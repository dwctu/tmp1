package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.widget.llong.sliding.SlideLayout;

/* loaded from: classes3.dex */
public abstract class ViewMultiVelvoPanelBinding extends ViewDataBinding {

    @NonNull
    public final TextView a;

    @NonNull
    public final FrameLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final SlideLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final RecyclerView g;

    @Bindable
    public Boolean h;

    public ViewMultiVelvoPanelBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, SlideLayout slideLayout, LinearLayout linearLayout, FrameLayout frameLayout2, TextView textView2, View view2, View view3, RecyclerView recyclerView) {
        super(obj, view, i);
        this.a = textView;
        this.b = frameLayout;
        this.c = imageView;
        this.d = slideLayout;
        this.e = linearLayout;
        this.f = textView2;
        this.g = recyclerView;
    }

    @NonNull
    public static ViewMultiVelvoPanelBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return d(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ViewMultiVelvoPanelBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ViewMultiVelvoPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_multi_velvo_panel, viewGroup, z, obj);
    }

    @Nullable
    public Boolean b() {
        return this.h;
    }

    public abstract void e(@Nullable Boolean bool);
}
