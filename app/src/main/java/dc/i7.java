package dc;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: LottieImageAsset.java */
/* loaded from: classes.dex */
public class i7 {
    public final int a;
    public final int b;
    public final String c;
    public final String d;

    @Nullable
    public Bitmap e;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public i7(int i, int i2, String str, String str2, String str3) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
    }

    @Nullable
    public Bitmap a() {
        return this.e;
    }

    public String b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.a;
    }

    public void f(@Nullable Bitmap bitmap) {
        this.e = bitmap;
    }
}
