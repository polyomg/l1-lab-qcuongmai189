package poly.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "poly.edu.controller",
    "poly.edu.dao",
    "poly.edu.entity",
    "poly.edu.service"   // 🔥 Thêm dòng này!
})
public class Ps43811Lab7Application {
    public static void main(String[] args) {
        SpringApplication.run(Ps43811Lab7Application.class, args);
    }
}
