package Shopping.View;

import Shopping.Login_Register.Login;
import Shopping.Login_Register.Register;

import java.util.Scanner;


public class Controller {
    public static Scanner sc=new Scanner(System.in);
    public static void Main() {
        String string=sc.nextLine();
        switch (string) {
            //登录页面
            case "1":
                //登录
                Login.choiceLogin();
                break;
            case "2":
                //注册
                Register.choiceRegister();
                break;
            default:{
                System.out.println("未识别操作！");
                Main();
            }
        }
    }
}