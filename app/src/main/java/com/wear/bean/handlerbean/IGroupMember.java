package com.wear.bean.handlerbean;

/* loaded from: classes3.dex */
public interface IGroupMember extends IItemType, IGroupPeopleInfo {
    String getAvatar();

    String getId();

    String getNickName();

    boolean isAdmin();

    boolean isOwrn();

    void setPermission(int i);
}
