package dc;

import dc.xc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* loaded from: classes.dex */
public class cc {
    public static xc.a a = xc.a.a("k");

    public static <T> List<id<T>> a(xc xcVar, f7 f7Var, float f, uc<T> ucVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (xcVar.K() == xc.b.STRING) {
            f7Var.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        xcVar.f();
        while (xcVar.p()) {
            if (xcVar.O(a) != 0) {
                xcVar.X();
            } else if (xcVar.K() == xc.b.BEGIN_ARRAY) {
                xcVar.e();
                if (xcVar.K() == xc.b.NUMBER) {
                    arrayList.add(bc.c(xcVar, f7Var, f, ucVar, false, z));
                } else {
                    while (xcVar.p()) {
                        arrayList.add(bc.c(xcVar, f7Var, f, ucVar, true, z));
                    }
                }
                xcVar.j();
            } else {
                arrayList.add(bc.c(xcVar, f7Var, f, ucVar, false, z));
            }
        }
        xcVar.m();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends id<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            id<T> idVar = list.get(i2);
            i2++;
            id<T> idVar2 = list.get(i2);
            idVar.h = Float.valueOf(idVar2.g);
            if (idVar.c == null && (t = idVar2.b) != null) {
                idVar.c = t;
                if (idVar instanceof w8) {
                    ((w8) idVar).i();
                }
            }
        }
        id<T> idVar3 = list.get(i);
        if ((idVar3.b == null || idVar3.c == null) && list.size() > 1) {
            list.remove(idVar3);
        }
    }
}
