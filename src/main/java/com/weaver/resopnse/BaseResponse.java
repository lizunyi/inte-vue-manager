package com.weaver.resopnse;

public class BaseResponse {
    private int code = 0;
    private String msg;
    private Object data;

    public static BaseResponse fail() {
        return new BaseResponse(-1, "系统异常");
    }

    public static BaseResponse fail(int code, String error) {
        return new BaseResponse(code, error);
    }

    public static BaseResponse fail(String error) {
        return new BaseResponse(-1, error);
    }


    public static BaseResponse success() {
        return new BaseResponse(0, "");
    }

    public static BaseResponse success(Object data) {
        return new BaseResponse(0, "", data);
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
