package com.wear.bean.socketio.date.request;

import dc.pf2;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class AppUserVideoTypeBean implements pf2 {
    public String data = "";
    public String emFriend;
    public String type;

    public AppUserVideoTypeBean() {
    }

    @Override // dc.pf2
    public String getAction() {
        return "AppUserVideoTypeDTO";
    }

    public String toString() {
        return "AppUserVideoTypeBean{type='" + this.type + "', emFriend='" + this.emFriend + "', data='" + this.data + '\'' + MessageFormatter.DELIM_STOP;
    }

    public AppUserVideoTypeBean(String str, String str2) {
        this.type = str;
        this.emFriend = str2;
    }
}
