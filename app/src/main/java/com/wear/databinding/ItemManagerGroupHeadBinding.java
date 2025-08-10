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
import com.wear.bean.GroupMemberHeader;

/* loaded from: classes3.dex */
public abstract class ItemManagerGroupHeadBinding extends ViewDataBinding {

    @NonNull
    public final TextView a;

    @Bindable
    public GroupMemberHeader b;

    public ItemManagerGroupHeadBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.a = textView;
    }

    @NonNull
    public static ItemManagerGroupHeadBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemManagerGroupHeadBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemManagerGroupHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_manager_group_head, viewGroup, z, obj);
    }

    public abstract void d(@Nullable GroupMemberHeader groupMemberHeader);
}
