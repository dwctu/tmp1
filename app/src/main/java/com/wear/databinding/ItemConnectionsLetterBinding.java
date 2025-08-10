package com.wear.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public abstract class ItemConnectionsLetterBinding extends ViewDataBinding {

    @NonNull
    public final View a;

    @Bindable
    public String b;

    @Bindable
    public Boolean c;

    public ItemConnectionsLetterBinding(Object obj, View view, int i, View view2) {
        super(obj, view, i);
        this.a = view2;
    }

    public static ItemConnectionsLetterBinding b(@NonNull View view) {
        return c(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemConnectionsLetterBinding c(@NonNull View view, @Nullable Object obj) {
        return (ItemConnectionsLetterBinding) ViewDataBinding.bind(obj, view, R.layout.item_connections_letter);
    }

    public abstract void d(@Nullable Boolean bool);

    public abstract void e(@Nullable String str);
}
