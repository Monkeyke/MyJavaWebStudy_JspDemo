package com.library.pojo;

import java.io.Serializable;

public class ResultBean implements Serializable {
    /**
     * 服务器端是否出现异常
     */
    private Boolean flag;
    /**
     * 服务器端处理请求之后要响应的数据
     */
    private Object data;
    /**
     * 服务器端的异常信息
     */
    private String errorMsg;

    public ResultBean() {
    }

    public ResultBean(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultBean(Object data, String errorMsg) {
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public ResultBean(Boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public ResultBean(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}