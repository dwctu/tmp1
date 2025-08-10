package com.google.firebase.database;

import androidx.annotation.NonNull;
import com.google.firebase.database.core.ServerValues;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ServerValue {

    @NonNull
    public static final Map<String, String> TIMESTAMP = createScalarServerValuePlaceholder("timestamp");

    private static Map<String, Map<String, Object>> createParameterizedServerValuePlaceholder(String str, Object obj) {
        HashMap map = new HashMap();
        map.put(str, obj);
        HashMap map2 = new HashMap();
        map2.put(ServerValues.NAME_SUBKEY_SERVERVALUE, Collections.unmodifiableMap(map));
        return Collections.unmodifiableMap(map2);
    }

    private static Map<String, String> createScalarServerValuePlaceholder(String str) {
        HashMap map = new HashMap();
        map.put(ServerValues.NAME_SUBKEY_SERVERVALUE, str);
        return Collections.unmodifiableMap(map);
    }

    @NonNull
    public static final Object increment(long j) {
        return createParameterizedServerValuePlaceholder(ServerValues.NAME_OP_INCREMENT, Long.valueOf(j));
    }

    @NonNull
    public static final Object increment(double d) {
        return createParameterizedServerValuePlaceholder(ServerValues.NAME_OP_INCREMENT, Double.valueOf(d));
    }
}
