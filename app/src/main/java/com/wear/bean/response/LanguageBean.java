package com.wear.bean.response;

import dc.of1;
import java.util.HashMap;

@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public class LanguageBean {
    private HashMap<String, String> lang;
    private HashMap<String, String> version;

    public HashMap<String, String> getLang() {
        return this.lang;
    }

    public HashMap<String, String> getVersion() {
        return this.version;
    }

    public void setLang(HashMap<String, String> map) {
        this.lang = map;
    }

    public void setVersion(HashMap<String, String> map) {
        this.version = map;
    }
}
