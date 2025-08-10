package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;
import io.agora.rtm2.RtmConstants;

/* loaded from: classes4.dex */
public class JoinTopicOptions {
    public String topicMeta = "";
    public RtmConstants.RtmMessageQos messageQos = RtmConstants.RtmMessageQos.RTM_MESSAGE_QOS_UNORDERED;

    @CalledByNative
    public int getMessageQos() {
        return RtmConstants.RtmMessageQos.getValue(this.messageQos);
    }

    @CalledByNative
    public String getTopicMeta() {
        return this.topicMeta;
    }
}
