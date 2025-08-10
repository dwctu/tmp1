package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.initializer.UrlInitializer;

/* loaded from: classes5.dex */
public class TCPInitializer extends UrlInitializer {
    @Override // org.jivesoftware.smack.initializer.UrlInitializer
    public String getProvidersUrl() {
        return "classpath:assets/org.jivesoftware.smack.tcp/smacktcp.providers";
    }
}
