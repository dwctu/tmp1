package com.wear.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes4.dex */
public class RainView extends View {
    public Paint a;
    public Matrix b;
    public Random c;
    public boolean d;
    public List<a> e;
    public int f;

    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public float e;
        public Bitmap f;
    }

    public RainView(Context context) {
        this(context, null);
    }

    public final void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setFilterBitmap(true);
        this.a.setDither(true);
        this.b = new Matrix();
        this.c = new Random();
        this.e = new ArrayList();
    }

    public final void b() {
        c();
        for (int i = 0; i < 20; i++) {
            a aVar = new a();
            aVar.f = BitmapFactory.decodeResource(getResources(), this.f);
            aVar.a = this.c.nextInt(getWidth() - 200) + 100;
            aVar.b = -this.c.nextInt(getHeight());
            aVar.c = this.c.nextInt(4) - 2;
            aVar.d = 12;
            aVar.e = (this.c.nextInt(40) + 80) / 100.0f;
            this.e.add(aVar);
        }
    }

    public final void c() {
        List<a> list = this.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (a aVar : this.e) {
            if (!aVar.f.isRecycled()) {
                aVar.f.recycle();
            }
        }
        this.e.clear();
    }

    public void d(boolean z) {
        this.d = z;
        b();
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d) {
            boolean z = false;
            for (int i = 0; i < this.e.size(); i++) {
                this.b.reset();
                this.b.setScale(this.e.get(i).e, this.e.get(i).e);
                this.e.get(i).a += this.e.get(i).c;
                this.e.get(i).b += this.e.get(i).d;
                if (this.e.get(i).b <= getHeight()) {
                    z = true;
                }
                this.b.postTranslate(this.e.get(i).a, this.e.get(i).b);
                canvas.drawBitmap(this.e.get(i).f, this.b, this.a);
            }
            if (z) {
                postInvalidate();
            } else {
                c();
            }
        }
    }

    public void setImgResId(int i) {
        this.f = i;
    }

    public RainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = R.drawable.toolbar_icon_bottom_emojis;
        a();
    }
}
