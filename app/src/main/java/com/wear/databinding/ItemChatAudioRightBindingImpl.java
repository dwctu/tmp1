package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import com.wear.ui.chat.widget.ChatAudioView;
import dc.ie3;
import dc.ut1;

/* loaded from: classes3.dex */
public class ItemChatAudioRightBindingImpl extends ItemChatAudioRightBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts g = null;

    @Nullable
    public static final SparseIntArray h;

    @NonNull
    public final ConstraintLayout e;
    public long f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h = sparseIntArray;
        sparseIntArray.put(R.id.layout_new_message_notice, 3);
        sparseIntArray.put(R.id.chat_item_time_create, 4);
        sparseIntArray.put(R.id.avatar, 5);
        sparseIntArray.put(R.id.chat_audio_view, 6);
    }

    public ItemChatAudioRightBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, g, h));
    }

    @Override // com.wear.databinding.ItemChatAudioRightBinding
    public void d(@Nullable Message message) {
        this.d = message;
        synchronized (this) {
            this.f |= 1;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    public void e(@Nullable ie3 ie3Var) {
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        synchronized (this) {
            j = this.f;
            this.f = 0L;
        }
        Message message = this.d;
        long j2 = j & 5;
        boolean z2 = false;
        if (j2 != 0) {
            int iSafeUnbox = ViewDataBinding.safeUnbox(message != null ? message.getSendStatus() : null);
            z = iSafeUnbox != 0;
            if (iSafeUnbox != 2) {
                z2 = true;
            }
        } else {
            z = false;
        }
        if (j2 != 0) {
            ut1.a(this.a, z2);
            ut1.a(this.c, z);
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
            this.f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (16 == i) {
            d((Message) obj);
        } else {
            if (3 != i) {
                return false;
            }
            e((ie3) obj);
        }
        return true;
    }

    public ItemChatAudioRightBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (ImageView) objArr[2], (ChatAudioView) objArr[6], (TextView) objArr[4], (LinearLayout) objArr[3], (ProgressBar) objArr[1]);
        this.f = -1L;
        this.a.setTag(null);
        this.c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.e = constraintLayout;
        constraintLayout.setTag("item_root");
        setRootTag(view);
        invalidateAll();
    }
}
