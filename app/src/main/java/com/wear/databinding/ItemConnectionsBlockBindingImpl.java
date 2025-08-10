package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.ConnectionBlockBean;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public class ItemConnectionsBlockBindingImpl extends ItemConnectionsBlockBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts f = null;

    @Nullable
    public static final SparseIntArray g = null;

    @NonNull
    public final SkinAutoRelativeLayout c;

    @NonNull
    public final TextView d;
    public long e;

    public ItemConnectionsBlockBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f, g));
    }

    @Override // com.wear.databinding.ItemConnectionsBlockBinding
    public void b(@Nullable ConnectionBlockBean connectionBlockBean) {
        this.b = connectionBlockBean;
        synchronized (this) {
            this.e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.e     // Catch: java.lang.Throwable -> L8a
            r4 = 0
            r1.e = r4     // Catch: java.lang.Throwable -> L8a
            monitor-exit(r21)     // Catch: java.lang.Throwable -> L8a
            com.wear.bean.ConnectionBlockBean r0 = r1.b
            r6 = 3
            long r8 = r2 & r6
            r10 = 16
            r12 = 1
            r13 = 0
            r14 = 0
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L38
            if (r0 == 0) goto L24
            java.lang.String r8 = r0.getAvatar()
            java.lang.String r9 = r0.getRemarks()
            goto L26
        L24:
            r8 = r13
            r9 = r8
        L26:
            if (r9 != 0) goto L2b
            r16 = 1
            goto L2d
        L2b:
            r16 = 0
        L2d:
            if (r15 == 0) goto L3c
            if (r16 == 0) goto L36
            r17 = 32
            long r2 = r2 | r17
            goto L3c
        L36:
            long r2 = r2 | r10
            goto L3c
        L38:
            r8 = r13
            r9 = r8
            r16 = 0
        L3c:
            long r10 = r10 & r2
            int r15 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r15 == 0) goto L4d
            if (r9 == 0) goto L48
            int r10 = r9.length()
            goto L49
        L48:
            r10 = 0
        L49:
            if (r10 != 0) goto L4d
            r10 = 1
            goto L4e
        L4d:
            r10 = 0
        L4e:
            long r17 = r2 & r6
            r19 = 8
            int r11 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r11 == 0) goto L65
            if (r16 == 0) goto L59
            goto L5a
        L59:
            r12 = r10
        L5a:
            if (r11 == 0) goto L64
            if (r12 == 0) goto L61
            long r2 = r2 | r19
            goto L64
        L61:
            r10 = 4
            long r2 = r2 | r10
        L64:
            r14 = r12
        L65:
            long r10 = r2 & r19
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L72
            if (r0 == 0) goto L72
            java.lang.String r0 = r0.getName()
            goto L73
        L72:
            r0 = r13
        L73:
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L7d
            if (r14 == 0) goto L7c
            r13 = r0
            goto L7d
        L7c:
            r13 = r9
        L7d:
            if (r6 == 0) goto L89
            de.hdodenhof.circleimageview.CircleImageView r0 = r1.a
            dc.f83.a(r0, r8)
            android.widget.TextView r0 = r1.d
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r13)
        L89:
            return
        L8a:
            r0 = move-exception
            monitor-exit(r21)     // Catch: java.lang.Throwable -> L8a
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.databinding.ItemConnectionsBlockBindingImpl.executeBindings():void");
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
        b((ConnectionBlockBean) obj);
        return true;
    }

    public ItemConnectionsBlockBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
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
