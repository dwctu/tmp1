package dc;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.Alarm;
import com.wear.bean.AlarmListItems;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.AlarmListDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: AlarmTranslationListener.java */
/* loaded from: classes4.dex */
public class zt3 {
    public static boolean a = false;
    public static ArrayList<g> b = new ArrayList<>();
    public static ArrayList<g> c = new ArrayList<>();
    public static ArrayList<g> d = new ArrayList<>();
    public static int e = 2;
    public static int f = 3;
    public static int g = 4;
    public static int h = 5;
    public static String i = "#";
    public static String j = "alarm#";
    public static String k = "";
    public static String l = WearUtils.a;
    public static xg3 m = xg3.i();
    public static HashMap<String, String> n = new HashMap<>();

    /* compiled from: AlarmTranslationListener.java */
    public class a implements Runnable {

        /* compiled from: AlarmTranslationListener.java */
        /* renamed from: dc.zt3$a$a, reason: collision with other inner class name */
        public class RunnableC0237a implements Runnable {
            public RunnableC0237a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (zt3.d.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<g> it = zt3.d.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        Iterator<g> it2 = zt3.b.iterator();
                        while (it2.hasNext()) {
                            g next2 = it2.next();
                            if (next.a().equals(next2.a())) {
                                arrayList.add(next2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            zt3.b.remove((g) it3.next());
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator<g> it4 = zt3.b.iterator();
                while (it4.hasNext()) {
                    g next3 = it4.next();
                    arrayList2.add(next3);
                    if (!next3.d && !WearUtils.e1(next3.f)) {
                        String.format(ah4.e(R.string.chat_alart_notify_notice), next3.e);
                    }
                }
                Iterator<g> it5 = zt3.d.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(it5.next());
                }
                Iterator<g> it6 = zt3.c.iterator();
                while (it6.hasNext()) {
                    arrayList2.add(it6.next());
                }
                if (arrayList2.size() > 0) {
                    MyApplication myApplication = WearUtils.x;
                    if (MyApplication.H() != null) {
                        zt3.u(arrayList2);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            zt3.a = true;
            MyApplication myApplication = WearUtils.x;
            if (MyApplication.H() != null) {
                MyApplication myApplication2 = WearUtils.x;
                MyApplication.H().runOnUiThread(new RunnableC0237a(this));
            }
        }
    }

    /* compiled from: AlarmTranslationListener.java */
    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AlarmListItems d;

        /* compiled from: AlarmTranslationListener.java */
        public class a implements Runnable {

            /* compiled from: AlarmTranslationListener.java */
            /* renamed from: dc.zt3$b$a$a, reason: collision with other inner class name */
            public class C0238a extends HashMap<String, String> {
                public C0238a() {
                    put("reason", "outOffTime");
                    put("type", "longDistance");
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IPeopleInfo iPeopleInfoS = WearUtils.y.s(b.this.b);
                String strE = ah4.e(R.string.chat_alarm_missed_local);
                Object[] objArr = new Object[2];
                objArr[0] = iPeopleInfoS == null ? "" : iPeopleInfoS.getShowNickName();
                objArr[1] = b.this.c;
                String str = String.format(strE, objArr);
                MyApplication myApplication = WearUtils.x;
                sg3.k(MyApplication.H(), str);
                WearUtils.x.q("alarm_miss", new C0238a());
                zt3.m(b.this.d);
            }
        }

        public b(String str, String str2, String str3, AlarmListItems alarmListItems) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = alarmListItems;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zt3.n.get(this.a) != null) {
                zt3.n.remove(this.a);
                MyApplication myApplication = WearUtils.x;
                if (MyApplication.H() != null) {
                    MyApplication myApplication2 = WearUtils.x;
                    MyApplication.H().runOnUiThread(new a());
                }
            }
        }
    }

    /* compiled from: AlarmTranslationListener.java */
    public class c implements Runnable {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            zb2.O().m0(this.a);
        }
    }

    /* compiled from: AlarmTranslationListener.java */
    public class d extends ff3 {
        public final /* synthetic */ AlarmListItems a;
        public final /* synthetic */ au3 b;

        public d(AlarmListItems alarmListItems, au3 au3Var) {
            this.a = alarmListItems;
            this.b = au3Var;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
            if (!z) {
                au3 au3Var = this.b;
                if (au3Var != null) {
                    au3Var.b();
                    return;
                }
                return;
            }
            File file = (File) obj;
            this.a.setReveiveFilePath(file.getPath());
            this.a.setDuration(WearUtils.n0(file.getPath()) / 10);
            DaoUtils.getAlarmListDao().updateOrAdd(this.a);
            au3 au3Var2 = this.b;
            if (au3Var2 != null) {
                au3Var2.a();
            }
        }
    }

