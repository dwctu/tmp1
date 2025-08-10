package com.component.dxhttp;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes.dex */
public class NetException extends RuntimeException {
    public static String a = "A000";
    public static String b = "A001";
    public static String c = "A005";
    public static String d = "A006";
    public static String e = "A007";
    public static String f = "A008";
    public static String g = "A009";
    public static String h = "A010";
    public static String i = "A012";
    public static String j = "S000";
    public String code;
    public String message;

    public NetException(String str, String str2) {
        super(str2);
        this.code = str;
        this.message = str2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "NetException{code='" + this.code + "', message='" + this.message + '\'' + MessageFormatter.DELIM_STOP;
    }
}
