package Shopping.Information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_address;
    private int user_phone;
    private double money;
}
