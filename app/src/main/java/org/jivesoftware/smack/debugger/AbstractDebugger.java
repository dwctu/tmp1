package org.jivesoftware.smack.debugger;

import java.io.Reader;
import java.io.Writer;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.ObservableReader;
import org.jivesoftware.smack.util.ObservableWriter;
import org.jivesoftware.smack.util.ReaderListener;
import org.jivesoftware.smack.util.WriterListener;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public abstract class AbstractDebugger implements SmackDebugger {
    public static boolean printInterpreted = false;
    private final ConnectionListener connListener;
    private final XMPPConnection connection;
    private final StanzaListener listener;
    private ObservableReader reader;
    private final ReaderListener readerListener;
    private ObservableWriter writer;
    private final WriterListener writerListener;

    public AbstractDebugger(final XMPPConnection xMPPConnection, Writer writer, Reader reader) {
        this.connection = xMPPConnection;
        this.reader = new ObservableReader(reader);
        ReaderListener readerListener = new ReaderListener() { // from class: org.jivesoftware.smack.debugger.AbstractDebugger.1
            @Override // org.jivesoftware.smack.util.ReaderListener
            public void read(String str) {
                AbstractDebugger.this.log("RECV (" + xMPPConnection.getConnectionCounter() + "): " + str);
            }
        };
        this.readerListener = readerListener;
        this.reader.addReaderListener(readerListener);
        this.writer = new ObservableWriter(writer);
        WriterListener writerListener = new WriterListener() { // from class: org.jivesoftware.smack.debugger.AbstractDebugger.2
            @Override // org.jivesoftware.smack.util.WriterListener
            public void write(String str) {
                AbstractDebugger.this.log("SENT (" + xMPPConnection.getConnectionCounter() + "): " + str);
            }
        };
        this.writerListener = writerListener;
        this.writer.addWriterListener(writerListener);
        this.listener = new StanzaListener() { // from class: org.jivesoftware.smack.debugger.AbstractDebugger.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processPacket(Stanza stanza) {
                if (AbstractDebugger.printInterpreted) {
                    AbstractDebugger.this.log("RCV PKT (" + xMPPConnection.getConnectionCounter() + "): " + ((Object) stanza.toXML()));
                }
            }
        };
        this.connListener = new ConnectionListener() { // from class: org.jivesoftware.smack.debugger.AbstractDebugger.4
            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                String str = "XMPPConnection authenticated (" + xMPPConnection2.getConnectionCounter() + ")";
                if (z) {
                    str = str + " and resumed";
                }
                AbstractDebugger.this.log(str);
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connected(XMPPConnection xMPPConnection2) {
                AbstractDebugger.this.log("XMPPConnection connected (" + xMPPConnection2.getConnectionCounter() + ")");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosed() {
                AbstractDebugger.this.log("XMPPConnection closed (" + xMPPConnection.getConnectionCounter() + ")");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosedOnError(Exception exc) {
                AbstractDebugger.this.log("XMPPConnection closed due to an exception (" + xMPPConnection.getConnectionCounter() + ")");
                exc.printStackTrace();
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectingIn(int i) {
                AbstractDebugger.this.log("XMPPConnection (" + xMPPConnection.getConnectionCounter() + ") will reconnect in " + i);
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectionFailed(Exception exc) {
                AbstractDebugger.this.log("Reconnection failed due to an exception (" + xMPPConnection.getConnectionCounter() + ")");
                exc.printStackTrace();
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void reconnectionSuccessful() {
                AbstractDebugger.this.log("XMPPConnection reconnected (" + xMPPConnection.getConnectionCounter() + ")");
            }
        };
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public Reader getReader() {
        return this.reader;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public StanzaListener getReaderListener() {
        return this.listener;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public Writer getWriter() {
        return this.writer;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public StanzaListener getWriterListener() {
        return null;
    }

    public abstract void log(String str);

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public Reader newConnectionReader(Reader reader) {
        this.reader.removeReaderListener(this.readerListener);
        ObservableReader observableReader = new ObservableReader(reader);
        observableReader.addReaderListener(this.readerListener);
        this.reader = observableReader;
        return observableReader;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public Writer newConnectionWriter(Writer writer) {
        this.writer.removeWriterListener(this.writerListener);
        ObservableWriter observableWriter = new ObservableWriter(writer);
        observableWriter.addWriterListener(this.writerListener);
        this.writer = observableWriter;
        return observableWriter;
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public void userHasLogged(String str) {
        String localpart = XmppStringUtils.parseLocalpart(str);
        boolean zEquals = "".equals(localpart);
        StringBuilder sb = new StringBuilder();
        sb.append("User logged (");
        sb.append(this.connection.getConnectionCounter());
        sb.append("): ");
        if (zEquals) {
            localpart = "";
        }
        sb.append(localpart);
        sb.append("@");
        sb.append(this.connection.getServiceName());
        sb.append(SignatureImpl.INNER_SEP);
        sb.append(this.connection.getPort());
        log(sb.toString() + "/" + XmppStringUtils.parseResource(str));
        this.connection.addConnectionListener(this.connListener);
    }
}