    /* compiled from: AlarmTranslationListener.java */
    public class e extends ff3 {
        public final /* synthetic */ AlarmListItems a;

        public e(AlarmListItems alarmListItems) {
            this.a = alarmListItems;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
            if (z) {
                this.a.setSoundFileath(((File) obj).getPath());
                DaoUtils.getAlarmListDao().updateOrAdd(this.a);
            }
        }
    }

    /* compiled from: AlarmTranslationListener.java */
    public class f implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Calendar b;
        public final /* synthetic */ long c;
        public final /* synthetic */ boolean d;

        public f(String str, Calendar calendar, long j, boolean z) {
            this.a = str;
            this.b = calendar;
            this.c = j;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            zt3.m.f(this.a, this.b, this.c, this.d);
        }
    }

    /* compiled from: AlarmTranslationListener.java */
    public static class g {
        public int a;
        public String b;
        public String c;
        public boolean d;
        public String e;
        public String f;

        public g(int i, String str, String str2, String str3, boolean z, String str4) {
            this.a = 0;
            this.d = false;
            this.a = i;
            this.b = str;
            this.d = z;
            this.e = str3;
            this.f = str4;
            f(str2, str3);
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }

        public int c() {
            return this.a;
        }

        public void d(String str) {
            this.b = str;
        }

        public void e(int i) {
            this.a = i;
        }

        public void f(String str, String str2) {
            AlarmListItems alarmListItemsFindById;
            if (WearUtils.e1(str2) || WearUtils.e1(this.b)) {
                alarmListItemsFindById = null;
            } else {
                alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(this.b);
                if (alarmListItemsFindById != null) {
                    str2 = alarmListItemsFindById.getTime();
                }
            }
            if (WearUtils.e1(str2) || this.a == 0) {
                return;
            }
            MyApplication myApplication = WearUtils.x;
            String strC = be3.c(str2, MyApplication.H());
            int i = this.a;
            if (i == zt3.h) {
                if (this.d) {
                    this.c = String.format(ah4.e(R.string.chat_alarm_missed_receive), str, strC);
                    return;
                } else {
                    this.c = String.format(ah4.e(R.string.chat_alarm_missed_local), str, strC);
                    return;
                }
            }
            if (i == zt3.e) {
                if (this.d) {
                    this.c = String.format(ah4.e(R.string.chat_alarm_receive), str, strC);
                    return;
                } else {
                    this.c = String.format(ah4.e(R.string.chat_alarm_receive_notice), str, strC);
                    return;
                }
            }
            if (i == zt3.f) {
                this.c = String.format(ah4.e(R.string.chat_alarm_execute_success), str, strC);
                return;
            }
            if (i == zt3.g) {
                this.c = ah4.e(R.string.alerm_setting_autoplay_notice_sender);
                AlarmMessagingService.d(this.b, true);
                if (alarmListItemsFindById != null) {
                    alarmListItemsFindById.setIsSelected(0);
                    DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindById);
                }
            }
        }
    }

