package dc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import androidx.multidex.MultiDexExtractor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: LottieCompositionFactory.java */
/* loaded from: classes.dex */
public class g7 {
    public static final Map<String, o7<f7>> a = new HashMap();
    public static final byte[] b = {80, 75, 3, 4};

    /* compiled from: LottieCompositionFactory.java */
    public class a implements j7<f7> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // dc.j7
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(f7 f7Var) {
            g7.a.remove(this.a);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class b implements j7<Throwable> {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // dc.j7
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            g7.a.remove(this.a);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class c implements Callable<n7<f7>> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n7<f7> call() {
            n7<f7> n7VarC = e7.d(this.a).c(this.b, this.c);
            if (this.c != null && n7VarC.b() != null) {
                n9.b().c(this.c, n7VarC.b());
            }
            return n7VarC;
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class d implements Callable<n7<f7>> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n7<f7> call() {
            return g7.g(this.a, this.b, this.c);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class e implements Callable<n7<f7>> {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public e(WeakReference weakReference, Context context, int i, String str) {
            this.a = weakReference;
            this.b = context;
            this.c = i;
            this.d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n7<f7> call() {
            Context context = (Context) this.a.get();
            if (context == null) {
                context = this.b;
            }
            return g7.p(context, this.c, this.d);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class f implements Callable<n7<f7>> {
        public final /* synthetic */ InputStream a;
        public final /* synthetic */ String b;

        public f(InputStream inputStream, String str) {
            this.a = inputStream;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n7<f7> call() {
            return g7.i(this.a, this.b);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    public class g implements Callable<n7<f7>> {
        public final /* synthetic */ f7 a;

        public g(f7 f7Var) {
            this.a = f7Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n7<f7> call() {
            return new n7<>(this.a);
        }
    }

    public static o7<f7> b(@Nullable String str, Callable<n7<f7>> callable) {
        f7 f7VarA = str == null ? null : n9.b().a(str);
        if (f7VarA != null) {
            return new o7<>(new g(f7VarA));
        }
        if (str != null) {
            Map<String, o7<f7>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        o7<f7> o7Var = new o7<>(callable);
        if (str != null) {
            o7Var.f(new a(str));
            o7Var.e(new b(str));
            a.put(str, o7Var);
        }
        return o7Var;
    }

    @Nullable
    public static i7 c(f7 f7Var, String str) {
        for (i7 i7Var : f7Var.i().values()) {
            if (i7Var.b().equals(str)) {
                return i7Var;
            }
        }
        return null;
    }

    public static o7<f7> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static o7<f7> e(Context context, String str, @Nullable String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static n7<f7> f(Context context, String str) {
        return g(context, str, "asset_" + str);
    }

    @WorkerThread
    public static n7<f7> g(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(MultiDexExtractor.EXTRACTED_SUFFIX) && !str.endsWith(".lottie")) {
                return i(context.getAssets().open(str), str2);
            }
            return s(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e2) {
            return new n7<>((Throwable) e2);
        }
    }

    public static o7<f7> h(InputStream inputStream, @Nullable String str) {
        return b(str, new f(inputStream, str));
    }

    @WorkerThread
    public static n7<f7> i(InputStream inputStream, @Nullable String str) {
        return j(inputStream, str, true);
    }

    @WorkerThread
    public static n7<f7> j(InputStream inputStream, @Nullable String str, boolean z) throws IOException {
        try {
            return k(xc.I(wd4.d(wd4.k(inputStream))), str);
        } finally {
            if (z) {
                hd.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static n7<f7> k(xc xcVar, @Nullable String str) {
        return l(xcVar, str, true);
    }

    public static n7<f7> l(xc xcVar, @Nullable String str, boolean z) throws IOException {
        try {
            try {
                f7 f7VarA = ec.a(xcVar);
                if (str != null) {
                    n9.b().c(str, f7VarA);
                }
                n7<f7> n7Var = new n7<>(f7VarA);
                if (z) {
                    hd.c(xcVar);
                }
                return n7Var;
            } catch (Exception e2) {
                n7<f7> n7Var2 = new n7<>(e2);
                if (z) {
                    hd.c(xcVar);
                }
                return n7Var2;
            }
        } catch (Throwable th) {
            if (z) {
                hd.c(xcVar);
            }
            throw th;
        }
    }

    public static o7<f7> m(Context context, @RawRes int i) {
        return n(context, i, w(context, i));
    }

    public static o7<f7> n(Context context, @RawRes int i, @Nullable String str) {
        return b(str, new e(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    @WorkerThread
    public static n7<f7> o(Context context, @RawRes int i) {
        return p(context, i, w(context, i));
    }

    @WorkerThread
    public static n7<f7> p(Context context, @RawRes int i, @Nullable String str) {
        try {
            pd4 pd4VarD = wd4.d(wd4.k(context.getResources().openRawResource(i)));
            return v(pd4VarD).booleanValue() ? s(new ZipInputStream(pd4VarD.a0()), str) : i(pd4VarD.a0(), str);
        } catch (Resources.NotFoundException e2) {
            return new n7<>((Throwable) e2);
        }
    }

    public static o7<f7> q(Context context, String str) {
        return r(context, str, "url_" + str);
    }

    public static o7<f7> r(Context context, String str, @Nullable String str2) {
        return b(str2, new c(context, str, str2));
    }

    @WorkerThread
    public static n7<f7> s(ZipInputStream zipInputStream, @Nullable String str) throws IOException {
        try {
            return t(zipInputStream, str);
        } finally {
            hd.c(zipInputStream);
        }
    }

    @WorkerThread
    public static n7<f7> t(ZipInputStream zipInputStream, @Nullable String str) throws IOException {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            f7 f7VarB = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    f7VarB = l(xc.I(wd4.d(wd4.k(zipInputStream))), null, false).b();
                } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                    map.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (f7VarB == null) {
                return new n7<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                i7 i7VarC = c(f7VarB, (String) entry.getKey());
                if (i7VarC != null) {
                    i7VarC.f(hd.l((Bitmap) entry.getValue(), i7VarC.e(), i7VarC.c()));
                }
            }
            for (Map.Entry<String, i7> entry2 : f7VarB.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new n7<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                n9.b().c(str, f7VarB);
            }
            return new n7<>(f7VarB);
        } catch (IOException e2) {
            return new n7<>((Throwable) e2);
        }
    }

    public static boolean u(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Boolean v(pd4 pd4Var) {
        try {
            pd4 pd4VarPeek = pd4Var.peek();
            for (byte b2 : b) {
                if (pd4VarPeek.readByte() != b2) {
                    return Boolean.FALSE;
                }
            }
            pd4VarPeek.close();
            return Boolean.TRUE;
        } catch (Exception e2) {
            dd.b("Failed to check zip file header", e2);
            return Boolean.FALSE;
        }
    }

    public static String w(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(u(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }
}
