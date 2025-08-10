package org.jivesoftware.smackx.si.packet;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.Scopes;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Date;
import java.util.Objects;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.filetransfer.FileTransferNegotiator;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.util.XmppDateTime;

/* loaded from: classes5.dex */
public class StreamInitiation extends IQ {
    public static final String ELEMENT = "si";
    public static final String NAMESPACE = "http://jabber.org/protocol/si";
    private Feature featureNegotiation;
    private File file;
    private String id;
    private String mimeType;

    /* renamed from: org.jivesoftware.smackx.si.packet.StreamInitiation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            int[] iArr = new int[IQ.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr;
            try {
                iArr[IQ.Type.set.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.result.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class Feature implements ExtensionElement {
        private final DataForm data;

        public Feature(DataForm dataForm) {
            this.data = dataForm;
        }

        public DataForm getData() {
            return this.data;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "feature";
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return "http://jabber.org/protocol/feature-neg";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML() {
            return "<feature xmlns=\"http://jabber.org/protocol/feature-neg\">" + ((CharSequence) this.data.toXML()) + "</feature>";
        }
    }

    public static class File implements ExtensionElement {
        private Date date;
        private String desc;
        private String hash;
        private boolean isRanged;
        private final String name;
        private final long size;

        public File(String str, long j) {
            Objects.requireNonNull(str, "name cannot be null");
            this.name = str;
            this.size = j;
        }

        public Date getDate() {
            return this.date;
        }

        public String getDesc() {
            return this.desc;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "file";
        }

        public String getHash() {
            return this.hash;
        }

        public String getName() {
            return this.name;
        }

        @Override // org.jivesoftware.smack.packet.ExtensionElement
        public String getNamespace() {
            return FileTransferNegotiator.SI_PROFILE_FILE_TRANSFER_NAMESPACE;
        }

        public long getSize() {
            return this.size;
        }

        public boolean isRanged() {
            return this.isRanged;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setHash(String str) {
            this.hash = str;
        }

        public void setRanged(boolean z) {
            this.isRanged = z;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML() {
            StringBuilder sb = new StringBuilder();
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(getElementName());
            sb.append(" xmlns=\"");
            sb.append(getNamespace());
            sb.append("\" ");
            if (getName() != null) {
                sb.append("name=\"");
                sb.append(StringUtils.escapeForXML(getName()));
                sb.append("\" ");
            }
            if (getSize() > 0) {
                sb.append("size=\"");
                sb.append(getSize());
                sb.append("\" ");
            }
            if (getDate() != null) {
                sb.append("date=\"");
                sb.append(XmppDateTime.formatXEP0082Date(this.date));
                sb.append("\" ");
            }
            if (getHash() != null) {
                sb.append("hash=\"");
                sb.append(getHash());
                sb.append("\" ");
            }
            String str = this.desc;
            if ((str == null || str.length() <= 0) && !this.isRanged) {
                sb.append("/>");
            } else {
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                if (getDesc() != null && this.desc.length() > 0) {
                    sb.append("<desc>");
                    sb.append(StringUtils.escapeForXML(getDesc()));
                    sb.append("</desc>");
                }
                if (isRanged()) {
                    sb.append("<range/>");
                }
                sb.append("</");
                sb.append(getElementName());
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            }
            return sb.toString();
        }
    }

    public StreamInitiation() {
        super(ELEMENT, "http://jabber.org/protocol/si");
    }

    public DataForm getFeatureNegotiationForm() {
        return this.featureNegotiation.getData();
    }

    public File getFile() {
        return this.file;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[getType().ordinal()];
        if (i == 1) {
            iQChildElementXmlStringBuilder.optAttribute(TtmlNode.ATTR_ID, getSessionID());
            iQChildElementXmlStringBuilder.optAttribute("mime-type", getMimeType());
            iQChildElementXmlStringBuilder.attribute(Scopes.PROFILE, FileTransferNegotiator.SI_PROFILE_FILE_TRANSFER_NAMESPACE);
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.optAppend(this.file.toXML());
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("IQ Type not understood");
            }
            iQChildElementXmlStringBuilder.rightAngleBracket();
        }
        Feature feature = this.featureNegotiation;
        if (feature != null) {
            iQChildElementXmlStringBuilder.append((CharSequence) feature.toXML());
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getSessionID() {
        return this.id;
    }

    public void setFeatureNegotiationForm(DataForm dataForm) {
        this.featureNegotiation = new Feature(dataForm);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setSessionID(String str) {
        this.id = str;
    }
}
