package com.component.dxdlog.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogServerResponseBean.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r¨\u0006("}, d2 = {"Lcom/component/dxdlog/bean/SessionToken;", "", "sessionToken", "", "secretAccessKey", "accessKeyId", "bucketName", TtmlNode.TAG_REGION, "durationSeconds", "", "objectKeyPrefix", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getBucketName", "getDurationSeconds", "()I", "expireTime", "", "getExpireTime", "()J", "setExpireTime", "(J)V", "getObjectKeyPrefix", "getRegion", "getSecretAccessKey", "getSessionToken", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SessionToken {

    @NotNull
    private final String accessKeyId;

    @NotNull
    private final String bucketName;
    private final int durationSeconds;
    private long expireTime;

    @NotNull
    private final String objectKeyPrefix;

    @NotNull
    private final String region;

    @NotNull
    private final String secretAccessKey;

    @NotNull
    private final String sessionToken;

    public SessionToken(@NotNull String sessionToken, @NotNull String secretAccessKey, @NotNull String accessKeyId, @NotNull String bucketName, @NotNull String region, int i, @NotNull String objectKeyPrefix) {
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(bucketName, "bucketName");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(objectKeyPrefix, "objectKeyPrefix");
        this.sessionToken = sessionToken;
        this.secretAccessKey = secretAccessKey;
        this.accessKeyId = accessKeyId;
        this.bucketName = bucketName;
        this.region = region;
        this.durationSeconds = i;
        this.objectKeyPrefix = objectKeyPrefix;
    }

    public static /* synthetic */ SessionToken copy$default(SessionToken sessionToken, String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sessionToken.sessionToken;
        }
        if ((i2 & 2) != 0) {
            str2 = sessionToken.secretAccessKey;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = sessionToken.accessKeyId;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = sessionToken.bucketName;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = sessionToken.region;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            i = sessionToken.durationSeconds;
        }
        int i3 = i;
        if ((i2 & 64) != 0) {
            str6 = sessionToken.objectKeyPrefix;
        }
        return sessionToken.copy(str, str7, str8, str9, str10, i3, str6);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSessionToken() {
        return this.sessionToken;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getBucketName() {
        return this.bucketName;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDurationSeconds() {
        return this.durationSeconds;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getObjectKeyPrefix() {
        return this.objectKeyPrefix;
    }

    @NotNull
    public final SessionToken copy(@NotNull String sessionToken, @NotNull String secretAccessKey, @NotNull String accessKeyId, @NotNull String bucketName, @NotNull String region, int durationSeconds, @NotNull String objectKeyPrefix) {
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(bucketName, "bucketName");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(objectKeyPrefix, "objectKeyPrefix");
        return new SessionToken(sessionToken, secretAccessKey, accessKeyId, bucketName, region, durationSeconds, objectKeyPrefix);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionToken)) {
            return false;
        }
        SessionToken sessionToken = (SessionToken) other;
        return Intrinsics.areEqual(this.sessionToken, sessionToken.sessionToken) && Intrinsics.areEqual(this.secretAccessKey, sessionToken.secretAccessKey) && Intrinsics.areEqual(this.accessKeyId, sessionToken.accessKeyId) && Intrinsics.areEqual(this.bucketName, sessionToken.bucketName) && Intrinsics.areEqual(this.region, sessionToken.region) && this.durationSeconds == sessionToken.durationSeconds && Intrinsics.areEqual(this.objectKeyPrefix, sessionToken.objectKeyPrefix);
    }

    @NotNull
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    @NotNull
    public final String getBucketName() {
        return this.bucketName;
    }

    public final int getDurationSeconds() {
        return this.durationSeconds;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    @NotNull
    public final String getObjectKeyPrefix() {
        return this.objectKeyPrefix;
    }

    @NotNull
    public final String getRegion() {
        return this.region;
    }

    @NotNull
    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    @NotNull
    public final String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        return (((((((((((this.sessionToken.hashCode() * 31) + this.secretAccessKey.hashCode()) * 31) + this.accessKeyId.hashCode()) * 31) + this.bucketName.hashCode()) * 31) + this.region.hashCode()) * 31) + this.durationSeconds) * 31) + this.objectKeyPrefix.hashCode();
    }

    public final void setExpireTime(long j) {
        this.expireTime = j;
    }

    @NotNull
    public String toString() {
        return "SessionToken(sessionToken=" + this.sessionToken + ", secretAccessKey=" + this.secretAccessKey + ", accessKeyId=" + this.accessKeyId + ", bucketName=" + this.bucketName + ", region=" + this.region + ", durationSeconds=" + this.durationSeconds + ", objectKeyPrefix=" + this.objectKeyPrefix + ')';
    }
}
