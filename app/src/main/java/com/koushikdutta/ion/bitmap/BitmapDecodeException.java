package com.koushikdutta.ion.bitmap;

/* loaded from: classes3.dex */
public class BitmapDecodeException extends Exception {
    public final int height;
    public final int width;

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + " size=" + this.width + 'x' + this.height;
    }
}
