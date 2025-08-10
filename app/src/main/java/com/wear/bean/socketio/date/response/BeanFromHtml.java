package com.wear.bean.socketio.date.response;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class BeanFromHtml {

    @SerializedName("datingId")
    private String id;
    private boolean owner;
    private String receiver;
    private String receiverName;
    private String sponsor;
    private String sponsorName;

    public String getId() {
        return this.id;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public String getSponsor() {
        return this.sponsor;
    }

    public String getSponsorName() {
        return this.sponsorName;
    }

    public boolean isOwner() {
        return this.owner;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setOwner(boolean z) {
        this.owner = z;
    }

    public void setReceiver(String str) {
        this.receiver = str;
    }

    public void setReceiverName(String str) {
        this.receiverName = str;
    }

    public void setSponsor(String str) {
        this.sponsor = str;
    }

    public void setSponsorName(String str) {
        this.sponsorName = str;
    }
}
