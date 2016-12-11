package com.message.model;

import java.io.Serializable;

public class MsgModel implements Serializable {
    private Long id;

    private Short msgType;

    private Short msgMode;

    private Short recipientType;

    private String msgContent;

    private Short state;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getMsgType() {
        return msgType;
    }

    public void setMsgType(Short msgType) {
        this.msgType = msgType;
    }

    public Short getMsgMode() {
        return msgMode;
    }

    public void setMsgMode(Short msgMode) {
        this.msgMode = msgMode;
    }

    public Short getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(Short recipientType) {
        this.recipientType = recipientType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}