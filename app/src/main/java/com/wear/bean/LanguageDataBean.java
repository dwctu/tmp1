package com.wear.bean;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LanguageDataBean.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\"\b\u0002\u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J#\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003JE\u0010\r\u001a\u00020\u00002\"\b\u0002\u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R+\u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/wear/bean/LanguageDataBean;", "", "lang", "", "", "version", "", "(Ljava/util/Map;Ljava/util/Map;)V", "getLang", "()Ljava/util/Map;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LanguageDataBean {

    @Nullable
    private final Map<String, Map<String, String>> lang;

    @Nullable
    private final Map<String, Long> version;

    public LanguageDataBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LanguageDataBean(@Nullable Map<String, ? extends Map<String, String>> map, @Nullable Map<String, Long> map2) {
        this.lang = map;
        this.version = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LanguageDataBean copy$default(LanguageDataBean languageDataBean, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = languageDataBean.lang;
        }
        if ((i & 2) != 0) {
            map2 = languageDataBean.version;
        }
        return languageDataBean.copy(map, map2);
    }

    @Nullable
    public final Map<String, Map<String, String>> component1() {
        return this.lang;
    }

    @Nullable
    public final Map<String, Long> component2() {
        return this.version;
    }

    @NotNull
    public final LanguageDataBean copy(@Nullable Map<String, ? extends Map<String, String>> lang, @Nullable Map<String, Long> version) {
        return new LanguageDataBean(lang, version);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageDataBean)) {
            return false;
        }
        LanguageDataBean languageDataBean = (LanguageDataBean) other;
        return Intrinsics.areEqual(this.lang, languageDataBean.lang) && Intrinsics.areEqual(this.version, languageDataBean.version);
    }

    @Nullable
    public final Map<String, Map<String, String>> getLang() {
        return this.lang;
    }

    @Nullable
    public final Map<String, Long> getVersion() {
        return this.version;
    }

    public int hashCode() {
        Map<String, Map<String, String>> map = this.lang;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, Long> map2 = this.version;
        return iHashCode + (map2 != null ? map2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LanguageDataBean(lang=" + this.lang + ", version=" + this.version + ')';
    }

    public /* synthetic */ LanguageDataBean(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2);
    }
}
