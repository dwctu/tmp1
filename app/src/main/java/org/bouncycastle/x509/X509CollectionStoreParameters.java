package org.bouncycastle.x509;

import com.broadcom.bt.util.io.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes5.dex */
public class X509CollectionStoreParameters implements X509StoreParameters {
    private Collection collection;

    public X509CollectionStoreParameters(Collection collection) {
        Objects.requireNonNull(collection, "collection cannot be null");
        this.collection = collection;
    }

    public Object clone() {
        return new X509CollectionStoreParameters(this.collection);
    }

    public Collection getCollection() {
        return new ArrayList(this.collection);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X509CollectionStoreParameters: [\n");
        stringBuffer.append("  collection: " + this.collection + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
