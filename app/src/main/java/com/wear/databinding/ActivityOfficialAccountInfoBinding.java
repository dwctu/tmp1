package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import com.wear.widget.roundwidget.SkinRoundAutoFrameLayout;
import com.wear.widget.roundwidget.SkinRoundTextView;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public final class ActivityOfficialAccountInfoBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final SkinRoundAutoFrameLayout c;

    @NonNull
    public final GifImageView d;

    @NonNull
    public final SwitchView e;

    @NonNull
    public final SwitchView f;

    public ActivityOfficialAccountInfoBinding(@NonNull LinearLayout linearLayout, @NonNull MyActionBar myActionBar, @NonNull SkinRoundAutoFrameLayout skinRoundAutoFrameLayout, @NonNull GifImageView gifImageView, @NonNull SwitchView switchView, @NonNull SwitchView switchView2, @NonNull SkinRoundTextView skinRoundTextView, @NonNull SkinRoundTextView skinRoundTextView2, @NonNull SkinRoundTextView skinRoundTextView3, @NonNull SkinRoundTextView skinRoundTextView4, @NonNull SkinRoundTextView skinRoundTextView5) {
        this.a = linearLayout;
        this.b = myActionBar;
        this.c = skinRoundAutoFrameLayout;
        this.d = gifImageView;
        this.e = switchView;
        this.f = switchView2;
    }

    @NonNull
    public static ActivityOfficialAccountInfoBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.fl_clear_message;
            SkinRoundAutoFrameLayout skinRoundAutoFrameLayout = (SkinRoundAutoFrameLayout) view.findViewById(R.id.fl_clear_message);
            if (skinRoundAutoFrameLayout != null) {
                i = R.id.iv_head_sculpture;
                GifImageView gifImageView = (GifImageView) view.findViewById(R.id.iv_head_sculpture);
                if (gifImageView != null) {
                    i = R.id.sw_mute_notifications;
                    SwitchView switchView = (SwitchView) view.findViewById(R.id.sw_mute_notifications);
                    if (switchView != null) {
                        i = R.id.sw_topping;
                        SwitchView switchView2 = (SwitchView) view.findViewById(R.id.sw_topping);
                        if (switchView2 != null) {
                            i = R.id.tv_clear_message;
                            SkinRoundTextView skinRoundTextView = (SkinRoundTextView) view.findViewById(R.id.tv_clear_message);
                            if (skinRoundTextView != null) {
                                i = R.id.tv_describe;
                                SkinRoundTextView skinRoundTextView2 = (SkinRoundTextView) view.findViewById(R.id.tv_describe);
                                if (skinRoundTextView2 != null) {
                                    i = R.id.tv_mute_notifications;
                                    SkinRoundTextView skinRoundTextView3 = (SkinRoundTextView) view.findViewById(R.id.tv_mute_notifications);
                                    if (skinRoundTextView3 != null) {
                                        i = R.id.tv_nickname;
                                        SkinRoundTextView skinRoundTextView4 = (SkinRoundTextView) view.findViewById(R.id.tv_nickname);
                                        if (skinRoundTextView4 != null) {
                                            i = R.id.tv_topping;
                                            SkinRoundTextView skinRoundTextView5 = (SkinRoundTextView) view.findViewById(R.id.tv_topping);
                                            if (skinRoundTextView5 != null) {
                                                return new ActivityOfficialAccountInfoBinding((LinearLayout) view, myActionBar, skinRoundAutoFrameLayout, gifImageView, switchView, switchView2, skinRoundTextView, skinRoundTextView2, skinRoundTextView3, skinRoundTextView4, skinRoundTextView5);
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
    public static ActivityOfficialAccountInfoBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityOfficialAccountInfoBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_official_account_info, viewGroup, false);
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
