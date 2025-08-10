package com.wear.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.chat.ReportActionMenuBean;

/* loaded from: classes3.dex */
public abstract class ItemReportActionMenuBinding extends ViewDataBinding {

    @NonNull
    public final TextView a;

    @Bindable
    public ReportActionMenuBean b;

    public ItemReportActionMenuBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.a = textView;
    }

    public abstract void b(@Nullable ReportActionMenuBean reportActionMenuBean);
}
