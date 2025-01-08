package com.plaguewzk.common;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author PlagueWZK
 * description: User
 * date: 2025/1/3 01:15
 */

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String userID;
    private String password;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
