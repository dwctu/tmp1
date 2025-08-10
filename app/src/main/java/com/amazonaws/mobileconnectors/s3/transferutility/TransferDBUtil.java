package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.json.JsonUtils;
import com.google.gson.Gson;
import com.j256.ormlite.field.FieldType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.net.RFC1522Codec;

/* loaded from: classes.dex */
public class TransferDBUtil {
    public static final Log b = LogFactory.b(TransferDBUtil.class);
    public static final Object c = new Object();
    public static TransferDBBase d;
    public Gson a = new Gson();

    public TransferDBUtil(Context context) {
        synchronized (c) {
            if (d == null) {
                d = new TransferDBBase(context);
            }
        }
    }

    public int a(ContentValues[] contentValuesArr) {
        TransferDBBase transferDBBase = d;
        return transferDBBase.a(transferDBBase.d(), contentValuesArr);
    }

    public final String b(int i) {
        if (i <= 0) {
            b.d("Cannot create a string of 0 or less placeholders.");
            return null;
        }
        StringBuilder sb = new StringBuilder((i * 2) - 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public int c(int i) {
        return d.b(i(i), null, null);
    }

    public ContentValues d(String str, String str2, File file, long j, int i, String str3, long j2, int i2, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", TransferType.UPLOAD.toString());
        contentValues.put("state", TransferState.WAITING.toString());
        contentValues.put("bucket_name", str);
        contentValues.put("key", str2);
        contentValues.put("file", file.getAbsolutePath());
        contentValues.put("bytes_current", (Long) 0L);
        contentValues.put("bytes_total", Long.valueOf(j2));
        contentValues.put("is_multipart", (Integer) 1);
        contentValues.put("part_num", Integer.valueOf(i));
        contentValues.put("file_offset", Long.valueOf(j));
        contentValues.put("multipart_id", str3);
        contentValues.put("is_last_part", Integer.valueOf(i2));
        contentValues.put("is_encrypted", (Integer) 0);
        contentValues.putAll(e(objectMetadata));
        if (cannedAccessControlList != null) {
            contentValues.put("canned_acl", cannedAccessControlList.toString());
        }
        if (transferUtilityOptions != null) {
            contentValues.put("transfer_utility_options", this.a.toJson(transferUtilityOptions));
        }
        return contentValues;
    }

    public final ContentValues e(ObjectMetadata objectMetadata) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_metadata", JsonUtils.e(objectMetadata.E()));
        contentValues.put("header_content_type", objectMetadata.q());
        contentValues.put("header_content_encoding", objectMetadata.n());
        contentValues.put("header_cache_control", objectMetadata.l());
        contentValues.put("content_md5", objectMetadata.p());
        contentValues.put("header_content_disposition", objectMetadata.m());
        contentValues.put("sse_algorithm", objectMetadata.z());
        contentValues.put("kms_key", objectMetadata.A());
        contentValues.put("expiration_time_rule_id", objectMetadata.t());
        if (objectMetadata.u() != null) {
            contentValues.put("http_expires_date", String.valueOf(objectMetadata.u().getTime()));
        }
        if (objectMetadata.D() != null) {
            contentValues.put("header_storage_class", objectMetadata.D());
        }
        return contentValues;
    }

    public final ContentValues f(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", transferType.toString());
        contentValues.put("state", TransferState.WAITING.toString());
        contentValues.put("bucket_name", str);
        contentValues.put("key", str2);
        contentValues.put("file", file.getAbsolutePath());
        contentValues.put("bytes_current", (Long) 0L);
        if (transferType.equals(TransferType.UPLOAD)) {
            contentValues.put("bytes_total", Long.valueOf(file != null ? file.length() : 0L));
        }
        contentValues.put("is_multipart", (Integer) 0);
        contentValues.put("part_num", (Integer) 0);
        contentValues.put("is_encrypted", (Integer) 0);
        contentValues.putAll(e(objectMetadata));
        if (cannedAccessControlList != null) {
            contentValues.put("canned_acl", cannedAccessControlList.toString());
        }
        if (transferUtilityOptions != null) {
            contentValues.put("transfer_utility_options", this.a.toJson(transferUtilityOptions));
        }
        return contentValues;
    }

    public List<UploadPartRequest> g(int i, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorF = null;
        try {
            cursorF = d.f(h(i), null, null, null, null);
            while (cursorF.moveToNext()) {
                if (!TransferState.PART_COMPLETED.equals(TransferState.getState(cursorF.getString(cursorF.getColumnIndexOrThrow("state"))))) {
                    UploadPartRequest uploadPartRequest = new UploadPartRequest();
                    uploadPartRequest.E(cursorF.getInt(cursorF.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX)));
                    uploadPartRequest.H(cursorF.getInt(cursorF.getColumnIndexOrThrow("main_upload_id")));
                    uploadPartRequest.B(cursorF.getString(cursorF.getColumnIndexOrThrow("bucket_name")));
                    uploadPartRequest.F(cursorF.getString(cursorF.getColumnIndexOrThrow("key")));
                    uploadPartRequest.L(str);
                    uploadPartRequest.C(new File(cursorF.getString(cursorF.getColumnIndexOrThrow("file"))));
                    uploadPartRequest.D(cursorF.getLong(cursorF.getColumnIndexOrThrow("file_offset")));
                    uploadPartRequest.J(cursorF.getInt(cursorF.getColumnIndexOrThrow("part_num")));
                    uploadPartRequest.K(cursorF.getLong(cursorF.getColumnIndexOrThrow("bytes_total")));
                    boolean z = true;
                    if (1 != cursorF.getInt(cursorF.getColumnIndexOrThrow("is_last_part"))) {
                        z = false;
                    }
                    uploadPartRequest.G(z);
                    arrayList.add(uploadPartRequest);
                }
            }
            return arrayList;
        } finally {
            if (cursorF != null) {
                cursorF.close();
            }
        }
    }

