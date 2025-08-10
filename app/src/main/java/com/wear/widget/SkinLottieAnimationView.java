package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.wear.util.MyApplication;
import dc.aj4;

/* loaded from: classes4.dex */
public class SkinLottieAnimationView extends LottieAnimationView implements aj4 {
    public boolean v;

    public SkinLottieAnimationView(Context context) {
        super(context);
        this.v = false;
    }

    @Override // dc.aj4
    public void P1() {
        if (this.v) {
            int i = MyApplication.m0;
            String str = "ds_light.json";
            if (i != 0 ? i != 1 : MyApplication.l0) {
                str = "ds_dark.json";
            }
            setAnimation(str);
        }
    }

    public void setDs(boolean z) {
        this.v = z;
    }

    public SkinLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = false;
    }

    public SkinLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v = false;
    }
}
