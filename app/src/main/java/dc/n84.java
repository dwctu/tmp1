package dc;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedInts;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: HeaderReader.java */
/* loaded from: classes5.dex */
public class n84 {
    public s94 a;
    public final ha4 b = new ha4();
    public final byte[] c = new byte[4];

    public final long a(s94 s94Var) {
        return s94Var.g() ? s94Var.d().e() : s94Var.b().e();
    }

    public boolean b(byte[] bArr, String str) {
        if (bArr[0] != 0 && da4.a(bArr[0], 4)) {
            return true;
        }
        if (bArr[3] != 0 && da4.a(bArr[3], 6)) {
            return true;
        }
        if (str != null) {
            return str.endsWith("/") || str.endsWith("\\");
        }
        return false;
    }

    public final long c(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new ZipException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        w(randomAccessFile, j);
        return ((long) this.b.c(randomAccessFile)) == o84.END_OF_CENTRAL_DIRECTORY.getValue() ? j : d(randomAccessFile);
    }

    public final long d(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (length2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            w(randomAccessFile, length);
            if (this.b.c(randomAccessFile) == o84.END_OF_CENTRAL_DIRECTORY.getValue()) {
                return length;
            }
            length3--;
        }
        throw new ZipException("Zip headers not found. Probably not a zip file");
    }

