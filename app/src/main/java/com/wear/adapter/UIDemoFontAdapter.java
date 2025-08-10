package com.wear.adapter;

import android.os.Build;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.UIDemoFontBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UIDemoFontAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/wear/adapter/UIDemoFontAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/UIDemoFontBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "datas", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoFontAdapter extends BaseQuickAdapter<UIDemoFontBean, BaseViewHolder> {

    @NotNull
    public final List<UIDemoFontBean> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIDemoFontAdapter(@NotNull List<UIDemoFontBean> datas) {
        super(R.layout.item_ui_demo_font, datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
        this.z = datas;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull UIDemoFontBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = (TextView) holder.getView(R.id.tv_font_simple);
        TextView textView2 = (TextView) holder.getView(R.id.tv_font_size);
        TextView textView3 = (TextView) holder.getView(R.id.tv_line_height);
        TextView textView4 = (TextView) holder.getView(R.id.tv_font_wight);
        TextView textView5 = (TextView) holder.getView(R.id.tv_font_name);
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(item.getResIds());
        }
        textView.setText(item.getFontSimple());
        textView2.setText(this.z.indexOf(item) != 0 ? String.valueOf(textView.getTextSize()) : "字号(px)");
        textView3.setText(this.z.indexOf(item) != 0 ? String.valueOf(textView.getLineHeight()) : "行高(px)");
        textView4.setText(item.getFontWeight());
        textView5.setText(item.getName());
    }
}
