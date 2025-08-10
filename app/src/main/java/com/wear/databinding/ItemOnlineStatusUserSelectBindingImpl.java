package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.me.OnlineStatusUserBean;
import com.wear.widget.RadiuImageView;
import dc.bc3;
import dc.iu1;
import dc.ut1;
import dc.wi1;

/* loaded from: classes3.dex */
public class ItemOnlineStatusUserSelectBindingImpl extends ItemOnlineStatusUserSelectBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts i = null;

    @Nullable
    public static final SparseIntArray j = null;

    @NonNull
    public final ImageView d;

    @NonNull
    public final RadiuImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;
    public long h;

    public ItemOnlineStatusUserSelectBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, i, j));
    }

    @Override // com.wear.databinding.ItemOnlineStatusUserSelectBinding
    public void b(@Nullable String str) {
        this.c = str;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ItemOnlineStatusUserSelectBinding
    public void c(@Nullable OnlineStatusUserBean onlineStatusUserBean) {
        this.b = onlineStatusUserBean;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String nickname;
        String str2;
        boolean isSelected;
        boolean z;
        boolean z2;
        String remark;
        String showName;
        synchronized (this) {
            j2 = this.h;
            this.h = 0L;
        }
        String str3 = this.c;
        OnlineStatusUserBean onlineStatusUserBean = this.b;
        long j3 = j2 & 7;
        String str4 = null;
        if (j3 != 0) {
            if (onlineStatusUserBean != null) {
                remark = onlineStatusUserBean.getRemark();
                nickname = onlineStatusUserBean.getNickname();
                showName = onlineStatusUserBean.getShowName();
            } else {
                remark = null;
                nickname = null;
                showName = null;
            }
            z = remark == null;
            if (j3 != 0) {
                j2 = z ? j2 | 16 : j2 | 8;
            }
            if ((j2 & 6) == 0 || onlineStatusUserBean == null) {
                str2 = null;
                isSelected = false;
            } else {
                String avatar = onlineStatusUserBean.getAvatar();
                isSelected = onlineStatusUserBean.getIsSelected();
                str2 = avatar;
            }
            str4 = remark;
            str = showName;
        } else {
            str = null;
            nickname = null;
            str2 = null;
            isSelected = false;
            z = false;
        }
        boolean zIsEmpty = ((8 & j2) == 0 || str4 == null) ? false : str4.isEmpty();
        long j4 = j2 & 7;
        if (j4 != 0) {
            if (z) {
                zIsEmpty = true;
            }
            if (j4 != 0) {
                j2 = zIsEmpty ? j2 | 256 : j2 | 128;
            }
        } else {
            zIsEmpty = false;
        }
        boolean z3 = (j2 & 128) != 0 && str3 == null;
        long j5 = j2 & 7;
        if (j5 != 0) {
            if (zIsEmpty) {
                z3 = true;
            }
            if (j5 != 0) {
                j2 = z3 ? j2 | 64 : j2 | 32;
            }
        } else {
            z3 = false;
        }
        boolean zIsEmpty2 = ((j2 & 32) == 0 || str3 == null) ? false : str3.isEmpty();
        long j6 = 7 & j2;
        if (j6 != 0) {
            z2 = z3 ? true : zIsEmpty2;
        } else {
            z2 = false;
        }
        if ((j2 & 6) != 0) {
            wi1.b(this.d, isSelected);
            RadiuImageView radiuImageView = this.e;
            iu1.d(radiuImageView, str2, AppCompatResources.getDrawable(radiuImageView.getContext(), R.drawable.chat_avatar_default));
        }
        if (j6 != 0) {
            bc3.c(this.f, str3, str);
            ut1.a(this.g, z2);
            bc3.d(this.g, str3, nickname);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (11 == i2) {
            b((String) obj);
        } else {
            if (15 != i2) {
                return false;
            }
            c((OnlineStatusUserBean) obj);
        }
        return true;
    }

    public ItemOnlineStatusUserSelectBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0]);
        this.h = -1L;
        this.a.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.d = imageView;
        imageView.setTag(null);
        RadiuImageView radiuImageView = (RadiuImageView) objArr[2];
        this.e = radiuImageView;
        radiuImageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.g = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
