package org.jivesoftware.smackx.rsm;

import java.util.Collection;
import java.util.LinkedList;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smackx.rsm.packet.RSMSet;

/* loaded from: classes5.dex */
public class RSMManager {
    public Collection<ExtensionElement> continuePage(int i, Collection<ExtensionElement> collection) {
        return continuePage(i, collection, null);
    }

    public Collection<ExtensionElement> page(int i) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new RSMSet(i));
        return linkedList;
    }

    public Collection<ExtensionElement> continuePage(int i, Collection<ExtensionElement> collection, Collection<ExtensionElement> collection2) {
        if (collection == null) {
            throw new IllegalArgumentException("returnedExtensions must no be null");
        }
        if (collection2 == null) {
            collection2 = new LinkedList<>();
        }
        RSMSet rSMSet = (RSMSet) PacketUtil.extensionElementFrom(collection, RSMSet.ELEMENT, RSMSet.NAMESPACE);
        if (rSMSet == null) {
            throw new IllegalArgumentException("returnedExtensions did not contain a RSMset");
        }
        collection2.add(new RSMSet(i, rSMSet.getLast(), RSMSet.PageDirection.after));
        return collection2;
    }
}
