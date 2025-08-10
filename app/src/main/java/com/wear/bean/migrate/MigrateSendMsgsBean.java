package com.wear.bean.migrate;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class MigrateSendMsgsBean implements Serializable {
    private byte[] fileBytes;
    private String msgs;

    public MigrateSendMsgsBean(String str, byte[] bArr) {
        this.msgs = str;
        this.fileBytes = bArr;
    }

    public byte[] getFileBytes() {
        return this.fileBytes;
    }

    public String getMsgs() {
        return this.msgs;
    }

    public void setFileBytes(byte[] bArr) {
        this.fileBytes = bArr;
    }

    public void setMsgs(String str) {
        this.msgs = str;
    }
}
