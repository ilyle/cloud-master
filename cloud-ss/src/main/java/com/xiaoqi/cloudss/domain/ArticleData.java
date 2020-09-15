package com.xiaoqi.cloudss.domain;

public class ArticleData {

    private ArticlePage data;
    private int errorCode;
    private int errorMsg;

    public ArticlePage getData() {
        return data;
    }

    public void setData(ArticlePage data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(int errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ArticleData{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg=" + errorMsg +
                '}';
    }
}
