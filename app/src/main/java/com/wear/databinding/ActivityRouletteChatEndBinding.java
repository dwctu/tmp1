package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.roundwidget.SkinRoundTextView;

/* loaded from: classes3.dex */
public abstract class ActivityRouletteChatEndBinding extends ViewDataBinding {

    @NonNull
    public final MyActionBar a;

    @NonNull
    public final SkinRoundTextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @Bindable
    public String e;

    public ActivityRouletteChatEndBinding(Object obj, View view, int i, MyActionBar myActionBar, SkinRoundTextView skinRoundTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.a = myActionBar;
        this.b = skinRoundTextView;
        this.c = textView;
        this.d = textView2;
    }

    @NonNull
    public static ActivityRouletteChatEndBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityRouletteChatEndBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityRouletteChatEndBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_roulette_chat_end, null, false, obj);
    }

    public abstract void d(@Nullable String str);
}
