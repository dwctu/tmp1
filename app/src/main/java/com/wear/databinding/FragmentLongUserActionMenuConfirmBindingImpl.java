package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom;
import com.wear.widget.roundwidget.SkinRoundTextView;
import dc.g83;
import skin.support.widget.SkinAutoLinearLayout;

/* loaded from: classes3.dex */
public class FragmentLongUserActionMenuConfirmBindingImpl extends FragmentLongUserActionMenuConfirmBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts i = null;

    @Nullable
    public static final SparseIntArray j;

    @NonNull
    public final SkinAutoLinearLayout e;

    @NonNull
    public final SkinRoundTextView f;

    @NonNull
    public final SkinRoundTextView g;
    public long h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.tv_cancel, 4);
    }

    public FragmentLongUserActionMenuConfirmBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, i, j));
    }

    @Override // com.wear.databinding.FragmentLongUserActionMenuConfirmBinding
    public void d(@Nullable String str) {
        this.d = str;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.wear.databinding.FragmentLongUserActionMenuConfirmBinding
    public void e(@Nullable LongUserActionMenuConfirmFragmentBottom.c cVar) {
        this.c = cVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        int content;
        int confirmText;
        int title;
        synchronized (this) {
            j2 = this.h;
            this.h = 0L;
        }
        LongUserActionMenuConfirmFragmentBottom.c cVar = this.c;
        String str = this.d;
        long j3 = 7 & j2;
        int i2 = 0;
        if (j3 != 0) {
            if ((j2 & 5) == 0 || cVar == null) {
                confirmText = 0;
                title = 0;
            } else {
                confirmText = cVar.getConfirmText();
                title = cVar.getTitle();
            }
            if (cVar != null) {
                content = cVar.getContent();
                i2 = title;
            } else {
                i2 = title;
                content = 0;
            }
        } else {
            content = 0;
            confirmText = 0;
        }
        if ((j2 & 5) != 0) {
            this.f.setText(i2);
            this.b.setText(confirmText);
        }
        if (j3 != 0) {
            g83.a(this.g, content, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (24 == i2) {
            e((LongUserActionMenuConfirmFragmentBottom.c) obj);
        } else {
            if (17 != i2) {
                return false;
            }
            d((String) obj);
        }
        return true;
    }

    public FragmentLongUserActionMenuConfirmBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SkinRoundTextView) objArr[4], (SkinRoundTextView) objArr[3]);
        this.h = -1L;
        SkinAutoLinearLayout skinAutoLinearLayout = (SkinAutoLinearLayout) objArr[0];
        this.e = skinAutoLinearLayout;
        skinAutoLinearLayout.setTag(null);
        SkinRoundTextView skinRoundTextView = (SkinRoundTextView) objArr[1];
        this.f = skinRoundTextView;
        skinRoundTextView.setTag(null);
        SkinRoundTextView skinRoundTextView2 = (SkinRoundTextView) objArr[2];
        this.g = skinRoundTextView2;
        skinRoundTextView2.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
