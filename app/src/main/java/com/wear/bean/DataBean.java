package com.wear.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatgptAudioBookTtsNotify.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/wear/bean/DataBean;", "", "()V", "leftTimes", "", "getLeftTimes", "()Ljava/lang/Integer;", "setLeftTimes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sessionTaskId", "", "getSessionTaskId", "()Ljava/lang/String;", "setSessionTaskId", "(Ljava/lang/String;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DataBean {

    @Nullable
    private String sessionTaskId = "";

    @Nullable
    private Integer leftTimes = 0;

    @Nullable
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    @Nullable
    public final String getSessionTaskId() {
        return this.sessionTaskId;
    }

    public final void setLeftTimes(@Nullable Integer num) {
        this.leftTimes = num;
    }

    public final void setSessionTaskId(@Nullable String str) {
        this.sessionTaskId = str;
    }
}
