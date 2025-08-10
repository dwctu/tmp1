package dc;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.io.File;

/* compiled from: L.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class e7 {
    public static boolean a = false;
    public static boolean b = false;
    public static String[] c;
    public static long[] d;
    public static int e;
    public static int f;
    public static ib g;
    public static hb h;
    public static volatile kb i;
    public static volatile jb j;

    /* compiled from: L.java */
    public class a implements hb {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // dc.hb
        @NonNull
        public File getCacheDir() {
            return new File(this.a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void a(String str) {
        if (b) {
            int i2 = e;
            if (i2 == 20) {
                f++;
                return;
            }
            c[i2] = str;
            d[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            e++;
        }
    }

    public static float b(String str) {
        int i2 = f;
        if (i2 > 0) {
            f = i2 - 1;
            return 0.0f;
        }
        if (!b) {
            return 0.0f;
        }
        int i3 = e - 1;
        e = i3;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(c[i3])) {
            TraceCompat.endSection();
            return (System.nanoTime() - d[e]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[e] + ".");
    }

    @NonNull
    public static jb c(@NonNull Context context) {
        jb jbVar = j;
        if (jbVar == null) {
            synchronized (jb.class) {
                jbVar = j;
                if (jbVar == null) {
                    hb aVar = h;
                    if (aVar == null) {
                        aVar = new a(context);
                    }
                    jbVar = new jb(aVar);
                    j = jbVar;
                }
            }
        }
        return jbVar;
    }

    @NonNull
    public static kb d(@NonNull Context context) {
        kb kbVar = i;
        if (kbVar == null) {
            synchronized (kb.class) {
                kbVar = i;
                if (kbVar == null) {
                    jb jbVarC = c(context);
                    ib ebVar = g;
                    if (ebVar == null) {
                        ebVar = new eb();
                    }
                    kbVar = new kb(jbVarC, ebVar);
                    i = kbVar;
                }
            }
        }
        return kbVar;
    }
}
