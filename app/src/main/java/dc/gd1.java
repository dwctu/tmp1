package dc;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: AvcDecoderConfigurationRecord.java */
/* loaded from: classes3.dex */
public class gd1 {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public List<byte[]> f;
    public List<byte[]> g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public List<byte[]> l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;

    public gd1() {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = 1;
        this.j = 0;
        this.k = 0;
        this.l = new ArrayList();
        this.m = 63;
        this.n = 7;
        this.o = 31;
        this.p = 31;
        this.q = 31;
    }

    public void a(ByteBuffer byteBuffer) {
        ef0.i(byteBuffer, this.a);
        ef0.i(byteBuffer, this.b);
        ef0.i(byteBuffer, this.c);
        ef0.i(byteBuffer, this.d);
        p41 p41Var = new p41(byteBuffer);
        p41Var.a(this.m, 6);
        p41Var.a(this.e, 2);
        p41Var.a(this.n, 3);
        p41Var.a(this.g.size(), 5);
        for (byte[] bArr : this.f) {
            ef0.e(byteBuffer, bArr.length);
            byteBuffer.put(bArr);
        }
        ef0.i(byteBuffer, this.g.size());
        for (byte[] bArr2 : this.g) {
            ef0.e(byteBuffer, bArr2.length);
            byteBuffer.put(bArr2);
        }
        if (this.h) {
            int i = this.b;
            if (i == 100 || i == 110 || i == 122 || i == 144) {
                p41 p41Var2 = new p41(byteBuffer);
                p41Var2.a(this.o, 6);
                p41Var2.a(this.i, 2);
                p41Var2.a(this.p, 5);
                p41Var2.a(this.j, 3);
                p41Var2.a(this.q, 5);
                p41Var2.a(this.k, 3);
                for (byte[] bArr3 : this.l) {
                    ef0.e(byteBuffer, bArr3.length);
                    byteBuffer.put(bArr3);
                }
            }
        }
    }

    public long b() {
        int i;
        long length = 6;
        while (this.f.iterator().hasNext()) {
            length = length + 2 + r0.next().length;
        }
        long length2 = length + 1;
        while (this.g.iterator().hasNext()) {
            length2 = length2 + 2 + r3.next().length;
        }
        if (this.h && ((i = this.b) == 100 || i == 110 || i == 122 || i == 144)) {
            length2 += 4;
            while (this.l.iterator().hasNext()) {
                length2 = length2 + 2 + r0.next().length;
            }
        }
        return length2;
    }

    public String toString() {
        return "AvcDecoderConfigurationRecord{configurationVersion=" + this.a + ", avcProfileIndication=" + this.b + ", profileCompatibility=" + this.c + ", avcLevelIndication=" + this.d + ", lengthSizeMinusOne=" + this.e + ", hasExts=" + this.h + ", chromaFormat=" + this.i + ", bitDepthLumaMinus8=" + this.j + ", bitDepthChromaMinus8=" + this.k + ", lengthSizeMinusOnePaddingBits=" + this.m + ", numberOfSequenceParameterSetsPaddingBits=" + this.n + ", chromaFormatPaddingBits=" + this.o + ", bitDepthLumaMinus8PaddingBits=" + this.p + ", bitDepthChromaMinus8PaddingBits=" + this.q + MessageFormatter.DELIM_STOP;
    }

    public gd1(ByteBuffer byteBuffer) {
        int i;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = 1;
        this.j = 0;
        this.k = 0;
        this.l = new ArrayList();
        this.m = 63;
        this.n = 7;
        this.o = 31;
        this.p = 31;
        this.q = 31;
        this.a = df0.l(byteBuffer);
        this.b = df0.l(byteBuffer);
        this.c = df0.l(byteBuffer);
        this.d = df0.l(byteBuffer);
        o41 o41Var = new o41(byteBuffer);
        this.m = o41Var.a(6);
        this.e = o41Var.a(2);
        this.n = o41Var.a(3);
        int iA = o41Var.a(5);
        for (int i2 = 0; i2 < iA; i2++) {
            byte[] bArr = new byte[df0.h(byteBuffer)];
            byteBuffer.get(bArr);
            this.f.add(bArr);
        }
        long jL = df0.l(byteBuffer);
        for (int i3 = 0; i3 < jL; i3++) {
            byte[] bArr2 = new byte[df0.h(byteBuffer)];
            byteBuffer.get(bArr2);
            this.g.add(bArr2);
        }
        if (byteBuffer.remaining() < 4) {
            this.h = false;
        }
        if (this.h && ((i = this.b) == 100 || i == 110 || i == 122 || i == 144)) {
            o41 o41Var2 = new o41(byteBuffer);
            this.o = o41Var2.a(6);
            this.i = o41Var2.a(2);
            this.p = o41Var2.a(5);
            this.j = o41Var2.a(3);
            this.q = o41Var2.a(5);
            this.k = o41Var2.a(3);
            long jL2 = df0.l(byteBuffer);
            for (int i4 = 0; i4 < jL2; i4++) {
                byte[] bArr3 = new byte[df0.h(byteBuffer)];
                byteBuffer.get(bArr3);
                this.l.add(bArr3);
            }
            return;
        }
        this.i = -1;
        this.j = -1;
        this.k = -1;
    }
}
