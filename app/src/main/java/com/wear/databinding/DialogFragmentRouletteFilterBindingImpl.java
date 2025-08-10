package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.RouletteSettingBean;
import com.wear.ui.discover.roulette.widget.FlowLayout;
import skin.support.widget.SkinCompatLinearLayout;

/* loaded from: classes3.dex */
public class DialogFragmentRouletteFilterBindingImpl extends DialogFragmentRouletteFilterBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts h = null;

    @Nullable
    public static final SparseIntArray i;

    @NonNull
    public final SkinCompatLinearLayout f;
    public long g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        i = sparseIntArray;
        sparseIntArray.put(R.id.btn_close, 1);
        sparseIntArray.put(R.id.gender_recyclerview, 2);
        sparseIntArray.put(R.id.plays_recyclerview, 3);
        sparseIntArray.put(R.id.cancel_btn, 4);
        sparseIntArray.put(R.id.submit_btn, 5);
    }

    public DialogFragmentRouletteFilterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, h, i));
    }

    @Override // com.wear.databinding.DialogFragmentRouletteFilterBinding
    public void d(@Nullable RouletteSettingBean rouletteSettingBean) {
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.g = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (19 != i2) {
            return false;
        }
        d((RouletteSettingBean) obj);
        return true;
    }

    public DialogFragmentRouletteFilterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[4], (FlowLayout) objArr[2], (FlowLayout) objArr[3], (TextView) objArr[5]);
        this.g = -1L;
        SkinCompatLinearLayout skinCompatLinearLayout = (SkinCompatLinearLayout) objArr[0];
        this.f = skinCompatLinearLayout;
        skinCompatLinearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
