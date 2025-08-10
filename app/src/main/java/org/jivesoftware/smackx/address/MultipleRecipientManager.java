package org.jivesoftware.smackx.address;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class MultipleRecipientManager {

    public static class PacketCopy extends Stanza {
        private CharSequence text;

        public PacketCopy(CharSequence charSequence) {
            this.text = charSequence;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML() {
            return this.text;
        }
    }

    private static String getMultipleRecipienServiceAddress(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        List<String> listFindServices = ServiceDiscoveryManager.getInstanceFor(xMPPConnection).findServices(MultipleAddresses.NAMESPACE, true, true);
        if (listFindServices.size() > 0) {
            return listFindServices.get(0);
        }
        return null;
    }

    public static MultipleRecipientInfo getMultipleRecipientInfo(Stanza stanza) {
        MultipleAddresses multipleAddresses = (MultipleAddresses) stanza.getExtension(MultipleAddresses.ELEMENT, MultipleAddresses.NAMESPACE);
        if (multipleAddresses == null) {
            return null;
        }
        return new MultipleRecipientInfo(multipleAddresses);
    }

    public static void reply(XMPPConnection xMPPConnection, Message message, Message message2) throws SmackException, XMPPException.XMPPErrorException {
        MultipleRecipientInfo multipleRecipientInfo = getMultipleRecipientInfo(message);
        if (multipleRecipientInfo == null) {
            throw new SmackException("Original message does not contain multiple recipient info");
        }
        if (multipleRecipientInfo.shouldNotReply()) {
            throw new SmackException("Original message should not be replied");
        }
        if (multipleRecipientInfo.getReplyRoom() != null) {
            throw new SmackException("Reply should be sent through a room");
        }
        if (message.getThread() != null) {
            message2.setThread(message.getThread());
        }
        MultipleAddresses.Address replyAddress = multipleRecipientInfo.getReplyAddress();
        if (replyAddress != null && replyAddress.getJid() != null) {
            message2.setTo(replyAddress.getJid());
            xMPPConnection.sendStanza(message2);
            return;
        }
        ArrayList arrayList = new ArrayList(multipleRecipientInfo.getTOAddresses().size());
        ArrayList arrayList2 = new ArrayList(multipleRecipientInfo.getCCAddresses().size());
        Iterator<MultipleAddresses.Address> it = multipleRecipientInfo.getTOAddresses().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getJid());
        }
        Iterator<MultipleAddresses.Address> it2 = multipleRecipientInfo.getCCAddresses().iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getJid());
        }
        if (!arrayList.contains(message.getFrom()) && !arrayList2.contains(message.getFrom())) {
            arrayList.add(message.getFrom());
        }
        String user = xMPPConnection.getUser();
        if (!arrayList.remove(user) && !arrayList2.remove(user)) {
            String bareJid = XmppStringUtils.parseBareJid(user);
            arrayList.remove(bareJid);
            arrayList2.remove(bareJid);
        }
        send(xMPPConnection, message2, arrayList, arrayList2, null, null, null, false);
    }

    public static void send(XMPPConnection xMPPConnection, Stanza stanza, Collection<String> collection, Collection<String> collection2, Collection<String> collection3) throws SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException, XMPPException.XMPPErrorException {
        send(xMPPConnection, stanza, collection, collection2, collection3, null, null, false);
    }

    private static void sendThroughService(XMPPConnection xMPPConnection, Stanza stanza, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, String str, String str2, boolean z, String str3) throws SmackException.NotConnectedException {
        MultipleAddresses multipleAddresses = new MultipleAddresses();
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                multipleAddresses.addAddress(MultipleAddresses.Type.to, it.next(), null, null, false, null);
            }
        }
        if (collection2 != null) {
            Iterator<String> it2 = collection2.iterator();
            while (it2.hasNext()) {
                multipleAddresses.addAddress(MultipleAddresses.Type.to, it2.next(), null, null, false, null);
            }
        }
        if (collection3 != null) {
            Iterator<String> it3 = collection3.iterator();
            while (it3.hasNext()) {
                multipleAddresses.addAddress(MultipleAddresses.Type.bcc, it3.next(), null, null, false, null);
            }
        }
        if (z) {
            multipleAddresses.setNoReply();
        } else {
            if (str != null && str.trim().length() > 0) {
                multipleAddresses.addAddress(MultipleAddresses.Type.replyto, str, null, null, false, null);
            }
            if (str2 != null && str2.trim().length() > 0) {
                multipleAddresses.addAddress(MultipleAddresses.Type.replyroom, str2, null, null, false, null);
            }
        }
        stanza.setTo(str3);
        stanza.addExtension(multipleAddresses);
        xMPPConnection.sendStanza(stanza);
    }

    private static void sendToIndividualRecipients(XMPPConnection xMPPConnection, Stanza stanza, Collection<String> collection, Collection<String> collection2, Collection<String> collection3) throws SmackException.NotConnectedException {
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                stanza.setTo(it.next());
                xMPPConnection.sendStanza(new PacketCopy(stanza.toXML()));
            }
        }
        if (collection2 != null) {
            Iterator<String> it2 = collection2.iterator();
            while (it2.hasNext()) {
                stanza.setTo(it2.next());
                xMPPConnection.sendStanza(new PacketCopy(stanza.toXML()));
            }
        }
        if (collection3 != null) {
            Iterator<String> it3 = collection3.iterator();
            while (it3.hasNext()) {
                stanza.setTo(it3.next());
                xMPPConnection.sendStanza(new PacketCopy(stanza.toXML()));
            }
        }
    }

    public static void send(XMPPConnection xMPPConnection, Stanza stanza, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, String str, String str2, boolean z) throws SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException, XMPPException.XMPPErrorException {
        if (collection != null && collection.size() == 1 && ((collection2 == null || collection2.isEmpty()) && ((collection3 == null || collection3.isEmpty()) && !z && StringUtils.isNullOrEmpty(str) && StringUtils.isNullOrEmpty(str2)))) {
            stanza.setTo(collection.iterator().next());
            xMPPConnection.sendStanza(stanza);
            return;
        }
        String multipleRecipienServiceAddress = getMultipleRecipienServiceAddress(xMPPConnection);
        if (multipleRecipienServiceAddress != null) {
            sendThroughService(xMPPConnection, stanza, collection, collection2, collection3, str, str2, z, multipleRecipienServiceAddress);
            return;
        }
        if (z || ((str != null && str.trim().length() > 0) || (str2 != null && str2.trim().length() > 0))) {
            throw new SmackException.FeatureNotSupportedException("Extended Stanza Addressing");
        }
        sendToIndividualRecipients(xMPPConnection, stanza, collection, collection2, collection3);
    }
}
