package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.wear.bean.chat.ReportActionMenuBean;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;

/* loaded from: classes3.dex */
public class ItemReportActionMenuBindingImpl extends ItemReportActionMenuBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts e = null;

    @Nullable
    public static final SparseIntArray f = null;

    @NonNull
    public final SkinRoundConstraintLayout c;
    public long d;

    public ItemReportActionMenuBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, e, f));
    }

    @Override // com.wear.databinding.ItemReportActionMenuBinding
    public void b(@Nullable ReportActionMenuBean reportActionMenuBean) {
        this.b = reportActionMenuBean;
        synchronized (this) {
            this.d |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.d;
            this.d = 0L;
        }
        String title = null;
        ReportActionMenuBean reportActionMenuBean = this.b;
        long j2 = j & 3;
        if (j2 != 0 && reportActionMenuBean != null) {
            title = reportActionMenuBean.getTitle();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.a, title);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.d = 2L;
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
        b((ReportActionMenuBean) obj);
        return true;
    }

    public ItemReportActionMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.d = -1L;
        SkinRoundConstraintLayout skinRoundConstraintLayout = (SkinRoundConstraintLayout) objArr[0];
        this.c = skinRoundConstraintLayout;
        skinRoundConstraintLayout.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
