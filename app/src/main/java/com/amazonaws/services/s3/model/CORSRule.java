package com.amazonaws.services.s3.model;

import com.koushikdutta.async.http.AsyncHttpDelete;
import com.koushikdutta.async.http.AsyncHttpHead;
import com.koushikdutta.async.http.AsyncHttpPut;
import java.util.List;

/* loaded from: classes.dex */
public class CORSRule {
    public List<AllowedMethods> a;
    public List<String> b;
    public List<String> c;
    public List<String> d;

    public enum AllowedMethods {
        GET("GET"),
        PUT(AsyncHttpPut.METHOD),
        HEAD(AsyncHttpHead.METHOD),
        POST("POST"),
        DELETE(AsyncHttpDelete.METHOD);

        private final String AllowedMethod;

        AllowedMethods(String str) {
            this.AllowedMethod = str;
        }

        public static AllowedMethods fromValue(String str) throws IllegalArgumentException {
            for (AllowedMethods allowedMethods : values()) {
                String string = allowedMethods.toString();
                if (string == null && str == null) {
                    return allowedMethods;
                }
                if (string != null && string.equals(str)) {
                    return allowedMethods;
                }
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.AllowedMethod;
        }
    }

    public void a(List<String> list) {
        this.d = list;
    }

    public void b(List<AllowedMethods> list) {
        this.a = list;
    }

    public void c(List<String> list) {
        this.b = list;
    }

    public void d(List<String> list) {
        this.c = list;
    }

    public void e(String str) {
    }

    public void f(int i) {
    }
}
