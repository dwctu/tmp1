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
import com.wear.bean.UserActionMenuBean;
import com.wear.widget.roundwidget.SkinRoundTextView;

/* loaded from: classes3.dex */
public abstract class FragmentLongUserActionMenuBinding extends ViewDataBinding {

    @NonNull
    public final SkinRoundTextView a;

    @NonNull
    public final SkinRoundTextView b;

    @NonNull
    public final SkinRoundTextView c;

    @NonNull
    public final SkinRoundTextView d;

    @NonNull
    public final SkinRoundTextView e;

    @NonNull
    public final SkinRoundTextView f;

    @NonNull
    public final SkinRoundTextView g;

    @Bindable
    public UserActionMenuBean h;

    public FragmentLongUserActionMenuBinding(Object obj, View view, int i, SkinRoundTextView skinRoundTextView, SkinRoundTextView skinRoundTextView2, SkinRoundTextView skinRoundTextView3, SkinRoundTextView skinRoundTextView4, SkinRoundTextView skinRoundTextView5, SkinRoundTextView skinRoundTextView6, SkinRoundTextView skinRoundTextView7) {
        super(obj, view, i);
        this.a = skinRoundTextView;
        this.b = skinRoundTextView2;
        this.c = skinRoundTextView3;
        this.d = skinRoundTextView4;
        this.e = skinRoundTextView5;
        this.f = skinRoundTextView6;
        this.g = skinRoundTextView7;
    }

    @NonNull
    public static FragmentLongUserActionMenuBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentLongUserActionMenuBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentLongUserActionMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_long_user_action_menu, viewGroup, z, obj);
    }

    public abstract void d(@Nullable UserActionMenuBean userActionMenuBean);
}
