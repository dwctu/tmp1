package com.wear.network.protocol.cookie.cache;

import dc.ic4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public class IdentifiableCookie {
    private ic4 cookie;

    public IdentifiableCookie(ic4 ic4Var) {
        this.cookie = ic4Var;
    }

    public static List<IdentifiableCookie> decorateAll(Collection<ic4> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (ic4 ic4Var : collection) {
            if (ic4Var != null) {
                arrayList.add(new IdentifiableCookie(ic4Var));
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        return identifiableCookie.cookie.h().equals(this.cookie.h()) && identifiableCookie.cookie.b().equals(this.cookie.b()) && identifiableCookie.cookie.o().equals(this.cookie.o()) && identifiableCookie.cookie.r() == this.cookie.r() && identifiableCookie.cookie.e() == this.cookie.e();
    }

    public ic4 getCookie() {
        return this.cookie;
    }

    public int hashCode() {
        return ((((((((527 + this.cookie.h().hashCode()) * 31) + this.cookie.b().hashCode()) * 31) + this.cookie.o().hashCode()) * 31) + (!this.cookie.r() ? 1 : 0)) * 31) + (!this.cookie.e() ? 1 : 0);
    }
}
