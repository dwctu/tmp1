package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.Signer;

/* loaded from: classes5.dex */
public class SignerInputBuffer extends ByteArrayOutputStream {
    public void updateSigner(Signer signer) {
        signer.update(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }
}
