package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.handlerbean.IHandlerPattern;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_playlist_items")
/* loaded from: classes3.dex */
public class PlaylistItems extends BaseEntity implements IHandlerPattern {

    @DatabaseField
    private String email;

    @DatabaseField
    private long lastUpdTime;

    @DatabaseField
    private String patternId;

    @DatabaseField
    private String playlistId;

    @DatabaseField
    private int sortId;

    @DatabaseField
    private String status;
    private String syncFialMsg;
    private int syncStatus;

    @DatabaseField
    private String toyFeature;

    public PlaylistItems() {
        setId(WearUtils.E());
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public void del() {
        setStatus("removed");
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public String getBeanId() {
        return getId();
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public int getCSortId() {
        return getSortId();
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public long getCdtTime() {
        return getCreated() == null ? getLastUpdTime() : getCreated().getTime();
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public long getLastUpdTime() {
        return (this.lastUpdTime != 0 || getCreated() == null) ? this.lastUpdTime : getCreated().getTime();
    }

    public String getOldEmail() {
        return this.email;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getPlaylistId() {
        return this.playlistId;
    }

    public int getSortId() {
        return this.sortId;
    }

    public String getStatus() {
        return this.status;
    }

    public String getToyFeature() {
        return this.toyFeature;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean isDel() {
        return "removed".equals(this.status);
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean neverSync() {
        return false;
    }

    public void setEmail(String str) {
        this.email = nd3.p(str);
    }

    public void setLastUpdTime(long j) {
        this.lastUpdTime = j;
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setPlaylistId(String str) {
        this.playlistId = str;
    }

    public void setSortId(int i) {
        this.sortId = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSyncFialMsg(String str) {
        this.syncFialMsg = str;
    }

    public void setSyncStatus(int i) {
        this.syncStatus = i;
    }

    public void setToyFeature(String str) {
        this.toyFeature = str;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean syncSuc() {
        return this.syncStatus == 0;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean useless() {
        return false;
    }

    public PlaylistItems(String str) {
        setId(str);
    }
}
