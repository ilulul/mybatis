package com.lll.activity.Result;


@JsonResult
public class ResponseResult {
    private int success = 1;

    private Error error;

    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(ResponseCode resCode) {
        this.success = resCode.getStatus();
        this.error = new Error(resCode.getCode(),resCode.getCode());
    }

    public ResponseResult(ResponseCode resCode, Object data) {
        this.success = resCode.getStatus();
        this.error = new Error(resCode.getCode(), resCode.getMsg());
        this.data = data;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseResult [success=" + success + ", error=" + error + ", data=" + data + "]";
    }
}
