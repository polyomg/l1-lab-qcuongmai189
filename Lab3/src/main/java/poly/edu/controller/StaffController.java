package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.model.Staff;

@Controller
public class StaffController {

    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .photo("user.png")
                .gender(true)
                .salary(98765.4321)
                .level(2)
                .build();

        model.addAttribute("staff", staff);
        return "/demo/staff-detail"; // tương ứng với templates/demo/staff-detail.html
    }
}
