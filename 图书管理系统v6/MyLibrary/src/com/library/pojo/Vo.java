package com.library.pojo;

import java.util.List;

public class Vo {
    private int code;
    private int count;
    private List<?> data;
    private String msg;

    public Vo() {
    }

    @Override
    public String toString() {
        return "Vo{" +
                "code=" + code +
                ", count=" + count +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Vo(int code, int count, List<?> data, String msg) {
        this.code = code;
        this.count = count;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
