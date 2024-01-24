package com.blog.simpleblog.MyConfig;

public interface BaseErrorInfoInterface {
    /**
     * 错误码
     *
     * @return
     */
    String getResultCode();

    /**
     * 错误描述
     *
     * @return
     */
    String getResultMsg();
}
