package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.chatMic.AudioWaveView;
import com.wear.widget.chatMic.VoiceMessagePanelAnimationView;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;

/* loaded from: classes3.dex */
public final class ViewVoiceMessagePanelBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final AudioWaveView c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final SkinRoundAutoLinearLayout g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final FrameLayout l;

    @NonNull
    public final VoiceMessagePanelAnimationView m;

    @NonNull
    public final TextView n;

    public ViewVoiceMessagePanelBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull AudioWaveView audioWaveView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull SkinRoundAutoLinearLayout skinRoundAutoLinearLayout, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull FrameLayout frameLayout, @NonNull TextView textView2, @NonNull FrameLayout frameLayout2, @NonNull VoiceMessagePanelAnimationView voiceMessagePanelAnimationView, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = audioWaveView;
        this.d = linearLayout;
        this.e = linearLayout2;
        this.f = imageView;
        this.g = skinRoundAutoLinearLayout;
        this.h = imageView2;
        this.i = imageView3;
        this.j = imageView4;
        this.k = textView2;
        this.l = frameLayout2;
        this.m = voiceMessagePanelAnimationView;
        this.n = textView3;
    }

    @NonNull
    public static ViewVoiceMessagePanelBinding a(@NonNull View view) {
        int i = R.id.audio_time_count_down;
        TextView textView = (TextView) view.findViewById(R.id.audio_time_count_down);
        if (textView != null) {
            i = R.id.audio_wave_view;
            AudioWaveView audioWaveView = (AudioWaveView) view.findViewById(R.id.audio_wave_view);
            if (audioWaveView != null) {
                i = R.id.audio_wave_view_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.audio_wave_view_container);
                if (linearLayout != null) {
                    i = R.id.bottom_container;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.bottom_container);
                    if (linearLayout2 != null) {
                        i = R.id.chat_lock_arrow_up;
                        ImageView imageView = (ImageView) view.findViewById(R.id.chat_lock_arrow_up);
                        if (imageView != null) {
                            i = R.id.chat_lock_container;
                            SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = (SkinRoundAutoLinearLayout) view.findViewById(R.id.chat_lock_container);
                            if (skinRoundAutoLinearLayout != null) {
                                i = R.id.chat_locked_icon;
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.chat_locked_icon);
                                if (imageView2 != null) {
                                    i = R.id.chat_record_action;
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.chat_record_action);
                                    if (imageView3 != null) {
                                        i = R.id.chat_record_cancel;
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.chat_record_cancel);
                                        if (imageView4 != null) {
                                            i = R.id.chat_record_container;
                                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.chat_record_container);
                                            if (frameLayout != null) {
                                                i = R.id.chat_record_time;
                                                TextView textView2 = (TextView) view.findViewById(R.id.chat_record_time);
                                                if (textView2 != null) {
                                                    i = R.id.custom_animation_container;
                                                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.custom_animation_container);
                                                    if (frameLayout2 != null) {
                                                        i = R.id.custom_animation_view;
                                                        VoiceMessagePanelAnimationView voiceMessagePanelAnimationView = (VoiceMessagePanelAnimationView) view.findViewById(R.id.custom_animation_view);
                                                        if (voiceMessagePanelAnimationView != null) {
                                                            i = R.id.hint_text;
                                                            TextView textView3 = (TextView) view.findViewById(R.id.hint_text);
                                                            if (textView3 != null) {
                                                                return new ViewVoiceMessagePanelBinding((ConstraintLayout) view, textView, audioWaveView, linearLayout, linearLayout2, imageView, skinRoundAutoLinearLayout, imageView2, imageView3, imageView4, frameLayout, textView2, frameLayout2, voiceMessagePanelAnimationView, textView3);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewVoiceMessagePanelBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_voice_message_panel, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
