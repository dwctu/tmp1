package com.wear.ui.longDistance.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.lovense.wear.R;
import com.wear.adapter.base.BaseAutoDataBindingHolder;
import com.wear.bean.ConnectionGroupBean;
import com.wear.bean.ConnectionLetterBean;
import com.wear.bean.ConnectionUserBean;
import com.wear.databinding.ItemConnectionsGroupBinding;
import com.wear.databinding.ItemConnectionsLetterBinding;
import com.wear.databinding.ItemConnectionsUserBinding;
import dc.tq;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConnectionsAdapter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001:\u0001\u000eB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0014\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000f"}, d2 = {"Lcom/wear/ui/longDistance/adapter/ConnectionsAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/wear/adapter/base/BaseAutoDataBindingHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "createBaseViewHolder", "view", "Landroid/view/View;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionsAdapter extends BaseMultiItemQuickAdapter<tq, BaseAutoDataBindingHolder<?>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionsAdapter(@NotNull List<tq> data) {
        super(data);
        Intrinsics.checkNotNullParameter(data, "data");
        I0(0, R.layout.item_connections_letter);
        I0(1, R.layout.item_connections_user);
        I0(2, R.layout.item_connections_group);
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
        if (itemViewType == 1) {
            Object dataBinding2 = holder.getDataBinding();
            ItemConnectionsUserBinding itemConnectionsUserBinding = dataBinding2 instanceof ItemConnectionsUserBinding ? (ItemConnectionsUserBinding) dataBinding2 : null;
            if (itemConnectionsUserBinding != null) {
                itemConnectionsUserBinding.b(item instanceof ConnectionUserBean ? (ConnectionUserBean) item : null);
                itemConnectionsUserBinding.executePendingBindings();
                return;
            }
            return;
        }
        if (itemViewType != 2) {
            return;
        }
        Object dataBinding3 = holder.getDataBinding();
        ItemConnectionsGroupBinding itemConnectionsGroupBinding = dataBinding3 instanceof ItemConnectionsGroupBinding ? (ItemConnectionsGroupBinding) dataBinding3 : null;
        if (itemConnectionsGroupBinding != null) {
            itemConnectionsGroupBinding.b(item instanceof ConnectionGroupBean ? (ConnectionGroupBean) item : null);
            itemConnectionsGroupBinding.executePendingBindings();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public BaseAutoDataBindingHolder<?> F(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (BaseAutoDataBindingHolder) super.F(view);
    }
}
