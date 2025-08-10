package com.component.dxtoy.business.longc.aapattern.bean;

import com.google.firebase.analytics.FirebaseAnalytics;
import dc.k10;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAPatternItemBean.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/component/dxtoy/business/longc/aapattern/bean/AAPatternItemBean;", "", FirebaseAnalytics.Param.INDEX, "", "value", "(II)V", "getIndex", "()I", "getValue", "setValue", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toElement", "", "type", "Lcom/component/dxtoy/business/longc/data/AAEum$Type;", "toElement100", "toElement20", "toString", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AAPatternItemBean {
    private final int index;
    private int value;

    /* compiled from: AAPatternItemBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[k10.values().length];
            iArr[k10.WRITE_PATTERN_JUST_20.ordinal()] = 1;
            iArr[k10.WRITE_PATTERN_CLEAR_20.ordinal()] = 2;
            iArr[k10.WRITE_PATTERN_CLEAR_RUN_20.ordinal()] = 3;
            iArr[k10.WRITE_PATTERN_JUST_100.ordinal()] = 4;
            iArr[k10.WRITE_PATTERN_CLEAR_100.ordinal()] = 5;
            iArr[k10.WRITE_PATTERN_CLEAR_RUN_100.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AAPatternItemBean(int i, int i2) {
        this.index = i;
        this.value = i2;
    }

    public static /* synthetic */ AAPatternItemBean copy$default(AAPatternItemBean aAPatternItemBean, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = aAPatternItemBean.index;
        }
        if ((i3 & 2) != 0) {
            i2 = aAPatternItemBean.value;
        }
        return aAPatternItemBean.copy(i, i2);
    }

    private final byte[] toElement100() {
        int i = this.index;
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) this.value};
    }

    private final byte[] toElement20() {
        int i = this.index;
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) (((byte) ((3 & (i >> 16)) << 6)) | ((byte) (this.value & 63)))};
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    @NotNull
    public final AAPatternItemBean copy(int index, int value) {
        return new AAPatternItemBean(index, value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AAPatternItemBean)) {
            return false;
        }
        AAPatternItemBean aAPatternItemBean = (AAPatternItemBean) other;
        return this.index == aAPatternItemBean.index && this.value == aAPatternItemBean.value;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.index * 31) + this.value;
    }

    public final void setValue(int i) {
        this.value = i;
    }

    @NotNull
    public final byte[] toElement(@NotNull k10 type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return toElement20();
            case 4:
            case 5:
            case 6:
                return toElement100();
            default:
                return new byte[0];
        }
    }

    @NotNull
    public String toString() {
        return "AAPatternItemBean(index=" + this.index + ", value=" + this.value + ')';
    }
}
