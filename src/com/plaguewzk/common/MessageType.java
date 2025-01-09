package com.plaguewzk.common;

/**
 * @author PlagueWZK
 * description: MessageType
 * date: 2025/1/3 01:28
 */

public interface MessageType {
    int MESSAGE_LOGIN_SUCCEED = 0;
    int MESSAGE_LOGIN_FAIL = 1;
    int MESSAGE_COMM_MES = 2;
    int MESSAGE_GET_ONLINE_FRIEND = 3;
    int MESSAGE_RET_ONLINE_FRIEND = 4;
    int MESSAGE_CLIENT_EXIT = 5;
    int MESSAGE_TO_ALL_MES = 6;
    int MESSAGE_FILE_MES = 7;
    int MESSAGE_RET_MES_FAIL = 8;
}
