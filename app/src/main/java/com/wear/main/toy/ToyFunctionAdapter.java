package com.wear.main.toy;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import dc.ah4;
import dc.th4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyFunctionAdapter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/wear/main/toy/ToyFunctionAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/main/toy/ToyFunctionAdapter$ToyFunctionSupportBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "ToyFunctionSupportBean", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ToyFunctionAdapter extends BaseQuickAdapter<ToyFunctionSupportBean, BaseViewHolder> {
    public ToyFunctionAdapter() {
        super(R.layout.item_toy_function_support, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull ToyFunctionSupportBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ((ImageView) holder.getView(R.id.iv_support_icon)).setImageDrawable(th4.d(holder.itemView.getContext(), item.getIcon()));
        ((TextView) holder.getView(R.id.tv_support_name)).setText(ah4.e(item.getName()));
        ((ImageView) holder.getView(R.id.iv_support_status)).setImageDrawable(th4.d(holder.itemView.getContext(), item.getIsSupport() ? R.drawable.icon_support_yes : R.drawable.icon_support_no));
    }

    /* compiled from: ToyFunctionAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/wear/main/toy/ToyFunctionAdapter$ToyFunctionSupportBean;", "", "icon", "", "name", "isSupport", "", "(IIZ)V", "getIcon", "()I", "setIcon", "(I)V", "()Z", "setSupport", "(Z)V", "getName", "setName", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.wear.main.toy.ToyFunctionAdapter$a, reason: from toString */
    public static final /* data */ class ToyFunctionSupportBean {

        /* renamed from: a, reason: from toString */
        public int icon;

        /* renamed from: b, reason: from toString */
        public int name;

        /* renamed from: c, reason: from toString */
        public boolean isSupport;

        public ToyFunctionSupportBean() {
            this(0, 0, false, 7, null);
        }

        public ToyFunctionSupportBean(int i, int i2, boolean z) {
            this.icon = i;
            this.name = i2;
            this.isSupport = z;
        }

        /* renamed from: a, reason: from getter */
        public final int getIcon() {
            return this.icon;
        }

        /* renamed from: b, reason: from getter */
        public final int getName() {
            return this.name;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsSupport() {
            return this.isSupport;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToyFunctionSupportBean)) {
                return false;
            }
            ToyFunctionSupportBean toyFunctionSupportBean = (ToyFunctionSupportBean) other;
            return this.icon == toyFunctionSupportBean.icon && this.name == toyFunctionSupportBean.name && this.isSupport == toyFunctionSupportBean.isSupport;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = ((this.icon * 31) + this.name) * 31;
            boolean z = this.isSupport;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return i + i2;
        }

        @NotNull
        public String toString() {
            return "ToyFunctionSupportBean(icon=" + this.icon + ", name=" + this.name + ", isSupport=" + this.isSupport + ')';
        }

        public /* synthetic */ ToyFunctionSupportBean(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
        }
    }
}
