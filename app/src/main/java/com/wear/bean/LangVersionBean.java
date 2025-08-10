package com.wear.bean;

import com.wear.network.presenter.bean.Lang;
import dc.of1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LangVersionBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/wear/bean/LangVersionBean;", "", "version", "Lcom/wear/network/presenter/bean/Lang;", "(Lcom/wear/network/presenter/bean/Lang;)V", "getVersion", "()Lcom/wear/network/presenter/bean/Lang;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class LangVersionBean {

    @Nullable
    private final Lang version;

    public LangVersionBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public LangVersionBean(@Nullable Lang lang) {
        this.version = lang;
    }

    public static /* synthetic */ LangVersionBean copy$default(LangVersionBean langVersionBean, Lang lang, int i, Object obj) {
        if ((i & 1) != 0) {
            lang = langVersionBean.version;
        }
        return langVersionBean.copy(lang);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Lang getVersion() {
        return this.version;
    }

    @NotNull
    public final LangVersionBean copy(@Nullable Lang version) {
        return new LangVersionBean(version);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LangVersionBean) && Intrinsics.areEqual(this.version, ((LangVersionBean) other).version);
    }

    @Nullable
    public final Lang getVersion() {
        return this.version;
    }

    public int hashCode() {
        Lang lang = this.version;
        if (lang == null) {
            return 0;
        }
        return lang.hashCode();
    }

    @NotNull
    public String toString() {
        return "LangVersionBean(version=" + this.version + ')';
    }

    public /* synthetic */ LangVersionBean(Lang lang, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : lang);
    }
}
