package dc;

import android.os.SystemClock;
import io.agora.rtm2.RtmConstants;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AnimConfigManager.kt */
/* loaded from: classes3.dex */
public final class og1 {

    @Nullable
    public ng1 a;

    @NotNull
    public final pg1 b;

    /* compiled from: AnimConfigManager.kt */
    public static final class a {
        public int a;

        @Nullable
        public String b;

        public final int a() {
            return this.a;
        }

        @Nullable
        public final String b() {
            return this.b;
        }

        public final void c(int i) {
            this.a = i;
        }

        public final void d(long j) {
        }

        public final void e(@Nullable String str) {
            this.b = str;
        }
    }

    public og1(@NotNull pg1 player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.b = player;
    }

    public final void a(int i, int i2) {
        ng1 ng1Var;
        ng1 ng1Var2 = this.a;
        if ((ng1Var2 == null || ng1Var2.k()) && (ng1Var = this.a) != null) {
            ng1Var.v(i);
            ng1Var.u(i2);
            int iB = ng1Var.b();
            if (iB == 1) {
                ng1Var.w(i / 2);
                ng1Var.r(i2);
                ng1Var.n(new yg1(0, 0, ng1Var.j(), ng1Var.d()));
                ng1Var.t(new yg1(ng1Var.j(), 0, ng1Var.j(), ng1Var.d()));
                return;
            }
            if (iB == 2) {
                ng1Var.w(i);
                ng1Var.r(i2 / 2);
                ng1Var.n(new yg1(0, 0, ng1Var.j(), ng1Var.d()));
                ng1Var.t(new yg1(0, ng1Var.d(), ng1Var.j(), ng1Var.d()));
                return;
            }
            if (iB == 3) {
                ng1Var.w(i / 2);
                ng1Var.r(i2);
                ng1Var.t(new yg1(0, 0, ng1Var.j(), ng1Var.d()));
                ng1Var.n(new yg1(ng1Var.j(), 0, ng1Var.j(), ng1Var.d()));
                return;
            }
            if (iB != 4) {
                ng1Var.w(i / 2);
                ng1Var.r(i2);
                ng1Var.n(new yg1(0, 0, ng1Var.j(), ng1Var.d()));
                ng1Var.t(new yg1(ng1Var.j(), 0, ng1Var.j(), ng1Var.d()));
                return;
            }
            ng1Var.w(i);
            ng1Var.r(i2 / 2);
            ng1Var.t(new yg1(0, 0, ng1Var.j(), ng1Var.d()));
            ng1Var.n(new yg1(0, ng1Var.d(), ng1Var.j(), ng1Var.d()));
        }
    }

    @Nullable
    public final ng1 b() {
        return this.a;
    }

    public final boolean c(ch1 ch1Var, int i, int i2) throws JSONException {
        a aVarD;
        ng1 ng1Var = new ng1();
        this.a = ng1Var;
        ch1Var.a();
        byte[] bArr = new byte[8];
        long jA = 0;
        while (ch1Var.read(bArr, 0, 8) == 8 && (aVarD = d(bArr)) != null) {
            if (Intrinsics.areEqual("vapc", aVarD.b())) {
                aVarD.d(jA);
                break;
            }
            jA += aVarD.a();
            ch1Var.skip(aVarD.a() - 8);
        }
        aVarD = null;
        if (aVarD == null) {
            xh1.c.b("AnimPlayer.AnimConfigManager", "vapc box head not found");
            ng1Var.o(true);
            ng1Var.p(i);
            ng1Var.q(i2);
            this.b.w(ng1Var.c());
            return true;
        }
        int iA = aVarD.a() - 8;
        byte[] bArr2 = new byte[iA];
        ch1Var.read(bArr2, 0, iA);
        ch1Var.b();
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(\"UTF-8\")");
        JSONObject jSONObject = new JSONObject(new String(bArr2, 0, iA, charsetForName));
        ng1Var.s(jSONObject);
        boolean zM = ng1Var.m(jSONObject);
        if (i2 > 0) {
            ng1Var.q(i2);
        }
        this.b.w(ng1Var.c());
        return zM;
    }

    public final a d(byte[] bArr) {
        if (bArr.length != 8) {
            return null;
        }
        a aVar = new a();
        aVar.c(((bArr[2] & 255) << 8) | 0 | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | (bArr[3] & 255));
        Charset charsetForName = Charset.forName("US-ASCII");
        Intrinsics.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(\"US-ASCII\")");
        aVar.e(new String(bArr, 4, 4, charsetForName));
        return aVar;
    }

    public final int e(@NotNull ch1 fileContainer, boolean z, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(fileContainer, "fileContainer");
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            boolean zC = c(fileContainer, i, i2);
            xh1.c.d("AnimPlayer.AnimConfigManager", "parseConfig cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms enableVersion1=" + z + " result=" + zC);
            if (!zC) {
                return RtmConstants.RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION;
            }
            ng1 ng1Var = this.a;
            if (ng1Var != null && ng1Var.k() && !z) {
                return RtmConstants.RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION;
            }
            ng1 ng1Var2 = this.a;
            if (ng1Var2 != null) {
                return this.b.j().b(ng1Var2);
            }
            return 0;
        } catch (Throwable th) {
            xh1.c.c("AnimPlayer.AnimConfigManager", "parseConfig error " + th, th);
            return RtmConstants.RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION;
        }
    }
}
