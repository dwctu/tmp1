package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public final class ActivityChatGptStoryBookBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final AppBarLayout d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final SeekBar g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    public ActivityChatGptStoryBookBinding(@NonNull LinearLayout linearLayout, @NonNull MyActionBar myActionBar, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView, @NonNull AppBarLayout appBarLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout3, @NonNull SeekBar seekBar, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = linearLayout;
        this.b = myActionBar;
        this.c = imageView;
        this.d = appBarLayout;
        this.e = imageView2;
        this.f = linearLayout3;
        this.g = seekBar;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
    }

    @NonNull
    public static ActivityChatGptStoryBookBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.fl_content;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.fl_content);
            if (coordinatorLayout != null) {
                i = R.id.iv_music_minibar_pause;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_music_minibar_pause);
                if (imageView != null) {
                    i = R.id.ll_music;
                    AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.ll_music);
                    if (appBarLayout != null) {
                        i = R.id.ll_text_content;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_text_content);
                        if (linearLayout != null) {
                            i = R.id.nav_bottom;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.nav_bottom);
                            if (imageView2 != null) {
                                i = R.id.nestedscrollview;
                                NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.nestedscrollview);
                                if (nestedScrollView != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) view;
                                    i = R.id.pgb_story_book;
                                    SeekBar seekBar = (SeekBar) view.findViewById(R.id.pgb_story_book);
                                    if (seekBar != null) {
                                        i = R.id.tv_text_content;
                                        TextView textView = (TextView) view.findViewById(R.id.tv_text_content);
                                        if (textView != null) {
                                            i = R.id.tv_time_end;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_time_end);
                                            if (textView2 != null) {
                                                i = R.id.tv_time_strat;
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_time_strat);
                                                if (textView3 != null) {
                                                    i = R.id.tv_title;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_title);
                                                    if (textView4 != null) {
                                                        return new ActivityChatGptStoryBookBinding(linearLayout2, myActionBar, coordinatorLayout, imageView, appBarLayout, linearLayout, imageView2, nestedScrollView, linearLayout2, seekBar, textView, textView2, textView3, textView4);
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
    public static ActivityChatGptStoryBookBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityChatGptStoryBookBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_chat_gpt_story_book, viewGroup, false);
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
