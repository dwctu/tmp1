package dc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.broadcom.bt.util.io.FileUtils;
import dc.bg0;
import dc.xf0;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: MP4Builder.java */
@TargetApi(16)
/* loaded from: classes4.dex */
public class wi3 {
    public b a = null;
    public xi3 b = null;
    public FileOutputStream c = null;
    public FileChannel d = null;
    public long e = 0;
    public long f = 0;
    public boolean g = true;
    public HashMap<bj3, long[]> h = new HashMap<>();
    public ByteBuffer i = null;

    /* compiled from: MP4Builder.java */
    public class b implements hf0 {
        public long a;
        public long b;

        public b(wi3 wi3Var) {
            this.a = FileUtils.ONE_GB;
            this.b = 0L;
        }

        public long a() {
            return this.a;
        }

        @Override // dc.hf0
        public long b() {
            return this.a + 16;
        }

        public long c() {
            return this.b;
        }

        public final boolean d(long j) {
            return j + 8 < 4294967296L;
        }

        @Override // dc.hf0
        public void e(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            long jB = b();
            if (d(jB)) {
                ef0.g(byteBufferAllocate, jB);
            } else {
                ef0.g(byteBufferAllocate, 1L);
            }
            byteBufferAllocate.put(cf0.y("mdat"));
            if (d(jB)) {
                byteBufferAllocate.put(new byte[8]);
            } else {
                ef0.h(byteBufferAllocate, jB);
            }
            byteBufferAllocate.rewind();
            writableByteChannel.write(byteBufferAllocate);
        }

        @Override // dc.hf0
        public void f(jf0 jf0Var) {
        }

        public void g(long j) {
            this.a = j;
        }

        public void h(long j) {
            this.b = j;
        }
    }

    public static long o(long j, long j2) {
        return j2 == 0 ? j : o(j2, j % j2);
    }

    public int a(MediaFormat mediaFormat, boolean z) throws Exception {
        return this.b.b(mediaFormat, z);
    }

