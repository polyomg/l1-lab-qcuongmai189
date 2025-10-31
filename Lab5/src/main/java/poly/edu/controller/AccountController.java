package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.service.CookieService;
import poly.edu.service.ParamService;
import poly.edu.service.SessionService;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    // ===========================
    // GET: Hiển thị form đăng nhập
    // ===========================
    @GetMapping("/account/login")
    public String login1() {
        return "/account/login"; // trỏ đến file login.html trong /templates/account/
    }

    // ===========================
    // POST: Xử lý đăng nhập
    // ===========================
    @PostMapping("/account/login")
    public String login2() {
        // Đọc tham số từ form
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        // Kiểm tra tài khoản
        if (un.equals("poly") && pw.equals("123")) {
            // ✅ Đăng nhập thành công
            sessionService.set("username", un);

            // Xử lý ghi nhớ tài khoản
            if (rm) {
                // Lưu cookie trong 10 ngày (10 ngày * 24h)
                cookieService.add("user", un, 24 * 10);
            } else {
                // Xóa cookie nếu không chọn "remember"
                cookieService.remove("user");
            }

            // Chuyển hướng sang trang chào mừng (hoặc homepage)
            return "redirect:/welcome";
        }

        // ❌ Đăng nhập sai → quay lại login
        return "/account/login";
    }
}

