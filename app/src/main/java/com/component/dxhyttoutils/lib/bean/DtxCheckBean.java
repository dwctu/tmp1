package com.component.dxhyttoutils.lib.bean;

import dc.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DtxCheckBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/component/dxhyttoutils/lib/bean/DtxCheckBean;", "", "time", "", "vc", "", "from", "", "data", "(JILjava/lang/String;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "getFrom", "()Ljava/lang/String;", "getTime", "()J", "getVc", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DtxCheckBean {

    @Nullable
    private final Object data;

    @NotNull
    private final String from;
    private final long time;
    private final int vc;

    public DtxCheckBean(long j, int i, @NotNull String from, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.time = j;
        this.vc = i;
        this.from = from;
        this.data = obj;
    }

    public static /* synthetic */ DtxCheckBean copy$default(DtxCheckBean dtxCheckBean, long j, int i, String str, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            j = dtxCheckBean.time;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            i = dtxCheckBean.vc;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str = dtxCheckBean.from;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            obj = dtxCheckBean.data;
        }
        return dtxCheckBean.copy(j2, i3, str2, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVc() {
        return this.vc;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    @NotNull
    public final DtxCheckBean copy(long time, int vc, @NotNull String from, @Nullable Object data) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new DtxCheckBean(time, vc, from, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DtxCheckBean)) {
            return false;
        }
        DtxCheckBean dtxCheckBean = (DtxCheckBean) other;
        return this.time == dtxCheckBean.time && this.vc == dtxCheckBean.vc && Intrinsics.areEqual(this.from, dtxCheckBean.from) && Intrinsics.areEqual(this.data, dtxCheckBean.data);
    }

    @Nullable
    public final Object getData() {
        return this.data;
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    public final long getTime() {
        return this.time;
    }

    public final int getVc() {
        return this.vc;
    }

    public int hashCode() {
        int iA = ((((g.a(this.time) * 31) + this.vc) * 31) + this.from.hashCode()) * 31;
        Object obj = this.data;
        return iA + (obj == null ? 0 : obj.hashCode());
    }

    @NotNull
    public String toString() {
        return "DtxCheckBean(time=" + this.time + ", vc=" + this.vc + ", from=" + this.from + ", data=" + this.data + ')';
    }
}
