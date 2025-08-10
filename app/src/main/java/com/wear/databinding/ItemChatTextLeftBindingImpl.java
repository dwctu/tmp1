package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import com.wear.ui.chat.adapter.ChatAdapter;
import com.wear.util.HttpTextView;
import com.wear.widget.SkinLottieAnimationView;
import dc.ie3;

/* loaded from: classes3.dex */
public class ItemChatTextLeftBindingImpl extends ItemChatTextLeftBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts l = null;

    @Nullable
    public static final SparseIntArray m;

    @NonNull
    public final ConstraintLayout j;
    public long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.layout_new_message_notice, 5);
        sparseIntArray.put(R.id.chat_item_time_create, 6);
        sparseIntArray.put(R.id.avatar, 7);
        sparseIntArray.put(R.id.content_container, 8);
    }

    public ItemChatTextLeftBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, l, m));
    }

    @Override // com.wear.databinding.ItemChatTextLeftBinding
    public void d(@Nullable Integer num) {
        this.e = num;
        synchronized (this) {
            this.k |= 8;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ItemChatTextLeftBinding
    public void e(@Nullable ie3 ie3Var) {
        this.h = ie3Var;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.k     // Catch: java.lang.Throwable -> L8f
            r4 = 0
            r1.k = r4     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r22)     // Catch: java.lang.Throwable -> L8f
            java.lang.Boolean r0 = r1.f
            dc.ie3 r6 = r1.h
            com.wear.ui.chat.adapter.ChatAdapter$a r7 = r1.i
            java.lang.Integer r8 = r1.e
            com.wear.bean.chat.Message r9 = r1.g
            r10 = 33
            long r10 = r10 & r2
            r12 = 0
            int r13 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r13 == 0) goto L2b
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox(r0)
            r10 = r0 ^ 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox(r10)
            goto L2d
        L2b:
            r0 = 0
            r10 = 0
        L2d:
            r14 = 62
            long r14 = r14 & r2
            r16 = 58
            r18 = 48
            int r11 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r11 == 0) goto L5c
            int r8 = androidx.databinding.ViewDataBinding.safeUnbox(r8)
            long r14 = r2 & r16
            int r20 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r20 == 0) goto L4e
            if (r9 == 0) goto L49
            int r14 = r9.getDirection()
            goto L4a
        L49:
            r14 = 0
        L4a:
            if (r14 != 0) goto L4e
            r14 = 1
            goto L4f
        L4e:
            r14 = 0
        L4f:
            long r20 = r2 & r18
            int r15 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r15 == 0) goto L5e
            if (r9 == 0) goto L5e
            boolean r12 = r9.getIsSelected()
            goto L5e
        L5c:
            r8 = 0
            r14 = 0
        L5e:
            long r18 = r2 & r18
            int r15 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r15 == 0) goto L69
            android.widget.ImageView r15 = r1.a
            dc.wi1.b(r15, r12)
        L69:
            if (r13 == 0) goto L75
            android.widget.ImageView r12 = r1.a
            dc.wi1.c(r12, r0)
            com.wear.util.HttpTextView r0 = r1.d
            r0.setOpenRegionUrl(r10)
        L75:
            long r2 = r2 & r16
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L87
            android.widget.ImageView r0 = r1.b
            com.wear.widget.SkinLottieAnimationView r2 = r1.c
            dc.ws2.b(r0, r9, r6, r8, r2)
            com.wear.util.HttpTextView r0 = r1.d
            dc.ws2.c(r0, r9, r6, r8, r14)
        L87:
            if (r11 == 0) goto L8e
            com.wear.widget.SkinLottieAnimationView r0 = r1.c
            dc.ws2.a(r0, r9, r6, r8, r7)
        L8e:
            return
        L8f:
            r0 = move-exception
            monitor-exit(r22)     // Catch: java.lang.Throwable -> L8f
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.databinding.ItemChatTextLeftBindingImpl.executeBindings():void");
    }

    @Override // com.wear.databinding.ItemChatTextLeftBinding
    public void f(@Nullable Boolean bool) {
        this.f = bool;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ItemChatTextLeftBinding
    public void g(@Nullable ChatAdapter.a aVar) {
        this.i = aVar;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ItemChatTextLeftBinding
    public void h(@Nullable Message message) {
        this.g = message;
        synchronized (this) {
            this.k |= 16;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (9 == i) {
            f((Boolean) obj);
        } else if (3 == i) {
            e((ie3) obj);
        } else if (13 == i) {
            g((ChatAdapter.a) obj);
        } else if (2 == i) {
            d((Integer) obj);
        } else {
            if (16 != i) {
                return false;
            }
            h((Message) obj);
        }
        return true;
    }

    public ItemChatTextLeftBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[7], (TextView) objArr[6], (ImageView) objArr[1], (FrameLayout) objArr[8], (ImageView) objArr[3], (LinearLayout) objArr[5], (SkinLottieAnimationView) objArr[4], (HttpTextView) objArr[2]);
        this.k = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.j = constraintLayout;
        constraintLayout.setTag("item_root");
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
