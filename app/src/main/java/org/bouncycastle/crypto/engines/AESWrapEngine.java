package org.bouncycastle.crypto.engines;

/* loaded from: classes5.dex */
public class AESWrapEngine extends RFC3394WrapEngine {
    public AESWrapEngine() {
        super(new AESEngine());
    }
}
