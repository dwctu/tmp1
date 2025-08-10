package com.wear.bean.data;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceModelBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/wear/bean/data/VoiceModelData;", "", "hasUpdate", "", ImagesContract.URL, "", "voiceResourceId", "modelName", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHasUpdate", "()Z", "getModelName", "()Ljava/lang/String;", "getUrl", "getVoiceResourceId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VoiceModelData {
    private final boolean hasUpdate;

    @Nullable
    private final String modelName;

    @Nullable
    private final String url;

    @Nullable
    private final String voiceResourceId;

    public VoiceModelData(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.hasUpdate = z;
        this.url = str;
        this.voiceResourceId = str2;
        this.modelName = str3;
    }

    public static /* synthetic */ VoiceModelData copy$default(VoiceModelData voiceModelData, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = voiceModelData.hasUpdate;
        }
        if ((i & 2) != 0) {
            str = voiceModelData.url;
        }
        if ((i & 4) != 0) {
            str2 = voiceModelData.voiceResourceId;
        }
        if ((i & 8) != 0) {
            str3 = voiceModelData.modelName;
        }
        return voiceModelData.copy(z, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getVoiceResourceId() {
        return this.voiceResourceId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    @NotNull
    public final VoiceModelData copy(boolean hasUpdate, @Nullable String url, @Nullable String voiceResourceId, @Nullable String modelName) {
        return new VoiceModelData(hasUpdate, url, voiceResourceId, modelName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceModelData)) {
            return false;
        }
        VoiceModelData voiceModelData = (VoiceModelData) other;
        return this.hasUpdate == voiceModelData.hasUpdate && Intrinsics.areEqual(this.url, voiceModelData.url) && Intrinsics.areEqual(this.voiceResourceId, voiceModelData.voiceResourceId) && Intrinsics.areEqual(this.modelName, voiceModelData.modelName);
    }

    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    @Nullable
    public final String getModelName() {
        return this.modelName;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getVoiceResourceId() {
        return this.voiceResourceId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.hasUpdate;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.url;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.voiceResourceId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.modelName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VoiceModelData(hasUpdate=" + this.hasUpdate + ", url=" + this.url + ", voiceResourceId=" + this.voiceResourceId + ", modelName=" + this.modelName + ')';
    }
}
