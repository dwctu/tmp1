package org.jivesoftware.smackx.offline.packet;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class OfflineMessageInfo implements ExtensionElement {
    private String node = null;

    public static class Provider extends ExtensionElementProvider<OfflineMessageInfo> {
        @Override // org.jivesoftware.smack.provider.Provider
        public OfflineMessageInfo parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
            OfflineMessageInfo offlineMessageInfo = new OfflineMessageInfo();
            boolean z = false;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        offlineMessageInfo.setNode(xmlPullParser.getAttributeValue("", "node"));
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(OfflineMessageRequest.ELEMENT)) {
                    z = true;
                }
            }
            return offlineMessageInfo;
        }
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return OfflineMessageRequest.ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return OfflineMessageRequest.NAMESPACE;
    }

    public String getNode() {
        return this.node;
    }

    public void setNode(String str) {
        this.node = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getElementName());
        sb.append(" xmlns=\"");
        sb.append(getNamespace());
        sb.append("\">");
        if (getNode() != null) {
            sb.append("<item node=\"");
            sb.append(getNode());
            sb.append("\"/>");
        }
        sb.append("</");
        sb.append(getElementName());
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }
}
