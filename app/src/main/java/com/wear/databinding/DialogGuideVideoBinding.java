package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.widget.roundwidget.SkinRoundTextView;

/* loaded from: classes3.dex */
public abstract class DialogGuideVideoBinding extends ViewDataBinding {

    @NonNull
    public final SkinRoundTextView a;

    @NonNull
    public final SkinRoundTextView b;

    @NonNull
    public final MyVideoView c;

    public DialogGuideVideoBinding(Object obj, View view, int i, SkinRoundTextView skinRoundTextView, SkinRoundTextView skinRoundTextView2, MyVideoView myVideoView) {
        super(obj, view, i);
        this.a = skinRoundTextView;
        this.b = skinRoundTextView2;
        this.c = myVideoView;
    }

    @NonNull
    public static DialogGuideVideoBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogGuideVideoBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogGuideVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_guide_video, viewGroup, z, obj);
    }
}
