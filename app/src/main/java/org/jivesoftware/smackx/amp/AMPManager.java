package org.jivesoftware.smackx.amp;

import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

/* loaded from: classes5.dex */
public class AMPManager {
    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.amp.AMPManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                AMPManager.setServiceEnabled(xMPPConnection, true);
            }
        });
    }

    public static boolean isActionSupported(XMPPConnection xMPPConnection, AMPExtension.Action action) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return isFeatureSupportedByServer(xMPPConnection, "http://jabber.org/protocol/amp?action=" + action.toString(), AMPExtension.NAMESPACE);
    }

    public static boolean isConditionSupported(XMPPConnection xMPPConnection, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return isFeatureSupportedByServer(xMPPConnection, "http://jabber.org/protocol/amp?condition=" + str, AMPExtension.NAMESPACE);
    }

    private static boolean isFeatureSupportedByServer(XMPPConnection xMPPConnection, String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).supportsFeature(str2, str);
    }

    public static boolean isServiceEnabled(XMPPConnection xMPPConnection) {
        xMPPConnection.getServiceName();
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).includesFeature(AMPExtension.NAMESPACE);
    }

    public static synchronized void setServiceEnabled(XMPPConnection xMPPConnection, boolean z) {
        if (isServiceEnabled(xMPPConnection) == z) {
            return;
        }
        if (z) {
            ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(AMPExtension.NAMESPACE);
        } else {
            ServiceDiscoveryManager.getInstanceFor(xMPPConnection).removeFeature(AMPExtension.NAMESPACE);
        }
    }
}
