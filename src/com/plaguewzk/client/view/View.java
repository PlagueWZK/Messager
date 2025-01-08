package com.plaguewzk.client.view;

import com.plaguewzk.client.utils.ScannerUtil;

/**
 * @author PlagueWZK
 * description: View
 * date: 2025/1/3 01:41
 */

public class View {
    private boolean loop = true;
    private String key = "";

    public static void main(String[] args) {
        new View().mainMenu();
    }

    private void mainMenu() {
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

                    }
                }
                case "9" -> {
                    loop = false;
                }
            }
        }

    }

    private void chatMenu() {
        while (loop) {
            System.out.println("-----------------聊天系统-----------------");
            System.out.println("\t\t1.显示用户");
            System.out.println("\t\t2.群送消息");
            System.out.println("\t\t3.私聊");
            System.out.println("\t\t4.发送文件");
            System.out.println("\t\t9.退出");
            
        }
    }

    private boolean loginMenu() {
        String userID;
        String password;

        System.out.println("-----------------登录系统-----------------");
        System.out.print("用户名:");
        userID = ScannerUtil.readString(10, null);
        System.out.println("密码:");
        password = ScannerUtil.readString(50, null);

        return true;
    }
}
