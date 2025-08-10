package com.wear.adapter.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.adapter.game.GamingDetailsAdFullScreenAdapter;
import com.wear.util.WearUtils;
import dc.ij3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GamingDetailsAdFullScreenAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/wear/adapter/game/GamingDetailsAdFullScreenAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/wear/adapter/game/GamingDetailsAdFullScreenAdapter$ViewHolder;", "datas", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/adapter/game/GamingDetailsAdFullScreenAdapter$OnItemClickListener;", "(Ljava/util/List;Lcom/wear/adapter/game/GamingDetailsAdFullScreenAdapter$OnItemClickListener;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "OnItemClickListener", "ViewHolder", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GamingDetailsAdFullScreenAdapter extends RecyclerView.Adapter<ViewHolder> {

    @Nullable
    public final List<Integer> a;

    @Nullable
    public final a b;

    /* compiled from: GamingDetailsAdFullScreenAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/wear/adapter/game/GamingDetailsAdFullScreenAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivBannerGamingDetails", "Lcom/github/chrisbanes/photoview/PhotoView;", "getIvBannerGamingDetails", "()Lcom/github/chrisbanes/photoview/PhotoView;", "setIvBannerGamingDetails", "(Lcom/github/chrisbanes/photoview/PhotoView;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_banner_gaming_details)
        public PhotoView ivBannerGamingDetails;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            ButterKnife.bind(this, itemView);
        }

        @NotNull
        public final PhotoView a() {
            PhotoView photoView = this.ivBannerGamingDetails;
            if (photoView != null) {
                return photoView;
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
            viewHolder.ivBannerGamingDetails = (PhotoView) Utils.findRequiredViewAsType(view, R.id.iv_banner_gaming_details, "field 'ivBannerGamingDetails'", PhotoView.class);
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

    /* compiled from: GamingDetailsAdFullScreenAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/adapter/game/GamingDetailsAdFullScreenAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(int i);
    }

    public GamingDetailsAdFullScreenAdapter(@Nullable List<Integer> list, @Nullable a aVar) {
        this.a = list;
        this.b = aVar;
    }

    public static final void n(GamingDetailsAdFullScreenAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Integer> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<Integer> list = this.a;
        if (list != null) {
            int iIntValue = list.get(i).intValue();
            Context context = holder.itemView.getContext();
            if (context != null) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ij3.b(context, holder.a(), iIntValue, -1, -1, 0);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dc.fk1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GamingDetailsAdFullScreenAdapter.n(this.a, i, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(WearUtils.x).inflate(R.layout.item_gaming_details_ad_full_screen, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new ViewHolder(view);
    }
}
