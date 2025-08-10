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
import com.lovense.wear.R;
import com.wear.bean.GroupMemberRequest;
import com.wear.widget.RadiuImageView;

/* loaded from: classes3.dex */
public abstract class ItemGroupManagerInvitationBinding extends ViewDataBinding {

    @NonNull
    public final RadiuImageView a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @Bindable
    public GroupMemberRequest d;

    public ItemGroupManagerInvitationBinding(Object obj, View view, int i, TextView textView, ImageView imageView, RadiuImageView radiuImageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.a = radiuImageView;
        this.b = textView2;
        this.c = textView3;
    }

    @NonNull
    public static ItemGroupManagerInvitationBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemGroupManagerInvitationBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemGroupManagerInvitationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_manager_invitation, viewGroup, z, obj);
    }

    public abstract void d(@Nullable GroupMemberRequest groupMemberRequest);
}
