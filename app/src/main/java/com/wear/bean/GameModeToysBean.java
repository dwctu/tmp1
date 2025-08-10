package com.wear.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GameModeToysBean.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/wear/bean/GameModeToysBean;", "", "type", "", "toys", "", "Lcom/wear/bean/Toy;", "(Ljava/lang/Integer;Ljava/util/List;)V", "getToys", "()Ljava/util/List;", "setToys", "(Ljava/util/List;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/wear/bean/GameModeToysBean;", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GameModeToysBean {

    @Nullable
    private List<? extends Toy> toys;

    @Nullable
    private Integer type;

    public GameModeToysBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public GameModeToysBean(@Nullable Integer num, @Nullable List<? extends Toy> list) {
        this.type = num;
        this.toys = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameModeToysBean copy$default(GameModeToysBean gameModeToysBean, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = gameModeToysBean.type;
        }
        if ((i & 2) != 0) {
            list = gameModeToysBean.toys;
        }
        return gameModeToysBean.copy(num, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    public final List<Toy> component2() {
        return this.toys;
    }

    @NotNull
    public final GameModeToysBean copy(@Nullable Integer type, @Nullable List<? extends Toy> toys) {
        return new GameModeToysBean(type, toys);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameModeToysBean)) {
            return false;
        }
        GameModeToysBean gameModeToysBean = (GameModeToysBean) other;
        return Intrinsics.areEqual(this.type, gameModeToysBean.type) && Intrinsics.areEqual(this.toys, gameModeToysBean.toys);
    }

    @Nullable
    public final List<Toy> getToys() {
        return this.toys;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.type;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<? extends Toy> list = this.toys;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setToys(@Nullable List<? extends Toy> list) {
        this.toys = list;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "GameModeToysBean(type=" + this.type + ", toys=" + this.toys + ')';
    }

    public /* synthetic */ GameModeToysBean(Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? null : list);
    }
}
