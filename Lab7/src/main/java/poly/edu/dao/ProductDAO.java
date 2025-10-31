package poly.edu.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Product;
import poly.edu.entity.Report;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    // DSL method — không cần viết @Query
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("SELECT o.categoryId AS group, SUM(o.price) AS sum, COUNT(o) AS count "
         + "FROM Product o "
         + "GROUP BY o.categoryId "
         + "ORDER BY SUM(o.price) DESC")
    List<Report> getInventoryByCategory();
}