    public Uri h(int i) {
        return Uri.parse(d.d() + "/part/" + i);
    }

    public Uri i(int i) {
        return Uri.parse(d.d() + "/" + i);
    }

    public TransferRecord j(int i) throws Throwable {
        Cursor cursorN;
        Cursor cursor = null;
        TransferRecord transferRecord = null;
        try {
            cursorN = n(i);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorN.moveToFirst()) {
                transferRecord = new TransferRecord(i);
                transferRecord.j(cursorN);
            }
            if (cursorN != null) {
                cursorN.close();
            }
            return transferRecord;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorN;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public Uri k(TransferType transferType, String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferUtilityOptions transferUtilityOptions) {
        ContentValues contentValuesF = f(transferType, str, str2, file, objectMetadata, cannedAccessControlList, transferUtilityOptions);
        TransferDBBase transferDBBase = d;
        return transferDBBase.e(transferDBBase.d(), contentValuesF);
    }

    public long l(int i) {
        Cursor cursorF = null;
        try {
            cursorF = d.f(h(i), null, null, null, null);
            long j = 0;
            while (cursorF.moveToNext()) {
                if (TransferState.PART_COMPLETED.equals(TransferState.getState(cursorF.getString(cursorF.getColumnIndexOrThrow("state"))))) {
                    j += cursorF.getLong(cursorF.getColumnIndexOrThrow("bytes_total"));
                }
            }
            return j;
        } finally {
            if (cursorF != null) {
                cursorF.close();
            }
        }
    }

    public List<PartETag> m(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorF = null;
        try {
            cursorF = d.f(h(i), null, null, null, null);
            while (cursorF.moveToNext()) {
                arrayList.add(new PartETag(cursorF.getInt(cursorF.getColumnIndexOrThrow("part_num")), cursorF.getString(cursorF.getColumnIndexOrThrow("etag"))));
            }
            return arrayList;
        } finally {
            if (cursorF != null) {
                cursorF.close();
            }
        }
    }

    public Cursor n(int i) {
        return d.f(i(i), null, null, null, null);
    }

    public Cursor o(TransferType transferType, TransferState[] transferStateArr) {
        String str;
        String[] strArr;
        int length = transferStateArr.length;
        String strB = b(length);
        int i = 0;
        if (transferType == TransferType.ANY) {
            String str2 = "state in (" + strB + ")";
            String[] strArr2 = new String[length];
            while (i < length) {
                strArr2[i] = transferStateArr[i].toString();
                i++;
            }
            str = str2;
            strArr = strArr2;
        } else {
            String str3 = "state in (" + strB + ") and type" + RFC1522Codec.PREFIX;
            String[] strArr3 = new String[length + 1];
            while (i < length) {
                strArr3[i] = transferStateArr[i].toString();
                i++;
            }
            strArr3[i] = transferType.toString();
            str = str3;
            strArr = strArr3;
        }
        TransferDBBase transferDBBase = d;
        return transferDBBase.f(transferDBBase.d(), null, str, strArr, null);
    }

    public int p(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bytes_current", Long.valueOf(j));
        return d.g(i(i), contentValues, null, null);
    }

    public int q(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("etag", str);
        return d.g(i(i), contentValues, null, null);
    }

    public int r(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("multipart_id", str);
        return d.g(i(i), contentValues, null, null);
    }

    public int s(int i, TransferState transferState) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", transferState.toString());
        return TransferState.FAILED.equals(transferState) ? d.g(i(i), contentValues, "state not in (?,?,?,?,?) ", new String[]{TransferState.COMPLETED.toString(), TransferState.PENDING_NETWORK_DISCONNECT.toString(), TransferState.PAUSED.toString(), TransferState.CANCELED.toString(), TransferState.WAITING_FOR_NETWORK.toString()}) : d.g(i(i), contentValues, null, null);
    }

    public int t(TransferRecord transferRecord) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FieldType.FOREIGN_ID_FIELD_SUFFIX, Integer.valueOf(transferRecord.a));
        contentValues.put("state", transferRecord.j.toString());
        contentValues.put("bytes_total", Long.valueOf(transferRecord.f));
        contentValues.put("bytes_current", Long.valueOf(transferRecord.g));
        return d.g(i(transferRecord.a), contentValues, null, null);
    }
}
