package dc;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: AudioSpecificConfig.java */
@s41(objectTypeIndication = 64, tags = {5})
/* loaded from: classes2.dex */
public class m41 extends n41 {
    public static Map<Integer, Integer> U = new HashMap();
    public static Map<Integer, String> V = new HashMap();
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public boolean T;
    public byte[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* compiled from: AudioSpecificConfig.java */
    public class a {
        public boolean a;

        public a(int i, o41 o41Var) {
            int iA;
            o41Var.b();
            o41Var.b();
            o41Var.b();
            o41Var.b();
            boolean zB = o41Var.b();
            this.a = zB;
            if (zB) {
                o41Var.b();
                o41Var.b();
                a(i, o41Var);
            }
            while (o41Var.a(4) != 0) {
                int iA2 = o41Var.a(4);
                if (iA2 == 15) {
                    iA = o41Var.a(8);
                    iA2 += iA;
                } else {
                    iA = 0;
                }
                if (iA == 255) {
                    iA2 += o41Var.a(16);
                }
                for (int i2 = 0; i2 < iA2; i2++) {
                    o41Var.a(8);
                }
            }
        }

        public void a(int i, o41 o41Var) {
            int i2;
            switch (i) {
                case 1:
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                    i2 = 3;
                    break;
                case 7:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                new b(m41.this, o41Var);
            }
        }
    }

    /* compiled from: AudioSpecificConfig.java */
    public class b {
        public boolean a;
        public boolean b;

        public b(m41 m41Var, o41 o41Var) {
            o41Var.b();
            o41Var.a(4);
            o41Var.a(4);
            o41Var.a(3);
            o41Var.a(2);
            this.a = o41Var.b();
            this.b = o41Var.b();
            if (this.a) {
                o41Var.a(2);
                o41Var.b();
                o41Var.a(2);
            }
            if (this.b) {
                o41Var.a(2);
                o41Var.a(2);
                o41Var.b();
            }
            o41Var.b();
        }
    }

    static {
        U.put(0, 96000);
        U.put(1, 88200);
        U.put(2, 64000);
        U.put(3, Integer.valueOf(OpusUtil.SAMPLE_RATE));
        U.put(4, 44100);
        U.put(5, 32000);
        U.put(6, 24000);
        U.put(7, 22050);
        U.put(8, Integer.valueOf(AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND));
        U.put(9, Integer.valueOf(SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES));
        U.put(10, 11025);
        U.put(11, 8000);
        V.put(1, "AAC main");
        V.put(2, "AAC LC");
        V.put(3, "AAC SSR");
        V.put(4, "AAC LTP");
        V.put(5, "SBR");
        V.put(6, "AAC Scalable");
        V.put(7, "TwinVQ");
        V.put(8, "CELP");
        V.put(9, "HVXC");
        V.put(10, "(reserved)");
        V.put(11, "(reserved)");
        V.put(12, "TTSI");
        V.put(13, "Main synthetic");
        V.put(14, "Wavetable synthesis");
        V.put(15, "General MIDI");
        V.put(16, "Algorithmic Synthesis and Audio FX");
        V.put(17, "ER AAC LC");
        V.put(18, "(reserved)");
        V.put(19, "ER AAC LTP");
        V.put(20, "ER AAC Scalable");
        V.put(21, "ER TwinVQ");
        V.put(22, "ER BSAC");
        V.put(23, "ER AAC LD");
        V.put(24, "ER CELP");
        V.put(25, "ER HVXC");
        V.put(26, "ER HILN");
        V.put(27, "ER Parametric");
        V.put(28, "SSC");
        V.put(29, "PS");
        V.put(30, "MPEG Surround");
        V.put(31, "(escape)");
        V.put(32, "Layer-1");
        V.put(33, "Layer-2");
        V.put(34, "Layer-3");
        V.put(35, "DST");
        V.put(36, "ALS");
        V.put(37, "SLS");
        V.put(38, "SLS non-core");
        V.put(39, "ER AAC ELD");
        V.put(40, "SMR Simple");
        V.put(41, "SMR Main");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0119  */
    @Override // dc.n41
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(java.nio.ByteBuffer r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.m41.e(java.nio.ByteBuffer):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m41.class != obj.getClass()) {
            return false;
        }
        m41 m41Var = (m41) obj;
        return this.B == m41Var.B && this.A == m41Var.A && this.C == m41Var.C && this.e == m41Var.e && this.h == m41Var.h && this.v == m41Var.v && this.u == m41Var.u && this.r == m41Var.r && this.q == m41Var.q && this.K == m41Var.K && this.i == m41Var.i && this.n == m41Var.n && this.w == m41Var.w && this.D == m41Var.D && this.m == m41Var.m && this.l == m41Var.l && this.p == m41Var.p && this.t == m41Var.t && this.E == m41Var.E && this.Q == m41Var.Q && this.R == m41Var.R && this.S == m41Var.S && this.P == m41Var.P && this.N == m41Var.N && this.M == m41Var.M && this.O == m41Var.O && this.J == m41Var.J && this.I == m41Var.I && this.F == m41Var.F && this.x == m41Var.x && this.z == m41Var.z && this.y == m41Var.y && this.H == m41Var.H && this.G == m41Var.G && this.T == m41Var.T && this.k == m41Var.k && this.o == m41Var.o && this.g == m41Var.g && this.f == m41Var.f && this.j == m41Var.j && this.s == m41Var.s && this.L == m41Var.L && Arrays.equals(this.d, m41Var.d);
    }

    public final int f() {
        return 0;
    }

    public final int g(o41 o41Var) throws IOException {
        int iA = o41Var.a(5);
        return iA == 31 ? o41Var.a(6) + 32 : iA;
    }

    public final void h(int i, int i2, int i3, o41 o41Var) throws IOException {
        this.I = o41Var.a(1);
        this.J = o41Var.a(2);
        int iA = o41Var.a(1);
        this.K = iA;
        if (iA == 1) {
            this.L = o41Var.a(1);
        }
    }

    public int hashCode() {
        byte[] bArr = this.d;
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((bArr != null ? Arrays.hashCode(bArr) : 0) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + (this.j ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s) * 31) + this.t) * 31) + this.u) * 31) + this.v) * 31) + this.w) * 31) + this.x) * 31) + this.y) * 31) + this.z) * 31) + (this.A ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0)) * 31) + this.D) * 31) + (this.E ? 1 : 0)) * 31) + this.F) * 31) + this.G) * 31) + this.H) * 31) + this.I) * 31) + this.J) * 31) + this.K) * 31) + this.L) * 31) + this.M) * 31) + this.N) * 31) + this.O) * 31) + this.P) * 31) + this.Q) * 31) + this.R) * 31) + this.S) * 31) + (this.T ? 1 : 0);
    }

    public final void i(int i, int i2, int i3, o41 o41Var) throws IOException {
        this.t = o41Var.a(1);
        int iA = o41Var.a(1);
        this.u = iA;
        if (iA == 1) {
            this.v = o41Var.a(14);
        }
        this.w = o41Var.a(1);
        if (i2 == 0) {
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        }
        if (i3 == 6 || i3 == 20) {
            this.x = o41Var.a(3);
        }
        if (this.w == 1) {
            if (i3 == 22) {
                this.y = o41Var.a(5);
                this.z = o41Var.a(11);
            }
            if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                this.A = o41Var.b();
                this.B = o41Var.b();
                this.C = o41Var.b();
            }
            this.D = o41Var.a(1);
        }
        this.E = true;
    }

    public final void j(int i, int i2, int i3, o41 o41Var) throws IOException {
        this.M = o41Var.a(1);
        this.N = o41Var.a(8);
        this.O = o41Var.a(4);
        this.P = o41Var.a(12);
        this.Q = o41Var.a(2);
    }

    public final void k(int i, int i2, int i3, o41 o41Var) throws IOException {
        int iA = o41Var.a(1);
        this.R = iA;
        if (iA == 1) {
            this.S = o41Var.a(2);
        }
    }

    public final void l(int i, int i2, int i3, o41 o41Var) throws IOException {
        int iA = o41Var.a(2);
        this.G = iA;
        if (iA != 1) {
            h(i, i2, i3, o41Var);
        }
        if (this.G != 0) {
            j(i, i2, i3, o41Var);
        }
        this.H = o41Var.a(1);
        this.T = true;
    }

    public final void m(int i, int i2, int i3, o41 o41Var) throws IOException {
        int iA = o41Var.a(1);
        this.F = iA;
        if (iA == 1) {
            l(i, i2, i3, o41Var);
        } else {
            k(i, i2, i3, o41Var);
        }
    }

    public ByteBuffer n() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(o());
        ef0.i(byteBufferAllocate, 5);
        ef0.i(byteBufferAllocate, o() - 2);
        p41 p41Var = new p41(byteBufferAllocate);
        p41Var.a(this.e, 5);
        p41Var.a(this.f, 4);
        if (this.f == 15) {
            throw new UnsupportedOperationException("can't serialize that yet");
        }
        p41Var.a(this.h, 4);
        return byteBufferAllocate;
    }

    public int o() {
        if (this.e == 2) {
            return f() + 4;
        }
        throw new UnsupportedOperationException("can't serialize that yet");
    }

    public void p(int i) {
        this.e = i;
    }

    public void q(int i) {
        this.h = i;
    }

    public void r(int i) {
        this.f = i;
    }

    @Override // dc.n41
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioSpecificConfig");
        sb.append("{configBytes=");
        sb.append(bf0.a(this.d));
        sb.append(", audioObjectType=");
        sb.append(this.e);
        sb.append(" (");
        sb.append(V.get(Integer.valueOf(this.e)));
        sb.append(")");
        sb.append(", samplingFrequencyIndex=");
        sb.append(this.f);
        sb.append(" (");
        sb.append(U.get(Integer.valueOf(this.f)));
        sb.append(")");
        sb.append(", samplingFrequency=");
        sb.append(this.g);
        sb.append(", channelConfiguration=");
        sb.append(this.h);
        if (this.i > 0) {
            sb.append(", extensionAudioObjectType=");
            sb.append(this.i);
            sb.append(" (");
            sb.append(V.get(Integer.valueOf(this.i)));
            sb.append(")");
            sb.append(", sbrPresentFlag=");
            sb.append(this.j);
            sb.append(", psPresentFlag=");
            sb.append(this.k);
            sb.append(", extensionSamplingFrequencyIndex=");
            sb.append(this.l);
            sb.append(" (");
            sb.append(U.get(Integer.valueOf(this.l)));
            sb.append(")");
            sb.append(", extensionSamplingFrequency=");
            sb.append(this.m);
            sb.append(", extensionChannelConfiguration=");
            sb.append(this.n);
        }
        sb.append(", syncExtensionType=");
        sb.append(this.s);
        if (this.E) {
            sb.append(", frameLengthFlag=");
            sb.append(this.t);
            sb.append(", dependsOnCoreCoder=");
            sb.append(this.u);
            sb.append(", coreCoderDelay=");
            sb.append(this.v);
            sb.append(", extensionFlag=");
            sb.append(this.w);
            sb.append(", layerNr=");
            sb.append(this.x);
            sb.append(", numOfSubFrame=");
            sb.append(this.y);
            sb.append(", layer_length=");
            sb.append(this.z);
            sb.append(", aacSectionDataResilienceFlag=");
            sb.append(this.A);
            sb.append(", aacScalefactorDataResilienceFlag=");
            sb.append(this.B);
            sb.append(", aacSpectralDataResilienceFlag=");
            sb.append(this.C);
            sb.append(", extensionFlag3=");
            sb.append(this.D);
        }
        if (this.T) {
            sb.append(", isBaseLayer=");
            sb.append(this.F);
            sb.append(", paraMode=");
            sb.append(this.G);
            sb.append(", paraExtensionFlag=");
            sb.append(this.H);
            sb.append(", hvxcVarMode=");
            sb.append(this.I);
            sb.append(", hvxcRateMode=");
            sb.append(this.J);
            sb.append(", erHvxcExtensionFlag=");
            sb.append(this.K);
            sb.append(", var_ScalableFlag=");
            sb.append(this.L);
            sb.append(", hilnQuantMode=");
            sb.append(this.M);
            sb.append(", hilnMaxNumLine=");
            sb.append(this.N);
            sb.append(", hilnSampleRateCode=");
            sb.append(this.O);
            sb.append(", hilnFrameLength=");
            sb.append(this.P);
            sb.append(", hilnContMode=");
            sb.append(this.Q);
            sb.append(", hilnEnhaLayer=");
            sb.append(this.R);
            sb.append(", hilnEnhaQuantMode=");
            sb.append(this.S);
        }
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
