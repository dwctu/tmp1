package dc;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.wear.widget.seekbar.RangeSeekBar;
import com.wear.widget.seekbar.VerticalRangeSeekBar;

/* compiled from: VerticalSeekBar.java */
/* loaded from: classes4.dex */
public class bt3 extends ys3 {
    public int R;
    public VerticalRangeSeekBar S;

    public bt3(RangeSeekBar rangeSeekBar, AttributeSet attributeSet, boolean z) {
        super(rangeSeekBar, attributeSet, z);
        A(attributeSet);
        this.S = (VerticalRangeSeekBar) rangeSeekBar;
    }

    private void A(AttributeSet attributeSet) {
        try {
            TypedArray typedArrayObtainStyledAttributes = d().obtainStyledAttributes(attributeSet, vi1.VerticalRangeSeekBar);
            this.R = typedArrayObtainStyledAttributes.getInt(0, 1);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // dc.ys3
    public void E(Canvas canvas, Paint paint, String str) {
        if (str == null) {
            return;
        }
        if (this.R == 1) {
            U(canvas, paint, str);
        } else {
            super.E(canvas, paint, str);
        }
    }

    @Override // dc.ys3
    public void F(Canvas canvas) {
        Bitmap bitmap = this.C;
        if (bitmap != null && !this.G) {
            canvas.drawBitmap(bitmap, 0.0f, this.I.getProgressTop() + ((this.I.getProgressHeight() - this.Q) / 2.0f), (Paint) null);
            return;
        }
        Bitmap bitmap2 = this.B;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, (this.I.getProgressTop() - (this.Q / 2.0f)) + this.I.getProgressHeight(), (Paint) null);
        }
    }

    public void U(Canvas canvas, Paint paint, String str) {
        paint.setTextSize(q());
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(f());
        int i = 0;
        paint.getTextBounds(str, 0, str.length(), this.L);
        int iHeight = this.L.height() + j() + k();
        if (r() > iHeight) {
            iHeight = r();
        }
        int iWidth = this.L.width() + l() + i();
        if (g() > iWidth) {
            iWidth = g();
        }
        Rect rect = this.M;
        rect.left = (this.P / 2) - (iHeight / 2);
        rect.top = ((this.w - iWidth) - this.Q) - h();
        Rect rect2 = this.M;
        rect2.right = rect2.left + iHeight;
        int i2 = rect2.top + iWidth;
        rect2.bottom = i2;
        if (this.D == null) {
            int i3 = this.P / 2;
            int iE = i3 - e();
            int iE2 = i2 - e();
            int iE3 = e() + i3;
            this.K.reset();
            this.K.moveTo(i3, i2);
            float f = iE;
            float f2 = iE2;
            this.K.lineTo(f, f2);
            this.K.lineTo(iE3, f2);
            this.K.close();
            canvas.drawPath(this.K, paint);
            this.M.bottom -= e();
            this.M.top -= e();
        }
        int iB = at3.b(d(), 1.0f);
        int iWidth2 = (((this.M.width() / 2) - ((int) (this.I.getProgressWidth() * this.x))) - this.I.getProgressLeft()) + iB;
        int iWidth3 = (((this.M.width() / 2) - ((int) (this.I.getProgressWidth() * (1.0f - this.x)))) - this.I.getProgressPaddingRight()) + iB;
        if (iWidth2 > 0) {
            Rect rect3 = this.M;
            rect3.left += iWidth2;
            rect3.right += iWidth2;
        } else if (iWidth3 > 0) {
            Rect rect4 = this.M;
            rect4.left -= iWidth3;
            rect4.right -= iWidth3;
        }
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            at3.c(canvas, paint, bitmap, this.M);
        } else if (m() > 0.0f) {
            canvas.drawRoundRect(new RectF(this.M), m(), m(), paint);
        } else {
            canvas.drawRect(this.M, paint);
        }
        Rect rect5 = this.M;
        int iWidth4 = ((rect5.left + ((rect5.width() - this.L.width()) / 2)) + j()) - k();
        Rect rect6 = this.M;
        int iHeight2 = ((rect6.bottom - ((rect6.height() - this.L.height()) / 2)) + l()) - i();
        paint.setColor(p());
        float f3 = iWidth4;
        float fWidth = (this.L.width() / 2.0f) + f3;
        float f4 = iHeight2;
        float fHeight = f4 - (this.L.height() / 2.0f);
        if (this.R == 1) {
            if (this.S.getOrientation() == 1) {
                i = 90;
            } else if (this.S.getOrientation() == 2) {
                i = -90;
            }
        }
        if (i != 0) {
            canvas.rotate(i, fWidth, fHeight);
        }
        canvas.drawText(str, f3, f4, paint);
        if (i != 0) {
            canvas.rotate(-i, fWidth, fHeight);
        }
    }
}
