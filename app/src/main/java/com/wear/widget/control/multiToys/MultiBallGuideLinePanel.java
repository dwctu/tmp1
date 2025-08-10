package com.wear.widget.control.multiToys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import dc.th4;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class MultiBallGuideLinePanel extends View {
    public Paint a;
    public Map<ControlBallBean, Float> b;

    public MultiBallGuideLinePanel(Context context) {
        super(context);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(th4.b(getContext(), R.color.remote_control_line));
        this.a.setStrokeWidth(2.0f);
        this.b = new HashMap();
    }

    public void b() {
        Map<ControlBallBean, Float> map = this.b;
        if (map != null) {
            map.clear();
        }
    }

    public void c(ControlBallBean controlBallBean) {
        this.b.remove(controlBallBean);
    }

    public void d(ControlBallBean controlBallBean, float f) {
        this.b.put(controlBallBean, Float.valueOf(f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Float f : this.b.values()) {
            canvas.drawLine(0.0f, f.floatValue(), getWidth(), f.floatValue(), this.a);
        }
    }

    public void setLineColor(int i) {
        this.a.setColor(i);
    }

    public MultiBallGuideLinePanel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MultiBallGuideLinePanel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
