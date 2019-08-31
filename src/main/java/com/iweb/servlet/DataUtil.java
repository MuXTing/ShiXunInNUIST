package com.iweb.servlet;

public class DataUtil {
    private  boolean result=false;//操作 是否成功
    private  String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isResult(){
        return  result;
    }

}
