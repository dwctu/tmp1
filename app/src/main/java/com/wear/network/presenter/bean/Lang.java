package com.wear.network.presenter.bean;

import com.huawei.hms.framework.common.ContainerUtils;
import dc.mf1;
import dc.of1;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RequestLangBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0086\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\u0006\u00106\u001a\u000207J\t\u00108\u001a\u000207HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u00069"}, d2 = {"Lcom/wear/network/presenter/bean/Lang;", "", "de", "", "en", "es", "fr", "ja", "ko", "pl", "ru", "zh", "zhTw", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getDe", "()Ljava/lang/Long;", "setDe", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEn", "setEn", "getEs", "setEs", "getFr", "setFr", "getJa", "setJa", "getKo", "setKo", "getPl", "setPl", "getRu", "setRu", "getZh", "setZh", "getZhTw", "setZhTw", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/wear/network/presenter/bean/Lang;", "equals", "", "other", "hashCode", "", "sortedFields", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class Lang {

    @Nullable
    private Long de;

    @Nullable
    private Long en;

    @Nullable
    private Long es;

    @Nullable
    private Long fr;

    @Nullable
    private Long ja;

    @Nullable
    private Long ko;

    @Nullable
    private Long pl;

    @Nullable
    private Long ru;

    @Nullable
    private Long zh;

    @Nullable
    private Long zhTw;

    public Lang() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public Lang(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable Long l5, @Nullable Long l6, @Nullable Long l7, @Nullable Long l8, @Nullable Long l9, @mf1(name = "zh-tw") @Nullable Long l10) {
        this.de = l;
        this.en = l2;
        this.es = l3;
        this.fr = l4;
        this.ja = l5;
        this.ko = l6;
        this.pl = l7;
        this.ru = l8;
        this.zh = l9;
        this.zhTw = l10;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getDe() {
        return this.de;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Long getZhTw() {
        return this.zhTw;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getEn() {
        return this.en;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getEs() {
        return this.es;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getFr() {
        return this.fr;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getJa() {
        return this.ja;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getKo() {
        return this.ko;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getPl() {
        return this.pl;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Long getRu() {
        return this.ru;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Long getZh() {
        return this.zh;
    }

    @NotNull
    public final Lang copy(@Nullable Long de2, @Nullable Long en, @Nullable Long es, @Nullable Long fr, @Nullable Long ja, @Nullable Long ko, @Nullable Long pl2, @Nullable Long ru, @Nullable Long zh, @mf1(name = "zh-tw") @Nullable Long zhTw) {
        return new Lang(de2, en, es, fr, ja, ko, pl2, ru, zh, zhTw);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Lang)) {
            return false;
        }
        Lang lang = (Lang) other;
        return Intrinsics.areEqual(this.de, lang.de) && Intrinsics.areEqual(this.en, lang.en) && Intrinsics.areEqual(this.es, lang.es) && Intrinsics.areEqual(this.fr, lang.fr) && Intrinsics.areEqual(this.ja, lang.ja) && Intrinsics.areEqual(this.ko, lang.ko) && Intrinsics.areEqual(this.pl, lang.pl) && Intrinsics.areEqual(this.ru, lang.ru) && Intrinsics.areEqual(this.zh, lang.zh) && Intrinsics.areEqual(this.zhTw, lang.zhTw);
    }

    @Nullable
    public final Long getDe() {
        return this.de;
    }

    @Nullable
    public final Long getEn() {
        return this.en;
    }

    @Nullable
    public final Long getEs() {
        return this.es;
    }

    @Nullable
    public final Long getFr() {
        return this.fr;
    }

    @Nullable
    public final Long getJa() {
        return this.ja;
    }

    @Nullable
    public final Long getKo() {
        return this.ko;
    }

    @Nullable
    public final Long getPl() {
        return this.pl;
    }

    @Nullable
    public final Long getRu() {
        return this.ru;
    }

    @Nullable
    public final Long getZh() {
        return this.zh;
    }

    @Nullable
    public final Long getZhTw() {
        return this.zhTw;
    }

    public int hashCode() {
        Long l = this.de;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.en;
        int iHashCode2 = (iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.es;
        int iHashCode3 = (iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.fr;
        int iHashCode4 = (iHashCode3 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.ja;
        int iHashCode5 = (iHashCode4 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l6 = this.ko;
        int iHashCode6 = (iHashCode5 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.pl;
        int iHashCode7 = (iHashCode6 + (l7 == null ? 0 : l7.hashCode())) * 31;
        Long l8 = this.ru;
        int iHashCode8 = (iHashCode7 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Long l9 = this.zh;
        int iHashCode9 = (iHashCode8 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.zhTw;
        return iHashCode9 + (l10 != null ? l10.hashCode() : 0);
    }

    public final void setDe(@Nullable Long l) {
        this.de = l;
    }

    public final void setEn(@Nullable Long l) {
        this.en = l;
    }

    public final void setEs(@Nullable Long l) {
        this.es = l;
    }

    public final void setFr(@Nullable Long l) {
        this.fr = l;
    }

    public final void setJa(@Nullable Long l) {
        this.ja = l;
    }

    public final void setKo(@Nullable Long l) {
        this.ko = l;
    }

    public final void setPl(@Nullable Long l) {
        this.pl = l;
    }

    public final void setRu(@Nullable Long l) {
        this.ru = l;
    }

    public final void setZh(@Nullable Long l) {
        this.zh = l;
    }

    public final void setZhTw(@Nullable Long l) {
        this.zhTw = l;
    }

    @NotNull
    public final String sortedFields() throws IllegalAccessException, IllegalArgumentException {
        String name;
        Field[] properties = Lang.class.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(properties, "properties");
        List<Field> listSortedWith = ArraysKt___ArraysKt.sortedWith(properties, new Comparator() { // from class: com.wear.network.presenter.bean.Lang$sortedFields$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(((Field) t).getName(), ((Field) t2).getName());
            }
        });
        ArrayList arrayList = new ArrayList();
        for (Field field : listSortedWith) {
            field.setAccessible(true);
            Object obj = field.get(this);
            mf1 mf1Var = (mf1) field.getAnnotation(mf1.class);
            if (mf1Var == null || (name = mf1Var.name()) == null) {
                name = field.getName();
            }
            if (Intrinsics.areEqual(name, "zhTw")) {
                name = "zh-tw";
            }
            arrayList.add(name + '=' + obj);
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
    }

    @NotNull
    public String toString() {
        return "Lang(de=" + this.de + ", en=" + this.en + ", es=" + this.es + ", fr=" + this.fr + ", ja=" + this.ja + ", ko=" + this.ko + ", pl=" + this.pl + ", ru=" + this.ru + ", zh=" + this.zh + ", zhTw=" + this.zhTw + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Lang(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Long l9, Long l10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? l : l, (i & 2) != 0 ? l : l2, (i & 4) != 0 ? l : l3, (i & 8) != 0 ? l : l4, (i & 16) != 0 ? l : l5, (i & 32) != 0 ? l : l6, (i & 64) != 0 ? l : l7, (i & 128) != 0 ? l : l8, (i & 256) != 0 ? l : l9, (i & 512) == 0 ? l10 : 0L);
    }
}
