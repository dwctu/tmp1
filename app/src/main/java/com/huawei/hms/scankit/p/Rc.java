package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ParticleSystem.java */
/* loaded from: classes3.dex */
public class Rc {
    private static final Object a = new Object();
    private int d;
    private long e;
    private boolean f;
    private float g;
    private int[] h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Path o;
    private PathMeasure p;
    private final ArrayList<Pc> b = new ArrayList<>();
    private final ArrayList<Pc> c = new ArrayList<>();
    private boolean n = false;
    private Uc q = new Uc();
    private Wc r = new Wc();

    public Rc(int i, long j) {
        a(i, j);
        a((Bitmap) null);
    }

    private void b(long j) {
        PathMeasure pathMeasure;
        Pc pcRemove = this.b.remove(0);
        this.r.a(pcRemove);
        if (!this.n || (pathMeasure = this.p) == null) {
            pcRemove.a(this.e, a(this.k, this.j), a(this.m, this.l), j, this.q);
        } else {
            float[] fArrB = b(0.0f, pathMeasure.getLength());
            pcRemove.a(this.e, (int) fArrB[0], (int) fArrB[1], j, this.q);
        }
        synchronized (a) {
            this.c.add(pcRemove);
            this.i++;
        }
    }

    private void c() {
        ArrayList arrayList;
        synchronized (a) {
            arrayList = new ArrayList(this.c);
        }
        this.b.addAll(arrayList);
    }

    public Rc a(float f, float f2) {
        a(new Xc(f, f2));
        return this;
    }

    private void a(Vc vc) {
        if (this.r == null) {
            this.r = new Wc();
        }
        this.r.a(vc);
    }

    public Rc a(int i, int i2, long j, long j2, Interpolator interpolator) {
        a(new Tc(i, i2, j, j2, interpolator));
        return this;
    }

    private void a(Sc sc) {
        if (this.q == null) {
            this.q = new Uc();
        }
        this.q.a(sc);
    }

    private void a(int i, long j) {
        this.h = new int[2];
        this.d = i;
        this.e = j;
    }

    private void a(Bitmap bitmap) {
        for (int i = 0; i < this.d; i++) {
            this.b.add(new Pc(bitmap));
        }
    }

    public void a(Rect rect, int i) {
        a(rect);
        a(i);
    }

    private float[] b(float f, float f2) {
        float fA;
        if (Float.compare(f, f2) <= 0) {
            fA = Yc.a(f2 - f) + f;
        } else {
            fA = f2 + Yc.a(f - f2);
        }
        if (this.p == null) {
            this.p = new PathMeasure(this.o, true);
        }
        float[] fArr = new float[2];
        this.p.getPosTan(fA, fArr, null);
        float f3 = fArr[0];
        int[] iArr = this.h;
        fArr[0] = f3 - iArr[0];
        fArr[1] = fArr[1] - iArr[1];
        return fArr;
    }

    private void a(int i) {
        synchronized (a) {
            this.i = 0;
        }
        this.g = i / 1000.0f;
        this.f = true;
    }

    private void a(Rect rect) {
        int i = rect.left - this.h[0];
        this.k = i;
        this.j = i + rect.width();
        int i2 = rect.top - this.h[1];
        this.m = i2;
        this.l = i2 + rect.height();
    }

    public List<Pc> b() {
        List<Pc> listUnmodifiableList;
        synchronized (a) {
            listUnmodifiableList = Collections.unmodifiableList(this.c);
        }
        return listUnmodifiableList;
    }

    private int a(int i, int i2) {
        if (i == i2) {
            return i;
        }
        if (i < i2) {
            return Yc.a(i2 - i) + i;
        }
        return Yc.a(i - i2) + i2;
    }

    public void a(long j) {
        boolean z = this.f;
        float f = this.g * j;
        ArrayList arrayList = new ArrayList();
        synchronized (a) {
            while (z) {
                if (this.b.isEmpty() || this.i >= f) {
                    break;
                } else {
                    b(j);
                }
            }
            Iterator<Pc> it = this.c.iterator();
            while (it.hasNext()) {
                Pc next = it.next();
                if (!next.a(j)) {
                    it.remove();
                    arrayList.add(next);
                }
            }
        }
        this.b.addAll(arrayList);
    }

    public void a() {
        c();
    }
}
