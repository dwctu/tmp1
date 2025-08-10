package dc;

import net.lingala.zip4j.exception.ZipException;

/* compiled from: CompressionMethod.java */
/* loaded from: classes5.dex */
public enum v94 {
    STORE(0),
    DEFLATE(8),
    AES_INTERNAL_ONLY(99);

    private int code;

    v94(int i) {
        this.code = i;
    }

    public static v94 getCompressionMethodFromCode(int i) throws ZipException {
        for (v94 v94Var : values()) {
            if (v94Var.getCode() == i) {
                return v94Var;
            }
        }
        throw new ZipException("Unknown compression method", ZipException.a.UNKNOWN_COMPRESSION_METHOD);
    }

    public int getCode() {
        return this.code;
    }
}
