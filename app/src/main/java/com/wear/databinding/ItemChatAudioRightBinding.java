package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import com.wear.ui.chat.widget.ChatAudioView;

/* loaded from: classes3.dex */
public abstract class ItemChatAudioRightBinding extends ViewDataBinding {

    @NonNull
    public final ImageView a;

    @NonNull
    public final ChatAudioView b;

    @NonNull
    public final ProgressBar c;

    @Bindable
    public Message d;

    public ItemChatAudioRightBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ChatAudioView chatAudioView, TextView textView, LinearLayout linearLayout, ProgressBar progressBar) {
        super(obj, view, i);
        this.a = imageView2;
        this.b = chatAudioView;
        this.c = progressBar;
    }

    @NonNull
    public static ItemChatAudioRightBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemChatAudioRightBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemChatAudioRightBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_audio_right, viewGroup, z, obj);
    }

    public abstract void d(@Nullable Message message);
}
