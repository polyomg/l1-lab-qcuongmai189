package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private HttpServletRequest request;

    // Hiển thị form login
    @GetMapping("/login/form")
    public String form() {
        return "login";
    }

    // Xử lý login
    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Sai username hoặc password!");
        }

        return "login"; 
    }
}
