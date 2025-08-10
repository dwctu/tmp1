package com.spotify.sdk.android.player;

/* loaded from: classes3.dex */
public interface Player {

    public interface AudioDeliveredCallback {
        int onAudioDelivered(short[] sArr, int i, int i2, int i3);
    }

    public interface AudioFlushCallback {
        void onAudioFlush();
    }

    public interface NotificationCallback {
        void onPlaybackError(Error error);

        void onPlaybackEvent(PlayerEvent playerEvent);
    }

    public interface OperationCallback {
        void onError(Error error);

        void onSuccess();
    }

    boolean addConnectionStateCallback(ConnectionStateCallback connectionStateCallback);

    boolean addNotificationCallback(NotificationCallback notificationCallback);

    void destroy();

    Metadata getMetadata();

    PlaybackState getPlaybackState();

    void initialize(Config config);

    boolean login(String str);

    boolean logout();

    void pause(OperationCallback operationCallback);

    void playUri(OperationCallback operationCallback, String str, int i, int i2);

    void queue(OperationCallback operationCallback, String str);

    void refreshCache();

    boolean removeConnectionStateCallback(ConnectionStateCallback connectionStateCallback);

    boolean removeNotificationCallback(NotificationCallback notificationCallback);

    void resume(OperationCallback operationCallback);

    void seekToPosition(OperationCallback operationCallback, int i);

    void setConnectivityStatus(OperationCallback operationCallback, Connectivity connectivity);

    void setPlaybackBitrate(OperationCallback operationCallback, PlaybackBitrate playbackBitrate);

    void setRepeat(OperationCallback operationCallback, boolean z);

    void setShuffle(OperationCallback operationCallback, boolean z);

    void skipToNext(OperationCallback operationCallback);

    void skipToPrevious(OperationCallback operationCallback);
}
