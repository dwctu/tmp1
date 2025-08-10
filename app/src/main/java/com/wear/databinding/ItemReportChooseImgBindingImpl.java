package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundAutoRelativeLayout;
import com.wear.widget.roundwidget.SkinRoundImageView;

/* loaded from: classes3.dex */
public class ItemReportChooseImgBindingImpl extends ItemReportChooseImgBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts c = null;

    @Nullable
    public static final SparseIntArray d;

    @NonNull
    public final SkinRoundAutoRelativeLayout a;
    public long b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(R.id.img_report, 1);
        sparseIntArray.put(R.id.img_delete, 2);
    }

    public ItemReportChooseImgBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, c, d));
    }

    public void b(@Nullable String str) {
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.b = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.b != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.b = 2L;
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
        b((String) obj);
        return true;
    }

    public ItemReportChooseImgBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SkinRoundImageView) objArr[2], (SkinRoundImageView) objArr[1]);
        this.b = -1L;
        SkinRoundAutoRelativeLayout skinRoundAutoRelativeLayout = (SkinRoundAutoRelativeLayout) objArr[0];
        this.a = skinRoundAutoRelativeLayout;
        skinRoundAutoRelativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
