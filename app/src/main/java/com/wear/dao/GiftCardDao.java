package com.wear.dao;

import com.wear.bean.GiftCard;

/* loaded from: classes3.dex */
public class GiftCardDao extends BaseDao<GiftCard> {
    public void clear() {
        delTs(findAll());
    }
}
