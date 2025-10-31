package poly.edu.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import poly.edu.service.MailService;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    // ✅ Hàng đợi lưu mail tạm thời
    List<Mail> queue = new ArrayList<>();

    @Override
    public void push(Mail mail) {
        queue.add(mail);
    }

    @Override
    public void send(Mail mail) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            helper.setFrom(mail.getFrom());
            helper.setReplyTo(mail.getFrom());
            helper.setTo(mail.getTo());

            if (!isNullOrEmpty(mail.getCc())) {
                helper.setCc(mail.getCc());
            }
            if (!isNullOrEmpty(mail.getBcc())) {
                helper.setBcc(mail.getBcc());
            }

            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);

            String filenames = mail.getFilenames();
            if (!isNullOrEmpty(filenames)) {
                for (String filename : filenames.split("[,;]+")) {
                    File file = new File(filename.trim());
                    if (file.exists()) {
                        helper.addAttachment(file.getName(), file);
                    }
                }
            }

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ✅ Chạy nền: mỗi 500ms lấy mail từ hàng đợi để gửi
    @Scheduled(fixedDelay = 500)
    public void run() {
        while (!queue.isEmpty()) {
            try {
                Mail mail = queue.remove(0);
                System.out.println("📨 Đang gửi mail đến: " + mail.getTo());
                this.send(mail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isNullOrEmpty(String text) {
        return (text == null || text.trim().isEmpty());
    }
}
