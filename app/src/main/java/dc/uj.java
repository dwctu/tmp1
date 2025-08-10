package dc;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public final class uj {
    public final int a;
    public final int b;
    public final Context c;
    public final int d;

    /* compiled from: MemorySizeCalculator.java */
    public static final class a {
        public static final int i;
        public final Context a;
        public ActivityManager b;
        public c c;
        public float e;
        public float d = 2.0f;
        public float f = 0.4f;
        public float g = 0.33f;
        public int h = 4194304;

        static {
            i = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.e = i;
            this.a = context;
            this.b = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !uj.e(this.b)) {
                return;
            }
            this.e = 0.0f;
        }

        public uj a() {
            return new uj(this);
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    public static final class b implements c {
        public final DisplayMetrics a;

        public b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // dc.uj.c
        public int a() {
            return this.a.heightPixels;
        }

        @Override // dc.uj.c
        public int b() {
            return this.a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    public interface c {
        int a();

        int b();
    }

    public uj(a aVar) {
        this.c = aVar.a;
        int i = e(aVar.b) ? aVar.h / 2 : aVar.h;
        this.d = i;
        int iC = c(aVar.b, aVar.f, aVar.g);
        float fB = aVar.c.b() * aVar.c.a() * 4;
        int iRound = Math.round(aVar.e * fB);
        int iRound2 = Math.round(fB * aVar.d);
        int i2 = iC - i;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.b = iRound2;
            this.a = iRound;
        } else {
            float f = i2;
            float f2 = aVar.e;
            float f3 = aVar.d;
            float f4 = f / (f2 + f3);
            this.b = Math.round(f3 * f4);
            this.a = Math.round(f4 * aVar.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.b));
            sb.append(", pool size: ");
            sb.append(f(this.a));
            sb.append(", byte array size: ");
            sb.append(f(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > iC);
            sb.append(", max size: ");
            sb.append(f(iC));
            sb.append(", memoryClass: ");
            sb.append(aVar.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.b));
            sb.toString();
        }
    }

    public static int c(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    @TargetApi(19)
    public static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public final String f(int i) {
        return Formatter.formatFileSize(this.c, i);
    }
}
