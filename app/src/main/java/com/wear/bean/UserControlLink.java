package com.wear.bean;

/* loaded from: classes3.dex */
public class UserControlLink extends User {
    private String linkId;
    private String platform;

    public String getLinkId() {
        return this.linkId;
    }

    public String getPlatform() {
        return this.platform;
    }

    @Override // com.wear.bean.User, com.wear.bean.handlerbean.IPeopleInfo
    public String getUserJid() {
        return getId();
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }
}
