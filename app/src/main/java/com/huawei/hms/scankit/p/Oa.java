package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: classes3.dex */
public class Oa {
    private final C0417y a;
    private com.huawei.hms.scankit.aiscan.common.A b;

    public Oa(C0417y c0417y) {
        this.a = c0417y;
    }

    private static com.huawei.hms.scankit.aiscan.common.q a(com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2, com.huawei.hms.scankit.aiscan.common.z zVar3, com.huawei.hms.scankit.aiscan.common.z zVar4, com.huawei.hms.scankit.aiscan.common.z zVar5, int i) {
        float fB;
        float fC;
        float fB2;
        float fC2;
        float f = i - 3.5f;
        if (zVar4 != null) {
            float fB3 = zVar4.b();
            fB = fB3;
            fC = zVar4.c();
            fB2 = zVar5.b();
            fC2 = zVar5.c();
        } else {
            fB = (zVar2.b() - zVar.b()) + zVar3.b();
            fC = (zVar2.c() - zVar.c()) + zVar3.c();
            fB2 = f;
            fC2 = fB2;
        }
        return com.huawei.hms.scankit.aiscan.common.q.a(3.5f, 3.5f, f, 3.5f, fB2, fC2, 3.5f, f, zVar.b(), zVar.c(), zVar2.b(), zVar2.c(), fB, fC, zVar3.b(), zVar3.c());
    }

    private float b(int i, int i2, int i3, int i4) {
        float fD;
        float fB;
        float fA = a(i, i2, i3, i4);
        int iD = i - (i3 - i);
        int iB = 0;
        if (iD < 0) {
            fD = i / (i - iD);
            iD = 0;
        } else if (iD >= this.a.d()) {
            fD = ((this.a.d() - 1) - i) / (iD - i);
            iD = this.a.d() - 1;
        } else {
            fD = 1.0f;
        }
        float f = i2;
        int i5 = (int) (f - ((i4 - i2) * fD));
        if (i5 < 0) {
            fB = f / (i2 - i5);
        } else if (i5 >= this.a.b()) {
            fB = ((this.a.b() - 1) - i2) / (i5 - i2);
            iB = this.a.b() - 1;
        } else {
            iB = i5;
            fB = 1.0f;
        }
        float fA2 = a(i, i2, (int) (i + ((iD - i) * fB)), iB);
        if (Math.max(fA, fA2) > Math.min(fA, fA2) * 1.5d) {
            return Float.NaN;
        }
        return (fA + fA2) - 1.0f;
    }

    private static C0417y a(C0417y c0417y, com.huawei.hms.scankit.aiscan.common.q qVar, int i) throws C0309a {
        return com.huawei.hms.scankit.aiscan.common.j.a().a(c0417y, i, i, qVar, true);
    }

    private static int a(com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2, com.huawei.hms.scankit.aiscan.common.z zVar3, float f) throws C0309a {
        int iA;
        int i;
        try {
            iA = ((com.huawei.hms.scankit.aiscan.common.n.a(com.huawei.hms.scankit.aiscan.common.z.a(zVar, zVar2) / f) + com.huawei.hms.scankit.aiscan.common.n.a(com.huawei.hms.scankit.aiscan.common.z.a(zVar, zVar3) / f)) / 2) + 7;
            i = iA & 3;
        } catch (C0309a unused) {
            iA = ((((int) (com.huawei.hms.scankit.aiscan.common.z.a(zVar, zVar2) / f)) + ((int) (com.huawei.hms.scankit.aiscan.common.z.a(zVar, zVar3) / f))) / 2) + 7;
            int i2 = iA & 3;
            if (i2 != 0) {
                if (i2 != 2) {
                    return i2 != 3 ? iA : iA + 2;
                }
            }
        }
        if (i != 0) {
            if (i != 2) {
                if (i != 3) {
                    return iA;
                }
                throw C0309a.a();
            }
            return iA - 1;
        }
        return iA + 1;
    }

    public final com.huawei.hms.scankit.aiscan.common.g a(Map<EnumC0312d, ?> map) throws C0309a {
        this.b = map == null ? null : (com.huawei.hms.scankit.aiscan.common.A) map.get(EnumC0312d.NEED_RESULT_POINT_CALLBACK);
        return a(new Sa(this.a, this.b).a());
    }

