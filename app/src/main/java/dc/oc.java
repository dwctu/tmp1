package dc;

import android.graphics.PointF;
import com.epicgames.unreal.psoservices.PSOProgramService;
import dc.xc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class oc implements uc<pa> {
    public static final oc a = new oc();
    public static final xc.a b = xc.a.a("c", PSOProgramService.VS_Key, "i", "o");

    @Override // dc.uc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public pa a(xc xcVar, float f) throws IOException {
        if (xcVar.K() == xc.b.BEGIN_ARRAY) {
            xcVar.e();
        }
        xcVar.f();
        List<PointF> listF = null;
        List<PointF> listF2 = null;
        List<PointF> listF3 = null;
        boolean zQ = false;
        while (xcVar.p()) {
            int iO = xcVar.O(b);
            if (iO == 0) {
                zQ = xcVar.q();
            } else if (iO == 1) {
                listF = ac.f(xcVar, f);
            } else if (iO == 2) {
                listF2 = ac.f(xcVar, f);
            } else if (iO != 3) {
                xcVar.V();
                xcVar.X();
            } else {
                listF3 = ac.f(xcVar, f);
            }
        }
        xcVar.m();
        if (xcVar.K() == xc.b.END_ARRAY) {
            xcVar.j();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new pa(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listF.get(i);
            int i2 = i - 1;
            arrayList.add(new h9(gd.a(listF.get(i2), listF3.get(i2)), gd.a(pointF2, listF2.get(i)), pointF2));
        }
        if (zQ) {
            PointF pointF3 = listF.get(0);
            int i3 = size - 1;
            arrayList.add(new h9(gd.a(listF.get(i3), listF3.get(i3)), gd.a(pointF3, listF2.get(0)), pointF3));
        }
        return new pa(pointF, zQ, arrayList);
    }
}
