package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public abstract class ActivityChatNewSelectBinding extends ViewDataBinding {

    @NonNull
    public final MyActionBar a;

    @NonNull
    public final TextView b;

    @NonNull
    public final RecyclerView c;

    public ActivityChatNewSelectBinding(Object obj, View view, int i, MyActionBar myActionBar, TextView textView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.a = myActionBar;
        this.b = textView;
        this.c = recyclerView;
    }

    @NonNull
    public static ActivityChatNewSelectBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChatNewSelectBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChatNewSelectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_new_select, null, false, obj);
    }
}
