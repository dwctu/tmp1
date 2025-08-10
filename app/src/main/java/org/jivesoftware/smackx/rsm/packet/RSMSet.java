package org.jivesoftware.smackx.rsm.packet;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class RSMSet implements ExtensionElement {
    public static final String ELEMENT = "set";
    public static final String NAMESPACE = "http://jabber.org/protocol/rsm";
    private final String after;
    private final String before;
    private final int count;
    private final int firstIndex;
    private final String firstString;
    private final int index;
    private final String last;
    private final int max;

    /* renamed from: org.jivesoftware.smackx.rsm.packet.RSMSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$rsm$packet$RSMSet$PageDirection;

        static {
            int[] iArr = new int[PageDirection.values().length];
            $SwitchMap$org$jivesoftware$smackx$rsm$packet$RSMSet$PageDirection = iArr;
            try {
                iArr[PageDirection.before.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$rsm$packet$RSMSet$PageDirection[PageDirection.after.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum PageDirection {
        before,
        after
    }

    public RSMSet(int i) {
        this(i, -1);
    }

    public static RSMSet from(Stanza stanza) {
        return (RSMSet) stanza.getExtension(ELEMENT, NAMESPACE);
    }

    public static RSMSet newAfter(String str) {
        return new RSMSet(str, PageDirection.after);
    }

    public static RSMSet newBefore(String str) {
        return new RSMSet(str, PageDirection.before);
    }

    public String getAfter() {
        return this.after;
    }

    public String getBefore() {
        return this.before;
    }

    public int getCount() {
        return this.count;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public String getFirst() {
        return this.firstString;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public int getIndex() {
        return this.index;
    }

    public String getLast() {
        return this.last;
    }

    public int getMax() {
        return this.max;
    }

    @Override // org.jivesoftware.smack.packet.ExtensionElement
    public String getNamespace() {
        return NAMESPACE;
    }

    public RSMSet(int i, int i2) {
        this(null, null, -1, i2, null, i, null, -1);
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(TtmlNode.ANNOTATION_POSITION_AFTER, this.after);
        xmlStringBuilder.optElement(TtmlNode.ANNOTATION_POSITION_BEFORE, this.before);
        xmlStringBuilder.optIntElement("count", this.count);
        if (this.firstString != null) {
            xmlStringBuilder.halfOpenElement("first");
            xmlStringBuilder.optIntAttribute(FirebaseAnalytics.Param.INDEX, this.firstIndex);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((CharSequence) this.firstString);
            xmlStringBuilder.closeElement("first");
        }
        xmlStringBuilder.optIntElement(FirebaseAnalytics.Param.INDEX, this.index);
        xmlStringBuilder.optElement("last", this.last);
        xmlStringBuilder.optIntElement("max", this.max);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public RSMSet(String str, PageDirection pageDirection) {
        this(-1, str, pageDirection);
    }

    public RSMSet(int i, String str, PageDirection pageDirection) {
        int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$rsm$packet$RSMSet$PageDirection[pageDirection.ordinal()];
        if (i2 == 1) {
            this.before = str;
            this.after = null;
        } else if (i2 == 2) {
            this.before = null;
            this.after = str;
        } else {
            throw new AssertionError();
        }
        this.count = -1;
        this.index = -1;
        this.last = null;
        this.max = i;
        this.firstString = null;
        this.firstIndex = -1;
    }

    public RSMSet(String str, String str2, int i, int i2, String str3, int i3, String str4, int i4) {
        this.after = str;
        this.before = str2;
        this.count = i;
        this.index = i2;
        this.last = str3;
        this.max = i3;
        this.firstString = str4;
        this.firstIndex = i4;
    }
}
