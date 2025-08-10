package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.wear.bean.ConnectionUserBean;
import com.wear.widget.roundwidget.SkinRoundTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes3.dex */
public abstract class ItemConnectionRequestBinding extends ViewDataBinding {

    @NonNull
    public final CircleImageView a;

    @NonNull
    public final SkinAutoRelativeLayout b;

    @Bindable
    public ConnectionUserBean c;

    public ItemConnectionRequestBinding(Object obj, View view, int i, CircleImageView circleImageView, SkinRoundTextView skinRoundTextView, ImageView imageView, SkinAutoRelativeLayout skinAutoRelativeLayout) {
        super(obj, view, i);
        this.a = circleImageView;
        this.b = skinAutoRelativeLayout;
    }

    public abstract void b(@Nullable ConnectionUserBean connectionUserBean);
}
