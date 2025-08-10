package org.jivesoftware.smack;

import com.broadcom.bt.util.io.FilenameUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.util.dns.HostAddress;

/* loaded from: classes5.dex */
public class SmackException extends Exception {
    private static final long serialVersionUID = 1844674365368214457L;

    public static class AlreadyConnectedException extends SmackException {
        private static final long serialVersionUID = 5011416918049135231L;

        public AlreadyConnectedException() {
            super("Client is already connected");
        }
    }

    public static class AlreadyLoggedInException extends SmackException {
        private static final long serialVersionUID = 5011416918049935231L;

        public AlreadyLoggedInException() {
            super("Client is already logged in");
        }
    }

    public static class FeatureNotSupportedException extends SmackException {
        private static final long serialVersionUID = 4713404802621452016L;
        private final String feature;
        private final String jid;

        public FeatureNotSupportedException(String str) {
            this(str, null);
        }

        public String getFeature() {
            return this.feature;
        }

        public String getJid() {
            return this.jid;
        }

        public FeatureNotSupportedException(String str, String str2) {
            String str3;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" not supported");
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = " by '" + str2 + "'";
            }
            sb.append(str3);
            super(sb.toString());
            this.jid = str2;
            this.feature = str;
        }
    }

    public static class IllegalStateChangeException extends SmackException {
        private static final long serialVersionUID = -1766023961577168927L;
    }

    public static class NoResponseException extends SmackException {
        private static final long serialVersionUID = -6523363748984543636L;
        private final StanzaFilter filter;

        private NoResponseException(String str, StanzaFilter stanzaFilter) {
            super(str);
            this.filter = stanzaFilter;
        }

        public static NoResponseException newWith(XMPPConnection xMPPConnection) {
            return newWith(xMPPConnection, (StanzaFilter) null);
        }

        public StanzaFilter getFilter() {
            return this.filter;
        }

        public static NoResponseException newWith(XMPPConnection xMPPConnection, PacketCollector packetCollector) {
            return newWith(xMPPConnection, packetCollector.getStanzaFilter());
        }

        public static NoResponseException newWith(XMPPConnection xMPPConnection, StanzaFilter stanzaFilter) {
            long packetReplyTimeout = xMPPConnection.getPacketReplyTimeout();
            StringBuilder sb = new StringBuilder(256);
            sb.append("No response received within reply timeout. Timeout was " + packetReplyTimeout + "ms (~" + (packetReplyTimeout / 1000) + "s). Used filter: ");
            if (stanzaFilter != null) {
                sb.append(stanzaFilter.toString());
            } else {
                sb.append("No filter used or filter was 'null'");
            }
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            return new NoResponseException(sb.toString(), stanzaFilter);
        }
    }

    public static class NotConnectedException extends SmackException {
        private static final long serialVersionUID = 9197980400776001173L;

        public NotConnectedException() {
            super("Client is not, or no longer, connected");
        }
    }

    public static class NotLoggedInException extends SmackException {
        private static final long serialVersionUID = 3216216839100019278L;

        public NotLoggedInException() {
            super("Client is not logged in");
        }
    }

    public static class ResourceBindingNotOfferedException extends SmackException {
        private static final long serialVersionUID = 2346934138253437571L;

        public ResourceBindingNotOfferedException() {
            super("Resource binding was not offered by server");
        }
    }

    public static class SecurityNotPossibleException extends SmackException {
        private static final long serialVersionUID = -6836090872690331336L;

        public SecurityNotPossibleException(String str) {
            super(str);
        }
    }

    public static class SecurityRequiredByClientException extends SecurityRequiredException {
        private static final long serialVersionUID = 2395325821201543159L;

        public SecurityRequiredByClientException() {
            super("SSL/TLS required by client but not supported by server");
        }
    }

    public static class SecurityRequiredByServerException extends SecurityRequiredException {
        private static final long serialVersionUID = 8268148813117631819L;

        public SecurityRequiredByServerException() {
            super("SSL/TLS required by server but disabled in client");
        }
    }

    public static abstract class SecurityRequiredException extends SmackException {
        private static final long serialVersionUID = 384291845029773545L;

        public SecurityRequiredException(String str) {
            super(str);
        }
    }

    public SmackException(Throwable th) {
        super(th);
    }

    public static class ConnectionException extends SmackException {
        private static final long serialVersionUID = 1686944201672697996L;
        private final List<HostAddress> failedAddresses;

        public ConnectionException(Throwable th) {
            super(th);
            this.failedAddresses = new ArrayList(0);
        }

        public static ConnectionException from(List<HostAddress> list) {
            StringBuilder sb = new StringBuilder("The following addresses failed: ");
            Iterator<HostAddress> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getErrorMessage());
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            return new ConnectionException(sb.toString(), list);
        }

        public List<HostAddress> getFailedAddresses() {
            return this.failedAddresses;
        }

        private ConnectionException(String str, List<HostAddress> list) {
            super(str);
            this.failedAddresses = list;
        }
    }

    public SmackException(String str) {
        super(str);
    }

    public SmackException(String str, Throwable th) {
        super(str, th);
    }

    public SmackException() {
    }
}
