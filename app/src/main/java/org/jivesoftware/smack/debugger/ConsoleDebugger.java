package org.jivesoftware.smack.debugger;

import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jivesoftware.smack.XMPPConnection;

/* loaded from: classes5.dex */
public class ConsoleDebugger extends AbstractDebugger {
    private final SimpleDateFormat dateFormatter;

    public ConsoleDebugger(XMPPConnection xMPPConnection, Writer writer, Reader reader) {
        super(xMPPConnection, writer, reader);
        this.dateFormatter = new SimpleDateFormat("hh:mm:ss aaa");
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    public void log(String str) {
        String str2;
        synchronized (this.dateFormatter) {
            str2 = this.dateFormatter.format(new Date());
        }
        System.out.println(str2 + ' ' + str);
    }
}
