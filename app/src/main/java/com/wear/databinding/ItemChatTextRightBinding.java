package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.wear.ui.chat.adapter.ChatAdapter;
import com.wear.util.HttpTextView;
import com.wear.widget.SkinLottieAnimationView;
import dc.ie3;

/* loaded from: classes3.dex */
public abstract class ItemChatTextRightBinding extends ViewDataBinding {

    @NonNull
    public final ImageView a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ProgressBar d;

    @NonNull
    public final SkinLottieAnimationView e;

    @NonNull
    public final HttpTextView f;

    @Bindable
    public Integer g;

    @Bindable
    public Boolean h;

    @Bindable
    public Message i;

    @Bindable
    public ie3 j;

    @Bindable
    public ChatAdapter.a k;

    public ItemChatTextRightBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, FrameLayout frameLayout, ImageView imageView4, LinearLayout linearLayout, ProgressBar progressBar, SkinLottieAnimationView skinLottieAnimationView, HttpTextView httpTextView) {
        super(obj, view, i);
        this.a = imageView2;
        this.b = imageView3;
        this.c = imageView4;
        this.d = progressBar;
        this.e = skinLottieAnimationView;
        this.f = httpTextView;
    }

    @NonNull
    public static ItemChatTextRightBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemChatTextRightBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemChatTextRightBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_text_right, viewGroup, z, obj);
    }

    public abstract void d(@Nullable Integer num);

    public abstract void e(@Nullable ie3 ie3Var);

    public abstract void f(@Nullable Boolean bool);

    public abstract void g(@Nullable ChatAdapter.a aVar);

    public abstract void h(@Nullable Message message);
}
