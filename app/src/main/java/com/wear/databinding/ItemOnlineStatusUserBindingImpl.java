package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.lovense.wear.R;
import com.wear.bean.me.OnlineStatusUserBean;
import com.wear.widget.RadiuImageView;
import com.wear.widget.swipe.EasySwipeMenuLayout;
import dc.iu1;

/* loaded from: classes3.dex */
public class ItemOnlineStatusUserBindingImpl extends ItemOnlineStatusUserBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts f = null;

    @Nullable
    public static final SparseIntArray g;

    @NonNull
    public final RadiuImageView c;

    @NonNull
    public final TextView d;
    public long e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        g = sparseIntArray;
        sparseIntArray.put(R.id.content_container, 3);
        sparseIntArray.put(R.id.tv_delete, 4);
    }

    public ItemOnlineStatusUserBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f, g));
    }

    @Override // com.wear.databinding.ItemOnlineStatusUserBinding
    public void b(@Nullable OnlineStatusUserBean onlineStatusUserBean) {
        this.b = onlineStatusUserBean;
        synchronized (this) {
            this.e |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.e;
            this.e = 0L;
        }
        OnlineStatusUserBean onlineStatusUserBean = this.b;
        long j2 = j & 3;
        String avatar = null;
        if (j2 == 0 || onlineStatusUserBean == null) {
            str = null;
        } else {
            String showName = onlineStatusUserBean.getShowName();
            avatar = onlineStatusUserBean.getAvatar();
            str = showName;
        }
        if (j2 != 0) {
            RadiuImageView radiuImageView = this.c;
            iu1.d(radiuImageView, avatar, AppCompatResources.getDrawable(radiuImageView.getContext(), R.drawable.chat_avatar_default));
            TextViewBindingAdapter.setText(this.d, str);
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
        if (15 != i) {
            return false;
        }
        b((OnlineStatusUserBean) obj);
        return true;
    }

    public ItemOnlineStatusUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[3], (EasySwipeMenuLayout) objArr[0], (TextView) objArr[4]);
        this.e = -1L;
        RadiuImageView radiuImageView = (RadiuImageView) objArr[1];
        this.c = radiuImageView;
        radiuImageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.d = textView;
        textView.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
