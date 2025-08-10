package com.wear.bean;

import android.text.TextUtils;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class PatternUploadBean {
    private long cdt;
    private String creater;
    private String email;
    private String friendEmail;
    private String isAnony;
    private long lastUpdTime;
    private String name;
    private int orderDis;
    private String owner;
    private String path;
    private String patternId;
    private String patternMode;
    private boolean selfMark;
    private boolean shared;
    private String status;
    private boolean sync;
    private String text;
    private String timer;
    private String toyFeature;
    private String toyName;
    private String toySymbol;
    private String toyTag;
    private String toyVersion;
    private String type;

    public void del() {
        this.status = "removed";
    }

    public long getCdt() {
        return this.cdt;
    }

    public String getCreater() {
        return this.creater;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFriendEmail() {
        return this.friendEmail;
    }

    public String getIsAnony() {
        return this.isAnony;
    }

    public long getLastUpdTime() {
        return this.lastUpdTime;
    }

    public String getName() {
        return this.name;
    }

    public int getOrderDis() {
        return this.orderDis;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getPath() {
        return this.path;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getPatternMode() {
        return this.patternMode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getText() {
        return this.text;
    }

    public String getTimer() {
        return this.timer;
    }

    public String getToyFeature() {
        return this.toyFeature;
    }

    public String getToyName() {
        return this.toyName;
    }

    public String getToySymbol() {
        return this.toySymbol;
    }

    public String getToyTag() {
        return this.toyTag;
    }

    public String getToyVersion() {
        return this.toyVersion;
    }

    public String getType() {
        return this.type;
    }

    public boolean isAnony() {
        return TextUtils.isEmpty(this.isAnony) || "1".equals(this.isAnony) || "true".equals(this.isAnony);
    }

    public boolean isDel() {
        return "removed".equals(this.status);
    }

    public boolean isDownload() {
        return !WearUtils.e1(this.status) && this.status.equals(Pattern.DOWNLOAD);
    }

    public boolean isSelfMark() {
        return this.selfMark;
    }

    public boolean isShared() {
        return this.shared;
    }

    public boolean isSync() {
        return this.sync;
    }

    public void setCdt(long j) {
        this.cdt = j;
    }

    public void setCreater(String str) {
        this.creater = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFriendEmail(String str) {
        this.friendEmail = str;
    }

    public void setIsAnony(String str) {
        this.isAnony = str;
    }

    public void setLastUpdTime(long j) {
        this.lastUpdTime = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrderDis(int i) {
        this.orderDis = i;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setPatternMode(String str) {
        this.patternMode = str;
    }

    public void setSelfMark(boolean z) {
        this.selfMark = z;
    }

    public void setShared(boolean z) {
        this.shared = z;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSync(boolean z) {
        this.sync = z;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTimer(String str) {
        this.timer = str;
    }

    public void setToyFeature(String str) {
        this.toyFeature = str;
    }

    public void setToyName(String str) {
        this.toyName = str;
    }

    public void setToySymbol(String str) {
        this.toySymbol = str;
    }

    public void setToyTag(String str) {
        this.toyTag = str;
    }

    public void setToyVersion(String str) {
        this.toyVersion = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
