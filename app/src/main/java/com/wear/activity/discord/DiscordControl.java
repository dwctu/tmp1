package com.wear.activity.discord;

import android.text.TextUtils;
import com.google.android.exoplayer2.offline.DownloadService;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.db2;
import dc.fk2;
import dc.mk2;
import dc.pc1;
import dc.ro2;
import dc.sg3;
import dc.tn2;
import dc.ye3;
import dc.yn2;
import dc.zn2;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class DiscordControl {
    private static final String TAG = "com.wear.activity.discord.DiscordControl";
    private static DiscordControl instance;
    private boolean hadToastIfInPositionMode = false;
    private boolean isJoin;
    private boolean isTemporaryExit;
    private String orderKey;

    private DiscordControl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLog(int i) {
        HashMap map = new HashMap();
        map.put(DownloadService.KEY_CONTENT_ID, this.orderKey);
        map.put("type", Integer.valueOf(i));
        ye3.d("M0003", WearUtils.A.toJson(map));
    }

    public static DiscordControl getInstance() {
        if (instance == null) {
            synchronized (DiscordControl.class) {
                if (instance == null) {
                    instance = new DiscordControl();
                }
            }
        }
        return instance;
    }

    private void joinActivity(final boolean z, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("orderKey", str);
        map.put("uid", db2.A().c);
        ArrayList arrayList = new ArrayList();
        ArrayList<Toy> arrayListP = pc1.a.P();
        if (arrayListP != null && !arrayListP.isEmpty()) {
            for (Toy toy : arrayListP) {
                ToyBean toyBean = new ToyBean();
                toyBean.setBattery(String.valueOf(toy.getBattery()));
                toyBean.setfVersion(String.valueOf(toy.getToyVersion()));
                toyBean.setId(toy.getDeviceId());
                toyBean.setIsControl(String.valueOf(toy.isConnected()));
                toyBean.setName(toy.getName());
                toyBean.setStatus(toy.getStatus() == 1 ? "true" : "false");
                toyBean.setType(toy.getType());
                arrayList.add(toyBean);
            }
        }
        map.put("toys", arrayList);
        tn2.x(WearUtils.x).h("/activity/discord/joinActivity", ro2.c(map), new yn2<BaseResponseBean>() { // from class: com.wear.activity.discord.DiscordControl.2
            @Override // dc.yn2
            public void onCompleted() {
            }

            @Override // dc.yn2, dc.zn2
            public void onError(NetException netException) {
                if (!TextUtils.equals("80002", netException.getCode())) {
                    sg3.l(netException.getMessage());
                } else {
                    sg3.l(ah4.e(R.string.discord_orgy_over));
                    EventBus.getDefault().post(new DiscordEvent(DiscordEvent.TYPE_ACTIVITY_OVER));
                }
            }

            @Override // dc.yn2
            public void onStart() {
            }

            @Override // dc.yn2, dc.zn2
            public void onSuccess(BaseResponseBean baseResponseBean) {
                if (baseResponseBean != null) {
                    if (!baseResponseBean.isResult()) {
                        sg3.l(baseResponseBean.getMessage());
                        return;
                    }
                    DiscordControl.this.orderKey = str;
                    DiscordControl.this.isJoin = true;
                    DiscordControl.this.isTemporaryExit = false;
                    DiscordJoinActivityBean discordJoinActivityBean = (DiscordJoinActivityBean) ro2.a(ro2.c(baseResponseBean.getData()), DiscordJoinActivityBean.class);
                    DiscordEvent discordEvent = new DiscordEvent(DiscordEvent.TYPE_JOIN_ACTIVITY);
                    discordEvent.setUrl(discordJoinActivityBean.getUrl());
                    EventBus.getDefault().post(discordEvent);
                    if (db2.A().b != null && !db2.A().b.l()) {
                        db2.A().b.j(false);
                    }
                    if (mk2.P().h0()) {
                        mk2.P().n0(true);
                    }
                    if ((z || !DiscordControl.this.hadToastIfInPositionMode) && fk2.a.l()) {
                        DiscordControl.this.hadToastIfInPositionMode = true;
                    }
                    DiscordControl.this.addLog(1);
                }
            }
        });
    }

    private void leaveActivity() {
        if (TextUtils.isEmpty(this.orderKey)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("orderKey", this.orderKey);
        map.put("uid", db2.A().c);
        tn2.x(WearUtils.x).l("/activity/discord/leaveActivity", map, new zn2<String>() { // from class: com.wear.activity.discord.DiscordControl.3
            @Override // dc.zn2
            public void onError(NetException netException) {
                sg3.l(netException.getMessage());
            }

            @Override // dc.zn2
            public void onSuccess(String str) {
                BaseResponseBean baseResponseBean = (BaseResponseBean) ro2.a(str, BaseResponseBean.class);
                if (baseResponseBean != null) {
                    if (!baseResponseBean.isResult()) {
                        sg3.l(baseResponseBean.getMessage());
                        return;
                    }
                    DiscordControl.this.isTemporaryExit = true;
                    EventBus.getDefault().post(new DiscordEvent(DiscordEvent.TYPE_LEAVE_ACTIVITY));
                    pc1.a.u0();
                    if (mk2.P().h0()) {
                        mk2.P().n0(false);
                    }
                    DiscordControl.this.addLog(2);
                }
            }
        });
    }

    public void getActivityStatus(final String str) {
        if (TextUtils.isEmpty(this.orderKey) && TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.orderKey;
        }
        HashMap map = new HashMap();
        map.put("orderKey", str);
        tn2.x(WearUtils.x).l("/activity/discord/activityStatus", map, new zn2<String>() { // from class: com.wear.activity.discord.DiscordControl.1
            @Override // dc.zn2
            public void onError(NetException netException) {
                DiscordEvent discordEvent = new DiscordEvent(DiscordEvent.TYPE_ACTIVITY_STATUS);
                discordEvent.setErrorMsg(netException.message);
                EventBus.getDefault().post(discordEvent);
            }

            @Override // dc.zn2
            public void onSuccess(String str2) {
                BaseResponseBean baseResponseBean = (BaseResponseBean) ro2.a(str2, BaseResponseBean.class);
                if (baseResponseBean != null) {
                    DiscordEvent discordEvent = new DiscordEvent(DiscordEvent.TYPE_ACTIVITY_STATUS);
                    if (baseResponseBean.isResult()) {
                        discordEvent.setStatus(((DiscordActivityBean) ro2.a(ro2.c(baseResponseBean.getData()), DiscordActivityBean.class)).getStatus());
                        discordEvent.setOrderKey(str);
                    } else {
                        discordEvent.setErrorMsg(baseResponseBean.getMessage());
                    }
                    EventBus.getDefault().post(discordEvent);
                }
            }
        });
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public boolean isJoin() {
        return this.isJoin;
    }

    public boolean isTemporaryExit() {
        return this.isTemporaryExit;
    }

    public void join(boolean z, boolean z2, String str) {
        if (!z2) {
            this.isJoin = z;
            this.orderKey = str;
        } else if (z) {
            joinActivity(true, str);
        } else {
            leaveActivity();
        }
    }

    public void temporaryExit(boolean z, boolean z2) {
        if (!z2) {
            this.isTemporaryExit = z;
        } else if (z) {
            leaveActivity();
        } else {
            joinActivity(false, this.orderKey);
        }
    }
}
