package org.jivesoftware.smack.packet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class XMPPError extends AbstractError {
    private static final Map<Condition, Type> CONDITION_TO_TYPE;
    public static final String ERROR = "error";
    private static final Logger LOGGER = Logger.getLogger(XMPPError.class.getName());
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-stanzas";
    private final Condition condition;
    private final String conditionText;
    private final String errorGenerator;
    private final Type type;

    /* renamed from: org.jivesoftware.smack.packet.XMPPError$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$XMPPError$Condition;

        static {
            int[] iArr = new int[Condition.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$XMPPError$Condition = iArr;
            try {
                iArr[Condition.gone.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$XMPPError$Condition[Condition.redirect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum Condition {
        bad_request,
        conflict,
        feature_not_implemented,
        forbidden,
        gone,
        internal_server_error,
        item_not_found,
        jid_malformed,
        not_acceptable,
        not_allowed,
        not_authorized,
        policy_violation,
        recipient_unavailable,
        redirect,
        registration_required,
        remote_server_not_found,
        remote_server_timeout,
        resource_constraint,
        service_unavailable,
        subscription_required,
        undefined_condition,
        unexpected_request;

        public static Condition fromString(String str) {
            if ("xml-not-well-formed".equals(str)) {
                str = "not-well-formed";
            }
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

    public enum Type {
        WAIT,
        CANCEL,
        MODIFY,
        AUTH,
        CONTINUE;

        public static Type fromString(String str) {
            return valueOf(str.toUpperCase());
        }

        @Override // java.lang.Enum
        public String toString() {
            return name().toLowerCase();
        }
    }

    static {
        HashMap map = new HashMap();
        CONDITION_TO_TYPE = map;
        Condition condition = Condition.bad_request;
        Type type = Type.MODIFY;
        map.put(condition, type);
        Condition condition2 = Condition.conflict;
        Type type2 = Type.CANCEL;
        map.put(condition2, type2);
        map.put(Condition.feature_not_implemented, type2);
        Condition condition3 = Condition.forbidden;
        Type type3 = Type.AUTH;
        map.put(condition3, type3);
        map.put(Condition.gone, type2);
        map.put(Condition.internal_server_error, type2);
        map.put(Condition.item_not_found, type2);
        map.put(Condition.jid_malformed, type);
        map.put(Condition.not_acceptable, type);
        map.put(Condition.not_allowed, type2);
        map.put(Condition.not_authorized, type3);
        map.put(Condition.policy_violation, type);
        Condition condition4 = Condition.recipient_unavailable;
        Type type4 = Type.WAIT;
        map.put(condition4, type4);
        map.put(Condition.redirect, type);
        map.put(Condition.registration_required, type3);
        map.put(Condition.remote_server_not_found, type2);
        map.put(Condition.remote_server_timeout, type4);
        map.put(Condition.resource_constraint, type4);
        map.put(Condition.service_unavailable, type4);
        map.put(Condition.subscription_required, type4);
        map.put(Condition.unexpected_request, type);
    }

    public XMPPError(Condition condition) {
        this(condition, null, null, null, null, null);
    }

    public static XMPPError from(Condition condition, String str) {
        HashMap map = new HashMap();
        map.put("en", str);
        return new XMPPError(condition, null, null, null, map, null);
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getConditionText() {
        return this.conditionText;
    }

    public String getErrorGenerator() {
        return this.errorGenerator;
    }

    public Type getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XMPPError: ");
        sb.append(this.condition.toString());
        sb.append(" - ");
        sb.append(this.type.toString());
        if (this.errorGenerator != null) {
            sb.append(". Generated by ");
            sb.append(this.errorGenerator);
        }
        return sb.toString();
    }

    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement("error");
        xmlStringBuilder.attribute("type", this.type.toString());
        xmlStringBuilder.optAttribute("by", this.errorGenerator);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.halfOpenElement(this.condition.toString());
        xmlStringBuilder.xmlnsAttribute(NAMESPACE);
        if (this.conditionText != null) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.conditionText);
            xmlStringBuilder.closeElement(this.condition.toString());
        } else {
            xmlStringBuilder.closeEmptyElement();
        }
        addDescriptiveTextsAndExtensions(xmlStringBuilder);
        xmlStringBuilder.closeElement("error");
        return xmlStringBuilder;
    }

    public XMPPError(Condition condition, ExtensionElement extensionElement) {
        this(condition, null, null, null, null, Arrays.asList(extensionElement));
    }

    public XMPPError(Condition condition, String str, String str2, Type type, Map<String, String> map, List<ExtensionElement> list) {
        int i;
        super(map, NAMESPACE, list);
        this.condition = condition;
        str = StringUtils.isNullOrEmpty(str) ? null : str;
        if (str != null && (i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$XMPPError$Condition[condition.ordinal()]) != 1 && i != 2) {
            throw new IllegalArgumentException("Condition text can only be set with condtion types 'gone' and 'redirect', not " + condition);
        }
        this.conditionText = str;
        this.errorGenerator = str2;
        if (type == null) {
            Type type2 = CONDITION_TO_TYPE.get(condition);
            if (type2 == null) {
                LOGGER.warning("Could not determine type for condition: " + condition);
                type2 = Type.CANCEL;
            }
            this.type = type2;
            return;
        }
        this.type = type;
    }
}
