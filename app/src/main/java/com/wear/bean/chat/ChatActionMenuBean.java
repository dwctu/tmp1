package com.wear.bean.chat;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatActionMenuBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/wear/bean/chat/ChatActionMenuBean;", "", MessageBundle.TITLE_ENTRY, "", "icon", "", "desc", "type", "isEnable", "", "(Ljava/lang/String;ILjava/lang/String;IZ)V", "getDesc", "()Ljava/lang/String;", "getIcon", "()I", "()Z", "setEnable", "(Z)V", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatActionMenuBean {

    @NotNull
    private final String desc;
    private final int icon;
    private boolean isEnable;

    @NotNull
    private final String title;
    private final int type;

    public ChatActionMenuBean(@NotNull String title, int i, @NotNull String desc, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.title = title;
        this.icon = i;
        this.desc = desc;
        this.type = i2;
        this.isEnable = z;
    }

    public static /* synthetic */ ChatActionMenuBean copy$default(ChatActionMenuBean chatActionMenuBean, String str, int i, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = chatActionMenuBean.title;
        }
        if ((i3 & 2) != 0) {
            i = chatActionMenuBean.icon;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            str2 = chatActionMenuBean.desc;
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            i2 = chatActionMenuBean.type;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            z = chatActionMenuBean.isEnable;
        }
        return chatActionMenuBean.copy(str, i4, str3, i5, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    @NotNull
    public final ChatActionMenuBean copy(@NotNull String title, int icon, @NotNull String desc, int type, boolean isEnable) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new ChatActionMenuBean(title, icon, desc, type, isEnable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatActionMenuBean)) {
            return false;
        }
        ChatActionMenuBean chatActionMenuBean = (ChatActionMenuBean) other;
        return Intrinsics.areEqual(this.title, chatActionMenuBean.title) && this.icon == chatActionMenuBean.icon && Intrinsics.areEqual(this.desc, chatActionMenuBean.desc) && this.type == chatActionMenuBean.type && this.isEnable == chatActionMenuBean.isEnable;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((((this.title.hashCode() * 31) + this.icon) * 31) + this.desc.hashCode()) * 31) + this.type) * 31;
        boolean z = this.isEnable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final void setEnable(boolean z) {
        this.isEnable = z;
    }

    @NotNull
    public String toString() {
        return "ChatActionMenuBean(title=" + this.title + ", icon=" + this.icon + ", desc=" + this.desc + ", type=" + this.type + ", isEnable=" + this.isEnable + ')';
    }

    public /* synthetic */ ChatActionMenuBean(String str, int i, String str2, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, i2, (i3 & 16) != 0 ? true : z);
    }
}
