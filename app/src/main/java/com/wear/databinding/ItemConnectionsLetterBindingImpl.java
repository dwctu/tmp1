package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundTextView;
import skin.support.widget.SkinAutoLinearLayout;

/* loaded from: classes3.dex */
public class ItemConnectionsLetterBindingImpl extends ItemConnectionsLetterBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h;

    @NonNull
    public final SkinAutoLinearLayout d;

    @NonNull
    public final SkinRoundTextView e;
    public long f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h = sparseIntArray;
        sparseIntArray.put(R.id.bottom_line, 2);
    }

    public ItemConnectionsLetterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, g, h));
    }

    @Override // com.wear.databinding.ItemConnectionsLetterBinding
    public void d(@Nullable Boolean bool) {
        this.c = bool;
        synchronized (this) {
            this.f |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ItemConnectionsLetterBinding
    public void e(@Nullable String str) {
        this.b = str;
        synchronized (this) {
            this.f |= 1;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        SkinRoundTextView skinRoundTextView;
        int i;
        synchronized (this) {
            j = this.f;
            this.f = 0L;
        }
        String str = this.b;
        Boolean bool = this.c;
        int colorFromResource = 0;
        long j2 = j & 6;
        if (j2 != 0) {
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j2 != 0) {
                j |= zSafeUnbox ? 16L : 8L;
            }
            if (zSafeUnbox) {
                skinRoundTextView = this.e;
                i = R.color.lvs_ui_standard_systemTextRegular;
            } else {
                skinRoundTextView = this.e;
                i = R.color.lvs_ui_standard_systemText4;
            }
            colorFromResource = ViewDataBinding.getColorFromResource(skinRoundTextView, i);
        }
        if ((5 & j) != 0) {
            TextViewBindingAdapter.setText(this.e, str);
        }
        if ((j & 6) != 0) {
            this.e.setTextColor(colorFromResource);
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
            this.f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (12 == i) {
            e((String) obj);
        } else {
            if (8 != i) {
                return false;
            }
            d((Boolean) obj);
        }
        return true;
    }

    public ItemConnectionsLetterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[2]);
        this.f = -1L;
        SkinAutoLinearLayout skinAutoLinearLayout = (SkinAutoLinearLayout) objArr[0];
        this.d = skinAutoLinearLayout;
        skinAutoLinearLayout.setTag(null);
        SkinRoundTextView skinRoundTextView = (SkinRoundTextView) objArr[1];
        this.e = skinRoundTextView;
        skinRoundTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
