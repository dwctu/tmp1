package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;

/* loaded from: classes3.dex */
public abstract class ItemChatSystemBinding extends ViewDataBinding {

    @NonNull
    public final TextView a;

    @Bindable
    public Message b;

    public ItemChatSystemBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.a = textView2;
    }

    @NonNull
    public static ItemChatSystemBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemChatSystemBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemChatSystemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_system, viewGroup, z, obj);
    }

    public abstract void d(@Nullable Message message);
}
