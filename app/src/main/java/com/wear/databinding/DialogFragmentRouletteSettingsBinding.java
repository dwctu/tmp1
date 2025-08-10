package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.bean.RouletteSettingBean;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public abstract class DialogFragmentRouletteSettingsBinding extends ViewDataBinding {

    @NonNull
    public final ImageView a;

    @NonNull
    public final RecyclerView b;

    @NonNull
    public final SwitchView c;

    @NonNull
    public final SwitchView d;

    @NonNull
    public final TextView e;

    @Bindable
    public RouletteSettingBean f;

    public DialogFragmentRouletteSettingsBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, SwitchView switchView, SwitchView switchView2, TextView textView) {
        super(obj, view, i);
        this.a = imageView;
        this.b = recyclerView;
        this.c = switchView;
        this.d = switchView2;
        this.e = textView;
    }

    @NonNull
    public static DialogFragmentRouletteSettingsBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogFragmentRouletteSettingsBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogFragmentRouletteSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_fragment_roulette_settings, viewGroup, z, obj);
    }

    public abstract void d(@Nullable RouletteSettingBean rouletteSettingBean);
}
