package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: VoiceModelBean.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/wear/bean/data/VoiceModelBean;", "", "result", "", XHTMLText.CODE, "", "message", "", "data", "Lcom/wear/bean/data/VoiceModelData;", "(ZILjava/lang/String;Lcom/wear/bean/data/VoiceModelData;)V", "getCode", "()I", "getData", "()Lcom/wear/bean/data/VoiceModelData;", "getMessage", "()Ljava/lang/String;", "getResult", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VoiceModelBean {
    private final int code;

    @Nullable
    private final VoiceModelData data;

    @Nullable
    private final String message;
    private final boolean result;

    public VoiceModelBean(boolean z, int i, @Nullable String str, @Nullable VoiceModelData voiceModelData) {
        this.result = z;
        this.code = i;
        this.message = str;
        this.data = voiceModelData;
    }

    public static /* synthetic */ VoiceModelBean copy$default(VoiceModelBean voiceModelBean, boolean z, int i, String str, VoiceModelData voiceModelData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = voiceModelBean.result;
        }
        if ((i2 & 2) != 0) {
            i = voiceModelBean.code;
        }
        if ((i2 & 4) != 0) {
            str = voiceModelBean.message;
        }
        if ((i2 & 8) != 0) {
            voiceModelData = voiceModelBean.data;
        }
        return voiceModelBean.copy(z, i, str, voiceModelData);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getResult() {
        return this.result;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final VoiceModelData getData() {
        return this.data;
    }

    @NotNull
    public final VoiceModelBean copy(boolean result, int code, @Nullable String message, @Nullable VoiceModelData data) {
        return new VoiceModelBean(result, code, message, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceModelBean)) {
            return false;
        }
        VoiceModelBean voiceModelBean = (VoiceModelBean) other;
        return this.result == voiceModelBean.result && this.code == voiceModelBean.code && Intrinsics.areEqual(this.message, voiceModelBean.message) && Intrinsics.areEqual(this.data, voiceModelBean.data);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final VoiceModelData getData() {
        return this.data;
    }

    @Nullable
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
        int i = ((r0 * 31) + this.code) * 31;
        String str = this.message;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        VoiceModelData voiceModelData = this.data;
        return iHashCode + (voiceModelData != null ? voiceModelData.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VoiceModelBean(result=" + this.result + ", code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public /* synthetic */ VoiceModelBean(boolean z, int i, String str, VoiceModelData voiceModelData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : voiceModelData);
    }
}
