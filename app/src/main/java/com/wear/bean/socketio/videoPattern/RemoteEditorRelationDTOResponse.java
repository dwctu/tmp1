package com.wear.bean.socketio.videoPattern;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class RemoteEditorRelationDTOResponse implements Serializable {
    private String ackId;
    private boolean sync;

    public String getAckId() {
        return this.ackId;
    }

    public boolean isSync() {
        return this.sync;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setSync(boolean z) {
        this.sync = z;
    }
}
