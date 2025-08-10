package com.wear.bean.migrate;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class MigrateMsgsTcBean implements Serializable {
    private byte[] attachments;
    private int flag;
    private int index;
    private String messages;

    public MigrateMsgsTcBean(int i, String str, byte[] bArr) {
        this(i, str, bArr, 1);
    }

    public byte[] getAttachments() {
        return this.attachments;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getIndex() {
        return this.index;
    }

    public String getMessages() {
        return this.messages;
    }

    public MigrateMsgsTcBean(int i, String str, byte[] bArr, int i2) {
        this.index = i;
        this.messages = str;
        this.attachments = bArr;
        this.flag = i2;
    }
}
