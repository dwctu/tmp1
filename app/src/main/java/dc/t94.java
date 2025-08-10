package dc;

/* compiled from: AesKeyStrength.java */
/* loaded from: classes5.dex */
public enum t94 {
    KEY_STRENGTH_128(1, 8, 16, 16),
    KEY_STRENGTH_192(2, 12, 24, 24),
    KEY_STRENGTH_256(3, 16, 32, 32);

    private int keyLength;
    private int macLength;
    private int rawCode;
    private int saltLength;

    t94(int i, int i2, int i3, int i4) {
        this.rawCode = i;
        this.saltLength = i2;
        this.macLength = i3;
        this.keyLength = i4;
    }

    public static t94 getAesKeyStrengthFromRawCode(int i) {
        for (t94 t94Var : values()) {
            if (t94Var.getRawCode() == i) {
                return t94Var;
            }
        }
        return null;
    }

    public int getKeyLength() {
        return this.keyLength;
    }

    public int getMacLength() {
        return this.macLength;
    }

    public int getRawCode() {
        return this.rawCode;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
