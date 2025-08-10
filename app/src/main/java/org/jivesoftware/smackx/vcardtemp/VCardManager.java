package org.jivesoftware.smackx.vcardtemp;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.id.StanzaIdUtil;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* loaded from: classes5.dex */
public class VCardManager extends Manager {
    public static final String ELEMENT = "vCard";
    private static final Map<XMPPConnection, VCardManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "vcard-temp";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.vcardtemp.VCardManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                VCardManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private VCardManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("vcard-temp");
    }

    public static synchronized VCardManager getInstanceFor(XMPPConnection xMPPConnection) {
        VCardManager vCardManager;
        Map<XMPPConnection, VCardManager> map = INSTANCES;
        vCardManager = map.get(xMPPConnection);
        if (vCardManager == null) {
            vCardManager = new VCardManager(xMPPConnection);
            map.put(xMPPConnection, vCardManager);
        }
        return vCardManager;
    }

    @Deprecated
    public static boolean isSupported(String str, XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getInstanceFor(xMPPConnection).isSupported(str);
    }

    public VCard loadVCard() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return loadVCard(null);
    }

    public void saveVCard(VCard vCard) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        vCard.setTo(null);
        vCard.setType(IQ.Type.set);
        vCard.setStanzaId(StanzaIdUtil.newStanzaId());
        connection().createPacketCollectorAndSend(vCard).nextResultOrThrow();
    }

    public boolean isSupported(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(str, "vcard-temp");
    }

    public VCard loadVCard(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        VCard vCard = new VCard();
        vCard.setTo(str);
        return (VCard) connection().createPacketCollectorAndSend(vCard).nextResultOrThrow();
    }
}
