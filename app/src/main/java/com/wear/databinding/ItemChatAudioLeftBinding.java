package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import com.wear.ui.chat.widget.ChatAudioView;

/* loaded from: classes3.dex */
public abstract class ItemChatAudioLeftBinding extends ViewDataBinding {

    @NonNull
    public final ChatAudioView a;

    public ItemChatAudioLeftBinding(Object obj, View view, int i, ImageView imageView, ChatAudioView chatAudioView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.a = chatAudioView;
    }

    @NonNull
    public static ItemChatAudioLeftBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemChatAudioLeftBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemChatAudioLeftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_audio_left, viewGroup, z, obj);
    }

    public abstract void d(@Nullable Message message);
}
