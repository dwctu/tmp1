package dc;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.xc;
import dc.ya;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public class ec {
    public static final xc.a a = xc.a.a("w", XHTMLText.H, "ip", "op", "fr", PSOProgramService.VS_Key, "layers", "assets", "fonts", "chars", "markers");
    public static xc.a b = xc.a.a(TtmlNode.ATTR_ID, "layers", "w", XHTMLText.H, "p", "u");
    public static final xc.a c = xc.a.a("list");
    public static final xc.a d = xc.a.a("cm", "tm", "dr");

    public static f7 a(xc xcVar) throws IOException {
        HashMap map;
        ArrayList arrayList;
        xc xcVar2 = xcVar;
        float fE = hd.e();
        LongSparseArray<ya> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<k9> sparseArrayCompat = new SparseArrayCompat<>();
        f7 f7Var = new f7();
        xcVar.f();
        int iY = 0;
        float fX = 0.0f;
        float fX2 = 0.0f;
        float fX3 = 0.0f;
        int iY2 = 0;
        while (xcVar.p()) {
            switch (xcVar2.O(a)) {
                case 0:
                    iY = xcVar.y();
                    break;
                case 1:
                    iY2 = xcVar.y();
                    break;
                case 2:
                    fX = (float) xcVar.x();
                    break;
                case 3:
                    map = map4;
                    arrayList = arrayList3;
                    fX2 = ((float) xcVar.x()) - 0.01f;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 4:
                    map = map4;
                    arrayList = arrayList3;
                    fX3 = (float) xcVar.x();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 5:
                    String[] strArrSplit = xcVar.C().split("\\.");
                    if (!hd.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        f7Var.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 6:
                    e(xcVar2, f7Var, arrayList2, longSparseArray);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 7:
                    b(xcVar2, f7Var, map2, map3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 8:
                    d(xcVar2, map4);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 9:
                    c(xcVar2, f7Var, sparseArrayCompat);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                case 10:
                    f(xcVar2, f7Var, arrayList3);
                    map = map4;
                    arrayList = arrayList3;
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
                default:
                    map = map4;
                    arrayList = arrayList3;
                    xcVar.V();
                    xcVar.X();
                    map4 = map;
                    arrayList3 = arrayList;
                    break;
            }
            xcVar2 = xcVar;
        }
        f7Var.r(new Rect(0, 0, (int) (iY * fE), (int) (iY2 * fE)), fX, fX2, fX3, arrayList2, longSparseArray, map2, map3, sparseArrayCompat, map4, arrayList3);
        return f7Var;
    }

    public static void b(xc xcVar, f7 f7Var, Map<String, List<ya>> map, Map<String, i7> map2) throws IOException {
        xcVar.e();
        while (xcVar.p()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            xcVar.f();
            String strC = null;
            String strC2 = null;
            String strC3 = null;
            int iY = 0;
            int iY2 = 0;
            while (xcVar.p()) {
                int iO = xcVar.O(b);
                if (iO == 0) {
                    strC = xcVar.C();
                } else if (iO == 1) {
                    xcVar.e();
                    while (xcVar.p()) {
                        ya yaVarB = dc.b(xcVar, f7Var);
                        longSparseArray.put(yaVarB.b(), yaVarB);
                        arrayList.add(yaVarB);
                    }
                    xcVar.j();
                } else if (iO == 2) {
                    iY = xcVar.y();
                } else if (iO == 3) {
                    iY2 = xcVar.y();
                } else if (iO == 4) {
                    strC2 = xcVar.C();
                } else if (iO != 5) {
                    xcVar.V();
                    xcVar.X();
                } else {
                    strC3 = xcVar.C();
                }
            }
            xcVar.m();
            if (strC2 != null) {
                i7 i7Var = new i7(iY, iY2, strC, strC2, strC3);
                map2.put(i7Var.d(), i7Var);
            } else {
                map.put(strC, arrayList);
            }
        }
        xcVar.j();
    }

    public static void c(xc xcVar, f7 f7Var, SparseArrayCompat<k9> sparseArrayCompat) throws IOException {
        xcVar.e();
        while (xcVar.p()) {
            k9 k9VarA = ub.a(xcVar, f7Var);
            sparseArrayCompat.put(k9VarA.hashCode(), k9VarA);
        }
        xcVar.j();
    }

    public static void d(xc xcVar, Map<String, j9> map) throws IOException {
        xcVar.f();
        while (xcVar.p()) {
            if (xcVar.O(c) != 0) {
                xcVar.V();
                xcVar.X();
            } else {
                xcVar.e();
                while (xcVar.p()) {
                    j9 j9VarA = vb.a(xcVar);
                    map.put(j9VarA.b(), j9VarA);
                }
                xcVar.j();
            }
        }
        xcVar.m();
    }

    public static void e(xc xcVar, f7 f7Var, List<ya> list, LongSparseArray<ya> longSparseArray) throws IOException {
        xcVar.e();
        int i = 0;
        while (xcVar.p()) {
            ya yaVarB = dc.b(xcVar, f7Var);
            if (yaVarB.d() == ya.a.IMAGE) {
                i++;
            }
            list.add(yaVarB);
            longSparseArray.put(yaVarB.b(), yaVarB);
            if (i > 4) {
                dd.c("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        xcVar.j();
    }

    public static void f(xc xcVar, f7 f7Var, List<o9> list) throws IOException {
        xcVar.e();
        while (xcVar.p()) {
            String strC = null;
            xcVar.f();
            float fX = 0.0f;
            float fX2 = 0.0f;
            while (xcVar.p()) {
                int iO = xcVar.O(d);
                if (iO == 0) {
                    strC = xcVar.C();
                } else if (iO == 1) {
                    fX = (float) xcVar.x();
                } else if (iO != 2) {
                    xcVar.V();
                    xcVar.X();
                } else {
                    fX2 = (float) xcVar.x();
                }
            }
            xcVar.m();
            list.add(new o9(strC, fX, fX2));
        }
        xcVar.j();
    }
}
