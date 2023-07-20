package Shopping.Information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int product_id;
    private String product_name;
    private double product_price;
    private int stock_num;
    private int sales_num;
    private int property_id;
    private int admin_id;
}