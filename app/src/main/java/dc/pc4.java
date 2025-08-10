package dc;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: Handshake.java */
/* loaded from: classes5.dex */
public final class pc4 {
    public final dd4 a;
    public final ec4 b;
    public final List<Certificate> c;
    public final List<Certificate> d;

    public pc4(dd4 dd4Var, ec4 ec4Var, List<Certificate> list, List<Certificate> list2) {
        this.a = dd4Var;
        this.b = ec4Var;
        this.c = list;
        this.d = list2;
    }

    public static pc4 b(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        ec4 ec4VarA = ec4.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        dd4 dd4VarForJavaName = dd4.forJavaName(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listImmutableList = peerCertificates != null ? Util.immutableList(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new pc4(dd4VarForJavaName, ec4VarA, listImmutableList, localCertificates != null ? Util.immutableList(localCertificates) : Collections.emptyList());
    }

    public static pc4 c(dd4 dd4Var, ec4 ec4Var, List<Certificate> list, List<Certificate> list2) {
        Objects.requireNonNull(dd4Var, "tlsVersion == null");
        Objects.requireNonNull(ec4Var, "cipherSuite == null");
        return new pc4(dd4Var, ec4Var, Util.immutableList(list), Util.immutableList(list2));
    }

    public ec4 a() {
        return this.b;
    }

    public List<Certificate> d() {
        return this.d;
    }

    public final List<String> e(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pc4)) {
            return false;
        }
        pc4 pc4Var = (pc4) obj;
        return this.a.equals(pc4Var.a) && this.b.equals(pc4Var.b) && this.c.equals(pc4Var.c) && this.d.equals(pc4Var.d);
    }

    public List<Certificate> f() {
        return this.c;
    }

    public dd4 g() {
        return this.a;
    }

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.a + " cipherSuite=" + this.b + " peerCertificates=" + e(this.c) + " localCertificates=" + e(this.d) + MessageFormatter.DELIM_STOP;
    }
}
