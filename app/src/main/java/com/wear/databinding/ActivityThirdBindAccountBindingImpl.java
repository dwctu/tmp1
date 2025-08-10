package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.main.account.login.ThirdBindViewModel;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.roundwidget.SkinRoundTextView;
import skin.support.widget.SkinAutoFrameLayout;
import skin.support.widget.SkinAutoLinearLayout;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public class ActivityThirdBindAccountBindingImpl extends ActivityThirdBindAccountBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h;

    @NonNull
    public final SkinAutoRelativeLayout e;
    public long f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h = sparseIntArray;
        sparseIntArray.put(R.id.login_top_layout, 1);
        sparseIntArray.put(R.id.actionbar_back, 2);
        sparseIntArray.put(R.id.actionbar_title, 3);
        sparseIntArray.put(R.id.forget_above_layout, 4);
        sparseIntArray.put(R.id.ll_email, 5);
        sparseIntArray.put(R.id.et_email, 6);
        sparseIntArray.put(R.id.email_content_delete, 7);
        sparseIntArray.put(R.id.ll_verification_code, 8);
        sparseIntArray.put(R.id.et_password, 9);
        sparseIntArray.put(R.id.verification_code_content_delete, 10);
        sparseIntArray.put(R.id.btn_bind, 11);
    }

    public ActivityThirdBindAccountBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, g, h));
    }

    public void b(@Nullable ThirdBindViewModel thirdBindViewModel) {
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f = 0L;
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
        if (27 != i) {
            return false;
        }
        b((ThirdBindViewModel) obj);
        return true;
    }

    public ActivityThirdBindAccountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (MediumBoldTextView) objArr[3], (SkinRoundTextView) objArr[11], (ImageView) objArr[7], (EditText) objArr[6], (EditText) objArr[9], (SkinAutoLinearLayout) objArr[4], (SkinAutoLinearLayout) objArr[5], (SkinAutoLinearLayout) objArr[8], (SkinAutoFrameLayout) objArr[1], (ImageView) objArr[10]);
        this.f = -1L;
        SkinAutoRelativeLayout skinAutoRelativeLayout = (SkinAutoRelativeLayout) objArr[0];
        this.e = skinAutoRelativeLayout;
        skinAutoRelativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
