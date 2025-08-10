package org.jivesoftware.smackx.xhtmlim;

import java.util.List;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

/* loaded from: classes5.dex */
public class XHTMLManager {
    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.xhtmlim.XHTMLManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                XHTMLManager.setServiceEnabled(xMPPConnection, true);
            }
        });
    }

    public static void addBody(Message message, XHTMLText xHTMLText) {
        XHTMLExtension xHTMLExtensionFrom = XHTMLExtension.from(message);
        if (xHTMLExtensionFrom == null) {
            xHTMLExtensionFrom = new XHTMLExtension();
            message.addExtension(xHTMLExtensionFrom);
        }
        xHTMLExtensionFrom.addBody(xHTMLText.toXML());
    }

    public static List<CharSequence> getBodies(Message message) {
        XHTMLExtension xHTMLExtensionFrom = XHTMLExtension.from(message);
        if (xHTMLExtensionFrom != null) {
            return xHTMLExtensionFrom.getBodies();
        }
        return null;
    }

    public static boolean isServiceEnabled(XMPPConnection xMPPConnection) {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).includesFeature(XHTMLExtension.NAMESPACE);
    }

    public static boolean isXHTMLMessage(Message message) {
        return message.getExtension(XHTMLExtension.ELEMENT, XHTMLExtension.NAMESPACE) != null;
    }

    public static synchronized void setServiceEnabled(XMPPConnection xMPPConnection, boolean z) {
        if (isServiceEnabled(xMPPConnection) == z) {
            return;
        }
        if (z) {
            ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(XHTMLExtension.NAMESPACE);
        } else {
            ServiceDiscoveryManager.getInstanceFor(xMPPConnection).removeFeature(XHTMLExtension.NAMESPACE);
        }
    }

    public static boolean isServiceEnabled(XMPPConnection xMPPConnection, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).supportsFeature(str, XHTMLExtension.NAMESPACE);
    }
}
