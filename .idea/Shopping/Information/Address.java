package Shopping.Information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Address {
    private int user_id;
    private int address_id;
    private String detail;
}