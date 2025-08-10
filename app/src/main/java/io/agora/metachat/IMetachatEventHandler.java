package io.agora.metachat;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IMetachatEventHandler {

    public static class ConnectionChangedReason {
        public static final int METACHAT_CONNECTION_CHANGED_DEFAULT = 0;

        private ConnectionChangedReason() {
        }
    }

    public static class ConnectionState {
        public static final int METACHAT_CONNECTION_STATE_ABORTED = 5;
        public static final int METACHAT_CONNECTION_STATE_CONNECTED = 3;
        public static final int METACHAT_CONNECTION_STATE_CONNECTING = 2;
        public static final int METACHAT_CONNECTION_STATE_DISCONNECTED = 1;
        public static final int METACHAT_CONNECTION_STATE_RECONNECTING = 4;

        private ConnectionState() {
        }
    }

    public static class SceneDownloadState {
        public static final int METACHAT_SCENE_DOWNLOAD_STATE_DOWNLOADED = 2;
        public static final int METACHAT_SCENE_DOWNLOAD_STATE_DOWNLOADING = 1;
        public static final int METACHAT_SCENE_DOWNLOAD_STATE_FAILED = 3;
        public static final int METACHAT_SCENE_DOWNLOAD_STATE_IDLE = 0;

        private SceneDownloadState() {
        }
    }

    @CalledByNative
    void onConnectionStateChanged(int i, int i2);

    @CalledByNative
    void onCreateSceneResult(IMetachatScene iMetachatScene, int i);

    @CalledByNative
    void onDownloadSceneProgress(long j, int i, int i2);

    @CalledByNative
    void onGetSceneInfosResult(MetachatSceneInfo[] metachatSceneInfoArr, int i);

    @CalledByNative
    void onRequestToken();
}
