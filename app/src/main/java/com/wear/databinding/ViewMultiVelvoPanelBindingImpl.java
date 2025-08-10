package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.widget.llong.sliding.SlideLayout;
import dc.wi1;

/* loaded from: classes3.dex */
public class ViewMultiVelvoPanelBindingImpl extends ViewMultiVelvoPanelBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts j = null;

    @Nullable
    public static final SparseIntArray k;
    public long i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.drawer_view_button, 2);
        sparseIntArray.put(R.id.velvo_line1, 3);
        sparseIntArray.put(R.id.velvo_container, 4);
        sparseIntArray.put(R.id.velvo_default, 5);
        sparseIntArray.put(R.id.velvo_recycler_view, 6);
        sparseIntArray.put(R.id.velvo_line2, 7);
        sparseIntArray.put(R.id.velvo_change_mode, 8);
        sparseIntArray.put(R.id.icon_switch, 9);
        sparseIntArray.put(R.id.drawer_model, 10);
    }

    public ViewMultiVelvoPanelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, j, k));
    }

    @Override // com.wear.databinding.ViewMultiVelvoPanelBinding
    public void e(@Nullable Boolean bool) {
        this.h = bool;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.i;
            this.i = 0L;
        }
        long j3 = j2 & 3;
        boolean zSafeUnbox = j3 != 0 ? ViewDataBinding.safeUnbox(this.h) : false;
        if (j3 != 0) {
            wi1.b(this.c, zSafeUnbox);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (7 != i) {
            return false;
        }
        e((Boolean) obj);
        return true;
    }

    public ViewMultiVelvoPanelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[10], (FrameLayout) objArr[2], (ImageView) objArr[1], (ImageView) objArr[9], (SlideLayout) objArr[0], (LinearLayout) objArr[8], (FrameLayout) objArr[4], (TextView) objArr[5], (View) objArr[3], (View) objArr[7], (RecyclerView) objArr[6]);
        this.i = -1L;
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
