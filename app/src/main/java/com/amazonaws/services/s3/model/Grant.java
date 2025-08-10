package com.amazonaws.services.s3.model;

/* loaded from: classes.dex */
public class Grant {
    public Grantee a;
    public Permission b;

    public Grant(Grantee grantee, Permission permission) {
        this.a = null;
        this.b = null;
        this.a = grantee;
        this.b = permission;
    }

    public Grantee a() {
        return this.a;
    }

    public Permission b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Grant.class != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        Grantee grantee = this.a;
        if (grantee == null) {
            if (grant.a != null) {
                return false;
            }
        } else if (!grantee.equals(grant.a)) {
            return false;
        }
        return this.b == grant.b;
    }

    public int hashCode() {
        Grantee grantee = this.a;
        int iHashCode = ((grantee == null ? 0 : grantee.hashCode()) + 31) * 31;
        Permission permission = this.b;
        return iHashCode + (permission != null ? permission.hashCode() : 0);
    }

    public String toString() {
        return "Grant [grantee=" + this.a + ", permission=" + this.b + "]";
    }
}
