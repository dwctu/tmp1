package com.huawei.hms.framework.network.grs.d.b;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public class a {
    public static HostnameVerifier a() {
        return new StrictHostnameVerifier();
    }

    public static SSLSocketFactory a(Context context) {
        try {
            return new SecureSSLSocketFactory(new SecureX509TrustManager(context.getAssets().open("grs_sp.bks"), ""));
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
