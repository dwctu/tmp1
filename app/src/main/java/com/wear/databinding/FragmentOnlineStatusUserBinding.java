package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class FragmentOnlineStatusUserBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final EditText e;

    @NonNull
    public final TextView f;

    @NonNull
    public final RecyclerView g;

    @NonNull
    public final RecyclerView h;

    @NonNull
    public final RelativeLayout i;

    public FragmentOnlineStatusUserBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull EditText editText, @NonNull TextView textView4, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull RelativeLayout relativeLayout) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = editText;
        this.f = textView4;
        this.g = recyclerView;
        this.h = recyclerView2;
        this.i = relativeLayout;
    }

    @NonNull
    public static FragmentOnlineStatusUserBinding a(@NonNull View view) {
        int i = R.id.cancel_btn;
        TextView textView = (TextView) view.findViewById(R.id.cancel_btn);
        if (textView != null) {
            i = R.id.description;
            TextView textView2 = (TextView) view.findViewById(R.id.description);
            if (textView2 != null) {
                i = R.id.done_btn;
                TextView textView3 = (TextView) view.findViewById(R.id.done_btn);
                if (textView3 != null) {
                    i = R.id.editText;
                    EditText editText = (EditText) view.findViewById(R.id.editText);
                    if (editText != null) {
                        i = R.id.friends_count;
                        TextView textView4 = (TextView) view.findViewById(R.id.friends_count);
                        if (textView4 != null) {
                            i = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                            if (recyclerView != null) {
                                i = R.id.recycler_view_header;
                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recycler_view_header);
                                if (recyclerView2 != null) {
                                    i = R.id.recycler_view_header_container;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.recycler_view_header_container);
                                    if (relativeLayout != null) {
                                        return new FragmentOnlineStatusUserBinding((LinearLayout) view, textView, textView2, textView3, editText, textView4, recyclerView, recyclerView2, relativeLayout);
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
    public static FragmentOnlineStatusUserBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_online_status_user, viewGroup, false);
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
