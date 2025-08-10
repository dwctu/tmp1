package org.jivesoftware.smackx.filetransfer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.filetransfer.FileTransfer;

/* loaded from: classes5.dex */
public class IncomingFileTransfer extends FileTransfer {
    private static final Logger LOGGER = Logger.getLogger(IncomingFileTransfer.class.getName());
    private InputStream inputStream;
    private FileTransferRequest recieveRequest;

    public IncomingFileTransfer(FileTransferRequest fileTransferRequest, FileTransferNegotiator fileTransferNegotiator) {
        super(fileTransferRequest.getRequestor(), fileTransferRequest.getStreamID(), fileTransferNegotiator);
        this.recieveRequest = fileTransferRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream negotiateStream() throws SmackException, XMPPException.XMPPErrorException {
        setStatus(FileTransfer.Status.negotiating_transfer);
        final StreamNegotiator streamNegotiatorSelectStreamNegotiator = this.negotiator.selectStreamNegotiator(this.recieveRequest);
        setStatus(FileTransfer.Status.negotiating_stream);
        FutureTask futureTask = new FutureTask(new Callable<InputStream>() { // from class: org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public InputStream call() throws Exception {
                return streamNegotiatorSelectStreamNegotiator.createIncomingStream(IncomingFileTransfer.this.recieveRequest.getStreamInitiation());
            }
        });
        futureTask.run();
        try {
            try {
                try {
                    try {
                        InputStream inputStream = (InputStream) futureTask.get(15L, TimeUnit.SECONDS);
                        futureTask.cancel(true);
                        setStatus(FileTransfer.Status.negotiated);
                        return inputStream;
                    } catch (InterruptedException e) {
                        throw new SmackException("Interruption while executing", e);
                    }
                } catch (ExecutionException e2) {
                    throw new SmackException("Error in execution", e2);
                }
            } catch (TimeoutException e3) {
                throw new SmackException("Request timed out", e3);
            }
        } catch (Throwable th) {
            futureTask.cancel(true);
            throw th;
        }
    }

    @Override // org.jivesoftware.smackx.filetransfer.FileTransfer
    public void cancel() {
        setStatus(FileTransfer.Status.cancelled);
    }

    public InputStream recieveFile() throws SmackException, XMPPException.XMPPErrorException {
        if (this.inputStream != null) {
            throw new IllegalStateException("Transfer already negotiated!");
        }
        try {
            InputStream inputStreamNegotiateStream = negotiateStream();
            this.inputStream = inputStreamNegotiateStream;
            return inputStreamNegotiateStream;
        } catch (XMPPException.XMPPErrorException e) {
            setException(e);
            throw e;
        }
    }

    public void recieveFile(final File file) throws SmackException, IOException {
        if (file != null) {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.canWrite()) {
                new Thread(new Runnable() { // from class: org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.1
                    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
                    /* JADX WARN: Removed duplicated region for block: B:37:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void run() throws java.io.IOException {
                        /*
                            r6 = this;
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this     // Catch: java.lang.Exception -> L9b
                            java.io.InputStream r1 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.access$100(r0)     // Catch: java.lang.Exception -> L9b
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.access$002(r0, r1)     // Catch: java.lang.Exception -> L9b
                            r0 = 0
                            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L26 java.io.FileNotFoundException -> L3e
                            java.io.File r2 = r2     // Catch: java.io.IOException -> L26 java.io.FileNotFoundException -> L3e
                            r1.<init>(r2)     // Catch: java.io.IOException -> L26 java.io.FileNotFoundException -> L3e
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this     // Catch: java.io.IOException -> L22 java.io.FileNotFoundException -> L24
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.in_progress     // Catch: java.io.IOException -> L22 java.io.FileNotFoundException -> L24
                            r0.setStatus(r2)     // Catch: java.io.IOException -> L22 java.io.FileNotFoundException -> L24
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this     // Catch: java.io.IOException -> L22 java.io.FileNotFoundException -> L24
                            java.io.InputStream r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.access$000(r0)     // Catch: java.io.IOException -> L22 java.io.FileNotFoundException -> L24
                            r0.writeToStream(r2, r1)     // Catch: java.io.IOException -> L22 java.io.FileNotFoundException -> L24
                            goto L55
                        L22:
                            r0 = move-exception
                            goto L2a
                        L24:
                            r0 = move-exception
                            goto L42
                        L26:
                            r1 = move-exception
                            r5 = r1
                            r1 = r0
                            r0 = r5
                        L2a:
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.error
                            r2.setStatus(r3)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Error r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Error.stream
                            r2.setError(r3)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            r2.setException(r0)
                            goto L55
                        L3e:
                            r1 = move-exception
                            r5 = r1
                            r1 = r0
                            r0 = r5
                        L42:
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.error
                            r2.setStatus(r3)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Error r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Error.bad_file
                            r2.setError(r3)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            r2.setException(r0)
                        L55:
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r0 = r0.getStatus()
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.in_progress
                            boolean r0 = r0.equals(r2)
                            if (r0 == 0) goto L6a
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.complete
                            r0.setStatus(r2)
                        L6a:
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            java.io.InputStream r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.access$000(r0)
                            if (r0 == 0) goto L88
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this     // Catch: java.io.IOException -> L7c
                            java.io.InputStream r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.access$000(r0)     // Catch: java.io.IOException -> L7c
                            r0.close()     // Catch: java.io.IOException -> L7c
                            goto L88
                        L7c:
                            r0 = move-exception
                            java.util.logging.Logger r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.access$200()
                            java.util.logging.Level r3 = java.util.logging.Level.WARNING
                            java.lang.String r4 = "Closing input stream"
                            r2.log(r3, r4, r0)
                        L88:
                            if (r1 == 0) goto L9a
                            r1.close()     // Catch: java.io.IOException -> L8e
                            goto L9a
                        L8e:
                            r0 = move-exception
                            java.util.logging.Logger r1 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.access$200()
                            java.util.logging.Level r2 = java.util.logging.Level.WARNING
                            java.lang.String r3 = "Closing output stream"
                            r1.log(r2, r3, r0)
                        L9a:
                            return
                        L9b:
                            r0 = move-exception
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r1 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.error
                            r1.setStatus(r2)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r1 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            r1.setException(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.AnonymousClass1.run():void");
                    }
                }, "File Transfer " + this.streamID).start();
                return;
            }
            throw new IllegalArgumentException("Cannot write to provided file");
        }
        throw new IllegalArgumentException("File cannot be null");
    }
}
