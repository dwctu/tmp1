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
import com.wear.bean.RouletteStatus;
import com.wear.ui.discover.roulette.RouletteResultFragment;
import com.wear.ui.discover.roulette.widget.RoundProgressBar;
import com.wear.widget.RadarScanView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public abstract class FragmentRouletteResultBinding extends ViewDataBinding {

    @NonNull
    public final CircleImageView a;

    @NonNull
    public final RadarScanView b;

    @NonNull
    public final RoundProgressBar c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @Bindable
    public RouletteStatus f;

    @Bindable
    public RouletteResultFragment.b g;

    public FragmentRouletteResultBinding(Object obj, View view, int i, CircleImageView circleImageView, RadarScanView radarScanView, RoundProgressBar roundProgressBar, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.a = circleImageView;
        this.b = radarScanView;
        this.c = roundProgressBar;
        this.d = textView;
        this.e = textView2;
    }

    @NonNull
    public static FragmentRouletteResultBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentRouletteResultBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentRouletteResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_roulette_result, viewGroup, z, obj);
    }

    public abstract void d(@Nullable RouletteResultFragment.b bVar);

    public abstract void e(@Nullable RouletteStatus rouletteStatus);
}
