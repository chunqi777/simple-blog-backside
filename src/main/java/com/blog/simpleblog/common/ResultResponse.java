package com.blog.simpleblog.common;

import com.blog.simpleblog.MyConfig.BaseErrorInfoInterface;
import com.blog.simpleblog.MyConfig.ExceptionEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应结果
     */
    private Object data;

    public ResultResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    /**
     * 成功
     *
     * @return
     */
    public static ResultResponse success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultResponse success(Object data) {
        ResultResponse rb = new ResultResponse();
        rb.setCode(ExceptionEnum.SUCCESS.getResultCode());
        rb.setMsg(ExceptionEnum.SUCCESS.getResultMsg());
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultResponse error(BaseErrorInfoInterface errorInfo) {
        ResultResponse rb = new ResultResponse();
        rb.setCode(errorInfo.getResultCode());
        rb.setMsg(errorInfo.getResultMsg());
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultResponse error(String code, String msg) {
        ResultResponse rb = new ResultResponse();
        rb.setCode(code);
        rb.setMsg(msg);
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultResponse error(String msg) {
        ResultResponse rb = new ResultResponse();
        rb.setCode("-1");
        rb.setMsg(msg);
        rb.setData(null);
        return rb;
    }
}
