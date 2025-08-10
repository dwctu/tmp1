package com.wear.bean.event;

import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyListItemChangeSettingEvent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/wear/bean/event/ToyListItemChangeSettingEvent;", "", "isTouchMoving", "", "toy", "Lcom/wear/bean/Toy;", "(ZLcom/wear/bean/Toy;)V", "()Z", "getToy", "()Lcom/wear/bean/Toy;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToyListItemChangeSettingEvent {
    private final boolean isTouchMoving;

    @Nullable
    private final Toy toy;

    public ToyListItemChangeSettingEvent(boolean z, @Nullable Toy toy) {
        this.isTouchMoving = z;
        this.toy = toy;
    }

    public static /* synthetic */ ToyListItemChangeSettingEvent copy$default(ToyListItemChangeSettingEvent toyListItemChangeSettingEvent, boolean z, Toy toy, int i, Object obj) {
        if ((i & 1) != 0) {
            z = toyListItemChangeSettingEvent.isTouchMoving;
        }
        if ((i & 2) != 0) {
            toy = toyListItemChangeSettingEvent.toy;
        }
        return toyListItemChangeSettingEvent.copy(z, toy);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsTouchMoving() {
        return this.isTouchMoving;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Toy getToy() {
        return this.toy;
    }

    @NotNull
    public final ToyListItemChangeSettingEvent copy(boolean isTouchMoving, @Nullable Toy toy) {
        return new ToyListItemChangeSettingEvent(isTouchMoving, toy);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyListItemChangeSettingEvent)) {
            return false;
        }
        ToyListItemChangeSettingEvent toyListItemChangeSettingEvent = (ToyListItemChangeSettingEvent) other;
        return this.isTouchMoving == toyListItemChangeSettingEvent.isTouchMoving && Intrinsics.areEqual(this.toy, toyListItemChangeSettingEvent.toy);
    }

    @Nullable
    public final Toy getToy() {
        return this.toy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.isTouchMoving;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Toy toy = this.toy;
        return i + (toy == null ? 0 : toy.hashCode());
    }

    public final boolean isTouchMoving() {
        return this.isTouchMoving;
    }

    @NotNull
    public String toString() {
        return "ToyListItemChangeSettingEvent(isTouchMoving=" + this.isTouchMoving + ", toy=" + this.toy + ')';
    }
}
