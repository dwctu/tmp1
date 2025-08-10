package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.RouletteItemSelectBean;

/* loaded from: classes3.dex */
public abstract class ItemRouletteSelectedBinding extends ViewDataBinding {

    @Bindable
    public RouletteItemSelectBean a;

    public ItemRouletteSelectedBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    @NonNull
    public static ItemRouletteSelectedBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return d(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemRouletteSelectedBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemRouletteSelectedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_roulette_selected, viewGroup, z, obj);
    }

    @Nullable
    public RouletteItemSelectBean b() {
        return this.a;
    }

    public abstract void e(@Nullable RouletteItemSelectBean rouletteItemSelectBean);
}
