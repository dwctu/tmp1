package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.ConnectionUserBean;
import com.wear.widget.roundwidget.SkinRoundTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public class ItemConnectionRequestBindingImpl extends ItemConnectionRequestBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;
    public long f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h = sparseIntArray;
        sparseIntArray.put(R.id.btn_user_reject, 4);
        sparseIntArray.put(R.id.btn_user_accept, 5);
    }

    public ItemConnectionRequestBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, g, h));
    }

    @Override // com.wear.databinding.ItemConnectionRequestBinding
    public void b(@Nullable ConnectionUserBean connectionUserBean) {
        this.c = connectionUserBean;
        synchronized (this) {
            this.f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.f     // Catch: java.lang.Throwable -> L71
            r4 = 0
            r1.f = r4     // Catch: java.lang.Throwable -> L71
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L71
            com.wear.bean.ConnectionUserBean r0 = r1.c
            r6 = 3
            long r8 = r2 & r6
            r10 = 1
            r11 = 8
            r13 = 0
            r14 = 0
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L3e
            if (r0 == 0) goto L2d
            java.lang.String r13 = r0.getAvatar()
            java.lang.String r8 = r0.getName()
            java.lang.String r0 = r0.getDesc()
            r17 = r13
            r13 = r0
            r0 = r17
            goto L2f
        L2d:
            r0 = r13
            r8 = r0
        L2f:
            if (r13 == 0) goto L33
            r9 = 1
            goto L34
        L33:
            r9 = 0
        L34:
            if (r15 == 0) goto L41
            if (r9 == 0) goto L3a
            long r2 = r2 | r11
            goto L41
        L3a:
            r15 = 4
            long r2 = r2 | r15
            goto L41
        L3e:
            r0 = r13
            r8 = r0
            r9 = 0
        L41:
            long r11 = r11 & r2
            int r15 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r15 == 0) goto L51
            if (r13 == 0) goto L4d
            int r11 = r13.length()
            goto L4e
        L4d:
            r11 = 0
        L4e:
            if (r11 <= 0) goto L51
            goto L52
        L51:
            r10 = 0
        L52:
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L5a
            if (r9 == 0) goto L5a
            r14 = r10
        L5a:
            if (r6 == 0) goto L70
            de.hdodenhof.circleimageview.CircleImageView r2 = r1.a
            dc.f83.a(r2, r0)
            android.widget.TextView r0 = r1.d
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r8)
            android.widget.TextView r0 = r1.e
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r13)
            android.widget.TextView r0 = r1.e
            dc.wi1.c(r0, r14)
        L70:
            return
        L71:
            r0 = move-exception
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L71
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.databinding.ItemConnectionRequestBindingImpl.executeBindings():void");
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
        b((ConnectionUserBean) obj);
        return true;
    }

    public ItemConnectionRequestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CircleImageView) objArr[1], (SkinRoundTextView) objArr[5], (ImageView) objArr[4], (SkinAutoRelativeLayout) objArr[0]);
        this.f = -1L;
        this.a.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.d = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.e = textView2;
        textView2.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
