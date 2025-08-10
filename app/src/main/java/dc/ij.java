package dc;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class ij implements cj {
    public static final Bitmap.Config j = Bitmap.Config.ARGB_8888;
    public final jj a;
    public final Set<Bitmap.Config> b;
    public final a c;
    public long d;
    public long e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* compiled from: LruBitmapPool.java */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    public static final class b implements a {
        @Override // dc.ij.a
        public void a(Bitmap bitmap) {
        }

        @Override // dc.ij.a
        public void b(Bitmap bitmap) {
        }
    }

    public ij(long j2, jj jjVar, Set<Bitmap.Config> set) {
        this.d = j2;
        this.a = jjVar;
        this.b = set;
        this.c = new b();
    }

    @TargetApi(26)
    public static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    public static Bitmap g(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = j;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            hashSet.add(null);
        }
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static jj l() {
        return Build.VERSION.SDK_INT >= 19 ? new lj() : new aj();
    }

    @TargetApi(19)
    public static void o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    public static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    @Override // dc.cj
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            String str = "trimMemory, level=" + i;
        }
        if (i >= 40 || (Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            b();
        } else if (i >= 20 || i == 15) {
            q(n() / 2);
        }
    }

    @Override // dc.cj
    public void b() {
        Log.isLoggable("LruBitmapPool", 3);
        q(0L);
    }

    @Override // dc.cj
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.a.e(bitmap) <= this.d && this.b.contains(bitmap.getConfig())) {
                int iE = this.a.e(bitmap);
                this.a.c(bitmap);
                this.c.b(bitmap);
                this.h++;
                this.e += iE;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    String str = "Put bitmap in pool=" + this.a.a(bitmap);
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                String str2 = "Reject bitmap from pool, bitmap: " + this.a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // dc.cj
    @NonNull
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapM = m(i, i2, config);
        if (bitmapM == null) {
            return g(i, i2, config);
        }
        bitmapM.eraseColor(0);
        return bitmapM;
    }

    @Override // dc.cj
    @NonNull
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapM = m(i, i2, config);
        return bitmapM == null ? g(i, i2, config) : bitmapM;
    }

    public final void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    public final void i() {
        String str = "Hits=" + this.f + ", misses=" + this.g + ", puts=" + this.h + ", evictions=" + this.i + ", currentSize=" + this.e + ", maxSize=" + this.d + "\nStrategy=" + this.a;
    }

    public final void j() {
        q(this.d);
    }

    @Nullable
    public final synchronized Bitmap m(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap bitmapD;
        f(config);
        bitmapD = this.a.d(i, i2, config != null ? config : j);
        if (bitmapD == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                String str = "Missing bitmap=" + this.a.b(i, i2, config);
            }
            this.g++;
        } else {
            this.f++;
            this.e -= this.a.e(bitmapD);
            this.c.a(bitmapD);
            p(bitmapD);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            String str2 = "Get bitmap=" + this.a.b(i, i2, config);
        }
        h();
        return bitmapD;
    }

    public long n() {
        return this.d;
    }

    public final synchronized void q(long j2) {
        while (this.e > j2) {
            Bitmap bitmapRemoveLast = this.a.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    i();
                }
                this.e = 0L;
                return;
            }
            this.c.a(bitmapRemoveLast);
            this.e -= this.a.e(bitmapRemoveLast);
            this.i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                String str = "Evicting bitmap=" + this.a.a(bitmapRemoveLast);
            }
            h();
            bitmapRemoveLast.recycle();
        }
    }

    public ij(long j2) {
        this(j2, l(), k());
    }
}
