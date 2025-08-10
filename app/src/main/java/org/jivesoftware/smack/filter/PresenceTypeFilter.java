package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.util.Objects;

/* loaded from: classes5.dex */
public class PresenceTypeFilter extends FlexibleStanzaTypeFilter<Presence> {
    private final Presence.Type type;
    public static final PresenceTypeFilter AVAILABLE = new PresenceTypeFilter(Presence.Type.available);
    public static final PresenceTypeFilter UNAVAILABLE = new PresenceTypeFilter(Presence.Type.unavailable);
    public static final PresenceTypeFilter SUBSCRIBE = new PresenceTypeFilter(Presence.Type.subscribe);
    public static final PresenceTypeFilter SUBSCRIBED = new PresenceTypeFilter(Presence.Type.subscribed);
    public static final PresenceTypeFilter UNSUBSCRIBE = new PresenceTypeFilter(Presence.Type.unsubscribe);
    public static final PresenceTypeFilter UNSUBSCRIBED = new PresenceTypeFilter(Presence.Type.unsubscribed);
    public static final PresenceTypeFilter ERROR = new PresenceTypeFilter(Presence.Type.error);
    public static final PresenceTypeFilter PROBE = new PresenceTypeFilter(Presence.Type.probe);

    private PresenceTypeFilter(Presence.Type type) {
        super(Presence.class);
        this.type = (Presence.Type) Objects.requireNonNull(type, "type must not be null");
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName() + ": type=" + this.type;
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Presence presence) {
        return presence.getType() == this.type;
    }
}
