package com.broadcom.bt.util.mime4j.field.address;

/* loaded from: classes.dex */
public class NamedMailbox extends Mailbox {
    private String name;

    public NamedMailbox(String str, String str2, String str3) {
        super(str2, str3);
        this.name = str;
    }

    @Override // com.broadcom.bt.util.mime4j.field.address.Mailbox
    public String getAddressString(boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.name == null) {
            str = "";
        } else {
            str = this.name + " ";
        }
        sb.append(str);
        sb.append(super.getAddressString(z));
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public NamedMailbox(String str, DomainList domainList, String str2, String str3) {
        super(domainList, str2, str3);
        this.name = str;
    }

    public NamedMailbox(String str, Mailbox mailbox) {
        super(mailbox.getRoute(), mailbox.getLocalPart(), mailbox.getDomain());
        this.name = str;
    }
}
