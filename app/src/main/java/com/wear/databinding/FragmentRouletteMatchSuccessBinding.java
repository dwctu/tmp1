package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.FindMatchUserBean;
import com.wear.ui.discover.roulette.widget.RouletteToyAndPlaysView;
import com.wear.ui.discover.roulette.widget.RoundProgressBar;

/* loaded from: classes3.dex */
public abstract class FragmentRouletteMatchSuccessBinding extends ViewDataBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final RoundProgressBar g;

    @NonNull
    public final TextView h;

    @NonNull
    public final RouletteToyAndPlaysView i;

    @Bindable
    public FindMatchUserBean j;

    @Bindable
    public Boolean k;

    public FragmentRouletteMatchSuccessBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, ConstraintLayout constraintLayout, ImageView imageView, TextView textView2, TextView textView3, RoundProgressBar roundProgressBar, TextView textView4, RouletteToyAndPlaysView rouletteToyAndPlaysView) {
        super(obj, view, i);
        this.a = linearLayout;
        this.b = textView;
        this.c = linearLayout2;
        this.d = imageView;
        this.e = textView2;
        this.f = textView3;
        this.g = roundProgressBar;
        this.h = textView4;
        this.i = rouletteToyAndPlaysView;
    }

    @NonNull
    public static FragmentRouletteMatchSuccessBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentRouletteMatchSuccessBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentRouletteMatchSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_roulette_match_success, viewGroup, z, obj);
    }

    public abstract void d(@Nullable FindMatchUserBean findMatchUserBean);

    public abstract void e(@Nullable Boolean bool);
}
