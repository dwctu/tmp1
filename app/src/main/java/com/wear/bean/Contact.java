package com.wear.bean;

import com.wear.bean.handlerbean.IContactInfo;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class Contact implements Serializable {
    private IContactInfo groupMember;
    private String mName;
    private int mType;

    public Contact(IContactInfo iContactInfo, String str, int i) {
        this.groupMember = iContactInfo;
        this.mName = str;
        this.mType = i;
    }

    public IContactInfo getGroupMember() {
        return this.groupMember;
    }

    public String getmName() {
        return this.mName;
    }

    public int getmType() {
        return this.mType;
    }
}
