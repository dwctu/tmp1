package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatFunctionMenuBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/wear/bean/ChatFunctionMenuBean;", "", "functionName", "", "functionId", "", "functionIcon", "(Ljava/lang/String;II)V", "getFunctionIcon", "()I", "setFunctionIcon", "(I)V", "getFunctionId", "setFunctionId", "getFunctionName", "()Ljava/lang/String;", "setFunctionName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatFunctionMenuBean {
    private int functionIcon;
    private int functionId;

    @NotNull
    private String functionName;

    public ChatFunctionMenuBean(@NotNull String functionName, int i, int i2) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.functionName = functionName;
        this.functionId = i;
        this.functionIcon = i2;
    }

    public static /* synthetic */ ChatFunctionMenuBean copy$default(ChatFunctionMenuBean chatFunctionMenuBean, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = chatFunctionMenuBean.functionName;
        }
        if ((i3 & 2) != 0) {
            i = chatFunctionMenuBean.functionId;
        }
        if ((i3 & 4) != 0) {
            i2 = chatFunctionMenuBean.functionIcon;
        }
        return chatFunctionMenuBean.copy(str, i, i2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFunctionName() {
        return this.functionName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFunctionId() {
        return this.functionId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFunctionIcon() {
        return this.functionIcon;
    }

    @NotNull
    public final ChatFunctionMenuBean copy(@NotNull String functionName, int functionId, int functionIcon) {
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return new ChatFunctionMenuBean(functionName, functionId, functionIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatFunctionMenuBean)) {
            return false;
        }
        ChatFunctionMenuBean chatFunctionMenuBean = (ChatFunctionMenuBean) other;
        return Intrinsics.areEqual(this.functionName, chatFunctionMenuBean.functionName) && this.functionId == chatFunctionMenuBean.functionId && this.functionIcon == chatFunctionMenuBean.functionIcon;
    }

    public final int getFunctionIcon() {
        return this.functionIcon;
    }

    public final int getFunctionId() {
        return this.functionId;
    }

    @NotNull
    public final String getFunctionName() {
        return this.functionName;
    }

    public int hashCode() {
        return (((this.functionName.hashCode() * 31) + this.functionId) * 31) + this.functionIcon;
    }

    public final void setFunctionIcon(int i) {
        this.functionIcon = i;
    }

    public final void setFunctionId(int i) {
        this.functionId = i;
    }

    public final void setFunctionName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.functionName = str;
    }

    @NotNull
    public String toString() {
        return "ChatFunctionMenuBean(functionName=" + this.functionName + ", functionId=" + this.functionId + ", functionIcon=" + this.functionIcon + ')';
    }
}
