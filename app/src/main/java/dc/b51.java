package dc;

import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: AndroidLogger.java */
/* loaded from: classes2.dex */
public class b51 extends g51 {
    public String a;

    public b51(String str) {
        this.a = str;
    }

    @Override // dc.g51
    public void b(String str) {
        String str2 = String.valueOf(this.a) + SignatureImpl.INNER_SEP + str;
    }
}
