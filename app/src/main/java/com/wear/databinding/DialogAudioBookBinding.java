package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class DialogAudioBookBinding implements ViewBinding {

    @NonNull
    public final RecyclerView a;

    @NonNull
    public final RecyclerView b;

    public DialogAudioBookBinding(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.a = recyclerView;
        this.b = recyclerView2;
    }

    @NonNull
    public static DialogAudioBookBinding a(@NonNull View view) {
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new DialogAudioBookBinding(recyclerView, recyclerView);
    }

    @NonNull
    public static DialogAudioBookBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAudioBookBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_audio_book, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RecyclerView getRoot() {
        return this.a;
    }
}
