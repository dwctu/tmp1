package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class ActivityXremoteCreateCustomUserBinding implements ViewBinding {

    @NonNull
    public final SkinCompatConstraintLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final TextView c;

    @NonNull
    public final EditText d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public ActivityXremoteCreateCustomUserBinding(@NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull MyActionBar myActionBar, @NonNull TextView textView, @NonNull EditText editText, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = skinCompatConstraintLayout;
        this.b = myActionBar;
        this.c = textView;
        this.d = editText;
        this.e = textView2;
        this.f = textView4;
    }

    @NonNull
    public static ActivityXremoteCreateCustomUserBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.btn_confirm;
            TextView textView = (TextView) view.findViewById(R.id.btn_confirm);
            if (textView != null) {
                i = R.id.et_name;
                EditText editText = (EditText) view.findViewById(R.id.et_name);
                if (editText != null) {
                    i = R.id.tv_count;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_count);
                    if (textView2 != null) {
                        i = R.id.tv_tip;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_tip);
                        if (textView3 != null) {
                            i = R.id.tv_warning;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_warning);
                            if (textView4 != null) {
                                return new ActivityXremoteCreateCustomUserBinding((SkinCompatConstraintLayout) view, myActionBar, textView, editText, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityXremoteCreateCustomUserBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityXremoteCreateCustomUserBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_xremote_create_custom_user, viewGroup, false);
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
