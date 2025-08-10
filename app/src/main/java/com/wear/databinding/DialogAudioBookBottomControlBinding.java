package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class DialogAudioBookBottomControlBinding implements ViewBinding {

    @NonNull
    public final SkinCompatConstraintLayout a;

    @NonNull
    public final ImageButton b;

    @NonNull
    public final ImageButton c;

    @NonNull
    public final ImageButton d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageButton f;

    @NonNull
    public final RoundedImageView g;

    @NonNull
    public final SeekBar h;

    @NonNull
    public final SeekBar i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    public DialogAudioBookBottomControlBinding(@NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageView imageView, @NonNull ImageButton imageButton3, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageButton imageButton4, @NonNull RoundedImageView roundedImageView, @NonNull SeekBar seekBar, @NonNull SeekBar seekBar2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = skinCompatConstraintLayout;
        this.b = imageButton;
        this.c = imageButton2;
        this.d = imageButton3;
        this.e = imageView2;
        this.f = imageButton4;
        this.g = roundedImageView;
        this.h = seekBar;
        this.i = seekBar2;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
    }

    @NonNull
    public static DialogAudioBookBottomControlBinding a(@NonNull View view) {
        int i = R.id.audio_book_next;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.audio_book_next);
        if (imageButton != null) {
            i = R.id.audio_book_previous;
            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.audio_book_previous);
            if (imageButton2 != null) {
                i = R.id.imageView;
                ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
                if (imageView != null) {
                    i = R.id.iv_audio_book_bottom_play;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.iv_audio_book_bottom_play);
                    if (imageButton3 != null) {
                        i = R.id.iv_close;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_close);
                        if (imageView2 != null) {
                            i = R.id.iv_replay_bg;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_replay_bg);
                            if (imageView3 != null) {
                                i = R.id.iv_replay_model;
                                ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.iv_replay_model);
                                if (imageButton4 != null) {
                                    i = R.id.riv_audio_book_cover;
                                    RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.riv_audio_book_cover);
                                    if (roundedImageView != null) {
                                        i = R.id.seekBar;
                                        SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
                                        if (seekBar != null) {
                                            i = R.id.sensitivity_seek;
                                            SeekBar seekBar2 = (SeekBar) view.findViewById(R.id.sensitivity_seek);
                                            if (seekBar2 != null) {
                                                i = R.id.tv_audio_book_bottom_bar_title;
                                                TextView textView = (TextView) view.findViewById(R.id.tv_audio_book_bottom_bar_title);
                                                if (textView != null) {
                                                    i = R.id.tv_current_position;
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_current_position);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_duration;
                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_duration);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_sensitivity;
                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_sensitivity);
                                                            if (textView4 != null) {
                                                                return new DialogAudioBookBottomControlBinding((SkinCompatConstraintLayout) view, imageButton, imageButton2, imageView, imageButton3, imageView2, imageView3, imageButton4, roundedImageView, seekBar, seekBar2, textView, textView2, textView3, textView4);
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
    public static DialogAudioBookBottomControlBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAudioBookBottomControlBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_audio_book_bottom_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinCompatConstraintLayout getRoot() {
        return this.a;
    }
}
