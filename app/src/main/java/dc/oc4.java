package dc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okhttp3.internal.Util;

/* compiled from: FormBody.java */
/* loaded from: classes5.dex */
public final class oc4 extends zc4 {
    public static final tc4 c = tc4.c("application/x-www-form-urlencoded");
    public final List<String> a;
    public final List<String> b;

    /* compiled from: FormBody.java */
    public static final class a {
        public final List<String> a;
        public final List<String> b;
        public final Charset c;

        public a() {
            this(null);
        }

        public a a(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.a.add(rc4.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            this.b.add(rc4.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            return this;
        }

        public a b(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.a.add(rc4.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
            this.b.add(rc4.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
            return this;
        }

        public oc4 c() {
            return new oc4(this.a, this.b);
        }

        public a(Charset charset) {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = charset;
        }
    }

    public oc4(List<String> list, List<String> list2) {
        this.a = Util.immutableList(list);
        this.b = Util.immutableList(list2);
    }

    public final long a(od4 od4Var, boolean z) {
        nd4 nd4Var = z ? new nd4() : od4Var.a();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                nd4Var.m0(38);
            }
            nd4Var.u0(this.a.get(i));
            nd4Var.m0(61);
            nd4Var.u0(this.b.get(i));
        }
        if (!z) {
            return 0L;
        }
        long jF0 = nd4Var.f0();
        nd4Var.b();
        return jF0;
    }

    @Override // dc.zc4
    public long contentLength() {
        return a(null, true);
    }

    @Override // dc.zc4
    public tc4 contentType() {
        return c;
    }

    @Override // dc.zc4
    public void writeTo(od4 od4Var) throws IOException {
        a(od4Var, false);
    }
}
