package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.delay.DelayInformationManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.pubsub.listener.ItemDeleteListener;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.jivesoftware.smackx.pubsub.listener.NodeConfigListener;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jivesoftware.smackx.pubsub.util.NodeUtils;
import org.jivesoftware.smackx.shim.packet.Header;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import org.jivesoftware.smackx.xdata.Form;

/* loaded from: classes5.dex */
public abstract class Node {
    public XMPPConnection con;
    public String id;
    public String to;
    public ConcurrentHashMap<ItemEventListener<Item>, StanzaListener> itemEventToListenerMap = new ConcurrentHashMap<>();
    public ConcurrentHashMap<ItemDeleteListener, StanzaListener> itemDeleteToListenerMap = new ConcurrentHashMap<>();
    public ConcurrentHashMap<NodeConfigListener, StanzaListener> configEventToListenerMap = new ConcurrentHashMap<>();

    public class ItemDeleteTranslator implements StanzaListener {
        private ItemDeleteListener listener;

        public ItemDeleteTranslator(ItemDeleteListener itemDeleteListener) {
            this.listener = itemDeleteListener;
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processPacket(Stanza stanza) {
            EventElement eventElement = (EventElement) stanza.getExtension("event", PubSubNamespace.EVENT.getXmlns());
            if (eventElement.getExtensions().get(0).getElementName().equals(PubSubElementType.PURGE_EVENT.getElementName())) {
                this.listener.handlePurge();
                return;
            }
            ItemsExtension itemsExtension = (ItemsExtension) eventElement.getEvent();
            List<? extends ExtensionElement> items = itemsExtension.getItems();
            ArrayList arrayList = new ArrayList(items.size());
            Iterator<? extends ExtensionElement> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(((RetractItem) it.next()).getId());
            }
            this.listener.handleDeletedItems(new ItemDeleteEvent(itemsExtension.getNode(), arrayList, Node.getSubscriptionIds(stanza)));
        }
    }

    public class ItemEventTranslator implements StanzaListener {
        private ItemEventListener listener;

        public ItemEventTranslator(ItemEventListener itemEventListener) {
            this.listener = itemEventListener;
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processPacket(Stanza stanza) {
            ItemsExtension itemsExtension = (ItemsExtension) ((EventElement) stanza.getExtension("event", PubSubNamespace.EVENT.getXmlns())).getEvent();
            this.listener.handlePublishedItems(new ItemPublishEvent(itemsExtension.getNode(), itemsExtension.getItems(), Node.getSubscriptionIds(stanza), DelayInformationManager.getDelayTimestamp(stanza)));
        }
    }

    public class NodeConfigTranslator implements StanzaListener {
        private NodeConfigListener listener;

        public NodeConfigTranslator(NodeConfigListener nodeConfigListener) {
            this.listener = nodeConfigListener;
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public void processPacket(Stanza stanza) {
            this.listener.handleNodeConfiguration((ConfigurationEvent) ((EventElement) stanza.getExtension("event", PubSubNamespace.EVENT.getXmlns())).getEvent());
        }
    }

