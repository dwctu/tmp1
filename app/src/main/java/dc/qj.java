package dc;

import android.util.Log;
import dc.mj;
import dc.tf;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class qj implements mj {
    public final File b;
    public final long c;
    public tf e;
    public final oj d = new oj();
    public final vj a = new vj();

    @Deprecated
    public qj(File file, long j) {
        this.b = file;
        this.c = j;
    }

    public static mj c(File file, long j) {
        return new qj(file, j);
    }

    @Override // dc.mj
    public void a(xg xgVar, mj.b bVar) {
        tf tfVarD;
        String strB = this.a.b(xgVar);
        this.d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                String str = "Put: Obtained: " + strB + " for for Key: " + xgVar;
            }
            try {
                tfVarD = d();
            } catch (IOException unused) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
            if (tfVarD.X(strB) != null) {
                return;
            }
            tf.c cVarL = tfVarD.L(strB);
            if (cVarL == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + strB);
            }
            try {
                if (bVar.a(cVarL.f(0))) {
                    cVarL.e();
                }
                cVarL.b();
            } catch (Throwable th) {
                cVarL.b();
                throw th;
            }
        } finally {
            this.d.b(strB);
        }
    }

    @Override // dc.mj
    public File b(xg xgVar) {
        String strB = this.a.b(xgVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            String str = "Get: Obtained: " + strB + " for for Key: " + xgVar;
        }
        try {
            tf.e eVarX = d().X(strB);
            if (eVarX != null) {
                return eVarX.a(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final synchronized tf d() throws IOException {
        if (this.e == null) {
            this.e = tf.d0(this.b, 1, 1, this.c);
        }
        return this.e;
    }
}
