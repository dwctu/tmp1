package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import io.agora.rtc2.video.VideoCaptureFormat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AnimConfig.kt */
/* loaded from: classes3.dex */
public final class ng1 {
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean l;

    @Nullable
    public hh1 n;

    @Nullable
    public JSONObject o;
    public final int a = 2;

    @NotNull
    public yg1 j = new yg1(0, 0, 0, 0);

    @NotNull
    public yg1 k = new yg1(0, 0, 0, 0);
    public int m = 1;

    @NotNull
    public final yg1 a() {
        return this.j;
    }

    public final int b() {
        return this.m;
    }

    public final int c() {
        return this.h;
    }

    public final int d() {
        return this.d;
    }

    @Nullable
    public final JSONObject e() {
        return this.o;
    }

    @Nullable
    public final hh1 f() {
        return this.n;
    }

    @NotNull
    public final yg1 g() {
        return this.k;
    }

    public final int h() {
        return this.f;
    }

    public final int i() {
        return this.e;
    }

    public final int j() {
        return this.c;
    }

    public final boolean k() {
        return this.l;
    }

    public final boolean l() {
        return this.i;
    }

    public final boolean m(@NotNull JSONObject json) throws JSONException {
        Intrinsics.checkParameterIsNotNull(json, "json");
        try {
            JSONObject jSONObject = json.getJSONObject("info");
            int i = jSONObject.getInt(PSOProgramService.VS_Key);
            if (this.a != i) {
                xh1.c.b("AnimPlayer.AnimConfig", "current version=" + this.a + " target=" + i);
                return false;
            }
            this.b = jSONObject.getInt("f");
            this.c = jSONObject.getInt("w");
            this.d = jSONObject.getInt(XHTMLText.H);
            this.e = jSONObject.getInt("videoW");
            this.f = jSONObject.getInt("videoH");
            this.g = jSONObject.getInt("orien");
            this.h = jSONObject.getInt(VideoCaptureFormat.keyFPS);
            this.i = jSONObject.getInt("isVapx") == 1;
            JSONArray jSONArray = jSONObject.getJSONArray("aFrame");
            if (jSONArray != null) {
                this.j = new yg1(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
                JSONArray jSONArray2 = jSONObject.getJSONArray("rgbFrame");
                if (jSONArray2 != null) {
                    this.k = new yg1(jSONArray2.getInt(0), jSONArray2.getInt(1), jSONArray2.getInt(2), jSONArray2.getInt(3));
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            xh1.c.c("AnimPlayer.AnimConfig", "json parse fail " + e, e);
            return false;
        }
    }

    public final void n(@NotNull yg1 yg1Var) {
        Intrinsics.checkParameterIsNotNull(yg1Var, "<set-?>");
        this.j = yg1Var;
    }

    public final void o(boolean z) {
        this.l = z;
    }

    public final void p(int i) {
        this.m = i;
    }

    public final void q(int i) {
        this.h = i;
    }

    public final void r(int i) {
        this.d = i;
    }

    public final void s(@Nullable JSONObject jSONObject) {
        this.o = jSONObject;
    }

    public final void t(@NotNull yg1 yg1Var) {
        Intrinsics.checkParameterIsNotNull(yg1Var, "<set-?>");
        this.k = yg1Var;
    }

    @NotNull
    public String toString() {
        return "AnimConfig(version=" + this.a + ", totalFrames=" + this.b + ", width=" + this.c + ", height=" + this.d + ", videoWidth=" + this.e + ", videoHeight=" + this.f + ", orien=" + this.g + ", fps=" + this.h + ", isMix=" + this.i + ", alphaPointRect=" + this.j + ", rgbPointRect=" + this.k + ", isDefaultConfig=" + this.l + ')';
    }

    public final void u(int i) {
        this.f = i;
    }

    public final void v(int i) {
        this.e = i;
    }

    public final void w(int i) {
        this.c = i;
    }
}
