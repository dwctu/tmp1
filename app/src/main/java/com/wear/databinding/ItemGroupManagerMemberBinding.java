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
import com.wear.bean.GroupMemberAdmin;
import com.wear.widget.RadiuImageView;

/* loaded from: classes3.dex */
public abstract class ItemGroupManagerMemberBinding extends ViewDataBinding {

    @NonNull
    public final RadiuImageView a;

    @NonNull
    public final TextView b;

    @Bindable
    public GroupMemberAdmin c;

    public ItemGroupManagerMemberBinding(Object obj, View view, int i, RadiuImageView radiuImageView, TextView textView) {
        super(obj, view, i);
        this.a = radiuImageView;
        this.b = textView;
    }

    @NonNull
    public static ItemGroupManagerMemberBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemGroupManagerMemberBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemGroupManagerMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_manager_member, viewGroup, z, obj);
    }

    public abstract void d(@Nullable GroupMemberAdmin groupMemberAdmin);
}
