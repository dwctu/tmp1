package com.broadcom.bt.util.mime4j.field.address;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class DomainList {
    private ArrayList domains;

    public DomainList(ArrayList arrayList, boolean z) {
        if (arrayList != null) {
            this.domains = z ? arrayList : (ArrayList) arrayList.clone();
        } else {
            this.domains = new ArrayList(0);
        }
    }

    public String get(int i) {
        if (i < 0 || size() <= i) {
            throw new IndexOutOfBoundsException();
        }
        return (String) this.domains.get(i);
    }

    public int size() {
        return this.domains.size();
    }

    public String toRouteString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < this.domains.size()) {
            stringBuffer.append("@");
            stringBuffer.append(get(i));
            i++;
            if (i < this.domains.size()) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }
}
