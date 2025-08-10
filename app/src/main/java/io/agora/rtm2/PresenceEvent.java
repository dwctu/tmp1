package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;
import io.agora.rtm2.RtmConstants;

/* loaded from: classes4.dex */
public class PresenceEvent {
    public String channelName;
    public RtmConstants.RtmChannelType channelType;
    public RtmConstants.RtmPresenceType presenceType;
    public TopicInfo[] topicInfos;
    public String userId;

    public PresenceEvent() {
        this.channelType = RtmConstants.RtmChannelType.RTM_CHANNEL_TYPE_STREAM;
        this.presenceType = RtmConstants.RtmPresenceType.RTM_PRESENCE_TYPE_REMOTE_JOIN_CHANNEL;
        this.channelName = "";
        this.topicInfos = null;
        this.userId = "";
    }

    @CalledByNative
    public PresenceEvent(int i, int i2, String str, TopicInfo[] topicInfoArr, String str2) {
        this.channelType = RtmConstants.RtmChannelType.values()[i];
        this.presenceType = RtmConstants.RtmPresenceType.values()[i2];
        this.channelName = str;
        this.topicInfos = topicInfoArr;
        this.userId = str2;
    }

    @CalledByNative
    public void setChannelName(String str) {
        this.channelName = str;
    }

    @CalledByNative
    public void setChannelType(int i) {
        this.channelType = RtmConstants.RtmChannelType.values()[i];
    }

    @CalledByNative
    public void setPresenceType(int i) {
        this.presenceType = RtmConstants.RtmPresenceType.values()[i];
    }

    @CalledByNative
    public void setUserId(String str) {
        this.userId = str;
    }
}
