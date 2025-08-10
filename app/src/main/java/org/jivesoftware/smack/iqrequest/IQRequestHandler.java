package org.jivesoftware.smack.iqrequest;

import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public interface IQRequestHandler {

    public enum Mode {
        sync,
        async
    }

    String getElement();

    Mode getMode();

    String getNamespace();

    IQ.Type getType();

    IQ handleIQRequest(IQ iq);
}
