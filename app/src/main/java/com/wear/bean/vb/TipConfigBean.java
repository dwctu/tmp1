package com.wear.bean.vb;

import dc.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TipConfigBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006("}, d2 = {"Lcom/wear/bean/vb/TipConfigBean;", "", "firstTime", "", "updateEndDayTime", "endDay", "", "startDay", "lastLookTime", "lastDay", "(JJIIJI)V", "getEndDay", "()I", "setEndDay", "(I)V", "getFirstTime", "()J", "setFirstTime", "(J)V", "getLastDay", "setLastDay", "getLastLookTime", "setLastLookTime", "getStartDay", "setStartDay", "getUpdateEndDayTime", "setUpdateEndDayTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TipConfigBean {
    private int endDay;
    private long firstTime;
    private int lastDay;
    private long lastLookTime;
    private int startDay;
    private long updateEndDayTime;

    public TipConfigBean() {
        this(0L, 0L, 0, 0, 0L, 0, 63, null);
    }

    public TipConfigBean(long j, long j2, int i, int i2, long j3, int i3) {
        this.firstTime = j;
        this.updateEndDayTime = j2;
        this.endDay = i;
        this.startDay = i2;
        this.lastLookTime = j3;
        this.lastDay = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final long getFirstTime() {
        return this.firstTime;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUpdateEndDayTime() {
        return this.updateEndDayTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getEndDay() {
        return this.endDay;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStartDay() {
        return this.startDay;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLastLookTime() {
        return this.lastLookTime;
    }

    /* renamed from: component6, reason: from getter */
    public final int getLastDay() {
        return this.lastDay;
    }

    @NotNull
    public final TipConfigBean copy(long firstTime, long updateEndDayTime, int endDay, int startDay, long lastLookTime, int lastDay) {
        return new TipConfigBean(firstTime, updateEndDayTime, endDay, startDay, lastLookTime, lastDay);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TipConfigBean)) {
            return false;
        }
        TipConfigBean tipConfigBean = (TipConfigBean) other;
        return this.firstTime == tipConfigBean.firstTime && this.updateEndDayTime == tipConfigBean.updateEndDayTime && this.endDay == tipConfigBean.endDay && this.startDay == tipConfigBean.startDay && this.lastLookTime == tipConfigBean.lastLookTime && this.lastDay == tipConfigBean.lastDay;
    }

    public final int getEndDay() {
        return this.endDay;
    }

    public final long getFirstTime() {
        return this.firstTime;
    }

    public final int getLastDay() {
        return this.lastDay;
    }

    public final long getLastLookTime() {
        return this.lastLookTime;
    }

    public final int getStartDay() {
        return this.startDay;
    }

    public final long getUpdateEndDayTime() {
        return this.updateEndDayTime;
    }

    public int hashCode() {
        return (((((((((g.a(this.firstTime) * 31) + g.a(this.updateEndDayTime)) * 31) + this.endDay) * 31) + this.startDay) * 31) + g.a(this.lastLookTime)) * 31) + this.lastDay;
    }

    public final void setEndDay(int i) {
        this.endDay = i;
    }

    public final void setFirstTime(long j) {
        this.firstTime = j;
    }

    public final void setLastDay(int i) {
        this.lastDay = i;
    }

    public final void setLastLookTime(long j) {
        this.lastLookTime = j;
    }

    public final void setStartDay(int i) {
        this.startDay = i;
    }

    public final void setUpdateEndDayTime(long j) {
        this.updateEndDayTime = j;
    }

    @NotNull
    public String toString() {
        return "TipConfigBean(firstTime=" + this.firstTime + ", updateEndDayTime=" + this.updateEndDayTime + ", endDay=" + this.endDay + ", startDay=" + this.startDay + ", lastLookTime=" + this.lastLookTime + ", lastDay=" + this.lastDay + ')';
    }

    public /* synthetic */ TipConfigBean(long j, long j2, int i, int i2, long j3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? 0L : j2, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) == 0 ? j3 : 0L, (i4 & 32) == 0 ? i3 : 0);
    }
}
