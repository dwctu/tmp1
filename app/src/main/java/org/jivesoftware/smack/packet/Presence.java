package org.jivesoftware.smack.packet;

import dc.z22;
import java.util.Locale;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.TypedCloneable;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public final class Presence extends Stanza implements TypedCloneable<Presence> {
    public static final String ELEMENT = "presence";
    private Mode mode;
    private int priority;
    private String status;
    private Type type;

    public enum Mode {
        chat,
        available,
        away,
        xa,
        dnd;

        public static Mode fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public enum Type {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public Presence(Type type) {
        this.type = Type.available;
        this.status = null;
        this.priority = Integer.MIN_VALUE;
        this.mode = null;
        setType(type);
    }

    public Mode getMode() {
        Mode mode = this.mode;
        return mode == null ? Mode.available : mode;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getStatus() {
        return this.status;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isAvailable() {
        return this.type == Type.available;
    }

    public boolean isAway() {
        Mode mode;
        return this.type == Type.available && ((mode = this.mode) == Mode.away || mode == Mode.xa || mode == Mode.dnd);
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setPriority(int i) {
        if (i >= -128 && i <= 128) {
            this.priority = i;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setType(Type type) {
        this.type = (Type) Objects.requireNonNull(type, "Type cannot be null");
    }

    @Override // org.jivesoftware.smack.util.TypedCloneable
    public Presence clone() {
        return new Presence(this);
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement(ELEMENT);
        addCommonAttributes(xmlStringBuilder);
        if (z22.a || this.type != Type.available) {
            xmlStringBuilder.attribute("type", this.type);
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("status", this.status);
        int i = this.priority;
        if (i != Integer.MIN_VALUE) {
            xmlStringBuilder.element("priority", Integer.toString(i));
        }
        Mode mode = this.mode;
        if (mode != null && mode != Mode.available) {
            xmlStringBuilder.element("show", mode);
        }
        xmlStringBuilder.append(getExtensionsXML());
        appendErrorIfExists(xmlStringBuilder);
        xmlStringBuilder.closeElement(ELEMENT);
        return xmlStringBuilder;
    }

    public Presence(Type type, String str, int i, Mode mode) {
        this.type = Type.available;
        this.status = null;
        this.priority = Integer.MIN_VALUE;
        this.mode = null;
        setType(type);
        setStatus(str);
        setPriority(i);
        setMode(mode);
    }

    public Presence(Presence presence) {
        super(presence);
        this.type = Type.available;
        this.status = null;
        this.priority = Integer.MIN_VALUE;
        this.mode = null;
        this.type = presence.type;
        this.status = presence.status;
        this.priority = presence.priority;
        this.mode = presence.mode;
    }
}
