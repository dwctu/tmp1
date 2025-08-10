package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import dc.ut1;
import dc.wi1;
import dc.ws2;

/* loaded from: classes3.dex */
public class ItemChatTextRightBindingImpl extends ItemChatTextRightBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts n = null;

    @Nullable
    public static final SparseIntArray o;

    @NonNull
    public final ConstraintLayout l;
    public long m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R.id.layout_new_message_notice, 7);
        sparseIntArray.put(R.id.chat_item_time_create, 8);
        sparseIntArray.put(R.id.avatar, 9);
        sparseIntArray.put(R.id.content_container, 10);
    }

    public ItemChatTextRightBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, n, o));
    }

    @Override // com.wear.databinding.ItemChatTextRightBinding
    public void d(@Nullable Integer num) {
        this.g = num;
        synchronized (this) {
            this.m |= 8;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ItemChatTextRightBinding
    public void e(@Nullable ie3 ie3Var) {
        this.j = ie3Var;
        synchronized (this) {
            this.m |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        ChatAdapter.a aVar;
        boolean z;
        boolean z2;
        int iSafeUnbox;
        boolean z3;
        boolean isSelected;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j = this.m;
            this.m = 0L;
        }
        Boolean bool = this.h;
        Integer sendStatus = null;
        ie3 ie3Var = this.j;
        ChatAdapter.a aVar2 = this.k;
        Integer num = this.g;
        Message message = this.i;
        long j2 = 33 & j;
        if (j2 != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
        } else {
            zSafeUnbox = false;
            zSafeUnbox2 = false;
        }
        long j3 = 62 & j;
        if (j3 != 0) {
            iSafeUnbox = ViewDataBinding.safeUnbox(num);
            long j4 = j & 58;
            if ((j & 48) != 0) {
                if (message != null) {
                    sendStatus = message.getSendStatus();
                    isSelected = message.getIsSelected();
                } else {
                    isSelected = false;
                }
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(sendStatus);
                z5 = iSafeUnbox2 != 0;
                z4 = iSafeUnbox2 != 2;
            } else {
                z4 = false;
                isSelected = false;
                z5 = false;
            }
            if (j4 != 0) {
                z3 = z4;
                z = z5;
                aVar = aVar2;
                z2 = (message != null ? message.getDirection() : 0) == 0;
            } else {
                z3 = z4;
                z = z5;
                aVar = aVar2;
                z2 = false;
            }
        } else {
            aVar = aVar2;
            z = false;
            z2 = false;
            iSafeUnbox = 0;
            z3 = false;
            isSelected = false;
        }
        if ((j & 48) != 0) {
            ut1.a(this.a, z3);
            wi1.b(this.b, isSelected);
            ut1.a(this.d, z);
        }
        if (j2 != 0) {
            wi1.c(this.b, zSafeUnbox);
            this.f.setOpenRegionUrl(zSafeUnbox2);
        }
        if ((j & 58) != 0) {
            ws2.b(this.c, message, ie3Var, iSafeUnbox, this.e);
            ws2.c(this.f, message, ie3Var, iSafeUnbox, z2);
        }
        if (j3 != 0) {
            ws2.a(this.e, message, ie3Var, iSafeUnbox, aVar);
        }
    }

    @Override // com.wear.databinding.ItemChatTextRightBinding
    public void f(@Nullable Boolean bool) {
        this.h = bool;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ItemChatTextRightBinding
    public void g(@Nullable ChatAdapter.a aVar) {
        this.k = aVar;
        synchronized (this) {
            this.m |= 4;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.wear.databinding.ItemChatTextRightBinding
    public void h(@Nullable Message message) {
        this.i = message;
        synchronized (this) {
            this.m |= 16;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 32L;
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

    public ItemChatTextRightBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[9], (ImageView) objArr[5], (TextView) objArr[8], (ImageView) objArr[6], (FrameLayout) objArr[10], (ImageView) objArr[2], (LinearLayout) objArr[7], (ProgressBar) objArr[4], (SkinLottieAnimationView) objArr[3], (HttpTextView) objArr[1]);
        this.m = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.l = constraintLayout;
        constraintLayout.setTag("item_root");
        this.e.setTag(null);
        this.f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
