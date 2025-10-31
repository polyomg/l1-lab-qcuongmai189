package poly.edu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.model.Staff3;

@Controller
public class StaffController3 {
    @RequestMapping("/staff/list2")
    public String list(Model model) {
        List<Staff3> list = List.of(
            Staff3.builder().id("user1@gmail.com").fullname("Nguyễn Văn User1").level(0).build(),
            Staff3.builder().id("user2@gmail.com").fullname("Nguyễn Văn User2").level(1).build(),
            Staff3.builder().id("user3@gmail.com").fullname("Nguyễn Văn User3").level(2).build(),
            Staff3.builder().id("user4@gmail.com").fullname("Nguyễn Văn User4").level(2).build(),
            Staff3.builder().id("user5@gmail.com").fullname("Nguyễn Văn User5").level(1).build(),
            Staff3.builder().id("user6@gmail.com").fullname("Nguyễn Văn User6").level(0).build()
        );

        model.addAttribute("list", list);
        return "demo/list-status"; // file list-status.html
    }
}

