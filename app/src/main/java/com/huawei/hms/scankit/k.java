package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.L;
import com.huawei.hms.scankit.p.Za;
import com.huawei.hms.scankit.p._a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: DecodeMultiCodes.java */
/* loaded from: classes3.dex */
public class k {
    private static boolean a = true;
    private static boolean b = false;
    private static boolean c = false;
    private static int d;
    private static LinkedList<L> e = new LinkedList<>();
    private static LinkedList<com.huawei.hms.scankit.aiscan.common.p> f = new LinkedList<>();
    private static LinkedList<com.huawei.hms.scankit.aiscan.common.p> g = new LinkedList<>();

    static {
        if (DynamicModuleInitializer.getContext() != null) {
            z.b(DynamicModuleInitializer.getContext(), "detect.ms");
            z.c(DynamicModuleInitializer.getContext(), "anchors.bin");
            z.a(DynamicModuleInitializer.getContext(), "angle.ms");
        }
    }

    public static com.huawei.hms.scankit.aiscan.common.x a(List<BarcodeFormat> list, l lVar) {
        if (list.size() > 0) {
            return lVar.d(list, null);
        }
        return null;
    }

    public static com.huawei.hms.scankit.aiscan.common.x[] b(Bitmap bitmap, E e2) {
        byte[] bArrB;
        try {
            e2.a = bitmap.getWidth();
            int height = bitmap.getHeight();
            e2.b = height;
            int i = e2.a;
            int[] iArr = new int[i * height];
            bitmap.getPixels(iArr, 0, i, 0, 0, i, height);
            bArrB = new com.huawei.hms.scankit.aiscan.common.s(e2.a, e2.b, iArr).b();
        } catch (IllegalArgumentException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "IllegalArgumentException");
            bArrB = null;
            return b(bArrB, e2);
        } catch (UnsatisfiedLinkError unused2) {
            com.huawei.hms.scankit.util.a.b("exception", "UnsatisfiedLinkError");
            bArrB = null;
            return b(bArrB, e2);
        } catch (UnsupportedOperationException unused3) {
            com.huawei.hms.scankit.util.a.b("exception", "UnsupportedArgumentException");
            bArrB = null;
            return b(bArrB, e2);
        } catch (Exception unused4) {
            com.huawei.hms.scankit.util.a.b("exception", "Exception");
            bArrB = null;
            return b(bArrB, e2);
        } catch (OutOfMemoryError unused5) {
            com.huawei.hms.scankit.util.a.b("exception", "OutOfMemoryError");
            bArrB = null;
            return b(bArrB, e2);
        }
        return b(bArrB, e2);
    }

    private static com.huawei.hms.scankit.aiscan.common.m c(byte[] bArr, E e2) {
        int i = e2.a;
        int i2 = e2.b;
        if (!e2.d) {
            return new com.huawei.hms.scankit.aiscan.common.r(bArr, i, i2, 0, 0, i, i2, false);
        }
        byte[] bArr2 = new byte[i * i2];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        e2.a = i2;
        e2.b = i;
        return new com.huawei.hms.scankit.aiscan.common.r(bArr2, i2, i, 0, 0, i2, i, false);
    }

    public static com.huawei.hms.scankit.aiscan.common.x[] a(Bitmap bitmap, E e2) {
        byte[] bArrB;
        try {
            e2.a = bitmap.getWidth();
            int height = bitmap.getHeight();
            e2.b = height;
            int i = e2.a;
            int[] iArr = new int[i * height];
            bitmap.getPixels(iArr, 0, i, 0, 0, i, height);
            bArrB = new com.huawei.hms.scankit.aiscan.common.s(e2.a, e2.b, iArr).b();
        } catch (IllegalArgumentException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "IllegalArgumentException");
            bArrB = null;
            return a(bArrB, e2);
        } catch (UnsatisfiedLinkError unused2) {
            com.huawei.hms.scankit.util.a.b("exception", "UnsatisfiedLinkError");
            bArrB = null;
            return a(bArrB, e2);
        } catch (UnsupportedOperationException unused3) {
            com.huawei.hms.scankit.util.a.b("exception", "UnsupportedArgumentException");
            bArrB = null;
            return a(bArrB, e2);
        } catch (Exception unused4) {
            com.huawei.hms.scankit.util.a.b("exception", "Exception");
            bArrB = null;
            return a(bArrB, e2);
        } catch (OutOfMemoryError unused5) {
            com.huawei.hms.scankit.util.a.b("exception", "OutOfMemoryError");
            bArrB = null;
            return a(bArrB, e2);
        }
        return a(bArrB, e2);
    }

    public static com.huawei.hms.scankit.aiscan.common.x[] b(byte[] bArr, E e2) {
        com.huawei.hms.scankit.aiscan.common.x[] xVarArr = new com.huawei.hms.scankit.aiscan.common.x[0];
        try {
            return a(bArr, e2, true);
        } catch (IllegalArgumentException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "IllegalArgumentException");
            return xVarArr;
        } catch (UnsatisfiedLinkError unused2) {
            com.huawei.hms.scankit.util.a.b("exception", "UnsatisfiedLinkError");
            return xVarArr;
        } catch (UnsupportedOperationException unused3) {
            com.huawei.hms.scankit.util.a.b("exception", "UnsupportedArgumentException");
            return xVarArr;
        } catch (Exception unused4) {
            com.huawei.hms.scankit.util.a.b("exception", "Exception");
            return xVarArr;
        } catch (OutOfMemoryError unused5) {
            com.huawei.hms.scankit.util.a.b("exception", "OutOfMemoryError");
            return xVarArr;
        }
    }

    public static com.huawei.hms.scankit.aiscan.common.x[] a(ByteBuffer byteBuffer, E e2) {
        return a(byteBuffer.array(), e2);
    }

    public static com.huawei.hms.scankit.aiscan.common.x[] a(byte[] bArr, E e2) {
        com.huawei.hms.scankit.aiscan.common.x[] xVarArr = new com.huawei.hms.scankit.aiscan.common.x[0];
        try {
            com.huawei.hms.scankit.aiscan.common.x[] xVarArrA = a(bArr, e2, false);
            int length = xVarArrA.length;
            int[] iArr = new int[length];
            int i = 0;
            int i2 = 0;
            while (i < xVarArrA.length) {
                int i3 = i + 1;
                for (int i4 = i3; i4 < xVarArrA.length; i4++) {
                    if (com.huawei.hms.scankit.aiscan.common.E.a(xVarArrA[i].h(), xVarArrA[i4].h()) > 0.7d) {
                        iArr[i4] = 1;
                        i2++;
                    }
                }
                i = i3;
            }
            int length2 = xVarArrA.length - i2;
            xVarArr = new com.huawei.hms.scankit.aiscan.common.x[length2];
            for (int i5 = 0; i5 < length2; i5++) {
                int i6 = i5;
                while (i6 < length) {
                    if (iArr[i6] != 1) {
                        break;
                    }
                    i6++;
                }
                xVarArr[i5] = xVarArrA[i6];
            }
        } catch (IllegalArgumentException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "IllegalArgumentException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("exception", "Exception");
        } catch (OutOfMemoryError unused3) {
            com.huawei.hms.scankit.util.a.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused4) {
            com.huawei.hms.scankit.util.a.b("exception", "UnsatisfiedLinkError");
        } catch (UnsupportedOperationException unused5) {
            com.huawei.hms.scankit.util.a.b("exception", "UnsupportedArgumentException");
        }
        return xVarArr;
    }

    public static com.huawei.hms.scankit.aiscan.common.x[] b(com.huawei.hms.scankit.aiscan.common.m mVar, E e2) {
        com.huawei.hms.scankit.aiscan.common.x xVar;
        boolean zA;
        com.huawei.hms.scankit.util.a.c("ScankitDecode", "scankit mode:LITESDK1");
        _a.a(e2);
        List<L> arrayList = new ArrayList<>();
        if (e2.a >= 30 && e2.b >= 30 && mVar != null) {
            List<List<BarcodeFormat>> listA = Za.a(e2.c);
            List<BarcodeFormat> list = listA.get(0);
            List<BarcodeFormat> list2 = listA.get(1);
            List<BarcodeFormat> list3 = listA.get(2);
            List<BarcodeFormat> list4 = listA.get(3);
            List<BarcodeFormat> list5 = listA.get(4);
            l lVar = new l(mVar);
            com.huawei.hms.scankit.aiscan.common.x xVarA = null;
            com.huawei.hms.scankit.aiscan.common.x xVarA2 = (!a || c) ? null : a(list, lVar);
            if (xVarA2 == null || xVarA2.i() == null) {
                arrayList = lVar.a(0, _a.l);
            }
            if (arrayList.size() > 0) {
                xVarA2 = b(arrayList, lVar, listA);
            } else if (_a.c || !_a.a || _a.b) {
                if ((xVarA2 == null || xVarA2.i() == null) && list3.size() > 0) {
                    xVarA2 = lVar.c(list3, null);
                }
                if ((xVarA2 == null || xVarA2.i() == null) && list2.size() > 0 && (!_a.a || _a.c)) {
                    xVarA2 = lVar.a(list2, (L) null);
                }
                if ((xVarA2 == null || xVarA2.i() == null) && list5.size() > 0) {
                    xVarA2 = lVar.b(list5, null);
                }
                if ((xVarA2 == null || xVarA2.i() == null) && list4.size() > 0) {
                    xVarA2 = lVar.b(list4, null);
                }
            }
            if (e2.e && ((xVarA2 == null || xVarA2.i() == null) && !a && b && !c)) {
                xVarA2 = a(list, lVar);
                b = false;
            }
            float fMax = 1.0f;
            if (_a.c) {
                xVar = null;
                zA = false;
            } else {
                zA = lVar.a();
                int i = _a.g - 1;
                if (i <= 0) {
                    i = 0;
                }
                _a.g = i;
                if (arrayList.size() > 0) {
                    zA = zA || lVar.a(arrayList);
                }
                if (lVar.d() > 0.0f) {
                    fMax = Math.max(1.0f, lVar.d());
                } else {
                    fMax = Math.max(1.0f, Math.max(lVar.b(), lVar.c()));
                }
                com.huawei.hms.scankit.aiscan.common.x xVarA3 = l.a(arrayList, lVar);
                xVarA = l.a(lVar);
                xVar = xVarA3;
            }
            if (xVarA != null && xVarA.f() == -2) {
                d++;
            } else {
                d = 0;
            }
            if (xVarA2 != null && xVarA2.i() != null) {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "ScanCode successful");
                d = 0;
                return new com.huawei.hms.scankit.aiscan.common.x[]{xVarA2};
            }
            if (zA) {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "ScanCode need zoom");
                com.huawei.hms.scankit.aiscan.common.x xVar2 = new com.huawei.hms.scankit.aiscan.common.x(fMax);
                xVar2.b(true);
                d = 0;
                return new com.huawei.hms.scankit.aiscan.common.x[]{xVar2};
            }
            if (arrayList.size() > 0 && xVar != null) {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "ScanCode need exposure");
                d = 0;
                return new com.huawei.hms.scankit.aiscan.common.x[]{xVar};
            }
            if (xVarA != null && d == 3) {
                xVarA.a(true);
                xVarA.a(-1);
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "ScanCode need globalexposure");
                d = 0;
                return new com.huawei.hms.scankit.aiscan.common.x[]{xVarA};
            }
            com.huawei.hms.scankit.util.a.c("ScankitDecode", "ScanCode null");
            return new com.huawei.hms.scankit.aiscan.common.x[0];
        }
        throw new IllegalArgumentException("widthOrHeight is Illeagle");
    }

    public static com.huawei.hms.scankit.aiscan.common.x[] a(com.huawei.hms.scankit.aiscan.common.m mVar, E e2) {
        com.huawei.hms.scankit.aiscan.common.x xVarA;
        List arrayList = new ArrayList();
        _a.a(e2);
        _a.a(1);
        if (e2.a >= 30 && e2.b >= 30 && mVar != null) {
            List<List<BarcodeFormat>> listA = Za.a(e2.c);
            List<BarcodeFormat> list = listA.get(0);
            List<BarcodeFormat> list2 = listA.get(1);
            List<BarcodeFormat> list3 = listA.get(2);
            List<BarcodeFormat> list4 = listA.get(3);
            l lVar = new l(mVar);
            List<L> listA2 = lVar.a(1, _a.l);
            if (listA2.size() > 0) {
                arrayList = a(listA2, lVar, listA);
            } else if ((_a.c || !_a.a) && (xVarA = a(lVar, list, list2, list3, list4)) != null && xVarA.i() != null) {
                arrayList.add(xVarA);
            }
            List<com.huawei.hms.scankit.aiscan.common.x> listA3 = com.huawei.hms.scankit.aiscan.common.E.a(arrayList);
            return listA3.size() > 0 ? (com.huawei.hms.scankit.aiscan.common.x[]) listA3.toArray(new com.huawei.hms.scankit.aiscan.common.x[0]) : new com.huawei.hms.scankit.aiscan.common.x[0];
        }
        throw new IllegalArgumentException("width or Height is Illeagle");
    }

    private static com.huawei.hms.scankit.aiscan.common.x a(l lVar, List<BarcodeFormat> list, List<BarcodeFormat> list2, List<BarcodeFormat> list3, List<BarcodeFormat> list4) {
        com.huawei.hms.scankit.aiscan.common.x xVarE = list.size() > 0 ? lVar.e(list, null) : null;
        if ((xVarE == null || xVarE.i() == null) && list3.size() > 0) {
            xVarE = lVar.c(list3, null);
        }
        if ((xVarE == null || xVarE.i() == null) && list2.size() > 0 && (!_a.a || _a.c)) {
            xVarE = lVar.a(list2, (L) null);
        }
        return ((xVarE == null || xVarE.i() == null) && list4.size() > 0) ? lVar.b(list4, null) : xVarE;
    }

    public static List<com.huawei.hms.scankit.aiscan.common.x> a(List<L> list, l lVar, List<List<BarcodeFormat>> list2) {
        com.huawei.hms.scankit.aiscan.common.x xVarF;
        List<BarcodeFormat> list3 = list2.get(0);
        List<BarcodeFormat> list4 = list2.get(1);
        List<BarcodeFormat> list5 = list2.get(2);
        List<BarcodeFormat> list6 = list2.get(3);
        List<BarcodeFormat> list7 = list2.get(4);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            com.huawei.hms.scankit.aiscan.common.x xVarB = null;
            if (i >= list.size()) {
                break;
            }
            lVar.i.a();
            L l = list.get(i);
            boolean z = l.g() == 5.0f;
            boolean z2 = l.g() == 1.0f;
            boolean z3 = l.g() == 3.0f;
            boolean z4 = l.g() == 2.0f;
            boolean z5 = l.g() == 4.0f;
            if (_a.b) {
                z = l.g() == 1.0f;
                z2 = l.g() == 2.0f;
                z3 = l.g() == 2.0f;
                z5 = l.g() == 1.0f;
                z4 = l.g() == 2.0f;
            }
            lVar.a(l);
            if (list3.size() > 0 && z2) {
                xVarB = lVar.d(list3, l);
            }
            if ((xVarB == null || xVarB.i() == null) && list6.size() > 0 && z3) {
                xVarB = lVar.b(list6, l);
            }
            if ((xVarB == null || xVarB.i() == null) && list5.size() > 0 && z5) {
                xVarB = lVar.c(list5, l);
            }
            if ((xVarB == null || xVarB.i() == null) && list7.size() > 0 && z4) {
                xVarB = lVar.b(list7, l);
            }
            if ((xVarB == null || xVarB.i() == null) && list4.size() > 0 && z) {
                xVarB = lVar.a(list4, l);
            }
            if (xVarB != null && xVarB.i() != null) {
                arrayList.add(xVarB);
            }
            i++;
        }
        if (arrayList.size() == 0 && list3.size() > 0 && (xVarF = lVar.f(list3, null)) != null && xVarF.i() != null) {
            arrayList.add(xVarF);
        }
        return arrayList;
    }

    public static com.huawei.hms.scankit.aiscan.common.x b(List<L> list, l lVar, List<List<BarcodeFormat>> list2) {
        List<BarcodeFormat> list3 = list2.get(0);
        List<BarcodeFormat> list4 = list2.get(1);
        List<BarcodeFormat> list5 = list2.get(2);
        List<BarcodeFormat> list6 = list2.get(3);
        List<BarcodeFormat> list7 = list2.get(4);
        com.huawei.hms.scankit.aiscan.common.x xVarD = null;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                lVar.i.a();
            }
            L l = list.get(i);
            boolean z = l.g() == 5.0f;
            boolean z2 = l.g() == 1.0f;
            boolean z3 = l.g() == 2.0f;
            boolean z4 = l.g() == 3.0f;
            boolean z5 = l.g() == 4.0f;
            if (_a.b) {
                z = l.g() == 1.0f;
                z2 = l.g() == 2.0f;
                z3 = l.g() == 2.0f;
                z4 = l.g() == 2.0f;
                z5 = l.g() == 1.0f;
            }
            lVar.a(l);
            if ((xVarD == null || xVarD.i() == null) && list3.size() > 0 && z2) {
                b = true;
                xVarD = lVar.d(list3, l);
            }
            if ((xVarD == null || xVarD.i() == null) && list6.size() > 0 && z4) {
                xVarD = lVar.b(list6, l);
            }
            if ((xVarD == null || xVarD.i() == null) && list7.size() > 0 && z3) {
                xVarD = lVar.b(list7, l);
            }
            if ((xVarD == null || xVarD.i() == null) && list5.size() > 0 && z5) {
                xVarD = lVar.c(list5, l);
            }
            if ((xVarD == null || xVarD.i() == null) && list4.size() > 0 && z) {
                xVarD = lVar.a(list4, l);
            }
            if (xVarD != null && xVarD.i() != null) {
                break;
            }
        }
        return xVarD;
    }

    public static void a(boolean z) {
        _a.a = z;
    }

    private static void a() {
        c = false;
        e = new LinkedList<>();
        f = new LinkedList<>();
        g = new LinkedList<>();
    }

    public static com.huawei.hms.scankit.aiscan.common.x[] a(byte[] bArr, E e2, boolean z) {
        int i;
        int i2;
        LinkedList linkedList = new LinkedList();
        a();
        int iMin = Math.min(e2.a, e2.b);
        float f2 = iMin;
        float fMax = Math.max(e2.a, e2.b) / f2;
        int i3 = (int) (f2 * 1.78f);
        com.huawei.hms.scankit.aiscan.common.m mVarC = c(bArr, e2);
        E e3 = new E(e2);
        if (iMin > 500 && e2.a >= e2.b && e2.e && fMax > 3.0f) {
            c = true;
            e3.a = i3;
            int i4 = e2.a - 1;
            while (i4 >= 0) {
                i4 -= i3;
                int i5 = i4 >= 0 ? i4 : 0;
                e3.h = i5;
                e3.i = 0;
                a(mVarC, i5, 0, e3);
            }
            Collections.sort(e);
            com.huawei.hms.scankit.aiscan.common.x xVarA = a(mVarC, e3, linkedList, z, true, i3);
            if (xVarA != null) {
                return new com.huawei.hms.scankit.aiscan.common.x[]{xVarA};
            }
            e = new LinkedList<>();
            Collections.sort(f);
            HashSet hashSet = new HashSet();
            Iterator<com.huawei.hms.scankit.aiscan.common.p> it = f.iterator();
            while (it.hasNext()) {
                com.huawei.hms.scankit.aiscan.common.p next = it.next();
                if (hashSet.add(Integer.valueOf(next.b)) && (i2 = next.b) >= i3 && i2 <= (e2.a - 1) - i3) {
                    e3.a = i3;
                    e3.j = true;
                    int i6 = i2 - (i3 / 2);
                    e3.h = i6;
                    e3.i = 0;
                    a(mVarC, i6, 0, e3);
                }
            }
            Collections.sort(e);
            com.huawei.hms.scankit.aiscan.common.x xVarA2 = a(mVarC, e3, linkedList, z, true, i3);
            if (xVarA2 != null) {
                return new com.huawei.hms.scankit.aiscan.common.x[]{xVarA2};
            }
        } else if (iMin > 500 && e2.e && fMax > 3.0f) {
            c = true;
            e3.b = i3;
            int i7 = e2.b - 1;
            while (i7 >= 0) {
                i7 -= i3;
                int i8 = i7 >= 0 ? i7 : 0;
                e3.h = 0;
                e3.i = i8;
                a(mVarC, 0, i8, e3);
            }
            Collections.sort(e);
            com.huawei.hms.scankit.aiscan.common.x xVarA3 = a(mVarC, e2, linkedList, z, false, i3);
            if (xVarA3 != null) {
                return new com.huawei.hms.scankit.aiscan.common.x[]{xVarA3};
            }
            e = new LinkedList<>();
            Collections.sort(g);
            HashSet hashSet2 = new HashSet();
            Iterator<com.huawei.hms.scankit.aiscan.common.p> it2 = g.iterator();
            while (it2.hasNext()) {
                com.huawei.hms.scankit.aiscan.common.p next2 = it2.next();
                if (hashSet2.add(Integer.valueOf(next2.b)) && (i = next2.b) >= i3 && i <= (e2.b - 1) - i3) {
                    int i9 = i - (i3 / 2);
                    e3.b = i3;
                    e3.j = true;
                    e3.h = 0;
                    e3.i = i9;
                    a(mVarC, 0, i9, e3);
                }
            }
            Collections.sort(e);
            com.huawei.hms.scankit.aiscan.common.x xVarA4 = a(mVarC, e2, linkedList, z, false, i3);
            if (xVarA4 != null) {
                return new com.huawei.hms.scankit.aiscan.common.x[]{xVarA4};
            }
        } else {
            c = false;
            if (z) {
                return b(mVarC, e2);
            }
            return a(mVarC, e2);
        }
        com.huawei.hms.scankit.aiscan.common.x[] xVarArr = new com.huawei.hms.scankit.aiscan.common.x[linkedList.size()];
        linkedList.toArray(xVarArr);
        return xVarArr;
    }

    private static void a(com.huawei.hms.scankit.aiscan.common.m mVar, int i, int i2, E e2) {
        _a.a(e2);
        byte[] bArrB = mVar.a(i, i2, e2.a, e2.b).b();
        int i3 = e2.a;
        int i4 = e2.b;
        List<L> listA = new l(new com.huawei.hms.scankit.aiscan.common.r(bArrB, i3, i4, 0, 0, i3, i4, false)).a(0, _a.l);
        if (!e2.j) {
            a(listA, e2);
        }
        for (L l : listA) {
            l.a(e2.h, e2.i);
            e.offer(l);
        }
    }

    private static com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.aiscan.common.m mVar, E e2, LinkedList<com.huawei.hms.scankit.aiscan.common.x> linkedList, boolean z, boolean z2, int i) {
        l lVar = new l(mVar);
        List<List<BarcodeFormat>> listA = Za.a(e2.c);
        if (z) {
            com.huawei.hms.scankit.aiscan.common.x xVarB = b(e, lVar, listA);
            if (xVarB == null || xVarB.i() == null) {
                return null;
            }
            return xVarB;
        }
        Iterator<com.huawei.hms.scankit.aiscan.common.x> it = a(e, lVar, listA).iterator();
        while (it.hasNext()) {
            linkedList.offer(it.next());
        }
        return null;
    }

    private static void a(List<L> list, E e2) {
        for (L l : list) {
            if (l.d() < e2.a * 0.1f) {
                f.offer(new com.huawei.hms.scankit.aiscan.common.p(l, e2.h));
            } else {
                float fD = l.d() + l.f();
                int i = e2.a;
                if (fD > i * 0.9f) {
                    f.offer(new com.huawei.hms.scankit.aiscan.common.p(l, e2.h + i));
                }
            }
            if (l.e() < e2.b * 0.1f) {
                g.offer(new com.huawei.hms.scankit.aiscan.common.p(l, e2.i));
            } else {
                float fE = l.e() + l.c();
                int i2 = e2.b;
                if (fE > i2 * 0.9f) {
                    g.offer(new com.huawei.hms.scankit.aiscan.common.p(l, e2.i + i2));
                }
            }
        }
    }
}
