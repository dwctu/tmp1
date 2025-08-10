package dc;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.util.ArrayList;

/* compiled from: BallPulseIndicator.java */
/* loaded from: classes3.dex */
public class ri1 extends oi1 {
    public float[] h = {1.0f, 1.0f, 1.0f};

    /* compiled from: BallPulseIndicator.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ri1.this.h[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ri1.this.h();
        }
    }

    @Override // dc.oi1
    public void b(Canvas canvas, Paint paint) {
        float fMin = (Math.min(e(), d()) - 8.0f) / 6.0f;
        float f = 2.0f * fMin;
        float fE = (e() / 2) - (f + 4.0f);
        float fD = d() / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f2 = i;
            canvas.translate((f * f2) + fE + (f2 * 4.0f), fD);
            float[] fArr = this.h;
            canvas.scale(fArr[i], fArr[i]);
            canvas.drawCircle(0.0f, 0.0f, fMin, paint);
            canvas.restore();
        }
    }

    @Override // dc.oi1
    public ArrayList<ValueAnimator> g() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {120, PsExtractor.VIDEO_STREAM_MASK, 360};
        for (int i = 0; i < 3; i++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            valueAnimatorOfFloat.setDuration(750L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setStartDelay(iArr[i]);
            a(valueAnimatorOfFloat, new a(i));
            arrayList.add(valueAnimatorOfFloat);
        }
        return arrayList;
    }
}
