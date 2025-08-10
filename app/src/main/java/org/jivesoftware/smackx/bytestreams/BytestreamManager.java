package org.jivesoftware.smackx.bytestreams;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;

/* loaded from: classes5.dex */
public interface BytestreamManager {
    void addIncomingBytestreamListener(BytestreamListener bytestreamListener);

    void addIncomingBytestreamListener(BytestreamListener bytestreamListener, String str);

    BytestreamSession establishSession(String str) throws SmackException, InterruptedException, IOException, XMPPException;

    BytestreamSession establishSession(String str, String str2) throws SmackException, InterruptedException, IOException, XMPPException;

    void removeIncomingBytestreamListener(String str);

    void removeIncomingBytestreamListener(BytestreamListener bytestreamListener);
}
