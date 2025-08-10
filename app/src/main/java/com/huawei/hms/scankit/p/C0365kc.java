package com.huawei.hms.scankit.p;

import org.slf4j.helpers.MessageFormatter;

/* compiled from: TextEncoder.java */
/* renamed from: com.huawei.hms.scankit.p.kc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0365kc extends C0325ac {
    @Override // com.huawei.hms.scankit.p.C0325ac
    public int a() {
        return 2;
    }

    @Override // com.huawei.hms.scankit.p.C0325ac
    public int a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        }
        if (c >= 'a' && c <= 'z') {
            sb.append((char) ((c - 'a') + 14));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        }
        if (c == '`') {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c - 'A') + 1));
            return 2;
        }
        if (c < '{' || c > 127) {
            sb.append("\u0001\u001e");
            return a((char) (c - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) ((c - MessageFormatter.DELIM_START) + 27));
        return 2;
    }
}
