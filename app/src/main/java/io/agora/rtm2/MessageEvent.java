package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;
import io.agora.rtm2.RtmConstants;

/* loaded from: classes4.dex */
public class MessageEvent {
    public String channelName;
    public RtmConstants.RtmChannelType channelType;
    public byte[] message;
    public String publisher;
    public String topicName;

    public MessageEvent() {
        this.channelType = RtmConstants.RtmChannelType.RTM_CHANNEL_TYPE_STREAM;
        this.channelName = "";
        this.topicName = "";
        this.message = null;
        this.publisher = "";
    }

    @CalledByNative
    public MessageEvent(int i, String str, String str2, byte[] bArr, String str3) {
        this.channelType = RtmConstants.RtmChannelType.values()[i];
        this.channelName = str;
        this.topicName = str2;
        this.message = bArr;
        this.publisher = str3;
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
    public void setPublisher(String str) {
        this.publisher = str;
    }

    @CalledByNative
    public void setTopicName(String str) {
        this.topicName = str;
    }
}
