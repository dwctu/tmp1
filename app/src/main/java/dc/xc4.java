package dc;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.platform.Platform;

/* compiled from: RealCall.java */
/* loaded from: classes5.dex */
public final class xc4 implements ac4 {
    public final vc4 a;
    public Transmitter b;
    public final yc4 c;
    public final boolean d;
    public boolean e;

    /* compiled from: RealCall.java */
    public final class a extends NamedRunnable {
        public final bc4 a;
        public volatile AtomicInteger b;

        public a(bc4 bc4Var) {
            super("OkHttp %s", xc4.this.e());
            this.b = new AtomicInteger(0);
            this.a = bc4Var;
        }

        public AtomicInteger a() {
            return this.b;
        }

        public void b(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    xc4.this.b.noMoreExchanges(interruptedIOException);
                    this.a.onFailure(xc4.this, interruptedIOException);
                    xc4.this.a.k().g(this);
                }
            } catch (Throwable th) {
                xc4.this.a.k().g(this);
                throw th;
            }
        }

        public xc4 c() {
            return xc4.this;
        }

        public String d() {
            return xc4.this.c.j().n();
        }

        public void e(a aVar) {
            this.b = aVar.b;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Throwable th;
            boolean z;
            IOException e;
            xc4.this.b.timeoutEnter();
            try {
                try {
                    z = true;
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                try {
                    this.a.onResponse(xc4.this, xc4.this.c());
                } catch (IOException e3) {
                    e = e3;
                    if (z) {
                        Platform.get().log(4, "Callback failure for " + xc4.this.f(), e);
                    } else {
                        this.a.onFailure(xc4.this, e);
                    }
                    xc4.this.a.k().g(this);
                } catch (Throwable th3) {
                    th = th3;
                    xc4.this.cancel();
                    if (!z) {
                        IOException iOException = new IOException("canceled due to " + th);
                        iOException.addSuppressed(th);
                        this.a.onFailure(xc4.this, iOException);
                    }
                    throw th;
                }
                xc4.this.a.k().g(this);
            } catch (Throwable th4) {
                xc4.this.a.k().g(this);
                throw th4;
            }
        }
    }

    public xc4(vc4 vc4Var, yc4 yc4Var, boolean z) {
        this.a = vc4Var;
        this.c = yc4Var;
        this.d = z;
    }

    public static xc4 d(vc4 vc4Var, yc4 yc4Var, boolean z) {
        xc4 xc4Var = new xc4(vc4Var, yc4Var, z);
        xc4Var.b = new Transmitter(vc4Var, xc4Var);
        return xc4Var;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public xc4 clone() {
        return d(this.a, this.c, this.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public dc.ad4 c() throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            dc.vc4 r0 = r11.a
            java.util.List r0 = r0.q()
            r1.addAll(r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            dc.vc4 r2 = r11.a
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            dc.vc4 r2 = r11.a
            dc.jc4 r2 = r2.i()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            dc.vc4 r2 = r11.a
            okhttp3.internal.cache.InternalCache r2 = r2.r()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = new okhttp3.internal.connection.ConnectInterceptor
            dc.vc4 r2 = r11.a
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r11.d
            if (r0 != 0) goto L4b
            dc.vc4 r0 = r11.a
            java.util.List r0 = r0.s()
            r1.addAll(r0)
        L4b:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r2 = r11.d
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.http.RealInterceptorChain r10 = new okhttp3.internal.http.RealInterceptorChain
            okhttp3.internal.connection.Transmitter r2 = r11.b
            r3 = 0
            r4 = 0
            dc.yc4 r5 = r11.c
            dc.vc4 r0 = r11.a
            int r7 = r0.f()
            dc.vc4 r0 = r11.a
            int r8 = r0.A()
            dc.vc4 r0 = r11.a
            int r9 = r0.E()
            r0 = r10
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            r1 = 0
            dc.yc4 r2 = r11.c     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            dc.ad4 r2 = r10.proceed(r2)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            okhttp3.internal.connection.Transmitter r3 = r11.b     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            boolean r3 = r3.isCanceled()     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            if (r3 != 0) goto L8a
            okhttp3.internal.connection.Transmitter r0 = r11.b
            r0.noMoreExchanges(r1)
            return r2
        L8a:
            okhttp3.internal.Util.closeQuietly(r2)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            throw r2     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
        L95:
            r2 = move-exception
            goto La3
        L97:
            r0 = move-exception
            r2 = 1
            okhttp3.internal.connection.Transmitter r3 = r11.b     // Catch: java.lang.Throwable -> La0
            java.io.IOException r0 = r3.noMoreExchanges(r0)     // Catch: java.lang.Throwable -> La0
            throw r0     // Catch: java.lang.Throwable -> La0
        La0:
            r0 = move-exception
            r2 = r0
            r0 = 1
        La3:
            if (r0 != 0) goto Laa
            okhttp3.internal.connection.Transmitter r0 = r11.b
            r0.noMoreExchanges(r1)
        Laa:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.xc4.c():dc.ad4");
    }

    @Override // dc.ac4
    public void cancel() throws IOException {
        this.b.cancel();
    }

    public String e() {
        return this.c.j().E();
    }

    @Override // dc.ac4
    public ad4 execute() throws IOException {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        this.b.timeoutEnter();
        this.b.callStart();
        try {
            this.a.k().c(this);
            return c();
        } finally {
            this.a.k().h(this);
        }
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.d ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(e());
        return sb.toString();
    }

    @Override // dc.ac4
    public boolean isCanceled() {
        return this.b.isCanceled();
    }

    @Override // dc.ac4
    public void j(bc4 bc4Var) {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        this.b.callStart();
        this.a.k().b(new a(bc4Var));
    }

    @Override // dc.ac4
    public yc4 request() {
        return this.c;
    }

    @Override // dc.ac4
    public ge4 timeout() {
        return this.b.timeout();
    }
}
