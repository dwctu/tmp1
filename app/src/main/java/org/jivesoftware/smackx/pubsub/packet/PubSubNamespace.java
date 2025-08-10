package org.jivesoftware.smackx.pubsub.packet;

import java.util.Locale;

/* loaded from: classes5.dex */
public enum PubSubNamespace {
    BASIC(null),
    ERROR("errors"),
    EVENT("event"),
    OWNER("owner");

    private String fragment;

    PubSubNamespace(String str) {
        this.fragment = str;
    }

    public static PubSubNamespace valueOfFromXmlns(String str) {
        return str.lastIndexOf(35) != -1 ? valueOf(str.substring(str.lastIndexOf(35) + 1).toUpperCase(Locale.US)) : BASIC;
    }

    public String getFragment() {
        return this.fragment;
    }

    public String getXmlns() {
        if (this.fragment == null) {
            return "http://jabber.org/protocol/pubsub";
        }
        return "http://jabber.org/protocol/pubsub#" + this.fragment;
    }
}
