package dc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: Track.java */
@TargetApi(16)
/* loaded from: classes4.dex */
public class bj3 {
    public static Map<Integer, Integer> q;
    public long a;
    public long c;
    public String d;
    public gf0 e;
    public uf0 f;
    public LinkedList<Integer> g;
    public int h;
    public int j;
    public int k;
    public float l;
    public ArrayList<Long> m;
    public boolean n;
    public long o;
    public boolean p;
    public ArrayList<zi3> b = new ArrayList<>();
    public Date i = new Date();

    static {
        HashMap map = new HashMap();
        q = map;
        map.put(96000, 0);
        q.put(88200, 1);
        q.put(64000, 2);
        q.put(Integer.valueOf(OpusUtil.SAMPLE_RATE), 3);
        q.put(44100, 4);
        q.put(32000, 5);
        q.put(24000, 6);
        q.put(22050, 7);
        q.put(Integer.valueOf(AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND), 8);
        q.put(Integer.valueOf(SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES), 9);
        q.put(11025, 10);
        q.put(8000, 11);
    }

    public bj3(int i, MediaFormat mediaFormat, boolean z) throws Exception {
        this.a = 0L;
        this.c = 0L;
        this.e = null;
        this.f = null;
        this.g = null;
        this.l = 0.0f;
        ArrayList<Long> arrayList = new ArrayList<>();
        this.m = arrayList;
        this.n = false;
        this.o = 0L;
        this.p = true;
        this.a = i;
        if (z) {
            arrayList.add(1024L);
            this.c = 1024L;
            this.l = 1.0f;
            this.h = mediaFormat.getInteger("sample-rate");
            this.d = "soun";
            this.e = new yf0();
            this.f = new uf0();
            gg0 gg0Var = new gg0("mp4a");
            gg0Var.K(mediaFormat.getInteger("channel-count"));
            gg0Var.L(mediaFormat.getInteger("sample-rate"));
            gg0Var.A(1);
            gg0Var.O(16);
            l41 l41Var = new l41();
            t41 t41Var = new t41();
            t41Var.i(0);
            z41 z41Var = new z41();
            z41Var.h(2);
            t41Var.j(z41Var);
            q41 q41Var = new q41();
            q41Var.l(64);
            q41Var.m(5);
            q41Var.j(1536);
            q41Var.k(96000L);
            q41Var.i(96000L);
            m41 m41Var = new m41();
            m41Var.p(2);
            m41Var.r(q.get(Integer.valueOf((int) gg0Var.I())).intValue());
            m41Var.q(gg0Var.C());
            q41Var.h(m41Var);
            t41Var.h(q41Var);
            ByteBuffer byteBufferF = t41Var.f();
            l41Var.w(t41Var);
            l41Var.u(byteBufferF);
            gg0Var.j(l41Var);
            this.f.j(gg0Var);
            return;
        }
        arrayList.add(3015L);
        this.c = 3015L;
        this.k = mediaFormat.getInteger(VideoCaptureFormat.keyWidth);
        this.j = mediaFormat.getInteger(VideoCaptureFormat.keyHeight);
        this.h = 90000;
        this.g = new LinkedList<>();
        this.d = "vide";
        this.e = new eg0();
        this.f = new uf0();
        String string = mediaFormat.getString("mime");
        if (!string.equals(MimeTypes.VIDEO_H264)) {
            if (string.equals("video/mp4v")) {
                hg0 hg0Var = new hg0("mp4v");
                hg0Var.A(1);
                hg0Var.b0(24);
                hg0Var.d0(1);
                hg0Var.f0(72.0d);
                hg0Var.g0(72.0d);
                hg0Var.h0(this.k);
                hg0Var.e0(this.j);
                this.f.j(hg0Var);
                return;
            }
            return;
        }
        hg0 hg0Var2 = new hg0("avc1");
        hg0Var2.A(1);
        hg0Var2.b0(24);
        hg0Var2.d0(1);
        hg0Var2.f0(72.0d);
        hg0Var2.g0(72.0d);
        hg0Var2.h0(this.k);
        hg0Var2.e0(this.j);
        fd1 fd1Var = new fd1();
        if (mediaFormat.getByteBuffer("csd-0") != null) {
            ArrayList arrayList2 = new ArrayList();
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
            byteBuffer.position(4);
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            arrayList2.add(bArr);
            ArrayList arrayList3 = new ArrayList();
            ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer("csd-1");
            byteBuffer2.position(4);
            byte[] bArr2 = new byte[byteBuffer2.remaining()];
            byteBuffer2.get(bArr2);
            arrayList3.add(bArr2);
            fd1Var.x(arrayList2);
            fd1Var.v(arrayList3);
        }
        fd1Var.o(13);
        fd1Var.p(100);
        fd1Var.r(-1);
        fd1Var.q(-1);
        fd1Var.s(-1);
        fd1Var.t(1);
        fd1Var.u(3);
        fd1Var.w(0);
        hg0Var2.j(fd1Var);
        this.f.j(hg0Var2);
    }

    public void a(long j, MediaCodec.BufferInfo bufferInfo) {
        boolean z = (this.n || (bufferInfo.flags & 1) == 0) ? false : true;
        this.b.add(new zi3(j, bufferInfo.size));
        LinkedList<Integer> linkedList = this.g;
        if (linkedList != null && z) {
            linkedList.add(Integer.valueOf(this.b.size()));
        }
        long j2 = bufferInfo.presentationTimeUs;
        long j3 = j2 - this.o;
        this.o = j2;
        long j4 = ((j3 * this.h) + 500000) / 1000000;
        if (!this.p) {
            ArrayList<Long> arrayList = this.m;
            arrayList.add(arrayList.size() - 1, Long.valueOf(j4));
            this.c += j4;
        }
        this.p = false;
    }

    public Date b() {
        return this.i;
    }

    public long c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.j;
    }

    public gf0 f() {
        return this.e;
    }

    public uf0 g() {
        return this.f;
    }

    public ArrayList<Long> h() {
        return this.m;
    }

    public ArrayList<zi3> i() {
        return this.b;
    }

    public long[] j() {
        LinkedList<Integer> linkedList = this.g;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        long[] jArr = new long[this.g.size()];
        for (int i = 0; i < this.g.size(); i++) {
            jArr[i] = this.g.get(i).intValue();
        }
        return jArr;
    }

    public int k() {
        return this.h;
    }

    public long l() {
        return this.a;
    }

    public float m() {
        return this.l;
    }

    public int n() {
        return this.k;
    }

    public boolean o() {
        return this.n;
    }
}