    public final com.huawei.hms.scankit.aiscan.common.g a(Ta ta) throws C0309a {
        Qa qaB = ta.b();
        Qa qaC = ta.c();
        Qa qaA = ta.a();
        try {
            float fA = a(qaB, qaC, qaA);
            if (fA >= 1.0f) {
                return a(qaB, qaC, qaA, fA);
            }
            throw C0309a.a();
        } catch (C0309a unused) {
            float fE = ((qaB.e() + qaC.e()) + qaA.e()) / 3.0f;
            if (fE >= 1.0f) {
                return a(qaB, qaC, qaA, fE);
            }
            throw C0309a.a();
        }
    }

    private com.huawei.hms.scankit.aiscan.common.g a(Qa qa, Qa qa2, Qa qa3, float f) throws C0309a {
        C0418ya[] c0418yaArr;
        C0418ya[] c0418yaArr2;
        C0418ya[] c0418yaArr3;
        char c;
        int iA;
        com.huawei.hms.scankit.aiscan.common.q qVar;
        com.huawei.hms.scankit.aiscan.common.z[] zVarArr;
        int iA2 = a((com.huawei.hms.scankit.aiscan.common.z) qa, (com.huawei.hms.scankit.aiscan.common.z) qa2, (com.huawei.hms.scankit.aiscan.common.z) qa3, f);
        _a.r.push(Integer.valueOf(iA2));
        Ya yaB = Ya.b(iA2);
        if (_a.n && _a.c) {
            return a(qa, qa2, qa3, f, iA2);
        }
        int iC = yaB.c() - 7;
        int length = yaB.b().length;
        int i = length * length;
        C0418ya[] c0418yaArr4 = new C0418ya[i];
        C0418ya[] c0418yaArr5 = new C0418ya[i];
        C0418ya[] c0418yaArr6 = new C0418ya[2];
        if (yaB.b().length > 0) {
            c0418yaArr = c0418yaArr6;
            c = 2;
            c0418yaArr2 = c0418yaArr5;
            c0418yaArr3 = c0418yaArr4;
            iA = a(qa, qa2, qa3, f, iA2, yaB, c0418yaArr4, c0418yaArr5, length, iC, c0418yaArr);
        } else {
            c0418yaArr = c0418yaArr6;
            c0418yaArr2 = c0418yaArr5;
            c0418yaArr3 = c0418yaArr4;
            c = 2;
            iA = 0;
        }
        C0418ya c0418ya = c0418yaArr[0];
        com.huawei.hms.scankit.aiscan.common.q qVarA = a(qa, qa2, qa3, c0418ya, c0418yaArr[1], iA2);
        if (_a.k && _a.h) {
            qVar = qVarA;
            a(qVarA, length, iA2, qa, qa2, qa3, c0418yaArr3, iA, c0418yaArr2);
        } else {
            qVar = qVarA;
        }
        C0417y c0417yA = a(this.a, qVar, iA2);
        if (c0418ya == null) {
            zVarArr = new com.huawei.hms.scankit.aiscan.common.z[3];
            zVarArr[0] = qa3;
            zVarArr[1] = qa;
            zVarArr[c] = qa2;
        } else {
            zVarArr = new com.huawei.hms.scankit.aiscan.common.z[4];
            zVarArr[0] = qa3;
            zVarArr[1] = qa;
            zVarArr[c] = qa2;
            zVarArr[3] = c0418ya;
        }
        float[] fArr = new float[8];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = iA2;
        fArr[c] = f2;
        fArr[3] = 0.0f;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = 0.0f;
        fArr[7] = f2;
        qVar.a(fArr);
        com.huawei.hms.scankit.aiscan.common.z zVar = new com.huawei.hms.scankit.aiscan.common.z(fArr[0], fArr[1], qa.d());
        com.huawei.hms.scankit.aiscan.common.z zVar2 = new com.huawei.hms.scankit.aiscan.common.z(fArr[c], fArr[3], qa2.d());
        com.huawei.hms.scankit.aiscan.common.z zVar3 = new com.huawei.hms.scankit.aiscan.common.z(fArr[4], fArr[5], qa3.d());
        com.huawei.hms.scankit.aiscan.common.z[] zVarArr2 = new com.huawei.hms.scankit.aiscan.common.z[4];
        zVarArr2[0] = a(new com.huawei.hms.scankit.aiscan.common.z(fArr[6], fArr[7]));
        zVarArr2[1] = a(zVar);
        zVarArr2[c] = a(zVar2);
        zVarArr2[3] = a(zVar3);
        return new com.huawei.hms.scankit.aiscan.common.g(c0417yA, zVarArr, zVarArr2, f);
    }

