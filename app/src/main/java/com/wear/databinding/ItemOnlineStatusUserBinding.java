package com.wear.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.me.OnlineStatusUserBean;
import com.wear.widget.swipe.EasySwipeMenuLayout;

/* loaded from: classes3.dex */
public abstract class ItemOnlineStatusUserBinding extends ViewDataBinding {

    @NonNull
    public final EasySwipeMenuLayout a;

    @Bindable
    public OnlineStatusUserBean b;

    public ItemOnlineStatusUserBinding(Object obj, View view, int i, LinearLayout linearLayout, EasySwipeMenuLayout easySwipeMenuLayout, TextView textView) {
        super(obj, view, i);
        this.a = easySwipeMenuLayout;
    }

    public abstract void b(@Nullable OnlineStatusUserBean onlineStatusUserBean);
}
