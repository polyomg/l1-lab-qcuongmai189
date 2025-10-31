package poly.edu.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Staff2 {
    private String id;
    private String fullname;
    private int level;
    private String photo;
    private double salary;
}