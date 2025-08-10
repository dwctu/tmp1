package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.wear.bean.chat.ChatMenuItem;
import dc.iu1;
import skin.support.widget.SkinCompatLinearLayout;

/* loaded from: classes3.dex */
public class ItemChatMenuBindingImpl extends ItemChatMenuBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts f = null;

    @Nullable
    public static final SparseIntArray g = null;

    @NonNull
    public final SkinCompatLinearLayout d;
    public long e;

    public ItemChatMenuBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f, g));
    }

    @Override // com.wear.databinding.ItemChatMenuBinding
    public void d(@Nullable ChatMenuItem chatMenuItem) {
        this.c = chatMenuItem;
        synchronized (this) {
            this.e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String name;
        synchronized (this) {
            j = this.e;
            this.e = 0L;
        }
        ChatMenuItem chatMenuItem = this.c;
        int icon = 0;
        long j2 = j & 3;
        if (j2 == 0 || chatMenuItem == null) {
            name = null;
        } else {
            name = chatMenuItem.getName();
            icon = chatMenuItem.getIcon();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.a, name);
            iu1.b(this.b, Integer.valueOf(icon), null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (10 != i) {
            return false;
        }
        d((ChatMenuItem) obj);
        return true;
    }

    public ItemChatMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (ImageView) objArr[1]);
        this.e = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        SkinCompatLinearLayout skinCompatLinearLayout = (SkinCompatLinearLayout) objArr[0];
        this.d = skinCompatLinearLayout;
        skinCompatLinearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
