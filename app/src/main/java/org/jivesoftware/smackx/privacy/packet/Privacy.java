package org.jivesoftware.smackx.privacy.packet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class Privacy extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:privacy";
    private String activeName;
    private boolean declineActiveList;
    private boolean declineDefaultList;
    private String defaultName;
    private Map<String, List<PrivacyItem>> itemLists;

    public Privacy() {
        super("query", "jabber:iq:privacy");
        this.declineActiveList = false;
        this.declineDefaultList = false;
        this.itemLists = new HashMap();
    }

    public boolean changeDefaultList(String str) {
        if (!getItemLists().containsKey(str)) {
            return false;
        }
        setDefaultName(str);
        return true;
    }

    public void deleteList(String str) {
        getItemLists().remove(str);
    }

    public void deletePrivacyList(String str) {
        getItemLists().remove(str);
        if (getDefaultName() == null || !str.equals(getDefaultName())) {
            return;
        }
        setDefaultName(null);
    }

    public String getActiveName() {
        return this.activeName;
    }

    public List<PrivacyItem> getActivePrivacyList() {
        if (getActiveName() == null) {
            return null;
        }
        return getItemLists().get(getActiveName());
    }

    public String getDefaultName() {
        return this.defaultName;
    }

    public List<PrivacyItem> getDefaultPrivacyList() {
        if (getDefaultName() == null) {
            return null;
        }
        return getItemLists().get(getDefaultName());
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (isDeclineActiveList()) {
            iQChildElementXmlStringBuilder.append("<active/>");
        } else if (getActiveName() != null) {
            iQChildElementXmlStringBuilder.append("<active name=\"").escape(getActiveName()).append("\"/>");
        }
        if (isDeclineDefaultList()) {
            iQChildElementXmlStringBuilder.append("<default/>");
        } else if (getDefaultName() != null) {
            iQChildElementXmlStringBuilder.append("<default name=\"").escape(getDefaultName()).append("\"/>");
        }
        for (Map.Entry<String, List<PrivacyItem>> entry : getItemLists().entrySet()) {
            String key = entry.getKey();
            List<PrivacyItem> value = entry.getValue();
            if (value.isEmpty()) {
                iQChildElementXmlStringBuilder.append("<list name=\"").escape(key).append("\"/>");
            } else {
                iQChildElementXmlStringBuilder.append("<list name=\"").escape(key).append("\">");
            }
            Iterator<PrivacyItem> it = value.iterator();
            while (it.hasNext()) {
                iQChildElementXmlStringBuilder.append((CharSequence) it.next().toXML());
            }
            if (!value.isEmpty()) {
                iQChildElementXmlStringBuilder.append("</list>");
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public PrivacyItem getItem(String str, int i) {
        Iterator<PrivacyItem> it = getPrivacyList(str).iterator();
        PrivacyItem privacyItem = null;
        while (privacyItem == null && it.hasNext()) {
            PrivacyItem next = it.next();
            if (next.getOrder() == i) {
                privacyItem = next;
            }
        }
        return privacyItem;
    }

    public Map<String, List<PrivacyItem>> getItemLists() {
        return this.itemLists;
    }

    public List<PrivacyItem> getPrivacyList(String str) {
        return getItemLists().get(str);
    }

    public Set<String> getPrivacyListNames() {
        return this.itemLists.keySet();
    }

    public boolean isDeclineActiveList() {
        return this.declineActiveList;
    }

    public boolean isDeclineDefaultList() {
        return this.declineDefaultList;
    }

    public void setActiveName(String str) {
        this.activeName = str;
    }

    public List<PrivacyItem> setActivePrivacyList() {
        setActiveName(getDefaultName());
        return getItemLists().get(getActiveName());
    }

    public void setDeclineActiveList(boolean z) {
        this.declineActiveList = z;
    }

    public void setDeclineDefaultList(boolean z) {
        this.declineDefaultList = z;
    }

    public void setDefaultName(String str) {
        this.defaultName = str;
    }

    public List<PrivacyItem> setPrivacyList(String str, List<PrivacyItem> list) {
        getItemLists().put(str, list);
        return list;
    }
}
