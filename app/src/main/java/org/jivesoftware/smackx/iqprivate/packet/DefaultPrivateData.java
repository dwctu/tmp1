package org.jivesoftware.smackx.iqprivate.packet;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class DefaultPrivateData implements PrivateData {
    private String elementName;
    private Map<String, String> map;
    private String namespace;

    public DefaultPrivateData(String str, String str2) {
        this.elementName = str;
        this.namespace = str2;
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String getElementName() {
        return this.elementName;
    }

    public synchronized Set<String> getNames() {
        Map<String, String> map = this.map;
        if (map == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(map.keySet());
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String getNamespace() {
        return this.namespace;
    }

    public synchronized String getValue(String str) {
        Map<String, String> map = this.map;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized void setValue(String str, String str2) {
        if (this.map == null) {
            this.map = new HashMap();
        }
        this.map.put(str, str2);
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(this.elementName);
        sb.append(" xmlns=\"");
        sb.append(this.namespace);
        sb.append("\">");
        for (String str : getNames()) {
            String value = getValue(str);
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(str);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            sb.append(value);
            sb.append("</");
            sb.append(str);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        }
        sb.append("</");
        sb.append(this.elementName);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }
}
