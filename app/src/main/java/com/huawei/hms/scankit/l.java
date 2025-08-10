package com.huawei.hms.scankit;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import com.huawei.hms.scankit.p.C0409w;
import com.huawei.hms.scankit.p.C0417y;
import com.huawei.hms.scankit.p.L;
import com.huawei.hms.scankit.p.M;
import com.huawei.hms.scankit.p.Xa;
import com.huawei.hms.scankit.p._a;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeProcessor.java */
/* loaded from: classes3.dex */
public class l {
    private com.huawei.hms.scankit.aiscan.common.m a;
    private C0409w b;
    private C0409w c;
    private C0409w d;
    private boolean e = false;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float j = 1.778f;
    private int k = 0;
    private int l = 0;
    public com.huawei.hms.scankit.aiscan.common.l i = new com.huawei.hms.scankit.aiscan.common.l();

    public l(com.huawei.hms.scankit.aiscan.common.m mVar) {
        this.a = mVar;
        this.b = new C0409w(new com.huawei.hms.scankit.p.A(this.a));
        this.c = new C0409w(new com.huawei.hms.scankit.p.B(this.a));
    }

    public static com.huawei.hms.scankit.aiscan.common.x a(List<L> list, l lVar) {
        for (L l : list) {
            if (_a.b || l.h() > 0.4d) {
                int iJ = (int) l.j();
                int iK = (int) l.k();
                if (iJ > lVar.a.c() / 3 && iJ < (lVar.a.c() * 2) / 3 && iK > lVar.a.a() / 3 && iK < (lVar.a.a() * 2) / 3) {
                    float fA = lVar.a(lVar.d);
                    com.huawei.hms.scankit.aiscan.common.x xVar = new com.huawei.hms.scankit.aiscan.common.x(1.0f);
                    xVar.a(fA);
                    xVar.a(l);
                    return xVar;
                }
            }
        }
        return null;
    }

