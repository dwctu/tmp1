package com.wear.bean.event;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlLinkPermissionEvent.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/wear/bean/event/ControlLinkPermissionEvent;", "", TypedValues.Custom.S_BOOLEAN, "", "(Z)V", "getBoolean", "()Z", "setBoolean", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ControlLinkPermissionEvent {
    private boolean boolean;

    public ControlLinkPermissionEvent(boolean z) {
        this.boolean = z;
    }

    public static /* synthetic */ ControlLinkPermissionEvent copy$default(ControlLinkPermissionEvent controlLinkPermissionEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = controlLinkPermissionEvent.boolean;
        }
        return controlLinkPermissionEvent.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getBoolean() {
        return this.boolean;
    }

    @NotNull
    public final ControlLinkPermissionEvent copy(boolean z) {
        return new ControlLinkPermissionEvent(z);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ControlLinkPermissionEvent) && this.boolean == ((ControlLinkPermissionEvent) other).boolean;
    }

    public final boolean getBoolean() {
        return this.boolean;
    }

    public int hashCode() {
        boolean z = this.boolean;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final void setBoolean(boolean z) {
        this.boolean = z;
    }

    @NotNull
    public String toString() {
        return "ControlLinkPermissionEvent(boolean=" + this.boolean + ')';
    }
}
