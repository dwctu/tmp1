package com.wear.bean.handlerbean.item;

import com.wear.bean.handlerbean.base.BaseUser;

/* loaded from: classes3.dex */
public class FootUser extends BaseUser {
    public int count;
    public int type;

    public FootUser(int i) {
        this.type = i;
    }

    public int getCount() {
        return this.count;
    }

    @Override // com.wear.bean.handlerbean.base.BaseUser, com.wear.bean.handlerbean.IItemType
    public int getTempViewType() {
        return this.type;
    }

    public int getType() {
        return this.type;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
