package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.bean.RouletteSettingBean;
import com.wear.bean.RouletteStatus;
import com.wear.ui.discover.roulette.RouletteHomeFragment;
import com.wear.widget.SpreadView;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import dc.oy2;
import dc.ut1;
import dc.zu1;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class FragmentRouletteHomeBindingImpl extends FragmentRouletteHomeBinding implements zu1.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts r = null;

    @Nullable
    public static final SparseIntArray s;

    @NonNull
    public final SkinCompatConstraintLayout l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @Nullable
    public final View.OnClickListener o;

    @Nullable
    public final View.OnClickListener p;
    public long q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        s = sparseIntArray;
        sparseIntArray.put(R.id.round_view, 5);
        sparseIntArray.put(R.id.avatar, 6);
        sparseIntArray.put(R.id.search_container, 7);
        sparseIntArray.put(R.id.iv_roulette_roulette_home_search, 8);
        sparseIntArray.put(R.id.lottie_roulette_home_search, 9);
        sparseIntArray.put(R.id.bg_roulette_home_bottom, 10);
        sparseIntArray.put(R.id.ban_container_view, 11);
        sparseIntArray.put(R.id.tv_ban_hint, 12);
    }

    public FragmentRouletteHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, r, s));
    }

    @Override // dc.zu1.a
    public final void a(int i, View view) {
        if (i == 1) {
            RouletteHomeFragment.b bVar = this.k;
            if (bVar != null) {
                bVar.b(view);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        RouletteHomeFragment.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(view);
        }
    }

    @Override // com.wear.databinding.FragmentRouletteHomeBinding
    public void d(@Nullable RouletteHomeFragment.b bVar) {
        this.k = bVar;
        synchronized (this) {
            this.q |= 4;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // com.wear.databinding.FragmentRouletteHomeBinding
    public void e(@Nullable ObservableField<RouletteSettingBean> observableField) {
        updateRegistration(0, observableField);
        this.j = observableField;
        synchronized (this) {
            this.q |= 1;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zIsGenderSet;
        boolean z;
        synchronized (this) {
            j = this.q;
            this.q = 0L;
        }
        RouletteStatus rouletteStatus = this.i;
        ObservableField<RouletteSettingBean> observableField = this.j;
        long j2 = 10 & j;
        long j3 = 9 & j;
        if (j3 != 0) {
            RouletteSettingBean rouletteSettingBean = observableField != null ? observableField.get() : null;
            zIsGenderSet = rouletteSettingBean != null ? rouletteSettingBean.isGenderSet() : false;
            z = !zIsGenderSet;
        } else {
            zIsGenderSet = false;
            z = false;
        }
        if ((j & 8) != 0) {
            this.m.setOnClickListener(this.o);
            this.n.setOnClickListener(this.p);
        }
        if (j3 != 0) {
            this.m.setSelected(z);
            ut1.a(this.h, zIsGenderSet);
        }
        if (j2 != 0) {
            oy2.d(this.g, rouletteStatus, false);
        }
    }

    @Override // com.wear.databinding.FragmentRouletteHomeBinding
    public void f(@Nullable RouletteStatus rouletteStatus) {
        this.i = rouletteStatus;
        synchronized (this) {
            this.q |= 2;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    public final boolean g(ObservableField<RouletteSettingBean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.q != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.q = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return g((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (22 == i) {
            f((RouletteStatus) obj);
        } else if (14 == i) {
            d((RouletteHomeFragment.b) obj);
        } else {
            if (20 != i) {
                return false;
            }
            e((ObservableField) obj);
        }
        return true;
    }

    public FragmentRouletteHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CircleImageView) objArr[6], (SkinRoundAutoLinearLayout) objArr[11], (ImageView) objArr[10], (ImageView) objArr[8], (LottieAnimationView) objArr[9], (SpreadView) objArr[5], (FrameLayout) objArr[7], (TextView) objArr[12], (TextView) objArr[1], (TextView) objArr[2]);
        this.q = -1L;
        SkinCompatConstraintLayout skinCompatConstraintLayout = (SkinCompatConstraintLayout) objArr[0];
        this.l = skinCompatConstraintLayout;
        skinCompatConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.m = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.n = textView2;
        textView2.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        this.o = new zu1(this, 1);
        this.p = new zu1(this, 2);
        invalidateAll();
    }
}
