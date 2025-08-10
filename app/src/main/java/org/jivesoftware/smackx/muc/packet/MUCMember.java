package org.jivesoftware.smackx.muc.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class MUCMember extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://www.jivesoftware.org/protocol/room#members";
    private final List<MUCItem> items;
    private String room;

    public MUCMember() {
        super("query", NAMESPACE);
        this.items = new ArrayList();
    }

    public void addItem(MUCItem mUCItem) {
        synchronized (this.items) {
            this.items.add(mUCItem);
        }
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.element("room", getRoom());
        return iQChildElementXmlStringBuilder;
    }

    public List<MUCItem> getItems() {
        List<MUCItem> listUnmodifiableList;
        synchronized (this.items) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.items));
        }
        return listUnmodifiableList;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String str) {
        this.room = str;
    }
}
