package com.wear.bean.chat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportActionMenuBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/wear/bean/chat/ReportActionMenuBean;", "", MessageBundle.TITLE_ENTRY, "", "type", "", "report_reason", "(Ljava/lang/String;ILjava/lang/String;)V", "getReport_reason", "()Ljava/lang/String;", "getTitle", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ReportActionMenuBean {

    @NotNull
    private final String report_reason;

    @NotNull
    private final String title;
    private final int type;

    public ReportActionMenuBean(@NotNull String title, int i, @NotNull String report_reason) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(report_reason, "report_reason");
        this.title = title;
        this.type = i;
        this.report_reason = report_reason;
    }

    public static /* synthetic */ ReportActionMenuBean copy$default(ReportActionMenuBean reportActionMenuBean, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = reportActionMenuBean.title;
        }
        if ((i2 & 2) != 0) {
            i = reportActionMenuBean.type;
        }
        if ((i2 & 4) != 0) {
            str2 = reportActionMenuBean.report_reason;
        }
        return reportActionMenuBean.copy(str, i, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getReport_reason() {
        return this.report_reason;
    }

    @NotNull
    public final ReportActionMenuBean copy(@NotNull String title, int type, @NotNull String report_reason) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(report_reason, "report_reason");
        return new ReportActionMenuBean(title, type, report_reason);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportActionMenuBean)) {
            return false;
        }
        ReportActionMenuBean reportActionMenuBean = (ReportActionMenuBean) other;
        return Intrinsics.areEqual(this.title, reportActionMenuBean.title) && this.type == reportActionMenuBean.type && Intrinsics.areEqual(this.report_reason, reportActionMenuBean.report_reason);
    }

    @NotNull
    public final String getReport_reason() {
        return this.report_reason;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.type) * 31) + this.report_reason.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReportActionMenuBean(title=" + this.title + ", type=" + this.type + ", report_reason=" + this.report_reason + ')';
    }
}
