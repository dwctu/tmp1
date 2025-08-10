package org.jivesoftware.smackx.filetransfer;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.filetransfer.FileTransferException;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* loaded from: classes5.dex */
public class FileTransferNegotiator extends Manager {
    public static boolean IBB_ONLY = false;
    public static final String SI_NAMESPACE = "http://jabber.org/protocol/si";
    public static final String STREAM_DATA_FIELD_NAME = "stream-method";
    private static final String STREAM_INIT_PREFIX = "jsi_";
    private final StreamNegotiator byteStreamTransferManager;
    private final StreamNegotiator inbandTransferManager;
    public static final String SI_PROFILE_FILE_TRANSFER_NAMESPACE = "http://jabber.org/protocol/si/profile/file-transfer";
    private static final String[] NAMESPACE = {"http://jabber.org/protocol/si", SI_PROFILE_FILE_TRANSFER_NAMESPACE};
    private static final Map<XMPPConnection, FileTransferNegotiator> INSTANCES = new WeakHashMap();
    private static final Random randomGenerator = new Random();

    static {
        IBB_ONLY = System.getProperty("ibb") != null;
    }

    private FileTransferNegotiator(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.byteStreamTransferManager = new Socks5TransferNegotiator(xMPPConnection);
        this.inbandTransferManager = new IBBTransferNegotiator(xMPPConnection);
        setServiceEnabled(xMPPConnection, true);
    }

    private DataForm createDefaultInitiationForm() {
        DataForm dataForm = new DataForm(DataForm.Type.form);
        FormField formField = new FormField(STREAM_DATA_FIELD_NAME);
        formField.setType(FormField.Type.list_single);
        if (!IBB_ONLY) {
            formField.addOption(new FormField.Option(Bytestream.NAMESPACE));
        }
        formField.addOption(new FormField.Option("http://jabber.org/protocol/ibb"));
        dataForm.addField(formField);
        return dataForm;
    }

    public static synchronized FileTransferNegotiator getInstanceFor(XMPPConnection xMPPConnection) {
        FileTransferNegotiator fileTransferNegotiator;
        Map<XMPPConnection, FileTransferNegotiator> map = INSTANCES;
        fileTransferNegotiator = map.get(xMPPConnection);
        if (fileTransferNegotiator == null) {
            fileTransferNegotiator = new FileTransferNegotiator(xMPPConnection);
            map.put(xMPPConnection, fileTransferNegotiator);
        }
        return fileTransferNegotiator;
    }

    private StreamNegotiator getNegotiator(FormField formField) throws FileTransferException.NoAcceptableTransferMechanisms {
        Iterator<FormField.Option> it = formField.getOptions().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            String value = it.next().getValue();
            if (value.equals(Bytestream.NAMESPACE) && !IBB_ONLY) {
                z = true;
            } else if (value.equals("http://jabber.org/protocol/ibb")) {
                z2 = true;
            }
        }
        if (z || z2) {
            return (z && z2) ? new FaultTolerantNegotiator(connection(), this.byteStreamTransferManager, this.inbandTransferManager) : z ? this.byteStreamTransferManager : this.inbandTransferManager;
        }
        throw new FileTransferException.NoAcceptableTransferMechanisms();
    }

    private StreamNegotiator getOutgoingNegotiator(FormField formField) throws FileTransferException.NoAcceptableTransferMechanisms {
        boolean z = false;
        boolean z2 = false;
        for (String str : formField.getValues()) {
            if (str.equals(Bytestream.NAMESPACE) && !IBB_ONLY) {
                z = true;
            } else if (str.equals("http://jabber.org/protocol/ibb")) {
                z2 = true;
            }
        }
        if (z || z2) {
            return (z && z2) ? new FaultTolerantNegotiator(connection(), this.byteStreamTransferManager, this.inbandTransferManager) : z ? this.byteStreamTransferManager : this.inbandTransferManager;
        }
        throw new FileTransferException.NoAcceptableTransferMechanisms();
    }

    private FormField getStreamMethodField(DataForm dataForm) {
        for (FormField formField : dataForm.getFields()) {
            if (formField.getVariable().equals(STREAM_DATA_FIELD_NAME)) {
                return formField;
            }
        }
        return null;
    }

    public static Collection<String> getSupportedProtocols() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static boolean isServiceEnabled(XMPPConnection xMPPConnection) {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(NAMESPACE));
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!instanceFor.includesFeature((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static void setServiceEnabled(XMPPConnection xMPPConnection, boolean z) {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(NAMESPACE));
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        for (String str : arrayList) {
            if (z) {
                instanceFor.addFeature(str);
            } else {
                instanceFor.removeFeature(str);
            }
        }
    }

    public String getNextStreamID() {
        return STREAM_INIT_PREFIX + Math.abs(randomGenerator.nextLong());
    }

    public StreamNegotiator negotiateOutgoingTransfer(String str, String str2, String str3, long j, String str4, int i) throws SmackException.NotConnectedException, SmackException.NoResponseException, FileTransferException.NoAcceptableTransferMechanisms, XMPPException.XMPPErrorException {
        StreamInitiation streamInitiation = new StreamInitiation();
        streamInitiation.setSessionID(str2);
        streamInitiation.setMimeType(URLConnection.guessContentTypeFromName(str3));
        StreamInitiation.File file = new StreamInitiation.File(str3, j);
        file.setDesc(str4);
        streamInitiation.setFile(file);
        streamInitiation.setFeatureNegotiationForm(createDefaultInitiationForm());
        streamInitiation.setFrom(connection().getUser());
        streamInitiation.setTo(str);
        streamInitiation.setType(IQ.Type.set);
        Stanza stanzaNextResultOrThrow = connection().createPacketCollectorAndSend(streamInitiation).nextResultOrThrow(i);
        if (!(stanzaNextResultOrThrow instanceof IQ)) {
            return null;
        }
        IQ iq = (IQ) stanzaNextResultOrThrow;
        if (iq.getType().equals(IQ.Type.result)) {
            return getOutgoingNegotiator(getStreamMethodField(((StreamInitiation) stanzaNextResultOrThrow).getFeatureNegotiationForm()));
        }
        throw new XMPPException.XMPPErrorException(iq.getError());
    }

    public StreamNegotiator selectStreamNegotiator(FileTransferRequest fileTransferRequest) throws SmackException.NotConnectedException, FileTransferException.NoAcceptableTransferMechanisms, FileTransferException.NoStreamMethodsOfferedException {
        StreamInitiation streamInitiation = fileTransferRequest.getStreamInitiation();
        FormField streamMethodField = getStreamMethodField(streamInitiation.getFeatureNegotiationForm());
        if (streamMethodField == null) {
            connection().sendStanza(IQ.createErrorResponse(streamInitiation, XMPPError.from(XMPPError.Condition.bad_request, "No stream methods contained in stanza.")));
            throw new FileTransferException.NoStreamMethodsOfferedException();
        }
        try {
            return getNegotiator(streamMethodField);
        } catch (FileTransferException.NoAcceptableTransferMechanisms e) {
            connection().sendStanza(IQ.createErrorResponse(streamInitiation, XMPPError.from(XMPPError.Condition.bad_request, "No acceptable transfer mechanism")));
            throw e;
        }
    }
}
