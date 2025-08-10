package com.wear.ui.chat.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.wear.bean.chat.Message;
import dc.as2;
import dc.bs2;
import dc.ie3;
import dc.tr2;
import dc.ur2;
import dc.vr2;
import dc.yr2;
import dc.zr2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0014¨\u0006\u0011"}, d2 = {"Lcom/wear/ui/chat/adapter/ChatAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/wear/bean/chat/Message;", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "isSelectMode", "", "chatAdapterListener", "Lcom/wear/ui/chat/adapter/ChatAdapter$ChatAdapterListener;", "(Lcom/wear/util/EmojisUtils;ZLcom/wear/ui/chat/adapter/ChatAdapter$ChatAdapterListener;)V", "getItemType", "", "data", "", "position", "ChatAdapterListener", "ChatEmojisAnimation", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatAdapter extends BaseProviderMultiAdapter<Message> {

    /* compiled from: ChatAdapter.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/ui/chat/adapter/ChatAdapter$ChatAdapterListener;", "Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider$OnAudioPlayListener;", "Lcom/wear/ui/chat/adapter/ChatAdapter$ChatEmojisAnimation;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a extends vr2.b, b {
    }

    /* compiled from: ChatAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/chat/adapter/ChatAdapter$ChatEmojisAnimation;", "", "isPlayed", "", "message", "Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void N2(@NotNull Message message);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatAdapter(@NotNull ie3 emojisUtils, boolean z, @Nullable a aVar) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        I0(new bs2());
        I0(new yr2());
        I0(new as2(emojisUtils, z, aVar));
        I0(new zr2(emojisUtils, z, aVar));
        I0(new ur2(aVar));
        I0(new tr2(aVar));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int Q0(@NotNull List<? extends Message> data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Message.INSTANCE.getSupportType().contains(Integer.valueOf(data.get(i).getType()))) {
            return (data.get(i).getType() * 2) + data.get(i).getDirection();
        }
        return -1;
    }
}
