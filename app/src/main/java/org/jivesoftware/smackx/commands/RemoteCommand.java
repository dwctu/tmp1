package org.jivesoftware.smackx.commands;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.xdata.Form;

/* loaded from: classes5.dex */
public class RemoteCommand extends AdHocCommand {
    private XMPPConnection connection;
    private String jid;
    private String sessionID;

    public RemoteCommand(XMPPConnection xMPPConnection, String str, String str2) {
        this.connection = xMPPConnection;
        this.jid = str2;
        setNode(str);
    }

    private void executeAction(AdHocCommand.Action action) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        executeAction(action, null);
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void cancel() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.cancel);
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void complete(Form form) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.complete, form);
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void execute() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.execute);
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public String getOwnerJID() {
        return this.jid;
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void next(Form form) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.next, form);
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void prev() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.prev);
    }

    private void executeAction(AdHocCommand.Action action, Form form) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        AdHocCommandData adHocCommandData = new AdHocCommandData();
        adHocCommandData.setType(IQ.Type.set);
        adHocCommandData.setTo(getOwnerJID());
        adHocCommandData.setNode(getNode());
        adHocCommandData.setSessionID(this.sessionID);
        adHocCommandData.setAction(action);
        if (form != null) {
            adHocCommandData.setForm(form.getDataFormToSend());
        }
        AdHocCommandData adHocCommandData2 = (AdHocCommandData) this.connection.createPacketCollectorAndSend(adHocCommandData).nextResultOrThrow();
        this.sessionID = adHocCommandData2.getSessionID();
        super.setData(adHocCommandData2);
    }

    public void execute(Form form) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.execute, form);
    }
}
