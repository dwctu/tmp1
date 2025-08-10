package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes5.dex */
public class DigestInputBuffer extends ByteArrayOutputStream {
    public void updateDigest(Digest digest) {
        digest.update(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }
}
