package dc;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.broadcom.bt.util.io.FilenameUtils;
import com.broadcom.bt.util.io.IOUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class tf implements Closeable {
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public final int e;
    public long f;
    public final int g;
    public Writer i;
    public int k;
    public long h = 0;
    public final LinkedHashMap<String, d> j = new LinkedHashMap<>(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    public final Callable<Void> n = new a();

    /* compiled from: DiskLruCache.java */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (tf.this) {
                if (tf.this.i == null) {
                    return null;
                }
                tf.this.k0();
                if (tf.this.b0()) {
                    tf.this.h0();
                    tf.this.k = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class c {
        public final d a;
        public final boolean[] b;
        public boolean c;

        public /* synthetic */ c(tf tfVar, d dVar, a aVar) {
            this(dVar);
        }

        public void a() throws IOException {
            tf.this.C(this, false);
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            tf.this.C(this, true);
            this.c = true;
        }

        public File f(int i) throws IOException {
            File fileK;
            synchronized (tf.this) {
                if (this.a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.a.e) {
                    this.b[i] = true;
                }
                fileK = this.a.k(i);
                if (!tf.this.a.exists()) {
                    tf.this.a.mkdirs();
                }
            }
            return fileK;
        }

        public c(d dVar) {
            this.a = dVar;
            this.b = dVar.e ? null : new boolean[tf.this.g];
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class d {
        public final String a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public c f;
        public long g;

        public /* synthetic */ d(tf tfVar, String str, a aVar) {
            this(str);
        }

        public File j(int i) {
            return this.c[i];
        }

        public File k(int i) {
            return this.d[i];
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != tf.this.g) {
                m(strArr);
                throw null;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    m(strArr);
                    throw null;
                }
            }
        }

        public d(String str) {
            this.a = str;
            this.b = new long[tf.this.g];
            this.c = new File[tf.this.g];
            this.d = new File[tf.this.g];
            StringBuilder sb = new StringBuilder(str);
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i = 0; i < tf.this.g; i++) {
                sb.append(i);
                this.c[i] = new File(tf.this.a, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(tf.this.a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class e {
        public final File[] a;

        public /* synthetic */ e(tf tfVar, String str, long j, File[] fileArr, long[] jArr, a aVar) {
            this(tfVar, str, j, fileArr, jArr);
        }

        public File a(int i) {
            return this.a[i];
        }

        public e(tf tfVar, String str, long j, File[] fileArr, long[] jArr) {
            this.a = fileArr;
        }
    }

    public tf(File file, int i, int i2, long j) {
        this.a = file;
        this.e = i;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }

    @TargetApi(26)
    public static void A(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void K(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void V(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static tf d0(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                j0(file2, file3, false);
            }
        }
        tf tfVar = new tf(file, i, i2, j);
        if (tfVar.b.exists()) {
            try {
                tfVar.f0();
                tfVar.e0();
                return tfVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                tfVar.I();
            }
        }
        file.mkdirs();
        tf tfVar2 = new tf(file, i, i2, j);
        tfVar2.h0();
        return tfVar2;
    }

    public static void j0(File file, File file2, boolean z) throws IOException {
        if (z) {
            K(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized void C(c cVar, boolean z) throws IOException {
        d dVar = cVar.a;
        if (dVar.f != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.e) {
            for (int i = 0; i < this.g; i++) {
                if (!cVar.b[i]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dVar.k(i).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.g; i2++) {
            File fileK = dVar.k(i2);
            if (!z) {
                K(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i2);
                fileK.renameTo(fileJ);
                long j = dVar.b[i2];
                long length = fileJ.length();
                dVar.b[i2] = length;
                this.h = (this.h - j) + length;
            }
        }
        this.k++;
        dVar.f = null;
        if (dVar.e || z) {
            dVar.e = true;
            this.i.append((CharSequence) "CLEAN");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append((CharSequence) dVar.l());
            this.i.append('\n');
            if (z) {
                long j2 = this.l;
                this.l = 1 + j2;
                dVar.g = j2;
            }
        } else {
            this.j.remove(dVar.a);
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append('\n');
        }
        V(this.i);
        if (this.h > this.f || b0()) {
            this.m.submit(this.n);
        }
    }

    public void I() throws IOException {
        close();
        vf.b(this.a);
    }

    public c L(String str) throws IOException {
        return O(str, -1L);
    }

    public final synchronized c O(String str, long j) throws IOException {
        y();
        d dVar = this.j.get(str);
        a aVar = null;
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.j.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f = cVar;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        V(this.i);
        return cVar;
    }

    public synchronized e X(String str) throws IOException {
        y();
        d dVar = this.j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.e) {
            return null;
        }
        for (File file : dVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (b0()) {
            this.m.submit(this.n);
        }
        return new e(this, str, dVar.g, dVar.c, dVar.b, null);
    }

    public final boolean b0() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i == null) {
            return;
        }
        Iterator it = new ArrayList(this.j.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f != null) {
                dVar.f.a();
            }
        }
        k0();
        A(this.i);
        this.i = null;
    }

    public final void e0() throws IOException {
        K(this.c);
        Iterator<d> it = this.j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.g) {
                    this.h += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.g) {
                    K(next.j(i));
                    K(next.k(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void f0() throws IOException {
        uf ufVar = new uf(new FileInputStream(this.b), vf.a);
        try {
            String strJ = ufVar.j();
            String strJ2 = ufVar.j();
            String strJ3 = ufVar.j();
            String strJ4 = ufVar.j();
            String strJ5 = ufVar.j();
            if (!"libcore.io.DiskLruCache".equals(strJ) || !"1".equals(strJ2) || !Integer.toString(this.e).equals(strJ3) || !Integer.toString(this.g).equals(strJ4) || !"".equals(strJ5)) {
                throw new IOException("unexpected journal header: [" + strJ + ", " + strJ2 + ", " + strJ4 + ", " + strJ5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    g0(ufVar.j());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (ufVar.f()) {
                        h0();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), vf.a));
                    }
                    vf.a(ufVar);
                    return;
                }
            }
        } catch (Throwable th) {
            vf.a(ufVar);
            throw th;
        }
    }

    public final void g0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = this.j.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void h0() throws IOException {
        Writer writer = this.i;
        if (writer != null) {
            A(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), vf.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write("1");
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(Integer.toString(this.e));
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            for (d dVar : this.j.values()) {
                if (dVar.f != null) {
                    bufferedWriter.write("DIRTY " + dVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
                }
            }
            A(bufferedWriter);
            if (this.b.exists()) {
                j0(this.b, this.d, true);
            }
            j0(this.c, this.b, false);
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), vf.a));
        } catch (Throwable th) {
            A(bufferedWriter);
            throw th;
        }
    }

    public synchronized boolean i0(String str) throws IOException {
        y();
        d dVar = this.j.get(str);
        if (dVar != null && dVar.f == null) {
            for (int i = 0; i < this.g; i++) {
                File fileJ = dVar.j(i);
                if (fileJ.exists() && !fileJ.delete()) {
                    throw new IOException("failed to delete " + fileJ);
                }
                this.h -= dVar.b[i];
                dVar.b[i] = 0;
            }
            this.k++;
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) str);
            this.i.append('\n');
            this.j.remove(str);
            if (b0()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public final void k0() throws IOException {
        while (this.h > this.f) {
            i0(this.j.entrySet().iterator().next().getKey());
        }
    }

    public final void y() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
}
