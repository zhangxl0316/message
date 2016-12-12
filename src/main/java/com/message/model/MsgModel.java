package com.message.model;

import java.io.Serializable;
import java.util.Date;

public class MsgModel implements Serializable {
    private Long id;

    private Short msgType;

    private Long msgCode;

    private String msgName;

    private Short sendMode;

    private Short recipientType;

    private String msgContent;

    private Date optTime;

    private String optUser;

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

    public Long getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(Long msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName == null ? null : msgName.trim();
    }

    public Short getSendMode() {
        return sendMode;
    }

    public void setSendMode(Short sendMode) {
        this.sendMode = sendMode;
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

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser == null ? null : optUser.trim();
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}