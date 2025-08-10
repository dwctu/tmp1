package dc;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.C;
import com.koushikdutta.async.http.cache.ResponseCacheMiddleware;
import com.wear.util.WearUtils;
import dc.vc4;
import dc.yc4;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: OkHttpUtils.java */
/* loaded from: classes4.dex */
public class nf3 {
    public static vc4 a;
    public static final tc4 b;

    /* compiled from: OkHttpUtils.java */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ d b;

        /* compiled from: OkHttpUtils.java */
        /* renamed from: dc.nf3$a$a, reason: collision with other inner class name */
        public class C0202a implements bc4 {
            public C0202a() {
            }

            @Override // dc.bc4
            public void onFailure(ac4 ac4Var, IOException iOException) {
                try {
                    d dVar = a.this.b;
                    if (dVar != null) {
                        dVar.onRequestComplete(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // dc.bc4
            public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
                try {
                    d dVar = a.this.b;
                    if (dVar != null) {
                        dVar.onRequestComplete(ad4Var.b().string());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public a(String str, d dVar) {
            this.a = str;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                try {
                    String str = this.a;
                    if (!str.startsWith("http")) {
                        str = WearUtils.e + this.a;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(WearUtils.B(str));
                    sb.append(str.lastIndexOf(".") > 0 ? str.substring(str.lastIndexOf(".")) : "");
                    String string = sb.toString();
                    try {
                        string = URLEncoder.encode(string, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                    }
                    File file = new File(WearUtils.T(ResponseCacheMiddleware.CACHE), string);
                    if (file.exists()) {
                        String strN1 = WearUtils.N1(file.getAbsolutePath());
                        if (!WearUtils.e1(strN1) && !strN1.contains("result")) {
                            d dVar = this.b;
                            if (dVar != null) {
                                dVar.onRequestComplete(strN1);
                                return;
                            }
                            return;
                        }
                    }
                    yc4.a aVar = new yc4.a();
                    aVar.k(str);
                    yc4 yc4VarB = aVar.b();
                    vc4.b bVarT = nf3.e().t();
                    bVarT.l(false);
                    bVarT.k(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
                    bVarT.b().a(yc4VarB).j(new C0202a());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception unused2) {
                d dVar2 = this.b;
                if (dVar2 != null) {
                    dVar2.onRequestComplete(null);
                }
            }
        }
    }

    /* compiled from: OkHttpUtils.java */
    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ e b;

        /* compiled from: OkHttpUtils.java */
        public class a implements bc4 {
            public a() {
            }

            @Override // dc.bc4
            public void onFailure(ac4 ac4Var, IOException iOException) {
                try {
                    e eVar = b.this.b;
                    if (eVar != null) {
                        eVar.a(null, iOException);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // dc.bc4
            public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
                e eVar = b.this.b;
                if (eVar != null) {
                    eVar.a(ad4Var, null);
                }
            }
        }

        public b(String str, e eVar) {
            this.a = str;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                yc4.a aVar = new yc4.a();
                aVar.k(this.a);
                aVar.d();
                yc4 yc4VarB = aVar.b();
                vc4.b bVarT = new vc4.b().b().t();
                bVarT.l(false);
                bVarT.k(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
                bVarT.b().a(yc4VarB).j(new a());
            } catch (Exception e) {
                try {
                    e eVar = this.b;
                    if (eVar != null) {
                        eVar.a(null, e);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* compiled from: OkHttpUtils.java */
    public class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ tc4 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d e;

        /* compiled from: OkHttpUtils.java */
        public class a implements bc4 {
            public a() {
            }

            @Override // dc.bc4
            public void onFailure(ac4 ac4Var, IOException iOException) {
                try {
                    d dVar = c.this.e;
                    if (dVar != null) {
                        dVar.onRequestComplete(null);
                    }
                    iOException.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // dc.bc4
            public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
                try {
                    if (c.this.e != null) {
                        bd4 bd4VarB = ad4Var.b();
                        c.this.e.onRequestComplete(bd4VarB != null ? bd4VarB.string() : null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public c(String str, tc4 tc4Var, String str2, String str3, d dVar) {
            this.a = str;
            this.b = tc4Var;
            this.c = str2;
            this.d = str3;
            this.e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            yc4 yc4VarB;
            try {
                String str = this.a;
                if (!str.startsWith("http")) {
                    str = "http://" + str;
                }
                String str2 = "doPostAsynOkHttp: " + str;
                zc4 zc4VarCreate = zc4.create(this.b, this.c);
                if (WearUtils.e1(this.d) || !this.d.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                    yc4.a aVar = new yc4.a();
                    aVar.k(str);
                    aVar.h(zc4VarCreate);
                    yc4VarB = aVar.b();
                } else {
                    yc4.a aVar2 = new yc4.a();
                    aVar2.k(str);
                    aVar2.a("api-version", "2");
                    aVar2.a("callback-push-version", "1.0.1");
                    aVar2.h(zc4VarCreate);
                    yc4VarB = aVar2.b();
                }
                nf3.e().a(yc4VarB).j(new a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: OkHttpUtils.java */
    public interface d {
        void onRequestComplete(String str);
    }

    /* compiled from: OkHttpUtils.java */
    public interface e {
        void a(ad4 ad4Var, Exception exc);
    }

    static {
        new HashMap();
        b = tc4.d("application/json; charset=utf-8");
    }

    public static void b(String str, d dVar) {
        vg3.b().a(new a(str, dVar));
    }

    public static void c(String str, String str2, String str3, d dVar) {
        d(str, str2, str3, dVar, b);
    }

    public static void d(String str, String str2, String str3, d dVar, tc4 tc4Var) {
        vg3.b().a(new c(str, tc4Var, str2, str3, dVar));
    }

    public static vc4 e() {
        if (a == null) {
            synchronized (vc4.class) {
                if (a == null) {
                    a = new vc4.b().b();
                }
            }
        }
        return a;
    }

    public static void f(String str, e eVar) {
        vg3.b().a(new b(str, eVar));
    }
}
