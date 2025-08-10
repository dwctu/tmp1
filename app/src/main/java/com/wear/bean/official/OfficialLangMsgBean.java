package com.wear.bean.official;

import dc.mf1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialMessageBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u00066"}, d2 = {"Lcom/wear/bean/official/OfficialLangMsgBean;", "", "en", "Lcom/wear/bean/official/OfficialLangInfo;", "fr", "es", "pl", "ru", "ja", "ko", "de", "zh", "zhTw", "(Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;Lcom/wear/bean/official/OfficialLangInfo;)V", "getDe", "()Lcom/wear/bean/official/OfficialLangInfo;", "setDe", "(Lcom/wear/bean/official/OfficialLangInfo;)V", "getEn", "setEn", "getEs", "setEs", "getFr", "setFr", "getJa", "setJa", "getKo", "setKo", "getPl", "setPl", "getRu", "setRu", "getZh", "setZh", "getZhTw", "setZhTw", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OfficialLangMsgBean {

    @Nullable
    private OfficialLangInfo de;

    @Nullable
    private OfficialLangInfo en;

    @Nullable
    private OfficialLangInfo es;

    @Nullable
    private OfficialLangInfo fr;

    @Nullable
    private OfficialLangInfo ja;

    @Nullable
    private OfficialLangInfo ko;

    @Nullable
    private OfficialLangInfo pl;

    @Nullable
    private OfficialLangInfo ru;

    @Nullable
    private OfficialLangInfo zh;

    @Nullable
    private OfficialLangInfo zhTw;

    public OfficialLangMsgBean() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public OfficialLangMsgBean(@Nullable OfficialLangInfo officialLangInfo, @Nullable OfficialLangInfo officialLangInfo2, @Nullable OfficialLangInfo officialLangInfo3, @Nullable OfficialLangInfo officialLangInfo4, @Nullable OfficialLangInfo officialLangInfo5, @Nullable OfficialLangInfo officialLangInfo6, @Nullable OfficialLangInfo officialLangInfo7, @Nullable OfficialLangInfo officialLangInfo8, @Nullable OfficialLangInfo officialLangInfo9, @mf1(name = "zh-tw") @Nullable OfficialLangInfo officialLangInfo10) {
        this.en = officialLangInfo;
        this.fr = officialLangInfo2;
        this.es = officialLangInfo3;
        this.pl = officialLangInfo4;
        this.ru = officialLangInfo5;
        this.ja = officialLangInfo6;
        this.ko = officialLangInfo7;
        this.de = officialLangInfo8;
        this.zh = officialLangInfo9;
        this.zhTw = officialLangInfo10;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final OfficialLangInfo getEn() {
        return this.en;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final OfficialLangInfo getZhTw() {
        return this.zhTw;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final OfficialLangInfo getFr() {
        return this.fr;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final OfficialLangInfo getEs() {
        return this.es;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final OfficialLangInfo getPl() {
        return this.pl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final OfficialLangInfo getRu() {
        return this.ru;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final OfficialLangInfo getJa() {
        return this.ja;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final OfficialLangInfo getKo() {
        return this.ko;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final OfficialLangInfo getDe() {
        return this.de;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final OfficialLangInfo getZh() {
        return this.zh;
    }

    @NotNull
    public final OfficialLangMsgBean copy(@Nullable OfficialLangInfo en, @Nullable OfficialLangInfo fr, @Nullable OfficialLangInfo es, @Nullable OfficialLangInfo pl2, @Nullable OfficialLangInfo ru, @Nullable OfficialLangInfo ja, @Nullable OfficialLangInfo ko, @Nullable OfficialLangInfo de2, @Nullable OfficialLangInfo zh, @mf1(name = "zh-tw") @Nullable OfficialLangInfo zhTw) {
        return new OfficialLangMsgBean(en, fr, es, pl2, ru, ja, ko, de2, zh, zhTw);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialLangMsgBean)) {
            return false;
        }
        OfficialLangMsgBean officialLangMsgBean = (OfficialLangMsgBean) other;
        return Intrinsics.areEqual(this.en, officialLangMsgBean.en) && Intrinsics.areEqual(this.fr, officialLangMsgBean.fr) && Intrinsics.areEqual(this.es, officialLangMsgBean.es) && Intrinsics.areEqual(this.pl, officialLangMsgBean.pl) && Intrinsics.areEqual(this.ru, officialLangMsgBean.ru) && Intrinsics.areEqual(this.ja, officialLangMsgBean.ja) && Intrinsics.areEqual(this.ko, officialLangMsgBean.ko) && Intrinsics.areEqual(this.de, officialLangMsgBean.de) && Intrinsics.areEqual(this.zh, officialLangMsgBean.zh) && Intrinsics.areEqual(this.zhTw, officialLangMsgBean.zhTw);
    }

    @Nullable
    public final OfficialLangInfo getDe() {
        return this.de;
    }

    @Nullable
    public final OfficialLangInfo getEn() {
        return this.en;
    }

    @Nullable
    public final OfficialLangInfo getEs() {
        return this.es;
    }

    @Nullable
    public final OfficialLangInfo getFr() {
        return this.fr;
    }

    @Nullable
    public final OfficialLangInfo getJa() {
        return this.ja;
    }

    @Nullable
    public final OfficialLangInfo getKo() {
        return this.ko;
    }

    @Nullable
    public final OfficialLangInfo getPl() {
        return this.pl;
    }

    @Nullable
    public final OfficialLangInfo getRu() {
        return this.ru;
    }

    @Nullable
    public final OfficialLangInfo getZh() {
        return this.zh;
    }

    @Nullable
    public final OfficialLangInfo getZhTw() {
        return this.zhTw;
    }

    public int hashCode() {
        OfficialLangInfo officialLangInfo = this.en;
        int iHashCode = (officialLangInfo == null ? 0 : officialLangInfo.hashCode()) * 31;
        OfficialLangInfo officialLangInfo2 = this.fr;
        int iHashCode2 = (iHashCode + (officialLangInfo2 == null ? 0 : officialLangInfo2.hashCode())) * 31;
        OfficialLangInfo officialLangInfo3 = this.es;
        int iHashCode3 = (iHashCode2 + (officialLangInfo3 == null ? 0 : officialLangInfo3.hashCode())) * 31;
        OfficialLangInfo officialLangInfo4 = this.pl;
        int iHashCode4 = (iHashCode3 + (officialLangInfo4 == null ? 0 : officialLangInfo4.hashCode())) * 31;
        OfficialLangInfo officialLangInfo5 = this.ru;
        int iHashCode5 = (iHashCode4 + (officialLangInfo5 == null ? 0 : officialLangInfo5.hashCode())) * 31;
        OfficialLangInfo officialLangInfo6 = this.ja;
        int iHashCode6 = (iHashCode5 + (officialLangInfo6 == null ? 0 : officialLangInfo6.hashCode())) * 31;
        OfficialLangInfo officialLangInfo7 = this.ko;
        int iHashCode7 = (iHashCode6 + (officialLangInfo7 == null ? 0 : officialLangInfo7.hashCode())) * 31;
        OfficialLangInfo officialLangInfo8 = this.de;
        int iHashCode8 = (iHashCode7 + (officialLangInfo8 == null ? 0 : officialLangInfo8.hashCode())) * 31;
        OfficialLangInfo officialLangInfo9 = this.zh;
        int iHashCode9 = (iHashCode8 + (officialLangInfo9 == null ? 0 : officialLangInfo9.hashCode())) * 31;
        OfficialLangInfo officialLangInfo10 = this.zhTw;
        return iHashCode9 + (officialLangInfo10 != null ? officialLangInfo10.hashCode() : 0);
    }

    public final void setDe(@Nullable OfficialLangInfo officialLangInfo) {
        this.de = officialLangInfo;
    }

    public final void setEn(@Nullable OfficialLangInfo officialLangInfo) {
        this.en = officialLangInfo;
    }

    public final void setEs(@Nullable OfficialLangInfo officialLangInfo) {
        this.es = officialLangInfo;
    }

    public final void setFr(@Nullable OfficialLangInfo officialLangInfo) {
        this.fr = officialLangInfo;
    }

    public final void setJa(@Nullable OfficialLangInfo officialLangInfo) {
        this.ja = officialLangInfo;
    }

    public final void setKo(@Nullable OfficialLangInfo officialLangInfo) {
        this.ko = officialLangInfo;
    }

    public final void setPl(@Nullable OfficialLangInfo officialLangInfo) {
        this.pl = officialLangInfo;
    }

    public final void setRu(@Nullable OfficialLangInfo officialLangInfo) {
        this.ru = officialLangInfo;
    }

    public final void setZh(@Nullable OfficialLangInfo officialLangInfo) {
        this.zh = officialLangInfo;
    }

    public final void setZhTw(@Nullable OfficialLangInfo officialLangInfo) {
        this.zhTw = officialLangInfo;
    }

    @NotNull
    public String toString() {
        return "OfficialLangMsgBean(en=" + this.en + ", fr=" + this.fr + ", es=" + this.es + ", pl=" + this.pl + ", ru=" + this.ru + ", ja=" + this.ja + ", ko=" + this.ko + ", de=" + this.de + ", zh=" + this.zh + ", zhTw=" + this.zhTw + ')';
    }

    public /* synthetic */ OfficialLangMsgBean(OfficialLangInfo officialLangInfo, OfficialLangInfo officialLangInfo2, OfficialLangInfo officialLangInfo3, OfficialLangInfo officialLangInfo4, OfficialLangInfo officialLangInfo5, OfficialLangInfo officialLangInfo6, OfficialLangInfo officialLangInfo7, OfficialLangInfo officialLangInfo8, OfficialLangInfo officialLangInfo9, OfficialLangInfo officialLangInfo10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : officialLangInfo, (i & 2) != 0 ? null : officialLangInfo2, (i & 4) != 0 ? null : officialLangInfo3, (i & 8) != 0 ? null : officialLangInfo4, (i & 16) != 0 ? null : officialLangInfo5, (i & 32) != 0 ? null : officialLangInfo6, (i & 64) != 0 ? null : officialLangInfo7, (i & 128) != 0 ? null : officialLangInfo8, (i & 256) != 0 ? null : officialLangInfo9, (i & 512) == 0 ? officialLangInfo10 : null);
    }
}
