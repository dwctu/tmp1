package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class TopicOptions {
    public ArrayList<String> users = new ArrayList<>();

    @CalledByNative
    public void setUsers(String[] strArr) {
        this.users = new ArrayList<>(Arrays.asList(strArr));
    }
}
