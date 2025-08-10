package dc;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SkinCompatManager.java */
/* loaded from: classes5.dex */
public class zg4 extends ki4 {
    public static volatile zg4 k;
    public final Context c;
    public final Object b = new Object();
    public boolean d = false;
    public List<jh4> e = new ArrayList();
    public List<ih4> f = new ArrayList();
    public List<ih4> g = new ArrayList();
    public SparseArray<c> h = new SparseArray<>();
    public boolean i = true;
    public boolean j = true;

    /* compiled from: SkinCompatManager.java */
    public class a extends AsyncTask<String, Void, String> {
        public final b a;
        public final c b;

        public a(b bVar, c cVar) {
            this.a = bVar;
            this.b = cVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            synchronized (zg4.this.b) {
                while (zg4.this.d) {
                    try {
                        zg4.this.b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                zg4.this.d = true;
            }
            try {
                if (strArr.length == 1) {
                    if (!TextUtils.isEmpty(this.b.b(zg4.this.c, strArr[0]))) {
                        return strArr[0];
                    }
                    th4.e().r(this.b);
                    return "";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            th4.e().q();
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            synchronized (zg4.this.b) {
                if (str != null) {
                    oi4 oi4VarB = oi4.b();
                    oi4VarB.e(str);
                    oi4VarB.f(this.b.getType());
                    oi4VarB.a();
                    zg4.this.c();
                    b bVar = this.a;
                    if (bVar != null) {
                        bVar.onSuccess();
                    }
                } else {
                    oi4 oi4VarB2 = oi4.b();
                    oi4VarB2.e("");
                    oi4VarB2.f(-1);
                    oi4VarB2.a();
                    b bVar2 = this.a;
                    if (bVar2 != null) {
                        bVar2.a("皮肤资源获取失败");
                    }
                }
                zg4.this.d = false;
                zg4.this.b.notifyAll();
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            b bVar = this.a;
            if (bVar != null) {
                bVar.onStart();
            }
        }
    }

    /* compiled from: SkinCompatManager.java */
    public interface b {
        void a(String str);

        void onStart();

        void onSuccess();
    }

    /* compiled from: SkinCompatManager.java */
    public interface c {
        Drawable a(Context context, String str, int i);

        String b(Context context, String str);

        String c(Context context, String str, int i);

        ColorStateList d(Context context, String str, int i);

        ColorStateList e(Context context, String str, int i);

        int getType();
    }

    public zg4(Context context) {
        this.c = context.getApplicationContext();
        s();
    }

    public static zg4 m() {
        return k;
    }

    public static zg4 r(Context context) {
        if (k == null) {
            synchronized (zg4.class) {
                if (k == null) {
                    k = new zg4(context);
                }
            }
        }
        oi4.d(context);
        return k;
    }

    public static zg4 z(Application application) {
        r(application);
        eh4.g(application);
        return k;
    }

    public zg4 i(ih4 ih4Var) {
        if (ih4Var instanceof jh4) {
            this.e.add((jh4) ih4Var);
        }
        this.f.add(ih4Var);
        return this;
    }

    public Context j() {
        return this.c;
    }

    @Deprecated
    public List<ih4> k() {
        return this.g;
    }

    public List<ih4> l() {
        return this.f;
    }

    public String n(String str) {
        return this.c.getPackageManager().getPackageArchiveInfo(str, 1).packageName;
    }

    public Resources o(String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageArchiveInfo = this.c.getPackageManager().getPackageArchiveInfo(str, 0);
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            Resources resourcesForApplication = this.c.getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo);
            Resources resources = this.c.getResources();
            return new Resources(resourcesForApplication.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SparseArray<c> p() {
        return this.h;
    }

    public List<jh4> q() {
        return this.e;
    }

    public final void s() {
        this.h.put(-1, new hi4());
        this.h.put(0, new fi4());
        this.h.put(1, new gi4());
        this.h.put(2, new ii4());
    }

    public boolean t() {
        return this.i;
    }

    public boolean u() {
        return this.j;
    }

    public AsyncTask v(String str, int i) {
        return w(str, null, i);
    }

    public AsyncTask w(String str, b bVar, int i) {
        c cVar = this.h.get(i);
        if (cVar == null) {
            return null;
        }
        return new a(bVar, cVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
    }

    public void x() {
        v("", -1);
    }

    public void y(b bVar) {
        w("", bVar, -1);
    }
}
