package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.bean.RouletteSettingBean;
import skin.support.widget.SkinCompatLinearLayout;

/* loaded from: classes3.dex */
public class DialogFragmentReportActionMenuBindingImpl extends DialogFragmentReportActionMenuBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts e = null;

    @Nullable
    public static final SparseIntArray f;

    @NonNull
    public final SkinCompatLinearLayout c;
    public long d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f = sparseIntArray;
        sparseIntArray.put(R.id.recycler_view, 1);
        sparseIntArray.put(R.id.tv_notice, 2);
    }

    public DialogFragmentReportActionMenuBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, e, f));
    }

    public void d(@Nullable RouletteSettingBean rouletteSettingBean) {
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.d = 0L;
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
        if (19 != i) {
            return false;
        }
        d((RouletteSettingBean) obj);
        return true;
    }

    public DialogFragmentReportActionMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[1], (TextView) objArr[2]);
        this.d = -1L;
        SkinCompatLinearLayout skinCompatLinearLayout = (SkinCompatLinearLayout) objArr[0];
        this.c = skinCompatLinearLayout;
        skinCompatLinearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
