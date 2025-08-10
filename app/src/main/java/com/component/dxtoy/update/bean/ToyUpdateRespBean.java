package com.component.dxtoy.update.bean;

import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyUpdateRespBean.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jz\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0007HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00068"}, d2 = {"Lcom/component/dxtoy/update/bean/ToyUpdateRespBean;", "", "hasUpdate", "", ImagesContract.URL, "", "version", "", "md5", "publishPercentMark", "toyDfuName", "toyDfuUrl", "enable3dx", "macId", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getEnable3dx", "()Ljava/lang/Boolean;", "setEnable3dx", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHasUpdate", "setHasUpdate", "getMacId", "()Ljava/lang/String;", "setMacId", "(Ljava/lang/String;)V", "getMd5", "setMd5", "getPublishPercentMark", "setPublishPercentMark", "getToyDfuName", "setToyDfuName", "getToyDfuUrl", "setToyDfuUrl", "getUrl", "setUrl", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/component/dxtoy/update/bean/ToyUpdateRespBean;", "equals", "other", "hashCode", "toString", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ToyUpdateRespBean {

    @Nullable
    private Boolean enable3dx;

    @Nullable
    private Boolean hasUpdate;

    @Nullable
    private String macId;

    @Nullable
    private String md5;

    @Nullable
    private Boolean publishPercentMark;

    @Nullable
    private String toyDfuName;

    @Nullable
    private String toyDfuUrl;

    @Nullable
    private String url;

    @Nullable
    private Integer version;

    public ToyUpdateRespBean() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public ToyUpdateRespBean(@Nullable Boolean bool, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Boolean bool2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool3, @Nullable String str5) {
        this.hasUpdate = bool;
        this.url = str;
        this.version = num;
        this.md5 = str2;
        this.publishPercentMark = bool2;
        this.toyDfuName = str3;
        this.toyDfuUrl = str4;
        this.enable3dx = bool3;
        this.macId = str5;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getHasUpdate() {
        return this.hasUpdate;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getPublishPercentMark() {
        return this.publishPercentMark;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getToyDfuName() {
        return this.toyDfuName;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getToyDfuUrl() {
        return this.toyDfuUrl;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Boolean getEnable3dx() {
        return this.enable3dx;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getMacId() {
        return this.macId;
    }

    @NotNull
    public final ToyUpdateRespBean copy(@Nullable Boolean hasUpdate, @Nullable String url, @Nullable Integer version, @Nullable String md5, @Nullable Boolean publishPercentMark, @Nullable String toyDfuName, @Nullable String toyDfuUrl, @Nullable Boolean enable3dx, @Nullable String macId) {
        return new ToyUpdateRespBean(hasUpdate, url, version, md5, publishPercentMark, toyDfuName, toyDfuUrl, enable3dx, macId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyUpdateRespBean)) {
            return false;
        }
        ToyUpdateRespBean toyUpdateRespBean = (ToyUpdateRespBean) other;
        return Intrinsics.areEqual(this.hasUpdate, toyUpdateRespBean.hasUpdate) && Intrinsics.areEqual(this.url, toyUpdateRespBean.url) && Intrinsics.areEqual(this.version, toyUpdateRespBean.version) && Intrinsics.areEqual(this.md5, toyUpdateRespBean.md5) && Intrinsics.areEqual(this.publishPercentMark, toyUpdateRespBean.publishPercentMark) && Intrinsics.areEqual(this.toyDfuName, toyUpdateRespBean.toyDfuName) && Intrinsics.areEqual(this.toyDfuUrl, toyUpdateRespBean.toyDfuUrl) && Intrinsics.areEqual(this.enable3dx, toyUpdateRespBean.enable3dx) && Intrinsics.areEqual(this.macId, toyUpdateRespBean.macId);
    }

    @Nullable
    public final Boolean getEnable3dx() {
        return this.enable3dx;
    }

    @Nullable
    public final Boolean getHasUpdate() {
        return this.hasUpdate;
    }

    @Nullable
    public final String getMacId() {
        return this.macId;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    @Nullable
    public final Boolean getPublishPercentMark() {
        return this.publishPercentMark;
    }

    @Nullable
    public final String getToyDfuName() {
        return this.toyDfuName;
    }

    @Nullable
    public final String getToyDfuUrl() {
        return this.toyDfuUrl;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        Boolean bool = this.hasUpdate;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.url;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.version;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.md5;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool2 = this.publishPercentMark;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.toyDfuName;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.toyDfuUrl;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool3 = this.enable3dx;
        int iHashCode8 = (iHashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str5 = this.macId;
        return iHashCode8 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setEnable3dx(@Nullable Boolean bool) {
        this.enable3dx = bool;
    }

    public final void setHasUpdate(@Nullable Boolean bool) {
        this.hasUpdate = bool;
    }

    public final void setMacId(@Nullable String str) {
        this.macId = str;
    }

    public final void setMd5(@Nullable String str) {
        this.md5 = str;
    }

    public final void setPublishPercentMark(@Nullable Boolean bool) {
        this.publishPercentMark = bool;
    }

    public final void setToyDfuName(@Nullable String str) {
        this.toyDfuName = str;
    }

    public final void setToyDfuUrl(@Nullable String str) {
        this.toyDfuUrl = str;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    public final void setVersion(@Nullable Integer num) {
        this.version = num;
    }

    @NotNull
    public String toString() {
        return "ToyUpdateRespBean(hasUpdate=" + this.hasUpdate + ", url=" + this.url + ", version=" + this.version + ", md5=" + this.md5 + ", publishPercentMark=" + this.publishPercentMark + ", toyDfuName=" + this.toyDfuName + ", toyDfuUrl=" + this.toyDfuUrl + ", enable3dx=" + this.enable3dx + ", macId=" + this.macId + ')';
    }

    public /* synthetic */ ToyUpdateRespBean(Boolean bool, String str, Integer num, String str2, Boolean bool2, String str3, String str4, Boolean bool3, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? Boolean.FALSE : bool2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? Boolean.FALSE : bool3, (i & 256) == 0 ? str5 : null);
    }
}
