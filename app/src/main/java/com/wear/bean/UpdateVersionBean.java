package com.wear.bean;

/* loaded from: classes3.dex */
public class UpdateVersionBean {
    private String apkUrl;
    private String changes;
    private boolean force;
    private boolean hasUpdate;
    private String url;
    private String version;

    public String getApkUrl() {
        return this.apkUrl;
    }

    public String getChanges() {
        return this.changes;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isHasUpdate() {
        return this.hasUpdate;
    }

    public void setApkUrl(String str) {
        this.apkUrl = str;
    }

    public void setChanges(String str) {
        this.changes = str;
    }

    public void setForce(boolean z) {
        this.force = z;
    }

    public void setHasUpdate(boolean z) {
        this.hasUpdate = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
