package Shopping.Login_Register;

import Shopping.DBUtil;
import Shopping.Information.Admin;
import Shopping.View.AdministratorView;
import Shopping.View.MainView;
import Shopping.View.UserView;

import java.sql.*;
import java.util.*;

public class Login {
    static Scanner sc = new Scanner(System.in);

    public static void choiceLogin() {
        System.out.println("请你选择登录用户");
        System.out.println("1.管理员");
        System.out.println("2.用户");
        System.out.println("----------------");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                administratorLoginView();
                break;
            case "2":
                userLogin();
                break;
            default: {
                System.out.println("未识别操作");
                choiceLogin();
                break;
            }
        }
    }

    /**
     * 管理员登录
     */
    public static void administratorLoginView() {//管理员登录视图
        //判断登录成功/显示管理员界面
        System.out.println("请输入管理员名称");
        String administratorName = sc.nextLine();
        System.out.println("请输入管理员密码");
        String password = sc.nextLine();
        String sql = "select * from admin";
        List<Admin> adminList = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            //判断管理员用户密码是否正确/并且跳转不同界面
            boolean isAdmin = false;
            while (rs.next()) {
                if (administratorName.equals(rs.getString("admin_name")) && password.equals(rs.getString("admin_password"))) {
                    isAdmin = true;
                    break;
                } else {
                    isAdmin = false;
                }
            }
            //登录成功，进入管理员界面
            if (isAdmin) {
                System.out.println("管理员" + administratorName + "登录成功！");
                AdministratorView.administratorOperate(rs.getInt("admin_id"));
            }
            //登录失败，重新选择操作
            else {
                System.out.println("账号或密码错误,请重新输入！");
                System.out.println();
                MainView.mainView();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 用户登录
     */
    public static void userLogin() {//用户登录
        System.out.println("请输入用户名称");
        String userName = sc.nextLine();
        System.out.println("请输入用户密码");
        String password = sc.nextLine();
        String sql = "select * from user";
        List<Admin> userList = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            //判断用户密码是否正确/跳转不同页面
            boolean isUser = false;
            while (rs.next()) {
                if (userName.equals(rs.getString("user_name")) && password.equals(rs.getString("user_password"))) {
                    isUser = true;
                    break;
                } else {
                    isUser = false;
                }
            }

            //登录成功，进入用户界面
            if (isUser) {
                int id = rs.getInt("user_id");
                System.out.println("用户" + userName + "登录成功！");
                UserView.userFeatureSelection(id);
            }
            //登录失败，重新选择操作
            else {
                System.out.println("账号或密码错误,请重新输入！");
                System.out.println();
                MainView.mainView();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}