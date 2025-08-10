package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.util.json.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.j256.ormlite.field.FieldType;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class TransferRecord {
    public static final Log E = LogFactory.b(TransferRecord.class);
    public String A;
    public TransferUtilityOptions B;
    public Future<?> C;
    public Gson D = new Gson();
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public long f;
    public long g;
    public long h;
    public TransferType i;
    public TransferState j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public Map<String, String> u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public TransferRecord(int i) {
        this.a = i;
    }

    public boolean b(final AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (e(this.j)) {
            return false;
        }
        transferStatusUpdater.l(this.a, TransferState.PENDING_CANCEL);
        if (f()) {
            this.C.cancel(true);
        }
        if (TransferType.UPLOAD.equals(this.i) && this.c == 1) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AmazonS3 amazonS32 = amazonS3;
                        TransferRecord transferRecord = TransferRecord.this;
                        amazonS32.e(new AbortMultipartUploadRequest(transferRecord.k, transferRecord.l, transferRecord.n));
                        TransferRecord.E.a("Successfully clean up multipart upload: " + TransferRecord.this.a);
                    } catch (AmazonClientException e) {
                        TransferRecord.E.e("Failed to abort multiplart upload: " + TransferRecord.this.a, e);
                    }
                }
            }).start();
        } else if (TransferType.DOWNLOAD.equals(this.i)) {
            new File(this.m).delete();
        }
        return true;
    }

    public final boolean c() {
        return this.e == 0 && !TransferState.COMPLETED.equals(this.j);
    }

    public boolean d(TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        TransferUtilityOptions transferUtilityOptions;
        if (connectivityManager == null || (transferUtilityOptions = this.B) == null || transferUtilityOptions.e() == null || this.B.e().isConnected(connectivityManager)) {
            return true;
        }
        E.b("Network Connection " + this.B.e() + " is not available.");
        transferStatusUpdater.l(this.a, TransferState.WAITING_FOR_NETWORK);
        return false;
    }

    public final boolean e(TransferState transferState) {
        return TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState);
    }

    public boolean f() {
        Future<?> future = this.C;
        return (future == null || future.isDone()) ? false : true;
    }

    public boolean g(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (e(this.j) || TransferState.PAUSED.equals(this.j)) {
            return false;
        }
        TransferState transferState = TransferState.PENDING_PAUSE;
        if (transferState.equals(this.j)) {
            return false;
        }
        transferStatusUpdater.l(this.a, transferState);
        if (f()) {
            this.C.cancel(true);
        }
        return true;
    }

    public boolean h(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        boolean zD = d(transferStatusUpdater, connectivityManager);
        boolean z = false;
        if (!zD && !e(this.j)) {
            z = true;
            if (f()) {
                this.C.cancel(true);
            }
        }
        return z;
    }

    public boolean i(AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        if (f() || !c() || !d(transferStatusUpdater, connectivityManager)) {
            return false;
        }
        if (this.i.equals(TransferType.DOWNLOAD)) {
            this.C = TransferThreadPool.c(new DownloadTask(this, amazonS3, transferStatusUpdater));
            return true;
        }
        this.C = TransferThreadPool.c(new UploadTask(this, amazonS3, transferDBUtil, transferStatusUpdater));
        return true;
    }

    public void j(Cursor cursor) {
        this.a = cursor.getInt(cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX));
        this.b = cursor.getInt(cursor.getColumnIndexOrThrow("main_upload_id"));
        this.i = TransferType.getType(cursor.getString(cursor.getColumnIndexOrThrow("type")));
        this.j = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
        this.k = cursor.getString(cursor.getColumnIndexOrThrow("bucket_name"));
        this.l = cursor.getString(cursor.getColumnIndexOrThrow("key"));
        cursor.getString(cursor.getColumnIndexOrThrow("version_id"));
        this.f = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_total"));
        this.g = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_current"));
        cursor.getLong(cursor.getColumnIndexOrThrow("speed"));
        cursor.getInt(cursor.getColumnIndexOrThrow("is_requester_pays"));
        this.c = cursor.getInt(cursor.getColumnIndexOrThrow("is_multipart"));
        this.d = cursor.getInt(cursor.getColumnIndexOrThrow("is_last_part"));
        cursor.getInt(cursor.getColumnIndexOrThrow("is_encrypted"));
        this.e = cursor.getInt(cursor.getColumnIndexOrThrow("part_num"));
        this.o = cursor.getString(cursor.getColumnIndexOrThrow("etag"));
        this.m = cursor.getString(cursor.getColumnIndexOrThrow("file"));
        this.n = cursor.getString(cursor.getColumnIndexOrThrow("multipart_id"));
        cursor.getLong(cursor.getColumnIndexOrThrow("range_start"));
        cursor.getLong(cursor.getColumnIndexOrThrow("range_last"));
        this.h = cursor.getLong(cursor.getColumnIndexOrThrow("file_offset"));
        this.p = cursor.getString(cursor.getColumnIndexOrThrow("header_content_type"));
        cursor.getString(cursor.getColumnIndexOrThrow("header_content_language"));
        this.q = cursor.getString(cursor.getColumnIndexOrThrow("header_content_disposition"));
        this.r = cursor.getString(cursor.getColumnIndexOrThrow("header_content_encoding"));
        this.s = cursor.getString(cursor.getColumnIndexOrThrow("header_cache_control"));
        cursor.getString(cursor.getColumnIndexOrThrow("header_expire"));
        this.u = JsonUtils.d(cursor.getString(cursor.getColumnIndexOrThrow("user_metadata")));
        this.v = cursor.getString(cursor.getColumnIndexOrThrow("expiration_time_rule_id"));
        this.w = cursor.getString(cursor.getColumnIndexOrThrow("http_expires_date"));
        this.x = cursor.getString(cursor.getColumnIndexOrThrow("sse_algorithm"));
        this.y = cursor.getString(cursor.getColumnIndexOrThrow("kms_key"));
        this.z = cursor.getString(cursor.getColumnIndexOrThrow("content_md5"));
        this.A = cursor.getString(cursor.getColumnIndexOrThrow("canned_acl"));
        this.t = cursor.getString(cursor.getColumnIndexOrThrow("header_storage_class"));
        String string = cursor.getString(cursor.getColumnIndexOrThrow("transfer_utility_options"));
        try {
            this.B = (TransferUtilityOptions) this.D.fromJson(string, TransferUtilityOptions.class);
        } catch (JsonSyntaxException e) {
            E.c(String.format("Failed to deserialize: %s, setting to default", string), e);
            this.B = new TransferUtilityOptions();
        }
    }

    public String toString() {
        return "[id:" + this.a + ",bucketName:" + this.k + ",key:" + this.l + ",file:" + this.m + ",type:" + this.i + ",bytesTotal:" + this.f + ",bytesCurrent:" + this.g + ",fileOffset:" + this.h + ",state:" + this.j + ",cannedAcl:" + this.A + ",mainUploadId:" + this.b + ",isMultipart:" + this.c + ",isLastPart:" + this.d + ",partNumber:" + this.e + ",multipartId:" + this.n + ",eTag:" + this.o + ",storageClass:" + this.t + ",userMetadata:" + this.u.toString() + ",transferUtilityOptions:" + this.D.toJson(this.B) + "]";
    }
}
