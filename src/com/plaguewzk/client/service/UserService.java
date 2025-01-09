package com.plaguewzk.client.service;

import com.plaguewzk.common.Message;
import com.plaguewzk.common.MessageType;
import com.plaguewzk.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author PlagueWZK
 * description: UserService 用户相关
 * date: 2025/1/8 17:40
 */

public class UserService {
    private User user = new User();
    private Socket socket;

    public boolean checkUser(String name, String password) {
        user.setUserID(name);
        user.setPassword(password);
        boolean flag = false;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message msg = (Message) ois.readObject();
            if (msg.getMesType() == MessageType.MESSAGE_LOGIN_SUCCEED) {
                ConnectThread ct = new ConnectThread(socket);
                ct.start();
                ThreadManager.addThreadToMap(name,ct);
                flag = true;
            } else {
                System.out.println("用户名或密码错误");
                oos.close();
                ois.close();
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("服务器异常");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public void requireOnlineFriend() {
        //try {
            //ObjectOutputStream oos =
                    //new ObjectOutputStream(ThreadManager.getThreadFromMap(user.getUserID()).getSocket().getOutputStream());
            ThreadManager.sendMessage(user.getUserID(),new Message(MessageType.MESSAGE_GET_ONLINE_FRIEND));
        //} catch (IOException e) {
            //throw new RuntimeException(e);
        //}
    }
    public void logout() {
        //try {
            //ObjectOutputStream oos =
                    //new ObjectOutputStream(ThreadManager.getThreadFromMap(user.getUserID()).getSocket().getOutputStream());
            //oos.writeObject(new Message(MessageType.MESSAGE_CLIENT_EXIT));
            ThreadManager.sendMessage(user.getUserID(),new Message(MessageType.MESSAGE_CLIENT_EXIT));
            System.exit(0);
        //} catch (IOException e) {
            //throw new RuntimeException(e);
        //}
    }

    public User getUser() {
        return user;
    }

}