    private int a(Qa qa, Qa qa2, Qa qa3, float f, int i, Ya ya, C0418ya[] c0418yaArr, C0418ya[] c0418yaArr2, int i2, int i3, C0418ya[] c0418yaArr3) {
        int i4;
        int i5;
        float fB = (qa2.b() - qa.b()) + qa3.b();
        float fC = (qa2.c() - qa.c()) + qa3.c();
        float f2 = i3;
        float f3 = 3.0f / f2;
        float f4 = 1.0f - f3;
        int iB = (int) (qa.b() + ((fB - qa.b()) * f4));
        int iC = (int) (qa.c() + (f4 * (fC - qa.c())));
        if (_a.q[0] && i3 == 22) {
            i4 = 2;
            i5 = 8;
        } else {
            i4 = 4;
            i5 = 16;
        }
        for (int i6 = i4; i6 <= i5; i6 <<= 1) {
            try {
                c0418yaArr3[0] = a(f, iB, iC, i6);
                break;
            } catch (C0309a unused) {
            }
        }
        float f5 = i - 6.5f;
        c0418yaArr3[1] = new C0418ya(f5, f5, qa3.e());
        if (c0418yaArr3[0] != null && com.huawei.hms.scankit.aiscan.common.n.a(iB, iC, c0418yaArr3[0].b(), c0418yaArr3[0].c()) > f * 4.0f) {
            c0418yaArr3[0] = null;
        }
        if (c0418yaArr3[0] == null && i2 > 2) {
            int i7 = i2 - 2;
            c0418yaArr3[1] = new C0418ya(ya.b()[i7] + 0.5f, f5, qa3.e());
            int iC2 = (int) (qa3.c() - (f3 * (qa3.c() - qa.c())));
            int iB2 = (int) ((((ya.b()[i7] - 3.0f) / f2) * (qa2.b() - qa.b())) + qa3.b());
            while (i4 <= i5) {
                try {
                    c0418yaArr3[0] = a(f, iB2, iC2, i4);
                    break;
                } catch (C0309a unused2) {
                    i4 <<= 1;
                }
            }
            if (c0418yaArr3[0] != null && com.huawei.hms.scankit.aiscan.common.n.a(iB2, iC2, c0418yaArr3[0].b(), c0418yaArr3[0].c()) > f * 4.0f) {
                c0418yaArr3[0] = null;
            }
        }
        if (_a.k && _a.h) {
            return a(ya, i3, qa2, qa, qa3, f, i2, 0, c0418yaArr, c0418yaArr2);
        }
        return 0;
    }

