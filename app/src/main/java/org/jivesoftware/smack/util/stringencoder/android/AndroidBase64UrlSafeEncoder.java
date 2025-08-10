package org.jivesoftware.smack.util.stringencoder.android;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import org.jivesoftware.smack.util.stringencoder.StringEncoder;

/* loaded from: classes5.dex */
public class AndroidBase64UrlSafeEncoder implements StringEncoder {
    private static final int BASE64_ENCODER_FLAGS = 10;
    private static AndroidBase64UrlSafeEncoder instance = new AndroidBase64UrlSafeEncoder();

    private AndroidBase64UrlSafeEncoder() {
    }

    public static AndroidBase64UrlSafeEncoder getInstance() {
        return instance;
    }

    @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
    public String decode(String str) {
        try {
            return new String(Base64.decode(str, 10), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported", e);
        }
    }

    @Override // org.jivesoftware.smack.util.stringencoder.StringEncoder
    public String encode(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 10);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported", e);
        }
    }
}
