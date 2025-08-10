package com.broadcom.bt.util.mime4j.field.address;

import java.util.ArrayList;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class Group extends Address {
    private MailboxList mailboxList;
    private String name;

    public Group(String str, MailboxList mailboxList) {
        this.name = str;
        this.mailboxList = mailboxList;
    }

    @Override // com.broadcom.bt.util.mime4j.field.address.Address
    public void doAddMailboxesTo(ArrayList arrayList) {
        for (int i = 0; i < this.mailboxList.size(); i++) {
            arrayList.add(this.mailboxList.get(i));
        }
    }

    public MailboxList getMailboxes() {
        return this.mailboxList;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(SignatureImpl.INNER_SEP);
        int i = 0;
        while (i < this.mailboxList.size()) {
            stringBuffer.append(this.mailboxList.get(i).toString());
            i++;
            if (i < this.mailboxList.size()) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(";");
        return stringBuffer.toString();
    }
}
