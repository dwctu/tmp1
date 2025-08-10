package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.ConnectionUserBean;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.widget.SkinAutoFrameLayout;

/* loaded from: classes3.dex */
public abstract class ItemConnectionsUserBinding extends ViewDataBinding {

    @NonNull
    public final CircleImageView a;

    @NonNull
    public final SkinAutoFrameLayout b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @Bindable
    public ConnectionUserBean e;

    public ItemConnectionsUserBinding(Object obj, View view, int i, CircleImageView circleImageView, SkinAutoFrameLayout skinAutoFrameLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.a = circleImageView;
        this.b = skinAutoFrameLayout;
        this.c = imageView;
        this.d = textView;
    }

    public abstract void b(@Nullable ConnectionUserBean connectionUserBean);
}
