package com.wear.bean.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.JSON;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioBookListBean.kt */
@DatabaseTable(tableName = "tb_audio_book_list")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003Jp\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010¨\u00060"}, d2 = {"Lcom/wear/bean/data/AudioBookList;", "Lcom/wear/bean/BaseEntity;", MessageBundle.TITLE_ENTRY, "", "coverUrl", TypedValues.TransitionType.S_DURATION, "", "audioUrl", "patternUrl", "tagNameList", "", "intro", "isPlay", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V", "getAudioUrl", "()Ljava/lang/String;", "getCoverUrl", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIntro", "()Z", "setPlay", "(Z)V", "getPatternUrl", "getTagNameList", "()Ljava/util/List;", "tagNameListDB", "getTagNameListDB", "setTagNameListDB", "(Ljava/lang/String;)V", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)Lcom/wear/bean/data/AudioBookList;", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AudioBookList extends BaseEntity {

    @DatabaseField
    @Nullable
    private final String audioUrl;

    @DatabaseField
    @Nullable
    private final String coverUrl;

    @DatabaseField
    @Nullable
    private final Integer duration;

    @DatabaseField
    @Nullable
    private final String intro;
    private boolean isPlay;

    @DatabaseField
    @NotNull
    private final String patternUrl;

    @Nullable
    private final List<String> tagNameList;

    @DatabaseField
    @Nullable
    private String tagNameListDB;

    @DatabaseField
    @Nullable
    private final String title;

    public AudioBookList() {
        this(null, null, null, null, null, null, null, false, 255, null);
    }

    public /* synthetic */ AudioBookList(String str, String str2, Integer num, String str3, String str4, List list, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0 : num, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? new ArrayList() : list, (i & 64) == 0 ? str5 : "", (i & 128) == 0 ? z : false);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getAudioUrl() {
        return this.audioUrl;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @Nullable
    public final List<String> component6() {
        return this.tagNameList;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getIntro() {
        return this.intro;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsPlay() {
        return this.isPlay;
    }

    @NotNull
    public final AudioBookList copy(@Nullable String title, @Nullable String coverUrl, @Nullable Integer duration, @Nullable String audioUrl, @NotNull String patternUrl, @Nullable List<String> tagNameList, @Nullable String intro, boolean isPlay) {
        Intrinsics.checkNotNullParameter(patternUrl, "patternUrl");
        return new AudioBookList(title, coverUrl, duration, audioUrl, patternUrl, tagNameList, intro, isPlay);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioBookList)) {
            return false;
        }
        AudioBookList audioBookList = (AudioBookList) other;
        return Intrinsics.areEqual(this.title, audioBookList.title) && Intrinsics.areEqual(this.coverUrl, audioBookList.coverUrl) && Intrinsics.areEqual(this.duration, audioBookList.duration) && Intrinsics.areEqual(this.audioUrl, audioBookList.audioUrl) && Intrinsics.areEqual(this.patternUrl, audioBookList.patternUrl) && Intrinsics.areEqual(this.tagNameList, audioBookList.tagNameList) && Intrinsics.areEqual(this.intro, audioBookList.intro) && this.isPlay == audioBookList.isPlay;
    }

    @Nullable
    public final String getAudioUrl() {
        return this.audioUrl;
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getIntro() {
        return this.intro;
    }

    @NotNull
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @Nullable
    public final List<String> getTagNameList() {
        return this.tagNameList;
    }

    @Nullable
    public final String getTagNameListDB() {
        return this.tagNameListDB;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.coverUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.duration;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.audioUrl;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.patternUrl.hashCode()) * 31;
        List<String> list = this.tagNameList;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.intro;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.isPlay;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode6 + i;
    }

    public final boolean isPlay() {
        return this.isPlay;
    }

    public final void setPlay(boolean z) {
        this.isPlay = z;
    }

    public final void setTagNameListDB(@Nullable String str) {
        this.tagNameListDB = str;
    }

    @NotNull
    public String toString() {
        return "AudioBookList(title=" + this.title + ", coverUrl=" + this.coverUrl + ", duration=" + this.duration + ", audioUrl=" + this.audioUrl + ", patternUrl=" + this.patternUrl + ", tagNameList=" + this.tagNameList + ", intro=" + this.intro + ", isPlay=" + this.isPlay + ')';
    }

    public AudioBookList(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @NotNull String patternUrl, @Nullable List<String> list, @Nullable String str4, boolean z) {
        Intrinsics.checkNotNullParameter(patternUrl, "patternUrl");
        this.title = str;
        this.coverUrl = str2;
        this.duration = num;
        this.audioUrl = str3;
        this.patternUrl = patternUrl;
        this.tagNameList = list;
        this.intro = str4;
        this.isPlay = z;
        this.tagNameListDB = JSON.toJSONString(list);
    }
}
