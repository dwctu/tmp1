package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityVMShareCard extends DataEntityAbstract {
    private String callbackAppName;
    private String callbackUrl;
    private String completeCallbackType;
    private String cover;
    private String desc;
    private String msgId;
    private String subTitle;
    private String title;
    private String url;

    public EntityVMShareCard() {
        setMsgId(WearUtils.E());
    }

    public String getCallbackAppName() {
        return this.callbackAppName;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public String getCompleteCallbackType() {
        return this.completeCallbackType;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.vmsharecard;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCallbackAppName(String str) {
        this.callbackAppName = str;
    }

    public void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public void setCompleteCallbackType(String str) {
        this.completeCallbackType = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public EntityVMShareCard(String str) {
        EntityVMShareCard entityVMShareCard = (EntityVMShareCard) fromJsonToDecrypt(str, EntityVMShareCard.class);
        this.url = entityVMShareCard.getUrl();
        this.title = entityVMShareCard.getTitle();
        this.subTitle = entityVMShareCard.getSubTitle();
        this.desc = entityVMShareCard.getDesc();
        this.cover = entityVMShareCard.getCover();
        this.callbackUrl = entityVMShareCard.getCallbackUrl();
        this.completeCallbackType = entityVMShareCard.getCompleteCallbackType();
        this.callbackAppName = entityVMShareCard.getCallbackAppName();
        this.msgId = entityVMShareCard.getMsgId();
    }
}
