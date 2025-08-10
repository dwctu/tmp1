package com.wear.bean;

/* loaded from: classes3.dex */
public class FavoriteEmojisBean {
    private String created;
    private String fileDesc;
    private String fileMd5;
    private String id;
    private String path;
    private String type;
    private String updated;
    private boolean isLoaded = false;
    private boolean isChoose = false;

    public String getCreated() {
        return this.created;
    }

    public String getFileDesc() {
        return this.fileDesc;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public String getId() {
        return this.id;
    }

    public String getPath() {
        return this.path;
    }

    public String getType() {
        return this.type;
    }

    public String getUpdated() {
        return this.updated;
    }

    public boolean isChoose() {
        return this.isChoose;
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void setChoose(boolean z) {
        this.isChoose = z;
    }

    public void setCreated(String str) {
        this.created = str;
    }

    public void setFileDesc(String str) {
        this.fileDesc = str;
    }

    public void setFileMd5(String str) {
        this.fileMd5 = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLoaded(boolean z) {
        this.isLoaded = z;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdated(String str) {
        this.updated = str;
    }
}
