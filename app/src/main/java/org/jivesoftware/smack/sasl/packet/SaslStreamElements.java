package org.jivesoftware.smack.sasl.packet;

import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.eg3;
import java.util.Map;
import org.jivesoftware.smack.packet.AbstractError;
import org.jivesoftware.smack.packet.PlainStreamElement;
import org.jivesoftware.smack.sasl.SASLError;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class SaslStreamElements {
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-sasl";

    public static class AuthMechanism implements PlainStreamElement {
        public static final String ELEMENT = "auth";
        public static final int ENCRYPTED_EV = 100;
        private final String authenticationText;
        private final String mechanism;

        public AuthMechanism(String str, String str2) {
            this.mechanism = (String) Objects.requireNonNull(str, "SASL mechanism shouldn't be null.");
            this.authenticationText = (String) StringUtils.requireNotNullOrEmpty(str2, "SASL authenticationText must not be null or empty (RFC6120 6.4.2)");
        }

        public String getAuthenticationText() {
            return this.authenticationText;
        }

        public String getMechanism() {
            return this.mechanism;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            if (eg3.d(MyApplication.N(), "is_third_login", false)) {
                xmlStringBuilder.halfOpenElement(ELEMENT).xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-sasl").attribute("lt", "gt").attribute("mechanism", this.mechanism).attribute("cv", "android-" + WearUtils.q).attribute("ev", 100).rightAngleBracket();
                xmlStringBuilder.optAppend(this.authenticationText);
                xmlStringBuilder.closeElement(ELEMENT);
                return xmlStringBuilder;
            }
            xmlStringBuilder.halfOpenElement(ELEMENT).xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-sasl").attribute("mechanism", this.mechanism).attribute("cv", "android-" + WearUtils.q).attribute("ev", 100).rightAngleBracket();
            xmlStringBuilder.optAppend(this.authenticationText);
            xmlStringBuilder.closeElement(ELEMENT);
            return xmlStringBuilder;
        }
    }

    public static class Challenge implements PlainStreamElement {
        public static final String ELEMENT = "challenge";
        private final String data;

        public Challenge(String str) {
            this.data = StringUtils.returnIfNotEmptyTrimmed(str);
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilderRightAngleBracket = new XmlStringBuilder().halfOpenElement(ELEMENT).xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-sasl").rightAngleBracket();
            xmlStringBuilderRightAngleBracket.optAppend(this.data);
            xmlStringBuilderRightAngleBracket.closeElement(ELEMENT);
            return xmlStringBuilderRightAngleBracket;
        }
    }

    public static class Response implements PlainStreamElement {
        public static final String ELEMENT = "response";
        private final String authenticationText;

        public Response() {
            this.authenticationText = null;
        }

        public String getAuthenticationText() {
            return this.authenticationText;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement(ELEMENT).xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-sasl").rightAngleBracket();
            xmlStringBuilder.optAppend(this.authenticationText);
            xmlStringBuilder.closeElement(ELEMENT);
            return xmlStringBuilder;
        }

        public Response(String str) {
            this.authenticationText = StringUtils.returnIfNotEmptyTrimmed(str);
        }
    }

    public static class SASLFailure extends AbstractError implements PlainStreamElement {
        public static final String ELEMENT = "failure";
        private final SASLError saslError;
        private final String saslErrorString;

        public SASLFailure(String str) {
            this(str, null);
        }

        public SASLError getSASLError() {
            return this.saslError;
        }

        public String getSASLErrorString() {
            return this.saslErrorString;
        }

        public String toString() {
            return toXML().toString();
        }

        public SASLFailure(String str, Map<String, String> map) {
            super(map);
            SASLError sASLErrorFromString = SASLError.fromString(str);
            if (sASLErrorFromString == null) {
                this.saslError = SASLError.not_authorized;
            } else {
                this.saslError = sASLErrorFromString;
            }
            this.saslErrorString = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement(ELEMENT).xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-sasl").rightAngleBracket();
            xmlStringBuilder.emptyElement(this.saslErrorString);
            addDescriptiveTextsAndExtensions(xmlStringBuilder);
            xmlStringBuilder.closeElement(ELEMENT);
            return xmlStringBuilder;
        }
    }

    public static class Success implements PlainStreamElement {
        public static final String ELEMENT = "success";
        private final String data;

        public Success(String str) {
            this.data = StringUtils.returnIfNotEmptyTrimmed(str);
        }

        public String getData() {
            return this.data;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("success").xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-sasl").rightAngleBracket();
            xmlStringBuilder.optAppend(this.data);
            xmlStringBuilder.closeElement("success");
            return xmlStringBuilder;
        }
    }
}