    public com.huawei.hms.scankit.aiscan.common.x b(List<BarcodeFormat> list, L l) {
        com.huawei.hms.scankit.aiscan.common.o oVar = new com.huawei.hms.scankit.aiscan.common.o();
        HashMap map = new HashMap();
        map.put(EnumC0312d.POSSIBLE_FORMATS, list);
        try {
            com.huawei.hms.scankit.aiscan.common.x xVarA = l != null ? oVar.a(this.b, this.c, this.d, map, this.i, l) : oVar.a(this.b, this.c, null, map, this.i, null);
            try {
                if (_a.c || xVarA == null || xVarA.i() != null || xVarA.h() == null || xVarA.h().length < 3) {
                    return xVarA;
                }
                float fB = H.b(this.a.c(), this.a.a(), xVarA.h());
                if (Math.abs(1.0f - fB) <= 0.001d) {
                    return xVarA;
                }
                this.h = fB;
                this.e = true;
                return xVarA;
            } catch (C0309a unused) {
                return xVarA;
            }
        } catch (C0309a unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0 A[Catch: a -> 0x00f8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {a -> 0x00f8, blocks: (B:10:0x0038, B:39:0x00f0, B:16:0x0056, B:18:0x0064, B:24:0x007e, B:26:0x0089, B:32:0x009c, B:30:0x0094), top: B:57:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8 A[PHI: r6 r7
  0x00f8: PHI (r6v7 com.huawei.hms.scankit.aiscan.common.x) = (r6v6 com.huawei.hms.scankit.aiscan.common.x), (r6v8 com.huawei.hms.scankit.aiscan.common.x) binds: [B:54:0x00f8, B:38:0x00ee] A[DONT_GENERATE, DONT_INLINE]
  0x00f8: PHI (r7v7 float) = (r7v6 float), (r7v8 float) binds: [B:54:0x00f8, B:38:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.aiscan.common.x c(java.util.List<com.huawei.hms.scankit.aiscan.common.BarcodeFormat> r31, com.huawei.hms.scankit.p.L r32) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.l.c(java.util.List, com.huawei.hms.scankit.p.L):com.huawei.hms.scankit.aiscan.common.x");
    }

    public com.huawei.hms.scankit.aiscan.common.x d(List<BarcodeFormat> list, L l) {
        HashMap map = new HashMap();
        map.put(EnumC0312d.POSSIBLE_FORMATS, list);
        if (l == null) {
            com.huawei.hms.scankit.aiscan.common.x xVarA = a(map);
            if (xVarA != null && xVarA.i() == null && _a.l) {
                _a.h = true;
                xVarA = a(map);
                _a.h = false;
            }
            com.huawei.hms.scankit.aiscan.common.x xVar = xVarA;
            if (xVar == null || xVar.i() != null || !_a.m) {
                return xVar;
            }
            _a.i = true;
            com.huawei.hms.scankit.aiscan.common.x xVarA2 = a(map);
            _a.i = false;
            return xVarA2;
        }
        com.huawei.hms.scankit.aiscan.common.x xVarA3 = a(map, l);
        if (xVarA3 != null && xVarA3.i() == null && _a.k) {
            _a.h = true;
            xVarA3 = f(list, l);
            _a.h = false;
        }
        if (xVarA3 != null && xVarA3.i() == null && _a.l) {
            _a.i = true;
            xVarA3 = a(map, l);
            _a.i = false;
        }
        if ((xVarA3 != null && xVarA3.i() != null) || !_a.m) {
            return xVarA3;
        }
        _a.j = true;
        com.huawei.hms.scankit.aiscan.common.x xVarA4 = a(map, l);
        _a.j = false;
        return xVarA4;
    }

    public com.huawei.hms.scankit.aiscan.common.x e(List<BarcodeFormat> list, L l) throws C0309a {
        com.huawei.hms.scankit.aiscan.common.m mVarC;
        float f;
        C0409w c0409w;
        HashMap map = new HashMap();
        map.put(EnumC0312d.POSSIBLE_FORMATS, list);
        try {
            com.huawei.hms.scankit.aiscan.common.m mVarC2 = l != null ? this.d.a().c() : this.a;
            if (!_a.a || (this.b.e() <= 800 && this.b.c() <= 800)) {
                mVarC = mVarC2;
                f = 1.0f;
            } else {
                float fE = (this.b.e() > this.b.c() ? this.b.e() : this.b.c()) / 800.0f;
                mVarC = this.i.h(new C0409w(new com.huawei.hms.scankit.p.A(mVarC2)), fE).a().c();
                f = fE;
            }
            if (mVarC == null) {
                throw C0309a.a();
            }
            if (!_a.a || _a.b) {
                c0409w = new C0409w(new com.huawei.hms.scankit.p.A(mVarC));
            } else {
                C0417y c0417yA = a(mVarC.b(), mVarC.c(), mVarC.a());
                c0409w = new C0409w(new com.huawei.hms.scankit.p.A(mVarC));
                c0409w.a(c0417yA);
            }
            com.huawei.hms.scankit.aiscan.common.o oVar = new com.huawei.hms.scankit.aiscan.common.o();
            try {
                com.huawei.hms.scankit.aiscan.common.x xVarA = oVar.a(c0409w, map);
                if (xVarA == null || xVarA.i() == null) {
                    throw C0309a.a();
                }
                M.a(xVarA.h(), f, l);
                return xVarA;
            } catch (C0309a unused) {
                return a(oVar, mVarC, c0409w, map, f, l);
            }
        } catch (C0309a unused2) {
            return null;
        }
    }

    public com.huawei.hms.scankit.aiscan.common.x f(List<BarcodeFormat> list, L l) {
        C0409w c0409wG;
        C0409w c0409w;
        com.huawei.hms.scankit.aiscan.common.o oVar = new com.huawei.hms.scankit.aiscan.common.o();
        HashMap map = new HashMap();
        map.put(EnumC0312d.POSSIBLE_FORMATS, list);
        float fE = 1.0f;
        if (l == null) {
            if (!_a.a || (this.b.e() <= 500 && this.b.c() <= 500)) {
                c0409wG = this.b;
            } else {
                fE = (this.b.e() > this.b.c() ? this.b.e() : this.b.c()) / 500.0f;
                c0409wG = this.i.c(this.b, fE);
            }
        } else if (!_a.a || (c0409w = this.d) == null || (c0409w.e() <= 500 && this.d.c() <= 500)) {
            c0409wG = this.d;
        } else {
            fE = (this.d.e() > this.d.c() ? this.d.e() : this.d.c()) / 500.0f;
            c0409wG = this.i.g(this.d, fE);
        }
        try {
            com.huawei.hms.scankit.aiscan.common.x xVarA = oVar.a(c0409wG, map);
            if (xVarA == null) {
                return xVarA;
            }
            try {
                if (xVarA.i() == null) {
                    return xVarA;
                }
                M.a(xVarA.h(), fE, l);
                return xVarA;
            } catch (C0309a unused) {
                return xVarA;
            }
        } catch (C0309a unused2) {
            return null;
        }
    }

    private C0409w b(C0409w c0409w) {
        int iE = c0409w.e();
        int iC = c0409w.c();
        int i = (int) (iE * 0.75d);
        int i2 = (int) (iC * 0.75d);
        int i3 = (iE - i) / 2;
        this.k += i3;
        int i4 = (iC - i2) / 2;
        this.l += i4;
        return c0409w.a(i3, i4, i, i2);
    }

    public static com.huawei.hms.scankit.aiscan.common.x a(l lVar) {
        float fA = lVar.a(lVar.b);
        com.huawei.hms.scankit.aiscan.common.x xVar = new com.huawei.hms.scankit.aiscan.common.x(1.0f);
        xVar.b(fA);
        xVar.b(new L(false, 0.0f, 0.0f, lVar.b.e(), lVar.b.e(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        return xVar;
    }

    private void b(List<L> list) {
        for (L l : list) {
            l.a(this.a.c(), this.a.a(), this.k, this.l);
            float fMin = Math.min(Math.abs(l.i() % 90.0f), 90.0f - Math.abs(l.i() % 90.0f));
            if (l.c() * l.f() > this.a.a() * 0.9f * this.a.c() && fMin < 5.0f) {
                l.b(this.a.c(), this.a.a());
            }
        }
    }

    public com.huawei.hms.scankit.aiscan.common.x a(Map<EnumC0312d, Object> map, L l) throws C0309a {
        C0409w c0409w;
        float f;
        com.huawei.hms.scankit.aiscan.common.x xVar;
        C0409w c0409w2;
        com.huawei.hms.scankit.aiscan.common.x xVar2;
        com.huawei.hms.scankit.aiscan.common.o oVar = new com.huawei.hms.scankit.aiscan.common.o();
        C0409w c0409w3 = this.d;
        if (c0409w3 == null) {
            return null;
        }
        _a.d = true;
        int iE = c0409w3.e() > this.d.c() ? this.d.e() : this.d.c();
        if (_a.a && iE > 500) {
            float f2 = iE / 500.0f;
            if (f2 < 1.0f) {
                f2 = 1.0f;
            }
            c0409w = this.i.g(this.d, f2);
            f = f2;
        } else {
            c0409w = this.d;
            f = 1.0f;
        }
        try {
            if (_a.j) {
                c0409w = new C0409w(new com.huawei.hms.scankit.p.A(com.huawei.hms.scankit.aiscan.common.C.a(c0409w.a().c())));
            }
            com.huawei.hms.scankit.aiscan.common.x xVarA = oVar.a(c0409w, map);
            if (xVarA != null) {
                try {
                    if (xVarA.i() == null && xVarA.h() != null && xVarA.h().length >= 3) {
                        xVar = new com.huawei.hms.scankit.aiscan.common.x(null, null, xVarA.h(), BarcodeFormat.QR_CODE);
                        try {
                            xVarA = a(c0409w, map, xVarA, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d});
                        } catch (C0309a unused) {
                            c0409w2 = c0409w;
                            xVar2 = xVarA;
                            com.huawei.hms.scankit.aiscan.common.x xVarA2 = a(c0409w2, xVar2, xVar, oVar, map, f, l);
                            if ((xVarA2 == null || xVarA2.i() == null) && !_a.c && xVarA2 != null && xVarA2.h() != null && xVarA2.h().length >= 3) {
                                M.a(xVarA2.h(), f, l);
                                float fA = H.a(this.a.c(), this.a.a(), xVarA2.h());
                                if (Math.abs(1.0f - fA) > 0.001d) {
                                    this.f = fA;
                                    this.e = true;
                                }
                            }
                            return xVarA2;
                        }
                    }
                } catch (C0309a unused2) {
                    xVar = null;
                }
            }
            if (xVarA != null && xVarA.i() != null) {
                M.a(xVarA.h(), f, l);
                return xVarA;
            }
            throw C0309a.a();
        } catch (C0309a unused3) {
            xVar = null;
            c0409w2 = c0409w;
            xVar2 = null;
        }
    }

    public float b() {
        return this.f;
    }

    public float d() {
        return this.g;
    }

    private C0409w c(C0409w c0409w) {
        int iE = c0409w.e();
        int iC = c0409w.c();
        if (iE < iC) {
            if (iC / iE <= 1.2d) {
                return c0409w;
            }
            int i = (int) (iE * 1.2d);
            int i2 = (iC - i) / 2;
            this.l = i2;
            return c0409w.a(0, i2, iE, i);
        }
        if (iE / iC <= 1.2d) {
            return c0409w;
        }
        int i3 = (int) (iC * 1.2d);
        int i4 = (iE - i3) / 2;
        this.k = i4;
        return c0409w.a(i4, 0, i3, iC);
    }

    public float c() {
        return this.h;
    }

    private com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, com.huawei.hms.scankit.aiscan.common.x xVar, com.huawei.hms.scankit.aiscan.common.x xVar2, com.huawei.hms.scankit.aiscan.common.o oVar, Map<EnumC0312d, Object> map, float f, L l) throws C0309a {
        try {
            if (_a.a) {
                c0409w.a(a(c0409w.d(), c0409w.e(), c0409w.c()));
                xVar = oVar.a(c0409w, map);
                if (xVar != null && xVar.i() == null && xVar.h() != null && xVar.h().length >= 3) {
                    com.huawei.hms.scankit.aiscan.common.x xVar3 = new com.huawei.hms.scankit.aiscan.common.x(null, null, xVar.h(), BarcodeFormat.QR_CODE);
                    try {
                        xVar = a(c0409w, map, xVar, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d});
                    } catch (C0309a unused) {
                        xVar2 = xVar3;
                        if (xVar == null && (_a.s || (!_a.c && _a.l))) {
                            try {
                                c0409w.a(c0409w.b().c());
                                com.huawei.hms.scankit.aiscan.common.x xVarA = oVar.a(c0409w, map);
                                if (xVarA != null && xVarA.i() != null) {
                                    M.a(xVarA.h(), f, l);
                                    return xVarA;
                                }
                            } catch (C0309a unused2) {
                            }
                        }
                        return xVar2;
                    }
                }
                if (xVar != null && xVar.i() != null) {
                    M.a(xVar.h(), f, l);
                    return xVar;
                }
            }
            throw C0309a.a();
        } catch (C0309a unused3) {
        }
    }

    public com.huawei.hms.scankit.aiscan.common.x a(Map<EnumC0312d, Object> map) {
        com.huawei.hms.scankit.aiscan.common.m mVarC;
        float f;
        com.huawei.hms.scankit.aiscan.common.x xVarA;
        com.huawei.hms.scankit.aiscan.common.o oVar = new com.huawei.hms.scankit.aiscan.common.o();
        com.huawei.hms.scankit.aiscan.common.m mVar = this.a;
        if (!_a.a || (this.b.e() <= 800 && this.b.c() <= 800)) {
            mVarC = mVar;
            f = 1.0f;
        } else {
            float fMax = Math.max(this.b.e(), this.b.c()) / 800.0f;
            if (_a.c && (this.b.e() > this.b.c() * this.j || this.b.c() > this.b.e() * this.j)) {
                fMax = Math.min(this.b.e(), this.b.c()) / 860.0f;
            }
            mVarC = this.i.d(this.b, fMax).a().c();
            f = fMax;
        }
        if (mVarC == null) {
            return null;
        }
        C0409w c0409w = new C0409w(new com.huawei.hms.scankit.p.A(mVarC));
        Xa.a(this.a);
        try {
            if (_a.a) {
                c0409w.a(a(mVarC.b(), mVarC.c(), mVarC.a()));
            }
            xVarA = oVar.a(c0409w, map);
        } catch (C0309a unused) {
        }
        if (xVarA != null && xVarA.i() != null) {
            return a(xVarA, f, 0, 0);
        }
        com.huawei.hms.scankit.aiscan.common.x xVar = (xVarA == null || xVarA.h() == null || xVarA.h().length < 3) ? null : new com.huawei.hms.scankit.aiscan.common.x(null, null, xVarA.h(), BarcodeFormat.QR_CODE);
        com.huawei.hms.scankit.aiscan.common.x xVar2 = xVar == null ? new com.huawei.hms.scankit.aiscan.common.x(null, null, null, BarcodeFormat.QR_CODE) : xVar;
        if (_a.c) {
            xVar2 = a(oVar, mVarC, xVar2, map, f, 0, 0);
        }
        if (xVar2 != null && xVar2.i() != null) {
            return xVar2;
        }
        if (xVar2 != null && xVar2.h() != null) {
            xVar = xVar2;
        }
        if (!_a.c && xVar != null && xVar.h() != null && xVar.h().length >= 3) {
            a(xVar, f, 0, 0);
            float fA = H.a(this.a.c(), this.a.a(), xVar.h());
            if (Math.abs(1.0f - fA) > 0.001d) {
                this.f = fA;
                this.e = true;
            }
        }
        return xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.aiscan.common.o r15, com.huawei.hms.scankit.aiscan.common.m r16, com.huawei.hms.scankit.aiscan.common.x r17, java.util.Map<com.huawei.hms.scankit.aiscan.common.EnumC0312d, java.lang.Object> r18, float r19, int r20, int r21) {
        /*
            r14 = this;
            r7 = r14
            r4 = r17
            r5 = r18
            r6 = r19
            r0 = r20
            r1 = r21
            boolean r2 = com.huawei.hms.scankit.p._a.a
            r3 = 0
            if (r2 == 0) goto L99
            r2 = 3
            com.huawei.hms.scankit.p.A r8 = new com.huawei.hms.scankit.p.A     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L4a
            r9 = r16
            r8.<init>(r9)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L48
            com.huawei.hms.scankit.p.w r10 = new com.huawei.hms.scankit.p.w     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L48
            r10.<init>(r8)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L48
            r8 = r15
            com.huawei.hms.scankit.aiscan.common.x r3 = r15.a(r10, r5)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L46
            if (r3 == 0) goto L2f
            java.lang.String r11 = r3.i()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L46
            if (r11 == 0) goto L2f
            com.huawei.hms.scankit.aiscan.common.x r0 = r14.a(r3, r6, r0, r1)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L46
            return r0
        L2f:
            if (r3 == 0) goto L4e
            com.huawei.hms.scankit.aiscan.common.z[] r11 = r3.h()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L46
            if (r11 == 0) goto L4e
            com.huawei.hms.scankit.aiscan.common.z[] r11 = r3.h()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L46
            int r11 = r11.length     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L46
            if (r11 < r2) goto L4e
            com.huawei.hms.scankit.aiscan.common.z[] r3 = r3.h()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L46
            r4.b(r3)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L46
            goto L4e
        L46:
            goto L4e
        L48:
            r8 = r15
            goto L4d
        L4a:
            r8 = r15
            r9 = r16
        L4d:
            r10 = r3
        L4e:
            if (r4 == 0) goto L8a
            com.huawei.hms.scankit.aiscan.common.z[] r3 = r17.h()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            if (r3 == 0) goto L8a
            com.huawei.hms.scankit.aiscan.common.z[] r3 = r17.h()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            int r3 = r3.length     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            if (r3 < r2) goto L8a
            boolean r3 = com.huawei.hms.scankit.p._a.h     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            if (r3 != 0) goto L8a
            r3 = 6
            double[] r3 = new double[r3]     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            r11 = 0
            r12 = 0
            r3[r11] = r12     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            r11 = 1
            r3[r11] = r12     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            r11 = 2
            r3[r11] = r12     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            r3[r2] = r12     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            r2 = 4
            r3[r2] = r12     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            r2 = 5
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r3[r2] = r11     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            com.huawei.hms.scankit.aiscan.common.x r2 = r14.a(r10, r5, r4, r3)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            if (r2 == 0) goto L8a
            java.lang.String r3 = r2.i()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            if (r3 == 0) goto L8a
            com.huawei.hms.scankit.aiscan.common.x r0 = r14.a(r2, r6, r0, r1)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8a
            return r0
        L8a:
            r0 = r14
            r1 = r10
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            com.huawei.hms.scankit.aiscan.common.x r3 = r0.a(r1, r2, r3, r4, r5, r6)
        L99:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.l.a(com.huawei.hms.scankit.aiscan.common.o, com.huawei.hms.scankit.aiscan.common.m, com.huawei.hms.scankit.aiscan.common.x, java.util.Map, float, int, int):com.huawei.hms.scankit.aiscan.common.x");
    }

    private com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, com.huawei.hms.scankit.aiscan.common.o oVar, com.huawei.hms.scankit.aiscan.common.m mVar, com.huawei.hms.scankit.aiscan.common.x xVar, Map<EnumC0312d, Object> map, float f) {
        com.huawei.hms.scankit.aiscan.common.x xVarA = null;
        try {
            Xa.a(this.a, xVar);
            if (_a.c && _a.q[1]) {
                _a.n = true;
                xVarA = oVar.a(this.b, map);
                _a.n = false;
                if (xVarA != null && xVarA.i() != null) {
                    return a(xVarA, f, 0, 0);
                }
            }
        } catch (C0309a unused) {
            _a.n = false;
        }
        float fE = c0409w.e() / c0409w.c();
        if (fE < 1.0f) {
            fE = 1.0f / fE;
        }
        if (!_a.h && !_a.i) {
            double d = fE;
            if (d > 1.27d && d < 1.272d) {
                _a.p = true;
                try {
                    com.huawei.hms.scankit.aiscan.common.x xVarA2 = oVar.a(new C0409w(new com.huawei.hms.scankit.p.B(mVar)), map);
                    if (xVarA2 != null) {
                        try {
                            if (xVarA2.i() != null) {
                                return a(xVarA2, f, 0, 0);
                            }
                        } catch (C0309a unused2) {
                        }
                    }
                    xVarA = xVarA2;
                } catch (C0309a unused3) {
                }
                _a.p = false;
            }
        }
        return xVarA;
    }

    private com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.aiscan.common.o oVar, com.huawei.hms.scankit.aiscan.common.m mVar, C0409w c0409w, Map<EnumC0312d, Object> map, float f, L l) throws C0309a {
        com.huawei.hms.scankit.aiscan.common.x xVarA = null;
        if (_a.a && !_a.b) {
            try {
                C0409w c0409w2 = new C0409w(new com.huawei.hms.scankit.p.A(mVar));
                try {
                    xVarA = oVar.a(c0409w2, map);
                    if (xVarA != null && xVarA.i() != null) {
                        M.a(xVarA.h(), f, l);
                        return xVarA;
                    }
                } catch (C0309a unused) {
                }
                c0409w = c0409w2;
            } catch (C0309a unused2) {
            }
            if (xVarA != null && xVarA.h() != null && xVarA.h().length >= 3) {
                try {
                    xVarA = a(c0409w, map, xVarA, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d});
                    if (xVarA != null && xVarA.i() != null) {
                        M.a(xVarA.h(), f, l);
                        return xVarA;
                    }
                } catch (C0309a unused3) {
                }
            }
        }
        C0409w c0409w3 = new C0409w(new com.huawei.hms.scankit.p.B(mVar));
        try {
            com.huawei.hms.scankit.aiscan.common.x xVarA2 = oVar.a(c0409w3, map);
            if (xVarA2 != null && xVarA2.i() != null) {
                M.a(xVarA2.h(), f, l);
                return xVarA2;
            }
            throw C0309a.a();
        } catch (C0309a unused4) {
            if (_a.a && !_a.b && xVarA != null && xVarA.h() != null && xVarA.h().length >= 3 && (xVarA = a(c0409w3, map, xVarA, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d})) != null && xVarA.i() != null) {
                M.a(xVarA.h(), f, l);
            }
            return xVarA;
        }
    }

    public com.huawei.hms.scankit.aiscan.common.x a(List<BarcodeFormat> list, L l) {
        com.huawei.hms.scankit.aiscan.common.o oVar = new com.huawei.hms.scankit.aiscan.common.o();
        HashMap map = new HashMap();
        map.put(EnumC0312d.POSSIBLE_FORMATS, list);
        if (_a.c) {
            map.put(EnumC0312d.PHOTO_MODE, Boolean.valueOf(_a.c));
        }
        com.huawei.hms.scankit.aiscan.common.x xVarA = null;
        try {
            if (l != null) {
                xVarA = oVar.a(this.b, this.d, map, this.i, l);
            } else {
                xVarA = oVar.a(this.b, (C0409w) null, map, this.i, (L) null);
            }
        } catch (C0309a unused) {
        }
        if (xVarA != null || _a.b || l == null || !_a.c || l.h() >= 0.8d) {
            return xVarA;
        }
        float fI = l.i() % 180.0f;
        boolean z = true;
        boolean z2 = ((double) l.c()) > ((double) this.b.c()) * 0.97d && ((fI < 5.0f && fI > -5.0f) || fI < -175.0f || fI > 175.0f);
        if (l.b() <= this.b.e() * 0.97d || ((fI >= 95.0f || fI <= 85.0f) && (fI >= -85.0f || fI <= -95.0f))) {
            z = false;
        }
        if (!z2 && !z) {
            return xVarA;
        }
        this.i.a();
        try {
            return oVar.a(this.b, (C0409w) null, map, this.i, (L) null);
        } catch (C0309a unused2) {
            return xVarA;
        }
    }

    public List<L> a(int i, boolean z) {
        List<L> listA;
        C0409w c0409w;
        ArrayList arrayList = new ArrayList();
        if (!_a.a) {
            return arrayList;
        }
        boolean z2 = _a.b;
        if (!z2) {
            byte[] bArrC = z.c();
            float[] fArrD = z.d();
            int iA = z.a();
            byte[] bArrB = z.b();
            LoadOpencvJNIUtil.setModel(bArrC, bArrC.length, fArrD, iA, bArrB, bArrB.length);
            C0409w c0409wB = this.b;
            long jCurrentTimeMillis = System.currentTimeMillis() % 10;
            boolean z3 = jCurrentTimeMillis % 2 == 0;
            boolean z4 = jCurrentTimeMillis % 3 == 0;
            if (i == 0 && !_a.c && z3) {
                c0409wB = c(this.b);
            } else if (i == 0 && !_a.c && z4) {
                c0409wB = b(c(this.b));
            } else {
                if (this.a.a() / this.a.c() > 1.35d) {
                    int iA2 = (int) (this.a.a() / 1.3f);
                    this.l = 0;
                    this.k = (-(iA2 - this.a.c())) / 2;
                    com.huawei.hms.scankit.aiscan.common.m mVar = this.a;
                    c0409w = new C0409w(new com.huawei.hms.scankit.p.A(mVar.b(iA2, mVar.a(), -this.k, -this.l)));
                } else if (1.0f / r1 > 1.35d) {
                    int iC = (int) (this.a.c() / 1.3f);
                    this.l = (-(iC - this.a.a())) / 2;
                    this.k = 0;
                    com.huawei.hms.scankit.aiscan.common.m mVar2 = this.a;
                    c0409w = new C0409w(new com.huawei.hms.scankit.p.A(mVar2.b(mVar2.c(), iC, -this.k, -this.l)));
                }
                c0409wB = c0409w;
            }
            listA = M.a(_a.b, c0409wB, i, z);
        } else {
            listA = M.a(z2, this.b, i, z);
        }
        List<L> list = listA;
        b(list);
        return list;
    }

    public void a(L l) {
        try {
            if (_a.a) {
                M.a(_a.b, this.b, l);
                this.d = l.l;
            }
        } catch (C0309a unused) {
        }
    }

    private com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, Map<EnumC0312d, Object> map, com.huawei.hms.scankit.aiscan.common.x xVar, double[] dArr) throws C0309a {
        com.huawei.hms.scankit.aiscan.common.x xVarA;
        if (c0409w == null) {
            return null;
        }
        com.huawei.hms.scankit.aiscan.common.o oVar = new com.huawei.hms.scankit.aiscan.common.o();
        int[] iArr = {0, 0};
        com.huawei.hms.scankit.aiscan.common.r rVar = new com.huawei.hms.scankit.aiscan.common.r(com.huawei.hms.scankit.aiscan.common.D.a(c0409w, map, xVar, iArr, dArr), iArr[0], iArr[1], 0, 0, iArr[0], iArr[1], false);
        try {
            xVarA = oVar.a(new C0409w(new com.huawei.hms.scankit.p.A(rVar)), map);
            if (xVarA != null) {
                try {
                    if (xVarA.i() != null) {
                        com.huawei.hms.scankit.aiscan.common.z[] zVarArrA = com.huawei.hms.scankit.aiscan.common.D.a(xVarA.h(), c0409w.e(), c0409w.c(), dArr);
                        xVarA.a();
                        xVarA.b(zVarArrA);
                        return xVarA;
                    }
                } catch (C0309a unused) {
                    C0409w c0409w2 = new C0409w(new com.huawei.hms.scankit.p.B(rVar));
                    try {
                        com.huawei.hms.scankit.aiscan.common.x xVarA2 = oVar.a(c0409w2, map);
                        if (xVarA2 != null && xVarA2.i() != null) {
                            com.huawei.hms.scankit.aiscan.common.z[] zVarArrA2 = com.huawei.hms.scankit.aiscan.common.D.a(xVarA2.h(), c0409w.e(), c0409w.c(), dArr);
                            xVarA2.a();
                            xVarA2.b(zVarArrA2);
                            return xVarA2;
                        }
                        throw C0309a.a();
                    } catch (C0309a unused2) {
                        c0409w2.a(a(rVar.b(), rVar.c(), rVar.a()));
                        try {
                            com.huawei.hms.scankit.aiscan.common.x xVarA3 = oVar.a(c0409w2, map);
                            if (xVarA3 != null && xVarA3.i() != null) {
                                com.huawei.hms.scankit.aiscan.common.z[] zVarArrA3 = com.huawei.hms.scankit.aiscan.common.D.a(xVarA3.h(), c0409w.e(), c0409w.c(), dArr);
                                xVarA3.a();
                                xVarA3.b(zVarArrA3);
                                return xVarA3;
                            }
                            throw C0309a.a();
                        } catch (C0309a unused3) {
                            return xVarA;
                        }
                    }
                }
            }
            throw C0309a.a();
        } catch (C0309a unused4) {
            xVarA = xVar;
        }
    }

    private com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.aiscan.common.x xVar, float f, int i, int i2) {
        if (xVar != null && xVar.h().length == 4 && (f != 1.0f || i != 0 || i2 != 0)) {
            com.huawei.hms.scankit.aiscan.common.z[] zVarArr = new com.huawei.hms.scankit.aiscan.common.z[4];
            for (int i3 = 0; i3 < 4; i3++) {
                zVarArr[i3] = new com.huawei.hms.scankit.aiscan.common.z((xVar.h()[i3].b() * f) + i, (xVar.h()[i3].c() * f) + i2);
            }
            xVar.a();
            xVar.a(zVarArr);
        }
        return xVar;
    }

    public static C0417y a(byte[] bArr, int i, int i2) throws C0309a {
        byte[] bArrAdaptivebinary = LoadOpencvJNIUtil.adaptivebinary(bArr, i2, i, 45);
        if (bArrAdaptivebinary != null) {
            C0417y c0417y = new C0417y(i, i2);
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    if (bArrAdaptivebinary[(i3 * i) + i4] == 0) {
                        c0417y.c(i4, i3);
                    }
                }
            }
            return c0417y;
        }
        throw C0309a.a();
    }

    public float a(C0409w c0409w) {
        if (((c0409w == null || (c0409w.a() == null && c0409w.a().c() == null)) ? null : c0409w.a().c().b()) == null) {
            return 1.0f;
        }
        long j = 0;
        int iE = c0409w.e();
        int iC = c0409w.c();
        for (int i = iC / 4; i < (iC * 3) / 4; i++) {
            for (int i2 = iE / 4; i2 < (iE * 3) / 4; i2++) {
                j += r0[(i * iE) + i2] & 255;
            }
        }
        return (j / r0.length) * 4;
    }

    public boolean a() {
        return this.e;
    }

    public boolean a(List<L> list) {
        int i;
        for (L l : list) {
            boolean z = l.g() == 1.0f && ((double) l.h()) > 0.7d;
            boolean z2 = l.g() == 1.0f && ((double) l.h()) > 0.4d;
            boolean z3 = l.g() == 2.0f && ((double) l.h()) > 0.7d;
            boolean z4 = l.g() == 3.0f && ((double) l.h()) > 0.7d;
            if (z2 || z3 || z4) {
                if (!z && !a(this.b, l) && (i = _a.g) <= 4) {
                    _a.g = i + 2;
                } else {
                    _a.g = 0;
                    float fB = H.b(this.a.c(), this.a.a(), new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z(l.d(), l.e()), new com.huawei.hms.scankit.aiscan.common.z(l.d() + l.f(), l.e()), new com.huawei.hms.scankit.aiscan.common.z(l.d(), l.e() + l.c())});
                    if (fB > 1.001f) {
                        this.g = fB;
                        this.e = true;
                    }
                }
            }
        }
        return this.e;
    }

    private static boolean a(C0409w c0409w, L l) {
        if (_a.a && !_a.b) {
            float fD = l.d();
            float fE = l.e();
            float f = l.f();
            float fC = l.c();
            float f2 = fD - ((f * 0.2f) / 2.0f);
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f3 = fE - ((0.2f * fC) / 2.0f);
            float f4 = f3 >= 0.0f ? f3 : 0.0f;
            float fE2 = (f * 1.2f) + f2;
            if (fE2 > c0409w.e()) {
                fE2 = c0409w.e();
            }
            float fC2 = (fC * 1.2f) + f4;
            if (fC2 > c0409w.c()) {
                fC2 = c0409w.c();
            }
            float f5 = fE2 - f2;
            float f6 = fC2 - f4;
            if (f5 < c0409w.e() / 2.0f && f6 < c0409w.c() / 2.0f) {
                for (L l2 : M.a(_a.b, c0409w.a((int) f2, (int) f4, (int) f5, (int) f6), 0, true)) {
                    boolean z = l2.g() == 1.0f && ((double) l2.h()) > 0.5d;
                    boolean z2 = l.g() == 2.0f && l2.g() == 2.0f && ((double) l2.h()) > 0.7d;
                    boolean z3 = l.g() == 3.0f && l2.g() == 3.0f && ((double) l2.h()) > 0.7d;
                    if (z || z2 || z3) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}
