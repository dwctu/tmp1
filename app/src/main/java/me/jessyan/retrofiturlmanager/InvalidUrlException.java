package me.jessyan.retrofiturlmanager;

import android.text.TextUtils;

/* loaded from: classes5.dex */
public class InvalidUrlException extends RuntimeException {
    public InvalidUrlException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("You've configured an invalid url : ");
        sb.append(TextUtils.isEmpty(str) ? "EMPTY_OR_NULL_URL" : str);
        super(sb.toString());
    }
}
