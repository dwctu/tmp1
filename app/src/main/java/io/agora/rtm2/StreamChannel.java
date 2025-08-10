package io.agora.rtm2;

/* loaded from: classes4.dex */
public abstract class StreamChannel {
    public abstract String getChannelName();

    public abstract int getSubscribedUserList(String str, UserList userList);

    public abstract int join(JoinChannelOptions joinChannelOptions);

    public abstract int joinTopic(String str, JoinTopicOptions joinTopicOptions);

    public abstract int leave();

    public abstract int leaveTopic(String str);

    public abstract int publishTopicMessage(String str, byte[] bArr);

    public abstract int release();

    public abstract int subscribeTopic(String str, TopicOptions topicOptions);

    public abstract int unsubscribeTopic(String str, TopicOptions topicOptions);
}
