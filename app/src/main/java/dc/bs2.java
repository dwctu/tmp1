package dc;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UnSupportItemProvider.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/UnSupportItemProvider;", "Lcom/wear/ui/chat/adapter/provoder/BaseProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class bs2 extends wr2 {
    @Override // dc.lr
    public int g() {
        return -1;
    }

    @Override // dc.lr
    public int h() {
        return R.layout.item_chat_not_support;
    }

    @Override // dc.wr2
    /* renamed from: t */
    public void a(@NotNull BaseViewHolder helper, @NotNull Message item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        super.a(helper, item);
        helper.setText(R.id.tv_sync_message, R.string.chat_message_old_version_tip);
        BaseProviderMultiAdapter<Message> baseProviderMultiAdapterC = c();
        if (baseProviderMultiAdapterC != null) {
            pr2.a(helper, baseProviderMultiAdapterC);
        }
    }
}
