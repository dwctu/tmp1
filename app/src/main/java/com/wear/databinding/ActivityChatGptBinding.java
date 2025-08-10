package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class ActivityChatGptBinding implements ViewBinding {

    @NonNull
    public final SkinCompatConstraintLayout a;

    @NonNull
    public final MyActionBar b;

    public ActivityChatGptBinding(@NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull MyActionBar myActionBar, @NonNull FrameLayout frameLayout) {
        this.a = skinCompatConstraintLayout;
        this.b = myActionBar;
    }

    @NonNull
    public static ActivityChatGptBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.constraint;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.constraint);
            if (frameLayout != null) {
                return new ActivityChatGptBinding((SkinCompatConstraintLayout) view, myActionBar, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityChatGptBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityChatGptBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_chat_gpt, viewGroup, false);
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
