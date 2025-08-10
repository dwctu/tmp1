package dc;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: CertificatePinner.java */
/* loaded from: classes5.dex */
public final class cc4 {
    public static final cc4 c = new a().a();
    public final Set<b> a;
    public final CertificateChainCleaner b;

    /* compiled from: CertificatePinner.java */
    public static final class a {
        public final List<b> a = new ArrayList();

        public cc4 a() {
            return new cc4(new LinkedHashSet(this.a), null);
        }
    }

    /* compiled from: CertificatePinner.java */
    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final qd4 d;

        public boolean a(String str) {
            if (!this.a.startsWith("*.")) {
                return str.equals(this.b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.b.length()) {
                String str2 = this.b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.a.equals(bVar.a) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.a.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return this.c + this.d.a();
        }
    }

    public cc4(Set<b> set, CertificateChainCleaner certificateChainCleaner) {
        this.a = set;
        this.b = certificateChainCleaner;
    }

    public static String c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + e((X509Certificate) certificate).a();
    }

    public static qd4 d(X509Certificate x509Certificate) {
        return qd4.m(x509Certificate.getPublicKey().getEncoded()).q();
    }

    public static qd4 e(X509Certificate x509Certificate) {
        return qd4.m(x509Certificate.getPublicKey().getEncoded()).r();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listB = b(str);
        if (listB.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.b;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.clean(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listB.size();
            qd4 qd4VarE = null;
            qd4 qd4VarD = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = listB.get(i2);
                if (bVar.c.equals("sha256/")) {
                    if (qd4VarE == null) {
                        qd4VarE = e(x509Certificate);
                    }
                    if (bVar.d.equals(qd4VarE)) {
                        return;
                    }
                } else {
                    if (!bVar.c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.c);
                    }
                    if (qd4VarD == null) {
                        qd4VarD = d(x509Certificate);
                    }
                    if (bVar.d.equals(qd4VarD)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(SignatureImpl.INNER_SEP);
        int size4 = listB.size();
        for (int i4 = 0; i4 < size4; i4++) {
            b bVar2 = listB.get(i4);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public List<b> b(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.a) {
            if (bVar.a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cc4) {
            cc4 cc4Var = (cc4) obj;
            if (Objects.equals(this.b, cc4Var.b) && this.a.equals(cc4Var.a)) {
                return true;
            }
        }
        return false;
    }

    public cc4 f(CertificateChainCleaner certificateChainCleaner) {
        return Objects.equals(this.b, certificateChainCleaner) ? this : new cc4(this.a, certificateChainCleaner);
    }

    public int hashCode() {
        return (Objects.hashCode(this.b) * 31) + this.a.hashCode();
    }
}
