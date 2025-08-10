package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.main.toy.newtoy.NewToyViewModel;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ActivityNewToyBindingImpl extends ActivityNewToyBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts h = null;

    @Nullable
    public static final SparseIntArray i;

    @NonNull
    public final RelativeLayout f;
    public long g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        i = sparseIntArray;
        sparseIntArray.put(R.id.newtoy_notoyrlstub, 1);
        sparseIntArray.put(R.id.newtoy_searchfailedstub, 2);
        sparseIntArray.put(R.id.newtoy_btdisabledstub, 3);
        sparseIntArray.put(R.id.newtoy_toycontentstub, 4);
        sparseIntArray.put(R.id.app_bar, 5);
    }

    public ActivityNewToyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, h, i));
    }

    public void b(@Nullable NewToyViewModel newToyViewModel) {
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
        if (27 != i2) {
            return false;
        }
        b((NewToyViewModel) obj);
        return true;
    }

    public ActivityNewToyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MyActionBar) objArr[5], objArr[3] != null ? NewtoyBtdisabledLayoutBinding.a((View) objArr[3]) : null, objArr[1] != null ? NewtoyNotoyrlLayoutBinding.a((View) objArr[1]) : null, objArr[2] != null ? NewtoySearchfailedLayoutBinding.a((View) objArr[2]) : null, objArr[4] != null ? NewtoyToycontentLayoutBinding.a((View) objArr[4]) : null);
        this.g = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
