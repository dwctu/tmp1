package dc;

import android.graphics.Color;
import android.graphics.Rect;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import dc.xc;
import dc.ya;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class dc {
    public static final xc.a a = xc.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", "sr", "st", "w", XHTMLText.H, "ip", "op", "tm", "cl", "hd");
    public static final xc.a b = xc.a.a(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "a");
    public static final xc.a c = xc.a.a("nm");

    /* compiled from: LayerParser.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ya.b.values().length];
            a = iArr;
            try {
                iArr[ya.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ya.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static ya a(f7 f7Var) {
        Rect rectB = f7Var.b();
        return new ya(Collections.emptyList(), f7Var, "__container", -1L, ya.a.PRE_COMP, -1L, null, Collections.emptyList(), new ba(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), ya.b.NONE, null, false);
    }

    public static ya b(xc xcVar, f7 f7Var) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        ya.b bVar = ya.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        xcVar.f();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        ya.b bVar2 = bVar;
        ya.a aVar = null;
        String strC = null;
        ba baVarG = null;
        z9 z9VarD = null;
        aa aaVarA = null;
        r9 r9VarF = null;
        long jY = -1;
        float fX = 0.0f;
        float fX2 = 0.0f;
        int iY = 0;
        int iY2 = 0;
        int color = 0;
        float fX3 = 1.0f;
        float fX4 = 0.0f;
        int iY3 = 0;
        int iY4 = 0;
        boolean zQ = false;
        long jY2 = 0;
        String strC2 = null;
        String strC3 = "UNSET";
        while (xcVar.p()) {
            switch (xcVar.O(a)) {
                case 0:
                    strC3 = xcVar.C();
                    break;
                case 1:
                    jY2 = xcVar.y();
                    break;
                case 2:
                    strC = xcVar.C();
                    break;
                case 3:
                    int iY5 = xcVar.y();
                    aVar = ya.a.UNKNOWN;
                    if (iY5 >= aVar.ordinal()) {
                        break;
                    } else {
                        aVar = ya.a.values()[iY5];
                        break;
                    }
                case 4:
                    jY = xcVar.y();
                    break;
                case 5:
                    iY = (int) (xcVar.y() * hd.e());
                    break;
                case 6:
                    iY2 = (int) (xcVar.y() * hd.e());
                    break;
                case 7:
                    color = Color.parseColor(xcVar.C());
                    break;
                case 8:
                    baVarG = nb.g(xcVar, f7Var);
                    break;
                case 9:
                    int iY6 = xcVar.y();
                    if (iY6 < ya.b.values().length) {
                        bVar2 = ya.b.values()[iY6];
                        int i = a.a[bVar2.ordinal()];
                        if (i == 1) {
                            f7Var.a("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            f7Var.a("Unsupported matte type: Luma Inverted");
                        }
                        f7Var.q(1);
                        break;
                    } else {
                        f7Var.a("Unsupported matte type: " + iY6);
                        break;
                    }
                case 10:
                    xcVar.e();
                    while (xcVar.p()) {
                        arrayList3.add(fc.a(xcVar, f7Var));
                    }
                    f7Var.q(arrayList3.size());
                    xcVar.j();
                    break;
                case 11:
                    xcVar.e();
                    while (xcVar.p()) {
                        fa faVarA = rb.a(xcVar, f7Var);
                        if (faVarA != null) {
                            arrayList4.add(faVarA);
                        }
                    }
                    xcVar.j();
                    break;
                case 12:
                    xcVar.f();
                    while (xcVar.p()) {
                        int iO = xcVar.O(b);
                        if (iO == 0) {
                            z9VarD = ob.d(xcVar, f7Var);
                        } else if (iO != 1) {
                            xcVar.V();
                            xcVar.X();
                        } else {
                            xcVar.e();
                            if (xcVar.p()) {
                                aaVarA = mb.a(xcVar, f7Var);
                            }
                            while (xcVar.p()) {
                                xcVar.X();
                            }
                            xcVar.j();
                        }
                    }
                    xcVar.m();
                    break;
                case 13:
                    xcVar.e();
                    ArrayList arrayList5 = new ArrayList();
                    while (xcVar.p()) {
                        xcVar.f();
                        while (xcVar.p()) {
                            if (xcVar.O(c) != 0) {
                                xcVar.V();
                                xcVar.X();
                            } else {
                                arrayList5.add(xcVar.C());
                            }
                        }
                        xcVar.m();
                    }
                    xcVar.j();
                    f7Var.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    fX3 = (float) xcVar.x();
                    break;
                case 15:
                    fX4 = (float) xcVar.x();
                    break;
                case 16:
                    iY3 = (int) (xcVar.y() * hd.e());
                    break;
                case 17:
                    iY4 = (int) (xcVar.y() * hd.e());
                    break;
                case 18:
                    fX = (float) xcVar.x();
                    break;
                case 19:
                    fX2 = (float) xcVar.x();
                    break;
                case 20:
                    r9VarF = ob.f(xcVar, f7Var, false);
                    break;
                case 21:
                    strC2 = xcVar.C();
                    break;
                case 22:
                    zQ = xcVar.q();
                    break;
                default:
                    xcVar.V();
                    xcVar.X();
                    break;
            }
        }
        xcVar.m();
        float f = fX / fX3;
        float f2 = fX2 / fX3;
        ArrayList arrayList6 = new ArrayList();
        if (f > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new id(f7Var, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f2 <= 0.0f) {
            f2 = f7Var.f();
        }
        arrayList2.add(new id(f7Var, fValueOf, fValueOf, null, f, Float.valueOf(f2)));
        arrayList2.add(new id(f7Var, fValueOf2, fValueOf2, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strC3.endsWith(".ai") || "ai".equals(strC2)) {
            f7Var.a("Convert your Illustrator layers to shape layers.");
        }
        return new ya(arrayList4, f7Var, strC3, jY2, aVar, jY, strC, arrayList, baVarG, iY, iY2, color, fX3, fX4, iY3, iY4, z9VarD, aaVarA, arrayList2, bVar2, r9VarF, zQ);
    }
}
