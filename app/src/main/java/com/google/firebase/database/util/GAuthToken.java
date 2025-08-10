package com.google.firebase.database.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GAuthToken {
    private static final String AUTH_KEY = "auth";
    private static final String TOKEN_KEY = "token";
    private static final String TOKEN_PREFIX = "gauth|";
    private final Map<String, Object> auth;
    private final String token;

    public GAuthToken(String str, Map<String, Object> map) {
        this.token = str;
        this.auth = map;
    }

    public static GAuthToken tryParseFromString(String str) {
        if (!str.startsWith(TOKEN_PREFIX)) {
            return null;
        }
        try {
            Map<String, Object> json = JsonMapper.parseJson(str.substring(6));
            return new GAuthToken((String) json.get(TOKEN_KEY), (Map) json.get("auth"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse gauth token", e);
        }
    }

    public Map<String, Object> getAuth() {
        return this.auth;
    }

    public String getToken() {
        return this.token;
    }

    public String serializeToString() {
        HashMap map = new HashMap();
        map.put(TOKEN_KEY, this.token);
        map.put("auth", this.auth);
        try {
            return TOKEN_PREFIX + JsonMapper.serializeJson(map);
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize gauth token", e);
        }
    }
}
