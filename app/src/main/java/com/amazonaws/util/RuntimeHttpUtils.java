package com.amazonaws.util;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class RuntimeHttpUtils {
    public static URI a(String str, ClientConfiguration clientConfiguration) {
        if (clientConfiguration != null) {
            return b(str, clientConfiguration.c());
        }
        throw new IllegalArgumentException("ClientConfiguration cannot be null");
    }

    public static URI b(String str, Protocol protocol) {
        if (str == null) {
            throw new IllegalArgumentException("endpoint cannot be null");
        }
        if (!str.contains("://")) {
            str = protocol.toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
