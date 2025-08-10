package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.lovense.wear.R;
import com.wear.bean.GroupMemberAdmin;
import com.wear.widget.RadiuImageView;
import dc.iu1;

/* loaded from: classes3.dex */
public class ItemGroupManagerMemberBindingImpl extends ItemGroupManagerMemberBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts f = null;

    @Nullable
    public static final SparseIntArray g = null;

    @NonNull
    public final ConstraintLayout d;
    public long e;

    public ItemGroupManagerMemberBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f, g));
    }

    @Override // com.wear.databinding.ItemGroupManagerMemberBinding
    public void d(@Nullable GroupMemberAdmin groupMemberAdmin) {
        this.c = groupMemberAdmin;
        synchronized (this) {
            this.e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String name;
        synchronized (this) {
            j = this.e;
            this.e = 0L;
        }
        GroupMemberAdmin groupMemberAdmin = this.c;
        long j2 = j & 3;
        String avatar = null;
        if (j2 == 0 || groupMemberAdmin == null) {
            name = null;
        } else {
            avatar = groupMemberAdmin.getAvatar();
            name = groupMemberAdmin.getName();
        }
        if (j2 != 0) {
            RadiuImageView radiuImageView = this.a;
            iu1.d(radiuImageView, avatar, AppCompatResources.getDrawable(radiuImageView.getContext(), R.drawable.chat_avatar_default));
            TextViewBindingAdapter.setText(this.b, name);
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
            this.e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (10 != i) {
            return false;
        }
        d((GroupMemberAdmin) obj);
        return true;
    }

    public ItemGroupManagerMemberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RadiuImageView) objArr[1], (TextView) objArr[2]);
        this.e = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.d = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
