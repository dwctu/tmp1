package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ChatGPTConfigBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/wear/bean/data/ChatGPTConfigBean;", "", "result", "", XHTMLText.CODE, "", "message", "data", "Lcom/wear/bean/data/ChatGPTConfigData;", "(ZLjava/lang/String;Ljava/lang/String;Lcom/wear/bean/data/ChatGPTConfigData;)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/wear/bean/data/ChatGPTConfigData;", "getMessage", "getResult", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatGPTConfigBean {

    @Nullable
    private final String code;

    @NotNull
    private final ChatGPTConfigData data;

    @NotNull
    private final String message;
    private final boolean result;

    public ChatGPTConfigBean(boolean z, @Nullable String str, @NotNull String message, @NotNull ChatGPTConfigData data) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(data, "data");
        this.result = z;
        this.code = str;
        this.message = message;
        this.data = data;
    }

    public static /* synthetic */ ChatGPTConfigBean copy$default(ChatGPTConfigBean chatGPTConfigBean, boolean z, String str, String str2, ChatGPTConfigData chatGPTConfigData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = chatGPTConfigBean.result;
        }
        if ((i & 2) != 0) {
            str = chatGPTConfigBean.code;
        }
        if ((i & 4) != 0) {
            str2 = chatGPTConfigBean.message;
        }
        if ((i & 8) != 0) {
            chatGPTConfigData = chatGPTConfigBean.data;
        }
        return chatGPTConfigBean.copy(z, str, str2, chatGPTConfigData);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final ChatGPTConfigData getData() {
        return this.data;
    }

    @NotNull
    public final ChatGPTConfigBean copy(boolean result, @Nullable String code, @NotNull String message, @NotNull ChatGPTConfigData data) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(data, "data");
        return new ChatGPTConfigBean(result, code, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatGPTConfigBean)) {
            return false;
        }
        ChatGPTConfigBean chatGPTConfigBean = (ChatGPTConfigBean) other;
        return this.result == chatGPTConfigBean.result && Intrinsics.areEqual(this.code, chatGPTConfigBean.code) && Intrinsics.areEqual(this.message, chatGPTConfigBean.message) && Intrinsics.areEqual(this.data, chatGPTConfigBean.data);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final ChatGPTConfigData getData() {
        return this.data;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final boolean getResult() {
        return this.result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.result;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.code;
        return ((((i + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode()) * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChatGPTConfigBean(result=" + this.result + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }
}
