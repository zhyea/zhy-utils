package org.chobit.common.model;

/**
 * @author robin
 */

public class ResultWrapper<T> {
    /**
     * 状态码
     */
    private int code = 200;
    /**
     * 返回内容
     */
    private T content;
    /**
     * 请求错误信息
     */
    private String msg;
    /**
     * 请求是否成功
     */
    private boolean success = true;

    public ResultWrapper() {
    }

    public ResultWrapper(T content) {
        this.content = content;
    }

    public ResultWrapper(int code, T content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}