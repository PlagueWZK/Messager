package com.plaguewzk.common;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author PlagueWZK
 * description: Message
 * date: 2025/1/3 01:18
 */

public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String sender;
    private String receiver;
    private String content;
    private String sendTime;
    private int mesType;

    public Message(int mesType) {
        this.mesType = mesType;
    }

    public int getMesType() {
        return mesType;
    }

    public void setMesType(int mesType) {
        this.mesType = mesType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
