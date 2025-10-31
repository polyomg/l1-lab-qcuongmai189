package poly.edu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.model.Product;

@Controller
public class ProductController {

    private final List<Product> items = new ArrayList<>(
        Arrays.asList(
            new Product("A", 1.0),
            new Product("B", 12.0)
        )
    );

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);

        // product luôn là form mặc định
        model.addAttribute("product", p);
        model.addAttribute("items", items);
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("formInput") Product formInput, Model model) {
        // Lưu sản phẩm người dùng nhập
        items.add(new Product(formInput.getName(), formInput.getPrice()));

        // product vẫn là mặc định ban đầu
        Product defaultProduct = new Product("iPhone 30", 5000.0);
        model.addAttribute("product", defaultProduct);

        // savedProduct hiển thị riêng ở ?2
        model.addAttribute("savedProduct", formInput);
        model.addAttribute("items", items);
        return "product/form";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return items;
    }
}
