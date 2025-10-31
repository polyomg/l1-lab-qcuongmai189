package poly.edu.controller;

	import java.util.List;
	import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
	import org.springframework.data.domain.Sort.Direction;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	
	import poly.edu.dao.ProductDAO;
	import poly.edu.entity.Product;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        String sortField = field.orElse("price");
        Sort sort = Sort.by(Direction.DESC, sortField);

        List<Product> items = dao.findAll(sort);

        model.addAttribute("items", items);
        model.addAttribute("field", sortField.toUpperCase());

        return "product/sort";
    }
 // --- PHÂN TRANG ---
    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5); // mỗi trang 5 sp
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }
}

