package com.wear.bean.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTStoryResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jn\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0017¨\u0006."}, d2 = {"Lcom/wear/bean/data/ChatGPTStoryData;", "Ljava/io/Serializable;", "audiobookCreateOk", "", "audiobookTitle", "", "audiobookContent", "patternFileUrl", "patternContent", "isLiked", "disLike", "audiobookUrl", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAudiobookContent", "()Ljava/lang/String;", "getAudiobookCreateOk", "()Ljava/lang/Boolean;", "setAudiobookCreateOk", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getAudiobookTitle", "getAudiobookUrl", "setAudiobookUrl", "(Ljava/lang/String;)V", "getDisLike", "setDisLike", "setLiked", "getPatternContent", "getPatternFileUrl", "setPatternFileUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/wear/bean/data/ChatGPTStoryData;", "equals", "other", "", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatGPTStoryData implements Serializable {

    @Nullable
    private final String audiobookContent;

    @Nullable
    private Boolean audiobookCreateOk;

    @Nullable
    private final String audiobookTitle;

    @Nullable
    private String audiobookUrl;

    @Nullable
    private Boolean disLike;

    @Nullable
    private Boolean isLiked;

    @Nullable
    private final String patternContent;

    @Nullable
    private String patternFileUrl;

    public ChatGPTStoryData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public ChatGPTStoryData(@Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str5) {
        this.audiobookCreateOk = bool;
        this.audiobookTitle = str;
        this.audiobookContent = str2;
        this.patternFileUrl = str3;
        this.patternContent = str4;
        this.isLiked = bool2;
        this.disLike = bool3;
        this.audiobookUrl = str5;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getAudiobookCreateOk() {
        return this.audiobookCreateOk;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAudiobookTitle() {
        return this.audiobookTitle;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAudiobookContent() {
        return this.audiobookContent;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPatternFileUrl() {
        return this.patternFileUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPatternContent() {
        return this.patternContent;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getIsLiked() {
        return this.isLiked;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getDisLike() {
        return this.disLike;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getAudiobookUrl() {
        return this.audiobookUrl;
    }

    @NotNull
    public final ChatGPTStoryData copy(@Nullable Boolean audiobookCreateOk, @Nullable String audiobookTitle, @Nullable String audiobookContent, @Nullable String patternFileUrl, @Nullable String patternContent, @Nullable Boolean isLiked, @Nullable Boolean disLike, @Nullable String audiobookUrl) {
        return new ChatGPTStoryData(audiobookCreateOk, audiobookTitle, audiobookContent, patternFileUrl, patternContent, isLiked, disLike, audiobookUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatGPTStoryData)) {
            return false;
        }
        ChatGPTStoryData chatGPTStoryData = (ChatGPTStoryData) other;
        return Intrinsics.areEqual(this.audiobookCreateOk, chatGPTStoryData.audiobookCreateOk) && Intrinsics.areEqual(this.audiobookTitle, chatGPTStoryData.audiobookTitle) && Intrinsics.areEqual(this.audiobookContent, chatGPTStoryData.audiobookContent) && Intrinsics.areEqual(this.patternFileUrl, chatGPTStoryData.patternFileUrl) && Intrinsics.areEqual(this.patternContent, chatGPTStoryData.patternContent) && Intrinsics.areEqual(this.isLiked, chatGPTStoryData.isLiked) && Intrinsics.areEqual(this.disLike, chatGPTStoryData.disLike) && Intrinsics.areEqual(this.audiobookUrl, chatGPTStoryData.audiobookUrl);
    }

    @Nullable
    public final String getAudiobookContent() {
        return this.audiobookContent;
    }

    @Nullable
    public final Boolean getAudiobookCreateOk() {
        return this.audiobookCreateOk;
    }

    @Nullable
    public final String getAudiobookTitle() {
        return this.audiobookTitle;
    }

    @Nullable
    public final String getAudiobookUrl() {
        return this.audiobookUrl;
    }

    @Nullable
    public final Boolean getDisLike() {
        return this.disLike;
    }

    @Nullable
    public final String getPatternContent() {
        return this.patternContent;
    }

    @Nullable
    public final String getPatternFileUrl() {
        return this.patternFileUrl;
    }

    public int hashCode() {
        Boolean bool = this.audiobookCreateOk;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.audiobookTitle;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.audiobookContent;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.patternFileUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.patternContent;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool2 = this.isLiked;
        int iHashCode6 = (iHashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.disLike;
        int iHashCode7 = (iHashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str5 = this.audiobookUrl;
        return iHashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    @Nullable
    public final Boolean isLiked() {
        return this.isLiked;
    }

    public final void setAudiobookCreateOk(@Nullable Boolean bool) {
        this.audiobookCreateOk = bool;
    }

    public final void setAudiobookUrl(@Nullable String str) {
        this.audiobookUrl = str;
    }

    public final void setDisLike(@Nullable Boolean bool) {
        this.disLike = bool;
    }

    public final void setLiked(@Nullable Boolean bool) {
        this.isLiked = bool;
    }

    public final void setPatternFileUrl(@Nullable String str) {
        this.patternFileUrl = str;
    }

    @NotNull
    public String toString() {
        return "ChatGPTStoryData(audiobookCreateOk=" + this.audiobookCreateOk + ", audiobookTitle=" + this.audiobookTitle + ", audiobookContent=" + this.audiobookContent + ", patternFileUrl=" + this.patternFileUrl + ", patternContent=" + this.patternContent + ", isLiked=" + this.isLiked + ", disLike=" + this.disLike + ", audiobookUrl=" + this.audiobookUrl + ')';
    }

    public /* synthetic */ ChatGPTStoryData(Boolean bool, String str, String str2, String str3, String str4, Boolean bool2, Boolean bool3, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? Boolean.FALSE : bool2, (i & 64) != 0 ? Boolean.FALSE : bool3, (i & 128) == 0 ? str5 : "");
    }
}
