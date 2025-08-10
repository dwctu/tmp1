package com.wear.bean.socketio.game;

/* loaded from: classes3.dex */
public class CreateServerResultBean extends GameBean {
    public String ip;
    public String wsport;
    public String wsurl;

    @Override // com.wear.bean.socketio.game.GameBean, dc.pf2
    public String getAction() {
        return "CreateServerResult";
    }
}
