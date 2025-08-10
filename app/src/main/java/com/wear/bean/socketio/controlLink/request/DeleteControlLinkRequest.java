package com.wear.bean.socketio.controlLink.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class DeleteControlLinkRequest implements Serializable {

    @SerializedName("longTimeControlLinkId")
    private String longTimeControlLinkId;

    public DeleteControlLinkRequest(String str) {
        this.longTimeControlLinkId = str;
    }

    public String getLongTimeControlLinkId() {
        return this.longTimeControlLinkId;
    }

    public void setLongTimeControlLinkId(String str) {
        this.longTimeControlLinkId = str;
    }
}
