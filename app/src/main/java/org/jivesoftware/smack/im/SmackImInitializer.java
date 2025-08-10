package org.jivesoftware.smack.im;

import org.jivesoftware.smack.initializer.UrlInitializer;

/* loaded from: classes5.dex */
public class SmackImInitializer extends UrlInitializer {
    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    public String getConfigUrl() {
        return "classpath:assets/org.jivesoftware.smack.im/smackim.xml";
    }

    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    public String getProvidersUrl() {
        return "classpath:assets/org.jivesoftware.smack.im/smackim.providers";
    }
}
