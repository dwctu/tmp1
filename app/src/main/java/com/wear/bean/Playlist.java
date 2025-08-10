package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.handlerbean.IHandlerPattern;
import com.wear.util.WearUtils;
import dc.nd3;
import java.util.List;

@DatabaseTable(tableName = "tb_playlist")
/* loaded from: classes3.dex */
public class Playlist extends BaseEntity implements IHandlerPattern {

    @DatabaseField
    private String email;

    @DatabaseField
    private long lastUpdTime;
    private List<PlaylistItems> myPatternPlayListItems;

    @DatabaseField
    private String name;

    @DatabaseField
    private int sortId;

    @DatabaseField
    private String status;
    private String syncFialMsg;
    private int syncStatus;

    public Playlist() {
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

    public List<PlaylistItems> getMyPatternPlayListItems() {
        return this.myPatternPlayListItems;
    }

    public String getName() {
        return this.name;
    }

    public String getOldEmail() {
        return this.email;
    }

    public int getSortId() {
        return this.sortId;
    }

    public String getStatus() {
        return this.status;
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

    public void setMyPatternPlayListItems(List<PlaylistItems> list) {
        this.myPatternPlayListItems = list;
    }

    public void setName(String str) {
        this.name = str;
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

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean syncSuc() {
        return this.syncStatus == 0;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean useless() {
        return false;
    }

    public Playlist(String str) {
        setId(str);
    }
}
