package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityWishList extends DataEntityAbstract {
    private String msgId;
    private String wishListDesc;
    private String wishListName;
    private String wishListUrl;

    public EntityWishList() {
        setMsgId(WearUtils.E());
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.wishlist;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getWishListDesc() {
        return this.wishListDesc;
    }

    public String getWishListName() {
        return this.wishListName;
    }

    public String getWishListUrl() {
        return this.wishListUrl;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setWishListDesc(String str) {
        this.wishListDesc = str;
    }

    public void setWishListName(String str) {
        this.wishListName = str;
    }

    public void setWishListUrl(String str) {
        this.wishListUrl = str;
    }

    public EntityWishList(String str) {
        EntityWishList entityWishList = (EntityWishList) fromJsonToDecrypt(str, EntityWishList.class);
        this.wishListDesc = entityWishList.getWishListDesc();
        this.wishListUrl = entityWishList.getWishListUrl();
        this.wishListName = entityWishList.getWishListName();
        this.msgId = entityWishList.getMsgId();
    }
}
