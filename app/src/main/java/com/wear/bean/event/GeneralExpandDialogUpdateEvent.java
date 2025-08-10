package com.wear.bean.event;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GeneralExpandDialogUpdateEvent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/wear/bean/event/GeneralExpandDialogUpdateEvent;", "", "name", "", TypedValues.TransitionType.S_DURATION, "", "status", "", "position", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPosition", "setPosition", "getStatus", "()Ljava/lang/Boolean;", "setStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/wear/bean/event/GeneralExpandDialogUpdateEvent;", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GeneralExpandDialogUpdateEvent {

    @Nullable
    private Long duration;

    @Nullable
    private String name;

    @Nullable
    private Long position;

    @Nullable
    private Boolean status;

    public GeneralExpandDialogUpdateEvent(@Nullable String str, @Nullable Long l, @Nullable Boolean bool, @Nullable Long l2) {
        this.name = str;
        this.duration = l;
        this.status = bool;
        this.position = l2;
    }

    public static /* synthetic */ GeneralExpandDialogUpdateEvent copy$default(GeneralExpandDialogUpdateEvent generalExpandDialogUpdateEvent, String str, Long l, Boolean bool, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = generalExpandDialogUpdateEvent.name;
        }
        if ((i & 2) != 0) {
            l = generalExpandDialogUpdateEvent.duration;
        }
        if ((i & 4) != 0) {
            bool = generalExpandDialogUpdateEvent.status;
        }
        if ((i & 8) != 0) {
            l2 = generalExpandDialogUpdateEvent.position;
        }
        return generalExpandDialogUpdateEvent.copy(str, l, bool, l2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getPosition() {
        return this.position;
    }

    @NotNull
    public final GeneralExpandDialogUpdateEvent copy(@Nullable String name, @Nullable Long duration, @Nullable Boolean status, @Nullable Long position) {
        return new GeneralExpandDialogUpdateEvent(name, duration, status, position);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GeneralExpandDialogUpdateEvent)) {
            return false;
        }
        GeneralExpandDialogUpdateEvent generalExpandDialogUpdateEvent = (GeneralExpandDialogUpdateEvent) other;
        return Intrinsics.areEqual(this.name, generalExpandDialogUpdateEvent.name) && Intrinsics.areEqual(this.duration, generalExpandDialogUpdateEvent.duration) && Intrinsics.areEqual(this.status, generalExpandDialogUpdateEvent.status) && Intrinsics.areEqual(this.position, generalExpandDialogUpdateEvent.position);
    }

    @Nullable
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Long getPosition() {
        return this.position;
    }

    @Nullable
    public final Boolean getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.duration;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.status;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l2 = this.position;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public final void setDuration(@Nullable Long l) {
        this.duration = l;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPosition(@Nullable Long l) {
        this.position = l;
    }

    public final void setStatus(@Nullable Boolean bool) {
        this.status = bool;
    }

    @NotNull
    public String toString() {
        return "GeneralExpandDialogUpdateEvent(name=" + this.name + ", duration=" + this.duration + ", status=" + this.status + ", position=" + this.position + ')';
    }
}
