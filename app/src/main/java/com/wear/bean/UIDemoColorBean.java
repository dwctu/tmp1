package com.wear.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoColorBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/wear/bean/UIDemoColorBean;", "", "name", "", "resIds", "", "lightHexFormat", "", "darkHexFormat", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "getDarkHexFormat", "()Ljava/util/List;", "setDarkHexFormat", "(Ljava/util/List;)V", "getLightHexFormat", "setLightHexFormat", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getResIds", "()I", "setResIds", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UIDemoColorBean {

    @NotNull
    private List<String> darkHexFormat;

    @NotNull
    private List<String> lightHexFormat;

    @NotNull
    private String name;
    private int resIds;

    public UIDemoColorBean(@NotNull String name, int i, @NotNull List<String> lightHexFormat, @NotNull List<String> darkHexFormat) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lightHexFormat, "lightHexFormat");
        Intrinsics.checkNotNullParameter(darkHexFormat, "darkHexFormat");
        this.name = name;
        this.resIds = i;
        this.lightHexFormat = lightHexFormat;
        this.darkHexFormat = darkHexFormat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UIDemoColorBean copy$default(UIDemoColorBean uIDemoColorBean, String str, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uIDemoColorBean.name;
        }
        if ((i2 & 2) != 0) {
            i = uIDemoColorBean.resIds;
        }
        if ((i2 & 4) != 0) {
            list = uIDemoColorBean.lightHexFormat;
        }
        if ((i2 & 8) != 0) {
            list2 = uIDemoColorBean.darkHexFormat;
        }
        return uIDemoColorBean.copy(str, i, list, list2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getResIds() {
        return this.resIds;
    }

    @NotNull
    public final List<String> component3() {
        return this.lightHexFormat;
    }

    @NotNull
    public final List<String> component4() {
        return this.darkHexFormat;
    }

    @NotNull
    public final UIDemoColorBean copy(@NotNull String name, int resIds, @NotNull List<String> lightHexFormat, @NotNull List<String> darkHexFormat) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lightHexFormat, "lightHexFormat");
        Intrinsics.checkNotNullParameter(darkHexFormat, "darkHexFormat");
        return new UIDemoColorBean(name, resIds, lightHexFormat, darkHexFormat);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UIDemoColorBean)) {
            return false;
        }
        UIDemoColorBean uIDemoColorBean = (UIDemoColorBean) other;
        return Intrinsics.areEqual(this.name, uIDemoColorBean.name) && this.resIds == uIDemoColorBean.resIds && Intrinsics.areEqual(this.lightHexFormat, uIDemoColorBean.lightHexFormat) && Intrinsics.areEqual(this.darkHexFormat, uIDemoColorBean.darkHexFormat);
    }

    @NotNull
    public final List<String> getDarkHexFormat() {
        return this.darkHexFormat;
    }

    @NotNull
    public final List<String> getLightHexFormat() {
        return this.lightHexFormat;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getResIds() {
        return this.resIds;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.resIds) * 31) + this.lightHexFormat.hashCode()) * 31) + this.darkHexFormat.hashCode();
    }

    public final void setDarkHexFormat(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.darkHexFormat = list;
    }

    public final void setLightHexFormat(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.lightHexFormat = list;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setResIds(int i) {
        this.resIds = i;
    }

    @NotNull
    public String toString() {
        return "UIDemoColorBean(name=" + this.name + ", resIds=" + this.resIds + ", lightHexFormat=" + this.lightHexFormat + ", darkHexFormat=" + this.darkHexFormat + ')';
    }
}
