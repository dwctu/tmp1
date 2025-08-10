package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;

/* loaded from: classes.dex */
public class TransferUtility {
    public static final Log f = LogFactory.b(TransferUtility.class);
    public static final Object g = new Object();
    public static String h = "";
    public TransferStatusUpdater a;
    public TransferDBUtil b;
    public final ConnectivityManager c;
    public final AmazonS3 d;
    public final TransferUtilityOptions e;

    public static class Builder {
        public AmazonS3 a;
        public Context b;
        public String c;
        public AWSConfiguration d;
        public TransferUtilityOptions e;

        public TransferUtility a() {
            if (this.a == null) {
                throw new IllegalArgumentException("AmazonS3 client is required please set using .s3Client(yourClient)");
            }
            if (this.b == null) {
                throw new IllegalArgumentException("Context is required please set using .context(applicationContext)");
            }
            AWSConfiguration aWSConfiguration = this.d;
            if (aWSConfiguration == null) {
                if (this.e == null) {
                    this.e = new TransferUtilityOptions();
                }
                return new TransferUtility(this.a, this.b, this.c, this.e);
            }
            try {
                aWSConfiguration.a("S3TransferUtility");
                throw null;
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to read S3TransferUtility please check your setup or awsconfiguration.json file", e);
            }
        }

        public Builder b(Context context) {
            this.b = context.getApplicationContext();
            return this;
        }

        public Builder c(String str) {
            this.c = str;
            return this;
        }

        public Builder d(AmazonS3 amazonS3) {
            this.a = amazonS3;
            return this;
        }
    }

    public static <X extends AmazonWebServiceRequest> X a(X x) {
        x.d().a("TransferService_multipart/" + e() + VersionInfoUtils.c());
        return x;
    }

    public static <X extends AmazonWebServiceRequest> X b(X x) {
        x.d().a("TransferService/" + e() + VersionInfoUtils.c());
        return x;
    }

    public static Builder c() {
        return new Builder();
    }

    public static String e() {
        synchronized (g) {
            String str = h;
            if (str != null && !str.trim().isEmpty()) {
                return h.trim() + "/";
            }
            return "";
        }
    }

    public final int d(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        long length = file.length();
        double d = length;
        long jMax = (long) Math.max(Math.ceil(d / 10000.0d), this.e.d());
        int iCeil = ((int) Math.ceil(d / jMax)) + 1;
        ContentValues[] contentValuesArr = new ContentValues[iCeil];
        contentValuesArr[0] = this.b.d(str, str2, file, 0L, 0, "", file.length(), 0, objectMetadata, cannedAccessControlList, this.e);
        long j = 0;
        int i = 1;
        for (int i2 = 1; i2 < iCeil; i2++) {
            long jMin = Math.min(jMax, length);
            length -= jMax;
            contentValuesArr[i2] = this.b.d(str, str2, file, j, i, "", jMin, length <= 0 ? 1 : 0, objectMetadata, cannedAccessControlList, this.e);
            j += jMax;
            i++;
        }
        return this.b.a(contentValuesArr);
    }

    public final boolean f(File file) {
        return file != null && file.length() > this.e.d();
    }

    public final synchronized void g(String str, int i) {
        S3ClientReference.b(Integer.valueOf(i), this.d);
        TransferRecord transferRecordD = this.a.d(i);
        if (transferRecordD == null) {
            transferRecordD = this.b.j(i);
            if (transferRecordD == null) {
                f.d("Cannot find transfer with id: " + i);
                return;
            }
            this.a.b(transferRecordD);
        } else if ("add_transfer".equals(str)) {
            f.g("Transfer has already been added: " + i);
            return;
        }
        if ("add_transfer".equals(str) || "resume_transfer".equals(str)) {
            transferRecordD.i(this.d, this.b, this.a, this.c);
        } else if ("pause_transfer".equals(str)) {
            transferRecordD.g(this.d, this.a);
        } else if ("cancel_transfer".equals(str)) {
            transferRecordD.b(this.d, this.a);
        } else {
            f.d("Unknown action: " + str);
        }
    }

    public TransferObserver h(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return i(str, str2, file, objectMetadata, null);
    }

    public TransferObserver i(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return j(str, str2, file, objectMetadata, cannedAccessControlList, null);
    }

    public TransferObserver j(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        if (file == null || file.isDirectory() || !file.exists()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        int iD = f(file) ? d(str, str2, file, objectMetadata, cannedAccessControlList) : Integer.parseInt(this.b.k(TransferType.UPLOAD, str, str2, file, objectMetadata, cannedAccessControlList, this.e).getLastPathSegment());
        TransferObserver transferObserver = new TransferObserver(iD, this.b, str, str2, file, transferListener);
        g("add_transfer", iD);
        return transferObserver;
    }

    public TransferUtility(AmazonS3 amazonS3, Context context, String str, TransferUtilityOptions transferUtilityOptions) {
        this.d = amazonS3;
        this.e = transferUtilityOptions;
        this.b = new TransferDBUtil(context.getApplicationContext());
        this.a = TransferStatusUpdater.c(context.getApplicationContext());
        TransferThreadPool.b(transferUtilityOptions.f());
        this.c = (ConnectivityManager) context.getSystemService("connectivity");
    }
}
