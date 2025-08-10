package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;
import com.wear.widget.roundwidget.SkinRoundTextView;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class ActivityRateFeedbackBinding implements ViewBinding {

    @NonNull
    public final SkinCompatConstraintLayout a;

    @NonNull
    public final SkinRoundTextView b;

    @NonNull
    public final EditText c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public ActivityRateFeedbackBinding(@NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull SkinRoundTextView skinRoundTextView, @NonNull SkinRoundConstraintLayout skinRoundConstraintLayout, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = skinCompatConstraintLayout;
        this.b = skinRoundTextView;
        this.c = editText;
        this.d = imageView;
        this.e = textView;
        this.f = textView2;
    }

    @NonNull
    public static ActivityRateFeedbackBinding a(@NonNull View view) {
        int i = R.id.btn_submit;
        SkinRoundTextView skinRoundTextView = (SkinRoundTextView) view.findViewById(R.id.btn_submit);
        if (skinRoundTextView != null) {
            i = R.id.cl_feedback_container;
            SkinRoundConstraintLayout skinRoundConstraintLayout = (SkinRoundConstraintLayout) view.findViewById(R.id.cl_feedback_container);
            if (skinRoundConstraintLayout != null) {
                i = R.id.et_feedback;
                EditText editText = (EditText) view.findViewById(R.id.et_feedback);
                if (editText != null) {
                    i = R.id.iv_close;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
                    if (imageView != null) {
                        i = R.id.tv_feedback_error;
                        TextView textView = (TextView) view.findViewById(R.id.tv_feedback_error);
                        if (textView != null) {
                            i = R.id.tv_feedback_hint;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_feedback_hint);
                            if (textView2 != null) {
                                i = R.id.tv_subtitle;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_subtitle);
                                if (textView3 != null) {
                                    i = R.id.tv_title;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_title);
                                    if (textView4 != null) {
                                        return new ActivityRateFeedbackBinding((SkinCompatConstraintLayout) view, skinRoundTextView, skinRoundConstraintLayout, editText, imageView, textView, textView2, textView3, textView4);
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
    public static ActivityRateFeedbackBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityRateFeedbackBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_rate_feedback, viewGroup, false);
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
