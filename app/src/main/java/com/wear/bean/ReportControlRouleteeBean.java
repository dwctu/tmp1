package com.wear.bean;

import com.wear.bean.chat.MessageSelected;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportControlRouleteeBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/wear/bean/ReportControlRouleteeBean;", "", "()V", "chatHistory", "", "Lcom/wear/bean/chat/MessageSelected;", "getChatHistory", "()Ljava/util/List;", "setChatHistory", "(Ljava/util/List;)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "images", "", "getImages", "()[Ljava/lang/String;", "setImages", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "reportType", "getReportType", "setReportType", "reportUser", "getReportUser", "setReportUser", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ReportControlRouleteeBean {

    @Nullable
    private List<MessageSelected> chatHistory;

    @Nullable
    private String description;

    @Nullable
    private String[] images;

    @Nullable
    private String reportType;

    @Nullable
    private String reportUser;

    @Nullable
    public final List<MessageSelected> getChatHistory() {
        return this.chatHistory;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String[] getImages() {
        return this.images;
    }

    @Nullable
    public final String getReportType() {
        return this.reportType;
    }

    @Nullable
    public final String getReportUser() {
        return this.reportUser;
    }

    public final void setChatHistory(@Nullable List<MessageSelected> list) {
        this.chatHistory = list;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setImages(@Nullable String[] strArr) {
        this.images = strArr;
    }

    public final void setReportType(@Nullable String str) {
        this.reportType = str;
    }

    public final void setReportUser(@Nullable String str) {
        this.reportUser = str;
    }
}
