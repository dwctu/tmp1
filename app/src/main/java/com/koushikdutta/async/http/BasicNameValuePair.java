package com.koushikdutta.async.http;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class BasicNameValuePair implements NameValuePair, Cloneable {
    private final String name;
    private final String value;

    public BasicNameValuePair(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.name = str;
        this.value = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        return this.name.equals(basicNameValuePair.name) && TextUtils.equals(this.value, basicNameValuePair.value);
    }

    @Override // com.koushikdutta.async.http.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // com.koushikdutta.async.http.NameValuePair
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.name.hashCode() ^ this.value.hashCode();
    }

    public String toString() {
        return this.name + "=" + this.value;
    }
}
