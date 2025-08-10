package com.broadcom.bt.util.mime4j.field.address;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class MailboxList {
    private ArrayList mailboxes;

    public MailboxList(ArrayList arrayList, boolean z) {
        if (arrayList != null) {
            this.mailboxes = z ? arrayList : (ArrayList) arrayList.clone();
        } else {
            this.mailboxes = new ArrayList(0);
        }
    }

    public Mailbox get(int i) {
        if (i < 0 || size() <= i) {
            throw new IndexOutOfBoundsException();
        }
        return (Mailbox) this.mailboxes.get(i);
    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i).toString());
        }
    }

    public int size() {
        return this.mailboxes.size();
    }
}
