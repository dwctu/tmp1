package org.jivesoftware.smack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Mechanisms;
import org.jivesoftware.smack.sasl.SASLAnonymous;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.json.JSONException;

/* loaded from: classes5.dex */
public class SASLAuthentication {
    private boolean authenticationSuccessful;
    private final AbstractXMPPConnection connection;
    private SASLMechanism currentMechanism = null;
    private Exception saslException;
    private static final Logger LOGGER = Logger.getLogger(SASLAuthentication.class.getName());
    private static final List<SASLMechanism> REGISTERED_MECHANISMS = new ArrayList();
    private static final Set<String> BLACKLISTED_MECHANISMS = new HashSet();

    public SASLAuthentication(AbstractXMPPConnection abstractXMPPConnection) {
        this.connection = abstractXMPPConnection;
        init();
    }

    public static boolean blacklistSASLMechanism(String str) {
        boolean zAdd;
        Set<String> set = BLACKLISTED_MECHANISMS;
        synchronized (set) {
            zAdd = set.add(str);
        }
        return zAdd;
    }

    public static Set<String> getBlacklistedSASLMechanisms() {
        HashSet hashSet;
        Set<String> set = BLACKLISTED_MECHANISMS;
        synchronized (set) {
            hashSet = new HashSet(set);
        }
        return hashSet;
    }

    public static Map<String, String> getRegisterdSASLMechanisms() {
        HashMap map = new HashMap();
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            for (SASLMechanism sASLMechanism : list) {
                map.put(sASLMechanism.getClass().getName(), sASLMechanism.getName());
            }
        }
        return map;
    }

    private void maybeThrowException() throws SmackException, SASLErrorException {
        Exception exc = this.saslException;
        if (exc != null) {
            if (exc instanceof SmackException) {
                throw ((SmackException) exc);
            }
            if (!(exc instanceof SASLErrorException)) {
                throw new IllegalStateException("Unexpected exception type", this.saslException);
            }
            throw ((SASLErrorException) exc);
        }
    }

    public static void registerSASLMechanism(SASLMechanism sASLMechanism) {
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            list.add(sASLMechanism);
            Collections.sort(list);
        }
    }

    private SASLMechanism selectMechanism() {
        for (SASLMechanism sASLMechanism : REGISTERED_MECHANISMS) {
            String name = sASLMechanism.getName();
            Set<String> set = BLACKLISTED_MECHANISMS;
            synchronized (set) {
                if (!set.contains(name)) {
                    if (serverMechanisms().contains(name)) {
                        return sASLMechanism.instanceForAuthentication(this.connection);
                    }
                }
            }
        }
        return null;
    }

    private List<String> serverMechanisms() {
        Mechanisms mechanisms = (Mechanisms) this.connection.getFeature(Mechanisms.ELEMENT, "urn:ietf:params:xml:ns:xmpp-sasl");
        if (mechanisms != null) {
            return mechanisms.getMechanisms();
        }
        LOGGER.warning("Server did not report any SASL mechanisms");
        return Collections.emptyList();
    }

    public static boolean unBlacklistSASLMechanism(String str) {
        boolean zRemove;
        Set<String> set = BLACKLISTED_MECHANISMS;
        synchronized (set) {
            zRemove = set.remove(str);
        }
        return zRemove;
    }

    public static boolean unregisterSASLMechanism(String str) {
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            Iterator<SASLMechanism> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getClass().getName().equals(str)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public void authenticate(String str, CallbackHandler callbackHandler) throws SmackException, SASLErrorException, IOException, XMPPException.XMPPErrorException {
        SASLMechanism sASLMechanismSelectMechanism = selectMechanism();
        if (sASLMechanismSelectMechanism == null) {
            throw new SmackException("SASL Authentication failed. No known authentication mechanisims.");
        }
        this.currentMechanism = sASLMechanismSelectMechanism;
        synchronized (this) {
            this.currentMechanism.authenticate(this.connection.getHost(), this.connection.getServiceName(), callbackHandler);
            try {
                wait(this.connection.getPacketReplyTimeout());
            } catch (InterruptedException unused) {
            }
        }
        maybeThrowException();
        if (!this.authenticationSuccessful) {
            throw SmackException.NoResponseException.newWith(this.connection);
        }
    }

    public void authenticateAnonymously() throws SmackException, SASLErrorException, XMPPException.XMPPErrorException {
        this.currentMechanism = new SASLAnonymous().instanceForAuthentication(this.connection);
        synchronized (this) {
            this.currentMechanism.authenticate(null, null, null, "");
            try {
                wait(this.connection.getPacketReplyTimeout());
            } catch (InterruptedException unused) {
            }
        }
        maybeThrowException();
        if (!this.authenticationSuccessful) {
            throw SmackException.NoResponseException.newWith(this.connection);
        }
    }

    public void authenticated(SaslStreamElements.Success success) throws SmackException, JSONException {
        if (success.getData() != null) {
            challengeReceived(success.getData(), true);
        }
        this.currentMechanism.checkIfSuccessfulOrThrow();
        this.authenticationSuccessful = true;
        synchronized (this) {
            notify();
        }
    }

    public void authenticationFailed(SaslStreamElements.SASLFailure sASLFailure) {
        authenticationFailed(new SASLErrorException(this.currentMechanism.getName(), sASLFailure));
    }

    public boolean authenticationSuccessful() {
        return this.authenticationSuccessful;
    }

    public void challengeReceived(String str) throws SmackException, JSONException {
        challengeReceived(str, false);
    }

    public boolean hasAnonymousAuthentication() {
        return serverMechanisms().contains(SASLAnonymous.NAME);
    }

    public boolean hasNonAnonymousAuthentication() {
        return (serverMechanisms().isEmpty() || (serverMechanisms().size() == 1 && hasAnonymousAuthentication())) ? false : true;
    }

    public void init() {
        this.authenticationSuccessful = false;
        this.saslException = null;
    }

    public void authenticationFailed(Exception exc) {
        this.saslException = exc;
        synchronized (this) {
            notify();
        }
    }

    public void challengeReceived(String str, boolean z) throws SmackException, JSONException {
        try {
            this.currentMechanism.challengeReceived(str, z);
        } catch (SmackException e) {
            authenticationFailed(e);
            throw e;
        }
    }

    public void authenticate(String str, String str2, String str3) throws SmackException, SASLErrorException, IOException, XMPPException.XMPPErrorException {
        SASLMechanism sASLMechanismSelectMechanism = selectMechanism();
        if (sASLMechanismSelectMechanism != null) {
            this.currentMechanism = sASLMechanismSelectMechanism;
            synchronized (this) {
                this.currentMechanism.authenticate(str, this.connection.getHost(), this.connection.getServiceName(), str2);
                try {
                    wait(this.connection.getPacketReplyTimeout());
                } catch (InterruptedException unused) {
                }
            }
            maybeThrowException();
            if (!this.authenticationSuccessful) {
                throw SmackException.NoResponseException.newWith(this.connection);
            }
            return;
        }
        throw new SmackException("SASL Authentication failed. No known authentication mechanisims.");
    }
}
