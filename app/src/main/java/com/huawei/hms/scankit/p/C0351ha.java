package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: BoundingBox.java */
/* renamed from: com.huawei.hms.scankit.p.ha, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0351ha {
    private final C0417y a;
    private final com.huawei.hms.scankit.aiscan.common.z b;
    private final com.huawei.hms.scankit.aiscan.common.z c;
    private final com.huawei.hms.scankit.aiscan.common.z d;
    private final com.huawei.hms.scankit.aiscan.common.z e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    public C0351ha(C0417y c0417y, com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2, com.huawei.hms.scankit.aiscan.common.z zVar3, com.huawei.hms.scankit.aiscan.common.z zVar4) throws C0309a {
        boolean z = zVar == null || zVar2 == null;
        boolean z2 = zVar3 == null || zVar4 == null;
        if (z && z2) {
            throw C0309a.a();
        }
        if (z) {
            zVar = new com.huawei.hms.scankit.aiscan.common.z(0.0f, zVar3.c());
            zVar2 = new com.huawei.hms.scankit.aiscan.common.z(0.0f, zVar4.c());
        } else if (z2) {
            zVar3 = new com.huawei.hms.scankit.aiscan.common.z(c0417y.d() - 1, zVar.c());
            zVar4 = new com.huawei.hms.scankit.aiscan.common.z(c0417y.d() - 1, zVar2.c());
        }
        this.a = c0417y;
        this.b = zVar;
        this.c = zVar2;
        this.d = zVar3;
        this.e = zVar4;
        this.f = (int) Math.min(zVar.b(), zVar2.b());
        this.g = (int) Math.max(zVar3.b(), zVar4.b());
        this.h = (int) Math.min(zVar.c(), zVar3.c());
        this.i = (int) Math.max(zVar2.c(), zVar4.c());
    }

    public static C0351ha a(C0351ha c0351ha, C0351ha c0351ha2) throws C0309a {
        return c0351ha == null ? c0351ha2 : c0351ha2 == null ? c0351ha : new C0351ha(c0351ha.a, c0351ha.b, c0351ha.c, c0351ha2.d, c0351ha2.e);
    }

    public com.huawei.hms.scankit.aiscan.common.z b() {
        return this.e;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.i;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.h;
    }

    public com.huawei.hms.scankit.aiscan.common.z g() {
        return this.b;
    }

    public com.huawei.hms.scankit.aiscan.common.z h() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.C0351ha a(int r13, int r14, boolean r15) throws com.huawei.hms.scankit.aiscan.common.C0309a {
        /*
            r12 = this;
            com.huawei.hms.scankit.aiscan.common.z r0 = r12.b
            com.huawei.hms.scankit.aiscan.common.z r1 = r12.c
            com.huawei.hms.scankit.aiscan.common.z r2 = r12.d
            com.huawei.hms.scankit.aiscan.common.z r3 = r12.e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.c()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            com.huawei.hms.scankit.aiscan.common.z r13 = new com.huawei.hms.scankit.aiscan.common.z
            float r4 = r4.b()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            com.huawei.hms.scankit.aiscan.common.z r13 = r12.c
            goto L34
        L32:
            com.huawei.hms.scankit.aiscan.common.z r13 = r12.e
        L34:
            float r0 = r13.c()
            int r0 = (int) r0
            int r0 = r0 + r14
            com.huawei.hms.scankit.p.y r14 = r12.a
            int r14 = r14.b()
            if (r0 < r14) goto L4a
            com.huawei.hms.scankit.p.y r14 = r12.a
            int r14 = r14.b()
            int r0 = r14 + (-1)
        L4a:
            com.huawei.hms.scankit.aiscan.common.z r14 = new com.huawei.hms.scankit.aiscan.common.z
            float r13 = r13.b()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            com.huawei.hms.scankit.p.ha r13 = new com.huawei.hms.scankit.p.ha
            com.huawei.hms.scankit.p.y r7 = r12.a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.C0351ha.a(int, int, boolean):com.huawei.hms.scankit.p.ha");
    }

    public com.huawei.hms.scankit.aiscan.common.z a() {
        return this.c;
    }

    public C0351ha(C0351ha c0351ha) {
        this.a = c0351ha.a;
        this.b = c0351ha.g();
        this.c = c0351ha.a();
        this.d = c0351ha.h();
        this.e = c0351ha.b();
        this.f = c0351ha.e();
        this.g = c0351ha.c();
        this.h = c0351ha.f();
        this.i = c0351ha.d();
    }
}
