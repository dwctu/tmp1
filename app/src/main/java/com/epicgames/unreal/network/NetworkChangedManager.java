package com.epicgames.unreal.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.epicgames.unreal.Logger;
import com.epicgames.unreal.network.NetworkConnectivityClient;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class NetworkChangedManager implements NetworkConnectivityClient {
    private static final long HOSTNAME_RESOLUTION_TIMEOUT_MS = 2000;
    private static final String[] HOST_RESOLUTION_ADDRESSES = {"https://example.com/", "https://google.com/", "https://www.samsung.com/"};
    private static final Logger Log = new Logger("UE", "NetworkChangedManager");
    private static final int MAX_RETRY_SEC = 13;
    private static NetworkChangedManager instance;
    private ConnectivityManager connectivityManager;
    private int currentHostResolutionAddressIndex = 0;

    @NonNull
    private Set<WeakReference<NetworkConnectivityClient.Listener>> networkChangedListeners = new HashSet();
    private Set<String> networks = new HashSet();

    @Nullable
    private ConnectivityState currentState = null;

    @Nullable
    private NetworkConnectivityClient.NetworkTransportType currentNetworkTransport = NetworkConnectivityClient.NetworkTransportType.UNKNOWN;
    private boolean networkCheckInProgress = false;
    private boolean retryScheduled = false;
    private int retryCount = 0;
    private Handler internalScheduler = new Handler();

    @TargetApi(21)
    private ConnectivityManager.NetworkCallback connectivityListener = new ConnectivityManager.NetworkCallback() { // from class: com.epicgames.unreal.network.NetworkChangedManager.1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkChangedManager.this.networks.add(network.toString());
            NetworkChangedManager.Log.verbose("Network Available: " + network.toString());
            NetworkChangedManager.this.checkNetworkConnectivity();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (Build.VERSION.SDK_INT >= 23 && !networkCapabilities.hasCapability(16)) {
                NetworkChangedManager.Log.verbose("Network Capabilities changed, doesn't have validated net_capability");
                NetworkChangedManager.this.networks.remove(network.toString());
            } else if (networkCapabilities.hasCapability(12)) {
                NetworkChangedManager.Log.verbose("Network Capabilities changed, has Internet: true");
                NetworkChangedManager.this.networks.add(network.toString());
            } else {
                NetworkChangedManager.Log.verbose("Network Capabilities changed, has Internet: false");
                NetworkChangedManager.this.networks.remove(network.toString());
            }
            NetworkChangedManager.this.checkNetworkConnectivity();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            NetworkChangedManager.this.networks.remove(network.toString());
            NetworkChangedManager.Log.verbose("Network Lost callback: " + network.toString());
            if (NetworkChangedManager.this.networks.isEmpty()) {
                NetworkChangedManager.Log.verbose("All Networks Lost");
            } else {
                NetworkChangedManager.Log.verbose("Not All Networks Lost");
            }
            NetworkChangedManager.this.checkNetworkConnectivity();
        }
    };
    private Runnable retryRunnable = new Runnable() { // from class: com.epicgames.unreal.network.NetworkChangedManager.2
        @Override // java.lang.Runnable
        public void run() {
            NetworkChangedManager.Log.verbose("Attempting to check for network connectivity again.");
            NetworkChangedManager.access$308(NetworkChangedManager.this);
            NetworkChangedManager.this.retryScheduled = false;
            NetworkChangedManager.this.checkNetworkConnectivity();
        }
    };

    /* renamed from: com.epicgames.unreal.network.NetworkChangedManager$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$epicgames$unreal$network$NetworkChangedManager$ConnectivityState;

        static {
            int[] iArr = new int[ConnectivityState.values().length];
            $SwitchMap$com$epicgames$unreal$network$NetworkChangedManager$ConnectivityState = iArr;
            try {
                iArr[ConnectivityState.NO_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$epicgames$unreal$network$NetworkChangedManager$ConnectivityState[ConnectivityState.CONNECTION_AVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum ConnectivityState {
        CONNECTION_AVAILABLE,
        NO_CONNECTION
    }

    private NetworkChangedManager() {
    }

    public static /* synthetic */ int access$308(NetworkChangedManager networkChangedManager) {
        int i = networkChangedManager.retryCount;
        networkChangedManager.retryCount = i + 1;
        return i;
    }

    @NonNull
    private ConnectivityState calculateNetworkConnectivityNaively() {
        ConnectivityManager connectivityManager;
        if (this.networks.isEmpty() || (connectivityManager = this.connectivityManager) == null) {
            return ConnectivityState.NO_CONNECTION;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) ? ConnectivityState.CONNECTION_AVAILABLE : ConnectivityState.NO_CONNECTION;
    }

    private NetworkConnectivityClient.NetworkTransportType calculateNetworkTransport(@NonNull ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return NetworkConnectivityClient.NetworkTransportType.UNKNOWN;
            }
            int type = activeNetworkInfo.getType();
            return type != 0 ? type != 1 ? type != 7 ? type != 9 ? type != 17 ? NetworkConnectivityClient.NetworkTransportType.UNKNOWN : NetworkConnectivityClient.NetworkTransportType.VPN : NetworkConnectivityClient.NetworkTransportType.ETHERNET : NetworkConnectivityClient.NetworkTransportType.BLUETOOTH : NetworkConnectivityClient.NetworkTransportType.WIFI : NetworkConnectivityClient.NetworkTransportType.CELLULAR;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return NetworkConnectivityClient.NetworkTransportType.UNKNOWN;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return networkCapabilities == null ? NetworkConnectivityClient.NetworkTransportType.UNKNOWN : networkCapabilities.hasTransport(1) ? NetworkConnectivityClient.NetworkTransportType.WIFI : networkCapabilities.hasTransport(0) ? NetworkConnectivityClient.NetworkTransportType.CELLULAR : networkCapabilities.hasTransport(3) ? NetworkConnectivityClient.NetworkTransportType.ETHERNET : networkCapabilities.hasTransport(2) ? NetworkConnectivityClient.NetworkTransportType.BLUETOOTH : networkCapabilities.hasTransport(4) ? NetworkConnectivityClient.NetworkTransportType.VPN : NetworkConnectivityClient.NetworkTransportType.UNKNOWN;
    }

    private long calculateRetryDelay() {
        return (long) (Math.min(13.0d, Math.pow(2.0d, this.retryCount)) * 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNetworkConnectivity() {
        ConnectivityState connectivityStateCalculateNetworkConnectivityNaively = calculateNetworkConnectivityNaively();
        if (connectivityStateCalculateNetworkConnectivityNaively != ConnectivityState.CONNECTION_AVAILABLE) {
            setNetworkState(ConnectivityState.NO_CONNECTION);
            return;
        }
        if (this.currentState == null) {
            Log.verbose("No network state set yet, setting naive network state checking connection fully.");
            setNetworkState(connectivityStateCalculateNetworkConnectivityNaively);
        }
        if (this.networkCheckInProgress) {
            return;
        }
        this.networkCheckInProgress = true;
        final ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        final Runnable runnable = new Runnable() { // from class: com.epicgames.unreal.network.NetworkChangedManager.3
            @Override // java.lang.Runnable
            public void run() {
                NetworkChangedManager.Log.verbose("Unable to connect to: " + NetworkChangedManager.this.getCurrentHostResolutionAddress());
                NetworkChangedManager.this.networkCheckInProgress = false;
                executorServiceNewSingleThreadExecutor.shutdownNow();
                NetworkChangedManager.this.setNetworkState(ConnectivityState.NO_CONNECTION);
                NetworkChangedManager.this.scheduleRetry();
            }
        };
        this.internalScheduler.postDelayed(runnable, (HOST_RESOLUTION_ADDRESSES.length * 2000) + 100);
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.epicgames.unreal.network.NetworkChangedManager.4
            /* JADX WARN: Removed duplicated region for block: B:26:0x00bc A[PHI: r2
  0x00bc: PHI (r2v15 java.net.HttpURLConnection) = (r2v14 java.net.HttpURLConnection), (r2v18 java.net.HttpURLConnection) binds: [B:25:0x00ba, B:29:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00ec  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 320
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.network.NetworkChangedManager.AnonymousClass4.run():void");
            }
        });
    }

    private void clearRetry() {
        this.internalScheduler.removeCallbacksAndMessages(this.retryRunnable);
        this.retryCount = 0;
        this.retryScheduled = false;
    }

    private void fireNetworkChangeListenerInternal(NetworkConnectivityClient.Listener listener, ConnectivityState connectivityState, NetworkConnectivityClient.NetworkTransportType networkTransportType) {
        int i = AnonymousClass5.$SwitchMap$com$epicgames$unreal$network$NetworkChangedManager$ConnectivityState[connectivityState.ordinal()];
        if (i == 1) {
            listener.onNetworkLost();
        } else {
            if (i != 2) {
                return;
            }
            listener.onNetworkAvailable(networkTransportType);
        }
    }

    private void fireNetworkChangeListeners(ConnectivityState connectivityState, NetworkConnectivityClient.NetworkTransportType networkTransportType) {
        Iterator<WeakReference<NetworkConnectivityClient.Listener>> it = this.networkChangedListeners.iterator();
        while (it.hasNext()) {
            NetworkConnectivityClient.Listener listener = it.next().get();
            if (listener == null) {
                it.remove();
            } else {
                fireNetworkChangeListenerInternal(listener, connectivityState, networkTransportType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentHostResolutionAddress() {
        return HOST_RESOLUTION_ADDRESSES[this.currentHostResolutionAddressIndex];
    }

    @NonNull
    public static synchronized NetworkConnectivityClient getInstance() {
        if (instance == null) {
            instance = new NetworkChangedManager();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextHostResolutionAddress() {
        int i = this.currentHostResolutionAddressIndex;
        if (i + 1 >= HOST_RESOLUTION_ADDRESSES.length) {
            this.currentHostResolutionAddressIndex = 0;
        } else {
            this.currentHostResolutionAddressIndex = i + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleRetry() {
        if (this.networkChangedListeners.size() == 0) {
            Log.verbose("No listeners so not retrying. When a listener is added the connection will be checked.");
        } else {
            if (this.retryScheduled || this.networkCheckInProgress) {
                return;
            }
            this.retryScheduled = true;
            this.internalScheduler.removeCallbacksAndMessages(this.retryRunnable);
            this.internalScheduler.postDelayed(this.retryRunnable, calculateRetryDelay());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNetworkState(ConnectivityState connectivityState) {
        NetworkConnectivityClient.NetworkTransportType networkTransportTypeCalculateNetworkTransport = calculateNetworkTransport(this.connectivityManager);
        if (this.currentState == connectivityState && this.currentNetworkTransport == networkTransportTypeCalculateNetworkTransport) {
            Log.verbose("Connectivity hasn't changed. Current state: " + this.currentState);
            if (this.currentState != ConnectivityState.CONNECTION_AVAILABLE) {
                scheduleRetry();
                return;
            }
            return;
        }
        this.currentState = connectivityState;
        this.currentNetworkTransport = networkTransportTypeCalculateNetworkTransport;
        fireNetworkChangeListeners(connectivityState, networkTransportTypeCalculateNetworkTransport);
        Log.verbose("Network connectivity changed. New connectivity state: " + connectivityState);
        if (this.currentState != ConnectivityState.CONNECTION_AVAILABLE) {
            scheduleRetry();
        } else {
            clearRetry();
        }
    }

    @Override // com.epicgames.unreal.network.NetworkConnectivityClient
    public boolean addListener(NetworkConnectivityClient.Listener listener) {
        return addListener(listener, false);
    }

    @Override // com.epicgames.unreal.network.NetworkConnectivityClient
    public void checkConnectivity() {
        checkNetworkConnectivity();
    }

    @Override // com.epicgames.unreal.network.NetworkConnectivityClient
    public void initNetworkCallback(@NonNull Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        this.connectivityManager = connectivityManager;
        if (connectivityManager == null) {
            Log.error("Unable to start connectivityManager");
            return;
        }
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(1);
        builder.addTransportType(3);
        builder.addTransportType(4);
        builder.addTransportType(0);
        builder.addTransportType(2);
        if (i >= 23) {
            builder.addCapability(16);
        }
        this.connectivityManager.registerNetworkCallback(builder.build(), this.connectivityListener);
    }

    @Override // com.epicgames.unreal.network.NetworkConnectivityClient
    public boolean removeListener(NetworkConnectivityClient.Listener listener) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        Iterator<WeakReference<NetworkConnectivityClient.Listener>> it = this.networkChangedListeners.iterator();
        while (it.hasNext()) {
            if (it.next().get() == listener) {
                it.remove();
                return true;
            }
        }
        if (this.networkChangedListeners.size() == 0) {
            clearRetry();
        }
        return false;
    }

    @Override // com.epicgames.unreal.network.NetworkConnectivityClient
    public boolean addListener(NetworkConnectivityClient.Listener listener, boolean z) {
        ConnectivityState connectivityState;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        Iterator<WeakReference<NetworkConnectivityClient.Listener>> it = this.networkChangedListeners.iterator();
        while (it.hasNext()) {
            if (it.next().get() == listener) {
                return false;
            }
        }
        this.networkChangedListeners.add(new WeakReference<>(listener));
        if (this.networkChangedListeners.size() == 1) {
            checkNetworkConnectivity();
        }
        if (z && (connectivityState = this.currentState) != null) {
            fireNetworkChangeListenerInternal(listener, connectivityState, this.currentNetworkTransport);
        }
        return true;
    }
}