    public static boolean b(MyApplication myApplication, EntityAlarm entityAlarm, String str, String str2, CommunMessage communMessage) throws ParseException {
        Date date;
        IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
        AlarmListItems alarmListItems = new AlarmListItems();
        alarmListItems.setId(entityAlarm.getId());
        alarmListItems.setIsSelected(0);
        alarmListItems.setFriendEmail(WearUtils.g0(str));
        alarmListItems.setOwnerEmail(k);
        alarmListItems.setTime(entityAlarm.getPattern().getTime());
        alarmListItems.setFrequency(entityAlarm.getPattern().getFrequency());
        alarmListItems.setDates(WearUtils.A.toJson(entityAlarm.getPattern().getDates()));
        alarmListItems.setPatternId(entityAlarm.getPattern().getUrl());
        alarmListItems.setReceiveFlag(1);
        alarmListItems.setNotify(entityAlarm.getNotify());
        alarmListItems.setNotiType(entityAlarm.getNotiType());
        alarmListItems.setSoundurl(entityAlarm.getSoundurl());
        alarmListItems.setVersion(entityAlarm.getVersion());
        alarmListItems.setReceiveAlarmId(str2);
        alarmListItems.setAlarmTitle(entityAlarm.getName());
        if (iPeopleInfoS != null) {
            if (iPeopleInfoS.isDateIng()) {
                alarmListItems.setAlarmTitle("From " + iPeopleInfoS.getShowNickName());
            } else if (iPeopleInfoS.isGroup()) {
                User userV = ch3.n().v(WearUtils.X(communMessage.getRealFrom()));
                if (userV == null || TextUtils.isEmpty(userV.getRemark())) {
                    alarmListItems.setAlarmTitle("From " + communMessage.getRealFromNickName());
                } else {
                    alarmListItems.setAlarmTitle("From " + userV.getRemark());
                }
            } else {
                alarmListItems.setAlarmTitle("From " + iPeopleInfoS.getUserName());
                if (!TextUtils.isEmpty(iPeopleInfoS.getRemark())) {
                    alarmListItems.setAlarmTitle("From " + iPeopleInfoS.getRemark());
                }
            }
        }
        DaoUtils.getAlarmListDao().addIfNotExist(alarmListItems);
        UserSetting userSettingZ = WearUtils.y.z(WearUtils.g0(str));
        if (!WearUtils.x1(userSettingZ.getAutoPlayAlarm()) || iPeopleInfoS == null || iPeopleInfoS.isDateIng()) {
            try {
                if ("customer".equals(alarmListItems.getFrequency())) {
                    Calendar calendar = Calendar.getInstance();
                    Date dateI = be3.I();
                    Date dateI2 = be3.I();
                    String[] strArr = !WearUtils.e1(alarmListItems.getDates()) ? (String[]) WearUtils.A.fromJson(alarmListItems.getDates(), String[].class) : null;
                    if (strArr == null || WearUtils.e1(alarmListItems.getTime()) || !WearUtils.Z0(strArr[0])) {
                        date = be3.j.parse(be3.i.format(dateI2) + " " + alarmListItems.getTime().trim());
                    } else {
                        date = be3.j.parse(strArr[0].trim() + " " + alarmListItems.getTime().trim());
                    }
                    calendar.setTime(date);
                    if (be3.B(dateI, date, 0)) {
                        calendar.add(5, 1);
                    }
                    long timeInMillis = calendar.getTimeInMillis() - System.currentTimeMillis();
                    if (timeInMillis < 0) {
                        return false;
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new c(str), timeInMillis);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            if (!f()) {
                userSettingZ.setAutoPlayAlarm(Boolean.FALSE);
                DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
                return false;
            }
            t(myApplication, entityAlarm.getId(), false, true, false);
            alarmListItems.setAccept(1);
            alarmListItems.setIsSelected(1);
            DaoUtils.getAlarmListDao().updateOrAdd(alarmListItems);
        }
        j(DaoUtils.getAlarmListDao().findById(entityAlarm.getId()));
        return true;
    }

    public static CommunMessage c(String str, String str2, String str3) {
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), str3, str);
        CommunMessage communMessage = new CommunMessage();
        String strP = WearUtils.y.p();
        if (WearUtils.e1(strP) && !WearUtils.e1(k)) {
            strP = WearUtils.i0(k);
        }
        communMessage.setFrom(strP);
        communMessage.setTo(str2);
        communMessage.sendEntity(entitySystem);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(str2);
        if (zb2.O().l0(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        }
        return communMessage;
    }

    public static g d(String str, String str2) {
        if (WearUtils.e1(str) || !str.startsWith(j)) {
            return null;
        }
        g gVar = new g(0, "", "", "", false, null);
        String[] strArrSplit = str.split(i);
        if (strArrSplit == null || strArrSplit.length != 5) {
            return gVar;
        }
        gVar.e(WearUtils.q1(strArrSplit[1]) ? Integer.valueOf(strArrSplit[1]).intValue() : 0);
        gVar.d(strArrSplit[2]);
        if (TextUtils.isEmpty(str2)) {
            gVar.f(strArrSplit[3], strArrSplit[4]);
            return gVar;
        }
        gVar.f(str2, strArrSplit[4]);
        return gVar;
    }

    public static long e(AlarmListItems alarmListItems) {
        return System.currentTimeMillis() + (alarmListItems.getSnoozeDuration() * 1000 * 60);
    }

    public static boolean f() {
        return q61.f(MyApplication.N(), "android.permission.SCHEDULE_EXACT_ALARM");
    }

    public static boolean g(AlarmListItems alarmListItems) throws ParseException {
        Date date;
        try {
            Calendar calendar = Calendar.getInstance();
            Date dateI = be3.I();
            Date dateI2 = be3.I();
            String[] strArr = !WearUtils.e1(alarmListItems.getDates()) ? (String[]) WearUtils.A.fromJson(alarmListItems.getDates(), String[].class) : null;
            if (strArr == null || WearUtils.e1(alarmListItems.getTime()) || !WearUtils.Z0(strArr[0])) {
                date = be3.j.parse(be3.i.format(dateI2) + " " + alarmListItems.getTime().trim());
            } else {
                date = be3.j.parse(strArr[0].trim() + " " + alarmListItems.getTime().trim());
            }
            calendar.setTime(date);
            return be3.B(dateI, date, 0);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static /* synthetic */ void h(String str, CommunMessage communMessage, EntityAlarm entityAlarm) {
        String showNickName;
        GroupMember memberByJid;
        IPeopleInfo iPeopleInfoS = WearUtils.y.s(WearUtils.g0(str));
        if (iPeopleInfoS != null) {
            if (iPeopleInfoS.isGroup()) {
                Group group = (Group) iPeopleInfoS;
                showNickName = (group == null || (memberByJid = group.getMemberByJid(communMessage.getRealFrom())) == null) ? "" : memberByJid.getShowNickName();
            } else {
                showNickName = iPeopleInfoS.getShowNickName();
            }
            String str2 = String.format(ah4.e(R.string.chat_alarm_receive), showNickName, entityAlarm.getPattern().getTime());
            MyApplication myApplication = WearUtils.x;
            sg3.k(MyApplication.H(), str2);
        }
    }

    public static /* synthetic */ void i(Activity activity, u51 u51Var) {
        q61 q61VarM = q61.m(activity);
        q61VarM.h("android.permission.SCHEDULE_EXACT_ALARM");
        q61VarM.j(u51Var);
    }

    public static void j(AlarmListItems alarmListItems) {
        k(alarmListItems, null);
    }

    public static void k(AlarmListItems alarmListItems, au3 au3Var) {
        WearUtils.E0(true, alarmListItems.getPatternId(), new d(alarmListItems, au3Var));
        if (EntityAlarm.AlarmNotiType.fromString(alarmListItems.getNotiType()) != EntityAlarm.AlarmNotiType.sound || WearUtils.e1(alarmListItems.getSoundurl())) {
            return;
        }
        WearUtils.E0(true, alarmListItems.getSoundurl(), new e(alarmListItems));
    }

    public static void l(String str, String str2, String str3) {
        Alarm alarmFindAlarm = DaoUtils.getAlarmDao().findAlarm(WearUtils.y.r(), str3);
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        if ((alarmFindAlarm == null || !WearUtils.y1(alarmFindAlarm.getNotifySwitchOn())) && alarmListItemsFindById.getNotify() != 1) {
            return;
        }
        n.put(str, str);
        WearUtils.x.l.postDelayed(new b(str, str3, str2, alarmListItemsFindById), 60000L);
    }

    public static void m(AlarmListItems alarmListItems) {
        String str = String.format(ah4.e(R.string.chat_alart_notify_notice), alarmListItems.getTime());
        EntitySystem entitySystem = new EntitySystem();
        entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C202.toString(), str);
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(WearUtils.i0(alarmListItems.getFriendEmail()));
        communMessage.sendEntity(entitySystem);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(WearUtils.y.p());
        if (zb2.O().l0(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            zb2.O().i0(communMessage);
        }
    }

    public static void n(MyApplication myApplication, final EntityAlarm entityAlarm, final String str, String str2, final CommunMessage communMessage) {
        IPeopleInfo iPeopleInfoS;
        System.out.println("receiveDeCode=" + WearUtils.A.toJson(entityAlarm));
        if (entityAlarm.getAlarmOPTType() == EntityAlarm.AlarmOPTType.delete) {
            if (entityAlarm.getVersion() < 1) {
                t(myApplication, entityAlarm.getId(), true, false, false);
                return;
            }
            return;
        }
        if (entityAlarm.getAlarmOPTType() == EntityAlarm.AlarmOPTType.pattern && b(myApplication, entityAlarm, str, str2, communMessage) && (iPeopleInfoS = WearUtils.y.s(WearUtils.g0(str))) != null) {
            if (!a) {
                c.add(new g(e, entityAlarm.getId(), iPeopleInfoS == null ? "" : iPeopleInfoS.getTempName(), entityAlarm.getPattern().getTime(), true, str));
            } else if (WearUtils.x1(WearUtils.y.z(WearUtils.g0(str)).getAutoPlayAlarm()) && !iPeopleInfoS.isDateIng()) {
                MyApplication myApplication2 = WearUtils.x;
                if (MyApplication.H() != null) {
                    MyApplication myApplication3 = WearUtils.x;
                    MyApplication.H().runOnUiThread(new Runnable() { // from class: dc.lt3
                        @Override // java.lang.Runnable
                        public final void run() {
                            zt3.h(str, communMessage, entityAlarm);
                        }
                    });
                }
            }
            if (iPeopleInfoS.isGroup()) {
                return;
            }
            Account accountU = WearUtils.y.u();
            StringBuilder sb = new StringBuilder();
            sb.append(accountU != null ? accountU.getUserName() : "");
            sb.append(i);
            sb.append(entityAlarm.getPattern().getTime());
            String str3 = j + e + i + str2 + i + sb.toString();
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T200.toString(), EntitySystem.SystemOPTCode.C202.toString(), str3);
            hu3.g0(entitySystem, str, MessageType.system, str3, null, null);
        }
    }

    public static void o() throws ParseException {
        a = false;
        b.clear();
        c.clear();
        d.clear();
        n.clear();
        m.g();
        m.m();
        q();
        p();
        WearUtils.x.l.postDelayed(new a(), 8000L);
    }

    public static void p() throws ParseException {
        Date date;
        List<AlarmListItems> listFindAllDefendAlarmList = DaoUtils.getAlarmListDao().findAllDefendAlarmList();
        if (listFindAllDefendAlarmList != null) {
            for (AlarmListItems alarmListItems : listFindAllDefendAlarmList) {
                if (alarmListItems != null) {
                    Alarm alarmFindAlarm = DaoUtils.getAlarmDao().findAlarm(k, alarmListItems.getFriendEmail());
                    if (!WearUtils.e1(alarmListItems.getRingTime())) {
                        try {
                            date = be3.j.parse(alarmListItems.getRingTime());
                            try {
                                if (!be3.C(date, be3.I(), 0) && (WearUtils.y1(alarmFindAlarm.getNotifySwitchOn()) || alarmListItems.getNotify() == 1)) {
                                    User userFindById = DaoUtils.getUserDao().findById(alarmListItems.getFriendEmail());
                                    b.add(new g(h, alarmListItems.getId(), userFindById == null ? "" : userFindById.getUserName(), alarmListItems.getTime(), false, alarmListItems.getFriendEmail()));
                                }
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            date = null;
                        }
                        if (alarmListItems.getFrequency().equals("customer") && (date == null || !be3.C(date, be3.I(), 0))) {
                            AlarmMessagingService.d(alarmListItems.getId(), false);
                            alarmListItems.setRingTime(null);
                            alarmListItems.setIsSelected(0);
                            DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
                        } else if (alarmListItems.getIsSelected() == 1) {
                            t(WearUtils.x, alarmListItems.getId(), false, true, true);
                        }
                    } else if (alarmListItems.getIsSelected() == 1) {
                        alarmListItems.setIsSelected(0);
                        DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
                    }
                }
            }
        }
    }

    public static void q() throws ParseException {
        Date date;
        List<AlarmListItems> listFindAllReceiveAlarmList = DaoUtils.getAlarmListDao().findAllReceiveAlarmList();
        if (listFindAllReceiveAlarmList != null) {
            for (AlarmListItems alarmListItems : listFindAllReceiveAlarmList) {
                if (alarmListItems != null) {
                    Alarm alarmK = WearUtils.x.K(alarmListItems.getFriendEmail());
                    if (WearUtils.e1(alarmListItems.getRingTime())) {
                        date = null;
                    } else {
                        try {
                            date = be3.j.parse(alarmListItems.getRingTime());
                        } catch (ParseException e2) {
                            e = e2;
                            date = null;
                        }
                        try {
                            if (!be3.C(date, be3.I(), 0) && (WearUtils.y1(alarmK.getMissSwitchOn()) || alarmListItems.getNotify() == 1)) {
                                User userFindById = DaoUtils.getUserDao().findById(alarmListItems.getFriendEmail());
                                b.add(new g(h, alarmListItems.getId(), userFindById == null ? "" : userFindById.getUserName(), alarmListItems.getTime(), true, alarmListItems.getFriendEmail()));
                                String.format(ah4.e(R.string.chat_alart_miss_notice), alarmListItems.getTime());
                                if (!WearUtils.e1(alarmK.getMessage())) {
                                    c(alarmK.getMessage(), WearUtils.i0(alarmListItems.getFriendEmail()), EntitySystem.SystemOPTCode.C202.toString());
                                }
                            }
                        } catch (ParseException e3) {
                            e = e3;
                            e.printStackTrace();
                            if (alarmListItems.getFrequency().equals("customer")) {
                            }
                            t(WearUtils.x, alarmListItems.getId(), false, true, false);
                        }
                    }
                    if (alarmListItems.getFrequency().equals("customer") || (date != null && be3.C(date, be3.I(), 0))) {
                        t(WearUtils.x, alarmListItems.getId(), false, true, false);
                    } else {
                        AlarmMessagingService.d(alarmListItems.getId(), false);
                        alarmListItems.setRingTime(null);
                        DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
                    }
                }
            }
        }
    }

    public static void r(Context context, AlarmListItems alarmListItems) {
        if (alarmListItems.getSnoozeCount() != 0 && alarmListItems.getHaveSnoozeCount() <= alarmListItems.getSnoozeCount() && alarmListItems.getHaveSnoozeCount() > 0) {
            s(context, alarmListItems, alarmListItems.getId());
        }
        if (alarmListItems.getSnoozeCount() == 0 || alarmListItems.getHaveSnoozeCount() <= alarmListItems.getSnoozeCount() || !alarmListItems.getFrequency().equals("customer")) {
            return;
        }
        AlarmMessagingService.d(alarmListItems.getId(), false);
        alarmListItems.setRingTime(null);
        alarmListItems.setIsSelected(0);
        alarmListItems.setHaveSnoozeCount(0);
        DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
    }

    public static void s(Context context, AlarmListItems alarmListItems, String str) {
        if (alarmListItems == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) AlarmMessagingService.class);
        intent.setAction("com.wear.alarm.MESSAGING_EVENT");
        intent.putExtra("com.wear.alarm.EXTRA_ALARM_ID", str);
        PendingIntent service = PendingIntent.getService(context, str.hashCode(), intent, 335544320);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        long jE = e(alarmListItems);
        if (f()) {
            alarmManager.setExact(0, jE, service);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x022a, code lost:
    
        r0 = r0 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0233, code lost:
    
        r0 = r2 - r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0145 A[Catch: ParseException -> 0x0244, TryCatch #0 {ParseException -> 0x0244, blocks: (B:13:0x005b, B:15:0x0065, B:20:0x0079, B:22:0x0083, B:24:0x008b, B:26:0x00d8, B:29:0x00e1, B:31:0x00e7, B:33:0x00f1, B:53:0x0145, B:55:0x0151, B:111:0x023e, B:56:0x0157, B:58:0x0161, B:60:0x0168, B:61:0x016d, B:62:0x0173, B:64:0x017d, B:65:0x0182, B:67:0x0185, B:75:0x019b, B:77:0x019e, B:80:0x01ac, B:110:0x023b, B:81:0x01b7, B:83:0x01bb, B:103:0x022a, B:84:0x01d1, B:86:0x01de, B:107:0x0233, B:87:0x01e9, B:89:0x01ee, B:90:0x01f3, B:92:0x01f6, B:93:0x0205, B:94:0x0215, B:96:0x0218, B:99:0x021e, B:100:0x0221, B:102:0x0225, B:104:0x022c, B:106:0x0231, B:108:0x0236, B:70:0x0193, B:35:0x010e, B:40:0x0120, B:43:0x012b, B:45:0x012e, B:48:0x013c, B:25:0x00b2), top: B:134:0x005b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void t(android.content.Context r17, java.lang.String r18, boolean r19, boolean r20, boolean r21) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 816
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.zt3.t(android.content.Context, java.lang.String, boolean, boolean, boolean):void");
    }

    public static void u(ArrayList<g> arrayList) {
        MyApplication myApplication = WearUtils.x;
        new qr3(MyApplication.H(), arrayList).show();
    }

    public static void v(final Activity activity, final u51 u51Var) {
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        is3.b bVar = new is3.b(activity);
        bVar.p(ah4.e(R.string.alarms_reminders_permission_required));
        bVar.b(true);
        bVar.o(ah4.e(R.string.common_go_setting));
        bVar.d(new is3.d() { // from class: dc.mt3
            @Override // dc.is3.d
            public final void doConfirm() {
                zt3.i(activity, u51Var);
            }
        });
        bVar.l(true);
        bVar.m(true);
        cs3.h(bVar).show();
    }
}
