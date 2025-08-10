package com.wear.widget.control;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class CoustomLinearLayout extends FrameLayout {
    public a a;

    public interface a {
        void a(int i, int i2, int i3, int i4);

        void b(int i);
    }

    public CoustomLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    public void setListener(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(i);
        }
    }
}
