package com.wear.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIDemoFontBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/wear/bean/UIDemoFontBean;", "", "fontSimple", "", TtmlNode.ATTR_TTS_FONT_WEIGHT, "name", "resIds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getFontSimple", "()Ljava/lang/String;", "setFontSimple", "(Ljava/lang/String;)V", "getFontWeight", "setFontWeight", "getName", "setName", "getResIds", "()I", "setResIds", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UIDemoFontBean {

    @NotNull
    private String fontSimple;

    @NotNull
    private String fontWeight;

    @NotNull
    private String name;
    private int resIds;

    public UIDemoFontBean(@NotNull String fontSimple, @NotNull String fontWeight, @NotNull String name, int i) {
        Intrinsics.checkNotNullParameter(fontSimple, "fontSimple");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(name, "name");
        this.fontSimple = fontSimple;
        this.fontWeight = fontWeight;
        this.name = name;
        this.resIds = i;
    }

    public static /* synthetic */ UIDemoFontBean copy$default(UIDemoFontBean uIDemoFontBean, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uIDemoFontBean.fontSimple;
        }
        if ((i2 & 2) != 0) {
            str2 = uIDemoFontBean.fontWeight;
        }
        if ((i2 & 4) != 0) {
            str3 = uIDemoFontBean.name;
        }
        if ((i2 & 8) != 0) {
            i = uIDemoFontBean.resIds;
        }
        return uIDemoFontBean.copy(str, str2, str3, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFontSimple() {
        return this.fontSimple;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFontWeight() {
        return this.fontWeight;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final int getResIds() {
        return this.resIds;
    }

    @NotNull
    public final UIDemoFontBean copy(@NotNull String fontSimple, @NotNull String fontWeight, @NotNull String name, int resIds) {
        Intrinsics.checkNotNullParameter(fontSimple, "fontSimple");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(name, "name");
        return new UIDemoFontBean(fontSimple, fontWeight, name, resIds);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UIDemoFontBean)) {
            return false;
        }
        UIDemoFontBean uIDemoFontBean = (UIDemoFontBean) other;
        return Intrinsics.areEqual(this.fontSimple, uIDemoFontBean.fontSimple) && Intrinsics.areEqual(this.fontWeight, uIDemoFontBean.fontWeight) && Intrinsics.areEqual(this.name, uIDemoFontBean.name) && this.resIds == uIDemoFontBean.resIds;
    }

    @NotNull
    public final String getFontSimple() {
        return this.fontSimple;
    }

    @NotNull
    public final String getFontWeight() {
        return this.fontWeight;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getResIds() {
        return this.resIds;
    }

    public int hashCode() {
        return (((((this.fontSimple.hashCode() * 31) + this.fontWeight.hashCode()) * 31) + this.name.hashCode()) * 31) + this.resIds;
    }

    public final void setFontSimple(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fontSimple = str;
    }

    public final void setFontWeight(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fontWeight = str;
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
        return "UIDemoFontBean(fontSimple=" + this.fontSimple + ", fontWeight=" + this.fontWeight + ", name=" + this.name + ", resIds=" + this.resIds + ')';
    }
}
