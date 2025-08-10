package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public class EmailAddressGrantee implements Grantee {
    public String a = null;

    public EmailAddressGrantee(String str) {
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EmailAddressGrantee.class != obj.getClass()) {
            return false;
        }
        EmailAddressGrantee emailAddressGrantee = (EmailAddressGrantee) obj;
        String str = this.a;
        if (str == null) {
            if (emailAddressGrantee.a != null) {
                return false;
            }
        } else if (!str.equals(emailAddressGrantee.a)) {
            return false;
        }
        return true;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getIdentifier() {
        return this.a;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getTypeIdentifier() {
        return "emailAddress";
    }

    public int hashCode() {
        String str = this.a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public void setIdentifier(String str) {
        this.a = str;
    }

    public String toString() {
        return this.a;
    }
}
