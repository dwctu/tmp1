package dc;

import net.lingala.zip4j.exception.ZipException;

/* compiled from: AesVersion.java */
/* loaded from: classes5.dex */
public enum u94 {
    ONE(1),
    TWO(2);

    private int versionNumber;

    u94(int i) {
        this.versionNumber = i;
    }

    public static u94 getFromVersionNumber(int i) throws ZipException {
        for (u94 u94Var : values()) {
            if (u94Var.versionNumber == i) {
                return u94Var;
            }
        }
        throw new ZipException("Unsupported Aes version");
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }
}
