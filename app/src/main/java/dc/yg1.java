package dc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnimConfig.kt */
/* loaded from: classes3.dex */
public final class yg1 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public yg1(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final int a() {
        return this.d;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof yg1) {
                yg1 yg1Var = (yg1) obj;
                if (this.a == yg1Var.a) {
                    if (this.b == yg1Var.b) {
                        if (this.c == yg1Var.c) {
                            if (this.d == yg1Var.d) {
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    @NotNull
    public String toString() {
        return "PointRect(x=" + this.a + ", y=" + this.b + ", w=" + this.c + ", h=" + this.d + ")";
    }
}
