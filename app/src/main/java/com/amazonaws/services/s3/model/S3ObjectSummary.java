package com.amazonaws.services.s3.model;

import java.util.Date;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes.dex */
public class S3ObjectSummary {
    public String a;
    public String b;
    public String c;
    public long d;
    public Date e;
    public String f;
    public Owner g;

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.b = str;
    }

    public void e(Date date) {
        this.e = date;
    }

    public void f(Owner owner) {
        this.g = owner;
    }

    public void g(long j) {
        this.d = j;
    }

    public void h(String str) {
        this.f = str;
    }

    public String toString() {
        return "S3ObjectSummary{bucketName='" + this.a + "', key='" + this.b + "', eTag='" + this.c + "', size=" + this.d + ", lastModified=" + this.e + ", storageClass='" + this.f + "', owner=" + this.g + MessageFormatter.DELIM_STOP;
    }
}
