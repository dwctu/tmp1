package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.widget.roundwidget.SkinRoundTextView;
import skin.support.widget.SkinCompatLinearLayout;

/* loaded from: classes3.dex */
public class DialogGuideVideoBindingImpl extends DialogGuideVideoBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts f = null;

    @Nullable
    public static final SparseIntArray g;

    @NonNull
    public final SkinCompatLinearLayout d;
    public long e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        g = sparseIntArray;
        sparseIntArray.put(R.id.tv_description, 1);
        sparseIntArray.put(R.id.videoView, 2);
        sparseIntArray.put(R.id.tv_got_it, 3);
    }

    public DialogGuideVideoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f, g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.e = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public DialogGuideVideoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SkinRoundTextView) objArr[1], (SkinRoundTextView) objArr[3], (MyVideoView) objArr[2]);
        this.e = -1L;
        SkinCompatLinearLayout skinCompatLinearLayout = (SkinCompatLinearLayout) objArr[0];
        this.d = skinCompatLinearLayout;
        skinCompatLinearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
