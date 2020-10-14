package com.lll.activity.Result;

/**
* @author:         tony
* @date:     2020/7/30 10:58
*/
public class Error {
    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public Error() {
    }

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Error [code=" + code + ", message=" + message + "]";
    }
}
