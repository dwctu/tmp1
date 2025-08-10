package org.jivesoftware.smackx.jiveproperties.packet;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.ExtensionElement;

/* loaded from: classes5.dex */
public class JivePropertiesExtension implements ExtensionElement {
    public static final String ELEMENT = "properties";
    private static final Logger LOGGER = Logger.getLogger(JivePropertiesExtension.class.getName());
    public static final String NAMESPACE = "http://www.jivesoftware.com/xmlns/xmpp/properties";
    private final Map<String, Object> properties;

    public JivePropertiesExtension() {
        this.properties = new HashMap();
    }

    public synchronized void deleteProperty(String str) {
        Map<String, Object> map = this.properties;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public synchronized Map<String, Object> getProperties() {
        if (this.properties == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new HashMap(this.properties));
    }

    public synchronized Object getProperty(String str) {
        Map<String, Object> map = this.properties;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized Collection<String> getPropertyNames() {
        if (this.properties == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.properties.keySet()));
    }

    public synchronized void setProperty(String str, Object obj) {
        if (!(obj instanceof Serializable)) {
            throw new IllegalArgumentException("Value must be serialiazble");
        }
        this.properties.put(str, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[SYNTHETIC] */
    @Override // org.jivesoftware.smack.packet.Element
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence toXML() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension.toXML():java.lang.CharSequence");
    }

    public JivePropertiesExtension(Map<String, Object> map) {
        this.properties = map;
    }
}