    public Node(XMPPConnection xMPPConnection, String str) {
        this.con = xMPPConnection;
        this.id = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> getSubscriptionIds(Stanza stanza) {
        HeadersExtension headersExtension = (HeadersExtension) stanza.getExtension(HeadersExtension.ELEMENT, HeadersExtension.NAMESPACE);
        if (headersExtension == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(headersExtension.getHeaders().size());
        Iterator<Header> it = headersExtension.getHeaders().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    public void addConfigurationListener(NodeConfigListener nodeConfigListener) {
        NodeConfigTranslator nodeConfigTranslator = new NodeConfigTranslator(nodeConfigListener);
        this.configEventToListenerMap.put(nodeConfigListener, nodeConfigTranslator);
        this.con.addSyncStanzaListener(nodeConfigTranslator, new EventContentFilter(EventElementType.configuration.toString()));
    }

    public void addItemDeleteListener(ItemDeleteListener itemDeleteListener) {
        ItemDeleteTranslator itemDeleteTranslator = new ItemDeleteTranslator(itemDeleteListener);
        this.itemDeleteToListenerMap.put(itemDeleteListener, itemDeleteTranslator);
        this.con.addSyncStanzaListener(itemDeleteTranslator, new OrFilter(new EventContentFilter(EventElementType.items.toString(), "retract"), new EventContentFilter(EventElementType.purge.toString())));
    }

    public void addItemEventListener(ItemEventListener itemEventListener) {
        ItemEventTranslator itemEventTranslator = new ItemEventTranslator(itemEventListener);
        this.itemEventToListenerMap.put(itemEventListener, itemEventTranslator);
        this.con.addSyncStanzaListener(itemEventTranslator, new EventContentFilter(EventElementType.items.toString(), "item"));
    }

    public PubSub createPubsubPacket(IQ.Type type, ExtensionElement extensionElement) {
        return createPubsubPacket(type, extensionElement, null);
    }

    public DiscoverInfo discoverInfo() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        DiscoverInfo discoverInfo = new DiscoverInfo();
        discoverInfo.setTo(this.to);
        discoverInfo.setNode(getId());
        return (DiscoverInfo) this.con.createPacketCollectorAndSend(discoverInfo).nextResultOrThrow();
    }

    public List<Affiliation> getAffiliations() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getAffiliations(null, null);
    }

    public String getId() {
        return this.id;
    }

    public ConfigureForm getNodeConfiguration() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        IQ.Type type = IQ.Type.get;
        PubSubElementType pubSubElementType = PubSubElementType.CONFIGURE_OWNER;
        return NodeUtils.getFormFromPacket(sendPubsubPacket(createPubsubPacket(type, new NodeExtension(pubSubElementType, getId()), PubSubNamespace.OWNER)), pubSubElementType);
    }

    public SubscribeForm getSubscriptionOptions(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getSubscriptionOptions(str, null);
    }

    public List<Subscription> getSubscriptions() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getSubscriptions(null, null);
    }

    public List<Subscription> getSubscriptionsAsOwner() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getSubscriptionsAsOwner(null, null);
    }

    public void removeConfigurationListener(NodeConfigListener nodeConfigListener) {
        StanzaListener stanzaListenerRemove = this.configEventToListenerMap.remove(nodeConfigListener);
        if (stanzaListenerRemove != null) {
            this.con.removeSyncStanzaListener(stanzaListenerRemove);
        }
    }

    public void removeItemDeleteListener(ItemDeleteListener itemDeleteListener) {
        StanzaListener stanzaListenerRemove = this.itemDeleteToListenerMap.remove(itemDeleteListener);
        if (stanzaListenerRemove != null) {
            this.con.removeSyncStanzaListener(stanzaListenerRemove);
        }
    }

    public void removeItemEventListener(ItemEventListener itemEventListener) {
        StanzaListener stanzaListenerRemove = this.itemEventToListenerMap.remove(itemEventListener);
        if (stanzaListenerRemove != null) {
            this.con.removeSyncStanzaListener(stanzaListenerRemove);
        }
    }

