package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public final class FragmentChatGptBinding implements ViewBinding {

    @NonNull
    public final SkinCompatConstraintLayout a;

    @NonNull
    public final RecyclerView b;

    @NonNull
    public final EditText c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final RecyclerView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final View i;

    public FragmentChatGptBinding(@NonNull SkinCompatConstraintLayout skinCompatConstraintLayout, @NonNull RecyclerView recyclerView, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull RecyclerView recyclerView2, @NonNull TextView textView, @NonNull View view) {
        this.a = skinCompatConstraintLayout;
        this.b = recyclerView;
        this.c = editText;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = recyclerView2;
        this.h = textView;
        this.i = view;
    }

    @NonNull
    public static FragmentChatGptBinding a(@NonNull View view) {
        int i = R.id.asking_about;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.asking_about);
        if (recyclerView != null) {
            i = R.id.et_input_chat;
            EditText editText = (EditText) view.findViewById(R.id.et_input_chat);
            if (editText != null) {
                i = R.id.iv_chat_ask_about;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_chat_ask_about);
                if (imageView != null) {
                    i = R.id.iv_chat_send;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_chat_send);
                    if (imageView2 != null) {
                        i = R.id.iv_clear;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_clear);
                        if (imageView3 != null) {
                            i = R.id.recyclerView;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView);
                            if (recyclerView2 != null) {
                                i = R.id.tv_left_times;
                                TextView textView = (TextView) view.findViewById(R.id.tv_left_times);
                                if (textView != null) {
                                    i = R.id.view;
                                    View viewFindViewById = view.findViewById(R.id.view);
                                    if (viewFindViewById != null) {
                                        return new FragmentChatGptBinding((SkinCompatConstraintLayout) view, recyclerView, editText, imageView, imageView2, imageView3, recyclerView2, textView, viewFindViewById);
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
    public static FragmentChatGptBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_chat_gpt, viewGroup, false);
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
