package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: LogS009Bean.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/wear/bean/LogS009Bean;", "", "()V", "element_content", "", "getElement_content", "()Ljava/lang/String;", "setElement_content", "(Ljava/lang/String;)V", "element_id", "getElement_id", "setElement_id", "element_name", "getElement_name", "setElement_name", "element_type", "getElement_type", "setElement_type", "event_id", "getEvent_id", "setEvent_id", "event_type", "getEvent_type", "setEvent_type", "page_name", "getPage_name", "setPage_name", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LogS009Bean {

    @NotNull
    private String page_name = "";

    @NotNull
    private String event_id = "";

    @NotNull
    private String event_type = "";

    @NotNull
    private String element_id = "";

    @NotNull
    private String element_type = "";

    @NotNull
    private String element_content = "";

    @NotNull
    private String element_name = "";

    @NotNull
    public final String getElement_content() {
        return this.element_content;
    }

    @NotNull
    public final String getElement_id() {
        return this.element_id;
    }

    @NotNull
    public final String getElement_name() {
        return this.element_name;
    }

    @NotNull
    public final String getElement_type() {
        return this.element_type;
    }

    @NotNull
    public final String getEvent_id() {
        return this.event_id;
    }

    @NotNull
    public final String getEvent_type() {
        return this.event_type;
    }

    @NotNull
    public final String getPage_name() {
        return this.page_name;
    }

    public final void setElement_content(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.element_content = str;
    }

    public final void setElement_id(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.element_id = str;
    }

    public final void setElement_name(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.element_name = str;
    }

    public final void setElement_type(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.element_type = str;
    }

    public final void setEvent_id(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.event_id = str;
    }

    public final void setEvent_type(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.event_type = str;
    }

    public final void setPage_name(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.page_name = str;
    }
}
