package dc;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import dc.kn;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<dc.qf<android.graphics.drawable.Drawable>>] */
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class rf implements ComponentCallbacks2, qn {
    public static final qo m = qo.q0(Bitmap.class).P();
    public final kf a;
    public final Context b;
    public final pn c;

    @GuardedBy("this")
    public final vn d;

    @GuardedBy("this")
    public final un e;

    @GuardedBy("this")
    public final wn f;
    public final Runnable g;
    public final Handler h;
    public final kn i;
    public final CopyOnWriteArrayList<po<Object>> j;

    @GuardedBy("this")
    public qo k;
    public boolean l;

    /* compiled from: RequestManager.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rf rfVar = rf.this;
            rfVar.c.b(rfVar);
        }
    }

    /* compiled from: RequestManager.java */
    public class b implements kn.a {

        @GuardedBy("RequestManager.this")
        public final vn a;

        public b(@NonNull vn vnVar) {
            this.a = vnVar;
        }

        @Override // dc.kn.a
        public void a(boolean z) {
            if (z) {
                synchronized (rf.this) {
                    this.a.e();
                }
            }
        }
    }

    static {
        qo.q0(GifDrawable.class).P();
        qo.r0(ii.c).Z(of.LOW).h0(true);
    }

    public rf(@NonNull kf kfVar, @NonNull pn pnVar, @NonNull un unVar, @NonNull Context context) {
        this(kfVar, pnVar, unVar, new vn(), kfVar.g(), context);
    }

    public synchronized void A(@NonNull qo qoVar) {
        this.k = qoVar.clone().b();
    }

    public synchronized void B(@NonNull cp<?> cpVar, @NonNull mo moVar) {
        this.f.j(cpVar);
        this.d.g(moVar);
    }

    public synchronized boolean C(@NonNull cp<?> cpVar) {
        mo request = cpVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.d.a(request)) {
            return false;
        }
        this.f.k(cpVar);
        cpVar.g(null);
        return true;
    }

    public final void D(@NonNull cp<?> cpVar) {
        boolean zC = C(cpVar);
        mo request = cpVar.getRequest();
        if (zC || this.a.r(cpVar) || request == null) {
            return;
        }
        cpVar.g(null);
        request.clear();
    }

    public final synchronized void E(@NonNull qo qoVar) {
        this.k = this.k.a(qoVar);
    }

    @NonNull
    public synchronized rf c(@NonNull qo qoVar) {
        E(qoVar);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> qf<ResourceType> d(@NonNull Class<ResourceType> cls) {
        return new qf<>(this.a, this, cls, this.b);
    }

    @NonNull
    @CheckResult
    public qf<Bitmap> j() {
        return d(Bitmap.class).a(m);
    }

    @NonNull
    @CheckResult
    public qf<Drawable> k() {
        return d(Drawable.class);
    }

    public void l(@Nullable cp<?> cpVar) {
        if (cpVar == null) {
            return;
        }
        D(cpVar);
    }

    public List<po<Object>> m() {
        return this.j;
    }

    public synchronized qo n() {
        return this.k;
    }

    @NonNull
    public <T> sf<?, T> o(Class<T> cls) {
        return this.a.i().e(cls);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // dc.qn
    public synchronized void onDestroy() {
        this.f.onDestroy();
        Iterator<cp<?>> it = this.f.d().iterator();
        while (it.hasNext()) {
            l(it.next());
        }
        this.f.c();
        this.d.b();
        this.c.a(this);
        this.c.a(this.i);
        this.h.removeCallbacks(this.g);
        this.a.u(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // dc.qn
    public synchronized void onStart() {
        z();
        this.f.onStart();
    }

    @Override // dc.qn
    public synchronized void onStop() {
        y();
        this.f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.l) {
            x();
        }
    }

    @NonNull
    @CheckResult
    public qf<Drawable> p(@Nullable Bitmap bitmap) {
        return k().D0(bitmap);
    }

    @NonNull
    @CheckResult
    public qf<Drawable> q(@Nullable Drawable drawable) {
        return k().E0(drawable);
    }

    @NonNull
    @CheckResult
    public qf<Drawable> r(@Nullable Uri uri) {
        return k().F0(uri);
    }

    @NonNull
    @CheckResult
    public qf<Drawable> s(@Nullable File file) {
        return k().G0(file);
    }

    @NonNull
    @CheckResult
    public qf<Drawable> t(@Nullable @DrawableRes @RawRes Integer num) {
        return k().H0(num);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.d + ", treeNode=" + this.e + "}";
    }

    @NonNull
    @CheckResult
    public qf<Drawable> u(@Nullable Object obj) {
        return k().I0(obj);
    }

    @NonNull
    @CheckResult
    public qf<Drawable> v(@Nullable String str) {
        return k().J0(str);
    }

    public synchronized void w() {
        this.d.c();
    }

    public synchronized void x() {
        w();
        Iterator<rf> it = this.e.a().iterator();
        while (it.hasNext()) {
            it.next().w();
        }
    }

    public synchronized void y() {
        this.d.d();
    }

    public synchronized void z() {
        this.d.f();
    }

    public rf(kf kfVar, pn pnVar, un unVar, vn vnVar, ln lnVar, Context context) {
        this.f = new wn();
        a aVar = new a();
        this.g = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.h = handler;
        this.a = kfVar;
        this.c = pnVar;
        this.e = unVar;
        this.d = vnVar;
        this.b = context;
        kn knVarA = lnVar.a(context.getApplicationContext(), new b(vnVar));
        this.i = knVarA;
        if (wp.q()) {
            handler.post(aVar);
        } else {
            pnVar.b(this);
        }
        pnVar.b(knVarA);
        this.j = new CopyOnWriteArrayList<>(kfVar.i().c());
        A(kfVar.i().d());
        kfVar.q(this);
    }
}
