package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;

/* loaded from: classes3.dex */
public final class ActivityManagerGroupBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final View d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final RelativeLayout f;

    @NonNull
    public final SwitchView g;

    @NonNull
    public final SwitchView h;

    @NonNull
    public final TextView i;

    public ActivityManagerGroupBinding(@NonNull LinearLayout linearLayout, @NonNull MyActionBar myActionBar, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull SwitchView switchView, @NonNull SwitchView switchView2, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.b = myActionBar;
        this.c = imageView;
        this.d = view;
        this.e = recyclerView;
        this.f = relativeLayout;
        this.g = switchView;
        this.h = switchView2;
        this.i = textView2;
    }

    @NonNull
    public static ActivityManagerGroupBinding a(@NonNull View view) {
        int i = R.id.action_bar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.action_bar);
        if (myActionBar != null) {
            i = R.id.invitation_approval_text;
            TextView textView = (TextView) view.findViewById(R.id.invitation_approval_text);
            if (textView != null) {
                i = R.id.iv_add_admin;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_add_admin);
                if (imageView != null) {
                    i = R.id.line;
                    View viewFindViewById = view.findViewById(R.id.line);
                    if (viewFindViewById != null) {
                        i = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                        if (recyclerView != null) {
                            i = R.id.rl_group_chat_invitation_approval;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_group_chat_invitation_approval);
                            if (relativeLayout != null) {
                                i = R.id.rl_group_chat_invite_others;
                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_group_chat_invite_others);
                                if (relativeLayout2 != null) {
                                    i = R.id.sb_group_chat_invitation_approval;
                                    SwitchView switchView = (SwitchView) view.findViewById(R.id.sb_group_chat_invitation_approval);
                                    if (switchView != null) {
                                        i = R.id.sb_group_chat_invite_others;
                                        SwitchView switchView2 = (SwitchView) view.findViewById(R.id.sb_group_chat_invite_others);
                                        if (switchView2 != null) {
                                            i = R.id.tv_group_chat_invitation_approval;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_group_chat_invitation_approval);
                                            if (textView2 != null) {
                                                return new ActivityManagerGroupBinding((LinearLayout) view, myActionBar, textView, imageView, viewFindViewById, recyclerView, relativeLayout, relativeLayout2, switchView, switchView2, textView2);
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
    public static ActivityManagerGroupBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityManagerGroupBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_manager_group, viewGroup, false);
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
