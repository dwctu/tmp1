package com.wear.bean.handlerbean;

/* loaded from: classes3.dex */
public interface HandlerUser {
    public static final int FRIEND_TYPE_CONTROL_LINK = 64;
    public static final int FRIEND_TYPE_DATING = 32;
    public static final int FRIEND_TYPE_DEFAULT = 1;
    public static final int FRIEND_TYPE_FRIEND_ADD = 4;
    public static final int FRIEND_TYPE_FRIEND_DELETE = 8;
    public static final int FRIEND_TYPE_I_ADD = 2;
    public static final int FRIEND_TYPE_STRANGER = 16;

    boolean addSendToMe();

    boolean canAutomaticAddFriend();

    boolean canSendMsg();

    boolean isDateIng();

    boolean isDeleteByFriend();

    boolean isFriend();

    boolean isShowInFriendsList();
}
