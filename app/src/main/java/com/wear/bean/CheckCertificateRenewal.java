package com.wear.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CheckCertificateRenewal.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/CheckCertificateRenewal;", "", "downloadToken", "", "certificatePwd", "list", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCertificatePwd", "()Ljava/lang/String;", "setCertificatePwd", "(Ljava/lang/String;)V", "getDownloadToken", "setDownloadToken", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CheckCertificateRenewal {

    @Nullable
    private String certificatePwd;

    @Nullable
    private String downloadToken;

    @Nullable
    private List<String> list;

    public CheckCertificateRenewal() {
        this(null, null, null, 7, null);
    }

    public CheckCertificateRenewal(@Nullable String str, @Nullable String str2, @Nullable List<String> list) {
        this.downloadToken = str;
        this.certificatePwd = str2;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CheckCertificateRenewal copy$default(CheckCertificateRenewal checkCertificateRenewal, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkCertificateRenewal.downloadToken;
        }
        if ((i & 2) != 0) {
            str2 = checkCertificateRenewal.certificatePwd;
        }
        if ((i & 4) != 0) {
            list = checkCertificateRenewal.list;
        }
        return checkCertificateRenewal.copy(str, str2, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getDownloadToken() {
        return this.downloadToken;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCertificatePwd() {
        return this.certificatePwd;
    }

    @Nullable
    public final List<String> component3() {
        return this.list;
    }

    @NotNull
    public final CheckCertificateRenewal copy(@Nullable String downloadToken, @Nullable String certificatePwd, @Nullable List<String> list) {
        return new CheckCertificateRenewal(downloadToken, certificatePwd, list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckCertificateRenewal)) {
            return false;
        }
        CheckCertificateRenewal checkCertificateRenewal = (CheckCertificateRenewal) other;
        return Intrinsics.areEqual(this.downloadToken, checkCertificateRenewal.downloadToken) && Intrinsics.areEqual(this.certificatePwd, checkCertificateRenewal.certificatePwd) && Intrinsics.areEqual(this.list, checkCertificateRenewal.list);
    }

    @Nullable
    public final String getCertificatePwd() {
        return this.certificatePwd;
    }

    @Nullable
    public final String getDownloadToken() {
        return this.downloadToken;
    }

    @Nullable
    public final List<String> getList() {
        return this.list;
    }

    public int hashCode() {
        String str = this.downloadToken;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.certificatePwd;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.list;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setCertificatePwd(@Nullable String str) {
        this.certificatePwd = str;
    }

    public final void setDownloadToken(@Nullable String str) {
        this.downloadToken = str;
    }

    public final void setList(@Nullable List<String> list) {
        this.list = list;
    }

    @NotNull
    public String toString() {
        return "CheckCertificateRenewal(downloadToken=" + this.downloadToken + ", certificatePwd=" + this.certificatePwd + ", list=" + this.list + ')';
    }

    public /* synthetic */ CheckCertificateRenewal(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : list);
    }
}
