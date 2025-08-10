package com.component.dxbilog.lib.bean;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogHttpConfigDefault.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b!\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001a\u0010%\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001a\u0010(\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001a\u0010+\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015¨\u00062"}, d2 = {"Lcom/component/dxbilog/lib/bean/BILogHttpConfigDefault;", "", "()V", "appVersionBlackList", "", "", "getAppVersionBlackList", "()Ljava/util/List;", "setAppVersionBlackList", "(Ljava/util/List;)V", "failExpiredMaxDays", "", "getFailExpiredMaxDays", "()D", "setFailExpiredMaxDays", "(D)V", "failExpiredMaxNum", "", "getFailExpiredMaxNum", "()I", "setFailExpiredMaxNum", "(I)V", "logNoBlackList", "getLogNoBlackList", "setLogNoBlackList", "normalExpiredMaxDays", "getNormalExpiredMaxDays", "setNormalExpiredMaxDays", "singleLogMaxLength", "getSingleLogMaxLength", "setSingleLogMaxLength", "singleUploadMaxSize", "getSingleUploadMaxSize", "setSingleUploadMaxSize", "uploadMinTimeInterval", "getUploadMinTimeInterval", "setUploadMinTimeInterval", "uploadSize", "getUploadSize", "setUploadSize", "uploadTimeIntervalData", "getUploadTimeIntervalData", "setUploadTimeIntervalData", "uploadTimeIntervalWifi", "getUploadTimeIntervalWifi", "setUploadTimeIntervalWifi", "version", "getVersion", "setVersion", "Companion", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogHttpConfigDefault {
    public static final double DEFAULT_FAIL_EXPIRED_MAX_DAYS = 7.0d;
    public static final int DEFAULT_FAIL_EXPIRED_MAX_NUM = 3;
    public static final double DEFAULT_NORMAL_EXPIRED_MAX_DAYS = 15.0d;
    public static final int DEFAULT_SINGLE_LOG_MAX_LENGTH = 20000;
    public static final double DEFAULT_SINGLE_UPLOAD_MAX_SIZE = 2.0d;
    public static final double DEFAULT_UPLOAD_MIN_TIME_INTERVAL = 2.0d;
    public static final int DEFAULT_UPLOAD_SIZE = 50;
    public static final double DEFAULT_UPLOAD_TIME_INTERVAL_DATA = 120.0d;
    public static final double DEFAULT_UPLOAD_TIME_INTERVAL_WIFI = 30.0d;
    public static final int DEFAULT_VERSION = 0;

    @Nullable
    private List<String> appVersionBlackList;

    @Nullable
    private List<String> logNoBlackList;
    private int version;
    private double uploadTimeIntervalWifi = 30.0d;
    private double uploadTimeIntervalData = 120.0d;
    private double uploadMinTimeInterval = 2.0d;
    private double singleUploadMaxSize = 2.0d;
    private int singleLogMaxLength = 20000;
    private int uploadSize = 50;
    private int failExpiredMaxNum = 3;
    private double failExpiredMaxDays = 7.0d;
    private double normalExpiredMaxDays = 15.0d;

    @Nullable
    public final List<String> getAppVersionBlackList() {
        return this.appVersionBlackList;
    }

    public final double getFailExpiredMaxDays() {
        return this.failExpiredMaxDays;
    }

    public final int getFailExpiredMaxNum() {
        return this.failExpiredMaxNum;
    }

    @Nullable
    public final List<String> getLogNoBlackList() {
        return this.logNoBlackList;
    }

    public final double getNormalExpiredMaxDays() {
        return this.normalExpiredMaxDays;
    }

    public final int getSingleLogMaxLength() {
        return this.singleLogMaxLength;
    }

    public final double getSingleUploadMaxSize() {
        return this.singleUploadMaxSize;
    }

    public final double getUploadMinTimeInterval() {
        return this.uploadMinTimeInterval;
    }

    public final int getUploadSize() {
        return this.uploadSize;
    }

    public final double getUploadTimeIntervalData() {
        return this.uploadTimeIntervalData;
    }

    public final double getUploadTimeIntervalWifi() {
        return this.uploadTimeIntervalWifi;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setAppVersionBlackList(@Nullable List<String> list) {
        this.appVersionBlackList = list;
    }

    public final void setFailExpiredMaxDays(double d) {
        this.failExpiredMaxDays = d;
    }

    public final void setFailExpiredMaxNum(int i) {
        this.failExpiredMaxNum = i;
    }

    public final void setLogNoBlackList(@Nullable List<String> list) {
        this.logNoBlackList = list;
    }

    public final void setNormalExpiredMaxDays(double d) {
        this.normalExpiredMaxDays = d;
    }

    public final void setSingleLogMaxLength(int i) {
        this.singleLogMaxLength = i;
    }

    public final void setSingleUploadMaxSize(double d) {
        this.singleUploadMaxSize = d;
    }

    public final void setUploadMinTimeInterval(double d) {
        this.uploadMinTimeInterval = d;
    }

    public final void setUploadSize(int i) {
        this.uploadSize = i;
    }

    public final void setUploadTimeIntervalData(double d) {
        this.uploadTimeIntervalData = d;
    }

    public final void setUploadTimeIntervalWifi(double d) {
        this.uploadTimeIntervalWifi = d;
    }

    public final void setVersion(int i) {
        this.version = i;
    }
}
