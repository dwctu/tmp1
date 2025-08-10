package com.google.android.vending.licensing.util;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Scanner;

/* loaded from: classes2.dex */
public class URIQueryDecoder {
    private static final String TAG = "URIQueryDecoder";

    public static void DecodeQuery(URI uri, Map<String, String> map) throws UnsupportedEncodingException {
        String strDecode;
        Scanner scanner = new Scanner(uri.getRawQuery());
        scanner.useDelimiter(ContainerUtils.FIELD_DELIMITER);
        while (scanner.hasNext()) {
            try {
                String[] strArrSplit = scanner.next().split("=");
                if (strArrSplit.length == 1) {
                    strDecode = null;
                } else {
                    if (strArrSplit.length != 2) {
                        throw new IllegalArgumentException("query parameter invalid");
                    }
                    strDecode = URLDecoder.decode(strArrSplit[1], "UTF-8");
                }
                map.put(URLDecoder.decode(strArrSplit[0], "UTF-8"), strDecode);
            } catch (UnsupportedEncodingException unused) {
                return;
            }
        }
    }
}
