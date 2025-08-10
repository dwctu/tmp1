package com.epicgames.unreal.network;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface NetworkConnectivityClient {

    public interface Listener {
        void onNetworkAvailable(NetworkTransportType networkTransportType);

        void onNetworkLost();
    }

    public enum NetworkTransportType {
        WIFI,
        VPN,
        ETHERNET,
        CELLULAR,
        BLUETOOTH,
        UNKNOWN
    }

    boolean addListener(Listener listener);

    boolean addListener(Listener listener, boolean z);

    void checkConnectivity();

    void initNetworkCallback(@NonNull Context context);

    boolean removeListener(Listener listener);
}
