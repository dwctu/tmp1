package com.wear.activity.orgySetting;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.gms.common.internal.ImagesContract;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lovense.wear.R;
import com.wear.activity.orgySetting.OrgyActivityBean;
import com.wear.activity.orgySetting.OrgyJoinBean;
import com.wear.bean.EntryPoint;
import com.wear.bean.Orgy;
import com.wear.bean.Toy;
import com.wear.bean.socketio.date.request.AppToyBean;
import com.wear.bean.socketio.date.request.AppToyTsBean;
import com.wear.dao.DaoUtils;
import com.wear.dao.OrgyDao;
import com.wear.main.MainActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import dc.be3;
import dc.ch3;
import dc.db2;
import dc.eg3;
import dc.fk2;
import dc.lg3;
import dc.mk2;
import dc.nd3;
import dc.of3;
import dc.pc1;
import dc.pj3;
import dc.sg3;
import dc.tn2;
import dc.uf2;
import dc.xe3;
import dc.ye3;
import dc.zn2;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class OrgySetting {
    public static final int HOT_VIEW_ID = 2131362944;
    public static final int ONE_HOURE_MSEC = 86400000;
    public static final String ORGY_ACTIVITY_DATA_KEY = WearUtils.r0("orgy_activity_data");
    private static final String TAG = "OrgySetting";
    private static volatile OrgySetting instance;
    private boolean hadToastIfInPositionMode;
    private OrgyJsInterface orgyJsInterface;
    private OrgyActivityBean.StageListBean orgyStageBean;
    private OrgyActivityBean orgys;
    public Timer timer = null;
    public JoinType joinType = JoinType.No;
    public String activityId = "";
    public String joinId = "";
    private boolean isLoadingInfo = false;
    public boolean nowHideBanner = false;
    public int index = 0;

    /* renamed from: com.wear.activity.orgySetting.OrgySetting$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] $SwitchMap$com$wear$activity$orgySetting$JoinType;

        static {
            int[] iArr = new int[JoinType.values().length];
            $SwitchMap$com$wear$activity$orgySetting$JoinType = iArr;
            try {
                iArr[JoinType.No.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$wear$activity$orgySetting$JoinType[JoinType.Yes.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$wear$activity$orgySetting$JoinType[JoinType.Cancel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface OnGetOrgyActivityListener {
        void onGetOrgyActivity(OrgyActivityBean orgyActivityBean);

        void onGetOrgyActivityFail();
    }

    private OrgySetting() {
    }

    public static synchronized OrgySetting getInstance() {
        if (instance == null) {
            synchronized (OrgySetting.class) {
                if (instance == null) {
                    instance = new OrgySetting();
                }
            }
        }
        return instance;
    }

    private String getLang() {
        Locale localeE = lg3.e(WearUtils.x);
        String language = localeE.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return "en";
        }
        if (!"zh".equalsIgnoreCase(language)) {
            return language;
        }
        String lowerCase = localeE.getCountry().toLowerCase();
        return (lowerCase.equals("ch") || lowerCase.equals("cn")) ? language : "zh-tw";
    }

    private Map<String, String> getParameters(URL url) {
        HashMap map = new HashMap();
        String query = url.getQuery();
        if (query != null) {
            for (String str : query.split(ContainerUtils.FIELD_DELIMITER)) {
                int iIndexOf = str.indexOf("=");
                try {
                    map.put(URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8"), URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    private long getShowTime(OrgyActivityBean.StageListBean stageListBean, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return i == 0 ? (stageListBean.getBannerTitle().getStartTimestamp() <= 0 || stageListBean.getBannerTitle().getStartTimestamp() < jCurrentTimeMillis) ? stageListBean.getPhaseEndTime() : stageListBean.getBannerTitle().getStartTimestamp() : (stageListBean.getBannerTitle().getEndTimestamp() <= 0 || stageListBean.getBannerTitle().getEndTimestamp() < jCurrentTimeMillis) ? stageListBean.getPhaseEndTime() : stageListBean.getBannerTitle().getEndTimestamp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JoinType mapJoinType(String str) {
        JoinType joinTypeFromString = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                joinTypeFromString = JoinType.fromString(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joinTypeFromString == null ? JoinType.Yes : joinTypeFromString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toastIfInPositionMode(boolean z) {
        if ((z || !this.hadToastIfInPositionMode) && fk2.a.l()) {
            this.hadToastIfInPositionMode = true;
        }
    }

    private void updateHotViewByActivityId() {
        postHotDotEvent(isHasHotView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateJoinType(JoinType joinType) {
        this.joinType = joinType;
        if (this.orgys != null) {
            int i = AnonymousClass8.$SwitchMap$com$wear$activity$orgySetting$JoinType[joinType.ordinal()];
            if (i == 1) {
                this.orgys.setJoinStatus("no");
            } else if (i == 2) {
                this.orgys.setJoinStatus("yes");
                of3.h().d("banner_joined_enable");
            } else if (i == 3) {
                this.orgys.setJoinStatus("cancel");
                of3.h().d("banner_joined_disable");
            }
        }
        eg3.i(WearUtils.x, ORGY_ACTIVITY_DATA_KEY, nd3.u(WearUtils.A.toJson(this.orgys)));
    }

    public void addJavascriptInterface(OrgyJsInterface orgyJsInterface) {
        this.orgyJsInterface = orgyJsInterface;
    }

    public void cacheSetActivityId(String str) {
        this.activityId = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01d6 A[Catch: Exception -> 0x02ac, all -> 0x02b9, TryCatch #0 {Exception -> 0x02ac, blocks: (B:5:0x000a, B:7:0x000e, B:9:0x0023, B:97:0x0258, B:10:0x0047, B:13:0x005a, B:16:0x0063, B:19:0x0078, B:21:0x007d, B:23:0x0086, B:74:0x01c8, B:76:0x01d6, B:80:0x01e5, B:82:0x01f9, B:84:0x0207, B:86:0x020f, B:88:0x021b, B:89:0x0224, B:91:0x022c, B:93:0x023a, B:95:0x0246, B:26:0x00a7, B:29:0x00bc, B:49:0x00fc, B:52:0x0125, B:55:0x0138, B:61:0x0175, B:63:0x017d, B:66:0x018a, B:67:0x018e, B:58:0x0162, B:68:0x0192, B:71:0x01b4, B:36:0x00d6, B:39:0x00e0, B:42:0x00ea), top: B:106:0x000a, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void checkTimer() {
        /*
            Method dump skipped, instructions count: 700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.activity.orgySetting.OrgySetting.checkTimer():void");
    }

    public String concatenateURL(String str, String str2, String str3, EntryPoint entryPoint) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = "start concatenateURL: " + str;
        StringBuilder sb = new StringBuilder();
        try {
            Map<String, String> parameters = getParameters(new URL(str));
            if (!parameters.containsKey("appType")) {
                sb.append("&appType=remote");
            }
            if (!parameters.containsKey("gtoken") && !TextUtils.isEmpty(WearUtils.s)) {
                sb.append("&gtoken=");
                sb.append(nd3.i(WearUtils.s));
            }
            if (!parameters.containsKey("lang")) {
                sb.append("&lang=");
                sb.append(getLang());
            }
            if (!parameters.containsKey("joinId") && !TextUtils.isEmpty(str2)) {
                sb.append("&joinId=");
                sb.append(str2);
            }
            if (!parameters.containsKey("apv")) {
                sb.append("&apv=");
                sb.append(WearUtils.q);
            }
            if (!parameters.containsKey("_utm_av") && !TextUtils.isEmpty(str3)) {
                sb.append("&_utm_av=");
                sb.append(str3);
            }
            if (!parameters.containsKey("_utm_pro") && entryPoint != null) {
                sb.append("&_utm_pro=");
                sb.append(entryPoint.getValue());
            }
            if (!parameters.containsKey("_utm_ap")) {
                sb.append("&_utm_ap=");
                sb.append("remote");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sb.length() > 0) {
            if (!str.contains("?")) {
                sb.replace(0, 1, "?");
            }
            str = str + sb.toString();
        }
        String str5 = "end concatenateURL: " + str;
        return str;
    }

    public void endTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
    }

    public String getActitivtyId() {
        return this.activityId;
    }

    public OrgyActivityBean.StageListBean getCurrentOrgyStageBean() {
        OrgyActivityBean orgyActivityBean = this.orgys;
        if (orgyActivityBean != null && orgyActivityBean.getStageList() != null && !this.orgys.getStageList().isEmpty()) {
            for (int i = 0; i < this.orgys.getStageList().size(); i++) {
                OrgyActivityBean.StageListBean stageListBean = this.orgys.getStageList().get(i);
                if (isBetween(stageListBean.getPhaseStartTime(), stageListBean.getPhaseEndTime())) {
                    return stageListBean;
                }
            }
        }
        return null;
    }

    public String getJoinId() {
        return this.joinId;
    }

    public JoinType getJoinType() {
        return this.joinType;
    }

    public OrgyActivityBean.StageListBean getOrgyStageBean() {
        return this.orgyStageBean;
    }

    public OrgyActivityBean getOrgys() {
        return this.orgys;
    }

    public int getSecondTime() {
        return 60 - ((int) ((System.currentTimeMillis() / 1000) % 60));
    }

    public boolean hasOrgys() {
        return !WearUtils.e1(this.activityId);
    }

    public void hiddenBannerShowType(boolean z) {
        if (z) {
            this.nowHideBanner = true;
        } else {
            OrgyUtil.updateShowBannerStatus(this.orgyStageBean, 0, this.activityId);
        }
        checkTimer();
    }

    public boolean isBetween(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = "orgySetting isBetween: " + jCurrentTimeMillis + "   " + j + "   " + j2;
        long j3 = jCurrentTimeMillis / 1000;
        if (j3 < j / 1000 || j3 > j2 / 1000) {
            return false;
        }
        if (jCurrentTimeMillis - j2 <= 0) {
            return true;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.wear.activity.orgySetting.OrgySetting.4
            @Override // java.lang.Runnable
            public void run() {
                String unused = OrgySetting.TAG;
                OrgySetting.this.checkTimer();
            }
        }, 1000L);
        return true;
    }

    public boolean isHasHotView() {
        OrgyActivityBean orgyActivityBean = this.orgys;
        boolean z = false;
        boolean z2 = orgyActivityBean != null && OrgyUtil.isBetween(orgyActivityBean.getStartTime(), this.orgys.getEndTime());
        OrgyActivityBean.StageListBean stageListBean = this.orgyStageBean;
        if (stageListBean != null && stageListBean.getFixedBtnEntrance() != 0) {
            z = z2;
        }
        if (ch3.n().u() == null || !z) {
            return z;
        }
        Orgy orgy = DaoUtils.getOrgyDao().getOrgy(ch3.n().r(), this.activityId);
        if (orgy == null) {
            return true;
        }
        return true ^ orgy.isShowHot();
    }

    public boolean isJoinIn() {
        return this.orgys != null && this.joinType == JoinType.Yes;
    }

    public void joinOrgyAction() {
        HashMap map = new HashMap();
        map.put("joinId", this.joinId);
        JoinType joinType = this.joinType;
        JoinType joinType2 = JoinType.Yes;
        map.put("status", joinType == joinType2 ? "0" : "1");
        tn2.x(WearUtils.x).l("/activity/api/orgy/joinStatusUpd", map, new zn2<String>() { // from class: com.wear.activity.orgySetting.OrgySetting.7
            @Override // dc.zn2
            public void onError(NetException netException) {
            }

            @Override // dc.zn2
            public void onSuccess(String str) {
                if (WearUtils.e1(str)) {
                    return;
                }
                NormalResponse normalResponse = null;
                try {
                    normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (normalResponse == null) {
                    return;
                }
                normalResponse.isResult();
            }
        });
        updateJoinType(this.joinType == joinType2 ? JoinType.Cancel : joinType2);
        checkTimer();
        if (this.joinType == JoinType.Cancel) {
            WearUtils.x.G().u0();
        }
        if (mk2.P().h0()) {
            mk2.P().n0(this.joinType == joinType2);
        }
    }

    public void joinOrgyActionByJs() {
        if (WearUtils.e1(db2.A().c)) {
            db2.A().c = String.valueOf(eg3.b(WearUtils.x, "control_uid_simple_key", ""));
        }
        String language = WearUtils.x.getResources().getConfiguration().locale.getLanguage();
        HashMap map = new HashMap();
        map.put("activityId", this.activityId);
        map.put("appType", "remote");
        map.put("uid", db2.A().c);
        map.put("lang", language);
        map.put("apv", ye3.s());
        map.put("socketOnDateServer", Boolean.TRUE);
        EventBus.getDefault().post(new OrgyReloadUrlEvent(1, null));
        tn2.x(WearUtils.x).l("/activity/api/orgy/joinOrgy", map, new zn2<String>() { // from class: com.wear.activity.orgySetting.OrgySetting.6
            @Override // dc.zn2
            public void onError(NetException netException) {
                EventBus.getDefault().post(new OrgyReloadUrlEvent(0, null));
            }

            @Override // dc.zn2
            public void onSuccess(String str) {
                xe3.a(OrgyUtil.TAG, "加入活动成功: " + str);
                EventBus.getDefault().post(new OrgyReloadUrlEvent(0, null));
                if (WearUtils.e1(str)) {
                    return;
                }
                try {
                    OrgyJoinBean orgyJoinBean = (OrgyJoinBean) WearUtils.A.fromJson(str, OrgyJoinBean.class);
                    if (orgyJoinBean == null) {
                        sg3.h(R.string.orgy_event_unable_join_notice);
                        return;
                    }
                    if (!orgyJoinBean.isResult().booleanValue()) {
                        if (orgyJoinBean.getCode().intValue() == 102) {
                            sg3.h(R.string.orgy_event_end_notice);
                            return;
                        } else if (orgyJoinBean.getCode().intValue() == 101) {
                            sg3.h(R.string.orgy_event_unable_join_notice);
                            return;
                        } else {
                            sg3.h(R.string.orgy_event_unable_join_notice);
                            return;
                        }
                    }
                    OrgyJoinBean.Data data = orgyJoinBean.getData();
                    if (data == null) {
                        sg3.h(R.string.orgy_event_unable_join_notice);
                        return;
                    }
                    OrgySetting.this.joinId = data.getJoinId();
                    if (WearUtils.e1(OrgySetting.this.joinId)) {
                        sg3.h(R.string.orgy_event_unable_join_notice);
                        return;
                    }
                    xe3.a(OrgyUtil.TAG, "活动加入成功！: joinId=" + OrgySetting.this.joinId);
                    OrgySetting.this.orgys.setJoinId(OrgySetting.this.joinId);
                    OrgySetting.this.orgys.setSocketOnDateServer(Boolean.TRUE);
                    OrgySetting orgySetting = OrgySetting.this;
                    orgySetting.updateJoinType(orgySetting.mapJoinType(data.getJoinStatus()));
                    OrgySetting.this.checkTimer();
                    if (OrgySetting.this.orgyJsInterface != null) {
                        OrgySetting orgySetting2 = OrgySetting.this;
                        OrgySetting.this.orgyJsInterface.callJsMethod(orgySetting2.concatenateURL(orgySetting2.orgyStageBean.getOrgyPhaseUrl(), OrgySetting.this.joinId, null, null));
                    }
                    if (mk2.P().h0()) {
                        mk2.P().n0(true);
                    }
                    OrgySetting orgySetting3 = OrgySetting.this;
                    orgySetting3.toastIfInPositionMode(orgySetting3.orgyJsInterface != null);
                } catch (Exception unused) {
                    sg3.h(R.string.orgy_event_unable_join_notice);
                }
            }
        });
    }

    public void loginOutRemoveData() {
        try {
            this.orgys = null;
            this.orgyStageBean = null;
            this.joinId = "";
            this.activityId = "";
            endTimer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void postHotDotEvent(boolean z) {
        EventBus.getDefault().post(new OrgyHotView(z));
    }

    public void pressedOrgyWeb() {
        Orgy orgy = DaoUtils.getOrgyDao().getOrgy(ch3.n().r(), this.activityId);
        if (orgy == null) {
            orgy = new Orgy(ch3.n().r(), this.activityId);
        }
        orgy.setShowHot(true);
        DaoUtils.getOrgyDao().updateOrAdd(orgy);
        showOrgyWebView();
        updateHotViewByActivityId();
    }

    public void removeOrgyJsInterface(OrgyJsInterface orgyJsInterface) {
        if (this.orgyJsInterface == orgyJsInterface) {
            this.orgyJsInterface = null;
        }
    }

    public void sendToyMessage() {
        ArrayList<Toy> arrayListO = pc1.a.o();
        ArrayList arrayList = new ArrayList();
        if (arrayListO != null && arrayListO.size() > 0) {
            for (Toy toy : arrayListO) {
                if (toy.isConnected()) {
                    AppToyBean appToyBean = new AppToyBean();
                    appToyBean.setBattery(toy.getBattery());
                    appToyBean.setFirmwareVersion(toy.getVersion().intValue());
                    appToyBean.setToyName(toy.getName());
                    appToyBean.setToyType(toy.getType());
                    appToyBean.setToyVersion(toy.getGenerationVersion());
                    appToyBean.setToyId(toy.getDeviceId());
                    arrayList.add(appToyBean);
                }
            }
        }
        AppToyTsBean appToyTsBean = new AppToyTsBean();
        String str = "sendToyMessage: " + arrayList.toString();
        appToyTsBean.setList(arrayList);
        uf2.v().E(appToyTsBean);
    }

    public void setOrgy(OrgyActivityBean orgyActivityBean) {
        String str;
        this.orgys = orgyActivityBean;
        endTimer();
        this.nowHideBanner = false;
        OrgyActivityBean orgyActivityBean2 = this.orgys;
        if (orgyActivityBean2 != null && orgyActivityBean2.getStageList() != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long startTime = this.orgys.getStartTime() - 300000;
            if (jCurrentTimeMillis < startTime) {
                long j = startTime - jCurrentTimeMillis;
                if (j < 86400000) {
                    xe3.a(OrgyUtil.TAG, "setOrgy 有活动数据 距离开始时间小于一天 大于 5分钟");
                    WearUtils.x.l.postDelayed(new Runnable() { // from class: com.wear.activity.orgySetting.OrgySetting.1
                        @Override // java.lang.Runnable
                        public void run() {
                            xe3.a(OrgyUtil.TAG, "setOrgy 活动开始前五分钟定时器开启！！！");
                            OrgySetting.this.syncOrgyActivity(null);
                        }
                    }, j);
                }
            }
            str = "";
            if (jCurrentTimeMillis > this.orgys.getEndTime() || jCurrentTimeMillis < startTime) {
                String str2 = OrgyUtil.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("setOrgy 有活动数据 ");
                sb.append(jCurrentTimeMillis > this.orgys.getEndTime() ? "当前时间已经超出活动结束时间" : "  ");
                sb.append("  ");
                sb.append(jCurrentTimeMillis < startTime ? "当前时间小于活动开始前五分钟" : "");
                xe3.a(str2, sb.toString());
                return;
            }
            if (!WearUtils.c1(Integer.valueOf(this.orgys.getId()))) {
                str = this.orgys.getId() + "";
            }
            this.activityId = str;
            Orgy orgy = DaoUtils.getOrgyDao().getOrgy(ch3.n().r(), this.activityId);
            DaoUtils.getOrgyDao().findAll();
            if (orgy == null) {
                DaoUtils.getOrgyDao().add((OrgyDao) new Orgy(ch3.n().r(), this.activityId));
            }
            Timer timer = new Timer();
            this.timer = timer;
            timer.schedule(new TimerTask() { // from class: com.wear.activity.orgySetting.OrgySetting.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    OrgySetting orgySetting = OrgySetting.this;
                    int i = orgySetting.index;
                    if (i == 3) {
                        OrgySetting.this.checkTimer();
                        OrgySetting.this.index = 0;
                    } else {
                        orgySetting.index = i + 1;
                    }
                    if (OrgySetting.this.isJoinIn()) {
                        OrgySetting.this.sendToyMessage();
                    }
                    String str3 = "run: orgySetting" + be3.m(be3.e);
                }
            }, getSecondTime() * 1000, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.wear.activity.orgySetting.OrgySetting.3
                @Override // java.lang.Runnable
                public void run() {
                    OrgySetting.this.checkTimer();
                    if (MyApplication.H() instanceof MainActivity) {
                        of3.h().d("banner_view");
                    }
                }
            }, 1000L);
        }
        updateHotViewByActivityId();
    }

    public void setOrgyStageBean(OrgyActivityBean.StageListBean stageListBean) {
        this.orgyStageBean = stageListBean;
    }

    public void setOrgys(OrgyActivityBean orgyActivityBean) {
        this.orgys = orgyActivityBean;
    }

    public void showOrgyWebView() {
        OrgyActivityBean.StageListBean stageListBean;
        MyApplication myApplication = WearUtils.x;
        Context contextH = MyApplication.H();
        if (contextH == null) {
            contextH = WearUtils.x.M();
        }
        if (contextH == null || this.orgys == null || (stageListBean = this.orgyStageBean) == null || stageListBean.getOrgyPhaseMark() != 1 || WearUtils.e1(this.orgyStageBean.getOrgyPhaseUrl())) {
            return;
        }
        String eventTrack = OrgyEventTrackUtil.getEventTrack("12", this.activityId, this.orgys.getUserGroupId());
        JoinType joinType = this.joinType;
        String strConcatenateURL = (joinType == JoinType.No || joinType == JoinType.NoWay) ? concatenateURL(this.orgyStageBean.getOrgyPhaseUrl(), null, eventTrack, EntryPoint.Banner) : concatenateURL(this.orgyStageBean.getOrgyPhaseUrl(), this.joinId, eventTrack, EntryPoint.Banner);
        if (this.orgys.getOpenType().equals("1")) {
            pj3.w(contextH, strConcatenateURL);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MessageBundle.TITLE_ENTRY, this.orgys.getName());
        bundle.putString(ImagesContract.URL, strConcatenateURL);
        pj3.g(contextH, OrgyWebViewActivity.class, bundle);
    }

    public void syncOrgyActivity(final OnGetOrgyActivityListener onGetOrgyActivityListener) {
        if (this.isLoadingInfo) {
            return;
        }
        this.isLoadingInfo = true;
        this.orgys = null;
        this.orgyStageBean = null;
        this.joinId = "";
        this.activityId = "";
        endTimer();
        if (WearUtils.e1(db2.A().c)) {
            db2.A().c = String.valueOf(eg3.b(WearUtils.x, "control_uid_simple_key", ""));
        }
        HashMap map = new HashMap();
        map.put("appType", "remote");
        map.put("uid", db2.A().c);
        map.put("lang", getLang());
        map.put("apv", ye3.s());
        tn2.x(WearUtils.x).l("/activity/api/orgy/orgyActivitys", map, new zn2<String>() { // from class: com.wear.activity.orgySetting.OrgySetting.5
            @Override // dc.zn2
            public void onError(NetException netException) {
                OrgySetting.this.isLoadingInfo = false;
                OnGetOrgyActivityListener onGetOrgyActivityListener2 = onGetOrgyActivityListener;
                if (onGetOrgyActivityListener2 != null) {
                    onGetOrgyActivityListener2.onGetOrgyActivityFail();
                }
            }

            @Override // dc.zn2
            public void onSuccess(String str) {
                OrgyActivityBean data;
                OrgySetting.this.isLoadingInfo = false;
                xe3.a(OrgyUtil.TAG, "活动接口获取成功: " + str);
                if (!WearUtils.e1(str)) {
                    try {
                        OrgyBean orgyBean = (OrgyBean) WearUtils.A.fromJson(str, OrgyBean.class);
                        if (orgyBean.isResult() && orgyBean.getData() != null && (data = orgyBean.getData()) != null && data.getStageList() != null && data.getStageList().size() > 0) {
                            OrgyUtil.getInstance().saveOrgyActivity(data);
                            OrgySetting.this.setOrgy(data);
                            OnGetOrgyActivityListener onGetOrgyActivityListener2 = onGetOrgyActivityListener;
                            if (onGetOrgyActivityListener2 != null) {
                                onGetOrgyActivityListener2.onGetOrgyActivity(data);
                                return;
                            }
                            return;
                        }
                        xe3.a(OrgyUtil.TAG, "活动数据错误！！！！ 清除本地存储数据！: ");
                        eg3.m(WearUtils.x, OrgySetting.ORGY_ACTIVITY_DATA_KEY);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                OnGetOrgyActivityListener onGetOrgyActivityListener3 = onGetOrgyActivityListener;
                if (onGetOrgyActivityListener3 != null) {
                    onGetOrgyActivityListener3.onGetOrgyActivityFail();
                }
            }
        });
    }
}
