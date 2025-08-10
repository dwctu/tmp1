package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.RouletteStatus;
import com.wear.ui.discover.roulette.RouletteResultFragment;
import com.wear.ui.discover.roulette.widget.RoundProgressBar;
import com.wear.widget.RadarScanView;
import dc.oy2;
import dc.ut1;
import dc.zu1;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class FragmentRouletteResultBindingImpl extends FragmentRouletteResultBinding implements zu1.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts l = null;

    @Nullable
    public static final SparseIntArray m;

    @NonNull
    public final SkinCompatConstraintLayout h;

    @NonNull
    public final LinearLayout i;

    @Nullable
    public final View.OnClickListener j;
    public long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.avatar, 5);
        sparseIntArray.put(R.id.round_progress_bar, 6);
    }

    public FragmentRouletteResultBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, l, m));
    }

    @Override // dc.zu1.a
    public final void a(int i, View view) {
        RouletteResultFragment.b bVar = this.g;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.wear.databinding.FragmentRouletteResultBinding
    public void d(@Nullable RouletteResultFragment.b bVar) {
        this.g = bVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // com.wear.databinding.FragmentRouletteResultBinding
    public void e(@Nullable RouletteStatus rouletteStatus) {
        this.f = rouletteStatus;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        RouletteStatus rouletteStatus = this.f;
        long j2 = j & 5;
        boolean z3 = false;
        if (j2 != 0) {
            z2 = rouletteStatus instanceof RouletteStatus.MatchSuccess;
            z = !(rouletteStatus instanceof RouletteStatus.Matching);
            if (j2 != 0) {
                j = z ? j | 16 : j | 8;
            }
        } else {
            z = false;
            z2 = false;
        }
        boolean z4 = (16 & j) != 0 ? !(rouletteStatus instanceof RouletteStatus.MatchFailedOtherUserDeclined) : false;
        long j3 = 5 & j;
        if (j3 != 0 && z) {
            z3 = z4;
        }
        if ((j & 4) != 0) {
            this.i.setOnClickListener(this.j);
        }
        if (j3 != 0) {
            ut1.a(this.i, z3);
            oy2.c(this.b, z2);
            oy2.d(this.d, rouletteStatus, true);
            oy2.b(this.e, rouletteStatus);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (22 == i) {
            e((RouletteStatus) obj);
        } else {
            if (14 != i) {
                return false;
            }
            d((RouletteResultFragment.b) obj);
        }
        return true;
    }

    public FragmentRouletteResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CircleImageView) objArr[5], (RadarScanView) objArr[1], (RoundProgressBar) objArr[6], (TextView) objArr[2], (TextView) objArr[3]);
        this.k = -1L;
        SkinCompatConstraintLayout skinCompatConstraintLayout = (SkinCompatConstraintLayout) objArr[0];
        this.h = skinCompatConstraintLayout;
        skinCompatConstraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[4];
        this.i = linearLayout;
        linearLayout.setTag(null);
        this.b.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        setRootTag(view);
        this.j = new zu1(this, 1);
        invalidateAll();
    }
}
