package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.InviteRequestInfo;

/* loaded from: classes3.dex */
public abstract class FragmentInviteUserRequestBinding extends ViewDataBinding {

    @NonNull
    public final TextView a;

    @NonNull
    public final TextView b;

    @Bindable
    public InviteRequestInfo c;

    public FragmentInviteUserRequestBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.a = textView;
        this.b = textView3;
    }

    @NonNull
    public static FragmentInviteUserRequestBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentInviteUserRequestBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentInviteUserRequestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_invite_user_request, viewGroup, z, obj);
    }

    public abstract void d(@Nullable InviteRequestInfo inviteRequestInfo);
}
