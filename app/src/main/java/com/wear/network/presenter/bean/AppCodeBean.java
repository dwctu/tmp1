package com.wear.network.presenter.bean;

import dc.nd3;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class AppCodeBean {
    private String appAccountCode;
    private String email;

    public AppCodeBean(String str, String str2) {
        this.appAccountCode = nd3.l(str);
        this.email = nd3.l(str2);
    }

    public String getAppAccountCode() {
        return nd3.a(this.appAccountCode);
    }

    public String getEmail() {
        return nd3.a(this.email);
    }

    public void setAppAccountCode(String str) {
        this.appAccountCode = nd3.l(str);
    }

    public void setEmail(String str) {
        this.email = nd3.l(str);
    }

    public String toString() {
        return "AppCodeBean{appAccountCode='" + this.appAccountCode + "', email='" + this.email + '\'' + MessageFormatter.DELIM_STOP + "{appAccountCode='" + getAppAccountCode() + "', email='" + getEmail() + '\'' + MessageFormatter.DELIM_STOP;
    }
}
