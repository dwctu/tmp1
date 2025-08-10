package dc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IRenderListener.kt */
/* loaded from: classes3.dex */
public interface xg1 {

    /* compiled from: IRenderListener.kt */
    public static final class a {
        public static void a(xg1 xg1Var, int i, int i2, @Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        }

        public static void b(xg1 xg1Var, int i, int i2) {
        }
    }

    void a(int i, int i2);

    void b(int i, int i2, @Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3);

    void c();

    void d();

    int e();

    void f(@NotNull ng1 ng1Var);

    void g();

    void h();

    void swapBuffers();
}
