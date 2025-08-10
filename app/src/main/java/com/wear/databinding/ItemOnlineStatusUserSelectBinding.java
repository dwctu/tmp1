package com.wear.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.me.OnlineStatusUserBean;

/* loaded from: classes3.dex */
public abstract class ItemOnlineStatusUserSelectBinding extends ViewDataBinding {

    @NonNull
    public final LinearLayout a;

    @Bindable
    public OnlineStatusUserBean b;

    @Bindable
    public String c;

    public ItemOnlineStatusUserSelectBinding(Object obj, View view, int i, LinearLayout linearLayout) {
        super(obj, view, i);
        this.a = linearLayout;
    }

    public abstract void b(@Nullable String str);

    public abstract void c(@Nullable OnlineStatusUserBean onlineStatusUserBean);
}
