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
import com.wear.bean.chat.ChatActionMenuBean;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;
import dc.iu1;

/* loaded from: classes3.dex */
public class ItemChatActionMenuBindingImpl extends ItemChatActionMenuBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h = null;

    @NonNull
    public final SkinRoundConstraintLayout e;
    public long f;

    public ItemChatActionMenuBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, g, h));
    }

    @Override // com.wear.databinding.ItemChatActionMenuBinding
    public void b(@Nullable ChatActionMenuBean chatActionMenuBean) {
        this.d = chatActionMenuBean;
        synchronized (this) {
            this.f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String title;
        String desc;
        int icon;
        synchronized (this) {
            j = this.f;
            this.f = 0L;
        }
        ChatActionMenuBean chatActionMenuBean = this.d;
        long j2 = j & 3;
        boolean zIsEnable = false;
        if (j2 == 0 || chatActionMenuBean == null) {
            title = null;
            desc = null;
            icon = 0;
        } else {
            title = chatActionMenuBean.getTitle();
            zIsEnable = chatActionMenuBean.isEnable();
            desc = chatActionMenuBean.getDesc();
            icon = chatActionMenuBean.getIcon();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.a, desc);
            this.a.setEnabled(zIsEnable);
            this.b.setEnabled(zIsEnable);
            iu1.b(this.b, Integer.valueOf(icon), null);
            TextViewBindingAdapter.setText(this.c, title);
            this.c.setEnabled(zIsEnable);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f = 2L;
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
        b((ChatActionMenuBean) obj);
        return true;
    }

    public ItemChatActionMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (ImageView) objArr[1], (TextView) objArr[2]);
        this.f = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        SkinRoundConstraintLayout skinRoundConstraintLayout = (SkinRoundConstraintLayout) objArr[0];
        this.e = skinRoundConstraintLayout;
        skinRoundConstraintLayout.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
