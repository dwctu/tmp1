package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.chat.ChatActionMenuBean;

/* loaded from: classes3.dex */
public abstract class ItemChatActionMenuBinding extends ViewDataBinding {

    @NonNull
    public final TextView a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final TextView c;

    @Bindable
    public ChatActionMenuBean d;

    public ItemChatActionMenuBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.a = textView;
        this.b = imageView;
        this.c = textView2;
    }

    public abstract void b(@Nullable ChatActionMenuBean chatActionMenuBean);
}
