package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public abstract class DialogFragmentChatActionMenuBinding extends ViewDataBinding {

    @NonNull
    public final ImageView a;

    @NonNull
    public final RecyclerView b;

    public DialogFragmentChatActionMenuBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.a = imageView;
        this.b = recyclerView;
    }

    @NonNull
    public static DialogFragmentChatActionMenuBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogFragmentChatActionMenuBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogFragmentChatActionMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_fragment_chat_action_menu, viewGroup, z, obj);
    }
}
