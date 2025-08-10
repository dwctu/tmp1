package com.wear.bean.handlerbean.base;

import com.wear.bean.handlerbean.IGroupMember;

/* loaded from: classes3.dex */
public class SimpleGroupMember implements IGroupMember {
    @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    public String getAvatar() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IGroupPeopleInfo
    public long getEnterTime() {
        return 0L;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IPeopleInfo
    public String getId() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember
    public String getNickName() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IItemType
    public int getTempViewType() {
        return 0;
    }

    @Override // com.wear.bean.handlerbean.IGroupPeopleInfo, com.wear.bean.handlerbean.IPeopleInfo
    public String getUserName() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IGroupPeopleInfo
    public boolean isAdmin() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember, com.wear.bean.handlerbean.IGroupPeopleInfo
    public boolean isOwrn() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IGroupMember
    public void setPermission(int i) {
    }
}
