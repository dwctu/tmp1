package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.wear.bean.RouletteItemSelectBean;

/* loaded from: classes3.dex */
public class ItemRouletteSelectedBindingImpl extends ItemRouletteSelectedBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts d = null;

    @Nullable
    public static final SparseIntArray e = null;

    @NonNull
    public final TextView b;
    public long c;

    public ItemRouletteSelectedBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, d, e));
    }

    @Override // com.wear.databinding.ItemRouletteSelectedBinding
    public void e(@Nullable RouletteItemSelectBean rouletteItemSelectBean) {
        this.a = rouletteItemSelectBean;
        synchronized (this) {
            this.c |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.c;
            this.c = 0L;
        }
        boolean zIsSelected = false;
        RouletteItemSelectBean rouletteItemSelectBean = this.a;
        String text = null;
        long j2 = j & 3;
        if (j2 != 0 && rouletteItemSelectBean != null) {
            zIsSelected = rouletteItemSelectBean.isSelected();
            text = rouletteItemSelectBean.getText();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.b, text);
            this.b.setSelected(zIsSelected);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.c != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.c = 2L;
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
        e((RouletteItemSelectBean) obj);
        return true;
    }

    public ItemRouletteSelectedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.c = -1L;
        TextView textView = (TextView) objArr[0];
        this.b = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
