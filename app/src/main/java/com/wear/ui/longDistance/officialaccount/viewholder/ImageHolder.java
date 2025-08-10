package com.wear.ui.longDistance.officialaccount.viewholder;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ImageHolder.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/viewholder/ImageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bannerPuas", "Landroid/widget/ImageView;", "getBannerPuas", "()Landroid/widget/ImageView;", "setBannerPuas", "(Landroid/widget/ImageView;)V", "imageView", "getImageView", "setImageView", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageHolder extends RecyclerView.ViewHolder {

    @NotNull
    public ImageView a;
    public ImageView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View viewFindViewById = view.findViewById(R.id.banner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<ImageView>(R.id.banner)");
        this.a = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.banner_puas);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById<ImageView>(R.id.banner_puas)");
        c((ImageView) viewFindViewById2);
    }

    @NotNull
    public final ImageView a() {
        ImageView imageView = this.b;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bannerPuas");
        return null;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ImageView getA() {
        return this.a;
    }

    public final void c(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.b = imageView;
    }
}
