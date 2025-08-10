package com.component.dxbilog.lib.manual.bean.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogUploadLogReqBean.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0095\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020<HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\u0019\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020<HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015¨\u0006H"}, d2 = {"Lcom/component/dxbilog/lib/manual/bean/request/BILogUploadLogReqBean;", "Landroid/os/Parcelable;", "accountCode", "", "text", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "platform", "appType", "version", "deviceId", "sessionId", "openId", "model", "timezone", "language", "nettype", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountCode", "()Ljava/lang/String;", "setAccountCode", "(Ljava/lang/String;)V", "getAppType", "setAppType", "getDeviceId", "setDeviceId", "getLanguage", "setLanguage", "getModel", "setModel", "getNettype", "setNettype", "getOpenId", "setOpenId", "getPlatform", "setPlatform", "getSessionId", "setSessionId", "getText", "()Ljava/util/List;", "setText", "(Ljava/util/List;)V", "getTimezone", "setTimezone", "getVersion", "setVersion", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BILogUploadLogReqBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BILogUploadLogReqBean> CREATOR = new Creator();

    @NotNull
    private String accountCode;

    @NotNull
    private String appType;

    @Nullable
    private String deviceId;

    @Nullable
    private String language;

    @Nullable
    private String model;

    @Nullable
    private String nettype;

    @Nullable
    private String openId;

    @NotNull
    private String platform;

    @Nullable
    private String sessionId;

    @NotNull
    private List<BILogDbBean> text;

    @Nullable
    private String timezone;

    @NotNull
    private String version;

    /* compiled from: BILogUploadLogReqBean.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BILogUploadLogReqBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BILogUploadLogReqBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(parcel.readSerializable());
            }
            return new BILogUploadLogReqBean(string, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BILogUploadLogReqBean[] newArray(int i) {
            return new BILogUploadLogReqBean[i];
        }
    }

    public BILogUploadLogReqBean(@NotNull String accountCode, @NotNull List<BILogDbBean> text, @NotNull String platform, @NotNull String appType, @NotNull String version, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appType, "appType");
        Intrinsics.checkNotNullParameter(version, "version");
        this.accountCode = accountCode;
        this.text = text;
        this.platform = platform;
        this.appType = appType;
        this.version = version;
        this.deviceId = str;
        this.sessionId = str2;
        this.openId = str3;
        this.model = str4;
        this.timezone = str5;
        this.language = str6;
        this.nettype = str7;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAccountCode() {
        return this.accountCode;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getNettype() {
        return this.nettype;
    }

    @NotNull
    public final List<BILogDbBean> component2() {
        return this.text;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getAppType() {
        return this.appType;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final BILogUploadLogReqBean copy(@NotNull String accountCode, @NotNull List<BILogDbBean> text, @NotNull String platform, @NotNull String appType, @NotNull String version, @Nullable String deviceId, @Nullable String sessionId, @Nullable String openId, @Nullable String model, @Nullable String timezone, @Nullable String language, @Nullable String nettype) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appType, "appType");
        Intrinsics.checkNotNullParameter(version, "version");
        return new BILogUploadLogReqBean(accountCode, text, platform, appType, version, deviceId, sessionId, openId, model, timezone, language, nettype);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BILogUploadLogReqBean)) {
            return false;
        }
        BILogUploadLogReqBean bILogUploadLogReqBean = (BILogUploadLogReqBean) other;
        return Intrinsics.areEqual(this.accountCode, bILogUploadLogReqBean.accountCode) && Intrinsics.areEqual(this.text, bILogUploadLogReqBean.text) && Intrinsics.areEqual(this.platform, bILogUploadLogReqBean.platform) && Intrinsics.areEqual(this.appType, bILogUploadLogReqBean.appType) && Intrinsics.areEqual(this.version, bILogUploadLogReqBean.version) && Intrinsics.areEqual(this.deviceId, bILogUploadLogReqBean.deviceId) && Intrinsics.areEqual(this.sessionId, bILogUploadLogReqBean.sessionId) && Intrinsics.areEqual(this.openId, bILogUploadLogReqBean.openId) && Intrinsics.areEqual(this.model, bILogUploadLogReqBean.model) && Intrinsics.areEqual(this.timezone, bILogUploadLogReqBean.timezone) && Intrinsics.areEqual(this.language, bILogUploadLogReqBean.language) && Intrinsics.areEqual(this.nettype, bILogUploadLogReqBean.nettype);
    }

    @NotNull
    public final String getAccountCode() {
        return this.accountCode;
    }

    @NotNull
    public final String getAppType() {
        return this.appType;
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getModel() {
        return this.model;
    }

    @Nullable
    public final String getNettype() {
        return this.nettype;
    }

    @Nullable
    public final String getOpenId() {
        return this.openId;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @Nullable
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final List<BILogDbBean> getText() {
        return this.text;
    }

    @Nullable
    public final String getTimezone() {
        return this.timezone;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.accountCode.hashCode() * 31) + this.text.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.appType.hashCode()) * 31) + this.version.hashCode()) * 31;
        String str = this.deviceId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.openId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.model;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.timezone;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.language;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.nettype;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setAccountCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountCode = str;
    }

    public final void setAppType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appType = str;
    }

    public final void setDeviceId(@Nullable String str) {
        this.deviceId = str;
    }

    public final void setLanguage(@Nullable String str) {
        this.language = str;
    }

    public final void setModel(@Nullable String str) {
        this.model = str;
    }

    public final void setNettype(@Nullable String str) {
        this.nettype = str;
    }

    public final void setOpenId(@Nullable String str) {
        this.openId = str;
    }

    public final void setPlatform(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platform = str;
    }

    public final void setSessionId(@Nullable String str) {
        this.sessionId = str;
    }

    public final void setText(@NotNull List<BILogDbBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.text = list;
    }

    public final void setTimezone(@Nullable String str) {
        this.timezone = str;
    }

    public final void setVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    @NotNull
    public String toString() {
        return "BILogUploadLogReqBean(accountCode=" + this.accountCode + ", text=" + this.text + ", platform=" + this.platform + ", appType=" + this.appType + ", version=" + this.version + ", deviceId=" + ((Object) this.deviceId) + ", sessionId=" + ((Object) this.sessionId) + ", openId=" + ((Object) this.openId) + ", model=" + ((Object) this.model) + ", timezone=" + ((Object) this.timezone) + ", language=" + ((Object) this.language) + ", nettype=" + ((Object) this.nettype) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.accountCode);
        List<BILogDbBean> list = this.text;
        parcel.writeInt(list.size());
        Iterator<BILogDbBean> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeSerializable(it.next());
        }
        parcel.writeString(this.platform);
        parcel.writeString(this.appType);
        parcel.writeString(this.version);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.openId);
        parcel.writeString(this.model);
        parcel.writeString(this.timezone);
        parcel.writeString(this.language);
        parcel.writeString(this.nettype);
    }

    public /* synthetic */ BILogUploadLogReqBean(String str, List list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, list, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }
}