    private int a(Ya ya, int i, Qa qa, Qa qa2, Qa qa3, float f, int i2, int i3, C0418ya[] c0418yaArr, C0418ya[] c0418yaArr2) {
        int i4;
        int i5;
        int i6;
        float f2;
        int i7 = i2;
        int i8 = i3;
        int i9 = 0;
        while (i9 < i7) {
            if (i9 == 0) {
                i4 = i7 - 1;
                i5 = 1;
            } else {
                i4 = i7;
                i5 = 0;
            }
            int i10 = i9 != i7 + (-1) ? i5 : 1;
            float f3 = 3.0f;
            float f4 = i;
            float fB = (((ya.b()[i9] - 3.0f) * (qa.b() - qa2.b())) / f4) + qa2.b();
            float fC = (((ya.b()[i9] - 3.0f) * (qa.c() - qa2.c())) / f4) + qa2.c();
            while (i10 < i4) {
                int iC = (int) (fC - (((ya.b()[i10] - f3) * (qa2.c() - qa3.c())) / f4));
                int iB = (int) (fB - (((ya.b()[i10] - f3) * (qa2.b() - qa3.b())) / f4));
                int i11 = 4;
                int i12 = 4;
                while (true) {
                    if (i12 > i11) {
                        i6 = i4;
                        f2 = fB;
                        break;
                    }
                    int i13 = (i9 * i7) + i10;
                    try {
                        c0418yaArr[i13] = a(f, iB, iC, i12);
                        i6 = i4;
                    } catch (C0309a unused) {
                        i6 = i4;
                    }
                    try {
                        f2 = fB;
                        try {
                            c0418yaArr2[i13] = new C0418ya(ya.b()[i9] + 0.5f, ya.b()[i10] + 0.5f, qa3.e());
                            i8++;
                            break;
                        } catch (C0309a unused2) {
                            continue;
                        }
                    } catch (C0309a unused3) {
                        f2 = fB;
                        i12 <<= 1;
                        i7 = i2;
                        fB = f2;
                        i4 = i6;
                        i11 = 4;
                    }
                    i12 <<= 1;
                    i7 = i2;
                    fB = f2;
                    i4 = i6;
                    i11 = 4;
                }
                i10++;
                i7 = i2;
                fB = f2;
                i4 = i6;
                f3 = 3.0f;
            }
            i9++;
            i7 = i2;
        }
        return i8;
    }

    private void a(com.huawei.hms.scankit.aiscan.common.q qVar, int i, int i2, Qa qa, Qa qa2, Qa qa3, C0418ya[] c0418yaArr, int i3, C0418ya[] c0418yaArr2) {
        int i4 = i3 + 3;
        int i5 = i4 * 2;
        float[] fArr = new float[i5];
        float[] fArr2 = new float[i5];
        fArr[0] = qa.b();
        fArr[1] = qa.c();
        fArr[2] = qa2.b();
        fArr[3] = qa2.c();
        fArr[4] = qa3.b();
        fArr[5] = qa3.c();
        fArr2[0] = 3.5f;
        fArr2[1] = 3.5f;
        float f = i2 - 3.5f;
        fArr2[2] = f;
        fArr2[3] = 3.5f;
        fArr2[4] = 3.5f;
        fArr2[5] = f;
        int i6 = 6;
        int i7 = 6;
        for (int i8 = 0; i8 < i * i; i8++) {
            if (c0418yaArr[i8] != null) {
                int i9 = i6 + 1;
                fArr[i6] = c0418yaArr[i8].b();
                i6 = i9 + 1;
                fArr[i9] = c0418yaArr[i8].c();
                int i10 = i7 + 1;
                fArr2[i7] = c0418yaArr2[i8].b();
                i7 = i10 + 1;
                fArr2[i10] = c0418yaArr2[i8].c();
            }
        }
        float[] fArrQuadFitting = LoadOpencvJNIUtil.QuadFitting(fArr2, i4, fArr);
        if (fArrQuadFitting.length != 0) {
            qVar.a(fArrQuadFitting[0], fArrQuadFitting[1], fArrQuadFitting[2], fArrQuadFitting[3], fArrQuadFitting[4], fArrQuadFitting[5], fArrQuadFitting[6], fArrQuadFitting[7], fArrQuadFitting[8], fArrQuadFitting[9], fArrQuadFitting[10], fArrQuadFitting[11], fArrQuadFitting[12], fArrQuadFitting[13]);
        }
    }

