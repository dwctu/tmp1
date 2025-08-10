package org.jivesoftware.smackx.bytestreams.socks5.packet;

import com.epicgames.unreal.psoservices.PSOProgramService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class Bytestream extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/bytestreams";
    private Mode mode;
    private String sessionID;
    private final List<StreamHost> streamHosts;
    private Activate toActivate;
    private StreamHostUsed usedHost;

    /* renamed from: org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream$1, reason: invalid class name */
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
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.get.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Activate implements NamedElement {
        public static String ELEMENTNAME = "activate";
        private final String target;

        public Activate(String str) {
            this.target = str;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENTNAME;
        }

        public String getTarget() {
            return this.target;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(getTarget());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }

    public enum Mode {
        tcp,
        udp;

        public static Mode fromName(String str) {
            try {
                return valueOf(str);
            } catch (Exception unused) {
                return tcp;
            }
        }
    }

    public static class StreamHost implements NamedElement {
        public static String ELEMENTNAME = "streamhost";
        private final String JID;
        private final String addy;
        private final int port;

        public StreamHost(String str, String str2) {
            this(str, str2, 0);
        }

        public String getAddress() {
            return this.addy;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENTNAME;
        }

        public String getJID() {
            return this.JID;
        }

        public int getPort() {
            return this.port;
        }

        public StreamHost(String str, String str2, int i) {
            this.JID = str;
            this.addy = str2;
            this.port = i;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.attribute(PSOProgramService.JobID_Key, getJID());
            xmlStringBuilder.attribute("host", getAddress());
            if (getPort() != 0) {
                xmlStringBuilder.attribute("port", Integer.toString(getPort()));
            } else {
                xmlStringBuilder.attribute("zeroconf", "_jabber.bytestreams");
            }
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class StreamHostUsed implements NamedElement {
        public static String ELEMENTNAME = "streamhost-used";
        private final String JID;

        public StreamHostUsed(String str) {
            this.JID = str;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENTNAME;
        }

        public String getJID() {
            return this.JID;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.attribute(PSOProgramService.JobID_Key, getJID());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public Bytestream() {
        super("query", NAMESPACE);
        this.mode = Mode.tcp;
        this.streamHosts = new ArrayList();
    }

    public StreamHost addStreamHost(String str, String str2) {
        return addStreamHost(str, str2, 0);
    }

    public int countStreamHosts() {
        return this.streamHosts.size();
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[getType().ordinal()];
        if (i == 1) {
            iQChildElementXmlStringBuilder.optAttribute(PSOProgramService.ServiceID_Key, getSessionID());
            iQChildElementXmlStringBuilder.optAttribute("mode", getMode());
            iQChildElementXmlStringBuilder.rightAngleBracket();
            if (getToActivate() == null) {
                Iterator<StreamHost> it = getStreamHosts().iterator();
                while (it.hasNext()) {
                    iQChildElementXmlStringBuilder.append(it.next().toXML());
                }
            } else {
                iQChildElementXmlStringBuilder.append(getToActivate().toXML());
            }
        } else if (i == 2) {
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.optAppend(getUsedHost());
            Iterator<StreamHost> it2 = this.streamHosts.iterator();
            while (it2.hasNext()) {
                iQChildElementXmlStringBuilder.append(it2.next().toXML());
            }
        } else {
            if (i != 3) {
                throw new IllegalStateException();
            }
            iQChildElementXmlStringBuilder.setEmptyElement();
        }
        return iQChildElementXmlStringBuilder;
    }

    public Mode getMode() {
        return this.mode;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public StreamHost getStreamHost(String str) {
        if (str == null) {
            return null;
        }
        for (StreamHost streamHost : this.streamHosts) {
            if (streamHost.getJID().equals(str)) {
                return streamHost;
            }
        }
        return null;
    }

    public List<StreamHost> getStreamHosts() {
        return Collections.unmodifiableList(this.streamHosts);
    }

    public Activate getToActivate() {
        return this.toActivate;
    }

    public StreamHostUsed getUsedHost() {
        return this.usedHost;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setToActivate(String str) {
        this.toActivate = new Activate(str);
    }

    public void setUsedHost(String str) {
        this.usedHost = new StreamHostUsed(str);
    }

    public StreamHost addStreamHost(String str, String str2, int i) {
        StreamHost streamHost = new StreamHost(str, str2, i);
        addStreamHost(streamHost);
        return streamHost;
    }

    public Bytestream(String str) {
        this();
        setSessionID(str);
    }

    public void addStreamHost(StreamHost streamHost) {
        this.streamHosts.add(streamHost);
    }
}
