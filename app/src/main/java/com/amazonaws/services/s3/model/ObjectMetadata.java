package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.ObjectRestoreResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.util.DateUtils;
import com.google.common.net.HttpHeaders;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class ObjectMetadata implements ServerSideEncryptionResult, S3RequesterChargedResult, ObjectExpirationResult, ObjectRestoreResult, Cloneable, Serializable {
    public static final String a;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private Date httpExpiresDate;
    private Map<String, Object> metadata;
    private Boolean ongoingRestore;
    private Date restoreExpirationTime;
    private Map<String, String> userMetadata;

    static {
        SSEAlgorithm.AES256.getAlgorithm();
        a = SSEAlgorithm.KMS.getAlgorithm();
    }

    public ObjectMetadata() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.userMetadata = new TreeMap(comparator);
        this.metadata = new TreeMap(comparator);
    }

    public String A() {
        return (String) this.metadata.get("x-amz-server-side-encryption-aws-kms-key-id");
    }

    public String B() {
        return (String) this.metadata.get("x-amz-server-side-encryption-customer-algorithm");
    }

    public String C() {
        return (String) this.metadata.get("x-amz-server-side-encryption-customer-key-MD5");
    }

    public String D() {
        Object obj = this.metadata.get("x-amz-storage-class");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Map<String, String> E() {
        return this.userMetadata;
    }

    public String F() {
        return (String) this.metadata.get("x-amz-version-id");
    }

    public boolean G() {
        return this.metadata.get("x-amz-request-charged") != null;
    }

    public void H(String str) {
        this.metadata.put(HttpHeaders.CACHE_CONTROL, str);
    }

    public void J(String str) {
        this.metadata.put("Content-Disposition", str);
    }

    public void K(String str) {
        this.metadata.put(HttpHeaders.CONTENT_ENCODING, str);
    }

    public void L(long j) {
        this.metadata.put(HttpHeaders.CONTENT_LENGTH, Long.valueOf(j));
    }

    public void M(String str) {
        if (str == null) {
            this.metadata.remove(HttpHeaders.CONTENT_MD5);
        } else {
            this.metadata.put(HttpHeaders.CONTENT_MD5, str);
        }
    }

    public void N(String str) {
        this.metadata.put("Content-Type", str);
    }

    public void P(String str, Object obj) {
        this.metadata.put(str, obj);
    }

    public void Q(Date date) {
        this.httpExpiresDate = date;
    }

    public void R(Map<String, String> map) {
        this.userMetadata = map;
    }

    @Override // com.amazonaws.services.s3.internal.ObjectRestoreResult
    public void a(Date date) {
        this.restoreExpirationTime = date;
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public void b(String str) {
        this.metadata.put("x-amz-server-side-encryption-customer-algorithm", str);
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void c(String str) {
        this.expirationTimeRuleId = str;
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void d(Date date) {
        this.expirationTime = date;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void e(boolean z) {
        if (z) {
            this.metadata.put("x-amz-request-charged", "requester");
        }
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public void f(String str) {
        this.metadata.put("x-amz-server-side-encryption", str);
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public void g(String str) {
        this.metadata.put("x-amz-server-side-encryption-customer-key-MD5", str);
    }

    @Override // com.amazonaws.services.s3.internal.ObjectRestoreResult
    public void h(boolean z) {
        this.ongoingRestore = Boolean.valueOf(z);
    }

    public void i(String str, String str2) {
        this.userMetadata.put(str, str2);
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public ObjectMetadata clone() {
        return new ObjectMetadata(this);
    }

    public String l() {
        return (String) this.metadata.get(HttpHeaders.CACHE_CONTROL);
    }

    public String m() {
        return (String) this.metadata.get("Content-Disposition");
    }

    public String n() {
        return (String) this.metadata.get(HttpHeaders.CONTENT_ENCODING);
    }

    public long o() {
        Long l = (Long) this.metadata.get(HttpHeaders.CONTENT_LENGTH);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public String p() {
        return (String) this.metadata.get(HttpHeaders.CONTENT_MD5);
    }

    public String q() {
        return (String) this.metadata.get("Content-Type");
    }

    public String r() {
        return (String) this.metadata.get(HttpHeaders.ETAG);
    }

    public Date s() {
        return DateUtils.b(this.expirationTime);
    }

    public String t() {
        return this.expirationTimeRuleId;
    }

    public Date u() {
        return DateUtils.b(this.httpExpiresDate);
    }

    public long v() {
        int iLastIndexOf;
        String str = (String) this.metadata.get(HttpHeaders.CONTENT_RANGE);
        return (str == null || (iLastIndexOf = str.lastIndexOf("/")) < 0) ? o() : Long.parseLong(str.substring(iLastIndexOf + 1));
    }

    public Map<String, Object> w() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(this.metadata);
        return Collections.unmodifiableMap(treeMap);
    }

    public Object x(String str) {
        return this.metadata.get(str);
    }

    public String z() {
        return (String) this.metadata.get("x-amz-server-side-encryption");
    }

    public ObjectMetadata(ObjectMetadata objectMetadata) {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.userMetadata = new TreeMap(comparator);
        this.metadata = new TreeMap(comparator);
        this.userMetadata = objectMetadata.userMetadata == null ? null : new TreeMap(objectMetadata.userMetadata);
        this.metadata = objectMetadata.metadata != null ? new TreeMap(objectMetadata.metadata) : null;
        this.expirationTime = DateUtils.b(objectMetadata.expirationTime);
        this.expirationTimeRuleId = objectMetadata.expirationTimeRuleId;
        this.httpExpiresDate = DateUtils.b(objectMetadata.httpExpiresDate);
        this.ongoingRestore = objectMetadata.ongoingRestore;
        this.restoreExpirationTime = DateUtils.b(objectMetadata.restoreExpirationTime);
    }
}
