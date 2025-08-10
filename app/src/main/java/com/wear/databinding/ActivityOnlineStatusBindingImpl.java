package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import dc.bc3;

/* loaded from: classes3.dex */
public class ActivityOnlineStatusBindingImpl extends ActivityOnlineStatusBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts i = null;

    @Nullable
    public static final SparseIntArray j;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final TextView g;
    public long h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.actionbar, 2);
        sparseIntArray.put(R.id.recycler_view_header, 3);
        sparseIntArray.put(R.id.add, 4);
        sparseIntArray.put(R.id.recycler_view, 5);
    }

    public ActivityOnlineStatusBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, i, j));
    }

    @Override // com.wear.databinding.ActivityOnlineStatusBinding
    public void d(@Nullable Integer num) {
        this.d = num;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ActivityOnlineStatusBinding
    public void e(@Nullable Integer num) {
        this.e = num;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        int iSafeUnbox;
        synchronized (this) {
            j2 = this.h;
            this.h = 0L;
        }
        Integer num = this.d;
        Integer num2 = this.e;
        long j3 = j2 & 7;
        int iSafeUnbox2 = 0;
        if (j3 != 0) {
            iSafeUnbox2 = ViewDataBinding.safeUnbox(num);
            iSafeUnbox = ViewDataBinding.safeUnbox(num2);
        } else {
            iSafeUnbox = 0;
        }
        if (j3 != 0) {
            bc3.a(this.g, iSafeUnbox2, iSafeUnbox);
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
        if (18 == i2) {
            d((Integer) obj);
        } else {
            if (21 != i2) {
                return false;
            }
            e((Integer) obj);
        }
        return true;
    }

    public ActivityOnlineStatusBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MyActionBar) objArr[2], (TextView) objArr[4], (RecyclerView) objArr[5], (RecyclerView) objArr[3]);
        this.h = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.g = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
