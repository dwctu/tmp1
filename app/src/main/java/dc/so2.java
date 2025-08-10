package dc;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: AsyncTaskRequestBody.java */
/* loaded from: classes3.dex */
public class so2 extends zc4 {
    public final b a;
    public final zc4 b;

    /* compiled from: AsyncTaskRequestBody.java */
    public class a extends rd4 {
        public long a;

        public a(ee4 ee4Var) {
            super(ee4Var);
            this.a = 0L;
        }

        @Override // dc.rd4, dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            this.a += j;
            so2.this.a.a(Math.round((this.a * 100.0f) / so2.this.contentLength()));
            super.write(nd4Var, j);
        }
    }

    /* compiled from: AsyncTaskRequestBody.java */
    public interface b {
        void a(int i);
    }

    public so2(zc4 zc4Var, b bVar) {
        this.a = bVar;
        this.b = zc4Var;
    }

    @Override // dc.zc4
    public long contentLength() throws IOException {
        return this.b.contentLength();
    }

    @Override // dc.zc4
    public tc4 contentType() {
        return this.b.contentType();
    }

    @Override // dc.zc4
    public void writeTo(@NonNull od4 od4Var) throws IOException {
        od4 od4VarC = wd4.c(new a(od4Var));
        this.b.writeTo(od4VarC);
        od4VarC.flush();
    }
}
