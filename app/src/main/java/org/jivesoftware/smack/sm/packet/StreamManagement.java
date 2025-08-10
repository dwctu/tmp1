package org.jivesoftware.smack.sm.packet;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullStreamElement;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes5.dex */
public class StreamManagement {
    public static final String NAMESPACE = "urn:xmpp:sm:3";

    public static abstract class AbstractEnable extends FullStreamElement {
        public int max;
        public boolean resume;

        private AbstractEnable() {
            this.max = -1;
            this.resume = false;
        }

        public int getMaxResumptionTime() {
            return this.max;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public final String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public boolean isResumeSet() {
            return this.resume;
        }

        public void maybeAddMaxAttributeTo(XmlStringBuilder xmlStringBuilder) {
            int i = this.max;
            if (i > 0) {
                xmlStringBuilder.attribute("max", Integer.toString(i));
            }
        }

        public void maybeAddResumeAttributeTo(XmlStringBuilder xmlStringBuilder) {
            if (this.resume) {
                xmlStringBuilder.attribute(Resume.ELEMENT, "true");
            }
        }
    }

    public static abstract class AbstractResume extends FullStreamElement {
        private final long handledCount;
        private final String previd;

        public AbstractResume(long j, String str) {
            this.handledCount = j;
            this.previd = str;
        }

        public long getHandledCount() {
            return this.handledCount;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public final String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public String getPrevId() {
            return this.previd;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public final XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.attribute(XHTMLText.H, Long.toString(this.handledCount));
            xmlStringBuilder.attribute("previd", this.previd);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class AckAnswer extends FullStreamElement {
        public static final String ELEMENT = "a";
        private final long handledCount;

        public AckAnswer(long j) {
            this.handledCount = j;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "a";
        }

        public long getHandledCount() {
            return this.handledCount;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.attribute(XHTMLText.H, Long.toString(this.handledCount));
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class AckRequest extends FullStreamElement {
        public static final String ELEMENT = "r";
        public static final AckRequest INSTANCE = new AckRequest();

        private AckRequest() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML() {
            return "<r xmlns='urn:xmpp:sm:3'/>";
        }
    }

    public static class Enable extends AbstractEnable {
        public static final String ELEMENT = "enable";
        public static final Enable INSTANCE = new Enable();

        private Enable() {
            super();
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractEnable
        public /* bridge */ /* synthetic */ int getMaxResumptionTime() {
            return super.getMaxResumptionTime();
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractEnable
        public /* bridge */ /* synthetic */ boolean isResumeSet() {
            return super.isResumeSet();
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            maybeAddResumeAttributeTo(xmlStringBuilder);
            maybeAddMaxAttributeTo(xmlStringBuilder);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public Enable(boolean z) {
            super();
            this.resume = z;
        }

        public Enable(boolean z, int i) {
            this(z);
            this.max = i;
        }
    }

    public static class Enabled extends AbstractEnable {
        public static final String ELEMENT = "enabled";
        private final String id;
        private final String location;

        public Enabled(String str, boolean z) {
            this(str, z, null, -1);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        public String getId() {
            return this.id;
        }

        public String getLocation() {
            return this.location;
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractEnable
        public /* bridge */ /* synthetic */ int getMaxResumptionTime() {
            return super.getMaxResumptionTime();
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractEnable
        public /* bridge */ /* synthetic */ boolean isResumeSet() {
            return super.isResumeSet();
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.optAttribute(TtmlNode.ATTR_ID, this.id);
            maybeAddResumeAttributeTo(xmlStringBuilder);
            xmlStringBuilder.optAttribute(FirebaseAnalytics.Param.LOCATION, this.location);
            maybeAddMaxAttributeTo(xmlStringBuilder);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public Enabled(String str, boolean z, String str2, int i) {
            super();
            this.id = str;
            this.resume = z;
            this.location = str2;
            this.max = i;
        }
    }

    public static class Failed extends FullStreamElement {
        public static final String ELEMENT = "failed";
        private XMPPError.Condition condition;

        public Failed() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public XMPPError.Condition getXMPPErrorCondition() {
            return this.condition;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            if (this.condition != null) {
                xmlStringBuilder.rightAngleBracket();
                xmlStringBuilder.append((CharSequence) this.condition.toString());
                xmlStringBuilder.xmlnsAttribute(XMPPError.NAMESPACE);
                xmlStringBuilder.closeElement(ELEMENT);
            } else {
                xmlStringBuilder.closeEmptyElement();
            }
            return xmlStringBuilder;
        }

        public Failed(XMPPError.Condition condition) {
            this.condition = condition;
        }
    }

    public static class Resume extends AbstractResume {
        public static final String ELEMENT = "resume";

        public Resume(long j, String str) {
            super(j, str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractResume
        public /* bridge */ /* synthetic */ long getHandledCount() {
            return super.getHandledCount();
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractResume
        public /* bridge */ /* synthetic */ String getPrevId() {
            return super.getPrevId();
        }
    }

    public static class Resumed extends AbstractResume {
        public static final String ELEMENT = "resumed";

        public Resumed(long j, String str) {
            super(j, str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractResume
        public /* bridge */ /* synthetic */ long getHandledCount() {
            return super.getHandledCount();
        }

        @Override // org.jivesoftware.smack.sm.packet.StreamManagement.AbstractResume
        public /* bridge */ /* synthetic */ String getPrevId() {
            return super.getPrevId();
        }
    }

    public static class StreamManagementFeature implements ExtensionElement {
        public static final String ELEMENT = "sm";
        public static final StreamManagementFeature INSTANCE = new StreamManagementFeature();

        private StreamManagementFeature() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }
}
