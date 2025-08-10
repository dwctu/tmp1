package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.lovense.wear.R;
import com.wear.bean.UserActionMenuBean;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import com.wear.widget.roundwidget.SkinRoundTextView;
import com.wear.widget.roundwidget.SkinRoundView;
import dc.f83;
import dc.wi1;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.widget.SkinAutoLinearLayout;

/* loaded from: classes3.dex */
public class FragmentLongUserActionMenuBindingImpl extends FragmentLongUserActionMenuBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts q = null;

    @Nullable
    public static final SparseIntArray r;

    @NonNull
    public final SkinRoundAutoLinearLayout i;

    @NonNull
    public final CircleImageView j;

    @NonNull
    public final SkinRoundTextView k;

    @NonNull
    public final SkinAutoLinearLayout l;

    @NonNull
    public final SkinRoundAutoLinearLayout m;

    @NonNull
    public final SkinAutoLinearLayout n;

    @NonNull
    public final SkinRoundView o;
    public long p;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r = sparseIntArray;
        sparseIntArray.put(R.id.black_setting, 12);
        sparseIntArray.put(R.id.clear_chat_message, 13);
    }

    public FragmentLongUserActionMenuBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, q, r));
    }

    @Override // com.wear.databinding.FragmentLongUserActionMenuBinding
    public void d(@Nullable UserActionMenuBean userActionMenuBean) {
        this.h = userActionMenuBean;
        synchronized (this) {
            this.p |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String nickname;
        int friendType;
        boolean isLeaveGroup;
        boolean isTop;
        boolean z;
        boolean z2;
        boolean isMuteNotification;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        long j2;
        long j3;
        synchronized (this) {
            j = this.p;
            this.p = 0L;
        }
        UserActionMenuBean userActionMenuBean = this.h;
        long j4 = j & 3;
        String avatar = null;
        if (j4 != 0) {
            if (userActionMenuBean != null) {
                isLeaveGroup = userActionMenuBean.getIsLeaveGroup();
                isTop = userActionMenuBean.getIsTop();
                avatar = userActionMenuBean.getAvatar();
                isMuteNotification = userActionMenuBean.getIsMuteNotification();
                nickname = userActionMenuBean.getNickname();
                friendType = userActionMenuBean.getFriendType();
            } else {
                nickname = null;
                friendType = 0;
                isLeaveGroup = false;
                isTop = false;
                isMuteNotification = false;
            }
            z3 = !isLeaveGroup;
            z4 = friendType == 1;
            boolean z8 = friendType == 0;
            z = friendType != 2;
            if (j4 != 0) {
                if (z4) {
                    j2 = j | 32;
                    j3 = 128;
                } else {
                    j2 = j | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            if ((j & 3) != 0) {
                j |= z8 ? 8L : 4L;
            }
            z2 = z8;
        } else {
            nickname = null;
            friendType = 0;
            isLeaveGroup = false;
            isTop = false;
            z = false;
            z2 = false;
            isMuteNotification = false;
            z3 = false;
            z4 = false;
        }
        long j5 = j & 3;
        if (j5 != 0) {
            z5 = z2 ? z3 : false;
            z7 = z4 ? z3 : false;
            z6 = z4 ? isLeaveGroup : false;
        } else {
            z5 = false;
            z6 = false;
            z7 = false;
        }
        if (j5 != 0) {
            wi1.c(this.c, z5);
            wi1.c(this.d, z6);
            wi1.c(this.e, z7);
            f83.c(this.j, avatar, friendType);
            TextViewBindingAdapter.setText(this.k, nickname);
            wi1.c(this.l, z3);
            wi1.c(this.m, z2);
            wi1.c(this.n, z3);
            wi1.c(this.o, z);
            wi1.b(this.f, isMuteNotification);
            wi1.c(this.f, z3);
            wi1.b(this.g, isTop);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (25 != i) {
            return false;
        }
        d((UserActionMenuBean) obj);
        return true;
    }

    public FragmentLongUserActionMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SkinRoundTextView) objArr[12], (SkinRoundTextView) objArr[13], (SkinRoundTextView) objArr[10], (SkinRoundTextView) objArr[6], (SkinRoundTextView) objArr[11], (SkinRoundTextView) objArr[5], (SkinRoundTextView) objArr[4]);
        this.p = -1L;
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = (SkinRoundAutoLinearLayout) objArr[0];
        this.i = skinRoundAutoLinearLayout;
        skinRoundAutoLinearLayout.setTag(null);
        CircleImageView circleImageView = (CircleImageView) objArr[1];
        this.j = circleImageView;
        circleImageView.setTag(null);
        SkinRoundTextView skinRoundTextView = (SkinRoundTextView) objArr[2];
        this.k = skinRoundTextView;
        skinRoundTextView.setTag(null);
        SkinAutoLinearLayout skinAutoLinearLayout = (SkinAutoLinearLayout) objArr[3];
        this.l = skinAutoLinearLayout;
        skinAutoLinearLayout.setTag(null);
        SkinRoundAutoLinearLayout skinRoundAutoLinearLayout2 = (SkinRoundAutoLinearLayout) objArr[7];
        this.m = skinRoundAutoLinearLayout2;
        skinRoundAutoLinearLayout2.setTag(null);
        SkinAutoLinearLayout skinAutoLinearLayout2 = (SkinAutoLinearLayout) objArr[8];
        this.n = skinAutoLinearLayout2;
        skinAutoLinearLayout2.setTag(null);
        SkinRoundView skinRoundView = (SkinRoundView) objArr[9];
        this.o = skinRoundView;
        skinRoundView.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
