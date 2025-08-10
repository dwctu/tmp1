package org.jivesoftware.smack;

/* loaded from: classes5.dex */
public abstract class AbstractConnectionClosedListener extends AbstractConnectionListener {
    @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
    public final void connectionClosed() {
        connectionTerminated();
    }

    @Override // org.jivesoftware.smack.AbstractConnectionListener, org.jivesoftware.smack.ConnectionListener
    public final void connectionClosedOnError(Exception exc) {
        connectionTerminated();
    }

    public abstract void connectionTerminated();
}
