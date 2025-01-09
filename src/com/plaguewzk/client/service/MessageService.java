package com.plaguewzk.client.service;

import com.plaguewzk.common.Message;
import com.plaguewzk.common.MessageType;

/**
 * @author PlagueWZK
 * description: MessageService 和消息相关的服务
 * date: 2025/1/9 16:49
 */

public class MessageService {
    public static void sendMessage(String content, String sender, String receiver) {
        Message message = new Message(content, sender, receiver);
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSendTime(new java.util.Date().toString());
        System.out.println("你对" + receiver + "说:" + content);
        ThreadManager.sendMessage(sender, message);
    }
}
