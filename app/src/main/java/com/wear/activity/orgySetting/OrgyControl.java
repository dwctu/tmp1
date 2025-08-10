package com.wear.activity.orgySetting;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.activity.discord.DiscordControl;
import com.wear.bean.B64Common;
import com.wear.bean.Toy;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.discover.speedMode.SpeedModeControl;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.ui.home.sound.SoundPlayControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.db2;
import dc.fg2;
import dc.ll3;
import dc.my2;
import dc.na2;
import dc.qf3;
import dc.tf2;
import dc.ye3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class OrgyControl implements tf2 {
    private static final String ORGY_ACTIVITY_COMMAND = "activityCommand";
    private static OrgyControl instance = null;
    private static boolean isAddLog = false;
    public Handler handler = new Handler(Looper.getMainLooper());
    private long time = 0;
    public MyApplication application = WearUtils.x;

    private OrgyControl() {
    }

    private void addLog() {
    }

    public static OrgyControl getInstance() {
        if (instance == null) {
            synchronized (fg2.class) {
                if (instance == null) {
                    instance = new OrgyControl();
                }
            }
        }
        return instance;
    }

    @Override // dc.tf2
    public void connectSuc() {
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    public synchronized void responseCommonBase64(String str, int i) {
        if (OrgySetting.getInstance().isJoinIn() && !isAddLog) {
            ArrayList<Toy> arrayListP = WearUtils.x.G().P();
            if (arrayListP.size() <= 0) {
                return;
            }
            isAddLog = true;
            HashMap map = new HashMap();
            map.put("type", 2);
            ArrayList arrayList = new ArrayList();
            if (arrayListP.size() > 0) {
                Iterator<Toy> it = arrayListP.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getAddress());
                }
            }
            map.put("toy", WearUtils.A.toJson(arrayList));
            ye3.d("M0002", WearUtils.A.toJson(map));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.time > 60000) {
            ye3.d("M0070", str);
            this.time = jCurrentTimeMillis;
        }
        System.out.println("WsManager-----onMessage.command=" + str);
        B64Common b64Common = (B64Common) WearUtils.A.fromJson(str, B64Common.class);
        if (b64Common != null && !WearUtils.e1(b64Common.getCate())) {
            if (b64Common.getCate().equals(TtmlNode.ATTR_ID)) {
                HashMap<String, B64Common.IdBean> id = b64Common.getId();
                if (id != null) {
                    for (Map.Entry<String, B64Common.IdBean> entry : id.entrySet()) {
                        Toy toyR = WearUtils.x.G().R(entry.getKey());
                        if (toyR != null) {
                            entry.getValue().sendCommand(WearUtils.x, toyR, i);
                        }
                    }
                }
            } else if (b64Common.getCate().equals(TtmlNode.COMBINE_ALL) && b64Common.getAll() != null) {
                b64Common.getAll().sendCommand(WearUtils.x, i);
            }
        }
    }

    public void socketIoReportToyCommandDTO(String str) {
        if (qf3.a || PatternPlayManagerImpl.H || na2.m().i() || SoundPlayControl.M().a || SpeedModeControl.C().L() || ll3.E().K() || MusicControl.h0().u || db2.A().i || (MyApplication.H() instanceof RemoteControlActivity) || (MyApplication.H() instanceof RemoteMultiControlActivity)) {
            return;
        }
        if ((OrgySetting.getInstance().isJoinIn() || (DiscordControl.getInstance().isJoin() && !DiscordControl.getInstance().isTemporaryExit())) && !my2.i.a().getB()) {
            responseCommonBase64(str, 0);
        }
    }
}
