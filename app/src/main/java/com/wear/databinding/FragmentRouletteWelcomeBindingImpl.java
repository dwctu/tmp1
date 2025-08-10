package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.ui.discover.roulette.RouletteWelcomeFragment;
import com.wear.widget.SpreadView;
import dc.zu1;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class FragmentRouletteWelcomeBindingImpl extends FragmentRouletteWelcomeBinding implements zu1.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h;

    @NonNull
    public final SkinCompatConstraintLayout d;

    @Nullable
    public final View.OnClickListener e;
    public long f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h = sparseIntArray;
        sparseIntArray.put(R.id.round_view, 2);
        sparseIntArray.put(R.id.avatar, 3);
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.content, 5);
    }

    public FragmentRouletteWelcomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, g, h));
    }

    @Override // dc.zu1.a
    public final void a(int i, View view) {
        RouletteWelcomeFragment.b bVar = this.c;
        if (bVar != null) {
            bVar.a(view);
        }
    }

    @Override // com.wear.databinding.FragmentRouletteWelcomeBinding
    public void d(@Nullable RouletteWelcomeFragment.b bVar) {
        this.c = bVar;
        synchronized (this) {
            this.f |= 1;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f;
            this.f = 0L;
        }
        if ((j & 2) != 0) {
            this.b.setOnClickListener(this.e);
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
            this.f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (14 != i) {
            return false;
        }
        d((RouletteWelcomeFragment.b) obj);
        return true;
    }

    public FragmentRouletteWelcomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CircleImageView) objArr[3], (TextView) objArr[5], (TextView) objArr[1], (SpreadView) objArr[2], (TextView) objArr[4]);
        this.f = -1L;
        this.b.setTag(null);
        SkinCompatConstraintLayout skinCompatConstraintLayout = (SkinCompatConstraintLayout) objArr[0];
        this.d = skinCompatConstraintLayout;
        skinCompatConstraintLayout.setTag(null);
        setRootTag(view);
        this.e = new zu1(this, 1);
        invalidateAll();
    }
}
