package org.jivesoftware.smackx.xdatalayout;

import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* loaded from: classes5.dex */
public class XDataLayoutManager {
    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.xdatalayout.XDataLayoutManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(DataLayout.NAMESPACE);
            }
        });
    }
}
