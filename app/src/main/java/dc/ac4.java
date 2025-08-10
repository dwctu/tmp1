package dc;

import java.io.IOException;

/* compiled from: Call.java */
/* loaded from: classes5.dex */
public interface ac4 extends Cloneable {

    /* compiled from: Call.java */
    public interface a {
        ac4 a(yc4 yc4Var);
    }

    void cancel();

    ad4 execute() throws IOException;

    boolean isCanceled();

    void j(bc4 bc4Var);

    yc4 request();

    ge4 timeout();
}
