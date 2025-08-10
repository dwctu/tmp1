package org.jivesoftware.smackx.pubsub;

import com.epicgames.unreal.psoservices.PSOProgramService;

/* loaded from: classes5.dex */
public class Subscription extends NodeExtension {
    public boolean configRequired;
    public String id;
    public String jid;
    public State state;

    public enum State {
        subscribed,
        unconfigured,
        pending,
        none
    }

    public Subscription(String str) {
        this(str, null, null, null);
    }

    private void appendAttribute(StringBuilder sb, String str, String str2) {
        sb.append(" ");
        sb.append(str);
        sb.append("='");
        sb.append(str2);
        sb.append("'");
    }

    public String getId() {
        return this.id;
    }

    public String getJid() {
        return this.jid;
    }

    public State getState() {
        return this.state;
    }

    public boolean isConfigRequired() {
        return this.configRequired;
    }

    public Subscription(String str, String str2) {
        this(str, str2, null, null);
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension, org.jivesoftware.smack.packet.Element
    public String toXML() {
        StringBuilder sb = new StringBuilder("<subscription");
        appendAttribute(sb, PSOProgramService.JobID_Key, this.jid);
        if (getNode() != null) {
            appendAttribute(sb, "node", getNode());
        }
        String str = this.id;
        if (str != null) {
            appendAttribute(sb, "subid", str);
        }
        State state = this.state;
        if (state != null) {
            appendAttribute(sb, "subscription", state.toString());
        }
        sb.append("/>");
        return sb.toString();
    }

    public Subscription(String str, String str2, String str3, State state) {
        super(PubSubElementType.SUBSCRIPTION, str2);
        this.configRequired = false;
        this.jid = str;
        this.id = str3;
        this.state = state;
    }

    public Subscription(String str, String str2, String str3, State state, boolean z) {
        super(PubSubElementType.SUBSCRIPTION, str2);
        this.configRequired = false;
        this.jid = str;
        this.id = str3;
        this.state = state;
        this.configRequired = z;
    }
}
