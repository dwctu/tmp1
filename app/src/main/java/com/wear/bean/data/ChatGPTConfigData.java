package com.wear.bean.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTConfigBean.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/wear/bean/data/ChatGPTConfigData;", "", "enableShow", "", "(Z)V", "getEnableShow", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatGPTConfigData {
    private final boolean enableShow;

    public ChatGPTConfigData(boolean z) {
        this.enableShow = z;
    }

    public static /* synthetic */ ChatGPTConfigData copy$default(ChatGPTConfigData chatGPTConfigData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = chatGPTConfigData.enableShow;
        }
        return chatGPTConfigData.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableShow() {
        return this.enableShow;
    }

    @NotNull
    public final ChatGPTConfigData copy(boolean enableShow) {
        return new ChatGPTConfigData(enableShow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChatGPTConfigData) && this.enableShow == ((ChatGPTConfigData) other).enableShow;
    }

    public final boolean getEnableShow() {
        return this.enableShow;
    }

    public int hashCode() {
        boolean z = this.enableShow;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "ChatGPTConfigData(enableShow=" + this.enableShow + ')';
    }
}
