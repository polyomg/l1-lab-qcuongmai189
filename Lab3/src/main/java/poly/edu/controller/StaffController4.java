package poly.edu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.model.Staff3;

@Controller
public class StaffController4 {
	 @RequestMapping("/staff/list3")
	    public String list(Model model) {
	        List<Staff3> list = List.of(
	            Staff3.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
	            Staff3.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
	            Staff3.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
	            Staff3.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
	            Staff3.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
	            Staff3.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
	        );

	        model.addAttribute("list", list);
	        return "demo/list-controls"; // view file list-controls.html
	    }
	}

