package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public final class ActivityInviteLinkBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView d;

    public ActivityInviteLinkBinding(@NonNull LinearLayout linearLayout, @NonNull MyActionBar myActionBar, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = linearLayout3;
        this.d = textView;
    }

    @NonNull
    public static ActivityInviteLinkBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.iv_copy_media;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_copy_media);
            if (imageView != null) {
                i = R.id.iv_share_media;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_share_media);
                if (imageView2 != null) {
                    i = R.id.sccl_copy;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.sccl_copy);
                    if (linearLayout != null) {
                        i = R.id.sccl_share;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.sccl_share);
                        if (linearLayout2 != null) {
                            i = R.id.tv_copy_link;
                            TextView textView = (TextView) view.findViewById(R.id.tv_copy_link);
                            if (textView != null) {
                                i = R.id.tv_copy_title;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_copy_title);
                                if (textView2 != null) {
                                    i = R.id.tv_share_title;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_share_title);
                                    if (textView3 != null) {
                                        return new ActivityInviteLinkBinding((LinearLayout) view, myActionBar, imageView, imageView2, linearLayout, linearLayout2, textView, textView2, textView3);
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
    public static ActivityInviteLinkBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityInviteLinkBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_invite_link, viewGroup, false);
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
