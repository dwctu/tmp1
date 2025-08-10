package org.jivesoftware.smackx.offline.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class OfflineMessageRequest extends IQ {
    public static final String ELEMENT = "offline";
    public static final String NAMESPACE = "http://jabber.org/protocol/offline";
    private boolean fetch;
    private List<Item> items;
    private boolean purge;

    public static class Item {
        private String action;
        private String jid;
        private String node;

        public Item(String str) {
            this.node = str;
        }

        public String getAction() {
            return this.action;
        }

        public String getJid() {
            return this.jid;
        }

        public String getNode() {
            return this.node;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public String toXML() {
            StringBuilder sb = new StringBuilder();
            sb.append("<item");
            if (getAction() != null) {
                sb.append(" action=\"");
                sb.append(getAction());
                sb.append("\"");
            }
            if (getJid() != null) {
                sb.append(" jid=\"");
                sb.append(getJid());
                sb.append("\"");
            }
            if (getNode() != null) {
                sb.append(" node=\"");
                sb.append(getNode());
                sb.append("\"");
            }
            sb.append("/>");
            return sb.toString();
        }
    }

    public static class Provider extends IQProvider<OfflineMessageRequest> {
        private Item parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            Item item = new Item(xmlPullParser.getAttributeValue("", "node"));
            item.setAction(xmlPullParser.getAttributeValue("", AMPExtension.Action.ATTRIBUTE_NAME));
            item.setJid(xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key));
            boolean z = false;
            while (!z) {
                if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("item")) {
                    z = true;
                }
            }
            return item;
        }

        @Override // org.jivesoftware.smack.provider.Provider
        public OfflineMessageRequest parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
            OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
            boolean z = false;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        offlineMessageRequest.addItem(parseItem(xmlPullParser));
                    } else if (xmlPullParser.getName().equals("purge")) {
                        offlineMessageRequest.setPurge(true);
                    } else if (xmlPullParser.getName().equals(RemoteConfigComponent.FETCH_FILE_NAME)) {
                        offlineMessageRequest.setFetch(true);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(OfflineMessageRequest.ELEMENT)) {
                    z = true;
                }
            }
            return offlineMessageRequest;
        }
    }

    public OfflineMessageRequest() {
        super(ELEMENT, NAMESPACE);
        this.items = new ArrayList();
        this.purge = false;
        this.fetch = false;
    }

    public void addItem(Item item) {
        synchronized (this.items) {
            this.items.add(item);
        }
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        synchronized (this.items) {
            for (int i = 0; i < this.items.size(); i++) {
                iQChildElementXmlStringBuilder.append((CharSequence) this.items.get(i).toXML());
            }
        }
        if (this.purge) {
            iQChildElementXmlStringBuilder.append("<purge/>");
        }
        if (this.fetch) {
            iQChildElementXmlStringBuilder.append("<fetch/>");
        }
        return iQChildElementXmlStringBuilder;
    }

    public List<Item> getItems() {
        List<Item> listUnmodifiableList;
        synchronized (this.items) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.items));
        }
        return listUnmodifiableList;
    }

    public boolean isFetch() {
        return this.fetch;
    }

    public boolean isPurge() {
        return this.purge;
    }

    public void setFetch(boolean z) {
        this.fetch = z;
    }

    public void setPurge(boolean z) {
        this.purge = z;
    }
}
