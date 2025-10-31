package poly.edu.entity;

import java.io.Serializable;

public interface Report {
    Serializable getGroup();  // nhóm (ở đây là loại hàng)
    Double getSum();          // tổng giá
    Long getCount();          // số lượng sản phẩm
}
