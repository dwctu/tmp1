package org.jivesoftware.smackx.filetransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smackx.filetransfer.FileTransfer;

/* loaded from: classes5.dex */
public class OutgoingFileTransfer extends FileTransfer {
    private static final Logger LOGGER = Logger.getLogger(OutgoingFileTransfer.class.getName());
    private static int RESPONSE_TIMEOUT = 60000;
    private NegotiationProgress callback;
    private String initiator;
    private OutputStream outputStream;
    private Thread transferThread;

    /* renamed from: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$XMPPError$Condition;

        static {
            int[] iArr = new int[XMPPError.Condition.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$XMPPError$Condition = iArr;
            try {
                iArr[XMPPError.Condition.forbidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$XMPPError$Condition[XMPPError.Condition.bad_request.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public interface NegotiationProgress {
        void errorEstablishingStream(Exception exc);

        void outputStreamEstablished(OutputStream outputStream);

        void statusUpdated(FileTransfer.Status status, FileTransfer.Status status2);
    }

    public OutgoingFileTransfer(String str, String str2, String str3, FileTransferNegotiator fileTransferNegotiator) {
        super(str2, str3, fileTransferNegotiator);
        this.initiator = str;
    }

    private void checkTransferThread() {
        Thread thread = this.transferThread;
        if ((thread != null && thread.isAlive()) || isDone()) {
            throw new IllegalStateException("File transfer in progress or has already completed.");
        }
    }

    public static int getResponseTimeout() {
        return RESPONSE_TIMEOUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleXMPPException(XMPPException.XMPPErrorException xMPPErrorException) {
        XMPPError xMPPError = xMPPErrorException.getXMPPError();
        if (xMPPError != null) {
            int i = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$packet$XMPPError$Condition[xMPPError.getCondition().ordinal()];
            if (i == 1) {
                setStatus(FileTransfer.Status.refused);
                return;
            } else if (i != 2) {
                setStatus(FileTransfer.Status.error);
            } else {
                setStatus(FileTransfer.Status.error);
                setError(FileTransfer.Error.not_acceptable);
            }
        }
        setException(xMPPErrorException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OutputStream negotiateStream(String str, long j, String str2) throws SmackException, XMPPException {
        FileTransfer.Status status = FileTransfer.Status.initial;
        FileTransfer.Status status2 = FileTransfer.Status.negotiating_transfer;
        if (!updateStatus(status, status2)) {
            throw new SmackException.IllegalStateChangeException();
        }
        StreamNegotiator streamNegotiatorNegotiateOutgoingTransfer = this.negotiator.negotiateOutgoingTransfer(getPeer(), this.streamID, str, j, str2, RESPONSE_TIMEOUT);
        FileTransfer.Status status3 = FileTransfer.Status.negotiating_stream;
        if (!updateStatus(status2, status3)) {
            throw new SmackException.IllegalStateChangeException();
        }
        this.outputStream = streamNegotiatorNegotiateOutgoingTransfer.createOutgoingStream(this.streamID, this.initiator, getPeer());
        if (updateStatus(status3, FileTransfer.Status.negotiated)) {
            return this.outputStream;
        }
        throw new SmackException.IllegalStateChangeException();
    }

    public static void setResponseTimeout(int i) {
        RESPONSE_TIMEOUT = i;
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    public void cancel() {
        setStatus(FileTransfer.Status.cancelled);
    }

    public long getBytesSent() {
        return this.amountWritten;
    }

    public OutputStream getOutputStream() {
        if (getStatus().equals(FileTransfer.Status.negotiated)) {
            return this.outputStream;
        }
        return null;
    }

    public synchronized OutputStream sendFile(String str, long j, String str2) throws SmackException, XMPPException {
        OutputStream outputStreamNegotiateStream;
        if (isDone() || this.outputStream != null) {
            throw new IllegalStateException("The negotation process has already been attempted on this file transfer");
        }
        try {
            setFileInfo(str, j);
            outputStreamNegotiateStream = negotiateStream(str, j, str2);
            this.outputStream = outputStreamNegotiateStream;
        } catch (XMPPException.XMPPErrorException e) {
            handleXMPPException(e);
            throw e;
        }
        return outputStreamNegotiateStream;
    }

    public synchronized void sendStream(final InputStream inputStream, final String str, final long j, final String str2) {
        checkTransferThread();
        setFileInfo(str, j);
        Thread thread = new Thread(new Runnable() { // from class: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.3
            @Override // java.lang.Runnable
            public void run() throws IOException {
                OutgoingFileTransfer outgoingFileTransfer;
                try {
                    OutgoingFileTransfer outgoingFileTransfer2 = OutgoingFileTransfer.this;
                    outgoingFileTransfer2.outputStream = outgoingFileTransfer2.negotiateStream(str, j, str2);
                } catch (XMPPException.XMPPErrorException e) {
                    OutgoingFileTransfer.this.handleXMPPException(e);
                    return;
                } catch (Exception e2) {
                    OutgoingFileTransfer.this.setException(e2);
                }
                if (OutgoingFileTransfer.this.outputStream == null) {
                    return;
                }
                try {
                    if (OutgoingFileTransfer.this.updateStatus(FileTransfer.Status.negotiated, FileTransfer.Status.in_progress)) {
                        try {
                            OutgoingFileTransfer outgoingFileTransfer3 = OutgoingFileTransfer.this;
                            outgoingFileTransfer3.writeToStream(inputStream, outgoingFileTransfer3.outputStream);
                            InputStream inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            OutgoingFileTransfer.this.outputStream.flush();
                            outgoingFileTransfer = OutgoingFileTransfer.this;
                        } catch (IOException e3) {
                            OutgoingFileTransfer.this.setStatus(FileTransfer.Status.error);
                            OutgoingFileTransfer.this.setException(e3);
                            InputStream inputStream3 = inputStream;
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            OutgoingFileTransfer.this.outputStream.flush();
                            outgoingFileTransfer = OutgoingFileTransfer.this;
                        }
                        outgoingFileTransfer.outputStream.close();
                        OutgoingFileTransfer.this.updateStatus(FileTransfer.Status.in_progress, FileTransfer.Status.complete);
                    }
                } catch (Throwable th) {
                    try {
                        InputStream inputStream4 = inputStream;
                        if (inputStream4 != null) {
                            inputStream4.close();
                        }
                        OutgoingFileTransfer.this.outputStream.flush();
                        OutgoingFileTransfer.this.outputStream.close();
                    } catch (IOException unused) {
                    }
                    throw th;
                }
            }
        }, "File Transfer " + this.streamID);
        this.transferThread = thread;
        thread.start();
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    public void setException(Exception exc) {
        super.setException(exc);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null) {
            negotiationProgress.errorEstablishingStream(exc);
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        if (this.outputStream == null) {
            this.outputStream = outputStream;
        }
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    public void setStatus(FileTransfer.Status status) {
        FileTransfer.Status status2 = getStatus();
        super.setStatus(status);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null) {
            negotiationProgress.statusUpdated(status2, status);
        }
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    public boolean updateStatus(FileTransfer.Status status, FileTransfer.Status status2) {
        boolean zUpdateStatus = super.updateStatus(status, status2);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null && zUpdateStatus) {
            negotiationProgress.statusUpdated(status, status2);
        }
        return zUpdateStatus;
    }

    public synchronized void sendFile(final String str, final long j, final String str2, final NegotiationProgress negotiationProgress) {
        try {
            if (negotiationProgress != null) {
                checkTransferThread();
                if (!isDone() && this.outputStream == null) {
                    setFileInfo(str, j);
                    this.callback = negotiationProgress;
                    Thread thread = new Thread(new Runnable() { // from class: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                OutgoingFileTransfer outgoingFileTransfer = OutgoingFileTransfer.this;
                                outgoingFileTransfer.outputStream = outgoingFileTransfer.negotiateStream(str, j, str2);
                                negotiationProgress.outputStreamEstablished(OutgoingFileTransfer.this.outputStream);
                            } catch (XMPPException.XMPPErrorException e) {
                                OutgoingFileTransfer.this.handleXMPPException(e);
                            } catch (Exception e2) {
                                OutgoingFileTransfer.this.setException(e2);
                            }
                        }
                    }, "File Transfer Negotiation " + this.streamID);
                    this.transferThread = thread;
                    thread.start();
                } else {
                    throw new IllegalStateException("The negotation process has already been attempted for this file transfer");
                }
            } else {
                throw new IllegalArgumentException("Callback progress cannot be null.");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void sendFile(final File file, final String str) throws SmackException {
        checkTransferThread();
        if (file != null && file.exists() && file.canRead()) {
            setFileInfo(file.getAbsolutePath(), file.getName(), file.length());
            Thread thread = new Thread(new Runnable() { // from class: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.2
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r0v12, types: [org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer] */
                /* JADX WARN: Type inference failed for: r0v2 */
                /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r1v2 */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r1v5, types: [org.jivesoftware.smackx.filetransfer.FileTransfer$Status] */
                /* JADX WARN: Type inference failed for: r2v11, types: [java.util.logging.Logger] */
                /* JADX WARN: Type inference failed for: r2v3, types: [org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer] */
                /* JADX WARN: Type inference failed for: r3v1, types: [org.jivesoftware.smackx.filetransfer.FileTransfer$Status] */
                /* JADX WARN: Type inference failed for: r3v14, types: [java.util.logging.Logger] */
                /* JADX WARN: Type inference failed for: r3v17, types: [java.util.logging.Logger] */
                /* JADX WARN: Type inference failed for: r3v19 */
                /* JADX WARN: Type inference failed for: r3v2 */
                /* JADX WARN: Type inference failed for: r3v21, types: [java.util.logging.Logger] */
                /* JADX WARN: Type inference failed for: r3v28 */
                /* JADX WARN: Type inference failed for: r3v29 */
                /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
                /* JADX WARN: Type inference failed for: r3v30 */
                /* JADX WARN: Type inference failed for: r3v31 */
                /* JADX WARN: Type inference failed for: r3v5, types: [java.util.logging.Logger] */
                /* JADX WARN: Type inference failed for: r3v7 */
                /* JADX WARN: Type inference failed for: r4v1, types: [java.util.logging.Logger] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0097 -> B:49:0x00d1). Please report as a decompilation issue!!! */
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    FileInputStream fileInputStream;
                    IOException e;
                    FileNotFoundException e2;
                    FileInputStream fileInputStream2;
                    ?? r0 = "Closing input stream";
                    ?? r1 = "Closing output stream";
                    try {
                        OutgoingFileTransfer outgoingFileTransfer = OutgoingFileTransfer.this;
                        outgoingFileTransfer.outputStream = outgoingFileTransfer.negotiateStream(file.getName(), file.length(), str);
                    } catch (XMPPException.XMPPErrorException e3) {
                        OutgoingFileTransfer.this.handleXMPPException(e3);
                        return;
                    } catch (Exception e4) {
                        OutgoingFileTransfer.this.setException(e4);
                    }
                    if (OutgoingFileTransfer.this.outputStream == null) {
                        return;
                    }
                    ?? r2 = OutgoingFileTransfer.this;
                    ?? r3 = FileTransfer.Status.negotiated;
                    if (!r2.updateStatus(r3, FileTransfer.Status.in_progress)) {
                        return;
                    }
                    try {
                        try {
                            try {
                                fileInputStream = new FileInputStream(file);
                            } catch (FileNotFoundException e5) {
                                fileInputStream = null;
                                e2 = e5;
                            } catch (IOException e6) {
                                fileInputStream = null;
                                e = e6;
                            } catch (Throwable th) {
                                r3 = 0;
                                th = th;
                                if (r3 != 0) {
                                    try {
                                        r3.close();
                                    } catch (IOException e7) {
                                        OutgoingFileTransfer.LOGGER.log(Level.WARNING, r0, e7);
                                    }
                                }
                                try {
                                    OutgoingFileTransfer.this.outputStream.close();
                                    throw th;
                                } catch (IOException e8) {
                                    OutgoingFileTransfer.LOGGER.log(Level.WARNING, r1, e8);
                                    throw th;
                                }
                            }
                            try {
                                OutgoingFileTransfer outgoingFileTransfer2 = OutgoingFileTransfer.this;
                                outgoingFileTransfer2.writeToStream(fileInputStream, outgoingFileTransfer2.outputStream);
                                try {
                                    fileInputStream.close();
                                    fileInputStream2 = fileInputStream;
                                } catch (IOException e9) {
                                    ?? r32 = OutgoingFileTransfer.LOGGER;
                                    r32.log(Level.WARNING, "Closing input stream", e9);
                                    fileInputStream2 = r32;
                                }
                                OutgoingFileTransfer.this.outputStream.close();
                                r3 = fileInputStream2;
                            } catch (FileNotFoundException e10) {
                                e2 = e10;
                                OutgoingFileTransfer.this.setStatus(FileTransfer.Status.error);
                                OutgoingFileTransfer.this.setError(FileTransfer.Error.bad_file);
                                OutgoingFileTransfer.this.setException(e2);
                                FileInputStream fileInputStream3 = fileInputStream;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        fileInputStream3 = fileInputStream;
                                    } catch (IOException e11) {
                                        ?? r33 = OutgoingFileTransfer.LOGGER;
                                        r33.log(Level.WARNING, "Closing input stream", e11);
                                        fileInputStream3 = r33;
                                    }
                                }
                                OutgoingFileTransfer.this.outputStream.close();
                                r3 = fileInputStream3;
                                r0 = OutgoingFileTransfer.this;
                                r1 = FileTransfer.Status.in_progress;
                                r0.updateStatus(r1, FileTransfer.Status.complete);
                            } catch (IOException e12) {
                                e = e12;
                                OutgoingFileTransfer.this.setStatus(FileTransfer.Status.error);
                                OutgoingFileTransfer.this.setException(e);
                                FileInputStream fileInputStream4 = fileInputStream;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        fileInputStream4 = fileInputStream;
                                    } catch (IOException e13) {
                                        ?? r34 = OutgoingFileTransfer.LOGGER;
                                        r34.log(Level.WARNING, "Closing input stream", e13);
                                        fileInputStream4 = r34;
                                    }
                                }
                                OutgoingFileTransfer.this.outputStream.close();
                                r3 = fileInputStream4;
                                r0 = OutgoingFileTransfer.this;
                                r1 = FileTransfer.Status.in_progress;
                                r0.updateStatus(r1, FileTransfer.Status.complete);
                            }
                        } catch (IOException e14) {
                            ?? r22 = OutgoingFileTransfer.LOGGER;
                            Level level = Level.WARNING;
                            r22.log(level, r1, e14);
                            r3 = level;
                        }
                        r0 = OutgoingFileTransfer.this;
                        r1 = FileTransfer.Status.in_progress;
                        r0.updateStatus(r1, FileTransfer.Status.complete);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }, "File Transfer " + this.streamID);
            this.transferThread = thread;
            thread.start();
        } else {
            throw new IllegalArgumentException("Could not read file");
        }
    }
}
