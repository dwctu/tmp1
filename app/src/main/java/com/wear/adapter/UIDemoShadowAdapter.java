package com.wear.adapter;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.UIDemoShadowBean;
import com.wear.widget.shadow.ShadowLayout;
import dc.vi1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UIDemoShadowAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/wear/adapter/UIDemoShadowAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/UIDemoShadowBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "datas", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIDemoShadowAdapter extends BaseQuickAdapter<UIDemoShadowBean, BaseViewHolder> {

    @NotNull
    public final List<UIDemoShadowBean> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIDemoShadowAdapter(@NotNull List<UIDemoShadowBean> datas) {
        super(R.layout.item_ui_demo_shadow, datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
        this.z = datas;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @SuppressLint({"Recycle"})
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull UIDemoShadowBean item) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ((TextView) holder.getView(R.id.tv_name)).setText(item.getName());
        ShadowLayout shadowLayout = (ShadowLayout) holder.getView(R.id.sfl_shadow);
        TypedArray typedArrayObtainStyledAttributes = J().obtainStyledAttributes(item.getResIds(), vi1.ShadowLayout);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.styleable.ShadowLayout)");
        typedArrayObtainStyledAttributes.getResourceId(13, 0);
        typedArrayObtainStyledAttributes.getResourceId(10, 0);
        typedArrayObtainStyledAttributes.getDimension(20, 0.0f);
        float dimension = typedArrayObtainStyledAttributes.getDimension(21, 0.0f);
        typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(19, 0.0f);
        shadowLayout.v(dimension);
        shadowLayout.u((int) dimension2);
    }
}
