package io.agora.rtm2;

import io.agora.base.internal.CalledByNative;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class UserList {
    public ArrayList<String> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    @CalledByNative
    public UserList(String[] strArr) {
        this.users = new ArrayList<>(Arrays.asList(strArr));
    }

    @CalledByNative
    public void setUsers(String[] strArr) {
        this.users = new ArrayList<>(Arrays.asList(strArr));
    }
}
