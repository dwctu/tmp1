package org.jivesoftware.smack;

/* loaded from: classes5.dex */
public interface ConnectionListener {
    void authenticated(XMPPConnection xMPPConnection, boolean z);

    void connected(XMPPConnection xMPPConnection);

    void connectionClosed();

    void connectionClosedOnError(Exception exc);

    void reconnectingIn(int i);

    void reconnectionFailed(Exception exc);

    void reconnectionSuccessful();
}
