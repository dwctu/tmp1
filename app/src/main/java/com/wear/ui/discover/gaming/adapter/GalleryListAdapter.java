package com.wear.ui.discover.gaming.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.NewGalleryList;
import com.wear.ui.discover.gaming.adapter.GalleryListAdapter;
import dc.ii;
import dc.ij3;
import dc.kf;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GalleryListAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/ui/discover/gaming/adapter/GalleryListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/NewGalleryList;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "(Ljava/util/List;)V", "clickListener", "Lcom/wear/ui/discover/gaming/adapter/GalleryListAdapter$OnItemClickListener;", "convert", "", "holder", "item", "setItemClickListener", "click", "OnItemClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GalleryListAdapter extends BaseQuickAdapter<NewGalleryList, BaseViewHolder> {

    @Nullable
    public a z;

    /* compiled from: GalleryListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/wear/ui/discover/gaming/adapter/GalleryListAdapter$OnItemClickListener;", "", "itemClick", "", "item", "Lcom/wear/bean/NewGalleryList;", "position", "", "playClick", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(@NotNull NewGalleryList newGalleryList, int i);

        void b(@NotNull NewGalleryList newGalleryList, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GalleryListAdapter(@NotNull List<NewGalleryList> list) {
        super(R.layout.item_gallery, list);
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public static final void J0(GalleryListAdapter this$0, NewGalleryList item, BaseViewHolder holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        a aVar = this$0.z;
        if (aVar != null) {
            aVar.b(item, holder.getAdapterPosition());
        }
    }

    public static final void K0(GalleryListAdapter this$0, NewGalleryList item, BaseViewHolder holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        a aVar = this$0.z;
        if (aVar != null) {
            aVar.a(item, holder.getAdapterPosition());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull final BaseViewHolder holder, @NotNull final NewGalleryList item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ImageView imageView = (ImageView) holder.getView(R.id.iv_ad_banner);
        ConstraintLayout constraintLayout = (ConstraintLayout) holder.getView(R.id.cl_ad_banner);
        kf.w(J()).v(item.getApplicationCoverImgUrl()).f(ii.a).A0(imageView);
        ij3.c(J(), (ImageView) holder.getView(R.id.iv_icon_gaming), item.getApplicationLogoUrl());
        holder.setText(R.id.tv_gaming_name, item.getApplicationName());
        holder.setText(R.id.tv_gaming_description, item.getApplicationSynopsis());
        ((TextView) holder.getView(R.id.btn_play)).setOnClickListener(new View.OnClickListener() { // from class: dc.fx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GalleryListAdapter.J0(this.a, item, holder, view);
            }
        });
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.ex2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GalleryListAdapter.K0(this.a, item, holder, view);
            }
        });
    }

    public final void N0(@Nullable a aVar) {
        this.z = aVar;
    }
}
