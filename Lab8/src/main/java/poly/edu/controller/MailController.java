package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.edu.service.MailService;
import poly.edu.service.MailService.Mail;

import java.io.File;
import java.io.IOException;

@Controller
public class MailController {

    @Autowired
    MailService mailService;

    // 🔹 Hiển thị form gửi mail
    @GetMapping("/mail/form")
    public String showForm(Model model) {
        model.addAttribute("mail", new Mail());
        return "mail/form";
    }

    // 🔹 Gửi mail trực tiếp
    @PostMapping("/mail/send-direct")
    public String sendDirect(@ModelAttribute Mail mail,
                             @RequestParam("attachments") MultipartFile[] attachments,
                             Model model) {
        try {
            StringBuilder filenames = new StringBuilder();

            // Lưu file upload tạm thời
            for (MultipartFile file : attachments) {
                if (!file.isEmpty()) {
                    File savedFile = new File(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
                    file.transferTo(savedFile);
                    filenames.append(savedFile.getAbsolutePath()).append(";");
                }
            }

            mail.setFilenames(filenames.toString());
            mailService.send(mail);

            model.addAttribute("message", "✅ Mail đã được gửi trực tiếp!");
        } catch (Exception e) {
            model.addAttribute("message", "❌ Lỗi khi gửi mail: " + e.getMessage());
        }
        return "mail/form";
    }

    // 🔹 Xếp mail vào hàng đợi
    @PostMapping("/mail/send-queue")
    public String sendQueue(@ModelAttribute Mail mail,
                            @RequestParam("attachments") MultipartFile[] attachments,
                            Model model) {
        try {
            StringBuilder filenames = new StringBuilder();

            for (MultipartFile file : attachments) {
                if (!file.isEmpty()) {
                    File savedFile = new File(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
                    file.transferTo(savedFile);
                    filenames.append(savedFile.getAbsolutePath()).append(";");
                }
            }

            mail.setFilenames(filenames.toString());
            mailService.push(mail);

            model.addAttribute("message", "📬 Mail đã được xếp vào hàng đợi!");
        } catch (IOException e) {
            model.addAttribute("message", "❌ Lỗi khi xử lý file đính kèm: " + e.getMessage());
        }
        return "mail/form";
    }
}
