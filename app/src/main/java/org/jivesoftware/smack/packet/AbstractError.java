package org.jivesoftware.smack.packet;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class AbstractError {
    public final Map<String, String> descriptiveTexts;
    private final List<ExtensionElement> extensions;
    private final String textNamespace;

    public AbstractError(Map<String, String> map) {
        this(map, null);
    }

    public void addDescriptiveTextsAndExtensions(XmlStringBuilder xmlStringBuilder) {
        for (Map.Entry<String, String> entry : this.descriptiveTexts.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            xmlStringBuilder.halfOpenElement("text").xmlnsAttribute(this.textNamespace).xmllangAttribute(key).rightAngleBracket();
            xmlStringBuilder.escape(value);
            xmlStringBuilder.closeElement("text");
        }
        Iterator<ExtensionElement> it = this.extensions.iterator();
        while (it.hasNext()) {
            xmlStringBuilder.append(it.next().toXML());
        }
    }

    public String getDescriptiveText() {
        String descriptiveText = getDescriptiveText(Locale.getDefault().getLanguage());
        return descriptiveText == null ? getDescriptiveText("") : descriptiveText;
    }

    public <PE extends ExtensionElement> PE getExtension(String str, String str2) {
        return (PE) PacketUtil.extensionElementFrom(this.extensions, str, str2);
    }

    public AbstractError(Map<String, String> map, List<ExtensionElement> list) {
        this(map, null, list);
    }

    public AbstractError(Map<String, String> map, String str, List<ExtensionElement> list) {
        if (map != null) {
            this.descriptiveTexts = map;
        } else {
            this.descriptiveTexts = Collections.emptyMap();
        }
        this.textNamespace = str;
        if (list != null) {
            this.extensions = list;
        } else {
            this.extensions = Collections.emptyList();
        }
    }

    public String getDescriptiveText(String str) {
        return this.descriptiveTexts.get(str);
    }
}
