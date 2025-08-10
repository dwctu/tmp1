package org.jivesoftware.smack.roster.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class RosterPacket extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:roster";
    private final List<Item> rosterItems;
    private String rosterVersion;

    public static class Item {
        public static final String GROUP = "group";
        private String name;
        private String user;
        private ItemType itemType = null;
        private ItemStatus itemStatus = null;
        private final Set<String> groupNames = new CopyOnWriteArraySet();

        public Item(String str, String str2) {
            this.user = str.toLowerCase(Locale.US);
            this.name = str2;
        }

        public void addGroupName(String str) {
            this.groupNames.add(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Item item = (Item) obj;
            Set<String> set = this.groupNames;
            if (set == null) {
                if (item.groupNames != null) {
                    return false;
                }
            } else if (!set.equals(item.groupNames)) {
                return false;
            }
            if (this.itemStatus != item.itemStatus || this.itemType != item.itemType) {
                return false;
            }
            String str = this.name;
            if (str == null) {
                if (item.name != null) {
                    return false;
                }
            } else if (!str.equals(item.name)) {
                return false;
            }
            String str2 = this.user;
            if (str2 == null) {
                if (item.user != null) {
                    return false;
                }
            } else if (!str2.equals(item.user)) {
                return false;
            }
            return true;
        }

        public Set<String> getGroupNames() {
            return Collections.unmodifiableSet(this.groupNames);
        }

        public ItemStatus getItemStatus() {
            return this.itemStatus;
        }

        public ItemType getItemType() {
            return this.itemType;
        }

        public String getName() {
            return this.name;
        }

        public String getUser() {
            return this.user;
        }

        public int hashCode() {
            Set<String> set = this.groupNames;
            int iHashCode = ((set == null ? 0 : set.hashCode()) + 31) * 31;
            ItemStatus itemStatus = this.itemStatus;
            int iHashCode2 = (iHashCode + (itemStatus == null ? 0 : itemStatus.hashCode())) * 31;
            ItemType itemType = this.itemType;
            int iHashCode3 = (iHashCode2 + (itemType == null ? 0 : itemType.hashCode())) * 31;
            String str = this.name;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.user;
            return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public void removeGroupName(String str) {
            this.groupNames.remove(str);
        }

        public void setItemStatus(ItemStatus itemStatus) {
            this.itemStatus = itemStatus;
        }

        public void setItemType(ItemType itemType) {
            this.itemType = itemType;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setUser(String str) {
            this.user = str;
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("item").attribute(PSOProgramService.JobID_Key, this.user);
            xmlStringBuilder.optAttribute("name", this.name);
            xmlStringBuilder.optAttribute("subscription", this.itemType);
            xmlStringBuilder.optAttribute("ask", this.itemStatus);
            xmlStringBuilder.rightAngleBracket();
            Iterator<String> it = this.groupNames.iterator();
            while (it.hasNext()) {
                xmlStringBuilder.openElement("group").escape(it.next()).closeElement("group");
            }
            xmlStringBuilder.closeElement("item");
            return xmlStringBuilder;
        }
    }

    public enum ItemStatus {
        subscribe,
        unsubscribe;

        public static final ItemStatus SUBSCRIPTION_PENDING;
        public static final ItemStatus UNSUBSCRIPTION_PENDING;

        static {
            ItemStatus itemStatus = subscribe;
            ItemStatus itemStatus2 = unsubscribe;
            SUBSCRIPTION_PENDING = itemStatus;
            UNSUBSCRIPTION_PENDING = itemStatus2;
        }

        public static ItemStatus fromString(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public enum ItemType {
        none,
        to,
        from,
        both,
        remove
    }

    public RosterPacket() {
        super("query", NAMESPACE);
        this.rosterItems = new ArrayList();
    }

    public void addRosterItem(Item item) {
        synchronized (this.rosterItems) {
            this.rosterItems.add(item);
        }
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute(RosterVer.ELEMENT, this.rosterVersion);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        synchronized (this.rosterItems) {
            Iterator<Item> it = this.rosterItems.iterator();
            while (it.hasNext()) {
                iQChildElementXmlStringBuilder.append(it.next().toXML());
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public int getRosterItemCount() {
        int size;
        synchronized (this.rosterItems) {
            size = this.rosterItems.size();
        }
        return size;
    }

    public List<Item> getRosterItems() {
        ArrayList arrayList;
        synchronized (this.rosterItems) {
            arrayList = new ArrayList(this.rosterItems);
        }
        return arrayList;
    }

    public String getVersion() {
        return this.rosterVersion;
    }

    public void setVersion(String str) {
        this.rosterVersion = str;
    }
}
