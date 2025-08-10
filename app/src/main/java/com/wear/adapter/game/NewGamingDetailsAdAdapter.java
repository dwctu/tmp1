package com.wear.adapter.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.adapter.game.NewGamingDetailsAdAdapter;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.ij3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewGamingDetailsAdAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wear/adapter/game/NewGamingDetailsAdAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/wear/adapter/game/NewGamingDetailsAdAdapter$ViewHolder;", "datas", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/adapter/game/NewGamingDetailsAdAdapter$OnItemClickListener;", "(Ljava/util/List;Lcom/wear/adapter/game/NewGamingDetailsAdAdapter$OnItemClickListener;)V", "previewImgOrientation", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHight", "OnItemClickListener", "ViewHolder", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewGamingDetailsAdAdapter extends RecyclerView.Adapter<ViewHolder> {

    @Nullable
    public final List<String> a;

    @Nullable
    public final a b;

    @Nullable
    public String c = "horizontal";

    /* compiled from: NewGamingDetailsAdAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/wear/adapter/game/NewGamingDetailsAdAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivBannerGamingDetails", "Landroid/widget/ImageView;", "getIvBannerGamingDetails", "()Landroid/widget/ImageView;", "setIvBannerGamingDetails", "(Landroid/widget/ImageView;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_banner_gaming_details)
        public ImageView ivBannerGamingDetails;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            ButterKnife.bind(this, itemView);
        }

        @NotNull
        public final ImageView a() {
            ImageView imageView = this.ivBannerGamingDetails;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ivBannerGamingDetails");
            return null;
        }
    }

    public final class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.ivBannerGamingDetails = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_banner_gaming_details, "field 'ivBannerGamingDetails'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.ivBannerGamingDetails = null;
        }
    }

    /* compiled from: NewGamingDetailsAdAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/adapter/game/NewGamingDetailsAdAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(int i);
    }

    public NewGamingDetailsAdAdapter(@Nullable List<String> list, @Nullable a aVar) {
        this.a = list;
        this.b = aVar;
    }

    public static final void n(NewGamingDetailsAdAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ViewHolder holder, final int i) {
        int iA;
        int iA2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        String str = "previewImgOrientation====" + this.c;
        if (Intrinsics.areEqual(this.c, "horizontal")) {
            iA = ce3.a(holder.itemView.getContext(), 250.0f);
            iA2 = ce3.a(holder.itemView.getContext(), 158.0f);
        } else {
            iA = ce3.a(holder.itemView.getContext(), 158.0f);
            iA2 = ce3.a(holder.itemView.getContext(), 250.0f);
        }
        ViewGroup.LayoutParams layoutParams = holder.a().getLayoutParams();
        layoutParams.width = iA;
        layoutParams.height = iA2;
        holder.a().setLayoutParams(layoutParams);
        List<String> list = this.a;
        if (list != null) {
            String str2 = list.get(i);
            Context context = holder.itemView.getContext();
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ij3.a(context, holder.a(), str2, -1, -1, 0);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dc.gk1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewGamingDetailsAdAdapter.n(this.a, i, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(WearUtils.x).inflate(R.layout.item_gaming_details_ad_new, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new ViewHolder(view);
    }

    public final void p(@NotNull String previewImgOrientation) {
        Intrinsics.checkNotNullParameter(previewImgOrientation, "previewImgOrientation");
        this.c = previewImgOrientation;
    }
}
