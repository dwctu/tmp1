package com.component.dxbilog.lib.manual.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.component.dxbilog.lib.bean.BILogHttpConfigDefault;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dc.c;
import dc.ks;
import dc.me0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogHttpConfig.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b6\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0001JB\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0002\u0010\u0012J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u0091\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\t\u0010D\u001a\u00020\u0006HÖ\u0001J\u0019\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001e¨\u0006K"}, d2 = {"Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;", "Landroid/os/Parcelable;", "version", "", "logNoBlackList", "", "", "appVersionBlackList", "uploadTimeIntervalWifi", "", "uploadTimeIntervalData", "uploadMinTimeInterval", "singleUploadMaxSize", "singleLogMaxLength", "uploadSize", "failExpiredMaxNum", "failExpiredMaxDays", "normalExpiredMaxDays", "(ILjava/util/List;Ljava/util/List;DDDDIIIDD)V", "getAppVersionBlackList", "()Ljava/util/List;", "setAppVersionBlackList", "(Ljava/util/List;)V", "getFailExpiredMaxDays", "()D", "setFailExpiredMaxDays", "(D)V", "getFailExpiredMaxNum", "()I", "setFailExpiredMaxNum", "(I)V", "getLogNoBlackList", "setLogNoBlackList", "getNormalExpiredMaxDays", "setNormalExpiredMaxDays", "getSingleLogMaxLength", "setSingleLogMaxLength", "getSingleUploadMaxSize", "setSingleUploadMaxSize", "getUploadMinTimeInterval", "setUploadMinTimeInterval", "getUploadSize", "setUploadSize", "getUploadTimeIntervalData", "setUploadTimeIntervalData", "getUploadTimeIntervalWifi", "setUploadTimeIntervalWifi", "getVersion", "setVersion", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BILogHttpConfig implements Parcelable {

    @NotNull
    private static final String SP_BILOG_HTTP_CONFIG = "sp_bilog_http_config";

    @Nullable
    private List<String> appVersionBlackList;
    private double failExpiredMaxDays;
    private int failExpiredMaxNum;

    @Nullable
    private List<String> logNoBlackList;
    private double normalExpiredMaxDays;
    private int singleLogMaxLength;
    private double singleUploadMaxSize;
    private double uploadMinTimeInterval;
    private int uploadSize;
    private double uploadTimeIntervalData;
    private double uploadTimeIntervalWifi;
    private int version;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<BILogHttpConfig> CREATOR = new Creator();

    /* compiled from: BILogHttpConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig$Companion;", "", "()V", "SP_BILOG_HTTP_CONFIG", "", "load", "Lcom/component/dxbilog/lib/manual/bean/BILogHttpConfig;", "save", "", "config", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final BILogHttpConfig load() {
            return (BILogHttpConfig) me0.d(BILogHttpConfig.SP_BILOG_HTTP_CONFIG, BILogHttpConfig.class);
        }

        public final void save(@Nullable BILogHttpConfig config) {
            if (config == null) {
                me0.l(BILogHttpConfig.SP_BILOG_HTTP_CONFIG);
            } else {
                me0.i(BILogHttpConfig.SP_BILOG_HTTP_CONFIG, config);
            }
        }
    }

    /* compiled from: BILogHttpConfig.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BILogHttpConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BILogHttpConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BILogHttpConfig(parcel.readInt(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readDouble(), parcel.readDouble());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BILogHttpConfig[] newArray(int i) {
            return new BILogHttpConfig[i];
        }
    }

    public BILogHttpConfig() {
        this(0, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 0, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 4095, null);
    }

    public BILogHttpConfig(int i, @Nullable List<String> list, @Nullable List<String> list2, double d, double d2, double d3, double d4, int i2, int i3, int i4, double d5, double d6) {
        this.version = i;
        this.logNoBlackList = list;
        this.appVersionBlackList = list2;
        this.uploadTimeIntervalWifi = d;
        this.uploadTimeIntervalData = d2;
        this.uploadMinTimeInterval = d3;
        this.singleUploadMaxSize = d4;
        this.singleLogMaxLength = i2;
        this.uploadSize = i3;
        this.failExpiredMaxNum = i4;
        this.failExpiredMaxDays = d5;
        this.normalExpiredMaxDays = d6;
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component10, reason: from getter */
    public final int getFailExpiredMaxNum() {
        return this.failExpiredMaxNum;
    }

    /* renamed from: component11, reason: from getter */
    public final double getFailExpiredMaxDays() {
        return this.failExpiredMaxDays;
    }

    /* renamed from: component12, reason: from getter */
    public final double getNormalExpiredMaxDays() {
        return this.normalExpiredMaxDays;
    }

    @Nullable
    public final List<String> component2() {
        return this.logNoBlackList;
    }

    @Nullable
    public final List<String> component3() {
        return this.appVersionBlackList;
    }

    /* renamed from: component4, reason: from getter */
    public final double getUploadTimeIntervalWifi() {
        return this.uploadTimeIntervalWifi;
    }

    /* renamed from: component5, reason: from getter */
    public final double getUploadTimeIntervalData() {
        return this.uploadTimeIntervalData;
    }

    /* renamed from: component6, reason: from getter */
    public final double getUploadMinTimeInterval() {
        return this.uploadMinTimeInterval;
    }

    /* renamed from: component7, reason: from getter */
    public final double getSingleUploadMaxSize() {
        return this.singleUploadMaxSize;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSingleLogMaxLength() {
        return this.singleLogMaxLength;
    }

    /* renamed from: component9, reason: from getter */
    public final int getUploadSize() {
        return this.uploadSize;
    }

    @NotNull
    public final BILogHttpConfig copy(int version, @Nullable List<String> logNoBlackList, @Nullable List<String> appVersionBlackList, double uploadTimeIntervalWifi, double uploadTimeIntervalData, double uploadMinTimeInterval, double singleUploadMaxSize, int singleLogMaxLength, int uploadSize, int failExpiredMaxNum, double failExpiredMaxDays, double normalExpiredMaxDays) {
        return new BILogHttpConfig(version, logNoBlackList, appVersionBlackList, uploadTimeIntervalWifi, uploadTimeIntervalData, uploadMinTimeInterval, singleUploadMaxSize, singleLogMaxLength, uploadSize, failExpiredMaxNum, failExpiredMaxDays, normalExpiredMaxDays);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BILogHttpConfig)) {
            return false;
        }
        BILogHttpConfig bILogHttpConfig = (BILogHttpConfig) other;
        return this.version == bILogHttpConfig.version && Intrinsics.areEqual(this.logNoBlackList, bILogHttpConfig.logNoBlackList) && Intrinsics.areEqual(this.appVersionBlackList, bILogHttpConfig.appVersionBlackList) && Intrinsics.areEqual((Object) Double.valueOf(this.uploadTimeIntervalWifi), (Object) Double.valueOf(bILogHttpConfig.uploadTimeIntervalWifi)) && Intrinsics.areEqual((Object) Double.valueOf(this.uploadTimeIntervalData), (Object) Double.valueOf(bILogHttpConfig.uploadTimeIntervalData)) && Intrinsics.areEqual((Object) Double.valueOf(this.uploadMinTimeInterval), (Object) Double.valueOf(bILogHttpConfig.uploadMinTimeInterval)) && Intrinsics.areEqual((Object) Double.valueOf(this.singleUploadMaxSize), (Object) Double.valueOf(bILogHttpConfig.singleUploadMaxSize)) && this.singleLogMaxLength == bILogHttpConfig.singleLogMaxLength && this.uploadSize == bILogHttpConfig.uploadSize && this.failExpiredMaxNum == bILogHttpConfig.failExpiredMaxNum && Intrinsics.areEqual((Object) Double.valueOf(this.failExpiredMaxDays), (Object) Double.valueOf(bILogHttpConfig.failExpiredMaxDays)) && Intrinsics.areEqual((Object) Double.valueOf(this.normalExpiredMaxDays), (Object) Double.valueOf(bILogHttpConfig.normalExpiredMaxDays));
    }

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

    public int hashCode() {
        int i = this.version * 31;
        List<String> list = this.logNoBlackList;
        int iHashCode = (i + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.appVersionBlackList;
        return ((((((((((((((((((iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31) + c.a(this.uploadTimeIntervalWifi)) * 31) + c.a(this.uploadTimeIntervalData)) * 31) + c.a(this.uploadMinTimeInterval)) * 31) + c.a(this.singleUploadMaxSize)) * 31) + this.singleLogMaxLength) * 31) + this.uploadSize) * 31) + this.failExpiredMaxNum) * 31) + c.a(this.failExpiredMaxDays)) * 31) + c.a(this.normalExpiredMaxDays);
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

    @NotNull
    public String toString() {
        return "BILogHttpConfig(version=" + this.version + ", logNoBlackList=" + this.logNoBlackList + ", appVersionBlackList=" + this.appVersionBlackList + ", uploadTimeIntervalWifi=" + this.uploadTimeIntervalWifi + ", uploadTimeIntervalData=" + this.uploadTimeIntervalData + ", uploadMinTimeInterval=" + this.uploadMinTimeInterval + ", singleUploadMaxSize=" + this.singleUploadMaxSize + ", singleLogMaxLength=" + this.singleLogMaxLength + ", uploadSize=" + this.uploadSize + ", failExpiredMaxNum=" + this.failExpiredMaxNum + ", failExpiredMaxDays=" + this.failExpiredMaxDays + ", normalExpiredMaxDays=" + this.normalExpiredMaxDays + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.version);
        parcel.writeStringList(this.logNoBlackList);
        parcel.writeStringList(this.appVersionBlackList);
        parcel.writeDouble(this.uploadTimeIntervalWifi);
        parcel.writeDouble(this.uploadTimeIntervalData);
        parcel.writeDouble(this.uploadMinTimeInterval);
        parcel.writeDouble(this.singleUploadMaxSize);
        parcel.writeInt(this.singleLogMaxLength);
        parcel.writeInt(this.uploadSize);
        parcel.writeInt(this.failExpiredMaxNum);
        parcel.writeDouble(this.failExpiredMaxDays);
        parcel.writeDouble(this.normalExpiredMaxDays);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ BILogHttpConfig(int i, List list, List list2, double d, double d2, double d3, double d4, int i2, int i3, int i4, double d5, double d6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int version;
        List logNoBlackList;
        double uploadTimeIntervalWifi;
        double uploadTimeIntervalData;
        double uploadMinTimeInterval;
        double singleUploadMaxSize;
        int singleLogMaxLength;
        int uploadSize;
        int failExpiredMaxNum;
        double failExpiredMaxDays;
        double normalExpiredMaxDays;
        if ((i5 & 1) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC = ks.a.b().c();
            version = bILogHttpConfigDefaultC == null ? 0 : bILogHttpConfigDefaultC.getVersion();
        } else {
            version = i;
        }
        List appVersionBlackList = null;
        if ((i5 & 2) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC2 = ks.a.b().c();
            logNoBlackList = bILogHttpConfigDefaultC2 == null ? null : bILogHttpConfigDefaultC2.getLogNoBlackList();
        } else {
            logNoBlackList = list;
        }
        if ((i5 & 4) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC3 = ks.a.b().c();
            if (bILogHttpConfigDefaultC3 != null) {
                appVersionBlackList = bILogHttpConfigDefaultC3.getAppVersionBlackList();
            }
        } else {
            appVersionBlackList = list2;
        }
        if ((i5 & 8) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC4 = ks.a.b().c();
            uploadTimeIntervalWifi = bILogHttpConfigDefaultC4 == null ? 30.0d : bILogHttpConfigDefaultC4.getUploadTimeIntervalWifi();
        } else {
            uploadTimeIntervalWifi = d;
        }
        if ((i5 & 16) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC5 = ks.a.b().c();
            uploadTimeIntervalData = bILogHttpConfigDefaultC5 == null ? 120.0d : bILogHttpConfigDefaultC5.getUploadTimeIntervalData();
        } else {
            uploadTimeIntervalData = d2;
        }
        if ((i5 & 32) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC6 = ks.a.b().c();
            uploadMinTimeInterval = bILogHttpConfigDefaultC6 == null ? 2.0d : bILogHttpConfigDefaultC6.getUploadMinTimeInterval();
        } else {
            uploadMinTimeInterval = d3;
        }
        if ((i5 & 64) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC7 = ks.a.b().c();
            singleUploadMaxSize = bILogHttpConfigDefaultC7 == null ? 2.0d : bILogHttpConfigDefaultC7.getSingleUploadMaxSize();
        } else {
            singleUploadMaxSize = d4;
        }
        if ((i5 & 128) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC8 = ks.a.b().c();
            singleLogMaxLength = bILogHttpConfigDefaultC8 == null ? 20000 : bILogHttpConfigDefaultC8.getSingleLogMaxLength();
        } else {
            singleLogMaxLength = i2;
        }
        if ((i5 & 256) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC9 = ks.a.b().c();
            uploadSize = bILogHttpConfigDefaultC9 == null ? 50 : bILogHttpConfigDefaultC9.getUploadSize();
        } else {
            uploadSize = i3;
        }
        if ((i5 & 512) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC10 = ks.a.b().c();
            failExpiredMaxNum = bILogHttpConfigDefaultC10 == null ? 3 : bILogHttpConfigDefaultC10.getFailExpiredMaxNum();
        } else {
            failExpiredMaxNum = i4;
        }
        if ((i5 & 1024) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC11 = ks.a.b().c();
            failExpiredMaxDays = bILogHttpConfigDefaultC11 == null ? 7.0d : bILogHttpConfigDefaultC11.getFailExpiredMaxDays();
        } else {
            failExpiredMaxDays = d5;
        }
        if ((i5 & 2048) != 0) {
            BILogHttpConfigDefault bILogHttpConfigDefaultC12 = ks.a.b().c();
            normalExpiredMaxDays = bILogHttpConfigDefaultC12 == null ? 15.0d : bILogHttpConfigDefaultC12.getNormalExpiredMaxDays();
        } else {
            normalExpiredMaxDays = d6;
        }
        this(version, logNoBlackList, appVersionBlackList, uploadTimeIntervalWifi, uploadTimeIntervalData, uploadMinTimeInterval, singleUploadMaxSize, singleLogMaxLength, uploadSize, failExpiredMaxNum, failExpiredMaxDays, normalExpiredMaxDays);
    }
}
