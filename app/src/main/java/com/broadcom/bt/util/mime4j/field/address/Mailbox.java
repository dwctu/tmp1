package com.broadcom.bt.util.mime4j.field.address;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class Mailbox extends Address {
    private String domain;
    private String localPart;
    private DomainList route;

    public Mailbox(String str, String str2) {
        this(null, str, str2);
    }

    @Override // com.broadcom.bt.util.mime4j.field.address.Address
    public final void doAddMailboxesTo(ArrayList arrayList) {
        arrayList.add(this);
    }

    public String getAddressString() {
        return getAddressString(false);
    }

    public String getDomain() {
        return this.domain;
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public DomainList getRoute() {
        return this.route;
    }

    public String toString() {
        return getAddressString();
    }

    public Mailbox(DomainList domainList, String str, String str2) {
        this.route = domainList;
        this.localPart = str;
        this.domain = str2;
    }

    public String getAddressString(boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        if (!z || this.route == null) {
            str = "";
        } else {
            str = this.route.toRouteString() + SignatureImpl.INNER_SEP;
        }
        sb.append(str);
        sb.append(this.localPart);
        sb.append(this.domain != null ? "@" : "");
        sb.append(this.domain);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }
}
