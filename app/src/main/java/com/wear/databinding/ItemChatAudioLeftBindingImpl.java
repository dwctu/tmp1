package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import com.wear.ui.chat.widget.ChatAudioView;
import dc.ie3;

/* loaded from: classes3.dex */
public class ItemChatAudioLeftBindingImpl extends ItemChatAudioLeftBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts d = null;

    @Nullable
    public static final SparseIntArray e;

    @NonNull
    public final ConstraintLayout b;
    public long c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e = sparseIntArray;
        sparseIntArray.put(R.id.layout_new_message_notice, 1);
        sparseIntArray.put(R.id.chat_item_time_create, 2);
        sparseIntArray.put(R.id.avatar, 3);
        sparseIntArray.put(R.id.chat_audio_view, 4);
    }

    public ItemChatAudioLeftBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, d, e));
    }

    @Override // com.wear.databinding.ItemChatAudioLeftBinding
    public void d(@Nullable Message message) {
    }

    public void e(@Nullable ie3 ie3Var) {
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.c = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.c != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.c = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (3 == i) {
            e((ie3) obj);
        } else {
            if (16 != i) {
                return false;
            }
            d((Message) obj);
        }
        return true;
    }

    public ItemChatAudioLeftBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ChatAudioView) objArr[4], (TextView) objArr[2], (LinearLayout) objArr[1]);
        this.c = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag("item_root");
        setRootTag(view);
        invalidateAll();
    }
}
