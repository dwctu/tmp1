package org.jivesoftware.smack.packet;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class StreamOpen extends FullStreamElement {
    public static final String CLIENT_NAMESPACE = "jabber:client";
    public static final String ELEMENT = "stream:stream";
    public static final String SERVER_NAMESPACE = "jabber:server";
    public static final String VERSION = "1.0";
    private final String contentNamespace;
    private final String from;
    private final String id;
    private final String lang;
    private final String to;

    /* renamed from: org.jivesoftware.smack.packet.StreamOpen$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StreamOpen$StreamContentNamespace;

        static {
            int[] iArr = new int[StreamContentNamespace.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$StreamOpen$StreamContentNamespace = iArr;
            try {
                iArr[StreamContentNamespace.client.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$StreamOpen$StreamContentNamespace[StreamContentNamespace.server.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum StreamContentNamespace {
        client,
        server
    }

    public StreamOpen(CharSequence charSequence) {
        this(charSequence, null, null, null, StreamContentNamespace.client);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return this.contentNamespace;
    }

    public StreamOpen(CharSequence charSequence, CharSequence charSequence2, String str) {
        this(charSequence, charSequence2, str, "en", StreamContentNamespace.client);
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("to", this.to);
        xmlStringBuilder.attribute("xmlns:stream", "http://etherx.jabber.org/streams");
        xmlStringBuilder.attribute("version", "1.0");
        xmlStringBuilder.optAttribute("from", this.from);
        xmlStringBuilder.optAttribute(TtmlNode.ATTR_ID, this.id);
        xmlStringBuilder.xmllangAttribute(this.lang);
        xmlStringBuilder.rightAngleBracket();
        return xmlStringBuilder;
    }

    public StreamOpen(CharSequence charSequence, CharSequence charSequence2, String str, String str2, StreamContentNamespace streamContentNamespace) {
        this.to = StringUtils.maybeToString(charSequence);
        this.from = StringUtils.maybeToString(charSequence2);
        this.id = str;
        this.lang = str2;
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$StreamOpen$StreamContentNamespace[streamContentNamespace.ordinal()];
        if (i == 1) {
            this.contentNamespace = "jabber:client";
        } else {
            if (i == 2) {
                this.contentNamespace = SERVER_NAMESPACE;
                return;
            }
            throw new IllegalStateException();
        }
    }
}
