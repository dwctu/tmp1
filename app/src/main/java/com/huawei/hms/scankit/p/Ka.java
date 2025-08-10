package com.huawei.hms.scankit.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DataMask.java */
/* loaded from: classes3.dex */
public abstract class Ka {
    public static final Ka a;
    public static final Ka b;
    public static final Ka c;
    public static final Ka d;
    public static final Ka e;
    public static final Ka f;
    public static final Ka g;
    public static final Ka h;
    private static final /* synthetic */ Ka[] i;

    static {
        Ca ca = new Ca("DATA_MASK_000", 0);
        a = ca;
        final String str = "DATA_MASK_001";
        final int i2 = 1;
        Ka ka = new Ka(str, i2) { // from class: com.huawei.hms.scankit.p.Da
            {
                Ca ca2 = null;
            }

            @Override // com.huawei.hms.scankit.p.Ka
            public boolean a(int i3, int i4) {
                return (i3 & 1) == 0;
            }
        };
        b = ka;
        final String str2 = "DATA_MASK_010";
        final int i3 = 2;
        Ka ka2 = new Ka(str2, i3) { // from class: com.huawei.hms.scankit.p.Ea
            {
                Ca ca2 = null;
            }

            @Override // com.huawei.hms.scankit.p.Ka
            public boolean a(int i4, int i5) {
                return i5 % 3 == 0;
            }
        };
        c = ka2;
        final String str3 = "DATA_MASK_011";
        final int i4 = 3;
        Ka ka3 = new Ka(str3, i4) { // from class: com.huawei.hms.scankit.p.Fa
            {
                Ca ca2 = null;
            }

            @Override // com.huawei.hms.scankit.p.Ka
            public boolean a(int i5, int i6) {
                return (i5 + i6) % 3 == 0;
            }
        };
        d = ka3;
        final String str4 = "DATA_MASK_100";
        final int i5 = 4;
        Ka ka4 = new Ka(str4, i5) { // from class: com.huawei.hms.scankit.p.Ga
            {
                Ca ca2 = null;
            }

            @Override // com.huawei.hms.scankit.p.Ka
            public boolean a(int i6, int i7) {
                return (((i6 / 2) + (i7 / 3)) & 1) == 0;
            }
        };
        e = ka4;
        final String str5 = "DATA_MASK_101";
        final int i6 = 5;
        Ka ka5 = new Ka(str5, i6) { // from class: com.huawei.hms.scankit.p.Ha
            {
                Ca ca2 = null;
            }

            @Override // com.huawei.hms.scankit.p.Ka
            public boolean a(int i7, int i8) {
                return (i7 * i8) % 6 == 0;
            }
        };
        f = ka5;
        final String str6 = "DATA_MASK_110";
        final int i7 = 6;
        Ka ka6 = new Ka(str6, i7) { // from class: com.huawei.hms.scankit.p.Ia
            {
                Ca ca2 = null;
            }

            @Override // com.huawei.hms.scankit.p.Ka
            public boolean a(int i8, int i9) {
                return (i8 * i9) % 6 < 3;
            }
        };
        g = ka6;
        final String str7 = "DATA_MASK_111";
        final int i8 = 7;
        Ka ka7 = new Ka(str7, i8) { // from class: com.huawei.hms.scankit.p.Ja
            {
                Ca ca2 = null;
            }

            @Override // com.huawei.hms.scankit.p.Ka
            public boolean a(int i9, int i10) {
                return (((i9 + i10) + ((i9 * i10) % 3)) & 1) == 0;
            }
        };
        h = ka7;
        i = new Ka[]{ca, ka, ka2, ka3, ka4, ka5, ka6, ka7};
    }

    private Ka(String str, int i2) {
    }

    public static Ka valueOf(String str) {
        return (Ka) Enum.valueOf(Ka.class, str);
    }

    public static Ka[] values() {
        return (Ka[]) i.clone();
    }

    public final void a(C0417y c0417y, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    c0417y.a(i4, i3);
                }
            }
        }
    }

    public abstract boolean a(int i2, int i3);

    public /* synthetic */ Ka(String str, int i2, Ca ca) {
        this(str, i2);
    }
}
