package com.wear.ui.discover.gaming.weight;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: ViewPageTransform.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/wear/ui/discover/gaming/weight/ViewPageTransform;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "viewpae2", "Landroidx/viewpager2/widget/ViewPager2;", "(Landroidx/viewpager2/widget/ViewPager2;)V", "default", "", "getDefault", "()F", "default_trans", "getDefault_trans", "getViewpae2", "()Landroidx/viewpager2/widget/ViewPager2;", "isRtl1", "", "transformPage", "", DataLayout.ELEMENT, "Landroid/view/View;", "position", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewPageTransform implements ViewPager2.PageTransformer {

    @NotNull
    public final ViewPager2 a;
    public final float b;
    public final float c;

    public final boolean a() {
        return this.a.getLayoutDirection() == 1;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NotNull View page, float position) {
        Intrinsics.checkNotNullParameter(page, "page");
        float f = 40 * position;
        if (this.a.getOrientation() == 0) {
            if (a()) {
                f = -f;
            }
            page.setTranslationX(f);
        } else {
            page.setTranslationY(f);
        }
        if (position <= -1.0f) {
            page.setScaleX(this.b);
            page.setScaleY(this.b);
            page.setTranslationX(this.c);
            return;
        }
        if (position <= 0.0f) {
            float f2 = 1 + (position / 15);
            page.setScaleX(f2);
            page.setScaleY(f2);
            page.setTranslationX((0 - position) * this.b);
            return;
        }
        if (position > 1.0f) {
            page.setScaleX(this.b);
            page.setScaleY(this.b);
            page.setTranslationX(this.c);
        } else {
            float f3 = 1 - (position / 15);
            page.setScaleX(f3);
            page.setScaleY(f3);
            page.setTranslationX((0 - position) * this.b);
        }
    }
}
