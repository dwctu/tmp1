package dc;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* compiled from: DocumentData.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class i9 {
    public final String a;
    public final String b;
    public final float c;
    public final a d;
    public final int e;
    public final float f;
    public final float g;

    @ColorInt
    public final int h;

    @ColorInt
    public final int i;
    public final float j;
    public final boolean k;

    /* compiled from: DocumentData.java */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public i9(String str, String str2, float f, a aVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = f;
        this.d = aVar;
        this.e = i;
        this.f = f2;
        this.g = f3;
        this.h = i2;
        this.i = i3;
        this.j = f4;
        this.k = z;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c)) * 31) + this.d.ordinal()) * 31) + this.e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.h;
    }
}
