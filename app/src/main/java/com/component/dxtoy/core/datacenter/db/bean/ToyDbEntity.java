package com.component.dxtoy.core.datacenter.db.bean;

import androidx.room.Entity;
import com.component.dxdatabase.lib.base.bean.DbBaseEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyDbEntity.kt */
@Entity
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001c\u0010/\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001c\u00102\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR\u001a\u0010>\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"¨\u0006A"}, d2 = {"Lcom/component/dxtoy/core/datacenter/db/bean/ToyDbEntity;", "Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "()V", "defineRename", "", "getDefineRename", "()Ljava/lang/String;", "setDefineRename", "(Ljava/lang/String;)V", "deviceName", "getDeviceName", "setDeviceName", "deviceType", "getDeviceType", "setDeviceType", "formApp", "getFormApp", "setFormApp", "isLedOpen", "", "()Z", "setLedOpen", "(Z)V", "isSelect", "setSelect", "isUIInMyToyList", "setUIInMyToyList", "isVirtualToy", "setVirtualToy", "ledColor", "", "getLedColor", "()I", "setLedColor", "(I)V", "mac", "getMac", "setMac", "otherAppConnectState", "getOtherAppConnectState", "setOtherAppConnectState", "rmId", "getRmId", "setRmId", "showName", "getShowName", "setShowName", "symbol", "getSymbol", "setSymbol", "type", "getType", "setType", "updateTime", "", "getUpdateTime", "()J", "setUpdateTime", "(J)V", "uuid", "getUuid", "setUuid", "version", "getVersion", "setVersion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ToyDbEntity extends DbBaseEntity {

    @Nullable
    private String defineRename;

    @Nullable
    private String deviceName;

    @Nullable
    private String deviceType;

    @Nullable
    private String formApp;
    private boolean isSelect;
    private boolean isUIInMyToyList;
    private boolean isVirtualToy;

    @Nullable
    private String rmId;

    @Nullable
    private String showName;

    @Nullable
    private String symbol;

    @Nullable
    private String type;
    private long updateTime;

    @Nullable
    private String uuid;
    private int version;

    @NotNull
    private String mac = "";
    private boolean isLedOpen = true;
    private int ledColor = 7;
    private int otherAppConnectState = -1;

    @Nullable
    public final String getDefineRename() {
        return this.defineRename;
    }

    @Nullable
    public final String getDeviceName() {
        return this.deviceName;
    }

    @Nullable
    public final String getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public final String getFormApp() {
        return this.formApp;
    }

    public final int getLedColor() {
        return this.ledColor;
    }

    @NotNull
    public final String getMac() {
        return this.mac;
    }

    public final int getOtherAppConnectState() {
        return this.otherAppConnectState;
    }

    @Nullable
    public final String getRmId() {
        return this.rmId;
    }

    @Nullable
    public final String getShowName() {
        return this.showName;
    }

    @Nullable
    public final String getSymbol() {
        return this.symbol;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    @Nullable
    public final String getUuid() {
        return this.uuid;
    }

    public final int getVersion() {
        return this.version;
    }

    /* renamed from: isLedOpen, reason: from getter */
    public final boolean getIsLedOpen() {
        return this.isLedOpen;
    }

    /* renamed from: isSelect, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* renamed from: isUIInMyToyList, reason: from getter */
    public final boolean getIsUIInMyToyList() {
        return this.isUIInMyToyList;
    }

    /* renamed from: isVirtualToy, reason: from getter */
    public final boolean getIsVirtualToy() {
        return this.isVirtualToy;
    }

    public final void setDefineRename(@Nullable String str) {
        this.defineRename = str;
    }

    public final void setDeviceName(@Nullable String str) {
        this.deviceName = str;
    }

    public final void setDeviceType(@Nullable String str) {
        this.deviceType = str;
    }

    public final void setFormApp(@Nullable String str) {
        this.formApp = str;
    }

    public final void setLedColor(int i) {
        this.ledColor = i;
    }

    public final void setLedOpen(boolean z) {
        this.isLedOpen = z;
    }

    public final void setMac(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mac = str;
    }

    public final void setOtherAppConnectState(int i) {
        this.otherAppConnectState = i;
    }

    public final void setRmId(@Nullable String str) {
        this.rmId = str;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public final void setShowName(@Nullable String str) {
        this.showName = str;
    }

    public final void setSymbol(@Nullable String str) {
        this.symbol = str;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public final void setUIInMyToyList(boolean z) {
        this.isUIInMyToyList = z;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public final void setUuid(@Nullable String str) {
        this.uuid = str;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public final void setVirtualToy(boolean z) {
        this.isVirtualToy = z;
    }
}
