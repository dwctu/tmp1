package dc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: CustomToastStyle.java */
/* loaded from: classes2.dex */
public class o71 implements m71<View> {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;

    public o71(int i) {
        this(i, 17);
    }

    @Override // dc.m71
    public float a() {
        return this.e;
    }

    @Override // dc.m71
    public View b(Context context) {
        return LayoutInflater.from(context).inflate(this.a, (ViewGroup) null);
    }

    @Override // dc.m71
    public float c() {
        return this.f;
    }

    @Override // dc.m71
    public int d() {
        return this.b;
    }

    @Override // dc.m71
    public int e() {
        return this.c;
    }

    @Override // dc.m71
    public int f() {
        return this.d;
    }

    public o71(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public o71(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0.0f, 0.0f);
    }

    public o71(int i, int i2, int i3, int i4, float f, float f2) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = f;
        this.f = f2;
    }
}
