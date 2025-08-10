package com.wear.bean.event;

import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UpdateToyStrengthEvent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/wear/bean/event/UpdateToyStrengthEvent;", "", "toy", "Lcom/wear/bean/Toy;", "(Lcom/wear/bean/Toy;)V", "getToy", "()Lcom/wear/bean/Toy;", "setToy", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UpdateToyStrengthEvent {

    @Nullable
    private Toy toy;

    public UpdateToyStrengthEvent(@Nullable Toy toy) {
        this.toy = toy;
    }

    public static /* synthetic */ UpdateToyStrengthEvent copy$default(UpdateToyStrengthEvent updateToyStrengthEvent, Toy toy, int i, Object obj) {
        if ((i & 1) != 0) {
            toy = updateToyStrengthEvent.toy;
        }
        return updateToyStrengthEvent.copy(toy);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Toy getToy() {
        return this.toy;
    }

    @NotNull
    public final UpdateToyStrengthEvent copy(@Nullable Toy toy) {
        return new UpdateToyStrengthEvent(toy);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UpdateToyStrengthEvent) && Intrinsics.areEqual(this.toy, ((UpdateToyStrengthEvent) other).toy);
    }

    @Nullable
    public final Toy getToy() {
        return this.toy;
    }

    public int hashCode() {
        Toy toy = this.toy;
        if (toy == null) {
            return 0;
        }
        return toy.hashCode();
    }

    public final void setToy(@Nullable Toy toy) {
        this.toy = toy;
    }

    @NotNull
    public String toString() {
        return "UpdateToyStrengthEvent(toy=" + this.toy + ')';
    }
}
