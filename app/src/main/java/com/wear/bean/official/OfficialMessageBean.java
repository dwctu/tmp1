package com.wear.bean.official;

import com.wear.bean.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialMessageBean.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/wear/bean/official/OfficialMessageBean;", "Lcom/wear/bean/BaseEntity;", "Ljava/io/Serializable;", "officialMsgList", "", "Lcom/wear/bean/official/OfficialMsg;", "(Ljava/util/List;)V", "getOfficialMsgList", "()Ljava/util/List;", "setOfficialMsgList", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OfficialMessageBean extends BaseEntity implements Serializable {

    @Nullable
    private List<OfficialMsg> officialMsgList;

    public OfficialMessageBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OfficialMessageBean(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficialMessageBean copy$default(OfficialMessageBean officialMessageBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = officialMessageBean.officialMsgList;
        }
        return officialMessageBean.copy(list);
    }

    @Nullable
    public final List<OfficialMsg> component1() {
        return this.officialMsgList;
    }

    @NotNull
    public final OfficialMessageBean copy(@Nullable List<OfficialMsg> officialMsgList) {
        return new OfficialMessageBean(officialMsgList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OfficialMessageBean) && Intrinsics.areEqual(this.officialMsgList, ((OfficialMessageBean) other).officialMsgList);
    }

    @Nullable
    public final List<OfficialMsg> getOfficialMsgList() {
        return this.officialMsgList;
    }

    public int hashCode() {
        List<OfficialMsg> list = this.officialMsgList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setOfficialMsgList(@Nullable List<OfficialMsg> list) {
        this.officialMsgList = list;
    }

    @NotNull
    public String toString() {
        return "OfficialMessageBean(officialMsgList=" + this.officialMsgList + ')';
    }

    public OfficialMessageBean(@Nullable List<OfficialMsg> list) {
        this.officialMsgList = list;
    }
}
