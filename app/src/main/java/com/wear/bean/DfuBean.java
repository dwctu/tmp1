package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class DfuBean implements Serializable {
    private boolean hasUpdate;
    private boolean isLanApiUpdate;
    private String md5;
    private String url;
    private int version;

    public String getMd5() {
        return this.md5;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isHasUpdate() {
        return this.hasUpdate;
    }

    public boolean isLanApiUpdate() {
        return this.isLanApiUpdate;
    }

    public void setHasUpdate(boolean z) {
        this.hasUpdate = z;
    }

    public void setLanApiUpdate(boolean z) {
        this.isLanApiUpdate = z;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
