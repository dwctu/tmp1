package org.jivesoftware.smackx.filetransfer;

import org.jivesoftware.smack.SmackException;

/* loaded from: classes5.dex */
public abstract class FileTransferException extends SmackException {
    private static final long serialVersionUID = 1;

    public static class NoAcceptableTransferMechanisms extends FileTransferException {
        private static final long serialVersionUID = 1;
    }

    public static class NoStreamMethodsOfferedException extends FileTransferException {
        private static final long serialVersionUID = 1;
    }
}
