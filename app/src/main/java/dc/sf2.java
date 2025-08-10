package dc;

/* compiled from: LocalBaseListener.java */
/* loaded from: classes3.dex */
public abstract class sf2 extends nf2 {
    @Override // dc.nf2, dc.pw3.a
    public void call(Object... objArr) {
        String str = "";
        if (objArr.length > 0) {
            for (Object obj : objArr) {
                str = str + obj.toString();
            }
            try {
                a(objArr[0].toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                a("");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        xe3.b(vf2.e, getClass().getSimpleName(), "收到消息： " + str);
    }
}
