package org.jivesoftware.smackx.privacy.packet;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.jivesoftware.smack.util.NumberUtil;

/* loaded from: classes5.dex */
public class PrivacyItem {
    public static final String SUBSCRIPTION_BOTH = "both";
    public static final String SUBSCRIPTION_FROM = "from";
    public static final String SUBSCRIPTION_NONE = "none";
    public static final String SUBSCRIPTION_TO = "to";
    private final boolean allow;
    private boolean filterIQ;
    private boolean filterMessage;
    private boolean filterPresenceIn;
    private boolean filterPresenceOut;
    private final long order;
    private final Type type;
    private final String value;

    public enum Type {
        group,
        jid,
        subscription
    }

    public PrivacyItem(boolean z, long j) {
        this(null, null, z, j);
    }

    public long getOrder() {
        return this.order;
    }

    public Type getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isAllow() {
        return this.allow;
    }

    public boolean isFilterEverything() {
        return (isFilterIQ() || isFilterMessage() || isFilterPresenceIn() || isFilterPresenceOut()) ? false : true;
    }

    public boolean isFilterIQ() {
        return this.filterIQ;
    }

    public boolean isFilterMessage() {
        return this.filterMessage;
    }

    public boolean isFilterPresenceIn() {
        return this.filterPresenceIn;
    }

    public boolean isFilterPresenceOut() {
        return this.filterPresenceOut;
    }

    public void setFilterIQ(boolean z) {
        this.filterIQ = z;
    }

    public void setFilterMessage(boolean z) {
        this.filterMessage = z;
    }

    public void setFilterPresenceIn(boolean z) {
        this.filterPresenceIn = z;
    }

    public void setFilterPresenceOut(boolean z) {
        this.filterPresenceOut = z;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<item");
        if (isAllow()) {
            sb.append(" action=\"allow\"");
        } else {
            sb.append(" action=\"deny\"");
        }
        sb.append(" order=\"");
        sb.append(getOrder());
        sb.append("\"");
        if (getType() != null) {
            sb.append(" type=\"");
            sb.append(getType());
            sb.append("\"");
        }
        if (getValue() != null) {
            sb.append(" value=\"");
            sb.append(getValue());
            sb.append("\"");
        }
        if (isFilterEverything()) {
            sb.append("/>");
        } else {
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            if (isFilterIQ()) {
                sb.append("<iq/>");
            }
            if (isFilterMessage()) {
                sb.append("<message/>");
            }
            if (isFilterPresenceIn()) {
                sb.append("<presence-in/>");
            }
            if (isFilterPresenceOut()) {
                sb.append("<presence-out/>");
            }
            sb.append("</item>");
        }
        return sb.toString();
    }

    public PrivacyItem(Type type, String str, boolean z, long j) {
        this.filterIQ = false;
        this.filterMessage = false;
        this.filterPresenceIn = false;
        this.filterPresenceOut = false;
        NumberUtil.checkIfInUInt32Range(j);
        this.type = type;
        this.value = str;
        this.allow = z;
        this.order = j;
    }
}
