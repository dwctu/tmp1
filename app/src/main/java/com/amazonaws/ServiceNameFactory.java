package com.amazonaws;

import com.amazonaws.internal.config.HttpClientConfig;
import com.amazonaws.internal.config.InternalConfig;

/* loaded from: classes.dex */
public enum ServiceNameFactory {
    ;

    public static String getServiceName(String str) {
        HttpClientConfig httpClientConfigH = InternalConfig.Factory.a().h(str);
        if (httpClientConfigH == null) {
            return null;
        }
        return httpClientConfigH.a();
    }
}
