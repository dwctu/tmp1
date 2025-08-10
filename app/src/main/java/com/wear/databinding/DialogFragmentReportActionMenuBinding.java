package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public abstract class DialogFragmentReportActionMenuBinding extends ViewDataBinding {

    @NonNull
    public final RecyclerView a;

    @NonNull
    public final TextView b;

    public DialogFragmentReportActionMenuBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.a = recyclerView;
        this.b = textView;
    }

    @NonNull
    public static DialogFragmentReportActionMenuBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return c(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogFragmentReportActionMenuBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogFragmentReportActionMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_fragment_report_action_menu, viewGroup, z, obj);
    }
}
