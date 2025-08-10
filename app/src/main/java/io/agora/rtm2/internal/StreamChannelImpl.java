package io.agora.rtm2.internal;

import android.text.TextUtils;
import io.agora.rtm2.JoinChannelOptions;
import io.agora.rtm2.JoinTopicOptions;
import io.agora.rtm2.StreamChannel;
import io.agora.rtm2.TopicOptions;
import io.agora.rtm2.UserList;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class StreamChannelImpl extends StreamChannel {
    private static final String TAG = "StreamChannelImpl";
    private long mChannelNative;
    private RtmClientImpl mRtmClient;

    public StreamChannelImpl(long j) {
        this.mChannelNative = 0L;
        this.mChannelNative = j;
    }

    private synchronized void detach() {
        RtmClientImpl rtmClientImpl = this.mRtmClient;
        if (rtmClientImpl != null) {
            rtmClientImpl.removeChannel(this);
            this.mRtmClient = null;
        }
    }

    private static native int nativeDestroy(long j);

    private native String nativeGetChannelName(long j);

    private native int nativeGetSubscribedUserList(long j, String str, UserList userList);

    private native int nativeJoin(long j, JoinChannelOptions joinChannelOptions);

    private native int nativeJoinTopic(long j, String str, JoinTopicOptions joinTopicOptions);

    private native int nativeLeave(long j);

    private native int nativeLeaveTopic(long j, String str);

    private native int nativePublishTopicMessage(long j, String str, byte[] bArr);

    private native int nativeSubscribeTopic(long j, String str, ArrayList<String> arrayList);

    private native int nativeUnsubscribeTopic(long j, String str, ArrayList<String> arrayList);

    public synchronized void attach(RtmClientImpl rtmClientImpl) {
        this.mRtmClient = rtmClientImpl;
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized String getChannelName() {
        long j = this.mChannelNative;
        if (j == 0) {
            return "";
        }
        return nativeGetChannelName(j);
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized int getSubscribedUserList(String str, UserList userList) {
        int i;
        if (this.mChannelNative == 0) {
            i = -7;
        } else if (str == null || TextUtils.isEmpty(str)) {
            i = -10003;
        } else {
            if (userList != null) {
                return nativeGetSubscribedUserList(this.mChannelNative, str, userList);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized int join(JoinChannelOptions joinChannelOptions) {
        int i;
        String str;
        if (this.mChannelNative == 0) {
            i = -7;
        } else {
            if (joinChannelOptions != null && (str = joinChannelOptions.token) != null && !TextUtils.isEmpty(str)) {
                return nativeJoin(this.mChannelNative, joinChannelOptions);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized int joinTopic(String str, JoinTopicOptions joinTopicOptions) {
        int i;
        if (this.mChannelNative == 0) {
            i = -7;
        } else {
            if (str != null && !TextUtils.isEmpty(str)) {
                return nativeJoinTopic(this.mChannelNative, str, joinTopicOptions);
            }
            i = -10003;
        }
        return i;
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized int leave() {
        long j = this.mChannelNative;
        if (j == 0) {
            return -7;
        }
        return nativeLeave(j);
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized int leaveTopic(String str) {
        int i;
        if (this.mChannelNative == 0) {
            i = -7;
        } else {
            if (str != null && !TextUtils.isEmpty(str)) {
                return nativeLeaveTopic(this.mChannelNative, str);
            }
            i = -10003;
        }
        return i;
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized int publishTopicMessage(String str, byte[] bArr) {
        int i;
        if (this.mChannelNative == 0) {
            i = -7;
        } else if (str == null || TextUtils.isEmpty(str)) {
            i = -10003;
        } else {
            if (bArr != null) {
                return nativePublishTopicMessage(this.mChannelNative, str, bArr);
            }
            i = -2;
        }
        return i;
    }

    @Override // io.agora.rtm2.StreamChannel
    public int release() {
        if (this.mChannelNative == 0) {
            return -7;
        }
        detach();
        int iNativeDestroy = nativeDestroy(this.mChannelNative);
        this.mChannelNative = 0L;
        return iNativeDestroy;
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized int subscribeTopic(String str, TopicOptions topicOptions) {
        int i;
        if (this.mChannelNative == 0) {
            i = -7;
        } else {
            if (str != null && !TextUtils.isEmpty(str)) {
                return nativeSubscribeTopic(this.mChannelNative, str, topicOptions.users);
            }
            i = -10003;
        }
        return i;
    }

    @Override // io.agora.rtm2.StreamChannel
    public synchronized int unsubscribeTopic(String str, TopicOptions topicOptions) {
        int i;
        if (this.mChannelNative == 0) {
            i = -7;
        } else {
            if (str != null && !TextUtils.isEmpty(str)) {
                return nativeUnsubscribeTopic(this.mChannelNative, str, topicOptions.users);
            }
            i = -10003;
        }
        return i;
    }
}
