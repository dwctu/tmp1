package com.wear.ui.longDistance.viewmodel;

import androidx.lifecycle.ViewModel;
import com.wear.bean.event.BlockFinishEvent;
import com.wear.bean.event.FriendsRequestEvent;
import dc.da3;
import dc.g44;
import dc.o44;
import dc.q44;
import dc.q93;
import java.util.ArrayList;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConnectionsBlockViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011H\u0007J\b\u0010\u0012\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/longDistance/viewmodel/ConnectionsBlockViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_connectionsBlockIntentFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/wear/ui/longDistance/intent/ConnectionsBlockIntent;", "connectionsBlockIntentFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getConnectionsBlockIntentFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "connectionsBlockRepository", "Lcom/wear/ui/longDistance/repository/ConnectionsBlockRepository;", "onCleared", "", "onMessageEvent", "event", "Lcom/wear/bean/event/BlockFinishEvent;", "Lcom/wear/bean/event/FriendsRequestEvent;", "refreshBlockList", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionsBlockViewModel extends ViewModel {

    @NotNull
    public final da3 a = new da3();

    @NotNull
    public final g44<q93> b;

    @NotNull
    public final o44<q93> c;

    public ConnectionsBlockViewModel() {
        g44<q93> g44VarA = q44.a(new q93.a(new ArrayList()));
        this.b = g44VarA;
        this.c = g44VarA;
        EventBus.getDefault().register(this);
        b();
    }

    @NotNull
    public final o44<q93> a() {
        return this.c;
    }

    public final void b() {
        this.b.setValue(new q93.a(this.a.b()));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable FriendsRequestEvent event) {
        b();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@Nullable BlockFinishEvent event) {
        b();
    }
}
