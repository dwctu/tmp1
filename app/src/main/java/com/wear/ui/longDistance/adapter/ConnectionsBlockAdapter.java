package com.wear.ui.longDistance.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.lovense.wear.R;
import com.wear.adapter.base.BaseAutoDataBindingHolder;
import com.wear.bean.ConnectionBlockBean;
import com.wear.bean.ConnectionLetterBean;
import com.wear.databinding.ItemConnectionsBlockBinding;
import com.wear.databinding.ItemConnectionsLetterBinding;
import dc.tq;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConnectionsBlockAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001:\u0001\u000bB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/wear/ui/longDistance/adapter/ConnectionsBlockAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/wear/adapter/base/BaseAutoDataBindingHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionsBlockAdapter extends BaseMultiItemQuickAdapter<tq, BaseAutoDataBindingHolder<?>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionsBlockAdapter(@NotNull List<tq> data) {
        super(data);
        Intrinsics.checkNotNullParameter(data, "data");
        I0(0, R.layout.item_connections_letter);
        I0(1, R.layout.item_connections_block);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseAutoDataBindingHolder<?> holder, @NotNull tq item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0) {
            Object dataBinding = holder.getDataBinding();
            ItemConnectionsLetterBinding itemConnectionsLetterBinding = dataBinding instanceof ItemConnectionsLetterBinding ? (ItemConnectionsLetterBinding) dataBinding : null;
            if (itemConnectionsLetterBinding != null) {
                ConnectionLetterBean connectionLetterBean = item instanceof ConnectionLetterBean ? (ConnectionLetterBean) item : null;
                itemConnectionsLetterBinding.e(connectionLetterBean != null ? connectionLetterBean.getLetter() : null);
                itemConnectionsLetterBinding.executePendingBindings();
                return;
            }
            return;
        }
        if (itemViewType != 1) {
            return;
        }
        Object dataBinding2 = holder.getDataBinding();
        ItemConnectionsBlockBinding itemConnectionsBlockBinding = dataBinding2 instanceof ItemConnectionsBlockBinding ? (ItemConnectionsBlockBinding) dataBinding2 : null;
        if (itemConnectionsBlockBinding != null) {
            itemConnectionsBlockBinding.b(item instanceof ConnectionBlockBean ? (ConnectionBlockBean) item : null);
            itemConnectionsBlockBinding.executePendingBindings();
        }
    }
}
