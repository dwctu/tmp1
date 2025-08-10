package org.jivesoftware.smack.util;

import java.util.Collection;
import java.util.Iterator;
import kotlin.text.Typography;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;

/* loaded from: classes5.dex */
public class XmlStringBuilder implements Appendable, CharSequence {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String RIGHT_ANGLE_BRACKET = Character.toString(Typography.greater);
    private final LazyStringBuilder sb;

    public XmlStringBuilder() {
        this.sb = new LazyStringBuilder();
    }

    public XmlStringBuilder attribute(String str, String str2) {
        this.sb.append(' ').append((CharSequence) str).append((CharSequence) "='");
        escape(str2);
        this.sb.append('\'');
        return this;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.sb.charAt(i);
    }

    public XmlStringBuilder closeElement(String str) {
        this.sb.append((CharSequence) "</").append((CharSequence) str);
        rightAngleBracket();
        return this;
    }

    public XmlStringBuilder closeEmptyElement() {
        this.sb.append((CharSequence) "/>");
        return this;
    }

    public XmlStringBuilder condAttribute(boolean z, String str, String str2) {
        if (z) {
            attribute(str, str2);
        }
        return this;
    }

    public XmlStringBuilder condEmptyElement(boolean z, String str) {
        if (z) {
            emptyElement(str);
        }
        return this;
    }

    public XmlStringBuilder element(String str, String str2) {
        openElement(str);
        escape(str2);
        closeElement(str);
        return this;
    }

    public XmlStringBuilder emptyElement(Enum<?> r1) {
        return emptyElement(r1.name());
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharSequence) {
            return toString().equals(((CharSequence) obj).toString());
        }
        return false;
    }

    public XmlStringBuilder escape(String str) {
        this.sb.append(StringUtils.escapeForXML(str));
        return this;
    }

    public XmlStringBuilder escapedElement(String str, String str2) {
        openElement(str);
        append((CharSequence) str2);
        closeElement(str);
        return this;
    }

    public XmlStringBuilder halfOpenElement(String str) {
        this.sb.append(Typography.less).append((CharSequence) str);
        return this;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.sb.length();
    }

    public XmlStringBuilder openElement(String str) {
        halfOpenElement(str).rightAngleBracket();
        return this;
    }

    public XmlStringBuilder optAppend(CharSequence charSequence) {
        if (charSequence != null) {
            append(charSequence);
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, String str2) {
        if (str2 != null) {
            attribute(str, str2);
        }
        return this;
    }

    public XmlStringBuilder optBooleanAttribute(String str, boolean z) {
        if (z) {
            this.sb.append(' ').append((CharSequence) str).append((CharSequence) "='true'");
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, String str2) {
        if (str2 != null) {
            element(str, str2);
        }
        return this;
    }

    public XmlStringBuilder optIntAttribute(String str, int i) {
        if (i >= 0) {
            attribute(str, Integer.toString(i));
        }
        return this;
    }

    public XmlStringBuilder optIntElement(String str, int i) {
        if (i >= 0) {
            element(str, String.valueOf(i));
        }
        return this;
    }

    public XmlStringBuilder optLongAttribute(String str, Long l) {
        if (l != null && l.longValue() >= 0) {
            attribute(str, Long.toString(l.longValue()));
        }
        return this;
    }

    public XmlStringBuilder prelude(ExtensionElement extensionElement) {
        return prelude(extensionElement.getElementName(), extensionElement.getNamespace());
    }

    @Deprecated
    public XmlStringBuilder rightAngelBracket() {
        return rightAngleBracket();
    }

    public XmlStringBuilder rightAngleBracket() {
        this.sb.append((CharSequence) RIGHT_ANGLE_BRACKET);
        return this;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.sb.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.sb.toString();
    }

    public XmlStringBuilder xmllangAttribute(String str) {
        optAttribute("xml:lang", str);
        return this;
    }

    public XmlStringBuilder xmlnsAttribute(String str) {
        optAttribute("xmlns", str);
        return this;
    }

    public XmlStringBuilder emptyElement(String str) {
        halfOpenElement(str);
        return closeEmptyElement();
    }

    public XmlStringBuilder halfOpenElement(NamedElement namedElement) {
        return halfOpenElement(namedElement.getElementName());
    }

    public XmlStringBuilder optAppend(Element element) {
        if (element != null) {
            append(element.toXML());
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, Enum<?> r2) {
        if (r2 != null) {
            attribute(str, r2.toString());
        }
        return this;
    }

    public XmlStringBuilder optElement(Element element) {
        if (element != null) {
            append(element.toXML());
        }
        return this;
    }

    public XmlStringBuilder prelude(String str, String str2) {
        halfOpenElement(str);
        xmlnsAttribute(str2);
        return this;
    }

    public XmlStringBuilder(ExtensionElement extensionElement) {
        this();
        prelude(extensionElement);
    }

    public XmlStringBuilder closeElement(NamedElement namedElement) {
        closeElement(namedElement.getElementName());
        return this;
    }

    public XmlStringBuilder optElement(String str, Enum<?> r2) {
        if (r2 != null) {
            element(str, r2);
        }
        return this;
    }

    public XmlStringBuilder append(XmlStringBuilder xmlStringBuilder) {
        this.sb.append(xmlStringBuilder.sb);
        return this;
    }

    public XmlStringBuilder attribute(String str, Enum<?> r2) {
        attribute(str, r2.name());
        return this;
    }

    public XmlStringBuilder element(String str, Enum<?> r2) {
        element(str, r2.name());
        return this;
    }

    public XmlStringBuilder(NamedElement namedElement) {
        this();
        halfOpenElement(namedElement.getElementName());
    }

    public XmlStringBuilder append(Collection<? extends Element> collection) {
        Iterator<? extends Element> it = collection.iterator();
        while (it.hasNext()) {
            append(it.next().toXML());
        }
        return this;
    }

    public XmlStringBuilder attribute(String str, int i) {
        return attribute(str, String.valueOf(i));
    }

    public XmlStringBuilder element(Element element) {
        return append(element.toXML());
    }

    @Override // java.lang.Appendable
    public XmlStringBuilder append(CharSequence charSequence) {
        this.sb.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public XmlStringBuilder append(CharSequence charSequence, int i, int i2) {
        this.sb.append(charSequence, i, i2);
        return this;
    }

    @Override // java.lang.Appendable
    public XmlStringBuilder append(char c) {
        this.sb.append(c);
        return this;
    }
}
