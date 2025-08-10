package com.koushikdutta.async;

import java.security.PrivateKey;
import java.security.cert.Certificate;

/* loaded from: classes3.dex */
public interface AsyncSSLServerSocket extends AsyncServerSocket {
    Certificate getCertificate();

    PrivateKey getPrivateKey();
}
