package com.example.angry.testreminder;

/**
 * Created by Angry on 6/5/2018.
 */

public class PojoClassTask {
    private String msg;
    private String time;

    public PojoClassTask(String msg, String time) {
        this.msg = msg;
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
