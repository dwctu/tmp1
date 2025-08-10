package dc;

import dc.ad4;
import dc.qc4;
import dc.yc4;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;

/* compiled from: Cache.java */
/* loaded from: classes5.dex */
public final class yb4 implements Closeable, Flushable {
    public final InternalCache a;
    public final DiskLruCache b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* compiled from: Cache.java */
    public class a implements InternalCache {
        public a() {
        }

        @Override // okhttp3.internal.cache.InternalCache
        public ad4 get(yc4 yc4Var) throws IOException {
            return yb4.this.e(yc4Var);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public CacheRequest put(ad4 ad4Var) throws IOException {
            return yb4.this.j(ad4Var);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void remove(yc4 yc4Var) throws IOException {
            yb4.this.p(yc4Var);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackConditionalCacheHit() {
            yb4.this.q();
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackResponse(CacheStrategy cacheStrategy) {
            yb4.this.x(cacheStrategy);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void update(ad4 ad4Var, ad4 ad4Var2) {
            yb4.this.y(ad4Var, ad4Var2);
        }
    }

    /* compiled from: Cache.java */
    public final class b implements CacheRequest {
        public final DiskLruCache.Editor a;
        public ee4 b;
        public ee4 c;
        public boolean d;

        /* compiled from: Cache.java */
        public class a extends rd4 {
            public final /* synthetic */ DiskLruCache.Editor a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ee4 ee4Var, yb4 yb4Var, DiskLruCache.Editor editor) {
                super(ee4Var);
                this.a = editor;
            }

            @Override // dc.rd4, dc.ee4, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                synchronized (yb4.this) {
                    b bVar = b.this;
                    if (bVar.d) {
                        return;
                    }
                    bVar.d = true;
                    yb4.this.c++;
                    super.close();
                    this.a.commit();
                }
            }
        }

        public b(DiskLruCache.Editor editor) {
            this.a = editor;
            ee4 ee4VarNewSink = editor.newSink(1);
            this.b = ee4VarNewSink;
            this.c = new a(ee4VarNewSink, yb4.this, editor);
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() throws IOException {
            synchronized (yb4.this) {
                if (this.d) {
                    return;
                }
                this.d = true;
                yb4.this.d++;
                Util.closeQuietly(this.b);
                try {
                    this.a.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public ee4 body() {
            return this.c;
        }
    }

    /* compiled from: Cache.java */
    public static class c extends bd4 {
        public final DiskLruCache.Snapshot a;
        public final pd4 b;
        public final String c;
        public final String d;

        /* compiled from: Cache.java */
        public class a extends sd4 {
            public final /* synthetic */ DiskLruCache.Snapshot a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, fe4 fe4Var, DiskLruCache.Snapshot snapshot) {
                super(fe4Var);
                this.a = snapshot;
            }

            @Override // dc.sd4, dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
            public void close() throws IOException {
                this.a.close();
                super.close();
            }
        }

        public c(DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.a = snapshot;
            this.c = str;
            this.d = str2;
            this.b = wd4.d(new a(this, snapshot.getSource(1), snapshot));
        }

        @Override // dc.bd4
        public long contentLength() {
            try {
                String str = this.d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // dc.bd4
        public tc4 contentType() {
            String str = this.c;
            if (str != null) {
                return tc4.d(str);
            }
            return null;
        }

        @Override // dc.bd4
        public pd4 source() {
            return this.b;
        }
    }

    public yb4(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    public static String f(rc4 rc4Var) {
        return qd4.h(rc4Var.toString()).l().j();
    }

    public static int m(pd4 pd4Var) throws IOException {
        try {
            long jP = pd4Var.P();
            String strZ = pd4Var.z();
            if (jP >= 0 && jP <= 2147483647L && strZ.isEmpty()) {
                return (int) jP;
            }
            throw new IOException("expected an int but was \"" + jP + strZ + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    public final void b(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    public ad4 e(yc4 yc4Var) throws IOException {
        try {
            DiskLruCache.Snapshot snapshot = this.b.get(f(yc4Var.j()));
            if (snapshot == null) {
                return null;
            }
            try {
                d dVar = new d(snapshot.getSource(0));
                ad4 ad4VarD = dVar.d(snapshot);
                if (dVar.b(yc4Var, ad4VarD)) {
                    return ad4VarD;
                }
                Util.closeQuietly(ad4VarD.b());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    public CacheRequest j(ad4 ad4Var) {
        DiskLruCache.Editor editorEdit;
        String strG = ad4Var.L().g();
        if (HttpMethod.invalidatesCache(ad4Var.L().g())) {
            try {
                p(ad4Var.L());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!strG.equals("GET") || HttpHeaders.hasVaryAll(ad4Var)) {
            return null;
        }
        d dVar = new d(ad4Var);
        try {
            editorEdit = this.b.edit(f(ad4Var.L().j()));
            if (editorEdit == null) {
                return null;
            }
            try {
                dVar.f(editorEdit);
                return new b(editorEdit);
            } catch (IOException unused2) {
                b(editorEdit);
                return null;
            }
        } catch (IOException unused3) {
            editorEdit = null;
        }
    }

    public void p(yc4 yc4Var) throws IOException {
        this.b.remove(f(yc4Var.j()));
    }

    public synchronized void q() {
        this.f++;
    }

    public synchronized void x(CacheStrategy cacheStrategy) {
        this.g++;
        if (cacheStrategy.networkRequest != null) {
            this.e++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.f++;
        }
    }

    public void y(ad4 ad4Var, ad4 ad4Var2) {
        DiskLruCache.Editor editorEdit;
        d dVar = new d(ad4Var2);
        try {
            editorEdit = ((c) ad4Var.b()).a.edit();
            if (editorEdit != null) {
                try {
                    dVar.f(editorEdit);
                    editorEdit.commit();
                } catch (IOException unused) {
                    b(editorEdit);
                }
            }
        } catch (IOException unused2) {
            editorEdit = null;
        }
    }

    public yb4(File file, long j, FileSystem fileSystem) {
        this.a = new a();
        this.b = DiskLruCache.create(fileSystem, file, 201105, 2, j);
    }

    /* compiled from: Cache.java */
    public static final class d {
        public static final String k = Platform.get().getPrefix() + "-Sent-Millis";
        public static final String l = Platform.get().getPrefix() + "-Received-Millis";
        public final String a;
        public final qc4 b;
        public final String c;
        public final wc4 d;
        public final int e;
        public final String f;
        public final qc4 g;
        public final pc4 h;
        public final long i;
        public final long j;

        public d(fe4 fe4Var) throws IOException {
            try {
                pd4 pd4VarD = wd4.d(fe4Var);
                this.a = pd4VarD.z();
                this.c = pd4VarD.z();
                qc4.a aVar = new qc4.a();
                int iM = yb4.m(pd4VarD);
                for (int i = 0; i < iM; i++) {
                    aVar.c(pd4VarD.z());
                }
                this.b = aVar.f();
                StatusLine statusLine = StatusLine.parse(pd4VarD.z());
                this.d = statusLine.protocol;
                this.e = statusLine.code;
                this.f = statusLine.message;
                qc4.a aVar2 = new qc4.a();
                int iM2 = yb4.m(pd4VarD);
                for (int i2 = 0; i2 < iM2; i2++) {
                    aVar2.c(pd4VarD.z());
                }
                String str = k;
                String strG = aVar2.g(str);
                String str2 = l;
                String strG2 = aVar2.g(str2);
                aVar2.h(str);
                aVar2.h(str2);
                this.i = strG != null ? Long.parseLong(strG) : 0L;
                this.j = strG2 != null ? Long.parseLong(strG2) : 0L;
                this.g = aVar2.f();
                if (a()) {
                    String strZ = pd4VarD.z();
                    if (strZ.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strZ + "\"");
                    }
                    this.h = pc4.c(!pd4VarD.N() ? dd4.forJavaName(pd4VarD.z()) : dd4.SSL_3_0, ec4.a(pd4VarD.z()), c(pd4VarD), c(pd4VarD));
                } else {
                    this.h = null;
                }
            } finally {
                fe4Var.close();
            }
        }

        public final boolean a() {
            return this.a.startsWith("https://");
        }

        public boolean b(yc4 yc4Var, ad4 ad4Var) {
            return this.a.equals(yc4Var.j().toString()) && this.c.equals(yc4Var.g()) && HttpHeaders.varyMatches(ad4Var, this.b, yc4Var);
        }

        public final List<Certificate> c(pd4 pd4Var) throws IOException, CertificateException {
            int iM = yb4.m(pd4Var);
            if (iM == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iM);
                for (int i = 0; i < iM; i++) {
                    String strZ = pd4Var.z();
                    nd4 nd4Var = new nd4();
                    nd4Var.j0(qd4.d(strZ));
                    arrayList.add(certificateFactory.generateCertificate(nd4Var.a0()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        public ad4 d(DiskLruCache.Snapshot snapshot) {
            String strC = this.g.c("Content-Type");
            String strC2 = this.g.c(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            yc4.a aVar = new yc4.a();
            aVar.k(this.a);
            aVar.g(this.c, null);
            aVar.f(this.b);
            yc4 yc4VarB = aVar.b();
            ad4.a aVar2 = new ad4.a();
            aVar2.q(yc4VarB);
            aVar2.o(this.d);
            aVar2.g(this.e);
            aVar2.l(this.f);
            aVar2.j(this.g);
            aVar2.b(new c(snapshot, strC, strC2));
            aVar2.h(this.h);
            aVar2.r(this.i);
            aVar2.p(this.j);
            return aVar2.c();
        }

        public final void e(od4 od4Var, List<Certificate> list) throws IOException {
            try {
                od4Var.F(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    od4Var.s(qd4.m(list.get(i).getEncoded()).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public void f(DiskLruCache.Editor editor) throws IOException {
            od4 od4VarC = wd4.c(editor.newSink(0));
            od4VarC.s(this.a).writeByte(10);
            od4VarC.s(this.c).writeByte(10);
            od4VarC.F(this.b.h()).writeByte(10);
            int iH = this.b.h();
            for (int i = 0; i < iH; i++) {
                od4VarC.s(this.b.e(i)).s(": ").s(this.b.j(i)).writeByte(10);
            }
            od4VarC.s(new StatusLine(this.d, this.e, this.f).toString()).writeByte(10);
            od4VarC.F(this.g.h() + 2).writeByte(10);
            int iH2 = this.g.h();
            for (int i2 = 0; i2 < iH2; i2++) {
                od4VarC.s(this.g.e(i2)).s(": ").s(this.g.j(i2)).writeByte(10);
            }
            od4VarC.s(k).s(": ").F(this.i).writeByte(10);
            od4VarC.s(l).s(": ").F(this.j).writeByte(10);
            if (a()) {
                od4VarC.writeByte(10);
                od4VarC.s(this.h.a().d()).writeByte(10);
                e(od4VarC, this.h.f());
                e(od4VarC, this.h.d());
                od4VarC.s(this.h.g().javaName()).writeByte(10);
            }
            od4VarC.close();
        }

        public d(ad4 ad4Var) {
            this.a = ad4Var.L().j().toString();
            this.b = HttpHeaders.varyHeaders(ad4Var);
            this.c = ad4Var.L().g();
            this.d = ad4Var.I();
            this.e = ad4Var.f();
            this.f = ad4Var.x();
            this.g = ad4Var.q();
            this.h = ad4Var.j();
            this.i = ad4Var.O();
            this.j = ad4Var.K();
        }
    }
}
