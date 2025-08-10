package com.huawei.hms.scankit.p;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.List;

/* compiled from: ParticleEffect.java */
/* loaded from: classes3.dex */
public class Qc {
    private long a = 0;
    private long b = 0;
    private int c;
    private int d;
    private int e;
    private float f;
    private Rect g;
    private Rc h;

    public Qc(Rc rc, Rect rect, int i, float f, int[] iArr) {
        this.c = 0;
        this.d = 0;
        this.h = rc;
        this.g = rect;
        this.e = i;
        if (iArr != null && iArr.length >= 2) {
            this.c = iArr[0];
            this.d = iArr[1];
        }
        this.f = f;
        c();
    }

    private void a() {
        Rc rc = this.h;
        if (rc != null) {
            rc.a();
        }
    }

    private int b() {
        float fA = Yc.a(1.0f);
        int iRed = Color.red(this.c);
        int iBlue = Color.blue(this.c);
        return Color.rgb((int) (iRed + ((Color.red(this.d) - iRed) * fA) + 0.5f), (int) (Color.green(this.c) + ((Color.green(this.d) - r3) * fA) + 0.5f), (int) (iBlue + ((Color.blue(this.d) - iBlue) * fA) + 0.5f));
    }

    private void c() {
        Rect rect;
        a();
        this.b = 0L;
        this.a = System.currentTimeMillis();
        Rc rc = this.h;
        if (rc == null || (rect = this.g) == null) {
            return;
        }
        rc.a(rect, this.e);
    }

    public void a(Canvas canvas, Rect rect) {
        if (this.h == null || canvas == null || rect == null) {
            return;
        }
        long jCurrentTimeMillis = this.b + (System.currentTimeMillis() - this.a);
        this.b = jCurrentTimeMillis;
        this.h.a(jCurrentTimeMillis);
        List<Pc> listB = this.h.b();
        if (listB == null || listB.isEmpty()) {
            return;
        }
        a(canvas, rect, listB);
        this.a = System.currentTimeMillis();
    }

    private void a(Canvas canvas, Rect rect, List<Pc> list) {
        for (Pc pc : list) {
            Paint paint = new Paint();
            if (pc.b() == 0) {
                pc.b(b());
            }
            paint.setColor(pc.b());
            boolean z = pc.d() > ((float) Math.max(rect.top, rect.bottom)) || pc.d() < ((float) Math.min(rect.top, rect.bottom));
            float fD = 0.0f;
            if (rect.height() != 0 && rect.width() != 0 && !z) {
                fD = (rect.bottom - pc.d()) / rect.height();
            }
            int iA = (int) (pc.a() * Math.abs(fD));
            if (iA > 0) {
                paint.setAlpha(iA);
                canvas.drawCircle(pc.c(), pc.d(), pc.f() * this.f, paint);
            }
        }
    }
}
