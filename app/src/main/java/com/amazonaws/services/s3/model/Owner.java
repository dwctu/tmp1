package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Owner implements Serializable {
    private static final long serialVersionUID = -8916731456944569115L;
    private String displayName;
    private String id;

    public String a() {
        return this.displayName;
    }

    public String b() {
        return this.id;
    }

    public void c(String str) {
        this.displayName = str;
    }

    public void d(String str) {
        this.id = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) obj;
        String strB = owner.b();
        String strA = owner.a();
        String strB2 = b();
        String strA2 = a();
        if (strB == null) {
            strB = "";
        }
        if (strA == null) {
            strA = "";
        }
        if (strB2 == null) {
            strB2 = "";
        }
        if (strA2 == null) {
            strA2 = "";
        }
        return strB.equals(strB2) && strA.equals(strA2);
    }

    public int hashCode() {
        String str = this.id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "S3Owner [name=" + a() + ",id=" + b() + "]";
    }
}
