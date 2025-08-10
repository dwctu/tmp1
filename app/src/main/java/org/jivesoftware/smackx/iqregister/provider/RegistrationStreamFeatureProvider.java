package org.jivesoftware.smackx.iqregister.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.iqregister.packet.Registration;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class RegistrationStreamFeatureProvider extends ExtensionElementProvider<Registration.Feature> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Registration.Feature parse(XmlPullParser xmlPullParser, int i) {
        return Registration.Feature.INSTANCE;
    }
}
