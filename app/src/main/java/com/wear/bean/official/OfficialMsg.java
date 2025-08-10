package com.wear.bean.official;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.BaseEntity;
import com.wear.util.WearUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialMessageBean.kt */
@DatabaseTable(tableName = "tb_official_msg")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J2\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001e\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006-"}, d2 = {"Lcom/wear/bean/official/OfficialMsg;", "Lcom/wear/bean/BaseEntity;", "userId", "", "lang", "Lcom/wear/bean/official/OfficialLangMsgBean;", "unreadMessage", "", "(Ljava/lang/String;Lcom/wear/bean/official/OfficialLangMsgBean;Ljava/lang/Long;)V", "getLang", "()Lcom/wear/bean/official/OfficialLangMsgBean;", "setLang", "(Lcom/wear/bean/official/OfficialLangMsgBean;)V", "langString", "getLangString", "()Ljava/lang/String;", "setLangString", "(Ljava/lang/String;)V", "officialMsgId", "getOfficialMsgId", "()Ljava/lang/Long;", "setOfficialMsgId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUnreadMessage", "setUnreadMessage", "getUserId", "setUserId", "userReceiveTime", "getUserReceiveTime", "()J", "setUserReceiveTime", "(J)V", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/wear/bean/official/OfficialLangMsgBean;Ljava/lang/Long;)Lcom/wear/bean/official/OfficialMsg;", "equals", "", "other", "", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OfficialMsg extends BaseEntity {

    @Nullable
    private OfficialLangMsgBean lang;

    @DatabaseField
    @NotNull
    private String langString;

    @DatabaseField
    @Nullable
    private Long officialMsgId;

    @DatabaseField
    @Nullable
    private Long unreadMessage;

    @DatabaseField
    @Nullable
    private String userId;

    @DatabaseField
    private long userReceiveTime;

    public OfficialMsg() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ OfficialMsg(String str, OfficialLangMsgBean officialLangMsgBean, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : officialLangMsgBean, (i & 4) != 0 ? 0L : l);
    }

    public static /* synthetic */ OfficialMsg copy$default(OfficialMsg officialMsg, String str, OfficialLangMsgBean officialLangMsgBean, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = officialMsg.userId;
        }
        if ((i & 2) != 0) {
            officialLangMsgBean = officialMsg.lang;
        }
        if ((i & 4) != 0) {
            l = officialMsg.unreadMessage;
        }
        return officialMsg.copy(str, officialLangMsgBean, l);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final OfficialLangMsgBean getLang() {
        return this.lang;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getUnreadMessage() {
        return this.unreadMessage;
    }

    @NotNull
    public final OfficialMsg copy(@Nullable String userId, @Nullable OfficialLangMsgBean lang, @Nullable Long unreadMessage) {
        return new OfficialMsg(userId, lang, unreadMessage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialMsg)) {
            return false;
        }
        OfficialMsg officialMsg = (OfficialMsg) other;
        return Intrinsics.areEqual(this.userId, officialMsg.userId) && Intrinsics.areEqual(this.lang, officialMsg.lang) && Intrinsics.areEqual(this.unreadMessage, officialMsg.unreadMessage);
    }

    @Nullable
    public final OfficialLangMsgBean getLang() {
        return this.lang;
    }

    @NotNull
    public final String getLangString() {
        return this.langString;
    }

    @Nullable
    public final Long getOfficialMsgId() {
        return this.officialMsgId;
    }

    @Nullable
    public final Long getUnreadMessage() {
        return this.unreadMessage;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public final long getUserReceiveTime() {
        return this.userReceiveTime;
    }

    public int hashCode() {
        String str = this.userId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        OfficialLangMsgBean officialLangMsgBean = this.lang;
        int iHashCode2 = (iHashCode + (officialLangMsgBean == null ? 0 : officialLangMsgBean.hashCode())) * 31;
        Long l = this.unreadMessage;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final void setLang(@Nullable OfficialLangMsgBean officialLangMsgBean) {
        this.lang = officialLangMsgBean;
    }

    public final void setLangString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.langString = str;
    }

    public final void setOfficialMsgId(@Nullable Long l) {
        this.officialMsgId = l;
    }

    public final void setUnreadMessage(@Nullable Long l) {
        this.unreadMessage = l;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    public final void setUserReceiveTime(long j) {
        this.userReceiveTime = j;
    }

    @NotNull
    public String toString() {
        return "OfficialMsg(userId=" + this.userId + ", lang=" + this.lang + ", unreadMessage=" + this.unreadMessage + ')';
    }

    public OfficialMsg(@Nullable String str, @Nullable OfficialLangMsgBean officialLangMsgBean, @Nullable Long l) {
        this.userId = str;
        this.lang = officialLangMsgBean;
        this.unreadMessage = l;
        this.officialMsgId = 0L;
        String json = WearUtils.A.toJson(this.lang);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(lang)");
        this.langString = json;
    }
}
