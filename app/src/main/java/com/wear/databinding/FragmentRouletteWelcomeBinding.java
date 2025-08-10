package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.ui.discover.roulette.RouletteWelcomeFragment;
import com.wear.widget.SpreadView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public abstract class FragmentRouletteWelcomeBinding extends ViewDataBinding {

    @NonNull
    public final CircleImageView a;

    @NonNull
    public final TextView b;

    @Bindable
    public RouletteWelcomeFragment.b c;

    public FragmentRouletteWelcomeBinding(Object obj, View view, int i, CircleImageView circleImageView, TextView textView, TextView textView2, SpreadView spreadView, TextView textView3) {
        super(obj, view, i);
        this.a = circleImageView;
        this.b = textView2;
    }

    @NonNull
    public static FragmentRouletteWelcomeBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentRouletteWelcomeBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentRouletteWelcomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_roulette_welcome, viewGroup, z, obj);
    }

    public abstract void d(@Nullable RouletteWelcomeFragment.b bVar);
}
