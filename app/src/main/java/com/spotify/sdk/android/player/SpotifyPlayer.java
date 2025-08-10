package com.spotify.sdk.android.player;

import android.os.Handler;
import android.os.Looper;
import com.spotify.sdk.android.player.Player;
import dc.ye1;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class SpotifyPlayer extends ye1 implements Player {
    public static final long CACHE_REFRESH_INTERVAL_IN_MS = 10000;
    private final AudioController mAudioController;
    private final ScheduledExecutorService mCacheExecutorService;
    private final Handler mHandler;
    private volatile boolean mIsLoggedIn;
    private volatile Metadata mMetadata;
    private volatile PlaybackState mPlaybackState;
    private Thread mPlayerThread;
    private final Object mInitializedMutex = new Object();
    private final Object mLoggedInMutex = new Object();
    private InitializationState mInitializationState = InitializationState.PENDING;
    private final ConcurrentLinkedQueue<Command> mRunBeforePump = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<Runnable> mRunAfterPump = new ConcurrentLinkedQueue<>();
    private final Set<ConnectionStateCallback> mConnectionStateCallbacks = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Set<Player.NotificationCallback> mNotificationCallbacks = Collections.newSetFromMap(new ConcurrentHashMap());
    private volatile boolean mShouldShutdown = false;

    public static class Builder {
        private AudioController mAudioController;
        private ScheduledExecutorService mCacheExecutor;
        private Config mConfig;
        private Handler mHandler;
        private Player mNativePlayer;

        public Builder(Config config) {
            if (config == null) {
                throw new IllegalArgumentException("Config can't be null");
            }
            this.mConfig = config;
        }

        public SpotifyPlayer build() {
            return build(null);
        }

        public Builder setAudioController(AudioController audioController) {
            this.mAudioController = audioController;
            return this;
        }

        public Builder setCacheExecutor(ScheduledExecutorService scheduledExecutorService) {
            this.mCacheExecutor = scheduledExecutorService;
            return this;
        }

        public Builder setCallbackHandler(Handler handler) {
            this.mHandler = handler;
            return this;
        }

        public Builder setNativePlayer(Player player) {
            this.mNativePlayer = player;
            return this;
        }

        public SpotifyPlayer build(InitializationObserver initializationObserver) {
            return SpotifyPlayer.create(this.mConfig, this.mNativePlayer, this.mAudioController, this.mHandler, initializationObserver, this.mCacheExecutor);
        }
    }

    public static abstract class Command implements Callable<Error> {
        private final Player.OperationCallback mOperationCallback;

        private Command(Player.OperationCallback operationCallback) {
            this.mOperationCallback = operationCallback;
        }
    }

    public interface InitializationObserver {
        void onError(Throwable th);

        void onInitialized(SpotifyPlayer spotifyPlayer);
    }

    public enum InitializationState {
        PENDING,
        TERMINATED,
        INITIALIZED
    }

    static {
        nativeInit();
    }

    private SpotifyPlayer(AudioController audioController, Handler handler, ScheduledExecutorService scheduledExecutorService) {
        this.mCacheExecutorService = scheduledExecutorService == null ? Executors.newSingleThreadScheduledExecutor() : scheduledExecutorService;
        this.mHandler = handler == null ? new Handler(Looper.getMainLooper()) : handler;
        this.mAudioController = audioController == null ? new AudioTrackController() : audioController;
    }

    public static SpotifyPlayer create(Config config) {
        return create(config, null, null, null, null, null);
    }

    private void executePostPump() {
        while (!this.mRunAfterPump.isEmpty()) {
            try {
                this.mRunAfterPump.poll().run();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void executePrePumpTasks() throws Exception {
        while (!this.mRunBeforePump.isEmpty()) {
            final Command commandPoll = this.mRunBeforePump.poll();
            final Error errorCall = Error.UNKNOWN;
            try {
                errorCall = commandPoll.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (commandPoll.mOperationCallback != null) {
                runAfterPumpOnHandler(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Error.kSpErrorOk == errorCall) {
                            commandPoll.mOperationCallback.onSuccess();
                        } else {
                            commandPoll.mOperationCallback.onError(errorCall);
                        }
                    }
                });
            }
        }
    }

    private native int nativeDestroy();

    private native Metadata nativeGetMetadata();

    private native PlaybackState nativeGetPlaybackState();

    private static void nativeInit() {
        System.loadLibrary("gnustl_shared");
        System.loadLibrary("spotify_embedded_shared");
        System.loadLibrary("spotify_sdk");
    }

    private native int nativeInitialize(Config config);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeLogin(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeLogout();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativePause();

    private native int nativePlayTrackList(String[] strArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativePlayUri(String str, int i, int i2);

    private native int nativePumpEvents();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeQueue(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeRefreshCache();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeResume();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSeekToPosition(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSetConnectivityStatus(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSetPlaybackBitrate(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSetRepeat(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSetShuffle(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSkipToNext();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSkipToPrevious();

    private void runAfterPump(Runnable runnable) {
        this.mRunAfterPump.add(runnable);
    }

    private void runAfterPumpOnHandler(final Runnable runnable) {
        this.mRunAfterPump.add(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.6
            @Override // java.lang.Runnable
            public void run() {
                SpotifyPlayer.this.mHandler.post(runnable);
            }
        });
    }

    private void runBeforePump(Command command) {
        this.mRunBeforePump.add(command);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRunLoop(Config config, final InitializationObserver initializationObserver) throws Exception {
        try {
            synchronized (this.mInitializedMutex) {
                nativeInitialize(config);
                this.mInitializationState = InitializationState.INITIALIZED;
                this.mShouldShutdown = false;
                this.mInitializedMutex.notifyAll();
                if (initializationObserver != null) {
                    this.mHandler.post(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.2
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (SpotifyPlayer.this.mInitializedMutex) {
                                if (SpotifyPlayer.this.isInitialized()) {
                                    initializationObserver.onInitialized(SpotifyPlayer.this);
                                } else {
                                    initializationObserver.onError(new PlayerInitializationException("Player already shut down"));
                                }
                            }
                        }
                    });
                }
            }
            nativeLogin(config.oauthToken);
            this.mCacheExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.4
                @Override // java.lang.Runnable
                public void run() {
                    SpotifyPlayer.this.nativeRefreshCache();
                }
            }, 10000L, 10000L, TimeUnit.MILLISECONDS);
            this.mAudioController.start();
            while (!this.mShouldShutdown) {
                executePrePumpTasks();
                nativePumpEvents();
                updateState();
                executePostPump();
                Thread.yield();
            }
            this.mAudioController.stop();
            nativeLogout();
            destroy();
            this.mCacheExecutorService.shutdown();
            this.mInitializationState = InitializationState.TERMINATED;
        } catch (Exception e) {
            this.mInitializationState = InitializationState.TERMINATED;
            if (initializationObserver != null) {
                this.mHandler.post(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.3
                    @Override // java.lang.Runnable
                    public void run() {
                        initializationObserver.onError(new PlayerInitializationException(e));
                    }
                });
            }
            synchronized (this.mInitializedMutex) {
                this.mInitializedMutex.notifyAll();
            }
        }
    }

    private void updateState() {
        this.mMetadata = nativeGetMetadata();
        this.mPlaybackState = nativeGetPlaybackState();
    }

    @Override // com.spotify.sdk.android.player.Player
    public boolean addConnectionStateCallback(ConnectionStateCallback connectionStateCallback) {
        return this.mConnectionStateCallbacks.add(connectionStateCallback);
    }

    @Override // com.spotify.sdk.android.player.Player
    public boolean addNotificationCallback(Player.NotificationCallback notificationCallback) {
        if (notificationCallback == null) {
            return false;
        }
        return this.mNotificationCallbacks.add(notificationCallback);
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        timeUnit.timedJoin(this.mPlayerThread, j);
        return isTerminated();
    }

    @Override // dc.ye1, com.spotify.sdk.android.player.Player
    public void destroy() {
        nativeDestroy();
    }

    @Override // com.spotify.sdk.android.player.Player
    public Metadata getMetadata() {
        return this.mMetadata;
    }

    @Override // com.spotify.sdk.android.player.Player
    public PlaybackState getPlaybackState() {
        return this.mPlaybackState;
    }

    @Override // com.spotify.sdk.android.player.Player
    public void initialize(Config config) {
        nativeInitialize(config);
    }

    public boolean isInitialized() {
        boolean z;
        synchronized (this.mInitializedMutex) {
            z = !isShutdown() && this.mInitializationState == InitializationState.INITIALIZED;
        }
        return z;
    }

    public boolean isLoggedIn() {
        boolean z;
        synchronized (this.mLoggedInMutex) {
            z = isInitialized() && this.mIsLoggedIn;
        }
        return z;
    }

    public boolean isShutdown() {
        boolean z;
        synchronized (this.mInitializedMutex) {
            z = this.mShouldShutdown;
        }
        return z;
    }

    public boolean isTerminated() {
        boolean z;
        synchronized (this.mInitializedMutex) {
            z = this.mInitializationState == InitializationState.TERMINATED;
        }
        return z;
    }

    @Override // com.spotify.sdk.android.player.Player
    public boolean login(final String str) {
        if (isLoggedIn()) {
            return false;
        }
        runBeforePump(new Command(null) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeLogin(str));
            }
        });
        return true;
    }

    @Override // com.spotify.sdk.android.player.Player
    public boolean logout() {
        if (!isLoggedIn()) {
            return false;
        }
        runBeforePump(new Command(null) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeLogout());
            }
        });
        return true;
    }

    public int onAudioDelivered(short[] sArr, int i, int i2, int i3) {
        return this.mAudioController.onAudioDataDelivered(sArr, i, i2, i3);
    }

    public void onAudioFlush() {
        this.mAudioController.onAudioFlush();
    }

    public void onConnectionMessage(final String str) {
        runAfterPump(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.13
            @Override // java.lang.Runnable
            public void run() {
                for (final ConnectionStateCallback connectionStateCallback : SpotifyPlayer.this.mConnectionStateCallbacks) {
                    SpotifyPlayer.this.mHandler.post(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            connectionStateCallback.onConnectionMessage(str);
                        }
                    });
                }
            }
        });
    }

    public void onErrorNotification(int i) {
        final Error errorFromNativeError = Error.fromNativeError(i);
        runAfterPumpOnHandler(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.26
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = SpotifyPlayer.this.mNotificationCallbacks.iterator();
                while (it.hasNext()) {
                    ((Player.NotificationCallback) it.next()).onPlaybackError(errorFromNativeError);
                }
            }
        });
    }

    public void onLoggedIn() {
        runAfterPump(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.9
            @Override // java.lang.Runnable
            public void run() {
                SpotifyPlayer.this.mIsLoggedIn = true;
                for (final ConnectionStateCallback connectionStateCallback : SpotifyPlayer.this.mConnectionStateCallbacks) {
                    SpotifyPlayer.this.mHandler.post(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            connectionStateCallback.onLoggedIn();
                        }
                    });
                }
            }
        });
    }

    public void onLoggedOut() {
        runAfterPump(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.10
            @Override // java.lang.Runnable
            public void run() {
                SpotifyPlayer.this.mIsLoggedIn = false;
                for (final ConnectionStateCallback connectionStateCallback : SpotifyPlayer.this.mConnectionStateCallbacks) {
                    SpotifyPlayer.this.mHandler.post(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            connectionStateCallback.onLoggedOut();
                        }
                    });
                }
            }
        });
    }

    public void onLoginFailed(final int i) {
        runAfterPump(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.11
            @Override // java.lang.Runnable
            public void run() {
                SpotifyPlayer.this.mIsLoggedIn = false;
                for (final ConnectionStateCallback connectionStateCallback : SpotifyPlayer.this.mConnectionStateCallbacks) {
                    SpotifyPlayer.this.mHandler.post(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            connectionStateCallback.onLoginFailed(Error.fromNativeError(i));
                        }
                    });
                }
            }
        });
    }

    public void onPlaybackNotificationEvent(int i) {
        final PlayerEvent playerEventFromNativeEvent = PlayerEvent.fromNativeEvent(i);
        runAfterPumpOnHandler(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.25
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = SpotifyPlayer.this.mNotificationCallbacks.iterator();
                while (it.hasNext()) {
                    ((Player.NotificationCallback) it.next()).onPlaybackEvent(playerEventFromNativeEvent);
                }
            }
        });
    }

    public void onTemporaryError() {
        runAfterPump(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.12
            @Override // java.lang.Runnable
            public void run() {
                for (final ConnectionStateCallback connectionStateCallback : SpotifyPlayer.this.mConnectionStateCallbacks) {
                    SpotifyPlayer.this.mHandler.post(new Runnable() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            connectionStateCallback.onTemporaryError();
                        }
                    });
                }
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void pause(Player.OperationCallback operationCallback) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                int iNativePause = SpotifyPlayer.this.nativePause();
                SpotifyPlayer.this.mAudioController.onAudioPaused();
                return Error.fromNativeError(iNativePause);
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void playUri(Player.OperationCallback operationCallback, final String str, final int i, final int i2) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativePlayUri(str, i, i2));
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void queue(Player.OperationCallback operationCallback, final String str) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeQueue(str));
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void refreshCache() {
        nativeRefreshCache();
    }

    @Override // com.spotify.sdk.android.player.Player
    public boolean removeConnectionStateCallback(ConnectionStateCallback connectionStateCallback) {
        return this.mConnectionStateCallbacks.remove(connectionStateCallback);
    }

    @Override // com.spotify.sdk.android.player.Player
    public boolean removeNotificationCallback(Player.NotificationCallback notificationCallback) {
        if (notificationCallback == null) {
            return false;
        }
        return this.mNotificationCallbacks.remove(notificationCallback);
    }

    @Override // com.spotify.sdk.android.player.Player
    public void resume(Player.OperationCallback operationCallback) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                int iNativeResume = SpotifyPlayer.this.nativeResume();
                SpotifyPlayer.this.mAudioController.onAudioResumed();
                return Error.fromNativeError(iNativeResume);
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void seekToPosition(Player.OperationCallback operationCallback, final int i) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeSeekToPosition(i));
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void setConnectivityStatus(Player.OperationCallback operationCallback, final Connectivity connectivity) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeSetConnectivityStatus(connectivity.getStatus()));
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void setPlaybackBitrate(Player.OperationCallback operationCallback, final PlaybackBitrate playbackBitrate) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeSetPlaybackBitrate(playbackBitrate.getValue()));
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void setRepeat(Player.OperationCallback operationCallback, final boolean z) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeSetRepeat(z));
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void setShuffle(Player.OperationCallback operationCallback, final boolean z) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeSetShuffle(z));
            }
        });
    }

    public void shutdown() {
        synchronized (this.mInitializedMutex) {
            if (this.mInitializationState == InitializationState.PENDING) {
                try {
                    this.mInitializedMutex.wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.mShouldShutdown = true;
            } else {
                this.mShouldShutdown = true;
            }
        }
    }

    @Override // com.spotify.sdk.android.player.Player
    public void skipToNext(Player.OperationCallback operationCallback) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeSkipToNext());
            }
        });
    }

    @Override // com.spotify.sdk.android.player.Player
    public void skipToPrevious(Player.OperationCallback operationCallback) {
        runBeforePump(new Command(operationCallback) { // from class: com.spotify.sdk.android.player.SpotifyPlayer.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Error call() {
                return Error.fromNativeError(SpotifyPlayer.this.nativeSkipToPrevious());
            }
        });
    }

    public static SpotifyPlayer create(Config config, InitializationObserver initializationObserver) {
        return create(config, null, null, null, initializationObserver, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SpotifyPlayer create(final Config config, Player player, AudioController audioController, Handler handler, final InitializationObserver initializationObserver, ScheduledExecutorService scheduledExecutorService) {
        if (config != null) {
            SpotifyPlayer spotifyPlayer = new SpotifyPlayer(audioController, handler, scheduledExecutorService);
            Thread thread = new Thread() { // from class: com.spotify.sdk.android.player.SpotifyPlayer.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Exception {
                    setName("SpotifyPlayerThread" + SpotifyPlayer.this.toString());
                    SpotifyPlayer.this.startRunLoop(config, initializationObserver);
                }
            };
            spotifyPlayer.mPlayerThread = thread;
            thread.start();
            return spotifyPlayer;
        }
        throw new IllegalArgumentException("Config can't be null");
    }
}
