package com.zjtcb.luoyan.github.event;

/**
 * Created by ly on 2016/6/15.
 */
public class EventMessage {
    public String msg;
    public int flag;
    private Object object;
    public EventMessage(String msg,int flag) {
        this.msg = msg;
        this.flag = flag;
    }

    public EventMessage (String msg,Object object){
        this.object = object;
        this.msg = msg;
    }

    public Object getObject(){
        return object;
    }
    public String getMsg() {
        return msg;
    }

    public int getFlag() {
        return flag;
    }
}
