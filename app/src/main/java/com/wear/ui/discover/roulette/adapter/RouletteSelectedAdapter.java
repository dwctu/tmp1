package com.wear.ui.discover.roulette.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.wear.bean.RouletteItemSelectBean;
import com.wear.databinding.ItemRouletteSelectedBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: RouletteSelectedAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014¨\u0006\u000e"}, d2 = {"Lcom/wear/ui/discover/roulette/adapter/RouletteSelectedAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/RouletteItemSelectBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/wear/databinding/ItemRouletteSelectedBinding;", "layoutResId", "", "datas", "", "(ILjava/util/List;)V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteSelectedAdapter extends BaseQuickAdapter<RouletteItemSelectBean, BaseDataBindingHolder<ItemRouletteSelectedBinding>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouletteSelectedAdapter(int i, @NotNull List<RouletteItemSelectBean> datas) {
        super(i, datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseDataBindingHolder<ItemRouletteSelectedBinding> holder, @NotNull RouletteItemSelectBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemRouletteSelectedBinding itemRouletteSelectedBinding = (ItemRouletteSelectedBinding) holder.getDataBinding();
        if (itemRouletteSelectedBinding != null) {
            itemRouletteSelectedBinding.e(item);
            itemRouletteSelectedBinding.executePendingBindings();
        }
    }
}
