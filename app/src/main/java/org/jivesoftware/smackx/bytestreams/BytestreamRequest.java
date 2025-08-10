package org.jivesoftware.smackx.bytestreams;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;

/* loaded from: classes5.dex */
public interface BytestreamRequest {
    BytestreamSession accept() throws SmackException, InterruptedException, XMPPException.XMPPErrorException;

    String getFrom();

    String getSessionID();

    void reject() throws SmackException.NotConnectedException;
}
