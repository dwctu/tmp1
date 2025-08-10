package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IRtmEventHandler {

    public static class RtmConnectionState {
        public static final int RTM_CONNECTION_STATE_CONNECTED = 3;
        public static final int RTM_CONNECTION_STATE_CONNECTING = 2;
        public static final int RTM_CONNECTION_STATE_DISCONNECTED = 1;
        public static final int RTM_CONNECTION_STATE_FAILED = 5;
        public static final int RTM_CONNECTION_STATE_RECONNECTING = 4;

        private RtmConnectionState() {
        }
    }

    @CalledByNative
    void onConnectionStateChange(String str, int i, int i2);

    @CalledByNative
    void onJoinResult(String str, String str2, int i);

    @CalledByNative
    void onJoinTopicResult(String str, String str2, String str3, String str4, int i);

    @CalledByNative
    void onLeaveResult(String str, String str2, int i);

    @CalledByNative
    void onLeaveTopicResult(String str, String str2, String str3, String str4, int i);

    @CalledByNative
    void onMessageEvent(MessageEvent messageEvent);

    @CalledByNative
    void onPresenceEvent(PresenceEvent presenceEvent);

    @CalledByNative
    void onTopicSubscribed(String str, String str2, String str3, UserList userList, UserList userList2, int i);

    @CalledByNative
    void onTopicUnsubscribed(String str, String str2, String str3, UserList userList, UserList userList2, int i);
}
