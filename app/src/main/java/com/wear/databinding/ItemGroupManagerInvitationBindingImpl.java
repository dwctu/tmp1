package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.lovense.wear.R;
import com.wear.bean.GroupMemberRequest;
import com.wear.widget.RadiuImageView;
import dc.i82;
import dc.iu1;

/* loaded from: classes3.dex */
public class ItemGroupManagerInvitationBindingImpl extends ItemGroupManagerInvitationBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h;

    @NonNull
    public final RelativeLayout e;
    public long f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h = sparseIntArray;
        sparseIntArray.put(R.id.btn_user_accept, 4);
        sparseIntArray.put(R.id.btn_user_reject, 5);
    }

    public ItemGroupManagerInvitationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, g, h));
    }

    @Override // com.wear.databinding.ItemGroupManagerInvitationBinding
    public void d(@Nullable GroupMemberRequest groupMemberRequest) {
        this.d = groupMemberRequest;
        synchronized (this) {
            this.f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String inviteBy;
        String name;
        String avatar;
        synchronized (this) {
            j = this.f;
            this.f = 0L;
        }
        GroupMemberRequest groupMemberRequest = this.d;
        int iSafeUnbox = 0;
        long j2 = j & 3;
        String str = null;
        Integer type = null;
        if (j2 != 0) {
            if (groupMemberRequest != null) {
                avatar = groupMemberRequest.getAvatar();
                inviteBy = groupMemberRequest.getInviteBy();
                name = groupMemberRequest.getName();
                type = groupMemberRequest.getType();
            } else {
                avatar = null;
                inviteBy = null;
                name = null;
            }
            iSafeUnbox = ViewDataBinding.safeUnbox(type);
            str = avatar;
        } else {
            inviteBy = null;
            name = null;
        }
        if (j2 != 0) {
            RadiuImageView radiuImageView = this.a;
            iu1.d(radiuImageView, str, AppCompatResources.getDrawable(radiuImageView.getContext(), R.drawable.chat_avatar_default));
            i82.a(this.b, iSafeUnbox, inviteBy);
            TextViewBindingAdapter.setText(this.c, name);
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
        if (10 != i) {
            return false;
        }
        d((GroupMemberRequest) obj);
        return true;
    }

    public ItemGroupManagerInvitationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (ImageView) objArr[5], (RadiuImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.f = -1L;
        this.a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.e = relativeLayout;
        relativeLayout.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
