package com.component.dxtoy.business.longc.aaprogram.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAProgramItemBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/component/dxtoy/business/longc/aaprogram/bean/AAProgramItemBean;", "", TtmlNode.START, "", TtmlNode.END, "speed", "times", "(IIII)V", "getEnd", "()I", "setEnd", "(I)V", "getSpeed", "getStart", "getTimes", "setTimes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toElement", "", "toString", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AAProgramItemBean {
    private int end;
    private final int speed;
    private final int start;
    private int times;

    public AAProgramItemBean(int i, int i2, int i3, int i4) {
        this.start = i;
        this.end = i2;
        this.speed = i3;
        this.times = i4;
    }

    public static /* synthetic */ AAProgramItemBean copy$default(AAProgramItemBean aAProgramItemBean, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = aAProgramItemBean.start;
        }
        if ((i5 & 2) != 0) {
            i2 = aAProgramItemBean.end;
        }
        if ((i5 & 4) != 0) {
            i3 = aAProgramItemBean.speed;
        }
        if ((i5 & 8) != 0) {
            i4 = aAProgramItemBean.times;
        }
        return aAProgramItemBean.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSpeed() {
        return this.speed;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTimes() {
        return this.times;
    }

    @NotNull
    public final AAProgramItemBean copy(int start, int end, int speed, int times) {
        return new AAProgramItemBean(start, end, speed, times);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AAProgramItemBean)) {
            return false;
        }
        AAProgramItemBean aAProgramItemBean = (AAProgramItemBean) other;
        return this.start == aAProgramItemBean.start && this.end == aAProgramItemBean.end && this.speed == aAProgramItemBean.speed && this.times == aAProgramItemBean.times;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getTimes() {
        return this.times;
    }

    public int hashCode() {
        return (((((this.start * 31) + this.end) * 31) + this.speed) * 31) + this.times;
    }

    public final void setEnd(int i) {
        this.end = i;
    }

    public final void setTimes(int i) {
        this.times = i;
    }

    @NotNull
    public final byte[] toElement() {
        return new byte[]{(byte) this.start, (byte) this.end, (byte) this.speed, (byte) this.times};
    }

    @NotNull
    public String toString() {
        return "AAProgramItemBean(start=" + this.start + ", end=" + this.end + ", speed=" + this.speed + ", times=" + this.times + ')';
    }
}
