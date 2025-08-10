package com.huawei.hms.scankit.p;

/* compiled from: QRCode.java */
/* loaded from: classes3.dex */
public final class Oc {
    private Va a;
    private Pa b;
    private Ya c;
    private int d = -1;
    private Ic e;

    public static boolean a(int i) {
        return i >= 0 && i < 8;
    }

    public Ic a() {
        return this.e;
    }

    public void b(int i) {
        this.d = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.c);
        sb.append("\n maskPattern: ");
        sb.append(this.d);
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(Va va) {
        this.a = va;
    }

    public void a(Pa pa) {
        this.b = pa;
    }

    public void a(Ya ya) {
        this.c = ya;
    }

    public void a(Ic ic) {
        this.e = ic;
    }
}
