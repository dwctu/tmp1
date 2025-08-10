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
import com.wear.bean.UserToy;

/* loaded from: classes3.dex */
public abstract class ItemRouletteToyBinding extends ViewDataBinding {

    @Bindable
    public UserToy a;

    public ItemRouletteToyBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemRouletteToyBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemRouletteToyBinding c(@NonNull View view, @Nullable Object obj) {
        return (ItemRouletteToyBinding) ViewDataBinding.bind(obj, view, R.layout.item_roulette_toy);
    }

    @NonNull
    public static ItemRouletteToyBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemRouletteToyBinding e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemRouletteToyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_roulette_toy, viewGroup, z, obj);
    }

    public abstract void f(@Nullable UserToy userToy);
}
