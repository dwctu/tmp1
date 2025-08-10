package com.wear.bean;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class UserGuidesMenuBean {
    private String cLink;
    private int menu;
    private String title;

    public UserGuidesMenuBean(String str, String str2, int i) {
        this.title = str;
        this.cLink = str2;
        this.menu = i;
    }

    public String getCLink() {
        return this.cLink;
    }

    public int getMenu() {
        return this.menu;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCLink(String str) {
        this.cLink = str;
    }

    public void setMenu(int i) {
        this.menu = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "UserGuidesMenuBean{title='" + this.title + "', cLink='" + this.cLink + "', menu=" + this.menu + MessageFormatter.DELIM_STOP;
    }
}
