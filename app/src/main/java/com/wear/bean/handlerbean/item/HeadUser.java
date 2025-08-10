package com.wear.bean.handlerbean.item;

import com.wear.bean.handlerbean.base.BaseUser;

/* loaded from: classes3.dex */
public class HeadUser extends BaseUser {
    public int type;

    public HeadUser(int i) {
        this.type = i;
    }

    @Override // com.wear.bean.handlerbean.base.BaseUser, com.wear.bean.handlerbean.IItemType
    public int getTempViewType() {
        return this.type;
    }
}
