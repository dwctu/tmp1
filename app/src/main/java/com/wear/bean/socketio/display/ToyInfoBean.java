package com.wear.bean.socketio.display;

/* loaded from: classes3.dex */
public class ToyInfoBean {
    private String fVersion;
    private String id;
    private String name;
    private String nickName;
    private int status;
    private String toyType;
    private String version;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getStatus() {
        return this.status;
    }

    public String getToyType() {
        return this.toyType;
    }

    public String getVersion() {
        return this.version;
    }

    public String getfVersion() {
        return this.fVersion;
    }

    public boolean isConnect() {
        return this.status == 1;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setToyType(String str) {
        this.toyType = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setfVersion(String str) {
        this.fVersion = str;
    }
}
