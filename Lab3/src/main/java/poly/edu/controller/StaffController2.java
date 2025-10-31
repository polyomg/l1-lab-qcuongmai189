package poly.edu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.model.Staff2;



@Controller
public class StaffController2 {

    @RequestMapping("/staff/list")
    public String list(Model model) {
        List<Staff2> list = List.of(
                Staff2.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).photo("user.png").salary(12345.68).build(),
                Staff2.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).photo("user.png").salary(12345.68).build(),
                Staff2.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).photo("user.png").salary(12345.68).build(),
                Staff2.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).photo("user.png").salary(12345.68).build(),
                Staff2.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).photo("user.png").salary(12345.68).build(),
                Staff2.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).photo("user.png").salary(12345.68).build()
        );

        model.addAttribute("list", list);
        return "/demo/staff-list";
    }
}
