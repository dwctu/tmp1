package com.wear.bean.vb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.Pattern;
import dc.g;
import dc.tq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoResponse.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000eHÆ\u0003Je\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u00103\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0016HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010$R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00068"}, d2 = {"Lcom/wear/bean/vb/VbPatternBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", TtmlNode.ATTR_ID, "", "patternUrl", "", "durationFormat", TypedValues.TransitionType.S_DURATION, "staticPatternId", "staticVideoLikeNumber", "staticVideoUserIsLike", "", "likeTimestamp", "pattern", "Lcom/wear/bean/Pattern;", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZJLcom/wear/bean/Pattern;)V", "getDuration", "()J", "getDurationFormat", "()Ljava/lang/String;", "getId", "itemType", "", "getItemType", "()I", "getLikeTimestamp", "setLikeTimestamp", "(J)V", "getPattern", "()Lcom/wear/bean/Pattern;", "setPattern", "(Lcom/wear/bean/Pattern;)V", "getPatternUrl", "getStaticPatternId", "getStaticVideoLikeNumber", "setStaticVideoLikeNumber", "(Ljava/lang/String;)V", "getStaticVideoUserIsLike", "()Z", "setStaticVideoUserIsLike", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VbPatternBean implements tq {
    private final long duration;

    @NotNull
    private final String durationFormat;
    private final long id;
    private long likeTimestamp;

    @Nullable
    private Pattern pattern;

    @NotNull
    private final String patternUrl;

    @NotNull
    private final String staticPatternId;

    @NotNull
    private String staticVideoLikeNumber;
    private boolean staticVideoUserIsLike;

    public VbPatternBean(long j, @NotNull String patternUrl, @NotNull String durationFormat, long j2, @NotNull String staticPatternId, @NotNull String staticVideoLikeNumber, boolean z, long j3, @Nullable Pattern pattern) {
        Intrinsics.checkNotNullParameter(patternUrl, "patternUrl");
        Intrinsics.checkNotNullParameter(durationFormat, "durationFormat");
        Intrinsics.checkNotNullParameter(staticPatternId, "staticPatternId");
        Intrinsics.checkNotNullParameter(staticVideoLikeNumber, "staticVideoLikeNumber");
        this.id = j;
        this.patternUrl = patternUrl;
        this.durationFormat = durationFormat;
        this.duration = j2;
        this.staticPatternId = staticPatternId;
        this.staticVideoLikeNumber = staticVideoLikeNumber;
        this.staticVideoUserIsLike = z;
        this.likeTimestamp = j3;
        this.pattern = pattern;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDurationFormat() {
        return this.durationFormat;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getStaticPatternId() {
        return this.staticPatternId;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getStaticVideoLikeNumber() {
        return this.staticVideoLikeNumber;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getStaticVideoUserIsLike() {
        return this.staticVideoUserIsLike;
    }

    /* renamed from: component8, reason: from getter */
    public final long getLikeTimestamp() {
        return this.likeTimestamp;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Pattern getPattern() {
        return this.pattern;
    }

    @NotNull
    public final VbPatternBean copy(long id, @NotNull String patternUrl, @NotNull String durationFormat, long duration, @NotNull String staticPatternId, @NotNull String staticVideoLikeNumber, boolean staticVideoUserIsLike, long likeTimestamp, @Nullable Pattern pattern) {
        Intrinsics.checkNotNullParameter(patternUrl, "patternUrl");
        Intrinsics.checkNotNullParameter(durationFormat, "durationFormat");
        Intrinsics.checkNotNullParameter(staticPatternId, "staticPatternId");
        Intrinsics.checkNotNullParameter(staticVideoLikeNumber, "staticVideoLikeNumber");
        return new VbPatternBean(id, patternUrl, durationFormat, duration, staticPatternId, staticVideoLikeNumber, staticVideoUserIsLike, likeTimestamp, pattern);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VbPatternBean)) {
            return false;
        }
        VbPatternBean vbPatternBean = (VbPatternBean) other;
        return this.id == vbPatternBean.id && Intrinsics.areEqual(this.patternUrl, vbPatternBean.patternUrl) && Intrinsics.areEqual(this.durationFormat, vbPatternBean.durationFormat) && this.duration == vbPatternBean.duration && Intrinsics.areEqual(this.staticPatternId, vbPatternBean.staticPatternId) && Intrinsics.areEqual(this.staticVideoLikeNumber, vbPatternBean.staticVideoLikeNumber) && this.staticVideoUserIsLike == vbPatternBean.staticVideoUserIsLike && this.likeTimestamp == vbPatternBean.likeTimestamp && Intrinsics.areEqual(this.pattern, vbPatternBean.pattern);
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getDurationFormat() {
        return this.durationFormat;
    }

    public final long getId() {
        return this.id;
    }

    @Override // dc.tq
    public int getItemType() {
        return 3;
    }

    public final long getLikeTimestamp() {
        return this.likeTimestamp;
    }

    @Nullable
    public final Pattern getPattern() {
        return this.pattern;
    }

    @NotNull
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @NotNull
    public final String getStaticPatternId() {
        return this.staticPatternId;
    }

    @NotNull
    public final String getStaticVideoLikeNumber() {
        return this.staticVideoLikeNumber;
    }

    public final boolean getStaticVideoUserIsLike() {
        return this.staticVideoUserIsLike;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = ((((((((((g.a(this.id) * 31) + this.patternUrl.hashCode()) * 31) + this.durationFormat.hashCode()) * 31) + g.a(this.duration)) * 31) + this.staticPatternId.hashCode()) * 31) + this.staticVideoLikeNumber.hashCode()) * 31;
        boolean z = this.staticVideoUserIsLike;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int iA2 = (((iA + i) * 31) + g.a(this.likeTimestamp)) * 31;
        Pattern pattern = this.pattern;
        return iA2 + (pattern == null ? 0 : pattern.hashCode());
    }

    public final void setLikeTimestamp(long j) {
        this.likeTimestamp = j;
    }

    public final void setPattern(@Nullable Pattern pattern) {
        this.pattern = pattern;
    }

    public final void setStaticVideoLikeNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.staticVideoLikeNumber = str;
    }

    public final void setStaticVideoUserIsLike(boolean z) {
        this.staticVideoUserIsLike = z;
    }

    @NotNull
    public String toString() {
        return "VbPatternBean(id=" + this.id + ", patternUrl=" + this.patternUrl + ", durationFormat=" + this.durationFormat + ", duration=" + this.duration + ", staticPatternId=" + this.staticPatternId + ", staticVideoLikeNumber=" + this.staticVideoLikeNumber + ", staticVideoUserIsLike=" + this.staticVideoUserIsLike + ", likeTimestamp=" + this.likeTimestamp + ", pattern=" + this.pattern + ')';
    }
}
