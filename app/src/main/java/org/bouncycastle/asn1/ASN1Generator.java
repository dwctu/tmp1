package org.bouncycastle.asn1;

import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class ASN1Generator {
    public OutputStream _out;

    public ASN1Generator(OutputStream outputStream) {
        this._out = outputStream;
    }

    public abstract OutputStream getRawOutputStream();
}
