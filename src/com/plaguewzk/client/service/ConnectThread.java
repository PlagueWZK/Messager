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
    private Socket socket;
    private OutputStream os;
    private InputStream is;

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
                }

            }
            catch (IOException e) {
                close();
                break;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void close() {
        try {
            os.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public OutputStream getOs() {
        return os;
    }

    public InputStream getIs() {
        return is;
    }
}
