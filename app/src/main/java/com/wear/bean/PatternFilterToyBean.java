package com.wear.bean;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class PatternFilterToyBean implements Comparable<PatternFilterToyBean> {
    private boolean isSelect;
    private String toyName;
    private String toySymbols;
    private String toyTag;

    public PatternFilterToyBean(String str, String str2, String str3) {
        this.toyName = str;
        this.toyTag = str2;
        this.toySymbols = str3;
    }

    @Override // java.lang.Comparable
    public int compareTo(PatternFilterToyBean patternFilterToyBean) {
        return 0;
    }

    public String getToyName() {
        return this.toyName;
    }

    public String getToySymbols() {
        return this.toySymbols;
    }

    public String getToyTag() {
        return this.toyTag;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setToyName(String str) {
        this.toyName = str;
    }

    public void setToySymbols(String str) {
        this.toySymbols = str;
    }

    public void setToyTag(String str) {
        this.toyTag = str;
    }

    public String toString() {
        return "PatternFilterToyBean{toyName='" + this.toyName + "', toyTag='" + this.toyTag + "', isSelect=" + this.isSelect + MessageFormatter.DELIM_STOP;
    }
}
