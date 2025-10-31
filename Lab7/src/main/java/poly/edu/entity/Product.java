package poly.edu.entity;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "products") // tên bảng đúng trong MySQL Workbench
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String image;
    private Double price;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    private Boolean available;

    @Column(name = "CategoryId")
    private String categoryId; // <--- CHỈNH LẠI Ở ĐÂY

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }

    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
}


