package com.wear.databinding;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.me.OnlineStatusHeadBean;

/* loaded from: classes3.dex */
public abstract class HeaderOnlineStatusBinding extends ViewDataBinding {

    @Bindable
    public OnlineStatusHeadBean a;

    public HeaderOnlineStatusBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public abstract void b(@Nullable OnlineStatusHeadBean onlineStatusHeadBean);
}
