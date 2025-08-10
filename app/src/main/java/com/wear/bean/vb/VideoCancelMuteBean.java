package com.wear.bean.vb;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoCancelMuteBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/wear/bean/vb/VideoCancelMuteBean;", "", "top", "", TtmlNode.LEFT, "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLeft", "()Ljava/lang/Integer;", "setLeft", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTop", "setTop", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/wear/bean/vb/VideoCancelMuteBean;", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VideoCancelMuteBean {

    @Nullable
    private Integer left;

    @Nullable
    private Integer top;

    public VideoCancelMuteBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public VideoCancelMuteBean(@Nullable Integer num, @Nullable Integer num2) {
        this.top = num;
        this.left = num2;
    }

    public static /* synthetic */ VideoCancelMuteBean copy$default(VideoCancelMuteBean videoCancelMuteBean, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = videoCancelMuteBean.top;
        }
        if ((i & 2) != 0) {
            num2 = videoCancelMuteBean.left;
        }
        return videoCancelMuteBean.copy(num, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getTop() {
        return this.top;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getLeft() {
        return this.left;
    }

    @NotNull
    public final VideoCancelMuteBean copy(@Nullable Integer top, @Nullable Integer left) {
        return new VideoCancelMuteBean(top, left);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCancelMuteBean)) {
            return false;
        }
        VideoCancelMuteBean videoCancelMuteBean = (VideoCancelMuteBean) other;
        return Intrinsics.areEqual(this.top, videoCancelMuteBean.top) && Intrinsics.areEqual(this.left, videoCancelMuteBean.left);
    }

    @Nullable
    public final Integer getLeft() {
        return this.left;
    }

    @Nullable
    public final Integer getTop() {
        return this.top;
    }

    public int hashCode() {
        Integer num = this.top;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.left;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setLeft(@Nullable Integer num) {
        this.left = num;
    }

    public final void setTop(@Nullable Integer num) {
        this.top = num;
    }

    @NotNull
    public String toString() {
        return "VideoCancelMuteBean(top=" + this.top + ", left=" + this.left + ')';
    }

    public /* synthetic */ VideoCancelMuteBean(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2);
    }
}
