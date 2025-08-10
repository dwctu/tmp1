package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0406va;
import com.huawei.hms.scankit.p.C0409w;
import com.huawei.hms.scankit.p.L;
import com.huawei.hms.scankit.p.M;
import com.huawei.hms.scankit.p.W;
import com.huawei.hms.scankit.p.Xa;
import com.huawei.hms.scankit.p._a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader.java */
/* loaded from: classes3.dex */
public final class o implements t {
    public static boolean a(x xVar, float f, float f2) {
        double dAbs = Math.abs(xVar.h()[0].b() - xVar.h()[1].b()) / f;
        return (dAbs < 0.55d && ((double) f2) > 1.5d) || dAbs < 0.3d;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public x a(C0409w c0409w, Map<EnumC0312d, ?> map) throws C0309a {
        return a(c0409w, a(map), map);
    }

    public t[] a(Map<EnumC0312d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC0312d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new W(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new Xa());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new com.huawei.hms.scankit.p.E());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new com.huawei.hms.scankit.p.r());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new C0406va());
            }
        }
        return (t[]) arrayList.toArray(new t[arrayList.size()]);
    }

    private x a(C0409w c0409w, t[] tVarArr, Map<EnumC0312d, ?> map) throws C0309a {
        if (tVarArr != null) {
            for (t tVar : tVarArr) {
                try {
                    x xVarA = tVar.a(c0409w, map);
                    if (xVarA != null && xVarA.h() != null) {
                        int i = 0;
                        for (z zVar : xVarA.h()) {
                            if (zVar != null) {
                                i++;
                            }
                        }
                        if (i == 0 && xVarA.b() == BarcodeFormat.PDF_417) {
                            throw C0309a.a();
                        }
                    }
                    return xVarA;
                } catch (C0309a unused) {
                }
            }
        }
        throw C0309a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.p.C0409w r10, com.huawei.hms.scankit.p.C0409w r11, java.util.Map<com.huawei.hms.scankit.aiscan.common.EnumC0312d, java.lang.Object> r12, com.huawei.hms.scankit.aiscan.common.l r13, com.huawei.hms.scankit.p.L r14) throws com.huawei.hms.scankit.aiscan.common.C0309a {
        /*
            r9 = this;
            com.huawei.hms.scankit.aiscan.common.d r0 = com.huawei.hms.scankit.aiscan.common.EnumC0312d.PHOTO_MODE
            boolean r0 = r12.containsKey(r0)
            r1 = 2
            float[] r6 = new float[r1]
            r6 = {x0066: FILL_ARRAY_DATA , data: [1065353216, 0} // fill-array
            r1 = 0
            r8 = 1
            if (r11 == 0) goto L1b
            r2 = r9
            r3 = r11
            r4 = r13
            r5 = r12
            r7 = r14
            com.huawei.hms.scankit.aiscan.common.x r11 = r2.a(r3, r4, r5, r6, r7)
        L19:
            r12 = 0
            goto L31
        L1b:
            if (r0 != 0) goto L24
            boolean r11 = com.huawei.hms.scankit.p._a.a
            if (r11 != 0) goto L22
            goto L24
        L22:
            r11 = 0
            goto L19
        L24:
            com.huawei.hms.scankit.aiscan.common.x r11 = r9.a(r10, r13, r12, r6)
            r12 = r6[r8]
            r13 = 1065353216(0x3f800000, float:1.0)
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 <= 0) goto L19
            r12 = 1
        L31:
            if (r11 == 0) goto L60
            if (r12 == 0) goto L5f
            com.huawei.hms.scankit.aiscan.common.z[] r12 = r11.h()
            if (r12 == 0) goto L5f
        L3b:
            int r13 = r12.length
            if (r1 >= r13) goto L5f
            r13 = r12[r1]
            if (r13 == 0) goto L5c
            com.huawei.hms.scankit.aiscan.common.z r13 = new com.huawei.hms.scankit.aiscan.common.z
            r14 = r12[r1]
            float r14 = r14.c()
            int r0 = r10.c()
            int r0 = r0 - r8
            float r0 = (float) r0
            r2 = r12[r1]
            float r2 = r2.b()
            float r0 = r0 - r2
            r13.<init>(r14, r0)
            r12[r1] = r13
        L5c:
            int r1 = r1 + 1
            goto L3b
        L5f:
            return r11
        L60:
            com.huawei.hms.scankit.aiscan.common.a r10 = com.huawei.hms.scankit.aiscan.common.C0309a.a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.aiscan.common.o.a(com.huawei.hms.scankit.p.w, com.huawei.hms.scankit.p.w, java.util.Map, com.huawei.hms.scankit.aiscan.common.l, com.huawei.hms.scankit.p.L):com.huawei.hms.scankit.aiscan.common.x");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.p.C0409w r11, com.huawei.hms.scankit.aiscan.common.l r12, java.util.Map<com.huawei.hms.scankit.aiscan.common.EnumC0312d, java.lang.Object> r13, float[] r14, com.huawei.hms.scankit.p.L r15) throws com.huawei.hms.scankit.aiscan.common.C0309a {
        /*
            r10 = this;
            float r0 = r15.n()
            int r1 = r11.e()
            int r2 = r11.c()
            if (r1 >= r2) goto L13
            int r1 = r11.e()
            goto L17
        L13:
            int r1 = r11.c()
        L17:
            float r1 = (float) r1
            r2 = 1140457472(0x43fa0000, float:500.0)
            float r2 = r1 / r2
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L24
            r2 = 1065353216(0x3f800000, float:1.0)
        L24:
            com.huawei.hms.scankit.p.w r4 = r12.g(r11, r2)
            com.huawei.hms.scankit.aiscan.common.t[] r5 = r10.a(r13)
            float r6 = r15.a()
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L3f
            float r6 = r15.b()
            float r7 = r15.a()
            float r6 = r6 / r7
            goto L41
        L3f:
            r6 = 1065353216(0x3f800000, float:1.0)
        L41:
            r7 = 0
            com.huawei.hms.scankit.aiscan.common.x r8 = r10.a(r4, r5, r13)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L54
            float r9 = r0 / r2
            boolean r9 = a(r8, r9, r6)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L56
            if (r9 != 0) goto L4f
            goto Laa
        L4f:
            com.huawei.hms.scankit.aiscan.common.a r8 = com.huawei.hms.scankit.aiscan.common.C0309a.a()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L54
            throw r8     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L54
        L54:
            goto L57
        L56:
            r7 = r8
        L57:
            boolean r8 = com.huawei.hms.scankit.p._a.k
            if (r8 == 0) goto La9
            r2 = 1132068864(0x437a0000, float:250.0)
            float r1 = r1 / r2
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 >= 0) goto L63
            goto L64
        L63:
            r3 = r1
        L64:
            com.huawei.hms.scankit.p.w r4 = r12.f(r11, r3)
            com.huawei.hms.scankit.aiscan.common.d r11 = com.huawei.hms.scankit.aiscan.common.EnumC0312d.PHOTO_MODE_NUM     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L88
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L88
            r13.put(r11, r1)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L88
            com.huawei.hms.scankit.p.w r11 = r12.e(r4)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L88
            com.huawei.hms.scankit.aiscan.common.x r11 = r10.a(r11, r5, r13)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L88
            float r1 = r0 / r3
            boolean r1 = a(r11, r1, r6)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L88
            if (r1 != 0) goto L83
            goto La2
        L83:
            com.huawei.hms.scankit.aiscan.common.a r11 = com.huawei.hms.scankit.aiscan.common.C0309a.a()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L88
            throw r11     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L88
        L88:
            com.huawei.hms.scankit.aiscan.common.d r11 = com.huawei.hms.scankit.aiscan.common.EnumC0312d.PHOTO_MODE_NUM
            r1 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13.put(r11, r1)
            com.huawei.hms.scankit.p.w r11 = r12.f(r4)
            com.huawei.hms.scankit.aiscan.common.x r11 = r10.a(r11, r5, r13)
            float r0 = r0 / r3
            boolean r12 = a(r11, r0, r6)
            if (r12 != 0) goto La4
        La2:
            r2 = r3
            goto Lab
        La4:
            com.huawei.hms.scankit.aiscan.common.a r11 = com.huawei.hms.scankit.aiscan.common.C0309a.a()
            throw r11
        La9:
            r8 = r7
        Laa:
            r11 = r8
        Lab:
            r12 = 0
            r14[r12] = r2
            if (r11 == 0) goto Lb7
            com.huawei.hms.scankit.p.y r12 = r4.b()
            com.huawei.hms.scankit.p.M.a(r12, r11, r2, r15)
        Lb7:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.aiscan.common.o.a(com.huawei.hms.scankit.p.w, com.huawei.hms.scankit.aiscan.common.l, java.util.Map, float[], com.huawei.hms.scankit.p.L):com.huawei.hms.scankit.aiscan.common.x");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.huawei.hms.scankit.aiscan.common.l] */
    /* JADX WARN: Type inference failed for: r10v10, types: [com.huawei.hms.scankit.aiscan.common.x] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.huawei.hms.scankit.aiscan.common.x] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.p.C0409w r9, com.huawei.hms.scankit.aiscan.common.l r10, java.util.Map<com.huawei.hms.scankit.aiscan.common.EnumC0312d, java.lang.Object> r11, float[] r12) throws com.huawei.hms.scankit.aiscan.common.C0309a {
        /*
            r8 = this;
            int r0 = r9.c()
            int r1 = r9.e()
            int r0 = java.lang.Math.min(r0, r1)
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            r2 = 1149698048(0x44870000, float:1080.0)
            float r0 = r0 / r2
            boolean r2 = com.huawei.hms.scankit.p._a.a
            if (r2 == 0) goto L1d
            com.huawei.hms.scankit.p.w r9 = r10.a(r9, r0)
            goto L29
        L1d:
            r2 = 1069547520(0x3fc00000, float:1.5)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L24
            r1 = r0
        L24:
            com.huawei.hms.scankit.p.w r9 = r10.a(r9, r1)
            r0 = r1
        L29:
            com.huawei.hms.scankit.aiscan.common.t[] r1 = r8.a(r11)
            boolean r2 = com.huawei.hms.scankit.p._a.b
            r3 = 0
            r4 = 0
            if (r2 != 0) goto L45
            boolean r2 = com.huawei.hms.scankit.p._a.a
            if (r2 == 0) goto L45
            com.huawei.hms.scankit.aiscan.common.d r10 = com.huawei.hms.scankit.aiscan.common.EnumC0312d.PHOTO_MODE_NUM
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r11.put(r10, r2)
            com.huawei.hms.scankit.aiscan.common.x r10 = r8.a(r9, r1, r11)
            goto L81
        L45:
            r2 = r3
            r5 = 0
        L47:
            r6 = 2
            if (r5 >= r6) goto L80
            r6 = 1
            if (r5 != r6) goto L5e
            com.huawei.hms.scankit.p.w r7 = com.huawei.hms.scankit.aiscan.common.k.a(r9)
            com.huawei.hms.scankit.p.w r7 = r10.c(r7)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            com.huawei.hms.scankit.aiscan.common.x r2 = r8.a(r7, r1, r11)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            r7 = 1073741824(0x40000000, float:2.0)
            r12[r6] = r7     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            goto L80
        L5e:
            com.huawei.hms.scankit.p.w r7 = r10.b(r9)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L67
            com.huawei.hms.scankit.aiscan.common.x r10 = r8.a(r7, r1, r11)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L67
            goto L81
        L67:
            boolean r7 = com.huawei.hms.scankit.p._a.k     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            if (r7 == 0) goto L7d
            com.huawei.hms.scankit.aiscan.common.d r7 = com.huawei.hms.scankit.aiscan.common.EnumC0312d.PHOTO_MODE_NUM     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            r11.put(r7, r6)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            com.huawei.hms.scankit.p.w r6 = r10.d(r9)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            com.huawei.hms.scankit.aiscan.common.x r10 = r8.a(r6, r1, r11)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L7d
            goto L81
        L7d:
            int r5 = r5 + 1
            goto L47
        L80:
            r10 = r2
        L81:
            if (r10 == 0) goto L8a
            com.huawei.hms.scankit.p.y r9 = r9.b()
            com.huawei.hms.scankit.p.M.a(r9, r10, r0, r3)
        L8a:
            r12[r4] = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.aiscan.common.o.a(com.huawei.hms.scankit.p.w, com.huawei.hms.scankit.aiscan.common.l, java.util.Map, float[]):com.huawei.hms.scankit.aiscan.common.x");
    }

    public x a(C0409w c0409w, C0409w c0409w2, C0409w c0409w3, Map<EnumC0312d, ?> map, l lVar, L l) throws C0309a {
        if (c0409w3 != null) {
            return a(c0409w3, lVar, map, l);
        }
        return a(c0409w, c0409w2, lVar, map);
    }

    public x a(C0409w c0409w, l lVar, Map<EnumC0312d, ?> map, L l) throws C0309a {
        int iE = c0409w.e();
        int iC = c0409w.c();
        int i = iE < iC ? iE : iC;
        float f = i * 1.0f;
        float f2 = f / 128.0f;
        if (f2 < 1.0f && _a.c) {
            c0409w = lVar.e(c0409w, f2);
        }
        C0409w c0409w2 = c0409w;
        float f3 = f / 500.0f;
        float f4 = f3 >= 1.0f ? f3 : 1.0f;
        try {
            x xVarA = a(lVar.g(c0409w2, f4), a(map), map);
            if (xVarA != null && xVarA.i() != null) {
                M.a(xVarA.h(), f4, l);
                return xVarA;
            }
            if (!_a.c && xVarA != null && xVarA.i() == null && xVarA.h().length >= 3) {
            }
            throw C0309a.a();
        } catch (C0309a unused) {
            x xVarA2 = a(i, c0409w2, lVar, map, l);
            if (xVarA2 == null) {
                throw C0309a.a();
            }
            if (0 != 0) {
                xVarA2.a();
                xVarA2.b((z[]) null);
                M.a(xVarA2.h(), f4, l);
            }
            return xVarA2;
        }
    }

    private x a(int i, C0409w c0409w, l lVar, Map<EnumC0312d, ?> map, L l) throws C0309a {
        float f = (i * 1.0f) / 250.0f;
        if (f < 1.0f) {
            f = 1.0f;
        }
        C0409w c0409wF = lVar.f(c0409w, f);
        t[] tVarArrA = a(map);
        try {
            try {
                x xVarA = a(lVar.e(c0409wF), tVarArrA, map);
                if (xVarA != null && xVarA.i() != null) {
                    M.a(xVarA.h(), f, l);
                    return xVarA;
                }
                throw C0309a.a();
            } catch (C0309a unused) {
                x xVarA2 = a(new C0409w(new com.huawei.hms.scankit.p.B(c0409w.a().c())), tVarArrA, map);
                if (xVarA2 != null && xVarA2.i() != null) {
                    M.a(xVarA2.h(), 1.0f, l);
                }
                return xVarA2;
            }
        } catch (C0309a unused2) {
            x xVarA3 = a(lVar.f(c0409wF), tVarArrA, map);
            if (xVarA3 != null && xVarA3.i() != null) {
                M.a(xVarA3.h(), f, l);
                return xVarA3;
            }
            throw C0309a.a();
        }
    }

    public x a(C0409w c0409w, C0409w c0409w2, l lVar, Map<EnumC0312d, ?> map) throws C0309a {
        C0409w c0409wA;
        int iE = c0409w.e();
        int iC = c0409w.c();
        int i = iE < iC ? iE : iC;
        float f = (i * 1.0f) / 1080.0f;
        if (f <= 1.0f) {
            f = 1.0f;
        }
        if (_a.a) {
            c0409wA = lVar.a(c0409w, f);
        } else {
            float f2 = f > 1.5f ? f : 1.0f;
            float f3 = f2;
            c0409wA = lVar.a(c0409w, f2);
            f = f3;
        }
        try {
            x xVarA = a(c0409wA, a(map), map);
            if (xVarA != null && xVarA.i() != null) {
                M.a(xVarA.h(), f, (L) null);
                return xVarA;
            }
            if (!_a.c && xVarA != null && xVarA.i() == null && xVarA.h().length >= 3) {
            }
            throw C0309a.a();
        } catch (C0309a unused) {
            x xVarA2 = a(i, lVar, c0409w, c0409w2, map);
            if (xVarA2 == null) {
                throw C0309a.a();
            }
            if (0 != 0) {
                xVarA2.a();
                xVarA2.b((z[]) null);
            }
            return xVarA2;
        }
    }

    private x a(int i, l lVar, C0409w c0409w, C0409w c0409w2, Map<EnumC0312d, ?> map) throws C0309a {
        t[] tVarArrA = a(map);
        try {
            if (_a.a) {
                float f = (i * 1.0f) / 500.0f;
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                x xVarA = a(lVar.g(lVar.g(c0409w, f)), tVarArrA, map);
                if (xVarA != null && xVarA.i() != null) {
                    M.a(xVarA.h(), f, (L) null);
                    return xVarA;
                }
            }
            throw C0309a.a();
        } catch (C0309a unused) {
            float f2 = (i * 1.0f) / 1080.0f;
            float f3 = f2 > 1.0f ? f2 : 1.0f;
            x xVarA2 = a(lVar.b(c0409w2, f3), tVarArrA, map);
            if (xVarA2 != null && xVarA2.i() != null) {
                M.a(xVarA2.h(), f3, (L) null);
            }
            return xVarA2;
        }
    }
}
