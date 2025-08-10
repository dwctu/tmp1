package org.jivesoftware.smackx.xdata;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

/* loaded from: classes5.dex */
public class XDataManager extends Manager {
    private static final Map<XMPPConnection, XDataManager> INSTANCES;
    public static final String NAMESPACE = "jabber:x:data";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.xdata.XDataManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                XDataManager.getInstanceFor(xMPPConnection);
            }
        });
        INSTANCES = new WeakHashMap();
    }

    private XDataManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("jabber:x:data");
    }

    public static synchronized XDataManager getInstanceFor(XMPPConnection xMPPConnection) {
        XDataManager xDataManager;
        Map<XMPPConnection, XDataManager> map = INSTANCES;
        xDataManager = map.get(xMPPConnection);
        if (xDataManager == null) {
            xDataManager = new XDataManager(xMPPConnection);
            map.put(xMPPConnection, xDataManager);
        }
        return xDataManager;
    }

    public boolean isSupported(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(str, "jabber:x:data");
    }
}
