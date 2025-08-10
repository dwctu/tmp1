package org.jivesoftware.smackx.filetransfer;

import java.io.InputStream;
import java.io.OutputStream;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.EventManger;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* loaded from: classes5.dex */
public abstract class StreamNegotiator {
    public static final EventManger<String, IQ, SmackException.NotConnectedException> initationSetEvents = new EventManger<>();

    public static StreamInitiation createInitiationAccept(StreamInitiation streamInitiation, String[] strArr) {
        StreamInitiation streamInitiation2 = new StreamInitiation();
        streamInitiation2.setTo(streamInitiation.getFrom());
        streamInitiation2.setFrom(streamInitiation.getTo());
        streamInitiation2.setType(IQ.Type.result);
        streamInitiation2.setStanzaId(streamInitiation.getStanzaId());
        DataForm dataForm = new DataForm(DataForm.Type.submit);
        FormField formField = new FormField(FileTransferNegotiator.STREAM_DATA_FIELD_NAME);
        for (String str : strArr) {
            formField.addValue(str);
        }
        dataForm.addField(formField);
        streamInitiation2.setFeatureNegotiationForm(dataForm);
        return streamInitiation2;
    }

    public static void signal(String str, IQ iq) {
        initationSetEvents.signalEvent(str, iq);
    }

    public abstract InputStream createIncomingStream(StreamInitiation streamInitiation) throws SmackException, InterruptedException, XMPPException.XMPPErrorException;

    public abstract OutputStream createOutgoingStream(String str, String str2, String str3) throws SmackException, XMPPException;

    public abstract String[] getNamespaces();

    public final IQ initiateIncomingStream(final XMPPConnection xMPPConnection, StreamInitiation streamInitiation) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        final StreamInitiation streamInitiationCreateInitiationAccept = createInitiationAccept(streamInitiation, getNamespaces());
        newStreamInitiation(streamInitiation.getFrom(), streamInitiation.getSessionID());
        try {
            IQ iqPerformActionAndWaitForEvent = initationSetEvents.performActionAndWaitForEvent(streamInitiation.getFrom().toString() + '\t' + streamInitiation.getSessionID(), xMPPConnection.getPacketReplyTimeout(), new EventManger.Callback<SmackException.NotConnectedException>() { // from class: org.jivesoftware.smackx.filetransfer.StreamNegotiator.1
                @Override // org.jivesoftware.smack.util.EventManger.Callback
                public void action() throws SmackException.NotConnectedException {
                    xMPPConnection.sendStanza(streamInitiationCreateInitiationAccept);
                }
            });
            if (iqPerformActionAndWaitForEvent == null) {
                throw SmackException.NoResponseException.newWith(xMPPConnection);
            }
            XMPPException.XMPPErrorException.ifHasErrorThenThrow(iqPerformActionAndWaitForEvent);
            return iqPerformActionAndWaitForEvent;
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public abstract InputStream negotiateIncomingStream(Stanza stanza) throws SmackException, InterruptedException, XMPPException.XMPPErrorException;

    public abstract void newStreamInitiation(String str, String str2);
}
