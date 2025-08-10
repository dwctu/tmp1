package com.wear.ui.discover.xremote.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.XRemoteAppUserBean;
import com.wear.ui.discover.xremote.adapter.XRemoteUserAdapter;
import dc.ah4;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: XRemoteUserAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J$\u0010\u001a\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/wear/ui/discover/xremote/adapter/XRemoteUserAdapter;", "Lcom/wear/adapter/BaseAdapter;", "Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "selectItemIndex", "", "list", "", "layoutId", "(Ljava/lang/Integer;Ljava/util/List;I)V", "getSelectItemIndex", "()I", "setSelectItemIndex", "(I)V", "onBindViewHolder", "", "holder", "Lcom/wear/adapter/BaseAdapter$ViewHolder;", "position", "payloads", "", "", "onOrientationChange", "orientation", "setItemViewPadding", "itemView", "Landroid/view/View;", "setValues", "t", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class XRemoteUserAdapter extends BaseAdapter<XRemoteAppUserBean.DataBean.ApplicationAccount> {
    public int j;

    public XRemoteUserAdapter(@Nullable Integer num, @Nullable List<XRemoteAppUserBean.DataBean.ApplicationAccount> list, int i) {
        super(list, i);
        this.j = num != null ? num.intValue() : 0;
    }

    public static final void F(XRemoteUserAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j = i;
        this$0.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull BaseAdapter.ViewHolder holder, int i, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(!payloads.isEmpty())) {
            super.onBindViewHolder(holder, i);
            return;
        }
        Object obj = payloads.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        D(view, iIntValue);
    }

    public final void C(int i) {
        int itemCount = getItemCount();
        for (int i2 = 0; i2 < itemCount; i2++) {
            notifyItemChanged(i2, Integer.valueOf(i));
        }
    }

    public final void D(View view, int i) {
        int i2 = i == 2 ? 42 : 63;
        view.setPadding(i2, i2, i2, i2);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void y(@Nullable BaseAdapter.ViewHolder viewHolder, @Nullable XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount, final int i) {
        if (viewHolder == null || applicationAccount == null) {
            return;
        }
        ((TextView) viewHolder.getView(R.id.tv_name)).setText(applicationAccount.getUsername());
        String accountType = applicationAccount.getAccountType();
        ((TextView) viewHolder.getView(R.id.tv_tag)).setText(Intrinsics.areEqual(accountType, "lovense_user_name") ? ah4.e(R.string.lovense_user_name) : Intrinsics.areEqual(accountType, "custom_name") ? ah4.e(R.string.custom_name) : "");
        ((ImageView) viewHolder.getView(R.id.iv_select)).setImageResource(this.j == i ? R.drawable.icon_xremote_authorized_select : R.drawable.icon_xremote_authorized_unselect);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dc.p23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteUserAdapter.F(this.a, i, view);
            }
        });
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        D(view, this.c.getResources().getConfiguration().orientation);
    }

    /* renamed from: z, reason: from getter */
    public final int getJ() {
        return this.j;
    }
}
