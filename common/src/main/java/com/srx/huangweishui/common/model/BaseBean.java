package com.srx.huangweishui.common.model;



/**
 * Created by huangweishui on 2018/8/21.
 */

public class BaseBean {
    private String userName;
    public BaseBean(String userName){
        this.userName=userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
