package org.jivesoftware.smackx.xdatavalidation.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.NumberUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdatavalidation.ValidationConsistencyException;

/* loaded from: classes5.dex */
public abstract class ValidateElement implements ExtensionElement {
    public static final String DATATYPE_XS_STRING = "xs:string";
    public static final String ELEMENT = "validate";
    public static final String NAMESPACE = "http://jabber.org/protocol/xdata-validate";
    private final String datatype;
    private ListRange listRange;

    /* renamed from: org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        static {
            int[] iArr = new int[FormField.Type.values().length];
            $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = iArr;
            try {
                iArr[FormField.Type.hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_multi.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.jid_single.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.list_multi.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[FormField.Type.text_multi.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class BasicValidateElement extends ValidateElement {
        public static final String METHOD = "basic";

        public BasicValidateElement(String str) {
            super(str, null);
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        public void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.emptyElement(METHOD);
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        public void checkConsistency(FormField formField) {
            checkListRangeConsistency(formField);
            if (formField.getType() != null) {
                int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[formField.getType().ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", formField.getType(), METHOD));
                }
            }
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML() {
            return super.toXML();
        }
    }

    public static class ListRange implements NamedElement {
        public static final String ELEMENT = "list-range";
        private final Long max;
        private final Long min;

        public ListRange(Long l, Long l2) {
            if (l != null) {
                NumberUtil.checkIfInUInt32Range(l.longValue());
            }
            if (l2 != null) {
                NumberUtil.checkIfInUInt32Range(l2.longValue());
            }
            if (l2 == null && l == null) {
                throw new IllegalArgumentException("Either min or max must be given");
            }
            this.min = l;
            this.max = l2;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        public Long getMax() {
            return this.max;
        }

        public Long getMin() {
            return this.min;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.optLongAttribute("min", getMin());
            xmlStringBuilder.optLongAttribute("max", getMax());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class OpenValidateElement extends ValidateElement {
        public static final String METHOD = "open";

        public OpenValidateElement(String str) {
            super(str, null);
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        public void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.emptyElement("open");
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        public void checkConsistency(FormField formField) {
            checkListRangeConsistency(formField);
            if (formField.getType() != null && AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[formField.getType().ordinal()] == 1) {
                throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", formField.getType(), "open"));
            }
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML() {
            return super.toXML();
        }
    }

    public static class RangeValidateElement extends ValidateElement {
        public static final String METHOD = "range";
        private final String max;
        private final String min;

        public RangeValidateElement(String str, String str2, String str3) {
            super(str, null);
            this.min = str2;
            this.max = str3;
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        public void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.halfOpenElement(METHOD);
            xmlStringBuilder.optAttribute("min", getMin());
            xmlStringBuilder.optAttribute("max", getMax());
            xmlStringBuilder.closeEmptyElement();
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        public void checkConsistency(FormField formField) {
            checkNonMultiConsistency(formField, METHOD);
            if (getDatatype().equals(ValidateElement.DATATYPE_XS_STRING)) {
                throw new ValidationConsistencyException(String.format("Field data type '%1$s' is not consistent with validation method '%2$s'.", getDatatype(), METHOD));
            }
        }

        public String getMax() {
            return this.max;
        }

        public String getMin() {
            return this.min;
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML() {
            return super.toXML();
        }
    }

    public static class RegexValidateElement extends ValidateElement {
        public static final String METHOD = "regex";
        private final String regex;

        public RegexValidateElement(String str, String str2) {
            super(str, null);
            this.regex = str2;
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        public void appendXML(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.element(METHOD, getRegex());
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement
        public void checkConsistency(FormField formField) {
            checkNonMultiConsistency(formField, METHOD);
        }

        public String getRegex() {
            return this.regex;
        }

        @Override // org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML() {
            return super.toXML();
        }
    }

    public /* synthetic */ ValidateElement(String str, AnonymousClass1 anonymousClass1) {
        this(str);
    }

    public abstract void appendXML(XmlStringBuilder xmlStringBuilder);

    public abstract void checkConsistency(FormField formField);

    public void checkListRangeConsistency(FormField formField) {
        ListRange listRange = getListRange();
        if (listRange == null) {
            return;
        }
        Long max = listRange.getMax();
        Long min = listRange.getMin();
        if ((max != null || min != null) && formField.getType() != FormField.Type.list_multi) {
            throw new ValidationConsistencyException("Field type is not of type 'list-multi' while a 'list-range' is defined.");
        }
    }

    public void checkNonMultiConsistency(FormField formField, String str) {
        checkListRangeConsistency(formField);
        if (formField.getType() != null) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[formField.getType().ordinal()];
            if (i == 1 || i == 2 || i == 4 || i == 5) {
                throw new ValidationConsistencyException(String.format("Field type '%1$s' is not consistent with validation method '%2$s'.", formField.getType(), str));
            }
        }
    }

    public String getDatatype() {
        String str = this.datatype;
        return str != null ? str : DATATYPE_XS_STRING;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public ListRange getListRange() {
        return this.listRange;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public void setListRange(ListRange listRange) {
        this.listRange = listRange;
    }

    private ValidateElement(String str) {
        this.datatype = StringUtils.isNotEmpty(str) ? str : null;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.optAttribute("datatype", this.datatype);
        xmlStringBuilder.rightAngleBracket();
        appendXML(xmlStringBuilder);
        xmlStringBuilder.optAppend(getListRange());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
