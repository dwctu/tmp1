package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public final class DialogNewToyBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    @NonNull
    public final NewtoyBtdisabledLayoutBinding b;

    @NonNull
    public final NewtoyNotoyrlLayoutBinding c;

    @NonNull
    public final NewtoySearchfailedLayoutBinding d;

    @NonNull
    public final NewtoyToycontentLayoutBinding e;

    @NonNull
    public final TextView f;

    public DialogNewToyBinding(@NonNull RelativeLayout relativeLayout, @NonNull NewtoyBtdisabledLayoutBinding newtoyBtdisabledLayoutBinding, @NonNull NewtoyNotoyrlLayoutBinding newtoyNotoyrlLayoutBinding, @NonNull NewtoySearchfailedLayoutBinding newtoySearchfailedLayoutBinding, @NonNull NewtoyToycontentLayoutBinding newtoyToycontentLayoutBinding, @NonNull TextView textView, @NonNull View view) {
        this.a = relativeLayout;
        this.b = newtoyBtdisabledLayoutBinding;
        this.c = newtoyNotoyrlLayoutBinding;
        this.d = newtoySearchfailedLayoutBinding;
        this.e = newtoyToycontentLayoutBinding;
        this.f = textView;
    }

    @NonNull
    public static DialogNewToyBinding a(@NonNull View view) {
        int i = R.id.newtoy_btdisabledstub;
        View viewFindViewById = view.findViewById(R.id.newtoy_btdisabledstub);
        if (viewFindViewById != null) {
            NewtoyBtdisabledLayoutBinding newtoyBtdisabledLayoutBindingA = NewtoyBtdisabledLayoutBinding.a(viewFindViewById);
            i = R.id.newtoy_notoyrlstub;
            View viewFindViewById2 = view.findViewById(R.id.newtoy_notoyrlstub);
            if (viewFindViewById2 != null) {
                NewtoyNotoyrlLayoutBinding newtoyNotoyrlLayoutBindingA = NewtoyNotoyrlLayoutBinding.a(viewFindViewById2);
                i = R.id.newtoy_searchfailedstub;
                View viewFindViewById3 = view.findViewById(R.id.newtoy_searchfailedstub);
                if (viewFindViewById3 != null) {
                    NewtoySearchfailedLayoutBinding newtoySearchfailedLayoutBindingA = NewtoySearchfailedLayoutBinding.a(viewFindViewById3);
                    i = R.id.newtoy_toycontentstub;
                    View viewFindViewById4 = view.findViewById(R.id.newtoy_toycontentstub);
                    if (viewFindViewById4 != null) {
                        NewtoyToycontentLayoutBinding newtoyToycontentLayoutBindingA = NewtoyToycontentLayoutBinding.a(viewFindViewById4);
                        i = R.id.tv_toy_title;
                        TextView textView = (TextView) view.findViewById(R.id.tv_toy_title);
                        if (textView != null) {
                            i = R.id.view;
                            View viewFindViewById5 = view.findViewById(R.id.view);
                            if (viewFindViewById5 != null) {
                                return new DialogNewToyBinding((RelativeLayout) view, newtoyBtdisabledLayoutBindingA, newtoyNotoyrlLayoutBindingA, newtoySearchfailedLayoutBindingA, newtoyToycontentLayoutBindingA, textView, viewFindViewById5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogNewToyBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_new_toy, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
