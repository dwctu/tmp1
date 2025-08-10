package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class BucketLoggingConfiguration implements Serializable {
    private String destinationBucketName = null;
    private String logFilePrefix = null;

    public String a() {
        return this.destinationBucketName;
    }

    public String b() {
        return this.logFilePrefix;
    }

    public boolean c() {
        return (this.destinationBucketName == null || this.logFilePrefix == null) ? false : true;
    }

    public void d(String str) {
        this.destinationBucketName = str;
    }

    public void e(String str) {
        if (str == null) {
            str = "";
        }
        this.logFilePrefix = str;
    }

    public String toString() {
        String str = "LoggingConfiguration enabled=" + c();
        if (!c()) {
            return str;
        }
        return str + ", destinationBucketName=" + a() + ", logFilePrefix=" + b();
    }
}
