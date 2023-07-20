package Shopping.Information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Admin {
    private int admin_id;
    private String admin_name;
    private String admin_password;
    private int admin_phone;
}
