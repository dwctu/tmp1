package com.huawei.hms.scankit;

/* compiled from: ScanAlgDecodeOption.java */
/* loaded from: classes3.dex */
public class E {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;

    public E(E e) {
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.a = e.a;
        this.b = e.b;
        this.c = e.c;
        this.d = e.d;
        this.e = e.e;
        this.g = e.g;
        this.f = e.f;
        this.h = e.h;
        this.i = e.i;
        this.j = e.j;
    }

    public E a(int i) {
        this.f = i;
        return this;
    }

    public E(int i, boolean z) {
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.a = 0;
        this.b = 0;
        this.c = i;
        this.d = false;
        this.e = z;
        this.g = true;
    }

    public E(int i, int i2, int i3) {
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = false;
        this.e = false;
        this.g = true;
    }

    public E(int i, int i2, int i3, boolean z, boolean z2) {
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.e = z2;
        this.g = true;
    }
}
