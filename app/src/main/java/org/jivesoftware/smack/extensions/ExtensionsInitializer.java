package org.jivesoftware.smack.extensions;

import org.jivesoftware.smack.initializer.UrlInitializer;

/* loaded from: classes5.dex */
public class ExtensionsInitializer extends UrlInitializer {
    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    public String getConfigUrl() {
        return "classpath:assets/org.jivesoftware.smack.extensions/extensions.xml";
    }

    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    public String getProvidersUrl() {
        return "classpath:assets/org.jivesoftware.smack.extensions/extensions.providers";
    }
}
