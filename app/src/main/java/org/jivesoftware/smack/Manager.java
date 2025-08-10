package org.jivesoftware.smack;

import java.lang.ref.WeakReference;
import org.jivesoftware.smack.util.Objects;

/* loaded from: classes5.dex */
public abstract class Manager {
    public final WeakReference<XMPPConnection> weakConnection;

    public Manager(XMPPConnection xMPPConnection) {
        Objects.requireNonNull(xMPPConnection, "XMPPConnection must not be null");
        this.weakConnection = new WeakReference<>(xMPPConnection);
    }

    public final XMPPConnection connection() {
        return this.weakConnection.get();
    }
}
