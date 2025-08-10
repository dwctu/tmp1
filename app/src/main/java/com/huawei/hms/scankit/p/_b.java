package com.huawei.hms.scankit.p;

import androidx.core.view.InputDeviceCompat;

/* compiled from: Base256Encoder.java */
/* loaded from: classes3.dex */
public final class _b implements InterfaceC0341ec {
    public int a() {
        return 5;
    }

    @Override // com.huawei.hms.scankit.p.InterfaceC0341ec
    public void a(C0345fc c0345fc) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!c0345fc.h()) {
                break;
            }
            sb.append(c0345fc.c());
            c0345fc.f++;
            if (C0353hc.a(c0345fc.d(), c0345fc.f, a()) != a()) {
                c0345fc.b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA = c0345fc.a() + length + 1;
        c0345fc.c(iA);
        boolean z = c0345fc.g().a() - iA > 0;
        if (c0345fc.h() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Message length not in valid ranges: ");
                        sb2.append(length);
                        throw new IllegalStateException(sb2.toString());
                    } catch (Exception e) {
                        throw e;
                    }
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            c0345fc.a(a(sb.charAt(i), c0345fc.a() + 1));
        }
    }

    private static char a(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
