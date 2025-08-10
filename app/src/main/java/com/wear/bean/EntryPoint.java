package com.wear.bean;

/* loaded from: classes3.dex */
public enum EntryPoint {
    Official("2404262219"),
    Discover("2404263711"),
    Banner("2404261884"),
    ControlLink("2404261010"),
    Flash("2404269049"),
    OfflineMessages("2404301081"),
    Other("");

    private String value;

    EntryPoint(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
