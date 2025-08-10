package com.wear.bean.socketio.msg.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class FrozenAccountResponse implements Serializable {

    @SerializedName("deleteTimestamp")
    private long deleteTimestamp;

    @SerializedName("frozenTimestamp")
    private long frozenTimestamp;

    public long getDeleteTimestamp() {
        return this.deleteTimestamp;
    }

    public long getFrozenTimestamp() {
        return this.frozenTimestamp;
    }

    public void setDeleteTimestamp(long j) {
        this.deleteTimestamp = j;
    }

    public void setFrozenTimestamp(long j) {
        this.frozenTimestamp = j;
    }

    public String toString() {
        return "FrozenAccountResponse{frozenTimestamp=" + this.frozenTimestamp + ", deleteTimestamp=" + this.deleteTimestamp + MessageFormatter.DELIM_STOP;
    }
}
