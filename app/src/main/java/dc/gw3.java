package dc;

import java.io.IOException;

/* compiled from: ProgressRequestBody.java */
/* loaded from: classes4.dex */
public class gw3 extends zc4 {
    public final zc4 a;
    public final cw3 b;

    public gw3(zc4 zc4Var, cw3 cw3Var) {
        this.a = zc4Var;
        this.b = cw3Var;
    }

    @Override // dc.zc4
    public long contentLength() throws IOException {
        return this.a.contentLength();
    }

    @Override // dc.zc4
    public tc4 contentType() {
        return this.a.contentType();
    }

    @Override // dc.zc4
    public void writeTo(od4 od4Var) throws IOException {
        if (this.b == null) {
            this.a.writeTo(od4Var);
            return;
        }
        od4 od4VarC = wd4.c(wd4.g(new fw3(od4Var.Y(), this.b, contentLength())));
        this.a.writeTo(od4VarC);
        od4VarC.flush();
    }
}
