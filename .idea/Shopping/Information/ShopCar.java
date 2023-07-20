package Shopping.Information;

import Shopping.View.UserView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import Shopping.DBUtil;

import java.util.*;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopCar {
    private int shop_carid;
    private int user_id;
    private int product_id;
    private double product_price;
    private int product_num;
    private double sum_price;

    public static void display(int uid) {
        String sql = "select * from shopcar where user_id = 1";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                int proId = rs.getInt("product_id");
                double proPrice = rs.getDouble("product_price");
                int proNum = rs.getInt("product_num");
                double sumPrice = rs.getDouble("sum_price");
                System.out.println("用户id：" + id + "/商品id：" + proId + "/商品价格：" + proPrice + "/购买数量: " + proNum + "/总价: " + sumPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("是否继续下一步操作");
        System.out.println("----------------");
        System.out.println("1.返回上个界面");
        System.out.println("2.退出");
        System.out.println("----------------");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                UserView.userFeatureSelection(uid);
                break;
            case "2":
                return;
            default:
                System.out.println("未识别操作！");
                break;
        }
    }
}

