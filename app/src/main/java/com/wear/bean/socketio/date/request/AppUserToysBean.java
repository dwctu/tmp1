package com.wear.bean.socketio.date.request;

/* loaded from: classes3.dex */
public class AppUserToysBean extends DateBean {
    public String sponsor;
    public String toyJson;
    public Object toys;

    @Override // com.wear.bean.socketio.date.request.DateBean, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "AppUserToysDTO";
    }

    public String getSponsor() {
        return this.sponsor;
    }

    public String getToyJson() {
        return this.toyJson;
    }

    public Object getToys() {
        return this.toys;
    }

    public void setSponsor(String str) {
        this.sponsor = str;
    }

    public void setToyJson(String str) {
        this.toyJson = str;
    }

    public void setToys(Object obj) {
        this.toys = obj;
    }
}
