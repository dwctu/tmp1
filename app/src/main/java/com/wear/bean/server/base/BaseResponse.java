package com.wear.bean.server.base;

import dc.m32;
import dc.qf2;

/* loaded from: classes3.dex */
public abstract class BaseResponse<T> implements m32 {
    public T data;
    public String type;

    @Override // dc.m32
    public abstract /* synthetic */ void handler(String str, qf2 qf2Var, Object obj);
}
