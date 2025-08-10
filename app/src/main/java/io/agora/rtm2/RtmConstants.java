package io.agora.rtm2;

import io.agora.rtc2.Constants;

/* loaded from: classes4.dex */
public class RtmConstants extends Constants {
    public static final int RTM_ERR_ALREADY_JOIN_CHANNEL = 10008;
    public static final int RTM_ERR_EXCEED_CHANNEL_LIMITATION = 10007;
    public static final int RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION = 10002;
    public static final int RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION = 10005;
    public static final int RTM_ERR_EXCEED_USER_LIMITATION = 10006;
    public static final int RTM_ERR_INVALID_TOPIC_NAME = 10003;
    public static final int RTM_ERR_NOT_JOIN_CHANNEL = 10009;
    public static final int RTM_ERR_PUBLISH_TOPIC_MESSAGE_FAILED = 10004;
    public static final int RTM_ERR_TOPIC_ALREADY_JOINED = 10001;
    public static final int STREAM_CHANNEL_ERROR_EXCEED_LIMITATION = 1;
    public static final int STREAM_CHANNEL_ERROR_OK = 0;
    public static final int STREAM_CHANNEL_ERROR_USER_NOT_EXIST = 2;

    public enum RtmChannelType {
        RTM_CHANNEL_TYPE_MESSAGE(0),
        RTM_CHANNEL_TYPE_STREAM(1);

        private int value;

        RtmChannelType(int i) {
            this.value = i;
        }

        public static int getValue(RtmChannelType rtmChannelType) {
            return rtmChannelType != null ? rtmChannelType.value : RTM_CHANNEL_TYPE_STREAM.value;
        }
    }

    public enum RtmMessageQos {
        RTM_MESSAGE_QOS_UNORDERED(0),
        RTM_MESSAGE_QOS_ORDERED(1);

        private int value;

        RtmMessageQos(int i) {
            this.value = i;
        }

        public static int getValue(RtmMessageQos rtmMessageQos) {
            return rtmMessageQos != null ? rtmMessageQos.value : RTM_MESSAGE_QOS_UNORDERED.value;
        }
    }

    public enum RtmPresenceType {
        RTM_PRESENCE_TYPE_REMOTE_JOIN_CHANNEL(0),
        RTM_PRESENCE_TYPE_REMOTE_LEAVE_CHANNEL(1),
        RTM_PRESENCE_TYPE_REMOTE_CONNECTION_TIMEOUT(2),
        RTM_PRESENCE_TYPE_REMOTE_JOIN_TOPIC(3),
        RTM_PRESENCE_TYPE_REMOTE_LEAVE_TOPIC(4),
        RTM_PRESENCE_TYPE_SELF_JOIN_CHANNEL(5);

        private int value;

        RtmPresenceType(int i) {
            this.value = i;
        }

        public static int getValue(RtmPresenceType rtmPresenceType) {
            return rtmPresenceType != null ? rtmPresenceType.value : RTM_PRESENCE_TYPE_REMOTE_JOIN_CHANNEL.value;
        }
    }
}
