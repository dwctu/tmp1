package com.wear.bean;

import com.wear.protocol.EntityVMShareCard;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class VMShareDataBean implements Serializable {
    private String callbackAppName;
    private String callbackUrl;
    private String completeCallbackType;
    private String cover;
    private String desc;
    private String subTitle;
    private String title;
    private String url;

    public EntityVMShareCard VMShare() {
        EntityVMShareCard entityVMShareCard = new EntityVMShareCard();
        entityVMShareCard.setCallbackAppName(this.callbackAppName);
        entityVMShareCard.setDesc(this.desc);
        entityVMShareCard.setTitle(this.title);
        entityVMShareCard.setCover(this.cover);
        entityVMShareCard.setCompleteCallbackType(this.completeCallbackType);
        entityVMShareCard.setSubTitle(this.subTitle);
        entityVMShareCard.setCallbackUrl(this.callbackUrl);
        entityVMShareCard.setUrl(this.url);
        return entityVMShareCard;
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

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
