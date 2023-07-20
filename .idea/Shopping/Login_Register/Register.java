package Shopping.Login_Register;

import Shopping.DBUtil;
import Shopping.View.MainView;

import java.util.*;
import java.sql.*;

public class Register {
    static Scanner sc = new Scanner(System.in);

    public static void choiceRegister() {
        System.out.println("用户注册");
        System.out.println("1.管理员");
        System.out.println("2.普通用户");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                //管理员注册
                administratorRegister();
                break;
            case "2":
                //用户注册
                userRegister();
                break;
            default: {
                System.out.println("未识别操作！");
                MainView.mainView();
            }

        }
    }

    public static void administratorRegister() {
        System.out.println("请输入管理员名称");
        String administratorName = sc.nextLine();
        //设置判断用户名不为空
        if (!(administratorName == null || administratorName.equals(""))) {
            System.out.println("请输入管理员密码");
            String administratorPassword = sc.nextLine();
            //设置判断密码不为空
            if (!(administratorPassword == null || administratorPassword.equals(""))) {
                System.out.println("请输入管理员手机号");
                String phone = sc.nextLine();
                //将输入的用户名密码存入对应的表中
                String sql = "insert into admin(admin_name,admin_password,admin_phone) value (?,?,?)";
                try (Connection c = DBUtil.getConnection();
                     PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setString(1, administratorName);
                    ps.setString(2, administratorPassword);
                    ps.setString(3, phone);
                    ps.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //若密码为空，重新注册
            else {
                System.out.println("密码不能为空");
                administratorRegister();
            }
        }
        //若管理员用户名为空，重新注册
        else {
            System.out.println("管理员名称不能为空");
            administratorRegister();
        }
        System.out.println("注册成功");
        System.out.println("返回上一步:1.yes||2.no");
        String choice = sc.nextLine();
        if ("yes".equals(choice) || "1".equals(choice)) {
            MainView.mainView();
        } else {
            return;
        }
    }

    public static void userRegister() {
        System.out.println("请输入用户名称");
        String userName = sc.nextLine();
        //判断用户名是否为空
        if (!(userName == null && userName.equals(""))) {
            System.out.println("请输入用户密码");
            String userPassword = sc.nextLine();
            //判断密码为空
            if (!(userPassword == null && userPassword.equals(""))) {
                System.out.println("请输入用户手机号");
                String phone = sc.nextLine();
                System.out.println("请设置您的默认地址");
                String address = sc.nextLine();
                //将输入的用户名密码存入对应的表中
                String sql = "insert into user(user_name,user_password,user_phone,user_address) value (?,?,?,?)";
                try (Connection c = DBUtil.getConnection();
                     PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setString(1, userName);
                    ps.setString(2, userPassword);
                    ps.setString(3, phone);
                    ps.setString(4, address);
                    ps.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //如果为空，重新注册
        else {
            System.out.println("用户名不能为空！");
            userRegister();
        }
        System.out.println("注册成功！");
        System.out.println("返回上一步:1.yes||2.no");
        String choice = sc.nextLine();
        if ("yes".equals(choice) || "1".equals(choice)) {
            MainView.mainView();
        } else {
            return;
        }
    }
}
