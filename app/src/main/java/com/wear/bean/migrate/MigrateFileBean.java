package com.wear.bean.migrate;

import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class MigrateFileBean {
    private String localAbsolutePath;
    private String localAbsolutePathTemp;
    private MessageType messageType;

    public MigrateFileBean(String str, MessageType messageType) {
        this.localAbsolutePath = str;
        this.messageType = messageType;
    }

    public String getFileName() {
        int iLastIndexOf;
        if (!WearUtils.e1(this.localAbsolutePath) && (iLastIndexOf = this.localAbsolutePath.lastIndexOf("/")) >= 0) {
            "".substring(iLastIndexOf);
        }
        return "";
    }

    public String getLocalAbsolutePath() {
        return this.localAbsolutePath;
    }

    public String getLocalAbsolutePathTemp() {
        return this.localAbsolutePathTemp;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public void setLocalAbsolutePathTemp(String str) {
        this.localAbsolutePathTemp = str;
    }
}
