package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.wear.bean.UserToy;

/* loaded from: classes3.dex */
public class ItemRouletteToyBindingImpl extends ItemRouletteToyBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts f = null;

    @Nullable
    public static final SparseIntArray g = null;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;
    public long e;

    public ItemRouletteToyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f, g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.e;
            this.e = 0L;
        }
        UserToy userToy = this.a;
        char toyFirstName = 0;
        long j2 = j & 3;
        String strValueOf = null;
        if (j2 != 0) {
            if (userToy != null) {
                toyFirstName = userToy.getToyFirstName();
                strValueOf = userToy.getToyName();
            }
            String str2 = strValueOf;
            strValueOf = String.valueOf(toyFirstName);
            str = str2;
        } else {
            str = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.c, strValueOf);
            TextViewBindingAdapter.setText(this.d, str);
        }
    }

    @Override // com.wear.databinding.ItemRouletteToyBinding
    public void f(@Nullable UserToy userToy) {
        this.a = userToy;
        synchronized (this) {
            this.e |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
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
        if (15 != i) {
            return false;
        }
        f((UserToy) obj);
        return true;
    }

    public ItemRouletteToyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.e = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.d = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
