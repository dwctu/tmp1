package com.wear.bean.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ChatGPTStoryResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/data/ChatGPTStoryResponse;", "Ljava/io/Serializable;", "result", "", XHTMLText.CODE, "", "message", "data", "Lcom/wear/bean/data/ChatGPTStoryBean;", "(ZLjava/lang/String;Ljava/lang/String;Lcom/wear/bean/data/ChatGPTStoryBean;)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/wear/bean/data/ChatGPTStoryBean;", "getMessage", "getResult", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatGPTStoryResponse implements Serializable {

    @NotNull
    private final String code;

    @Nullable
    private final ChatGPTStoryBean data;

    @NotNull
    private final String message;
    private final boolean result;

    public ChatGPTStoryResponse(boolean z, @NotNull String code, @NotNull String message, @Nullable ChatGPTStoryBean chatGPTStoryBean) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
        this.result = z;
        this.code = code;
        this.message = message;
        this.data = chatGPTStoryBean;
    }

    public static /* synthetic */ ChatGPTStoryResponse copy$default(ChatGPTStoryResponse chatGPTStoryResponse, boolean z, String str, String str2, ChatGPTStoryBean chatGPTStoryBean, int i, Object obj) {
        if ((i & 1) != 0) {
            z = chatGPTStoryResponse.result;
        }
        if ((i & 2) != 0) {
            str = chatGPTStoryResponse.code;
        }
        if ((i & 4) != 0) {
            str2 = chatGPTStoryResponse.message;
        }
        if ((i & 8) != 0) {
            chatGPTStoryBean = chatGPTStoryResponse.data;
        }
        return chatGPTStoryResponse.copy(z, str, str2, chatGPTStoryBean);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getResult() {
        return this.result;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final ChatGPTStoryBean getData() {
        return this.data;
    }

    @NotNull
    public final ChatGPTStoryResponse copy(boolean result, @NotNull String code, @NotNull String message, @Nullable ChatGPTStoryBean data) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
        return new ChatGPTStoryResponse(result, code, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatGPTStoryResponse)) {
            return false;
        }
        ChatGPTStoryResponse chatGPTStoryResponse = (ChatGPTStoryResponse) other;
        return this.result == chatGPTStoryResponse.result && Intrinsics.areEqual(this.code, chatGPTStoryResponse.code) && Intrinsics.areEqual(this.message, chatGPTStoryResponse.message) && Intrinsics.areEqual(this.data, chatGPTStoryResponse.data);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final ChatGPTStoryBean getData() {
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
        int iHashCode = ((((r0 * 31) + this.code.hashCode()) * 31) + this.message.hashCode()) * 31;
        ChatGPTStoryBean chatGPTStoryBean = this.data;
        return iHashCode + (chatGPTStoryBean == null ? 0 : chatGPTStoryBean.hashCode());
    }

    @NotNull
    public String toString() {
        return "ChatGPTStoryResponse(result=" + this.result + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }
}
