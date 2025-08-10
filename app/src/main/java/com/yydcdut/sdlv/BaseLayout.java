package com.yydcdut.sdlv;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import dc.zu3;

/* loaded from: classes4.dex */
public abstract class BaseLayout extends FrameLayout {
    public zu3 a;

    public BaseLayout(Context context, zu3 zu3Var) {
        super(context);
        this.a = zu3Var;
    }

    public abstract void a();

    public abstract ImageView getImageView();

    public abstract TextView getTextView();
}
