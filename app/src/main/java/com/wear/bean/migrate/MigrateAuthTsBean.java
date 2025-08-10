package com.wear.bean.migrate;

import java.util.List;

/* loaded from: classes3.dex */
public class MigrateAuthTsBean {
    private int appVersion;
    private String jid;
    private String platform;
    private List<String> tabFields;

    public MigrateAuthTsBean(String str, String str2, int i, List<String> list) {
        this.jid = str;
        this.platform = str2;
        this.appVersion = i;
        this.tabFields = list;
    }

    public int getAppVersion() {
        return this.appVersion;
    }

    public String getJid() {
        return this.jid;
    }

    public String getPlatform() {
        return this.platform;
    }

    public List<String> getTabFields() {
        return this.tabFields;
    }
}
