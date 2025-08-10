package com.wear.bean.event;

import com.wear.bean.Toy;
import dc.ek2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SolaceProFunctionChangeEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/wear/bean/event/SolaceProFunctionChangeEvent;", "", "toy", "Lcom/wear/bean/Toy;", "newMode", "Lcom/wear/main/toy/solacepro/SolaceProModel;", "(Lcom/wear/bean/Toy;Lcom/wear/main/toy/solacepro/SolaceProModel;)V", "getNewMode", "()Lcom/wear/main/toy/solacepro/SolaceProModel;", "getToy", "()Lcom/wear/bean/Toy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SolaceProFunctionChangeEvent {

    @NotNull
    private final ek2 newMode;

    @Nullable
    private final Toy toy;

    public SolaceProFunctionChangeEvent(@Nullable Toy toy, @NotNull ek2 newMode) {
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        this.toy = toy;
        this.newMode = newMode;
    }

    @NotNull
    public final ek2 getNewMode() {
        return this.newMode;
    }

    @Nullable
    public final Toy getToy() {
        return this.toy;
    }
}
