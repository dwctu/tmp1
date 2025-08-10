package org.jivesoftware.smackx.pubsub;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.EmptyResultIQ;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jivesoftware.smackx.pubsub.util.NodeUtils;

/* loaded from: classes5.dex */
public final class PubSubManager {
    private XMPPConnection con;
    private Map<String, Node> nodeMap = new ConcurrentHashMap();
    private String to;

    public PubSubManager(XMPPConnection xMPPConnection) {
        this.con = xMPPConnection;
        this.to = "pubsub." + xMPPConnection.getServiceName();
    }

    private PubSub sendPubsubPacket(IQ.Type type, ExtensionElement extensionElement, PubSubNamespace pubSubNamespace) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return sendPubsubPacket(this.con, this.to, type, Collections.singletonList(extensionElement), pubSubNamespace);
    }

    public LeafNode createNode() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        LeafNode leafNode = new LeafNode(this.con, ((NodeExtension) sendPubsubPacket(IQ.Type.set, new NodeExtension(PubSubElementType.CREATE), null).getExtension("create", PubSubNamespace.BASIC.getXmlns())).getNode());
        leafNode.setTo(this.to);
        this.nodeMap.put(leafNode.getId(), leafNode);
        return leafNode;
    }

    public void deleteNode(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        IQ.Type type = IQ.Type.set;
        PubSubElementType pubSubElementType = PubSubElementType.DELETE;
        sendPubsubPacket(type, new NodeExtension(pubSubElementType, str), pubSubElementType.getNamespace());
        this.nodeMap.remove(str);
    }

    public DiscoverItems discoverNodes(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        DiscoverItems discoverItems = new DiscoverItems();
        if (str != null) {
            discoverItems.setNode(str);
        }
        discoverItems.setTo(this.to);
        return (DiscoverItems) this.con.createPacketCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public List<Affiliation> getAffiliations() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        IQ.Type type = IQ.Type.get;
        PubSubElementType pubSubElementType = PubSubElementType.AFFILIATIONS;
        return ((AffiliationsExtension) sendPubsubPacket(type, new NodeExtension(pubSubElementType), null).getExtension(pubSubElementType)).getAffiliations();
    }

    public ConfigureForm getDefaultConfiguration() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        IQ.Type type = IQ.Type.get;
        PubSubElementType pubSubElementType = PubSubElementType.DEFAULT;
        return NodeUtils.getFormFromPacket(sendPubsubPacket(type, new NodeExtension(pubSubElementType), pubSubElementType.getNamespace()), pubSubElementType);
    }

    public <T extends Node> T getNode(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        T collectionNode = (T) this.nodeMap.get(str);
        if (collectionNode == null) {
            DiscoverInfo discoverInfo = new DiscoverInfo();
            discoverInfo.setTo(this.to);
            discoverInfo.setNode(str);
            DiscoverInfo discoverInfo2 = (DiscoverInfo) this.con.createPacketCollectorAndSend(discoverInfo).nextResultOrThrow();
            if (discoverInfo2.hasIdentity("pubsub", "leaf")) {
                collectionNode = new LeafNode(this.con, str);
            } else {
                if (!discoverInfo2.hasIdentity("pubsub", "collection")) {
                    throw new AssertionError("PubSub service '" + this.to + "' returned disco info result for node '" + str + "', but it did not contain an Identity of type 'leaf' or 'collection' (and category 'pubsub'), which is not allowed according to XEP-60 5.3.");
                }
                collectionNode = new CollectionNode(this.con, str);
            }
            collectionNode.setTo(this.to);
            this.nodeMap.put(str, collectionNode);
        }
        return collectionNode;
    }

    public List<Subscription> getSubscriptions() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        IQ.Type type = IQ.Type.get;
        PubSubElementType pubSubElementType = PubSubElementType.SUBSCRIPTIONS;
        return ((SubscriptionsExtension) sendPubsubPacket(type, new NodeExtension(pubSubElementType), null).getExtension(pubSubElementType.getElementName(), pubSubElementType.getNamespace().getXmlns())).getSubscriptions();
    }

    public DiscoverInfo getSupportedFeatures() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(this.con).discoverInfo(this.to);
    }

    public static PubSub sendPubsubPacket(XMPPConnection xMPPConnection, String str, IQ.Type type, List<ExtensionElement> list, PubSubNamespace pubSubNamespace) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        PubSub pubSub = new PubSub(str, type, pubSubNamespace);
        Iterator<ExtensionElement> it = list.iterator();
        while (it.hasNext()) {
            pubSub.addExtension(it.next());
        }
        return sendPubsubPacket(xMPPConnection, pubSub);
    }

    public PubSubManager(XMPPConnection xMPPConnection, String str) {
        this.con = xMPPConnection;
        this.to = str;
    }

    public static PubSub sendPubsubPacket(XMPPConnection xMPPConnection, PubSub pubSub) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        IQ iq = (IQ) xMPPConnection.createPacketCollectorAndSend(pubSub).nextResultOrThrow();
        if (iq instanceof EmptyResultIQ) {
            return null;
        }
        return (PubSub) iq;
    }

    public LeafNode createNode(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return (LeafNode) createNode(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jivesoftware.smackx.pubsub.Node createNode(java.lang.String r5, org.jivesoftware.smackx.xdata.Form r6) throws org.jivesoftware.smack.SmackException.NotConnectedException, org.jivesoftware.smack.SmackException.NoResponseException, org.jivesoftware.smack.XMPPException.XMPPErrorException {
        /*
            r4 = this;
            java.lang.String r0 = r4.to
            org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.set
            org.jivesoftware.smackx.pubsub.NodeExtension r2 = new org.jivesoftware.smackx.pubsub.NodeExtension
            org.jivesoftware.smackx.pubsub.PubSubElementType r3 = org.jivesoftware.smackx.pubsub.PubSubElementType.CREATE
            r2.<init>(r3, r5)
            r3 = 0
            org.jivesoftware.smackx.pubsub.packet.PubSub r0 = org.jivesoftware.smackx.pubsub.packet.PubSub.createPubsubPacket(r0, r1, r2, r3)
            if (r6 == 0) goto L3e
            org.jivesoftware.smackx.pubsub.FormNode r1 = new org.jivesoftware.smackx.pubsub.FormNode
            org.jivesoftware.smackx.pubsub.FormNodeType r2 = org.jivesoftware.smackx.pubsub.FormNodeType.CONFIGURE
            r1.<init>(r2, r6)
            r0.addExtension(r1)
            org.jivesoftware.smackx.pubsub.ConfigureNodeFields r1 = org.jivesoftware.smackx.pubsub.ConfigureNodeFields.node_type
            java.lang.String r1 = r1.getFieldName()
            org.jivesoftware.smackx.xdata.FormField r6 = r6.getField(r1)
            if (r6 == 0) goto L3e
            java.util.List r6 = r6.getValues()
            r1 = 0
            java.lang.Object r6 = r6.get(r1)
            java.lang.String r6 = (java.lang.String) r6
            org.jivesoftware.smackx.pubsub.NodeType r1 = org.jivesoftware.smackx.pubsub.NodeType.leaf
            java.lang.String r1 = r1.toString()
            boolean r6 = r6.equals(r1)
            goto L3f
        L3e:
            r6 = 1
        L3f:
            org.jivesoftware.smack.XMPPConnection r1 = r4.con
            sendPubsubPacket(r1, r0)
            if (r6 == 0) goto L4e
            org.jivesoftware.smackx.pubsub.LeafNode r6 = new org.jivesoftware.smackx.pubsub.LeafNode
            org.jivesoftware.smack.XMPPConnection r0 = r4.con
            r6.<init>(r0, r5)
            goto L55
        L4e:
            org.jivesoftware.smackx.pubsub.CollectionNode r6 = new org.jivesoftware.smackx.pubsub.CollectionNode
            org.jivesoftware.smack.XMPPConnection r0 = r4.con
            r6.<init>(r0, r5)
        L55:
            java.lang.String r5 = r4.to
            r6.setTo(r5)
            java.util.Map<java.lang.String, org.jivesoftware.smackx.pubsub.Node> r5 = r4.nodeMap
            java.lang.String r0 = r6.getId()
            r5.put(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.pubsub.PubSubManager.createNode(java.lang.String, org.jivesoftware.smackx.xdata.Form):org.jivesoftware.smackx.pubsub.Node");
    }
}
