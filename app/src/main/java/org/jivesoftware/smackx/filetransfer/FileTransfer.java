package org.jivesoftware.smackx.filetransfer;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class FileTransfer {
    private static final int BUFFER_SIZE = 8192;
    private Error error;
    private Exception exception;
    private String fileName;
    private String filePath;
    private long fileSize;
    public FileTransferNegotiator negotiator;
    private String peer;
    public String streamID;
    private Status status = Status.initial;
    private final Object statusMonitor = new Object();
    public long amountWritten = -1;

    public enum Error {
        none("No error"),
        not_acceptable("The peer did not find any of the provided stream mechanisms acceptable."),
        bad_file("The provided file to transfer does not exist or could not be read."),
        no_response("The remote user did not respond or the connection timed out."),
        connection("An error occured over the socket connected to send the file."),
        stream("An error occured while sending or recieving the file.");

        private final String msg;

        Error(String str) {
            this.msg = str;
        }

        public String getMessage() {
            return this.msg;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.msg;
        }
    }

    public enum Status {
        error("Error"),
        initial("Initial"),
        negotiating_transfer("Negotiating Transfer"),
        refused("Refused"),
        negotiating_stream("Negotiating Stream"),
        negotiated("Negotiated"),
        in_progress("In Progress"),
        complete("Complete"),
        cancelled("Cancelled");

        private String status;

        Status(String str) {
            this.status = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.status;
        }
    }

    public FileTransfer(String str, String str2, FileTransferNegotiator fileTransferNegotiator) {
        this.peer = str;
        this.streamID = str2;
        this.negotiator = fileTransferNegotiator;
    }

    public abstract void cancel();

    public long getAmountWritten() {
        return this.amountWritten;
    }

    public Error getError() {
        return this.error;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getPeer() {
        return this.peer;
    }

    public double getProgress() {
        long j = this.amountWritten;
        if (j <= 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        long j2 = this.fileSize;
        return j2 <= 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : j / j2;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getStreamID() {
        return this.streamID;
    }

    public boolean isDone() {
        Status status = this.status;
        return status == Status.cancelled || status == Status.error || status == Status.complete || status == Status.refused;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public void setException(Exception exc) {
        this.exception = exc;
    }

    public void setFileInfo(String str, long j) {
        this.fileName = str;
        this.fileSize = j;
    }

    public void setStatus(Status status) {
        synchronized (this.statusMonitor) {
            this.status = status;
        }
    }

    public boolean updateStatus(Status status, Status status2) {
        synchronized (this.statusMonitor) {
            if (status != this.status) {
                return false;
            }
            this.status = status2;
            return true;
        }
    }

    public void writeToStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        this.amountWritten = 0L;
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0 || getStatus().equals(Status.cancelled)) {
                break;
            }
            outputStream.write(bArr, 0, i);
            this.amountWritten += i;
        }
        if (getStatus().equals(Status.cancelled) || getError() != Error.none || this.amountWritten == this.fileSize) {
            return;
        }
        setStatus(Status.error);
        this.error = Error.connection;
    }

    public void setFileInfo(String str, String str2, long j) {
        this.filePath = str;
        this.fileName = str2;
        this.fileSize = j;
    }
}
