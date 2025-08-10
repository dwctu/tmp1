package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.RouletteSettingBean;
import com.wear.ui.discover.roulette.widget.FlowLayout;

/* loaded from: classes3.dex */
public abstract class DialogFragmentRouletteFilterBinding extends ViewDataBinding {

    @NonNull
    public final ImageView a;

    @NonNull
    public final TextView b;

    @NonNull
    public final FlowLayout c;

    @NonNull
    public final FlowLayout d;

    @NonNull
    public final TextView e;

    public DialogFragmentRouletteFilterBinding(Object obj, View view, int i, ImageView imageView, TextView textView, FlowLayout flowLayout, FlowLayout flowLayout2, TextView textView2) {
        super(obj, view, i);
        this.a = imageView;
        this.b = textView;
        this.c = flowLayout;
        this.d = flowLayout2;
        this.e = textView2;
    }

    @NonNull
    public static DialogFragmentRouletteFilterBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogFragmentRouletteFilterBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogFragmentRouletteFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_fragment_roulette_filter, viewGroup, z, obj);
    }

    public abstract void d(@Nullable RouletteSettingBean rouletteSettingBean);
}
