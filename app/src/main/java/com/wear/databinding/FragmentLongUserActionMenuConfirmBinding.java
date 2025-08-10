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
import com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom;
import com.wear.widget.roundwidget.SkinRoundTextView;

/* loaded from: classes3.dex */
public abstract class FragmentLongUserActionMenuConfirmBinding extends ViewDataBinding {

    @NonNull
    public final SkinRoundTextView a;

    @NonNull
    public final SkinRoundTextView b;

    @Bindable
    public LongUserActionMenuConfirmFragmentBottom.c c;

    @Bindable
    public String d;

    public FragmentLongUserActionMenuConfirmBinding(Object obj, View view, int i, SkinRoundTextView skinRoundTextView, SkinRoundTextView skinRoundTextView2) {
        super(obj, view, i);
        this.a = skinRoundTextView;
        this.b = skinRoundTextView2;
    }

    @NonNull
    public static FragmentLongUserActionMenuConfirmBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentLongUserActionMenuConfirmBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentLongUserActionMenuConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_long_user_action_menu_confirm, viewGroup, z, obj);
    }

    public abstract void d(@Nullable String str);

    public abstract void e(@Nullable LongUserActionMenuConfirmFragmentBottom.c cVar);
}
