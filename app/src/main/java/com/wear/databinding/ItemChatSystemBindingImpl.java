package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import dc.ws2;

/* loaded from: classes3.dex */
public class ItemChatSystemBindingImpl extends ItemChatSystemBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts e = null;

    @Nullable
    public static final SparseIntArray f;

    @NonNull
    public final LinearLayout c;
    public long d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f = sparseIntArray;
        sparseIntArray.put(R.id.chat_item_time_create, 2);
    }

    public ItemChatSystemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, e, f));
    }

    @Override // com.wear.databinding.ItemChatSystemBinding
    public void d(@Nullable Message message) {
        this.b = message;
        synchronized (this) {
            this.d |= 1;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.d;
            this.d = 0L;
        }
        Message message = this.b;
        if ((j & 3) != 0) {
            ws2.g(this.a, message);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.d = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (16 != i) {
            return false;
        }
        d((Message) obj);
        return true;
    }

    public ItemChatSystemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1]);
        this.d = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.c = linearLayout;
        linearLayout.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
