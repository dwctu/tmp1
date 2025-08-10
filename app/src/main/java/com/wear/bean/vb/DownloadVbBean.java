package com.wear.bean.vb;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.wear.bean.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DownloadVbBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/wear/bean/vb/DownloadVbBean;", "", Pattern.DOWNLOAD, "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "suffix", "", "(Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/String;)V", "getDownload", "()Ljava/lang/Boolean;", "setDownload", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getParams", "()Ljava/lang/Object;", "setParams", "(Ljava/lang/Object;)V", "getSuffix", "()Ljava/lang/String;", "setSuffix", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/String;)Lcom/wear/bean/vb/DownloadVbBean;", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DownloadVbBean {

    @Nullable
    private Boolean download;

    @Nullable
    private Object params;

    @Nullable
    private String suffix;

    public DownloadVbBean() {
        this(null, null, null, 7, null);
    }

    public DownloadVbBean(@Nullable Boolean bool, @Nullable Object obj, @Nullable String str) {
        this.download = bool;
        this.params = obj;
        this.suffix = str;
    }

    public static /* synthetic */ DownloadVbBean copy$default(DownloadVbBean downloadVbBean, Boolean bool, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            bool = downloadVbBean.download;
        }
        if ((i & 2) != 0) {
            obj = downloadVbBean.params;
        }
        if ((i & 4) != 0) {
            str = downloadVbBean.suffix;
        }
        return downloadVbBean.copy(bool, obj, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getDownload() {
        return this.download;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Object getParams() {
        return this.params;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSuffix() {
        return this.suffix;
    }

    @NotNull
    public final DownloadVbBean copy(@Nullable Boolean download, @Nullable Object params, @Nullable String suffix) {
        return new DownloadVbBean(download, params, suffix);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadVbBean)) {
            return false;
        }
        DownloadVbBean downloadVbBean = (DownloadVbBean) other;
        return Intrinsics.areEqual(this.download, downloadVbBean.download) && Intrinsics.areEqual(this.params, downloadVbBean.params) && Intrinsics.areEqual(this.suffix, downloadVbBean.suffix);
    }

    @Nullable
    public final Boolean getDownload() {
        return this.download;
    }

    @Nullable
    public final Object getParams() {
        return this.params;
    }

    @Nullable
    public final String getSuffix() {
        return this.suffix;
    }

    public int hashCode() {
        Boolean bool = this.download;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Object obj = this.params;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        String str = this.suffix;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setDownload(@Nullable Boolean bool) {
        this.download = bool;
    }

    public final void setParams(@Nullable Object obj) {
        this.params = obj;
    }

    public final void setSuffix(@Nullable String str) {
        this.suffix = str;
    }

    @NotNull
    public String toString() {
        return "DownloadVbBean(download=" + this.download + ", params=" + this.params + ", suffix=" + this.suffix + ')';
    }

    public /* synthetic */ DownloadVbBean(Boolean bool, Object obj, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : str);
    }
}
