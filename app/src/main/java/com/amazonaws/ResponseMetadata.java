package com.amazonaws;

import java.util.Map;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes.dex */
public class ResponseMetadata {
    public final Map<String, String> a;

    public ResponseMetadata(Map<String, String> map) {
        this.a = map;
    }

    public String a() {
        return this.a.get("AWS_REQUEST_ID");
    }

    public String toString() {
        Map<String, String> map = this.a;
        return map == null ? MessageFormatter.DELIM_STR : map.toString();
    }
}
