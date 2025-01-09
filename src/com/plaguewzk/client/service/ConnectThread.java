package com.plaguewzk.client.service;

import com.plaguewzk.common.Message;
import com.plaguewzk.common.MessageType;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author PlagueWZK
 * description: ConnectThread
 * date: 2025/1/8 17:50
 */

public class ConnectThread extends Thread {
    private final Socket socket;
    private final OutputStream os;
    private final InputStream is;

    public ConnectThread(Socket socket) {
        this.socket = socket;
        try {
            os = socket.getOutputStream();
            is = socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(is);
                Message msg = (Message) ois.readObject();
                switch (msg.getMesType()) {
                    case MessageType.MESSAGE_RET_ONLINE_FRIEND -> {
                        if (msg.getContent() == null) {
                            System.out.println("当前无在线用户");
                            continue;
                        }
                        String[] onlineUsers = msg.getContent().split(" ");
                        System.out.println("-----------------在线用户-----------------");
                        for (String i : onlineUsers) {
                            System.out.println(i);
                        }
                        System.out.println("-----------------------------------------");
                    }
                    case MessageType.MESSAGE_COMM_MES -> {
                        System.out.println(msg.getSender() + "对你说:" + msg.getContent());
                    }
                    case MessageType.MESSAGE_RET_MES_FAIL -> {
                        System.out.println(msg.getContent());
                    }
                }

            }
            catch (IOException e) {
                close();
                break;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.err.println("未知异常");
                close();
                break;
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void close() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("关闭资源时发生异常");
            System.out.println(e.getMessage());
        }
    }

    public OutputStream getOs() {
        return os;
    }

    public InputStream getIs() {
        return is;
    }
}
