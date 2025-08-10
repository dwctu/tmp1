package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.wear.bean.ConnectionGroupBean;
import dc.f83;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public class ItemConnectionsGroupBindingImpl extends ItemConnectionsGroupBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts f = null;

    @Nullable
    public static final SparseIntArray g = null;

    @NonNull
    public final SkinAutoRelativeLayout c;

    @NonNull
    public final TextView d;
    public long e;

    public ItemConnectionsGroupBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f, g));
    }

    @Override // com.wear.databinding.ItemConnectionsGroupBinding
    public void b(@Nullable ConnectionGroupBean connectionGroupBean) {
        this.b = connectionGroupBean;
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
        ConnectionGroupBean connectionGroupBean = this.b;
        long j2 = j & 3;
        String avatar = null;
        if (j2 == 0 || connectionGroupBean == null) {
            name = null;
        } else {
            avatar = connectionGroupBean.getAvatar();
            name = connectionGroupBean.getName();
        }
        if (j2 != 0) {
            f83.b(this.a, avatar);
            TextViewBindingAdapter.setText(this.d, name);
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
        b((ConnectionGroupBean) obj);
        return true;
    }

    public ItemConnectionsGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CircleImageView) objArr[1]);
        this.e = -1L;
        this.a.setTag(null);
        SkinAutoRelativeLayout skinAutoRelativeLayout = (SkinAutoRelativeLayout) objArr[0];
        this.c = skinAutoRelativeLayout;
        skinAutoRelativeLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.d = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
