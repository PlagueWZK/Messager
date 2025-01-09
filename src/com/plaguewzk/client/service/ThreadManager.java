package com.plaguewzk.client.service;

import com.plaguewzk.common.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * @author PlagueWZK
 * description: ThreadManager
 * date: 2025/1/8 18:03
 */

public class ThreadManager {
    private static final HashMap<String, ConnectThread> threadMap = new HashMap<>();


    public static void addThreadToMap(String userID, ConnectThread thread) {
        threadMap.put(userID, thread);
    }
    public static ConnectThread getThreadFromMap(String userID) {
        return threadMap.get(userID);
    }
    public static void sendMessage(String userID, Message message) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(threadMap.get(userID).getOs());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}