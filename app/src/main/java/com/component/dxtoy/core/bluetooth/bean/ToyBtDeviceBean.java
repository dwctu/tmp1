package com.component.dxtoy.core.bluetooth.bean;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyBtDeviceBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/bean/ToyBtDeviceBean;", "", "mac", "", "serviceList", "", "Landroid/bluetooth/BluetoothGattService;", FirebaseAnalytics.Param.CHARACTER, "Landroid/bluetooth/BluetoothGattCharacteristic;", "serviceUUID", "Ljava/util/UUID;", "characterUUID", "(Ljava/lang/String;Ljava/util/List;Landroid/bluetooth/BluetoothGattCharacteristic;Ljava/util/UUID;Ljava/util/UUID;)V", "getCharacter", "()Landroid/bluetooth/BluetoothGattCharacteristic;", "getCharacterUUID", "()Ljava/util/UUID;", "getMac", "()Ljava/lang/String;", "getServiceList", "()Ljava/util/List;", "getServiceUUID", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ToyBtDeviceBean {

    @NotNull
    private final BluetoothGattCharacteristic character;

    @NotNull
    private final UUID characterUUID;

    @NotNull
    private final String mac;

    @NotNull
    private final List<BluetoothGattService> serviceList;

    @NotNull
    private final UUID serviceUUID;

    /* JADX WARN: Multi-variable type inference failed */
    public ToyBtDeviceBean(@NotNull String mac, @NotNull List<? extends BluetoothGattService> serviceList, @NotNull BluetoothGattCharacteristic character, @NotNull UUID serviceUUID, @NotNull UUID characterUUID) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(serviceList, "serviceList");
        Intrinsics.checkNotNullParameter(character, "character");
        Intrinsics.checkNotNullParameter(serviceUUID, "serviceUUID");
        Intrinsics.checkNotNullParameter(characterUUID, "characterUUID");
        this.mac = mac;
        this.serviceList = serviceList;
        this.character = character;
        this.serviceUUID = serviceUUID;
        this.characterUUID = characterUUID;
    }

    @NotNull
    public final BluetoothGattCharacteristic getCharacter() {
        return this.character;
    }

    @NotNull
    public final UUID getCharacterUUID() {
        return this.characterUUID;
    }

    @NotNull
    public final String getMac() {
        return this.mac;
    }

    @NotNull
    public final List<BluetoothGattService> getServiceList() {
        return this.serviceList;
    }

    @NotNull
    public final UUID getServiceUUID() {
        return this.serviceUUID;
    }
}
