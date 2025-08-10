package com.amazonaws.services.s3.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TagSet {
    public Map<String, String> a;

    public TagSet(Map<String, String> map) {
        HashMap map2 = new HashMap(1);
        this.a = map2;
        map2.putAll(map);
    }

    public Map<String, String> a() {
        return this.a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("Tags: " + a());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
