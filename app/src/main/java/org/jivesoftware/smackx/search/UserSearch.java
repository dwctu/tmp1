package org.jivesoftware.smackx.search;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.SimpleIQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.nick.packet.Nick;
import org.jivesoftware.smackx.xdata.Form;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class UserSearch extends SimpleIQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:search";

    public static class Provider extends IQProvider<IQ> {
        @Override // org.jivesoftware.smack.provider.Provider
        public IQ parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
            SimpleUserSearch simpleUserSearch = new SimpleUserSearch();
            UserSearch userSearch = null;
            boolean z = false;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2 && xmlPullParser.getName().equals("instructions")) {
                    UserSearch.buildDataForm(simpleUserSearch, xmlPullParser.nextText(), xmlPullParser);
                    return simpleUserSearch;
                }
                if (next == 2 && xmlPullParser.getName().equals("item")) {
                    simpleUserSearch.parseItems(xmlPullParser);
                    return simpleUserSearch;
                }
                if (next == 2 && xmlPullParser.getNamespace().equals("jabber:x:data")) {
                    userSearch = new UserSearch();
                    PacketParserUtils.addExtensionElement(userSearch, xmlPullParser);
                } else if (next == 3 && xmlPullParser.getName().equals("query")) {
                    z = true;
                }
            }
            return userSearch != null ? userSearch : simpleUserSearch;
        }
    }

    public UserSearch() {
        super("query", "jabber:iq:search");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void buildDataForm(SimpleUserSearch simpleUserSearch, String str, XmlPullParser xmlPullParser) throws XmlPullParserException, SmackException, IOException {
        DataForm dataForm = new DataForm(DataForm.Type.form);
        dataForm.setTitle("User Search");
        dataForm.addInstruction(str);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2 && !xmlPullParser.getNamespace().equals("jabber:x:data")) {
                String name = xmlPullParser.getName();
                FormField formField = new FormField(name);
                if (name.equals("first")) {
                    formField.setLabel("First Name");
                } else if (name.equals("last")) {
                    formField.setLabel("Last Name");
                } else if (name.equals("email")) {
                    formField.setLabel("Email Address");
                } else if (name.equals(Nick.ELEMENT_NAME)) {
                    formField.setLabel("Nickname");
                }
                formField.setType(FormField.Type.text_single);
                dataForm.addField(formField);
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("query")) {
                    z = true;
                }
            } else if (next == 2 && xmlPullParser.getNamespace().equals("jabber:x:data")) {
                PacketParserUtils.addExtensionElement(simpleUserSearch, xmlPullParser);
                z = true;
            }
        }
        if (simpleUserSearch.getExtension("x", "jabber:x:data") == null) {
            simpleUserSearch.addExtension(dataForm);
        }
    }

    public Form getSearchForm(XMPPConnection xMPPConnection, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        UserSearch userSearch = new UserSearch();
        userSearch.setType(IQ.Type.get);
        userSearch.setTo(str);
        return Form.getFormFrom((IQ) xMPPConnection.createPacketCollectorAndSend(userSearch).nextResultOrThrow());
    }

    public ReportedData sendSearchForm(XMPPConnection xMPPConnection, Form form, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        UserSearch userSearch = new UserSearch();
        userSearch.setType(IQ.Type.set);
        userSearch.setTo(str);
        userSearch.addExtension(form.getDataFormToSend());
        return ReportedData.getReportedDataFrom((IQ) xMPPConnection.createPacketCollectorAndSend(userSearch).nextResultOrThrow());
    }

    public ReportedData sendSimpleSearchForm(XMPPConnection xMPPConnection, Form form, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        SimpleUserSearch simpleUserSearch = new SimpleUserSearch();
        simpleUserSearch.setForm(form);
        simpleUserSearch.setType(IQ.Type.set);
        simpleUserSearch.setTo(str);
        return ((SimpleUserSearch) xMPPConnection.createPacketCollectorAndSend(simpleUserSearch).nextResultOrThrow()).getReportedData();
    }
}
