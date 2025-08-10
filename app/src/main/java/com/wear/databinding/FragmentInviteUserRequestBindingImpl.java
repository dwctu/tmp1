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
import com.lovense.wear.R;
import com.wear.bean.InviteRequestInfo;
import dc.iu1;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public class FragmentInviteUserRequestBindingImpl extends FragmentInviteUserRequestBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final CircleImageView e;
    public long f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h = sparseIntArray;
        sparseIntArray.put(R.id.content, 2);
        sparseIntArray.put(R.id.request, 3);
        sparseIntArray.put(R.id.close, 4);
    }

    public FragmentInviteUserRequestBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, g, h));
    }

    @Override // com.wear.databinding.FragmentInviteUserRequestBinding
    public void d(@Nullable InviteRequestInfo inviteRequestInfo) {
        this.c = inviteRequestInfo;
        synchronized (this) {
            this.f |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f;
            this.f = 0L;
        }
        String avatarUrl = null;
        InviteRequestInfo inviteRequestInfo = this.c;
        long j2 = j & 3;
        if (j2 != 0 && inviteRequestInfo != null) {
            avatarUrl = inviteRequestInfo.getAvatarUrl();
        }
        if (j2 != 0) {
            CircleImageView circleImageView = this.e;
            iu1.c(circleImageView, avatarUrl, AppCompatResources.getDrawable(circleImageView.getContext(), R.drawable.chat_avatar_default));
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
        if (5 != i) {
            return false;
        }
        d((InviteRequestInfo) obj);
        return true;
    }

    public FragmentInviteUserRequestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[3]);
        this.f = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.d = linearLayout;
        linearLayout.setTag(null);
        CircleImageView circleImageView = (CircleImageView) objArr[1];
        this.e = circleImageView;
        circleImageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
