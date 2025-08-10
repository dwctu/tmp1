package org.jivesoftware.smackx.xdatalayout.packet;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class DataLayout implements ExtensionElement {
    public static final String ELEMENT = "page";
    public static final String NAMESPACE = "http://jabber.org/protocol/xdata-layout";
    private final String label;
    private final List<DataFormLayoutElement> pageLayout = new ArrayList();

    public interface DataFormLayoutElement extends NamedElement {
    }

    public static class Fieldref implements DataFormLayoutElement {
        public static final String ELEMENT = "fieldref";
        private final String var;

        public Fieldref(String str) {
            this.var = str;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        public String getVar() {
            return this.var;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.attribute("var", getVar());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class Reportedref implements DataFormLayoutElement {
        public static final String ELEMENT = "reportedref";

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class Section implements DataFormLayoutElement {
        public static final String ELEMENT = "section";
        private final String label;
        private final List<DataFormLayoutElement> sectionLayout = new ArrayList();

        public Section(String str) {
            this.label = str;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        public String getLabel() {
            return this.label;
        }

        public List<DataFormLayoutElement> getSectionLayout() {
            return this.sectionLayout;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.optAttribute(Constants.ScionAnalytics.PARAM_LABEL, getLabel());
            xmlStringBuilder.rightAngleBracket();
            DataLayout.walkList(xmlStringBuilder, getSectionLayout());
            xmlStringBuilder.closeElement(ELEMENT);
            return xmlStringBuilder;
        }
    }

    public static class Text implements DataFormLayoutElement {
        public static final String ELEMENT = "text";
        private final String text;

        public Text(String str) {
            this.text = str;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "text";
        }

        public String getText() {
            return this.text;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.element("text", getText());
            return xmlStringBuilder;
        }
    }

    public DataLayout(String str) {
        this.label = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void walkList(XmlStringBuilder xmlStringBuilder, List<DataFormLayoutElement> list) {
        Iterator<DataFormLayoutElement> it = list.iterator();
        while (it.hasNext()) {
            xmlStringBuilder.append(it.next().toXML());
        }
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public String getLabel() {
        return this.label;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public List<DataFormLayoutElement> getPageLayout() {
        return this.pageLayout;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.optAttribute(Constants.ScionAnalytics.PARAM_LABEL, getLabel());
        xmlStringBuilder.rightAngleBracket();
        walkList(xmlStringBuilder, getPageLayout());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
