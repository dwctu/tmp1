package com.wear.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.UIDemoColorBean;
import com.wear.util.MyApplication;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UIDemoColorAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/wear/adapter/UIDemoColorAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/UIDemoColorBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "datas", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoColorAdapter extends BaseQuickAdapter<UIDemoColorBean, BaseViewHolder> {

    @NotNull
    public final List<UIDemoColorBean> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIDemoColorAdapter(@NotNull List<UIDemoColorBean> datas) {
        super(R.layout.item_ui_demo_color, datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
        this.z = datas;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull UIDemoColorBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ((TextView) holder.getView(R.id.tv_name)).setText(item.getName());
        ((SkinRoundConstraintLayout) holder.getView(R.id.cl_color)).setBackgroundResource(item.getResIds());
        TextView textView = (TextView) holder.getView(R.id.tv_color_1);
        int i = MyApplication.m0;
        List<String> lightHexFormat = i != 0 ? (i == 1 || i != 2) ? item.getLightHexFormat() : item.getDarkHexFormat() : MyApplication.l0 ? item.getDarkHexFormat() : item.getLightHexFormat();
        textView.setText(lightHexFormat.get(0));
        TextView textView2 = (TextView) holder.getView(R.id.tv_color_2);
        textView2.setText(lightHexFormat.size() == 2 ? lightHexFormat.get(1) : "");
        textView2.setVisibility(lightHexFormat.size() != 2 ? 8 : 0);
    }
}
