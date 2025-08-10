package org.jivesoftware.smackx.offline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.offline.packet.OfflineMessageInfo;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;
import org.jivesoftware.smackx.xdata.Form;

/* loaded from: classes5.dex */
public class OfflineMessageManager {
    private static final StanzaFilter PACKET_FILTER = new AndFilter(new StanzaExtensionFilter(new OfflineMessageInfo()), StanzaTypeFilter.MESSAGE);
    private static final String namespace = "http://jabber.org/protocol/offline";
    private final XMPPConnection connection;

    public OfflineMessageManager(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
    }

    public void deleteMessages(List<String> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            OfflineMessageRequest.Item item = new OfflineMessageRequest.Item(it.next());
            item.setAction(DiscoverItems.Item.REMOVE_ACTION);
            offlineMessageRequest.addItem(item);
        }
        this.connection.createPacketCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
    }

    public List<OfflineMessageHeader> getHeaders() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        ArrayList arrayList = new ArrayList();
        Iterator<DiscoverItems.Item> it = ServiceDiscoveryManager.getInstanceFor(this.connection).discoverItems(null, "http://jabber.org/protocol/offline").getItems().iterator();
        while (it.hasNext()) {
            arrayList.add(new OfflineMessageHeader(it.next()));
        }
        return arrayList;
    }

    public int getMessageCount() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Form formFrom = Form.getFormFrom(ServiceDiscoveryManager.getInstanceFor(this.connection).discoverInfo(null, "http://jabber.org/protocol/offline"));
        if (formFrom != null) {
            return Integer.parseInt(formFrom.getField("number_of_messages").getValues().get(0));
        }
        return 0;
    }

    public List<Message> getMessages(final List<String> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        ArrayList arrayList = new ArrayList();
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            OfflineMessageRequest.Item item = new OfflineMessageRequest.Item(it.next());
            item.setAction("view");
            offlineMessageRequest.addItem(item);
        }
        PacketCollector packetCollectorCreatePacketCollector = this.connection.createPacketCollector(new AndFilter(PACKET_FILTER, new StanzaFilter() { // from class: org.jivesoftware.smackx.offline.OfflineMessageManager.1
            @Override // org.jivesoftware.smack.filter.StanzaFilter
            public boolean accept(Stanza stanza) {
                return list.contains(((OfflineMessageInfo) stanza.getExtension(OfflineMessageRequest.ELEMENT, "http://jabber.org/protocol/offline")).getNode());
            }
        }));
        try {
            this.connection.createPacketCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
            for (Message message = (Message) packetCollectorCreatePacketCollector.nextResult(); message != null; message = (Message) packetCollectorCreatePacketCollector.nextResult()) {
                arrayList.add(message);
            }
            return arrayList;
        } finally {
            packetCollectorCreatePacketCollector.cancel();
        }
    }

    public boolean supportsFlexibleRetrieval() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(this.connection).serverSupportsFeature("http://jabber.org/protocol/offline");
    }

    public void deleteMessages() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        offlineMessageRequest.setPurge(true);
        this.connection.createPacketCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
    }

    public List<Message> getMessages() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        offlineMessageRequest.setFetch(true);
        PacketCollector packetCollectorCreatePacketCollectorAndSend = this.connection.createPacketCollectorAndSend(offlineMessageRequest);
        PacketCollector packetCollectorCreatePacketCollector = this.connection.createPacketCollector(PacketCollector.newConfiguration().setStanzaFilter(PACKET_FILTER).setCollectorToReset(packetCollectorCreatePacketCollectorAndSend));
        try {
            packetCollectorCreatePacketCollectorAndSend.nextResultOrThrow();
            packetCollectorCreatePacketCollector.cancel();
            ArrayList arrayList = new ArrayList(packetCollectorCreatePacketCollector.getCollectedCount());
            while (true) {
                Message message = (Message) packetCollectorCreatePacketCollector.pollResult();
                if (message == null) {
                    return arrayList;
                }
                arrayList.add(message);
            }
        } finally {
            packetCollectorCreatePacketCollector.cancel();
        }
    }
}
