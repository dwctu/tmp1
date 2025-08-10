package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.FindMatchUserBean;
import com.wear.ui.discover.roulette.widget.RouletteToyAndPlaysView;
import com.wear.ui.discover.roulette.widget.RoundProgressBar;

/* loaded from: classes3.dex */
public class FragmentRouletteMatchSuccessBindingImpl extends FragmentRouletteMatchSuccessBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts n = null;

    @Nullable
    public static final SparseIntArray o;

    @NonNull
    public final ConstraintLayout l;
    public long m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.container_card, 9);
        sparseIntArray.put(R.id.round_progress_bar, 10);
    }

    public FragmentRouletteMatchSuccessBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, n, o));
    }

    @Override // com.wear.databinding.FragmentRouletteMatchSuccessBinding
    public void d(@Nullable FindMatchUserBean findMatchUserBean) {
        this.j = findMatchUserBean;
        synchronized (this) {
            this.m |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.wear.databinding.FragmentRouletteMatchSuccessBinding
    public void e(@Nullable Boolean bool) {
        this.k = bool;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008c A[PHI: r15
  0x008c: PHI (r15v2 java.lang.String) = (r15v1 java.lang.String), (r15v4 java.lang.String) binds: [B:35:0x007d, B:38:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.databinding.FragmentRouletteMatchSuccessBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (6 == i) {
            e((Boolean) obj);
            return true;
        }
        if (1 != i) {
            return false;
        }
        d((FindMatchUserBean) obj);
        return true;
    }

    public FragmentRouletteMatchSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[7], (TextView) objArr[8], (LinearLayout) objArr[6], (ConstraintLayout) objArr[9], (ImageView) objArr[2], (TextView) objArr[4], (TextView) objArr[5], (RoundProgressBar) objArr[10], (TextView) objArr[1], (RouletteToyAndPlaysView) objArr[3]);
        this.m = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.l = constraintLayout;
        constraintLayout.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
