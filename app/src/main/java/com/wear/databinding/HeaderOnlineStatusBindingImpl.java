package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.wear.bean.me.OnlineStatusHeadBean;
import dc.bc3;
import dc.wi1;

/* loaded from: classes3.dex */
public class HeaderOnlineStatusBindingImpl extends HeaderOnlineStatusBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h = null;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final TextView e;
    public long f;

    public HeaderOnlineStatusBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, g, h));
    }

    @Override // com.wear.databinding.HeaderOnlineStatusBinding
    public void b(@Nullable OnlineStatusHeadBean onlineStatusHeadBean) {
        this.a = onlineStatusHeadBean;
        synchronized (this) {
            this.f |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int icon;
        synchronized (this) {
            j = this.f;
            this.f = 0L;
        }
        OnlineStatusHeadBean onlineStatusHeadBean = this.a;
        String text = null;
        long j2 = j & 3;
        boolean zIsSelected = false;
        if (j2 == 0 || onlineStatusHeadBean == null) {
            icon = 0;
        } else {
            zIsSelected = onlineStatusHeadBean.isSelected();
            text = onlineStatusHeadBean.getText();
            icon = onlineStatusHeadBean.getIcon();
        }
        if (j2 != 0) {
            wi1.b(this.b, zIsSelected);
            wi1.b(this.c, zIsSelected);
            bc3.b(this.d, icon);
            wi1.b(this.e, zIsSelected);
            TextViewBindingAdapter.setText(this.e, text);
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
        if (15 != i) {
            return false;
        }
        b((OnlineStatusHeadBean) obj);
        return true;
    }

    public HeaderOnlineStatusBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.c = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[2];
        this.d = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.e = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
