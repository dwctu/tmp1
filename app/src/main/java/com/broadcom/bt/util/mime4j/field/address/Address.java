package com.broadcom.bt.util.mime4j.field.address;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class Address {
    public final void addMailboxesTo(ArrayList arrayList) {
        doAddMailboxesTo(arrayList);
    }

    public abstract void doAddMailboxesTo(ArrayList arrayList);
}
