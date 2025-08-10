package com.wear.bean.chat;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityToy;
import dc.ht2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReceiveToyOrderDataEntityAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/wear/bean/chat/ReceiveToyOrderDataEntityAdapter;", "Lcom/wear/ui/chat/manager/MessageSignalingAction$ReceiveToyOrderHandler;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/bean/chat/ReceiveToyOrderDataEntityAdapter$ReceiveToyOrderDataEntityListener;", "(Lcom/wear/bean/chat/ReceiveToyOrderDataEntityAdapter$ReceiveToyOrderDataEntityListener;)V", "receiveToyOrder", "", "toyMessage", "Lcom/wear/bean/chat/SignalingToyMessage;", "ReceiveToyOrderDataEntityListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ReceiveToyOrderDataEntityAdapter implements ht2.b {

    @NotNull
    private final ReceiveToyOrderDataEntityListener listener;

    /* compiled from: ReceiveToyOrderDataEntityAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/bean/chat/ReceiveToyOrderDataEntityAdapter$ReceiveToyOrderDataEntityListener;", "", "receiveToyOrder", "", "entity", "Lcom/wear/protocol/DataEntityAbstract;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface ReceiveToyOrderDataEntityListener {
        void receiveToyOrder(@NotNull DataEntityAbstract entity);
    }

    public ReceiveToyOrderDataEntityAdapter(@NotNull ReceiveToyOrderDataEntityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // dc.ht2.b
    public void receiveToyOrder(@NotNull SignalingToyMessage toyMessage) {
        Intrinsics.checkNotNullParameter(toyMessage, "toyMessage");
        this.listener.receiveToyOrder(new EntityToy(toyMessage.getOrder()));
    }
}
