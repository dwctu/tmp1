package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public abstract class ActivityOnlineStatusBinding extends ViewDataBinding {

    @NonNull
    public final TextView a;

    @NonNull
    public final RecyclerView b;

    @NonNull
    public final RecyclerView c;

    @Bindable
    public Integer d;

    @Bindable
    public Integer e;

    public ActivityOnlineStatusBinding(Object obj, View view, int i, MyActionBar myActionBar, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.a = textView;
        this.b = recyclerView;
        this.c = recyclerView2;
    }

    @NonNull
    public static ActivityOnlineStatusBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityOnlineStatusBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityOnlineStatusBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_online_status, null, false, obj);
    }

    public abstract void d(@Nullable Integer num);

    public abstract void e(@Nullable Integer num);
}
