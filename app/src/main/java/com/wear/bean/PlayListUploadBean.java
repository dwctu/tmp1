package com.wear.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PlayListUploadBean {
    private long cdtTime;
    private String id;
    private long lastUpdTime;
    private List<String> myPatternPlayListItemEditVos = new ArrayList();
    private String name;
    private int sortId;

    public long getCdtTime() {
        return this.cdtTime;
    }

    public String getId() {
        return this.id;
    }

    public long getLastUpdTime() {
        return this.lastUpdTime;
    }

    public List<String> getMyPatternPlayListItemEditVos() {
        return this.myPatternPlayListItemEditVos;
    }

    public String getName() {
        return this.name;
    }

    public int getSortId() {
        return this.sortId;
    }

    public void setCdtTime(long j) {
        this.cdtTime = j;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLastUpdTime(long j) {
        this.lastUpdTime = j;
    }

    public void setMyPatternPlayListItemEditVos(List<String> list) {
        this.myPatternPlayListItemEditVos = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSortId(int i) {
        this.sortId = i;
    }
}
