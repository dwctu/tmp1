package org.jivesoftware.smack.sm.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class StreamManagementStreamFeatureProvider extends ExtensionElementProvider<StreamManagement.StreamManagementFeature> {
    @Override // org.jivesoftware.smack.provider.Provider
    public StreamManagement.StreamManagementFeature parse(XmlPullParser xmlPullParser, int i) {
        return StreamManagement.StreamManagementFeature.INSTANCE;
    }
}
