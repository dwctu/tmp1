package org.jivesoftware.smackx.debugger.android;

import java.io.Reader;
import java.io.Writer;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.debugger.AbstractDebugger;

/* loaded from: classes5.dex */
public class AndroidDebugger extends AbstractDebugger {
    public AndroidDebugger(XMPPConnection xMPPConnection, Writer writer, Reader reader) {
        super(xMPPConnection, writer, reader);
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    public void log(String str) {
    }
}
