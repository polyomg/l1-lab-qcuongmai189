package poly.edu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    private String id;
    private String fullname;

    @Default
    private String photo = "photo.jpg";

    @Default
    private Boolean gender = true; // true = Nam, false = Nữ

    @Default
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday = new Date();

    @Default
    private double salary = 12345.6789;

    @Default
    private Integer level = 0; // 0: Úy, 1: Tá, 2: Tướng
}
