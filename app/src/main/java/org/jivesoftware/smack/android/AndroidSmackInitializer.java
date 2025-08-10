package org.jivesoftware.smack.android;

import java.util.List;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.initializer.SmackInitializer;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smack.util.stringencoder.Base64UrlSafeEncoder;
import org.jivesoftware.smack.util.stringencoder.android.AndroidBase64Encoder;
import org.jivesoftware.smack.util.stringencoder.android.AndroidBase64UrlSafeEncoder;

/* loaded from: classes5.dex */
public class AndroidSmackInitializer implements SmackInitializer {
    @Override // org.jivesoftware.smack.initializer.SmackInitializer
    public List<Exception> initialize() {
        SmackConfiguration.setDefaultHostnameVerifier(new StrictHostnameVerifier());
        Base64.setEncoder(AndroidBase64Encoder.getInstance());
        Base64UrlSafeEncoder.setEncoder(AndroidBase64UrlSafeEncoder.getInstance());
        return null;
    }
}
