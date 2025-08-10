package org.jivesoftware.smack.packet;

import java.util.List;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class StreamError extends AbstractError implements PlainStreamElement {
    public static final String ELEMENT = "stream:error";
    public static final String JABBER_CLIENT = "jabber:client";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-streams";
    private final Condition condition;
    private final String conditionText;

    /* renamed from: org.jivesoftware.smack.packet.StreamError$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition;

        static {
            int[] iArr = new int[Condition.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition = iArr;
            try {
                iArr[Condition.see_other_host.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum Condition {
        bad_format,
        bad_namespace_prefix,
        conflict,
        connection_timeout,
        host_gone,
        host_unknown,
        improper_addressing,
        internal_server_error,
        invalid_from,
        invalid_namespace,
        invalid_xml,
        not_authorized,
        not_well_formed,
        policy_violation,
        remote_connection_failed,
        reset,
        resource_constraint,
        restricted_xml,
        see_other_host,
        system_shutdown,
        undeficed_condition,
        unsupported_encoding,
        unsupported_feature,
        unsupported_stanza_type,
        unsupported_version;

        public static Condition fromString(String str) {
            String strReplace = str.replace(SignatureImpl.SEP, '_');
            try {
                return valueOf(strReplace);
            } catch (Exception e) {
                throw new IllegalStateException("Could not transform string '" + strReplace + "' to XMPPErrorCondition", e);
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return name().replace('_', SignatureImpl.SEP);
        }
    }

    public StreamError(Condition condition, String str, Map<String, String> map, List<ExtensionElement> list) {
        super(map, list);
        str = StringUtils.isNullOrEmpty(str) ? null : str;
        if (str == null || AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition[condition.ordinal()] == 1) {
            this.condition = condition;
            this.conditionText = str;
        } else {
            throw new IllegalArgumentException("The given condition '" + condition + "' can not contain a conditionText");
        }
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getConditionText() {
        return this.conditionText;
    }

    public String toString() {
        return toXML().toString();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.openElement(ELEMENT);
        xmlStringBuilder.halfOpenElement(this.condition.toString()).xmlnsAttribute(NAMESPACE).closeEmptyElement();
        addDescriptiveTextsAndExtensions(xmlStringBuilder);
        xmlStringBuilder.closeElement(ELEMENT);
        return xmlStringBuilder;
    }
}
