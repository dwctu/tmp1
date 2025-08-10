package com.wear.bean;

import dc.ek2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: Solace2StateProxy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/wear/bean/Solace2StateProxy;", "", MultipleAddresses.Address.ELEMENT, "", "solaceProModel", "Lcom/wear/main/toy/solacepro/SolaceProModel;", "isSelected", "", "(Ljava/lang/String;Lcom/wear/main/toy/solacepro/SolaceProModel;Z)V", "getAddress", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "getSolaceProModel", "()Lcom/wear/main/toy/solacepro/SolaceProModel;", "setSolaceProModel", "(Lcom/wear/main/toy/solacepro/SolaceProModel;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Solace2StateProxy {

    @NotNull
    private final String address;
    private boolean isSelected;

    @NotNull
    private ek2 solaceProModel;

    public Solace2StateProxy(@NotNull String address, @NotNull ek2 solaceProModel, boolean z) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(solaceProModel, "solaceProModel");
        this.address = address;
        this.solaceProModel = solaceProModel;
        this.isSelected = z;
    }

    public static /* synthetic */ Solace2StateProxy copy$default(Solace2StateProxy solace2StateProxy, String str, ek2 ek2Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = solace2StateProxy.address;
        }
        if ((i & 2) != 0) {
            ek2Var = solace2StateProxy.solaceProModel;
        }
        if ((i & 4) != 0) {
            z = solace2StateProxy.isSelected;
        }
        return solace2StateProxy.copy(str, ek2Var, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ek2 getSolaceProModel() {
        return this.solaceProModel;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @NotNull
    public final Solace2StateProxy copy(@NotNull String address, @NotNull ek2 solaceProModel, boolean z) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(solaceProModel, "solaceProModel");
        return new Solace2StateProxy(address, solaceProModel, z);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Solace2StateProxy)) {
            return false;
        }
        Solace2StateProxy solace2StateProxy = (Solace2StateProxy) other;
        return Intrinsics.areEqual(this.address, solace2StateProxy.address) && this.solaceProModel == solace2StateProxy.solaceProModel && this.isSelected == solace2StateProxy.isSelected;
    }

    @NotNull
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final ek2 getSolaceProModel() {
        return this.solaceProModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.address.hashCode() * 31) + this.solaceProModel.hashCode()) * 31;
        boolean z = this.isSelected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setSolaceProModel(@NotNull ek2 ek2Var) {
        Intrinsics.checkNotNullParameter(ek2Var, "<set-?>");
        this.solaceProModel = ek2Var;
    }

    @NotNull
    public String toString() {
        return "Solace2StateProxy(address=" + this.address + ", solaceProModel=" + this.solaceProModel + ", isSelected=" + this.isSelected + ')';
    }
}
