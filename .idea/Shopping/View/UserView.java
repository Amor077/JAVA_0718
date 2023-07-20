package Shopping.View;

import Shopping.Information.Catalog;
import Shopping.Information.ShopCar;

import java.util.*;

public class UserView {
    /**
     * 用户登录成功后，可以进行的操作
     * 功能：浏览商城
     * 充值
     * 查看购物车
     */
    public static void userFeatureSelection(int uid) {
        Scanner sc = new Scanner(System.in);
        System.out.println("您可以进行的操作");
        System.out.println("----------------");
        System.out.println("1.浏览商城");
        System.out.println("2.查看个人购物车");
        System.out.println("----------------");
        System.out.println("3.返回上一步");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                Catalog.merchandiseDisplay();
                break;
            case "2": {
                ShopCar.display(uid);
                break;
            }
            default: {
                MainView.mainView();
                break;
            }
        }
    }
}
