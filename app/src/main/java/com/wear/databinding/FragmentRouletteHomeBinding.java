package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.bean.RouletteSettingBean;
import com.wear.bean.RouletteStatus;
import com.wear.ui.discover.roulette.RouletteHomeFragment;
import com.wear.widget.SpreadView;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public abstract class FragmentRouletteHomeBinding extends ViewDataBinding {

    @NonNull
    public final CircleImageView a;

    @NonNull
    public final SkinRoundAutoLinearLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final LottieAnimationView d;

    @NonNull
    public final FrameLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @Bindable
    public RouletteStatus i;

    @Bindable
    public ObservableField<RouletteSettingBean> j;

    @Bindable
    public RouletteHomeFragment.b k;

    public FragmentRouletteHomeBinding(Object obj, View view, int i, CircleImageView circleImageView, SkinRoundAutoLinearLayout skinRoundAutoLinearLayout, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, SpreadView spreadView, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.a = circleImageView;
        this.b = skinRoundAutoLinearLayout;
        this.c = imageView2;
        this.d = lottieAnimationView;
        this.e = frameLayout;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
    }

    @NonNull
    public static FragmentRouletteHomeBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentRouletteHomeBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentRouletteHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_roulette_home, viewGroup, z, obj);
    }

    public abstract void d(@Nullable RouletteHomeFragment.b bVar);

    public abstract void e(@Nullable ObservableField<RouletteSettingBean> observableField);

    public abstract void f(@Nullable RouletteStatus rouletteStatus);
}
