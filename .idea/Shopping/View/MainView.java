package Shopping.View;

import java.util.Scanner;

public class MainView {
    public static Scanner sc=new Scanner(System.in);
    public static void mainView() {
        System.out.println("*******欢迎来到购物系统*******");
        System.out.println("选择操作");
        System.out.println("1.登录:");
        //登录分为管理员登录和用户登录；
        System.out.println("2.注册:");
        //管理员注册和用户注册
        Controller.Main();
    }
}