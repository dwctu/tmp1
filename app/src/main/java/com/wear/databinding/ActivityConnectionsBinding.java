package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.ConnectionsSideBar;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.roundwidget.SkinRoundAutoLinearLayout;
import com.wear.widget.roundwidget.SkinRoundTextView;
import com.wear.widget.sticky.StickyHeadContainer;
import skin.support.design.widget.SkinMaterialAppBarLayout;
import skin.support.widget.SkinAutoFrameLayout;
import skin.support.widget.SkinAutoLinearLayout;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public final class ActivityConnectionsBinding implements ViewBinding {

    @NonNull
    public final SkinAutoRelativeLayout a;

    @NonNull
    public final SkinMaterialAppBarLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final CoordinatorLayout d;

    @NonNull
    public final SkinAutoFrameLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final RecyclerView g;

    @NonNull
    public final RecyclerView h;

    @NonNull
    public final SkinRoundAutoLinearLayout i;

    @NonNull
    public final ConnectionsSideBar j;

    @NonNull
    public final StickyHeadContainer k;

    @NonNull
    public final ItemConnectionsLetterBinding l;

    public ActivityConnectionsBinding(@NonNull SkinAutoRelativeLayout skinAutoRelativeLayout, @NonNull SkinMaterialAppBarLayout skinMaterialAppBarLayout, @NonNull ImageView imageView, @NonNull CoordinatorLayout coordinatorLayout, @NonNull SkinAutoFrameLayout skinAutoFrameLayout, @NonNull TextView textView, @NonNull View view, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull SkinRoundAutoLinearLayout skinRoundAutoLinearLayout, @NonNull ConnectionsSideBar connectionsSideBar, @NonNull StickyHeadContainer stickyHeadContainer, @NonNull ItemConnectionsLetterBinding itemConnectionsLetterBinding, @NonNull SkinAutoRelativeLayout skinAutoRelativeLayout2, @NonNull SkinAutoLinearLayout skinAutoLinearLayout, @NonNull SkinRoundTextView skinRoundTextView, @NonNull SkinRoundTextView skinRoundTextView2, @NonNull SkinRoundTextView skinRoundTextView3, @NonNull SkinRoundTextView skinRoundTextView4) {
        this.a = skinAutoRelativeLayout;
        this.b = skinMaterialAppBarLayout;
        this.c = imageView;
        this.d = coordinatorLayout;
        this.e = skinAutoFrameLayout;
        this.f = textView;
        this.g = recyclerView;
        this.h = recyclerView2;
        this.i = skinRoundAutoLinearLayout;
        this.j = connectionsSideBar;
        this.k = stickyHeadContainer;
        this.l = itemConnectionsLetterBinding;
    }

    @NonNull
    public static ActivityConnectionsBinding a(@NonNull View view) {
        int i = R.id.app_bar_layout;
        SkinMaterialAppBarLayout skinMaterialAppBarLayout = (SkinMaterialAppBarLayout) view.findViewById(R.id.app_bar_layout);
        if (skinMaterialAppBarLayout != null) {
            i = R.id.back;
            ImageView imageView = (ImageView) view.findViewById(R.id.back);
            if (imageView != null) {
                i = R.id.coordinator_layout;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator_layout);
                if (coordinatorLayout != null) {
                    i = R.id.header_container;
                    SkinAutoFrameLayout skinAutoFrameLayout = (SkinAutoFrameLayout) view.findViewById(R.id.header_container);
                    if (skinAutoFrameLayout != null) {
                        i = R.id.letter_hint_pop;
                        TextView textView = (TextView) view.findViewById(R.id.letter_hint_pop);
                        if (textView != null) {
                            i = R.id.line;
                            View viewFindViewById = view.findViewById(R.id.line);
                            if (viewFindViewById != null) {
                                i = R.id.mtv_title;
                                MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) view.findViewById(R.id.mtv_title);
                                if (mediumBoldTextView != null) {
                                    i = R.id.recycler_view;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                                    if (recyclerView != null) {
                                        i = R.id.recycler_view_request;
                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recycler_view_request);
                                        if (recyclerView2 != null) {
                                            i = R.id.search_container;
                                            SkinRoundAutoLinearLayout skinRoundAutoLinearLayout = (SkinRoundAutoLinearLayout) view.findViewById(R.id.search_container);
                                            if (skinRoundAutoLinearLayout != null) {
                                                i = R.id.side_bar;
                                                ConnectionsSideBar connectionsSideBar = (ConnectionsSideBar) view.findViewById(R.id.side_bar);
                                                if (connectionsSideBar != null) {
                                                    i = R.id.sticky_header_container;
                                                    StickyHeadContainer stickyHeadContainer = (StickyHeadContainer) view.findViewById(R.id.sticky_header_container);
                                                    if (stickyHeadContainer != null) {
                                                        i = R.id.sticky_header_item;
                                                        View viewFindViewById2 = view.findViewById(R.id.sticky_header_item);
                                                        if (viewFindViewById2 != null) {
                                                            ItemConnectionsLetterBinding itemConnectionsLetterBindingB = ItemConnectionsLetterBinding.b(viewFindViewById2);
                                                            i = R.id.title_container;
                                                            SkinAutoRelativeLayout skinAutoRelativeLayout = (SkinAutoRelativeLayout) view.findViewById(R.id.title_container);
                                                            if (skinAutoRelativeLayout != null) {
                                                                i = R.id.top_container;
                                                                SkinAutoLinearLayout skinAutoLinearLayout = (SkinAutoLinearLayout) view.findViewById(R.id.top_container);
                                                                if (skinAutoLinearLayout != null) {
                                                                    i = R.id.tv_header_1;
                                                                    SkinRoundTextView skinRoundTextView = (SkinRoundTextView) view.findViewById(R.id.tv_header_1);
                                                                    if (skinRoundTextView != null) {
                                                                        i = R.id.tv_header_11;
                                                                        SkinRoundTextView skinRoundTextView2 = (SkinRoundTextView) view.findViewById(R.id.tv_header_11);
                                                                        if (skinRoundTextView2 != null) {
                                                                            i = R.id.tv_header_2;
                                                                            SkinRoundTextView skinRoundTextView3 = (SkinRoundTextView) view.findViewById(R.id.tv_header_2);
                                                                            if (skinRoundTextView3 != null) {
                                                                                i = R.id.tv_header_22;
                                                                                SkinRoundTextView skinRoundTextView4 = (SkinRoundTextView) view.findViewById(R.id.tv_header_22);
                                                                                if (skinRoundTextView4 != null) {
                                                                                    return new ActivityConnectionsBinding((SkinAutoRelativeLayout) view, skinMaterialAppBarLayout, imageView, coordinatorLayout, skinAutoFrameLayout, textView, viewFindViewById, mediumBoldTextView, recyclerView, recyclerView2, skinRoundAutoLinearLayout, connectionsSideBar, stickyHeadContainer, itemConnectionsLetterBindingB, skinAutoRelativeLayout, skinAutoLinearLayout, skinRoundTextView, skinRoundTextView2, skinRoundTextView3, skinRoundTextView4);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityConnectionsBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityConnectionsBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_connections, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SkinAutoRelativeLayout getRoot() {
        return this.a;
    }
}
