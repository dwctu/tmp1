package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class DebugDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public DebugDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = textView5;
        this.g = textView6;
    }

    @NonNull
    public static DebugDialogBinding a(@NonNull View view) {
        int i = R.id.tv_close;
        TextView textView = (TextView) view.findViewById(R.id.tv_close);
        if (textView != null) {
            i = R.id.tv_open_feature_config;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_open_feature_config);
            if (textView2 != null) {
                i = R.id.tv_toy_clear_db;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_toy_clear_db);
                if (textView3 != null) {
                    i = R.id.tv_toy_switch;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_toy_switch);
                    if (textView4 != null) {
                        i = R.id.tv_ye_test1;
                        TextView textView5 = (TextView) view.findViewById(R.id.tv_ye_test1);
                        if (textView5 != null) {
                            i = R.id.tv_ye_test2;
                            TextView textView6 = (TextView) view.findViewById(R.id.tv_ye_test2);
                            if (textView6 != null) {
                                return new DebugDialogBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DebugDialogBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.debug_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
