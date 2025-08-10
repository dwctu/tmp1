package com.wear.bean;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class GcmBatchBean {
    private String body;
    private String isVer;
    private String messageType;
    private String midiaImg;
    private String toEmail;

    public GcmBatchBean(String str, String str2, String str3, String str4, String str5) {
        this.body = str;
        this.toEmail = str2;
        this.messageType = str3;
        this.isVer = str4;
        this.midiaImg = str5;
    }

    public String getBody() {
        return this.body;
    }

    public String getIsVer() {
        return this.isVer;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public String getMidiaImg() {
        return this.midiaImg;
    }

    public String getToEmail() {
        return this.toEmail;
    }

    public String toString() {
        return "GcmBatchBean{body='" + this.body + "', toEmail='" + this.toEmail + "', messageType='" + this.messageType + "', isVer='" + this.isVer + "', midiaImg='" + this.midiaImg + '\'' + MessageFormatter.DELIM_STOP;
    }
}
