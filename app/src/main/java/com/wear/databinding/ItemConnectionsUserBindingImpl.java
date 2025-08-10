package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.wear.bean.ConnectionUserBean;
import com.wear.widget.SquareView;
import dc.f83;
import dc.wi1;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.widget.SkinAutoFrameLayout;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public class ItemConnectionsUserBindingImpl extends ItemConnectionsUserBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts j = null;

    @Nullable
    public static final SparseIntArray k = null;

    @NonNull
    public final SkinAutoRelativeLayout f;

    @NonNull
    public final SquareView g;

    @NonNull
    public final SquareView h;
    public long i;

    public ItemConnectionsUserBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, j, k));
    }

    @Override // com.wear.databinding.ItemConnectionsUserBinding
    public void b(@Nullable ConnectionUserBean connectionUserBean) {
        this.e = connectionUserBean;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String name;
        boolean z;
        boolean zIsOfficialAccount;
        boolean z2;
        int onlineStatus;
        synchronized (this) {
            j2 = this.i;
            this.i = 0L;
        }
        ConnectionUserBean connectionUserBean = this.e;
        long j3 = j2 & 3;
        String avatar = null;
        if (j3 != 0) {
            if (connectionUserBean != null) {
                avatar = connectionUserBean.getAvatar();
                onlineStatus = connectionUserBean.getOnlineStatus();
                name = connectionUserBean.getName();
                zIsOfficialAccount = connectionUserBean.isOfficialAccount();
            } else {
                name = null;
                onlineStatus = 0;
                zIsOfficialAccount = false;
            }
            boolean z3 = onlineStatus != 0;
            z2 = onlineStatus == 2;
            z = onlineStatus == 1;
            z = z3;
        } else {
            name = null;
            z = false;
            zIsOfficialAccount = false;
            z2 = false;
        }
        if (j3 != 0) {
            f83.a(this.a, avatar);
            wi1.c(this.b, z);
            wi1.c(this.c, zIsOfficialAccount);
            wi1.c(this.g, z);
            wi1.c(this.h, z2);
            TextViewBindingAdapter.setText(this.d, name);
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
        if (10 != i) {
            return false;
        }
        b((ConnectionUserBean) obj);
        return true;
    }

    public ItemConnectionsUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CircleImageView) objArr[1], (SkinAutoFrameLayout) objArr[2], (ImageView) objArr[6], (TextView) objArr[5]);
        this.i = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        SkinAutoRelativeLayout skinAutoRelativeLayout = (SkinAutoRelativeLayout) objArr[0];
        this.f = skinAutoRelativeLayout;
        skinAutoRelativeLayout.setTag(null);
        SquareView squareView = (SquareView) objArr[3];
        this.g = squareView;
        squareView.setTag(null);
        SquareView squareView2 = (SquareView) objArr[4];
        this.h = squareView2;
        squareView2.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
