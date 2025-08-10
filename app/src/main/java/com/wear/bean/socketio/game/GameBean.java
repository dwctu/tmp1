package com.wear.bean.socketio.game;

import com.alibaba.fastjson.annotation.JSONField;
import dc.pf2;

/* loaded from: classes3.dex */
public abstract class GameBean implements pf2 {
    @Override // dc.pf2
    @JSONField(serialize = false)
    public abstract /* synthetic */ String getAction();
}
