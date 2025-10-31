package poly.edu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.model.Product;

import java.util.Arrays;
import java.util.List;
@Controller
@RequestMapping("/product2") // 
public class ProductController2 {

    @GetMapping("/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);

        model.addAttribute("formProduct", p);
        
        // Dòng này để tránh null
        model.addAttribute("savedProduct", new Product());
        return "product2/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("savedProduct") Product p, Model model) {
        model.addAttribute("savedProduct", p);
        return "product2/form";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0)
        );
    }
}
