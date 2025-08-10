package com.wear.bean.socketio.controlLink.response;

import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: ControlPermissionResponse.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/wear/bean/socketio/controlLink/response/ControlPermissionResponse;", "Ljava/io/Serializable;", "()V", "creatorExistUntreatedLiveControlRequest", "", "getCreatorExistUntreatedLiveControlRequest", "()Z", "setCreatorExistUntreatedLiveControlRequest", "(Z)V", "creatorExistUntreatedSyncControlRequest", "getCreatorExistUntreatedSyncControlRequest", "setCreatorExistUntreatedSyncControlRequest", "creatorLastApplyLiveControlTime", "", "getCreatorLastApplyLiveControlTime", "()J", "setCreatorLastApplyLiveControlTime", "(J)V", "creatorLastApplySyncControlTime", "getCreatorLastApplySyncControlTime", "setCreatorLastApplySyncControlTime", "joinerHasLiveControlPermission", "getJoinerHasLiveControlPermission", "setJoinerHasLiveControlPermission", "joinerHasSyncControlPermission", "getJoinerHasSyncControlPermission", "setJoinerHasSyncControlPermission", "openControlPermission", "getOpenControlPermission", "setOpenControlPermission", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ControlPermissionResponse implements Serializable {
    private boolean creatorExistUntreatedLiveControlRequest;
    private boolean creatorExistUntreatedSyncControlRequest;
    private long creatorLastApplyLiveControlTime;
    private long creatorLastApplySyncControlTime;
    private boolean joinerHasLiveControlPermission;
    private boolean joinerHasSyncControlPermission;
    private boolean openControlPermission;

    public final boolean getCreatorExistUntreatedLiveControlRequest() {
        return this.creatorExistUntreatedLiveControlRequest;
    }

    public final boolean getCreatorExistUntreatedSyncControlRequest() {
        return this.creatorExistUntreatedSyncControlRequest;
    }

    public final long getCreatorLastApplyLiveControlTime() {
        return this.creatorLastApplyLiveControlTime;
    }

    public final long getCreatorLastApplySyncControlTime() {
        return this.creatorLastApplySyncControlTime;
    }

    public final boolean getJoinerHasLiveControlPermission() {
        return this.joinerHasLiveControlPermission;
    }

    public final boolean getJoinerHasSyncControlPermission() {
        return this.joinerHasSyncControlPermission;
    }

    public final boolean getOpenControlPermission() {
        return this.openControlPermission;
    }

    public final void setCreatorExistUntreatedLiveControlRequest(boolean z) {
        this.creatorExistUntreatedLiveControlRequest = z;
    }

    public final void setCreatorExistUntreatedSyncControlRequest(boolean z) {
        this.creatorExistUntreatedSyncControlRequest = z;
    }

    public final void setCreatorLastApplyLiveControlTime(long j) {
        this.creatorLastApplyLiveControlTime = j;
    }

    public final void setCreatorLastApplySyncControlTime(long j) {
        this.creatorLastApplySyncControlTime = j;
    }

    public final void setJoinerHasLiveControlPermission(boolean z) {
        this.joinerHasLiveControlPermission = z;
    }

    public final void setJoinerHasSyncControlPermission(boolean z) {
        this.joinerHasSyncControlPermission = z;
    }

    public final void setOpenControlPermission(boolean z) {
        this.openControlPermission = z;
    }
}
