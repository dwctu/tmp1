package org.jivesoftware.smackx.xdata.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.bouncycastle.i18n.MessageBundle;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;

/* loaded from: classes5.dex */
public class DataForm implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "jabber:x:data";
    private ReportedData reportedData;
    private String title;
    private Type type;
    private List<String> instructions = new ArrayList();
    private final List<Item> items = new ArrayList();
    private final List<FormField> fields = new ArrayList();
    private final List<Element> extensionElements = new ArrayList();

    public static class Item {
        public static final String ELEMENT = "item";
        private List<FormField> fields;

        public Item(List<FormField> list) {
            this.fields = new ArrayList();
            this.fields = list;
        }

        public List<FormField> getFields() {
            return Collections.unmodifiableList(new ArrayList(this.fields));
        }

        public CharSequence toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("item");
            Iterator<FormField> it = getFields().iterator();
            while (it.hasNext()) {
                xmlStringBuilder.append(it.next().toXML());
            }
            xmlStringBuilder.closeElement("item");
            return xmlStringBuilder;
        }
    }

    public static class ReportedData {
        public static final String ELEMENT = "reported";
        private List<FormField> fields;

        public ReportedData(List<FormField> list) {
            this.fields = new ArrayList();
            this.fields = list;
        }

        public List<FormField> getFields() {
            return Collections.unmodifiableList(new ArrayList(this.fields));
        }

        public CharSequence toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement(ELEMENT);
            Iterator<FormField> it = getFields().iterator();
            while (it.hasNext()) {
                xmlStringBuilder.append(it.next().toXML());
            }
            xmlStringBuilder.closeElement(ELEMENT);
            return xmlStringBuilder;
        }
    }

    public enum Type {
        form,
        submit,
        cancel,
        result;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public DataForm(Type type) {
        this.type = type;
    }

    public static DataForm from(Stanza stanza) {
        return (DataForm) stanza.getExtension("x", "jabber:x:data");
    }

    public void addExtensionElement(Element element) {
        this.extensionElements.add(element);
    }

    public void addField(FormField formField) {
        String variable = formField.getVariable();
        if (variable == null || getField(variable) == null) {
            synchronized (this.fields) {
                this.fields.add(formField);
            }
        } else {
            throw new IllegalArgumentException("This data form already contains a form field with the variable name '" + variable + "'");
        }
    }

    public void addInstruction(String str) {
        synchronized (this.instructions) {
            this.instructions.add(str);
        }
    }

    public void addItem(Item item) {
        synchronized (this.items) {
            this.items.add(item);
        }
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    public List<Element> getExtensionElements() {
        return Collections.unmodifiableList(this.extensionElements);
    }

    public FormField getField(String str) {
        synchronized (this.fields) {
            for (FormField formField : this.fields) {
                if (str.equals(formField.getVariable())) {
                    return formField;
                }
            }
            return null;
        }
    }

    public List<FormField> getFields() {
        List<FormField> listUnmodifiableList;
        synchronized (this.fields) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.fields));
        }
        return listUnmodifiableList;
    }

    public FormField getHiddenFormTypeField() {
        FormField field = getField(FormField.FORM_TYPE);
        if (field == null || field.getType() != FormField.Type.hidden) {
            return null;
        }
        return field;
    }

    public List<String> getInstructions() {
        List<String> listUnmodifiableList;
        synchronized (this.instructions) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.instructions));
        }
        return listUnmodifiableList;
    }

    public List<Item> getItems() {
        List<Item> listUnmodifiableList;
        synchronized (this.items) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.items));
        }
        return listUnmodifiableList;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return "jabber:x:data";
    }

    public ReportedData getReportedData() {
        return this.reportedData;
    }

    public String getTitle() {
        return this.title;
    }

    public Type getType() {
        return this.type;
    }

    public boolean hasHiddenFormTypeField() {
        return getHiddenFormTypeField() != null;
    }

    public void setInstructions(List<String> list) {
        this.instructions = list;
    }

    public void setReportedData(ReportedData reportedData) {
        this.reportedData = reportedData;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("type", getType());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(MessageBundle.TITLE_ENTRY, getTitle());
        Iterator<String> it = getInstructions().iterator();
        while (it.hasNext()) {
            xmlStringBuilder.element("instructions", it.next());
        }
        if (getReportedData() != null) {
            xmlStringBuilder.append(getReportedData().toXML());
        }
        Iterator<Item> it2 = getItems().iterator();
        while (it2.hasNext()) {
            xmlStringBuilder.append(it2.next().toXML());
        }
        Iterator<FormField> it3 = getFields().iterator();
        while (it3.hasNext()) {
            xmlStringBuilder.append(it3.next().toXML());
        }
        Iterator<Element> it4 = this.extensionElements.iterator();
        while (it4.hasNext()) {
            xmlStringBuilder.append(it4.next().toXML());
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
