package com.wear.ui.me.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.lovense.wear.R;
import com.wear.bean.me.OnlineStatusUserBean;
import com.wear.databinding.ItemOnlineStatusUserSelectBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: OnlineStatusUserSelectAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/wear/ui/me/adapter/OnlineStatusUserSelectAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/me/OnlineStatusUserBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/wear/databinding/ItemOnlineStatusUserSelectBinding;", "datas", "", "(Ljava/util/List;)V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OnlineStatusUserSelectAdapter extends BaseQuickAdapter<OnlineStatusUserBean, BaseDataBindingHolder<ItemOnlineStatusUserSelectBinding>> {

    @NotNull
    public String z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusUserSelectAdapter(@NotNull List<OnlineStatusUserBean> datas) {
        super(R.layout.item_online_status_user_select, datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
        this.z = "";
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseDataBindingHolder<ItemOnlineStatusUserSelectBinding> holder, @NotNull OnlineStatusUserBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemOnlineStatusUserSelectBinding itemOnlineStatusUserSelectBinding = (ItemOnlineStatusUserSelectBinding) holder.getDataBinding();
        if (itemOnlineStatusUserSelectBinding != null) {
            itemOnlineStatusUserSelectBinding.b(this.z);
            itemOnlineStatusUserSelectBinding.c(item);
            itemOnlineStatusUserSelectBinding.executePendingBindings();
        }
    }

    public final void J0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.z = str;
    }
}
