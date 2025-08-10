package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.roundwidget.SkinRoundTextView;

/* loaded from: classes3.dex */
public class ActivityRouletteChatEndBindingImpl extends ActivityRouletteChatEndBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts j = null;

    @Nullable
    public static final SparseIntArray k;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;
    public long i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.actionbar, 3);
        sparseIntArray.put(R.id.reason_tv, 4);
        sparseIntArray.put(R.id.exit, 5);
        sparseIntArray.put(R.id.report, 6);
    }

    public ActivityRouletteChatEndBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, j, k));
    }

    @Override // com.wear.databinding.ActivityRouletteChatEndBinding
    public void d(@Nullable String str) {
        this.e = str;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.i;
            this.i = 0L;
        }
        String str = this.e;
        long j3 = 3 & j2;
        if ((j2 & 2) != 0) {
            TextView textView = this.g;
            TextViewBindingAdapter.setText(textView, textView.getResources().getString(R.string.control_roulette_duration, ""));
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.h, str);
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
        if (23 != i) {
            return false;
        }
        d((String) obj);
        return true;
    }

    public ActivityRouletteChatEndBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MyActionBar) objArr[3], (SkinRoundTextView) objArr[5], (TextView) objArr[4], (TextView) objArr[6]);
        this.i = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.g = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.h = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
