package org.jivesoftware.smackx.filetransfer;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smackx.si.packet.StreamInitiation;

/* loaded from: classes5.dex */
public class FileTransferRequest {
    private final FileTransferManager manager;
    private final StreamInitiation streamInitiation;

    public FileTransferRequest(FileTransferManager fileTransferManager, StreamInitiation streamInitiation) {
        this.streamInitiation = streamInitiation;
        this.manager = fileTransferManager;
    }

    public IncomingFileTransfer accept() {
        return this.manager.createIncomingFileTransfer(this);
    }

    public String getDescription() {
        return this.streamInitiation.getFile().getDesc();
    }

    public String getFileName() {
        return this.streamInitiation.getFile().getName();
    }

    public long getFileSize() {
        return this.streamInitiation.getFile().getSize();
    }

    public String getMimeType() {
        return this.streamInitiation.getMimeType();
    }

    public String getRequestor() {
        return this.streamInitiation.getFrom();
    }

    public String getStreamID() {
        return this.streamInitiation.getSessionID();
    }

    public StreamInitiation getStreamInitiation() {
        return this.streamInitiation;
    }

    public void reject() throws SmackException.NotConnectedException {
        this.manager.rejectIncomingFileTransfer(this);
    }
}
