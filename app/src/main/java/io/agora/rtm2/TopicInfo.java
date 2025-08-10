package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class TopicInfo {
    public ArrayList<String> publisherMetas;
    public ArrayList<String> publisherUserIds;
    public String topicName;

    public TopicInfo(String str) {
        this.topicName = str;
        this.publisherUserIds = new ArrayList<>();
        this.publisherMetas = new ArrayList<>();
    }

    @CalledByNative
    public TopicInfo(String str, String[] strArr, String[] strArr2) {
        this.topicName = str;
        this.publisherUserIds = new ArrayList<>(Arrays.asList(strArr));
        this.publisherMetas = new ArrayList<>(Arrays.asList(strArr2));
    }

    @CalledByNative
    public void setTopicName(String str) {
        this.topicName = str;
    }
}
