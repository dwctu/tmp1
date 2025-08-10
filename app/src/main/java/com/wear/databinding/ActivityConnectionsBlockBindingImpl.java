package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.widget.ConnectionsSideBar;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.sticky.StickyHeadContainer;
import skin.support.widget.SkinAutoLinearLayout;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public class ActivityConnectionsBlockBindingImpl extends ActivityConnectionsBlockBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts i;

    @Nullable
    public static final SparseIntArray j;

    @NonNull
    public final SkinAutoLinearLayout g;
    public long h;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        i = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"item_connections_letter"}, new int[]{2}, new int[]{R.layout.item_connections_letter});
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.title_container, 3);
        sparseIntArray.put(R.id.back, 4);
        sparseIntArray.put(R.id.mtv_title, 5);
        sparseIntArray.put(R.id.recycler_view, 6);
        sparseIntArray.put(R.id.side_bar, 7);
        sparseIntArray.put(R.id.letter_hint_pop, 8);
    }

    public ActivityConnectionsBlockBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, i, j));
    }

    public final boolean d(ItemConnectionsLetterBinding itemConnectionsLetterBinding, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.h = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.h != 0) {
                return true;
            }
            return this.f.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 2L;
        }
        this.f.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return d((ItemConnectionsLetterBinding) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        return true;
    }

    public ActivityConnectionsBlockBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[4], (TextView) objArr[8], (MediumBoldTextView) objArr[5], (RecyclerView) objArr[6], (ConnectionsSideBar) objArr[7], (StickyHeadContainer) objArr[1], (ItemConnectionsLetterBinding) objArr[2], (SkinAutoRelativeLayout) objArr[3]);
        this.h = -1L;
        SkinAutoLinearLayout skinAutoLinearLayout = (SkinAutoLinearLayout) objArr[0];
        this.g = skinAutoLinearLayout;
        skinAutoLinearLayout.setTag(null);
        this.e.setTag(null);
        setContainedBinding(this.f);
        setRootTag(view);
        invalidateAll();
    }
}