    public void sendConfigurationForm(Form form) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        this.con.createPacketCollectorAndSend(createPubsubPacket(IQ.Type.set, new FormNode(FormNodeType.CONFIGURE_OWNER, getId(), form), PubSubNamespace.OWNER)).nextResultOrThrow();
    }

    public PubSub sendPubsubPacket(PubSub pubSub) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return PubSubManager.sendPubsubPacket(this.con, pubSub);
    }

    public void setTo(String str) {
        this.to = str;
    }

    public Subscription subscribe(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return (Subscription) sendPubsubPacket(createPubsubPacket(IQ.Type.set, new SubscribeExtension(str, getId()))).getExtension(PubSubElementType.SUBSCRIPTION);
    }

    public String toString() {
        return super.toString() + " " + getClass().getName() + " id: " + this.id;
    }

    public void unsubscribe(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        unsubscribe(str, null);
    }

    public class EventContentFilter implements StanzaFilter {
        private String firstElement;
        private String secondElement;

        public EventContentFilter(String str) {
            this.firstElement = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.jivesoftware.smack.filter.StanzaFilter
        public boolean accept(Stanza stanza) {
            EventElement eventElement;
            NodeExtension event;
            if (!(stanza instanceof Message) || (eventElement = (EventElement) stanza.getExtension("event", PubSubNamespace.EVENT.getXmlns())) == null || (event = eventElement.getEvent()) == 0 || !event.getElementName().equals(this.firstElement) || !event.getNode().equals(Node.this.getId())) {
                return false;
            }
            if (this.secondElement == null) {
                return true;
            }
            if (event instanceof EmbeddedPacketExtension) {
                List<ExtensionElement> extensions = ((EmbeddedPacketExtension) event).getExtensions();
                if (extensions.size() > 0 && extensions.get(0).getElementName().equals(this.secondElement)) {
                    return true;
                }
            }
            return false;
        }

        public EventContentFilter(String str, String str2) {
            this.firstElement = str;
            this.secondElement = str2;
        }
    }

    public PubSub createPubsubPacket(IQ.Type type, ExtensionElement extensionElement, PubSubNamespace pubSubNamespace) {
        return PubSub.createPubsubPacket(this.to, type, extensionElement, pubSubNamespace);
    }

    public List<Affiliation> getAffiliations(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        PubSub pubSubCreatePubsubPacket = createPubsubPacket(IQ.Type.get, new NodeExtension(PubSubElementType.AFFILIATIONS, getId()));
        if (list != null) {
            Iterator<ExtensionElement> it = list.iterator();
            while (it.hasNext()) {
                pubSubCreatePubsubPacket.addExtension(it.next());
            }
        }
        PubSub pubSubSendPubsubPacket = sendPubsubPacket(pubSubCreatePubsubPacket);
        if (collection != null) {
            collection.addAll(pubSubSendPubsubPacket.getExtensions());
        }
        return ((AffiliationsExtension) pubSubSendPubsubPacket.getExtension(PubSubElementType.AFFILIATIONS)).getAffiliations();
    }

    public SubscribeForm getSubscriptionOptions(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return new SubscribeForm(((FormNode) sendPubsubPacket(createPubsubPacket(IQ.Type.get, new OptionsExtension(str, getId(), str2))).getExtension(PubSubElementType.OPTIONS)).getForm());
    }

    public List<Subscription> getSubscriptions(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getSubscriptions(list, collection, null);
    }

    public List<Subscription> getSubscriptionsAsOwner(List<ExtensionElement> list, Collection<ExtensionElement> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return getSubscriptions(list, collection, PubSubNamespace.OWNER);
    }

    public void unsubscribe(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        sendPubsubPacket(createPubsubPacket(IQ.Type.set, new UnsubscribeExtension(str, getId(), str2)));
    }

    private List<Subscription> getSubscriptions(List<ExtensionElement> list, Collection<ExtensionElement> collection, PubSubNamespace pubSubNamespace) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        PubSub pubSubCreatePubsubPacket = createPubsubPacket(IQ.Type.get, new NodeExtension(PubSubElementType.SUBSCRIPTIONS, getId()), pubSubNamespace);
        if (list != null) {
            Iterator<ExtensionElement> it = list.iterator();
            while (it.hasNext()) {
                pubSubCreatePubsubPacket.addExtension(it.next());
            }
        }
        PubSub pubSubSendPubsubPacket = sendPubsubPacket(pubSubCreatePubsubPacket);
        if (collection != null) {
            collection.addAll(pubSubSendPubsubPacket.getExtensions());
        }
        return ((SubscriptionsExtension) pubSubSendPubsubPacket.getExtension(PubSubElementType.SUBSCRIPTIONS)).getSubscriptions();
    }

    public Subscription subscribe(String str, SubscribeForm subscribeForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        PubSub pubSubCreatePubsubPacket = createPubsubPacket(IQ.Type.set, new SubscribeExtension(str, getId()));
        pubSubCreatePubsubPacket.addExtension(new FormNode(FormNodeType.OPTIONS, subscribeForm));
        return (Subscription) PubSubManager.sendPubsubPacket(this.con, pubSubCreatePubsubPacket).getExtension(PubSubElementType.SUBSCRIPTION);
    }
}