    public nf0 b() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("3gp4");
        return new nf0("isom", 0L, linkedList);
    }

    public wi3 c(xi3 xi3Var) throws Exception {
        this.b = xi3Var;
        FileOutputStream fileOutputStream = new FileOutputStream(xi3Var.c());
        this.c = fileOutputStream;
        this.d = fileOutputStream.getChannel();
        nf0 nf0VarB = b();
        nf0VarB.e(this.d);
        long jB = this.e + nf0VarB.b();
        this.e = jB;
        this.f += jB;
        this.a = new b();
        this.i = ByteBuffer.allocateDirect(4);
        return this;
    }

    public sf0 d(xi3 xi3Var) {
        sf0 sf0Var = new sf0();
        tf0 tf0Var = new tf0();
        tf0Var.B(new Date());
        tf0Var.E(new Date());
        tf0Var.D(h51.j);
        long jP = p(xi3Var);
        Iterator<bj3> it = xi3Var.e().iterator();
        long j = 0;
        while (it.hasNext()) {
            long jC = (it.next().c() * jP) / r7.k();
            if (jC > j) {
                j = jC;
            }
        }
        tf0Var.C(j);
        tf0Var.G(jP);
        tf0Var.F(xi3Var.e().size() + 1);
        sf0Var.j(tf0Var);
        Iterator<bj3> it2 = xi3Var.e().iterator();
        while (it2.hasNext()) {
            sf0Var.j(l(it2.next(), xi3Var));
        }
        return sf0Var;
    }

    public hf0 e(bj3 bj3Var) {
        wf0 wf0Var = new wf0();
        h(bj3Var, wf0Var);
        k(bj3Var, wf0Var);
        i(bj3Var, wf0Var);
        g(bj3Var, wf0Var);
        j(bj3Var, wf0Var);
        f(bj3Var, wf0Var);
        return wf0Var;
    }

    public void f(bj3 bj3Var, wf0 wf0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<zi3> it = bj3Var.i().iterator();
        long jB = -1;
        while (it.hasNext()) {
            zi3 next = it.next();
            long jA = next.a();
            if (jB != -1 && jB != jA) {
                jB = -1;
            }
            if (jB == -1) {
                arrayList.add(Long.valueOf(jA));
            }
            jB = next.b() + jA;
        }
        long[] jArr = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        zf0 zf0Var = new zf0();
        zf0Var.v(jArr);
        wf0Var.j(zf0Var);
    }

    public void g(bj3 bj3Var, wf0 wf0Var) {
        xf0 xf0Var = new xf0();
        xf0Var.v(new LinkedList());
        int size = bj3Var.i().size();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < size) {
            zi3 zi3Var = bj3Var.i().get(i2);
            i3++;
            if (i2 == size + (-1) || zi3Var.a() + zi3Var.b() != bj3Var.i().get(i2 + 1).a()) {
                if (i != i3) {
                    xf0Var.u().add(new xf0.a(i4, i3, 1L));
                    i = i3;
                }
                i4++;
                i3 = 0;
            }
            i2++;
        }
        wf0Var.j(xf0Var);
    }

    public void h(bj3 bj3Var, wf0 wf0Var) {
        wf0Var.j(bj3Var.g());
    }

    public void i(bj3 bj3Var, wf0 wf0Var) {
        long[] jArrJ = bj3Var.j();
        if (jArrJ == null || jArrJ.length <= 0) {
            return;
        }
        ag0 ag0Var = new ag0();
        ag0Var.u(jArrJ);
        wf0Var.j(ag0Var);
    }

    public void j(bj3 bj3Var, wf0 wf0Var) {
        vf0 vf0Var = new vf0();
        vf0Var.w(this.h.get(bj3Var));
        wf0Var.j(vf0Var);
    }

    public void k(bj3 bj3Var, wf0 wf0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = bj3Var.h().iterator();
        bg0.a aVar = null;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (aVar == null || aVar.b() != jLongValue) {
                aVar = new bg0.a(1L, jLongValue);
                arrayList.add(aVar);
            } else {
                aVar.c(aVar.a() + 1);
            }
        }
        bg0 bg0Var = new bg0();
        bg0Var.u(arrayList);
        wf0Var.j(bg0Var);
    }

    public cg0 l(bj3 bj3Var, xi3 xi3Var) {
        cg0 cg0Var = new cg0();
        dg0 dg0Var = new dg0();
        dg0Var.G(true);
        dg0Var.I(true);
        dg0Var.J(true);
        if (bj3Var.o()) {
            dg0Var.L(h51.j);
        } else {
            dg0Var.L(xi3Var.d());
        }
        dg0Var.D(0);
        dg0Var.E(bj3Var.b());
        dg0Var.F((bj3Var.c() * p(xi3Var)) / bj3Var.k());
        dg0Var.H(bj3Var.e());
        dg0Var.P(bj3Var.n());
        dg0Var.K(0);
        dg0Var.M(new Date());
        dg0Var.N(bj3Var.l() + 1);
        dg0Var.O(bj3Var.m());
        cg0Var.j(dg0Var);
        pf0 pf0Var = new pf0();
        cg0Var.j(pf0Var);
        qf0 qf0Var = new qf0();
        qf0Var.z(bj3Var.b());
        qf0Var.A(bj3Var.c());
        qf0Var.C(bj3Var.k());
        qf0Var.B("eng");
        pf0Var.j(qf0Var);
        of0 of0Var = new of0();
        of0Var.x(bj3Var.o() ? "SoundHandle" : "VideoHandle");
        of0Var.w(bj3Var.d());
        pf0Var.j(of0Var);
        rf0 rf0Var = new rf0();
        rf0Var.j(bj3Var.f());
        lf0 lf0Var = new lf0();
        mf0 mf0Var = new mf0();
        lf0Var.j(mf0Var);
        kf0 kf0Var = new kf0();
        kf0Var.r(1);
        mf0Var.j(kf0Var);
        rf0Var.j(lf0Var);
        rf0Var.j(e(bj3Var));
        pf0Var.j(rf0Var);
        return cg0Var;
    }

    public void m(boolean z) throws Exception {
        if (this.a.a() != 0) {
            n();
        }
        Iterator<bj3> it = this.b.e().iterator();
        while (it.hasNext()) {
            bj3 next = it.next();
            ArrayList<zi3> arrayListI = next.i();
            int size = arrayListI.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = arrayListI.get(i).b();
            }
            this.h.put(next, jArr);
        }
        d(this.b).e(this.d);
        this.c.flush();
        this.d.close();
        this.c.close();
    }

    public final void n() throws Exception {
        long jPosition = this.d.position();
        this.d.position(this.a.c());
        this.a.e(this.d);
        this.d.position(jPosition);
        this.a.h(0L);
        this.a.g(0L);
        this.c.flush();
    }

    public long p(xi3 xi3Var) {
        long jK = !xi3Var.e().isEmpty() ? xi3Var.e().iterator().next().k() : 0L;
        Iterator<bj3> it = xi3Var.e().iterator();
        while (it.hasNext()) {
            jK = o(it.next().k(), jK);
        }
        return jK;
    }

    public boolean q(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) throws Exception {
        if (this.g) {
            this.a.g(0L);
            this.a.e(this.d);
            this.a.h(this.e);
            this.e += 16;
            this.f += 16;
            this.g = false;
        }
        b bVar = this.a;
        bVar.g(bVar.a() + bufferInfo.size);
        long j = this.f + bufferInfo.size;
        this.f = j;
        boolean z2 = true;
        if (j >= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) {
            n();
            this.g = true;
            this.f -= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        } else {
            z2 = false;
        }
        this.b.a(i, this.e, bufferInfo);
        byteBuffer.position(bufferInfo.offset + (z ? 0 : 4));
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        if (!z) {
            this.i.position(0);
            this.i.putInt(bufferInfo.size - 4);
            this.i.position(0);
            this.d.write(this.i);
        }
        this.d.write(byteBuffer);
        this.e += bufferInfo.size;
        if (z2) {
            this.c.flush();
        }
        return z2;
    }
}
