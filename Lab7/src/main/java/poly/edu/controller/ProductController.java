package poly.edu.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;
import poly.edu.service.SessionService;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    @Autowired
    SessionService session;

    @RequestMapping("/product/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {

        // Lấy từ khóa từ request hoặc session
        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);

        // Tạo đối tượng Pageable
        Pageable pageable = PageRequest.of(p.orElse(0), 5);

        // Truy vấn theo từ khóa có phân trang
        Page<Product> page = dao.findAllByNameLike("%" + kwords + "%", pageable);

        // Truyền dữ liệu sang view
        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);

        return "product/search-and-page";
    }
}





