package com.wear.bean.vb;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JsPatternUrlBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/wear/bean/vb/JsPatternUrlBean;", "", "result", "", "patternUrl", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getPatternUrl", "()Ljava/lang/String;", "setPatternUrl", "(Ljava/lang/String;)V", "getResult", "()Ljava/lang/Boolean;", "setResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/wear/bean/vb/JsPatternUrlBean;", "equals", "other", "hashCode", "", "noEmpty", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class JsPatternUrlBean {

    @Nullable
    private String patternUrl;

    @Nullable
    private Boolean result;

    public JsPatternUrlBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public JsPatternUrlBean(@Nullable Boolean bool, @Nullable String str) {
        this.result = bool;
        this.patternUrl = str;
    }

    public static /* synthetic */ JsPatternUrlBean copy$default(JsPatternUrlBean jsPatternUrlBean, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = jsPatternUrlBean.result;
        }
        if ((i & 2) != 0) {
            str = jsPatternUrlBean.patternUrl;
        }
        return jsPatternUrlBean.copy(bool, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @NotNull
    public final JsPatternUrlBean copy(@Nullable Boolean result, @Nullable String patternUrl) {
        return new JsPatternUrlBean(result, patternUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JsPatternUrlBean)) {
            return false;
        }
        JsPatternUrlBean jsPatternUrlBean = (JsPatternUrlBean) other;
        return Intrinsics.areEqual(this.result, jsPatternUrlBean.result) && Intrinsics.areEqual(this.patternUrl, jsPatternUrlBean.patternUrl);
    }

    @Nullable
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @Nullable
    public final Boolean getResult() {
        return this.result;
    }

    public int hashCode() {
        Boolean bool = this.result;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.patternUrl;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean noEmpty() {
        if (Intrinsics.areEqual(this.result, Boolean.TRUE)) {
            String str = this.patternUrl;
            if (str == null || str.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void setPatternUrl(@Nullable String str) {
        this.patternUrl = str;
    }

    public final void setResult(@Nullable Boolean bool) {
        this.result = bool;
    }

    @NotNull
    public String toString() {
        return "JsPatternUrlBean(result=" + this.result + ", patternUrl=" + this.patternUrl + ')';
    }

    public /* synthetic */ JsPatternUrlBean(Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? null : str);
    }
}
