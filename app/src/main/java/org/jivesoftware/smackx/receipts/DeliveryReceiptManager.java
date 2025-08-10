package org.jivesoftware.smackx.receipts;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

/* loaded from: classes5.dex */
public class DeliveryReceiptManager extends Manager {
    private static final StanzaListener AUTO_ADD_DELIVERY_RECEIPT_REQUESTS_LISTENER;
    private static final StanzaFilter MESSAGES_TO_REQUEST_RECEIPTS_FOR;
    private static final StanzaFilter MESSAGES_WITH_DELIVERY_RECEIPT;
    private static final StanzaFilter MESSAGES_WITH_DEVLIERY_RECEIPT_REQUEST;
    private static AutoReceiptMode defaultAutoReceiptMode;
    private static Map<XMPPConnection, DeliveryReceiptManager> instances;
    private AutoReceiptMode autoReceiptMode;
    private final Set<ReceiptReceivedListener> receiptReceivedListeners;

    /* renamed from: org.jivesoftware.smackx.receipts.DeliveryReceiptManager$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode;

        static {
            int[] iArr = new int[AutoReceiptMode.values().length];
            $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode = iArr;
            try {
                iArr[AutoReceiptMode.disabled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode[AutoReceiptMode.ifIsSubscribed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode[AutoReceiptMode.always.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum AutoReceiptMode {
        disabled,
        ifIsSubscribed,
        always
    }

    static {
        StanzaTypeFilter stanzaTypeFilter = StanzaTypeFilter.MESSAGE;
        MESSAGES_WITH_DEVLIERY_RECEIPT_REQUEST = new AndFilter(stanzaTypeFilter, new StanzaExtensionFilter(new DeliveryReceiptRequest()));
        MESSAGES_WITH_DELIVERY_RECEIPT = new AndFilter(stanzaTypeFilter, new StanzaExtensionFilter(DeliveryReceipt.ELEMENT, DeliveryReceipt.NAMESPACE));
        instances = new WeakHashMap();
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.receipts.DeliveryReceiptManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                DeliveryReceiptManager.getInstanceFor(xMPPConnection);
            }
        });
        defaultAutoReceiptMode = AutoReceiptMode.ifIsSubscribed;
        MESSAGES_TO_REQUEST_RECEIPTS_FOR = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT_OR_HEADLINE, new NotFilter(new StanzaExtensionFilter(DeliveryReceipt.ELEMENT, DeliveryReceipt.NAMESPACE)));
        AUTO_ADD_DELIVERY_RECEIPT_REQUESTS_LISTENER = new StanzaListener() { // from class: org.jivesoftware.smackx.receipts.DeliveryReceiptManager.4
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                DeliveryReceiptRequest.addTo((Message) stanza);
            }
        };
    }

    private DeliveryReceiptManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.autoReceiptMode = defaultAutoReceiptMode;
        this.receiptReceivedListeners = new CopyOnWriteArraySet();
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(DeliveryReceipt.NAMESPACE);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.receipts.DeliveryReceiptManager.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                DeliveryReceipt deliveryReceiptFrom = DeliveryReceipt.from((Message) stanza);
                Iterator it = DeliveryReceiptManager.this.receiptReceivedListeners.iterator();
                while (it.hasNext()) {
                    ((ReceiptReceivedListener) it.next()).onReceiptReceived(stanza.getFrom(), stanza.getTo(), deliveryReceiptFrom.getId(), stanza);
                }
            }
        }, MESSAGES_WITH_DELIVERY_RECEIPT);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.receipts.DeliveryReceiptManager.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                String from = stanza.getFrom();
                XMPPConnection xMPPConnectionConnection = DeliveryReceiptManager.this.connection();
                int i = AnonymousClass5.$SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode[DeliveryReceiptManager.this.autoReceiptMode.ordinal()];
                if (i != 1) {
                    if (i == 2 && !Roster.getInstanceFor(xMPPConnectionConnection).isSubscribedToMyPresence(from)) {
                        return;
                    }
                    xMPPConnectionConnection.sendStanza(DeliveryReceiptManager.receiptMessageFor((Message) stanza));
                }
            }
        }, MESSAGES_WITH_DEVLIERY_RECEIPT_REQUEST);
    }

    @Deprecated
    public static String addDeliveryReceiptRequest(Message message) {
        return DeliveryReceiptRequest.addTo(message);
    }

    public static synchronized DeliveryReceiptManager getInstanceFor(XMPPConnection xMPPConnection) {
        DeliveryReceiptManager deliveryReceiptManager;
        deliveryReceiptManager = instances.get(xMPPConnection);
        if (deliveryReceiptManager == null) {
            deliveryReceiptManager = new DeliveryReceiptManager(xMPPConnection);
            instances.put(xMPPConnection, deliveryReceiptManager);
        }
        return deliveryReceiptManager;
    }

    public static boolean hasDeliveryReceiptRequest(Message message) {
        return DeliveryReceiptRequest.from(message) != null;
    }

    public static Message receiptMessageFor(Message message) {
        Message message2 = new Message(message.getFrom(), message.getType());
        message2.addExtension(new DeliveryReceipt(message.getStanzaId()));
        return message2;
    }

    public static void setDefaultAutoReceiptMode(AutoReceiptMode autoReceiptMode) {
        defaultAutoReceiptMode = autoReceiptMode;
    }

    public void addReceiptReceivedListener(ReceiptReceivedListener receiptReceivedListener) {
        this.receiptReceivedListeners.add(receiptReceivedListener);
    }

    public void autoAddDeliveryReceiptRequests() {
        connection().addPacketInterceptor(AUTO_ADD_DELIVERY_RECEIPT_REQUESTS_LISTENER, MESSAGES_TO_REQUEST_RECEIPTS_FOR);
    }

    public void dontAutoAddDeliveryReceiptRequests() {
        connection().removePacketInterceptor(AUTO_ADD_DELIVERY_RECEIPT_REQUESTS_LISTENER);
    }

    public AutoReceiptMode getAutoReceiptMode() {
        return this.autoReceiptMode;
    }

    public boolean isSupported(String str) throws SmackException, XMPPException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(str, DeliveryReceipt.NAMESPACE);
    }

    public void removeReceiptReceivedListener(ReceiptReceivedListener receiptReceivedListener) {
        this.receiptReceivedListeners.remove(receiptReceivedListener);
    }

    public void setAutoReceiptMode(AutoReceiptMode autoReceiptMode) {
        this.autoReceiptMode = autoReceiptMode;
    }
}
