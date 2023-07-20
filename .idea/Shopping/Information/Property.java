package Shopping.Information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Property {
    private int property_id;
    private String property_name;
    private String property_describe;
}

