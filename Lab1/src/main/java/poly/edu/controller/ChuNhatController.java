package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ChuNhatController {
	
	// Hiển thị form nhập
    @GetMapping("/chunhat/form")
    public String form() {
        return "chunhat";
    }
    
    // Xử lý tính toán
    @PostMapping("/chunhat/tinh")
    public String calc(HttpServletRequest request, Model model) {
        double dai = Double.parseDouble(request.getParameter("dai"));
        double rong = Double.parseDouble(request.getParameter("rong"));

        double area = dai * rong;
        double perimeter = (dai + rong) * 2;

        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);

        return "chunhat";
    }
}
