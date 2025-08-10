package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.chat.ChatMenuItem;

/* loaded from: classes3.dex */
public abstract class ItemChatMenuBinding extends ViewDataBinding {

    @NonNull
    public final TextView a;

    @NonNull
    public final ImageView b;

    @Bindable
    public ChatMenuItem c;

    public ItemChatMenuBinding(Object obj, View view, int i, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.a = textView;
        this.b = imageView;
    }

    @NonNull
    public static ItemChatMenuBinding b(@NonNull LayoutInflater layoutInflater) {
        return c(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemChatMenuBinding c(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemChatMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_menu, null, false, obj);
    }

    public abstract void d(@Nullable ChatMenuItem chatMenuItem);
}
