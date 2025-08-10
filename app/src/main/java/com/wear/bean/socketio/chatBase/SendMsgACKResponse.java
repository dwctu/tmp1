package com.wear.bean.socketio.chatBase;

/* loaded from: classes3.dex */
public class SendMsgACKResponse extends BaseChatResponseBean {
    private int ackCode;
    private long createTime;
    private String msgId;
    private String tips;
    private String tipsKey;

    public int getAckCode() {
        return this.ackCode;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getTips() {
        return this.tips;
    }

    public String getTipsKey() {
        return this.tipsKey;
    }

    public void setAckCode(int i) {
        this.ackCode = i;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public void setTipsKey(String str) {
        this.tipsKey = str;
    }
}
