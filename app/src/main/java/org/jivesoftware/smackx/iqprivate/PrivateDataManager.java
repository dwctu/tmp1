package org.jivesoftware.smackx.iqprivate;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.iqprivate.packet.DefaultPrivateData;
import org.jivesoftware.smackx.iqprivate.packet.PrivateData;
import org.jivesoftware.smackx.iqprivate.packet.PrivateDataIQ;
import org.jivesoftware.smackx.iqprivate.provider.PrivateDataProvider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class PrivateDataManager extends Manager {
    private static final Map<XMPPConnection, PrivateDataManager> instances = new WeakHashMap();
    private static Map<String, PrivateDataProvider> privateDataProviders = new Hashtable();

    public static class PrivateDataIQProvider extends IQProvider<PrivateDataIQ> {
        @Override // org.jivesoftware.smack.provider.Provider
        public PrivateDataIQ parse(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, SmackException, IOException {
            PrivateData privateData = null;
            boolean z = false;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    PrivateDataProvider privateDataProvider = PrivateDataManager.getPrivateDataProvider(name, namespace);
                    if (privateDataProvider != null) {
                        privateData = privateDataProvider.parsePrivateData(xmlPullParser);
                    } else {
                        DefaultPrivateData defaultPrivateData = new DefaultPrivateData(name, namespace);
                        boolean z2 = false;
                        while (!z2) {
                            int next2 = xmlPullParser.next();
                            if (next2 == 2) {
                                String name2 = xmlPullParser.getName();
                                if (xmlPullParser.isEmptyElementTag()) {
                                    defaultPrivateData.setValue(name2, "");
                                } else if (xmlPullParser.next() == 4) {
                                    defaultPrivateData.setValue(name2, xmlPullParser.getText());
                                }
                            } else if (next2 == 3 && xmlPullParser.getName().equals(name)) {
                                z2 = true;
                            }
                        }
                        privateData = defaultPrivateData;
                    }
                } else if (next == 3 && xmlPullParser.getName().equals("query")) {
                    z = true;
                }
            }
            return new PrivateDataIQ(privateData);
        }
    }

    private PrivateDataManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        instances.put(xMPPConnection, this);
    }

    public static void addPrivateDataProvider(String str, String str2, PrivateDataProvider privateDataProvider) {
        privateDataProviders.put(getProviderKey(str, str2), privateDataProvider);
    }

    public static synchronized PrivateDataManager getInstanceFor(XMPPConnection xMPPConnection) {
        PrivateDataManager privateDataManager;
        privateDataManager = instances.get(xMPPConnection);
        if (privateDataManager == null) {
            privateDataManager = new PrivateDataManager(xMPPConnection);
        }
        return privateDataManager;
    }

    public static PrivateDataProvider getPrivateDataProvider(String str, String str2) {
        return privateDataProviders.get(getProviderKey(str, str2));
    }

    private static String getProviderKey(String str, String str2) {
        return SimpleComparison.LESS_THAN_OPERATION + str + "/><" + str2 + "/>";
    }

    public static void removePrivateDataProvider(String str, String str2) {
        privateDataProviders.remove(getProviderKey(str, str2));
    }

    public PrivateData getPrivateData(String str, String str2) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        return ((PrivateDataIQ) connection().createPacketCollectorAndSend(new PrivateDataIQ(str, str2)).nextResultOrThrow()).getPrivateData();
    }

    public void setPrivateData(PrivateData privateData) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        connection().createPacketCollectorAndSend(new PrivateDataIQ(privateData)).nextResultOrThrow();
    }
}
