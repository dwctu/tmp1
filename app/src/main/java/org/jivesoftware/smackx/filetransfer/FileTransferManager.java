package org.jivesoftware.smackx.filetransfer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class FileTransferManager extends Manager {
    private static final Map<XMPPConnection, FileTransferManager> INSTANCES = new WeakHashMap();
    private final FileTransferNegotiator fileTransferNegotiator;
    private final List<FileTransferListener> listeners;

    private FileTransferManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.listeners = new CopyOnWriteArrayList();
        this.fileTransferNegotiator = FileTransferNegotiator.getInstanceFor(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(StreamInitiation.ELEMENT, "http://jabber.org/protocol/si", IQ.Type.set, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.filetransfer.FileTransferManager.1
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                FileTransferRequest fileTransferRequest = new FileTransferRequest(FileTransferManager.this, (StreamInitiation) iq);
                Iterator it = FileTransferManager.this.listeners.iterator();
                while (it.hasNext()) {
                    ((FileTransferListener) it.next()).fileTransferRequest(fileTransferRequest);
                }
                return null;
            }
        });
    }

    public static synchronized FileTransferManager getInstanceFor(XMPPConnection xMPPConnection) {
        FileTransferManager fileTransferManager;
        Map<XMPPConnection, FileTransferManager> map = INSTANCES;
        fileTransferManager = map.get(xMPPConnection);
        if (fileTransferManager == null) {
            fileTransferManager = new FileTransferManager(xMPPConnection);
            map.put(xMPPConnection, fileTransferManager);
        }
        return fileTransferManager;
    }

    public void addFileTransferListener(FileTransferListener fileTransferListener) {
        this.listeners.add(fileTransferListener);
    }

    public IncomingFileTransfer createIncomingFileTransfer(FileTransferRequest fileTransferRequest) {
        Objects.requireNonNull(fileTransferRequest, "RecieveRequest cannot be null");
        IncomingFileTransfer incomingFileTransfer = new IncomingFileTransfer(fileTransferRequest, this.fileTransferNegotiator);
        incomingFileTransfer.setFileInfo(fileTransferRequest.getFileName(), fileTransferRequest.getFileSize());
        return incomingFileTransfer;
    }

    public OutgoingFileTransfer createOutgoingFileTransfer(String str) {
        if (str == null) {
            throw new IllegalArgumentException("userID was null");
        }
        if (XmppStringUtils.isFullJID(str)) {
            return new OutgoingFileTransfer(connection().getUser(), str, this.fileTransferNegotiator.getNextStreamID(), this.fileTransferNegotiator);
        }
        throw new IllegalArgumentException("The provided user id was not a full JID (i.e. with resource part)");
    }

    public void rejectIncomingFileTransfer(FileTransferRequest fileTransferRequest) throws SmackException.NotConnectedException {
        connection().sendStanza(IQ.createErrorResponse(fileTransferRequest.getStreamInitiation(), new XMPPError(XMPPError.Condition.forbidden)));
    }

    public void removeFileTransferListener(FileTransferListener fileTransferListener) {
        this.listeners.remove(fileTransferListener);
    }
}
