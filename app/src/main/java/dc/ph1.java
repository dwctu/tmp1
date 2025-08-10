package dc;

import android.opengl.GLES20;
import dc.th1;
import java.util.Collection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MixRender.kt */
/* loaded from: classes3.dex */
public final class ph1 {

    @Nullable
    public qh1 a;

    @NotNull
    public zh1 b;

    @NotNull
    public zh1 c;

    @NotNull
    public zh1 d;
    public final oh1 e;

    public ph1(@NotNull oh1 mixAnimPlugin) {
        Intrinsics.checkParameterIsNotNull(mixAnimPlugin, "mixAnimPlugin");
        this.e = mixAnimPlugin;
        this.b = new zh1();
        this.c = new zh1();
        this.d = new zh1();
    }

    public final float[] a(float[] fArr, int i, int i2, int i3, int i4, th1.a aVar) {
        yg1 yg1Var;
        if (aVar != th1.a.CENTER_FULL) {
            li1.a.a(i, i2, new yg1(0, 0, i, i2), fArr);
        } else if (i > i3 || i2 > i4) {
            float f = (i * 1.0f) / i2;
            float f2 = i3;
            float f3 = i4;
            if (f > (1.0f * f2) / f3) {
                int i5 = (int) (f2 / f);
                yg1Var = new yg1(0, (i4 - i5) / 2, i3, i5);
            } else {
                int i6 = (int) (f3 * f);
                yg1Var = new yg1((i3 - i6) / 2, 0, i6, i4);
            }
            li1.a.a(i3, i4, yg1Var, fArr);
        } else {
            li1.a.a(i3, i4, new yg1((i3 - i) / 2, (i4 - i2) / 2, i, i2), fArr);
        }
        return fArr;
    }

    public final void b() {
        HashMap<String, th1> mapA;
        Collection<th1> collectionValues;
        this.a = new qh1();
        GLES20.glDisable(2929);
        uh1 uh1VarR = this.e.r();
        if (uh1VarR == null || (mapA = uh1VarR.a()) == null || (collectionValues = mapA.values()) == null) {
            return;
        }
        for (th1 th1Var : collectionValues) {
            xh1 xh1Var = xh1.c;
            xh1Var.d("AnimPlayer.MixRender", "init srcId=" + th1Var.i());
            th1Var.q(mi1.a.a(th1Var.b()));
            StringBuilder sb = new StringBuilder();
            sb.append("textureProgram=");
            qh1 qh1Var = this.a;
            sb.append(qh1Var != null ? Integer.valueOf(qh1Var.d()) : null);
            sb.append(",textureId=");
            sb.append(th1Var.k());
            xh1Var.d("AnimPlayer.MixRender", sb.toString());
        }
    }

    public final void c(int i) {
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
    }

    public final void d(@NotNull ng1 config, @NotNull kh1 frame, @NotNull th1 src) {
        xg1 xg1VarL;
        int iE;
        qh1 qh1Var;
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(frame, "frame");
        Intrinsics.checkParameterIsNotNull(src, "src");
        sg1 sg1VarE = this.e.p().e();
        if (sg1VarE == null || (xg1VarL = sg1VarE.l()) == null || (iE = xg1VarL.e()) <= 0 || (qh1Var = this.a) == null) {
            return;
        }
        qh1Var.i();
        zh1 zh1Var = this.b;
        ni1 ni1Var = ni1.a;
        int iJ = config.j();
        int iD = config.d();
        yg1 yg1VarA = frame.a();
        float[] fArrA = this.b.a();
        ni1Var.a(iJ, iD, yg1VarA, fArrA);
        zh1Var.b(fArrA);
        this.b.c(qh1Var.a());
        zh1 zh1Var2 = this.c;
        float[] fArrA2 = zh1Var2.a();
        a(fArrA2, frame.a().b(), frame.a().a(), src.e(), src.d(), src.f());
        zh1Var2.b(fArrA2);
        this.c.c(qh1Var.c());
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, src.k());
        GLES20.glUniform1i(qh1Var.h(), 0);
        zh1 zh1Var3 = this.d;
        li1 li1Var = li1.a;
        int i = config.i();
        int iH = config.h();
        yg1 yg1VarB = frame.b();
        float[] fArrA3 = this.d.a();
        li1Var.a(i, iH, yg1VarB, fArrA3);
        zh1Var3.b(fArrA3);
        if (frame.c() == 90) {
            zh1 zh1Var4 = this.d;
            float[] fArrA4 = zh1Var4.a();
            li1Var.b(fArrA4);
            zh1Var4.b(fArrA4);
        }
        this.d.c(qh1Var.b());
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(36197, iE);
        GLES20.glUniform1i(qh1Var.g(), 1);
        if (src.l() == th1.c.TXT && this.e.l()) {
            GLES20.glUniform1i(qh1Var.f(), 1);
            float[] fArrE = e(src.c());
            GLES20.glUniform4f(qh1Var.e(), fArrE[1], fArrE[2], fArrE[3], fArrE[0]);
        } else {
            GLES20.glUniform1i(qh1Var.f(), 0);
            GLES20.glUniform4f(qh1Var.e(), 0.0f, 0.0f, 0.0f, 0.0f);
        }
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisable(3042);
    }

    public final float[] e(int i) {
        return new float[]{((i >>> 24) & 255) / 255.0f, ((i >>> 16) & 255) / 255.0f, ((i >>> 8) & 255) / 255.0f, (i & 255) / 255.0f};
    }
}
