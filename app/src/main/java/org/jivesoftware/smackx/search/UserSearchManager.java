package org.jivesoftware.smackx.search;

import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.xdata.Form;

/* loaded from: classes5.dex */
public class UserSearchManager {
    private XMPPConnection con;
    private UserSearch userSearch = new UserSearch();

    public UserSearchManager(XMPPConnection xMPPConnection) {
        this.con = xMPPConnection;
    }

    public Form getSearchForm(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return this.userSearch.getSearchForm(this.con, str);
    }

    public ReportedData getSearchResults(Form form, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return this.userSearch.sendSearchForm(this.con, form, str);
    }

    public List<String> getSearchServices() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(this.con).findServices("jabber:iq:search", false, false);
    }
}
