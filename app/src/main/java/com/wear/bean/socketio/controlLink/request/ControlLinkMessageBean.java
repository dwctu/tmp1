package com.wear.bean.socketio.controlLink.request;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;
import com.wear.protocol.MessageType;

/* loaded from: classes3.dex */
public class ControlLinkMessageBean extends BaseAckRequestBean {
    private String ackId;
    private String dateImType;
    private String dateImTypeData;
    private String extJsonStr;
    private String msgData;
    private MessageType msgType;
    private int msgVer;
    private String toId;

    public ControlLinkMessageBean(String str, String str2, int i, MessageType messageType, String str3, String str4, String str5) {
        this.ackId = str;
        this.toId = str2;
        this.msgVer = i;
        this.msgType = messageType;
        this.msgData = str3;
        this.dateImTypeData = str4;
        this.dateImType = "control_link";
        this.extJsonStr = str5;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean
    public String getAckId() {
        return this.ackId;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "q_send_im_msg_ts";
    }

    public String getDateImType() {
        return this.dateImType;
    }

    public String getDateImTypeData() {
        return this.dateImTypeData;
    }

    public String getExtJsonStr() {
        return this.extJsonStr;
    }

    public String getMsgData() {
        return this.msgData;
    }

    public MessageType getMsgType() {
        return this.msgType;
    }

    public int getMsgVer() {
        return this.msgVer;
    }

    public String getToId() {
        return this.toId;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean
    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setDateImType(String str) {
        this.dateImType = str;
    }

    public void setDateImTypeData(String str) {
        this.dateImTypeData = str;
    }

    public void setExtJsonStr(String str) {
        this.extJsonStr = str;
    }

    public void setMsgData(String str) {
        this.msgData = str;
    }

    public void setMsgType(MessageType messageType) {
        this.msgType = messageType;
    }

    public void setMsgVer(int i) {
        this.msgVer = i;
    }

    public void setToId(String str) {
        this.toId = str;
    }

    public ControlLinkMessageBean() {
    }
}
