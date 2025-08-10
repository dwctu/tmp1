package org.jivesoftware.smackx.iqregister;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaIdFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.iqregister.packet.Registration;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class AccountManager extends Manager {
    private boolean accountCreationSupported;
    private boolean allowSensitiveOperationOverInsecureConnection;
    private Registration info;
    private static final Logger LOGGER = Logger.getLogger(AccountManager.class.getName());
    private static final Map<XMPPConnection, AccountManager> INSTANCES = new WeakHashMap();
    private static boolean allowSensitiveOperationOverInsecureConnectionDefault = false;

    private AccountManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.allowSensitiveOperationOverInsecureConnection = allowSensitiveOperationOverInsecureConnectionDefault;
        this.info = null;
        this.accountCreationSupported = false;
    }

    private PacketCollector createPacketCollectorAndSend(IQ iq) throws SmackException.NotConnectedException {
        return connection().createPacketCollectorAndSend(new StanzaIdFilter(iq.getStanzaId()), iq);
    }

    public static synchronized AccountManager getInstance(XMPPConnection xMPPConnection) {
        AccountManager accountManager;
        Map<XMPPConnection, AccountManager> map = INSTANCES;
        accountManager = map.get(xMPPConnection);
        if (accountManager == null) {
            accountManager = new AccountManager(xMPPConnection);
            map.put(xMPPConnection, accountManager);
        }
        return accountManager;
    }

    private synchronized void getRegistrationInfo() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Registration registration = new Registration();
        registration.setTo(connection().getServiceName());
        this.info = (Registration) createPacketCollectorAndSend(registration).nextResultOrThrow();
    }

    public static void sensitiveOperationOverInsecureConnectionDefault(boolean z) {
        allowSensitiveOperationOverInsecureConnectionDefault = z;
    }

    public void changePassword(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (!connection().isSecureConnection() && !this.allowSensitiveOperationOverInsecureConnection) {
            LOGGER.warning("Changing password over insecure connection. This will throw an exception in future versions of Smack if AccountManager.sensitiveOperationOverInsecureConnection(true) is not set");
        }
        HashMap map = new HashMap();
        map.put("username", XmppStringUtils.parseLocalpart(connection().getUser()));
        map.put("password", str);
        Registration registration = new Registration(map);
        registration.setType(IQ.Type.set);
        registration.setTo(connection().getServiceName());
        createPacketCollectorAndSend(registration).nextResultOrThrow();
    }

    public void createAccount(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        HashMap map = new HashMap();
        Iterator<String> it = getAccountAttributes().iterator();
        while (it.hasNext()) {
            map.put(it.next(), "");
        }
        createAccount(str, str2, map);
    }

    public void deleteAccount() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        HashMap map = new HashMap();
        map.put(DiscoverItems.Item.REMOVE_ACTION, "");
        Registration registration = new Registration(map);
        registration.setType(IQ.Type.set);
        registration.setTo(connection().getServiceName());
        createPacketCollectorAndSend(registration).nextResultOrThrow();
    }

    public String getAccountAttribute(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (this.info == null) {
            getRegistrationInfo();
        }
        return this.info.getAttributes().get(str);
    }

    public Set<String> getAccountAttributes() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (this.info == null) {
            getRegistrationInfo();
        }
        Map<String, String> attributes = this.info.getAttributes();
        return attributes != null ? Collections.unmodifiableSet(attributes.keySet()) : Collections.emptySet();
    }

    public String getAccountInstructions() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (this.info == null) {
            getRegistrationInfo();
        }
        return this.info.getInstructions();
    }

    public void sensitiveOperationOverInsecureConnection(boolean z) {
        this.allowSensitiveOperationOverInsecureConnection = z;
    }

    public void setSupportsAccountCreation(boolean z) {
        this.accountCreationSupported = z;
    }

    public boolean supportsAccountCreation() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (this.accountCreationSupported) {
            return true;
        }
        if (this.info == null) {
            getRegistrationInfo();
            this.accountCreationSupported = this.info.getType() != IQ.Type.error;
        }
        return this.accountCreationSupported;
    }

    public void createAccount(String str, String str2, Map<String, String> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        if (!connection().isSecureConnection() && !this.allowSensitiveOperationOverInsecureConnection) {
            LOGGER.warning("Creating account over insecure connection. This will throw an exception in future versions of Smack if AccountManager.sensitiveOperationOverInsecureConnection(true) is not set");
        }
        map.put("username", str);
        map.put("password", str2);
        Registration registration = new Registration(map);
        registration.setType(IQ.Type.set);
        registration.setTo(connection().getServiceName());
        createPacketCollectorAndSend(registration).nextResultOrThrow();
    }
}
