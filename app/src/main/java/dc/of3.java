package dc;

import android.os.Build;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.messaging.Constants;
import com.j256.ormlite.misc.TransactionManager;
import com.wear.activity.orgySetting.JoinType;
import com.wear.activity.orgySetting.OrgyActivityBean;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.bean.OrgyLogBean;
import com.wear.dao.DaoUtils;
import com.wear.dao.DatabaseHelper;
import com.wear.dao.OrgyLogDao;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.ye3;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Callable;

/* compiled from: OrgyLogUtil.java */
/* loaded from: classes4.dex */
public class of3 {
    public static of3 d;
    public String a;
    public int b = 0;
    public TransactionManager c;

    /* compiled from: OrgyLogUtil.java */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            of3.this.m();
        }
    }

    /* compiled from: OrgyLogUtil.java */
    public class b implements ye3.g {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        @Override // dc.ye3.g
        public void a() {
            of3.this.g(this.a);
        }

        @Override // dc.ye3.g
        public void error() {
        }
    }

    /* compiled from: OrgyLogUtil.java */
    public class c implements zn2<String> {
        public final /* synthetic */ ye3.g a;

        public c(of3 of3Var, ye3.g gVar) {
            this.a = gVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                ye3.g gVar = this.a;
                if (gVar != null) {
                    gVar.error();
                    return;
                }
                return;
            }
            ye3.g gVar2 = this.a;
            if (gVar2 != null) {
                gVar2.a();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ye3.g gVar = this.a;
            if (gVar != null) {
                gVar.error();
            }
        }
    }

    public of3() {
        i();
    }

    public static of3 h() {
        if (d == null) {
            synchronized (of3.class) {
                if (d == null) {
                    d = new of3();
                }
            }
        }
        return d;
    }

    public static /* synthetic */ Boolean j(OrgyLogBean orgyLogBean) throws Exception {
        DaoUtils.getOrgyLogDao().add((OrgyLogDao) orgyLogBean);
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean k(List list) throws Exception {
        DaoUtils.getOrgyLogDao().delTs(list);
        return Boolean.TRUE;
    }

    public final void c(final OrgyLogBean orgyLogBean) {
        TransactionManager transactionManager = this.c;
        if (transactionManager == null) {
            DaoUtils.getOrgyLogDao().add((OrgyLogDao) orgyLogBean);
            return;
        }
        try {
            transactionManager.callInTransaction(new Callable() { // from class: dc.rc3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return of3.j(orgyLogBean);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("OrgyLogUtils addLog 异常：", e));
        }
    }

    public void d(String str) {
        OrgyActivityBean.StageListBean orgyStageBean = OrgySetting.getInstance().getOrgyStageBean();
        OrgyActivityBean orgys = OrgySetting.getInstance().getOrgys();
        if (orgys == null || orgyStageBean == null) {
            return;
        }
        f(str, orgys.getName(), orgyStageBean.getPhaseName(), orgyStageBean.getOrgyPhaseUrl(), orgyStageBean.getPhaseName(), str.equals("banner_view") ? (OrgySetting.getInstance().getJoinType() == JoinType.Yes || OrgySetting.getInstance().getJoinType() == JoinType.Cancel) ? "0" : "1" : null, orgys.getUserGroupId(), String.valueOf(orgys.getId()));
    }

    public void e(String str, OrgyActivityBean orgyActivityBean, OrgyActivityBean.StageListBean stageListBean) {
        f(str, orgyActivityBean.getName(), stageListBean.getPhaseName(), stageListBean.getOrgyPhaseUrl(), stageListBean.getPhaseName(), null, orgyActivityBean.getUserGroupId(), String.valueOf(orgyActivityBean.getId()));
    }

    public final synchronized void f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (WearUtils.e1(str)) {
            return;
        }
        OrgyLogBean orgyLogBean = new OrgyLogBean();
        orgyLogBean.setLocationTime(be3.i(be3.a, new Date()));
        orgyLogBean.setTimestamp(System.currentTimeMillis() + "");
        orgyLogBean.setEventId(str);
        orgyLogBean.setContent(str2);
        orgyLogBean.setStage(str3);
        orgyLogBean.setCampaignLink(str4);
        orgyLogBean.setPage(str5);
        orgyLogBean.setType(str6);
        orgyLogBean.setTargetLink(null);
        orgyLogBean.setPosition(str7);
        orgyLogBean.setActivityId(str8);
        String str9 = "addLog: " + WearUtils.A.toJson(orgyLogBean);
        c(orgyLogBean);
        int i = this.b + 1;
        this.b = i;
        if (i % 50 == 0) {
            if (WearUtils.x.j == 1) {
                m();
            } else {
                List<OrgyLogBean> listFindAll = DaoUtils.getOrgyLogDao().findAll();
                if (listFindAll != null && listFindAll.size() > 50) {
                    l(listFindAll, 50);
                }
            }
        }
        if (this.b >= 50000) {
            this.b = 0;
        }
    }

    public final void g(final List<OrgyLogBean> list) {
        TransactionManager transactionManager = this.c;
        if (transactionManager == null) {
            DaoUtils.getOrgyLogDao().delTs(list);
            return;
        }
        try {
            transactionManager.callInTransaction(new Callable() { // from class: dc.sc3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return of3.k(list);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("OrgyLogUtils delLogs 异常：", e));
        }
    }

    public final void i() {
        String strH = eg3.h(WearUtils.x, "log_session", "");
        this.a = strH;
        if (WearUtils.e1(strH)) {
            String string = UUID.randomUUID().toString();
            this.a = string;
            eg3.i(WearUtils.x, "log_session", string);
        }
        if (DatabaseHelper.getHelper() != null) {
            this.c = new TransactionManager(DatabaseHelper.getHelper().getConnectionSource());
        }
        o();
    }

    public final synchronized void l(List<OrgyLogBean> list, int i) {
        if (list != null) {
            int size = list.size();
            if (size <= i) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<OrgyLogBean> it = list.iterator();
            for (int i2 = 0; it.hasNext() && i2 < size - i; i2++) {
                arrayList.add(it.next());
                it.remove();
            }
            if (arrayList.size() > 0) {
                g(arrayList);
            }
        }
    }

    public final synchronized void m() {
        String firstLogActivityId;
        if (WearUtils.x.j != 1) {
            return;
        }
        try {
            firstLogActivityId = DaoUtils.getOrgyLogDao().getFirstLogActivityId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (WearUtils.e1(firstLogActivityId)) {
            return;
        }
        List<OrgyLogBean> listFindLogsByActivityId = DaoUtils.getOrgyLogDao().findLogsByActivityId(firstLogActivityId);
        if (listFindLogsByActivityId != null) {
            l(listFindLogsByActivityId, 50);
            n(firstLogActivityId, listFindLogsByActivityId, new b(listFindLogsByActivityId));
        }
    }

    public void n(String str, List<OrgyLogBean> list, ye3.g gVar) {
        if (WearUtils.g1(list)) {
            return;
        }
        if (WearUtils.e1(WearUtils.q)) {
            WearUtils.q = "";
        }
        HashMap map = new HashMap();
        map.put("appType", "remote");
        map.put("deviceId", this.a);
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        map.put("deviceBrand", Build.BRAND);
        map.put("deviceModel", Build.MODEL);
        map.put("version", WearUtils.q);
        map.put("language", lg3.b(WearUtils.x));
        map.put(Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, str);
        map.put("eventList", list);
        tn2.x(WearUtils.x).m("/activity/coll/marketingApp/event", WearUtils.A.toJson(map), new c(this, gVar));
    }

    public final void o() {
        new Timer().schedule(new a(), 5000L, 30000L);
    }
}
