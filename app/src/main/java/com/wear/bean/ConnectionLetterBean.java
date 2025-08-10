package com.wear.bean;

import dc.tq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConnectionBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/wear/bean/ConnectionLetterBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "letter", "", "(Ljava/lang/String;)V", "itemType", "", "getItemType", "()I", "getLetter", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConnectionLetterBean implements tq {

    @NotNull
    private final String letter;

    public ConnectionLetterBean(@NotNull String letter) {
        Intrinsics.checkNotNullParameter(letter, "letter");
        this.letter = letter;
    }

    public static /* synthetic */ ConnectionLetterBean copy$default(ConnectionLetterBean connectionLetterBean, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectionLetterBean.letter;
        }
        return connectionLetterBean.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getLetter() {
        return this.letter;
    }

    @NotNull
    public final ConnectionLetterBean copy(@NotNull String letter) {
        Intrinsics.checkNotNullParameter(letter, "letter");
        return new ConnectionLetterBean(letter);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConnectionLetterBean) && Intrinsics.areEqual(this.letter, ((ConnectionLetterBean) other).letter);
    }

    @Override // dc.tq
    public int getItemType() {
        return 0;
    }

    @NotNull
    public final String getLetter() {
        return this.letter;
    }

    public int hashCode() {
        return this.letter.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConnectionLetterBean(letter=" + this.letter + ')';
    }
}
