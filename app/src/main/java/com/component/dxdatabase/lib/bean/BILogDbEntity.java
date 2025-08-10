package com.component.dxdatabase.lib.bean;

import androidx.room.Entity;
import com.component.dxdatabase.lib.base.bean.DbBaseEntity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* compiled from: BILogDbEntity.kt */
@Entity
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001c\u0010&\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001a\u0010,\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/component/dxdatabase/lib/bean/BILogDbEntity;", "Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "()V", "accountCode", "", "getAccountCode", "()Ljava/lang/String;", "setAccountCode", "(Ljava/lang/String;)V", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "getAppVersion", "setAppVersion", "byteSize", "", "getByteSize", "()Ljava/lang/Integer;", "setByteSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", FirebaseAnalytics.Param.CONTENT, "getContent", "setContent", "failCount", "getFailCount", "setFailCount", "logNo", "getLogNo", "setLogNo", "nextUploadTime", "", "getNextUploadTime", "()Ljava/lang/Long;", "setNextUploadTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "openId", "getOpenId", "setOpenId", "pageName", "getPageName", "setPageName", JivePropertiesExtension.ELEMENT, "getProperties", "setProperties", "timeStamp", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BILogDbEntity extends DbBaseEntity {

    @Nullable
    private String accountCode;

    @Nullable
    private String appVersion;

    @Nullable
    private Integer byteSize;

    @Nullable
    private String content;

    @Nullable
    private Integer failCount;

    @Nullable
    private String logNo;

    @Nullable
    private Long nextUploadTime;

    @Nullable
    private String openId;

    @Nullable
    private String pageName;

    @Nullable
    private String properties;
    private long timeStamp;

    @Nullable
    public final String getAccountCode() {
        return this.accountCode;
    }

    @Nullable
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public final Integer getByteSize() {
        return this.byteSize;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Integer getFailCount() {
        return this.failCount;
    }

    @Nullable
    public final String getLogNo() {
        return this.logNo;
    }

    @Nullable
    public final Long getNextUploadTime() {
        return this.nextUploadTime;
    }

    @Nullable
    public final String getOpenId() {
        return this.openId;
    }

    @Nullable
    public final String getPageName() {
        return this.pageName;
    }

    @Nullable
    public final String getProperties() {
        return this.properties;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final void setAccountCode(@Nullable String str) {
        this.accountCode = str;
    }

    public final void setAppVersion(@Nullable String str) {
        this.appVersion = str;
    }

    public final void setByteSize(@Nullable Integer num) {
        this.byteSize = num;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setFailCount(@Nullable Integer num) {
        this.failCount = num;
    }

    public final void setLogNo(@Nullable String str) {
        this.logNo = str;
    }

    public final void setNextUploadTime(@Nullable Long l) {
        this.nextUploadTime = l;
    }

    public final void setOpenId(@Nullable String str) {
        this.openId = str;
    }

    public final void setPageName(@Nullable String str) {
        this.pageName = str;
    }

    public final void setProperties(@Nullable String str) {
        this.properties = str;
    }

    public final void setTimeStamp(long j) {
        this.timeStamp = j;
    }
}
