package net.sqlcipher;

/* loaded from: classes5.dex */
public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int i, int i2) {
        super("Index " + i + " requested, with a size of " + i2);
    }
}