    public final List<j94> e(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            j94 j94Var = new j94();
            j94Var.f(this.b.m(bArr, i2));
            int i3 = i2 + 2;
            int iM = this.b.m(bArr, i3);
            j94Var.g(iM);
            int i4 = i3 + 2;
            if (iM > 0) {
                byte[] bArr2 = new byte[iM];
                System.arraycopy(bArr, i4, bArr2, 0, iM);
                j94Var.e(bArr2);
            }
            i2 = i4 + iM;
            arrayList.add(j94Var);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public final d94 f(List<j94> list, ha4 ha4Var) throws ZipException {
        if (list == null) {
            return null;
        }
        for (j94 j94Var : list) {
            if (j94Var != null) {
                long jC = j94Var.c();
                o84 o84Var = o84.AES_EXTRA_DATA_RECORD;
                if (jC == o84Var.getValue()) {
                    byte[] bArrB = j94Var.b();
                    if (bArrB == null || bArrB.length != 7) {
                        throw new ZipException("corrupt AES extra data records");
                    }
                    d94 d94Var = new d94();
                    d94Var.a(o84Var);
                    d94Var.h(j94Var.d());
                    byte[] bArrB2 = j94Var.b();
                    d94Var.f(u94.getFromVersionNumber(ha4Var.m(bArrB2, 0)));
                    byte[] bArr = new byte[2];
                    System.arraycopy(bArrB2, 2, bArr, 0, 2);
                    d94Var.i(new String(bArr));
                    d94Var.e(t94.getAesKeyStrengthFromRawCode(bArrB2[4] & 255));
                    d94Var.g(v94.getCompressionMethodFromCode(ha4Var.m(bArrB2, 5)));
                    return d94Var;
                }
            }
        }
        return null;
    }

    public final void g(e94 e94Var, ha4 ha4Var) throws ZipException {
        d94 d94VarF;
        if (e94Var.g() == null || e94Var.g().size() <= 0 || (d94VarF = f(e94Var.g(), ha4Var)) == null) {
            return;
        }
        e94Var.r(d94VarF);
        e94Var.y(w94.AES);
    }

    public s94 h(RandomAccessFile randomAccessFile, n94 n94Var) throws IOException {
        if (randomAccessFile.length() == 0) {
            return new s94();
        }
        if (randomAccessFile.length() < 22) {
            throw new ZipException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        }
        s94 s94Var = new s94();
        this.a = s94Var;
        try {
            s94Var.i(k(randomAccessFile, this.b, n94Var));
            if (this.a.b().e() == 0) {
                return this.a;
            }
            s94 s94Var2 = this.a;
            s94Var2.l(r(randomAccessFile, this.b, s94Var2.b().c()));
            if (this.a.g()) {
                this.a.m(q(randomAccessFile, this.b));
                if (this.a.d() == null || this.a.d().b() <= 0) {
                    this.a.k(false);
                } else {
                    this.a.k(true);
                }
            }
            this.a.h(i(randomAccessFile, this.b, n94Var.b()));
            return this.a;
        } catch (ZipException e) {
            throw e;
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new ZipException("Zip headers not found. Probably not a zip file or a corrupted zip file", e2);
        }
    }

    public final f94 i(RandomAccessFile randomAccessFile, ha4 ha4Var, Charset charset) throws IOException {
        f94 f94Var = new f94();
        ArrayList arrayList = new ArrayList();
        long jB = p84.b(this.a);
        long jA = a(this.a);
        randomAccessFile.seek(jB);
        int i = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i2 = 0;
        int i3 = 0;
        while (i3 < jA) {
            k94 k94Var = new k94();
            byte[] bArr3 = bArr2;
            long jC = ha4Var.c(randomAccessFile);
            o84 o84Var = o84.CENTRAL_DIRECTORY;
            if (jC != o84Var.getValue()) {
                throw new ZipException("Expected central directory entry not found (#" + (i3 + 1) + ")");
            }
            k94Var.a(o84Var);
            k94Var.T(ha4Var.l(randomAccessFile));
            k94Var.H(ha4Var.l(randomAccessFile));
            byte[] bArr4 = new byte[i];
            randomAccessFile.readFully(bArr4);
            k94Var.x(da4.a(bArr4[i2], i2));
            k94Var.v(da4.a(bArr4[i2], 3));
            k94Var.D(da4.a(bArr4[1], 3));
            k94Var.E((byte[]) bArr4.clone());
            k94Var.t(v94.getCompressionMethodFromCode(ha4Var.l(randomAccessFile)));
            k94Var.F(ha4Var.c(randomAccessFile));
            randomAccessFile.readFully(bArr3);
            byte[] bArr5 = bArr;
            k94Var.u(ha4Var.j(bArr3, i2));
            k94Var.s(ha4Var.i(randomAccessFile, 4));
            k94Var.G(ha4Var.i(randomAccessFile, 4));
            int iL = ha4Var.l(randomAccessFile);
            k94Var.C(iL);
            k94Var.A(ha4Var.l(randomAccessFile));
            int iL2 = ha4Var.l(randomAccessFile);
            k94Var.Q(iL2);
            k94Var.N(ha4Var.l(randomAccessFile));
            randomAccessFile.readFully(bArr5);
            k94Var.R((byte[]) bArr5.clone());
            randomAccessFile.readFully(bArr3);
            k94Var.O((byte[]) bArr3.clone());
            randomAccessFile.readFully(bArr3);
            long j = jA;
            k94Var.S(ha4Var.j(bArr3, 0));
            if (iL <= 0) {
                throw new ZipException("Invalid entry name in file header");
            }
            byte[] bArr6 = new byte[iL];
            randomAccessFile.readFully(bArr6);
            k94Var.B(p84.a(bArr6, k94Var.q(), charset));
            k94Var.w(b(k94Var.L(), k94Var.i()));
            o(randomAccessFile, k94Var);
            t(k94Var, ha4Var);
            g(k94Var, ha4Var);
            if (iL2 > 0) {
                byte[] bArr7 = new byte[iL2];
                randomAccessFile.readFully(bArr7);
                k94Var.P(p84.a(bArr7, k94Var.q(), charset));
            }
            if (k94Var.p()) {
                if (k94Var.b() != null) {
                    k94Var.y(w94.AES);
                } else {
                    k94Var.y(w94.ZIP_STANDARD);
                }
            }
            arrayList.add(k94Var);
            i3++;
            bArr = bArr5;
            bArr2 = bArr3;
            jA = j;
            i = 2;
            i2 = 0;
        }
        f94Var.b(arrayList);
        h94 h94Var = new h94();
        long jC2 = ha4Var.c(randomAccessFile);
        o84 o84Var2 = o84.DIGITAL_SIGNATURE;
        if (jC2 == o84Var2.getValue()) {
            h94Var.a(o84Var2);
            h94Var.d(ha4Var.l(randomAccessFile));
            if (h94Var.b() > 0) {
                byte[] bArr8 = new byte[h94Var.b()];
                randomAccessFile.readFully(bArr8);
                h94Var.c(new String(bArr8));
            }
        }
        return f94Var;
    }

    public g94 j(InputStream inputStream, boolean z) throws IOException {
        g94 g94Var = new g94();
        byte[] bArr = new byte[4];
        ja4.i(inputStream, bArr);
        long j = this.b.j(bArr, 0);
        o84 o84Var = o84.EXTRA_DATA_RECORD;
        if (j == o84Var.getValue()) {
            g94Var.a(o84Var);
            ja4.i(inputStream, bArr);
            g94Var.f(this.b.j(bArr, 0));
        } else {
            g94Var.f(j);
        }
        if (z) {
            g94Var.e(this.b.f(inputStream));
            g94Var.g(this.b.f(inputStream));
        } else {
            g94Var.e(this.b.b(inputStream));
            g94Var.g(this.b.b(inputStream));
        }
        return g94Var;
    }

    public final i94 k(RandomAccessFile randomAccessFile, ha4 ha4Var, n94 n94Var) throws IOException {
        long jC = c(randomAccessFile);
        w(randomAccessFile, 4 + jC);
        i94 i94Var = new i94();
        i94Var.a(o84.END_OF_CENTRAL_DIRECTORY);
        i94Var.g(ha4Var.l(randomAccessFile));
        i94Var.h(ha4Var.l(randomAccessFile));
        i94Var.m(ha4Var.l(randomAccessFile));
        i94Var.l(ha4Var.l(randomAccessFile));
        i94Var.k(ha4Var.c(randomAccessFile));
        i94Var.i(jC);
        randomAccessFile.readFully(this.c);
        i94Var.j(ha4Var.j(this.c, 0));
        i94Var.f(v(randomAccessFile, ha4Var.l(randomAccessFile), n94Var.b()));
        this.a.k(i94Var.b() > 0);
        return i94Var;
    }

    public final List<j94> l(InputStream inputStream, int i) throws IOException {
        if (i < 4) {
            if (i <= 0) {
                return null;
            }
            inputStream.skip(i);
            return null;
        }
        byte[] bArr = new byte[i];
        ja4.i(inputStream, bArr);
        try {
            return e(bArr, i);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    public final List<j94> m(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i < 4) {
            if (i <= 0) {
                return null;
            }
            randomAccessFile.skipBytes(i);
            return null;
        }
        byte[] bArr = new byte[i];
        randomAccessFile.read(bArr);
        try {
            return e(bArr, i);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    public final void n(InputStream inputStream, l94 l94Var) throws IOException {
        int iH = l94Var.h();
        if (iH <= 0) {
            return;
        }
        l94Var.z(l(inputStream, iH));
    }

    public final void o(RandomAccessFile randomAccessFile, k94 k94Var) throws IOException {
        int iH = k94Var.h();
        if (iH <= 0) {
            return;
        }
        k94Var.z(m(randomAccessFile, iH));
    }

    public l94 p(InputStream inputStream, Charset charset) throws IOException {
        l94 l94Var = new l94();
        byte[] bArr = new byte[4];
        int iB = this.b.b(inputStream);
        if (iB == o84.TEMPORARY_SPANNING_MARKER.getValue()) {
            iB = this.b.b(inputStream);
        }
        long j = iB;
        o84 o84Var = o84.LOCAL_FILE_HEADER;
        if (j != o84Var.getValue()) {
            return null;
        }
        l94Var.a(o84Var);
        l94Var.H(this.b.k(inputStream));
        byte[] bArr2 = new byte[2];
        if (ja4.i(inputStream, bArr2) != 2) {
            throw new ZipException("Could not read enough bytes for generalPurposeFlags");
        }
        l94Var.x(da4.a(bArr2[0], 0));
        l94Var.v(da4.a(bArr2[0], 3));
        boolean z = true;
        l94Var.D(da4.a(bArr2[1], 3));
        l94Var.E((byte[]) bArr2.clone());
        l94Var.t(v94.getCompressionMethodFromCode(this.b.k(inputStream)));
        l94Var.F(this.b.b(inputStream));
        ja4.i(inputStream, bArr);
        l94Var.u(this.b.j(bArr, 0));
        l94Var.s(this.b.g(inputStream, 4));
        l94Var.G(this.b.g(inputStream, 4));
        int iK = this.b.k(inputStream);
        l94Var.C(iK);
        l94Var.A(this.b.k(inputStream));
        if (iK <= 0) {
            throw new ZipException("Invalid entry name in local file header");
        }
        byte[] bArr3 = new byte[iK];
        ja4.i(inputStream, bArr3);
        String strA = p84.a(bArr3, l94Var.q(), charset);
        l94Var.B(strA);
        if (!strA.endsWith("/") && !strA.endsWith("\\")) {
            z = false;
        }
        l94Var.w(z);
        n(inputStream, l94Var);
        u(l94Var, this.b);
        g(l94Var, this.b);
        if (l94Var.p() && l94Var.f() != w94.AES) {
            if (da4.a(l94Var.j()[0], 6)) {
                l94Var.y(w94.ZIP_STANDARD_VARIANT_STRONG);
            } else {
                l94Var.y(w94.ZIP_STANDARD);
            }
        }
        return l94Var;
    }

    public final p94 q(RandomAccessFile randomAccessFile, ha4 ha4Var) throws IOException {
        if (this.a.c() == null) {
            throw new ZipException("invalid zip64 end of central directory locator");
        }
        long jB = this.a.c().b();
        if (jB < 0) {
            throw new ZipException("invalid offset for start of end of central directory record");
        }
        randomAccessFile.seek(jB);
        p94 p94Var = new p94();
        long jC = ha4Var.c(randomAccessFile);
        o84 o84Var = o84.ZIP64_END_CENTRAL_DIRECTORY_RECORD;
        if (jC != o84Var.getValue()) {
            throw new ZipException("invalid signature for zip64 end of central directory record");
        }
        p94Var.a(o84Var);
        p94Var.k(ha4Var.h(randomAccessFile));
        p94Var.n(ha4Var.l(randomAccessFile));
        p94Var.o(ha4Var.l(randomAccessFile));
        p94Var.g(ha4Var.c(randomAccessFile));
        p94Var.h(ha4Var.c(randomAccessFile));
        p94Var.m(ha4Var.h(randomAccessFile));
        p94Var.l(ha4Var.h(randomAccessFile));
        p94Var.j(ha4Var.h(randomAccessFile));
        p94Var.i(ha4Var.h(randomAccessFile));
        long jD = p94Var.d() - 44;
        if (jD > 0) {
            byte[] bArr = new byte[(int) jD];
            randomAccessFile.readFully(bArr);
            p94Var.f(bArr);
        }
        return p94Var;
    }

    public final o94 r(RandomAccessFile randomAccessFile, ha4 ha4Var, long j) throws IOException {
        o94 o94Var = new o94();
        x(randomAccessFile, j);
        long jC = ha4Var.c(randomAccessFile);
        o84 o84Var = o84.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR;
        if (jC != o84Var.getValue()) {
            this.a.n(false);
            return null;
        }
        this.a.n(true);
        o94Var.a(o84Var);
        o94Var.c(ha4Var.c(randomAccessFile));
        o94Var.d(ha4Var.h(randomAccessFile));
        o94Var.e(ha4Var.c(randomAccessFile));
        return o94Var;
    }

    public final q94 s(List<j94> list, ha4 ha4Var, long j, long j2, long j3, int i) {
        for (j94 j94Var : list) {
            if (j94Var != null && o84.ZIP64_EXTRA_FIELD_SIGNATURE.getValue() == j94Var.c()) {
                q94 q94Var = new q94();
                byte[] bArrB = j94Var.b();
                if (j94Var.d() <= 0) {
                    return null;
                }
                int i2 = 0;
                if (j94Var.d() > 0 && j == UnsignedInts.INT_MASK) {
                    q94Var.i(ha4Var.j(bArrB, 0));
                    i2 = 8;
                }
                if (i2 < j94Var.d() && j2 == UnsignedInts.INT_MASK) {
                    q94Var.f(ha4Var.j(bArrB, i2));
                    i2 += 8;
                }
                if (i2 < j94Var.d() && j3 == UnsignedInts.INT_MASK) {
                    q94Var.h(ha4Var.j(bArrB, i2));
                    i2 += 8;
                }
                if (i2 < j94Var.d() && i == 65535) {
                    q94Var.g(ha4Var.e(bArrB, i2));
                }
                return q94Var;
            }
        }
        return null;
    }

    public final void t(k94 k94Var, ha4 ha4Var) {
        q94 q94VarS;
        if (k94Var.g() == null || k94Var.g().size() <= 0 || (q94VarS = s(k94Var.g(), ha4Var, k94Var.l(), k94Var.c(), k94Var.M(), k94Var.K())) == null) {
            return;
        }
        k94Var.I(q94VarS);
        if (q94VarS.e() != -1) {
            k94Var.G(q94VarS.e());
        }
        if (q94VarS.b() != -1) {
            k94Var.s(q94VarS.b());
        }
        if (q94VarS.d() != -1) {
            k94Var.S(q94VarS.d());
        }
        if (q94VarS.c() != -1) {
            k94Var.N(q94VarS.c());
        }
    }

    public final void u(l94 l94Var, ha4 ha4Var) throws ZipException {
        q94 q94VarS;
        if (l94Var == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        }
        if (l94Var.g() == null || l94Var.g().size() <= 0 || (q94VarS = s(l94Var.g(), ha4Var, l94Var.l(), l94Var.c(), 0L, 0)) == null) {
            return;
        }
        l94Var.I(q94VarS);
        if (q94VarS.e() != -1) {
            l94Var.G(q94VarS.e());
        }
        if (q94VarS.b() != -1) {
            l94Var.s(q94VarS.b());
        }
    }

    public final String v(RandomAccessFile randomAccessFile, int i, Charset charset) throws IOException {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            randomAccessFile.readFully(bArr);
            if (charset == null) {
                charset = fa4.c;
            }
            return p84.a(bArr, false, charset);
        } catch (IOException unused) {
            return null;
        }
    }

    public final void w(RandomAccessFile randomAccessFile, long j) throws IOException {
        if (randomAccessFile instanceof w84) {
            ((w84) randomAccessFile).j(j);
        } else {
            randomAccessFile.seek(j);
        }
    }

    public final void x(RandomAccessFile randomAccessFile, long j) throws IOException {
        w(randomAccessFile, (((j - 4) - 8) - 4) - 4);
    }
}
