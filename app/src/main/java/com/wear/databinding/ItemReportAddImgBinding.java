package com.wear.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundAutoRelativeLayout;
import com.wear.widget.roundwidget.SkinRoundImageView;

/* loaded from: classes3.dex */
public final class ItemReportAddImgBinding implements ViewBinding {

    @NonNull
    public final SkinRoundAutoRelativeLayout a;

    @NonNull
    public final SkinRoundImageView b;

    public ItemReportAddImgBinding(@NonNull SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout, @NonNull SkinRoundImageView skinRoundImageView) {
        this.a = skinRoundAutoRelativeLayout;
        this.b = skinRoundImageView;
    }

    @NonNull
    public static ItemReportAddImgBinding a(@NonNull View view) {
        SkinRoundImageView skinRoundImageView = (SkinRoundImageView) view.findViewById(R.id.img_add);
        if (skinRoundImageView != null) {
            return new ItemReportAddImgBinding((SkinRoundAutoRelativeLayout) view, skinRoundImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.img_add)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinRoundAutoRelativeLayout getRoot() {
        return this.a;
    }
}
