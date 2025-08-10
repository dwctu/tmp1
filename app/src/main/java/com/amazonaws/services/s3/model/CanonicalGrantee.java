package com.amazonaws.services.s3.model;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.Serializable;

/* loaded from: classes.dex */
public class CanonicalGrantee implements Grantee, Serializable {
    private String id = null;
    private String displayName = null;

    public CanonicalGrantee(String str) {
        setIdentifier(str);
    }

    public void a(String str) {
        this.displayName = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CanonicalGrantee) {
            return this.id.equals(((CanonicalGrantee) obj).id);
        }
        return false;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getIdentifier() {
        return this.id;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getTypeIdentifier() {
        return TtmlNode.ATTR_ID;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public void setIdentifier(String str) {
        this.id = str;
    }
}
