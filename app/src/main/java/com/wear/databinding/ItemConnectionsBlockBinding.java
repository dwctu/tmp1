package com.wear.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.ConnectionBlockBean;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public abstract class ItemConnectionsBlockBinding extends ViewDataBinding {

    @NonNull
    public final CircleImageView a;

    @Bindable
    public ConnectionBlockBean b;

    public ItemConnectionsBlockBinding(Object obj, View view, int i, CircleImageView circleImageView) {
        super(obj, view, i);
        this.a = circleImageView;
    }

    public abstract void b(@Nullable ConnectionBlockBean connectionBlockBean);
}
