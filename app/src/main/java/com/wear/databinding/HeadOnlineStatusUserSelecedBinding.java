package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.me.OnlineStatusUserBean;

/* loaded from: classes3.dex */
public abstract class HeadOnlineStatusUserSelecedBinding extends ViewDataBinding {

    @Bindable
    public OnlineStatusUserBean a;

    public HeadOnlineStatusUserSelecedBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
    }

    public abstract void b(@Nullable OnlineStatusUserBean onlineStatusUserBean);
}
