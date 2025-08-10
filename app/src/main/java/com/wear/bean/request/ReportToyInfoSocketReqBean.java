package com.wear.bean.request;

import dc.pf2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReportToyInfoSocketReqBean.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/wear/bean/request/ReportToyInfoSocketReqBean;", "Lcom/wear/main/socketio/IMessage;", "data", "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getAction", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ReportToyInfoSocketReqBean implements pf2 {

    @NotNull
    private final String data;

    public ReportToyInfoSocketReqBean(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // dc.pf2
    @NotNull
    public String getAction() {
        return "report_toy_info_ts";
    }

    @NotNull
    public final String getData() {
        return this.data;
    }
}
