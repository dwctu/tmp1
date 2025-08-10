package com.wear.activity.orgySetting;

/* loaded from: classes3.dex */
public enum JoinType {
    NoWay("noway"),
    No("no"),
    Yes("yes"),
    Cancel("cancel");

    private String value;

    JoinType(String str) {
        this.value = str;
    }

    public static JoinType fromString(String str) {
        for (JoinType joinType : values()) {
            if (joinType.getValue().equals(str)) {
                return joinType;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
