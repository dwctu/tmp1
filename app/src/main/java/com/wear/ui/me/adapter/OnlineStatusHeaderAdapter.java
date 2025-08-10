package com.wear.ui.me.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.lovense.wear.R;
import com.wear.bean.me.OnlineStatusHeadBean;
import com.wear.databinding.HeaderOnlineStatusBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: OnlineStatusHeaderAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/wear/ui/me/adapter/OnlineStatusHeaderAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/me/OnlineStatusHeadBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/wear/databinding/HeaderOnlineStatusBinding;", "datas", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OnlineStatusHeaderAdapter extends BaseQuickAdapter<OnlineStatusHeadBean, BaseDataBindingHolder<HeaderOnlineStatusBinding>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusHeaderAdapter(@NotNull List<OnlineStatusHeadBean> datas) {
        super(R.layout.header_online_status, datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseDataBindingHolder<HeaderOnlineStatusBinding> holder, @NotNull OnlineStatusHeadBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        HeaderOnlineStatusBinding headerOnlineStatusBinding = (HeaderOnlineStatusBinding) holder.getDataBinding();
        if (headerOnlineStatusBinding != null) {
            headerOnlineStatusBinding.b(item);
            headerOnlineStatusBinding.executePendingBindings();
        }
    }
}
