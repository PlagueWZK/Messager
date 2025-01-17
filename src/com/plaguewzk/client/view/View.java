package com.plaguewzk.client.view;

import com.plaguewzk.client.service.UserService;
import com.plaguewzk.client.utils.ScannerUtil;

/**
 * @author PlagueWZK
 * description: View
 * date: 2025/1/3 01:41
 */

public class View {
    private boolean loop = true;
    private String key = "";
    private UserService userService = new UserService();

    public void mainMenu() {
        while (loop) {
            System.out.println("-----------------通讯系统-----------------");
            System.out.println("\t\t1.登录");
            System.out.println("\t\t9.退出");

            key = ScannerUtil.readString(1, "");
            switch (key) {
                case "1" -> {
                    boolean flag = loginMenu();
                    if (flag) {
                        System.out.println("登录成功");
                        loop = false;
                        break;
                    }
                    System.out.println("登录失败");
                }
                case "9" -> {
                    loop = false;
                    System.exit(0);
                }
                case "" -> {
                }
                default -> {
                    System.out.println("输入有误!");
                }
            }
        }
        chatMenu();
    }

    private void chatMenu() {
        loop = true;
        while (loop) {
            System.out.println("-----------------聊天系统-----------------");
            System.out.println("\t\t1.显示用户");
            System.out.println("\t\t2.群送消息");
            System.out.println("\t\t3.私聊");
            System.out.println("\t\t4.发送文件");
            System.out.println("\t\t9.退出");
            key = ScannerUtil.readString(1, "");
            switch (key) {
                case "1" -> {
                    userService.requireOnlineFriend();
                }
                case "2" -> {

                }
                case "3" -> {

                }
                case "4" -> {

                }
                case "9" -> {
                    loop = false;
                    userService.logout();
                }
                default -> {
                    System.out.println("输入有误!");
                }
            }
        }
        System.exit(0);
    }

    private boolean loginMenu() {
        String userID;
        String password;

        System.out.println("-----------------登录系统-----------------");
        System.out.print("用户名:");
        userID = ScannerUtil.readString(10, "");
        System.out.print("密码:");
        password = ScannerUtil.readString(50, "");
        return userService.checkUser(userID, password);
    }
}