    private com.huawei.hms.scankit.aiscan.common.g a(Qa qa, Qa qa2, Qa qa3, float f, int i) {
        C0417y c0417y = new C0417y(i, i);
        float f2 = i;
        float fB = this.a.b() / f2;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                double d = fB * 0.5d;
                int i4 = (int) ((i3 * fB) + d);
                int i5 = (int) ((i2 * fB) + d);
                if (i4 >= -1 && i4 <= this.a.d() && i5 >= -1 && i5 <= this.a.b()) {
                    if (this.a.b(i4, i5)) {
                        c0417y.c(i3, i2);
                    }
                } else {
                    c0417y.c(i3, i2);
                }
            }
        }
        com.huawei.hms.scankit.aiscan.common.z[] zVarArr = {qa3, qa, qa2};
        float[] fArr = {0.0f, 0.0f, f2, 0.0f, f2, f2, 0.0f, f2};
        a(qa, qa2, qa3, null, null, i).a(fArr);
        return new com.huawei.hms.scankit.aiscan.common.g(c0417y, zVarArr, new com.huawei.hms.scankit.aiscan.common.z[]{a(new com.huawei.hms.scankit.aiscan.common.z(fArr[6], fArr[7])), a(new com.huawei.hms.scankit.aiscan.common.z(fArr[0], fArr[1])), a(new com.huawei.hms.scankit.aiscan.common.z(fArr[2], fArr[3])), a(new com.huawei.hms.scankit.aiscan.common.z(fArr[4], fArr[5]))}, f);
    }

    public final float a(com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2, com.huawei.hms.scankit.aiscan.common.z zVar3) {
        return (a(zVar, zVar2) + a(zVar, zVar3)) / 2.0f;
    }

    private float a(com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2) {
        float fB = b((int) zVar.b(), (int) zVar.c(), (int) zVar2.b(), (int) zVar2.c());
        float fB2 = b((int) zVar2.b(), (int) zVar2.c(), (int) zVar.b(), (int) zVar.c());
        return Float.isNaN(fB) ? fB2 / 7.0f : Float.isNaN(fB2) ? fB / 7.0f : (fB + fB2) / 14.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
    
        if (r15 != 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return com.huawei.hms.scankit.aiscan.common.n.a(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r1 >= r5) goto L39
            r12 = 1
            goto L3a
        L39:
            r12 = -1
        L3a:
            if (r4 >= r6) goto L3d
            r11 = 1
        L3d:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L41:
            if (r13 == r5) goto L80
            if (r0 == 0) goto L47
            r2 = r14
            goto L48
        L47:
            r2 = r13
        L48:
            if (r0 == 0) goto L4c
            r10 = r13
            goto L4d
        L4c:
            r10 = r14
        L4d:
            if (r15 != r3) goto L57
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 1
            goto L5e
        L57:
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 0
        L5e:
            com.huawei.hms.scankit.p.y r5 = r3.a
            boolean r2 = r5.b(r2, r10)
            if (r0 != r2) goto L70
            r0 = 2
            if (r15 != r0) goto L6e
            float r0 = com.huawei.hms.scankit.aiscan.common.n.a(r13, r14, r1, r4)
            return r0
        L6e:
            int r15 = r15 + 1
        L70:
            int r9 = r9 + r8
            if (r9 <= 0) goto L78
            if (r14 != r6) goto L76
            goto L84
        L76:
            int r14 = r14 + r11
            int r9 = r9 - r7
        L78:
            int r13 = r13 + r12
            r5 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L41
        L80:
            r3 = r17
            r19 = r5
        L84:
            r0 = 2
            if (r15 != r0) goto L8e
            r5 = r19
            float r0 = com.huawei.hms.scankit.aiscan.common.n.a(r5, r6, r1, r4)
            return r0
        L8e:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Oa.a(int, int, int, int):float");
    }

    public final C0418ya a(float f, int i, int i2, float f2) throws C0309a {
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.a.d() - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin >= f3) {
            int iMax2 = Math.max(0, i2 - i3);
            int iMin2 = Math.min(this.a.b() - 1, i2 + i3) - iMax2;
            if (iMin2 >= f3) {
                return new C0422za(this.a, iMax, iMax2, iMin, iMin2, f, this.b).a();
            }
            throw C0309a.a();
        }
        throw C0309a.a();
    }

    private com.huawei.hms.scankit.aiscan.common.z a(com.huawei.hms.scankit.aiscan.common.z zVar) {
        float fB = zVar.b();
        float fC = zVar.c();
        int iD = this.a.d() - 1;
        int iB = this.a.b() - 1;
        if (fB < 0.0f) {
            fB = 0.0f;
        }
        float f = iD;
        if (fB > f) {
            fB = f;
        }
        if (fC < 0.0f) {
            fC = 0.0f;
        }
        float f2 = iB;
        if (fC > f2) {
            fC = f2;
        }
        return new com.huawei.hms.scankit.aiscan.common.z(fB, fC, zVar.d());
    }
}
