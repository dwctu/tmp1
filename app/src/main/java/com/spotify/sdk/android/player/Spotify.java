package com.spotify.sdk.android.player;

import com.spotify.sdk.android.player.SpotifyPlayer;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Spotify {
    private static final int SLEEP_TIMEOUT_MS = 10;
    private static final int WAIT_COUNTER = 300;
    private static SpotifyPlayer sPlayer;
    private static final Object sPlayerMutex = new Object();
    private static final Set<Object> sPlayerReferences = Collections.newSetFromMap(new IdentityHashMap());

    private Spotify() {
    }

    public static boolean awaitDestroyPlayer(Object obj, long j, TimeUnit timeUnit) throws InterruptedException {
        synchronized (sPlayerMutex) {
            removePlayerReference(obj);
            if (!sPlayerReferences.isEmpty()) {
                return false;
            }
            SpotifyPlayer spotifyPlayer = sPlayer;
            if (spotifyPlayer == null) {
                return true;
            }
            spotifyPlayer.shutdown();
            boolean zAwaitTermination = sPlayer.awaitTermination(j, timeUnit);
            if (zAwaitTermination) {
                sPlayer = null;
            }
            return zAwaitTermination;
        }
    }

    public static void destroyPlayer(Object obj) {
        SpotifyPlayer spotifyPlayer;
        synchronized (sPlayerMutex) {
            removePlayerReference(obj);
            if (sPlayerReferences.isEmpty() && (spotifyPlayer = sPlayer) != null) {
                spotifyPlayer.shutdown();
                sPlayer = null;
            }
        }
    }

    public static SpotifyPlayer getPlayer(Config config, Object obj, SpotifyPlayer.InitializationObserver initializationObserver) {
        if (config != null) {
            return getPlayer(new SpotifyPlayer.Builder(config), obj, initializationObserver);
        }
        throw new IllegalArgumentException("Config can't be null");
    }

    public static int getReferenceCount() {
        int size;
        synchronized (sPlayerMutex) {
            size = sPlayerReferences.size();
        }
        return size;
    }

    private static void removePlayerReference(Object obj) {
        synchronized (sPlayerMutex) {
            SpotifyPlayer spotifyPlayer = sPlayer;
            if (spotifyPlayer != null && (obj instanceof ConnectionStateCallback)) {
                spotifyPlayer.removeConnectionStateCallback((ConnectionStateCallback) obj);
            }
            Set<Object> set = sPlayerReferences;
            if (set.contains(obj)) {
                set.remove(obj);
            }
        }
    }

    public static SpotifyPlayer getPlayer(SpotifyPlayer.Builder builder, Object obj, SpotifyPlayer.InitializationObserver initializationObserver) {
        SpotifyPlayer spotifyPlayer;
        if (obj == null) {
            throw new IllegalArgumentException("Player cannot have a null owner");
        }
        if (builder != null) {
            synchronized (sPlayerMutex) {
                SpotifyPlayer spotifyPlayer2 = sPlayer;
                if (spotifyPlayer2 == null) {
                    sPlayer = builder.build(initializationObserver);
                } else {
                    if (!spotifyPlayer2.isShutdown()) {
                        int i = WAIT_COUNTER;
                        while (!sPlayer.isInitialized() && i > 0) {
                            i--;
                            try {
                                Thread.sleep(10L);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    if (initializationObserver != null) {
                        if (sPlayer.isInitialized()) {
                            initializationObserver.onInitialized(sPlayer);
                        } else if (sPlayer.isShutdown()) {
                            initializationObserver.onError(new PlayerInitializationException("Player already shut down"));
                        } else {
                            initializationObserver.onError(new PlayerInitializationException("Player initialization failed"));
                        }
                    }
                }
                sPlayerReferences.add(obj);
                spotifyPlayer = sPlayer;
            }
            return spotifyPlayer;
        }
        throw new IllegalArgumentException("Builder can't be null");
    }
}
