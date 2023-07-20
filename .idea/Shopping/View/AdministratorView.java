package Shopping.View;

import Shopping.Product.Select;
import Shopping.Product.Update;

import java.util.Scanner;


public class AdministratorView {
    /**
     * 管理员可以对商品操作
     * 对订单操作
     */
    public static void administratorOperate(int adminId){
        System.out.println("管理员可执行内容：");
        System.out.println("1.查看售货店铺：");
        System.out.println("2.修改商品信息：");
        System.out.println("3.修改订单信息：");
        System.out.println("退出");
        Scanner sc=new Scanner(System.in);
        String choice=sc.nextLine();
        switch (choice){
            case "1":
                Select.display(adminId);
                break;
            case "2":
                Update.productView(adminId);
                break;
            case "3":break;
            default:MainView.mainView();
        }
    }

}