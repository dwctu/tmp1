package com.wear.adapter.longdistance;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.adapter.longdistance.GuideViewPagerAdapter;
import dc.ah4;
import dc.kf;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GuideViewPagerAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/wear/adapter/longdistance/GuideViewPagerAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "mutableList", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/adapter/longdistance/GuideViewPagerAdapter$Listener;", "(Ljava/util/List;Lcom/wear/adapter/longdistance/GuideViewPagerAdapter$Listener;)V", "calculateScale", "", "position", "", "longDistanceLottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "rlLongDistanceBringUp", "Landroid/widget/RelativeLayout;", "convert", "holder", "item", "Listener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GuideViewPagerAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    @Nullable
    public final a z;

    /* compiled from: GuideViewPagerAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/wear/adapter/longdistance/GuideViewPagerAdapter$Listener;", "", "onItemGotIt", "", "onItemNext", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(int i);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideViewPagerAdapter(@NotNull List<String> mutableList, @Nullable a aVar) {
        super(R.layout.item_guide_long_distance, mutableList);
        Intrinsics.checkNotNullParameter(mutableList, "mutableList");
        this.z = aVar;
    }

    public static final void K0(GuideViewPagerAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.z;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static final void L0(BaseViewHolder holder, GuideViewPagerAdapter this$0, View view) {
        a aVar;
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (holder.getLayoutPosition() >= 2 || (aVar = this$0.z) == null) {
            return;
        }
        aVar.a(holder.getLayoutPosition() + 1);
    }

    public static final void M0(BaseViewHolder holder, GuideViewPagerAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (holder.getLayoutPosition() == 2) {
            a aVar = this$0.z;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        a aVar2 = this$0.z;
        if (aVar2 != null) {
            aVar2.a(holder.getLayoutPosition() + 1);
        }
    }

    public final void I0(int i, @NotNull LottieAnimationView longDistanceLottieView, @NotNull RelativeLayout rlLongDistanceBringUp) {
        Intrinsics.checkNotNullParameter(longDistanceLottieView, "longDistanceLottieView");
        Intrinsics.checkNotNullParameter(rlLongDistanceBringUp, "rlLongDistanceBringUp");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = J().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        double d = i2;
        longDistanceLottieView.setY((float) (0.374d * d));
        longDistanceLottieView.setX((float) (i3 * 0.605d));
        longDistanceLottieView.setAnimation("long_distance_finger.json");
        longDistanceLottieView.p(true);
        longDistanceLottieView.r();
        rlLongDistanceBringUp.setY((float) (d * 0.51d));
        if (i == 0) {
            longDistanceLottieView.setVisibility(0);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull final BaseViewHolder holder, @NotNull String item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        kf.w(J()).v("file:///android_asset/" + item).A0((ImageView) holder.getView(R.id.iv_guide));
        View view = holder.getView(R.id.tv_skip);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        View view2 = holder.getView(R.id.tv_long_next);
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) view2;
        View view3 = holder.getView(R.id.rl_long_distance_bring_up);
        Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) view3;
        View view4 = holder.getView(R.id.iv_guide);
        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) view4;
        View view5 = holder.getView(R.id.long_distance_lottie_view);
        Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view5;
        if (holder.getLayoutPosition() == 2) {
            holder.setGone(R.id.tv_skip, true);
            holder.setText(R.id.tv_long_next, ah4.e(R.string.Resistence_button));
        } else {
            holder.setGone(R.id.tv_skip, false);
            textView.getPaint().setFlags(8);
            textView.getPaint().setAntiAlias(true);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ah4.e(R.string.long_distance_tutorial_button);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.long_distance_tutorial_button)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{Integer.valueOf(holder.getLayoutPosition() + 1)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            holder.setText(R.id.tv_long_next, str);
        }
        if (holder.getLayoutPosition() == 0) {
            relativeLayout.setVisibility(0);
        } else {
            lottieAnimationView.g();
            lottieAnimationView.setVisibility(8);
            relativeLayout.setVisibility(8);
        }
        holder.setText(R.id.tv_long_distance_bring_up, ah4.e(R.string.long_distance_tutorial_step1));
        I0(holder.getLayoutPosition(), lottieAnimationView, relativeLayout);
        textView.setOnClickListener(new View.OnClickListener() { // from class: dc.qk1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                GuideViewPagerAdapter.K0(this.a, view6);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.pk1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                GuideViewPagerAdapter.L0(holder, this, view6);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: dc.ok1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                GuideViewPagerAdapter.M0(holder, this, view6);
            }
        });
    }
}
