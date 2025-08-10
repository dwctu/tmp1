package dc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.lovense.wear.R;
import com.wear.bean.Alarm;
import com.wear.bean.Group;
import com.wear.bean.ReCall;
import com.wear.bean.TypingBean;
import com.wear.bean.User;
import com.wear.bean.UserSetting;
import com.wear.bean.event.AddFriendsRequestEvent;
import com.wear.bean.event.BurnAfterReadEvent;
import com.wear.bean.event.ChatBurnRecallEvent;
import com.wear.bean.event.SystemEvent;
import com.wear.bean.event.TypingEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.dao.UserSettingDao;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityBurnPicture;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.kn3;
import dc.n82;
import dc.zt3;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* compiled from: SystemTranslationListener.java */
/* loaded from: classes4.dex */
public class nu3 {

    /* compiled from: SystemTranslationListener.java */
    public class a implements n82.d {
        public final /* synthetic */ EntitySystem.EntityArray a;

        public a(EntitySystem.EntityArray entityArray) {
            this.a = entityArray;
        }

        @Override // dc.n82.d
        public void a(boolean z) {
            if (this.a.getSysOPTCode() == EntitySystem.SystemOPTCode.C306) {
                EventBus.getDefault().post(new SystemEvent(0, null));
            }
        }
    }

    /* compiled from: SystemTranslationListener.java */
    public class b implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;

        /* compiled from: SystemTranslationListener.java */
        public class a implements kn3.d {
            public a(b bVar) {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
            }
        }

        public b(Activity activity, String str) {
            this.a = activity;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.isFinishing() || this.a.isDestroyed()) {
                return;
            }
            kn3 kn3Var = new kn3((Context) this.a, this.b, ah4.e(R.string.common_ok), false, false, (kn3.d) new a(this));
            kn3Var.show();
            kn3Var.n();
        }
    }

    public static void a(MyApplication myApplication, String str, String str2, EntitySystem entitySystem, CommunMessage communMessage) {
        boolean z;
        ReCall reCallFindById;
        CommunMessage communMessageFindById;
        System.out.println("receiveSystemDeCode=" + WearUtils.A.toJson(entitySystem));
        String strB = "";
        if (entitySystem == null || entitySystem.getData() == null) {
            return;
        }
        Iterator<EntitySystem.EntityArray> it = entitySystem.getData().iterator();
        while (it.hasNext()) {
            EntitySystem.EntityArray next = it.next();
            String strG0 = WearUtils.g0(str);
            EntitySystem.SystemOPTCode sysOPTCode = next.getSysOPTCode();
            EntitySystem.SystemOPTCode systemOPTCode = EntitySystem.SystemOPTCode.C304;
            if (sysOPTCode == systemOPTCode || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C305) {
                UserSetting userSettingZ = WearUtils.y.z(strG0);
                if (next.getSysOPTCode() == systemOPTCode) {
                    userSettingZ.setPassiveAutoAccept(Boolean.TRUE);
                } else {
                    userSettingZ.setPassiveAutoAccept(Boolean.FALSE);
                }
                DaoUtils.getUserSettingDao().update((UserSettingDao) userSettingZ);
            }
            EntitySystem.SystemOPTCode sysOPTCode2 = next.getSysOPTCode();
            EntitySystem.SystemOPTCode systemOPTCode2 = EntitySystem.SystemOPTCode.C300;
            if (sysOPTCode2 == systemOPTCode2 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C301) {
                Alarm alarmK = myApplication.K(strG0);
                if (next.getSysOPTCode() == systemOPTCode2) {
                    alarmK.setNotifySwitchOn("true");
                } else {
                    alarmK.setNotifySwitchOn("false");
                }
                DaoUtils.getAlarmDao().updateOrAdd(alarmK);
            }
            EntitySystem.SystemOPTCode sysOPTCode3 = next.getSysOPTCode();
            EntitySystem.SystemOPTCode systemOPTCode3 = EntitySystem.SystemOPTCode.C302;
            if (sysOPTCode3 == systemOPTCode3 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C303) {
                Alarm alarmK2 = myApplication.K(strG0);
                if (next.getSysOPTCode() == systemOPTCode3) {
                    alarmK2.setMissSwitchOn("true");
                    alarmK2.setMessage(WearUtils.e1(next.getText()) ? "" : next.getText());
                } else {
                    alarmK2.setMissSwitchOn("false");
                }
                DaoUtils.getAlarmDao().updateOrAdd(alarmK2);
            }
            if (next.getSysOPTCode() == EntitySystem.SystemOPTCode.C306 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C307) {
                WearUtils.x.i.x(new a(next));
            }
            if (next.getSysOPTType() == EntitySystem.SystemOPTType.T300 && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C324) {
                zb2.O().C(strG0);
            }
            EntitySystem.SystemOPTType sysOPTType = next.getSysOPTType();
            EntitySystem.SystemOPTType systemOPTType = EntitySystem.SystemOPTType.T200;
            if (sysOPTType == systemOPTType && (next.getSysOPTCode() == EntitySystem.SystemOPTCode.C325 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C326 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C327 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C328)) {
                DaoUtils.getCommunMessageDao().addIfNotExist(communMessage);
                zb2.O().i0(communMessage);
            }
            if (next.getSysOPTType() == systemOPTType && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C666) {
                DaoUtils.getCommunMessageDao().addIfNotExist(communMessage);
                zb2.O().i0(communMessage);
            }
            if (next.getSysOPTType() == systemOPTType && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C329) {
                DaoUtils.getCommunMessageDao().addIfNotExist(communMessage);
                zb2.O().i0(communMessage);
            }
            EntitySystem.SystemOPTCode sysOPTCode4 = next.getSysOPTCode();
            EntitySystem.SystemOPTCode systemOPTCode4 = EntitySystem.SystemOPTCode.C311;
            if (sysOPTCode4 == systemOPTCode4 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C312) {
                if (next.getSysOPTCode() == systemOPTCode4) {
                    WearUtils.x.i.C(str, true);
                } else {
                    synchronized (ch3.h) {
                        Iterator<User> it2 = ch3.j.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            User next2 = it2.next();
                            if (next2.getId().equals(WearUtils.g0(str))) {
                                ch3.j.remove(next2);
                                AddFriendsRequestEvent addFriendsRequestEvent = new AddFriendsRequestEvent();
                                addFriendsRequestEvent.flag = 3;
                                addFriendsRequestEvent.user = next2;
                                WearUtils.y.w(WearUtils.g0(str)).resetFriendType(16);
                                EventBus.getDefault().post(addFriendsRequestEvent);
                                break;
                            }
                        }
                    }
                    WearUtils.x.i.C(str, false);
                }
            }
            EntitySystem.SystemOPTType sysOPTType2 = next.getSysOPTType();
            EntitySystem.SystemOPTType systemOPTType2 = EntitySystem.SystemOPTType.T200;
            if (sysOPTType2 == systemOPTType2 && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C202) {
                String text = next.getText();
                IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
                String showNickName = iPeopleInfoS != null ? iPeopleInfoS.getShowNickName() : null;
                if (iPeopleInfoS instanceof Group) {
                    showNickName = communMessage.getRealFromNickName();
                }
                zt3.g gVarD = zt3.d(text, showNickName);
                if (gVarD != null) {
                    if (zt3.a) {
                        zt3.n.remove(gVarD.a());
                        strB = gVarD.b();
                    } else {
                        if (WearUtils.e1(gVarD.a()) || DaoUtils.getAlarmListDao().findById(gVarD.a()).getNotify() == 1) {
                            zt3.d.add(gVarD);
                        }
                    }
                }
            }
            EntitySystem.SystemOPTType sysOPTType3 = next.getSysOPTType();
            EntitySystem.SystemOPTType systemOPTType3 = EntitySystem.SystemOPTType.T300;
            if (sysOPTType3 == systemOPTType3) {
                EntitySystem.SystemOPTCode sysOPTCode5 = next.getSysOPTCode();
                EntitySystem.SystemOPTCode systemOPTCode5 = EntitySystem.SystemOPTCode.C320;
                if (sysOPTCode5 == systemOPTCode5) {
                    String text2 = next.getText();
                    if (!WearUtils.e1(text2)) {
                        String communMessageId = DaoUtils.getReCallDao().getCommunMessageId(text2, 1);
                        if (!WearUtils.e1(communMessageId) && (communMessageFindById = DaoUtils.getCommunMessageDao().findById(communMessageId)) != null) {
                            boolean z2 = communMessageFindById.getType() == MessageType.pattern;
                            boolean z3 = communMessageFindById.getType() == MessageType.burnpicture;
                            EntitySystem entitySystem2 = new EntitySystem();
                            entitySystem2.addDataToArray(systemOPTType3.toString(), systemOPTCode5.toString(), text2);
                            communMessageFindById.sendEntity(entitySystem2);
                            DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessageFindById);
                            DaoUtils.getReCallDao().delById(communMessageFindById.getId());
                            df3.e().o(str, communMessageFindById.getId());
                            if (z2) {
                                cu3.f(communMessageFindById.getId());
                                if (!WearUtils.e1(qf3.o()) && qf3.o().equals(communMessageFindById.getId())) {
                                    qf3.C();
                                }
                            }
                            if (z3) {
                                EventBus.getDefault().post(new ChatBurnRecallEvent());
                            }
                            EventBus.getDefault().post(new SystemEvent(1, communMessageFindById));
                        }
                    }
                }
            }
            if (next.getSysOPTType() == systemOPTType3 && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C321) {
                String text3 = next.getText();
                if (!WearUtils.e1(text3)) {
                    String communMessageId2 = DaoUtils.getReCallDao().getCommunMessageId(text3, 0);
                    if (!WearUtils.e1(communMessageId2) && (reCallFindById = DaoUtils.getReCallDao().findById(communMessageId2)) != null) {
                        reCallFindById.setCanBe(1);
                        DaoUtils.getReCallDao().delT(reCallFindById);
                    }
                }
            }
            if (next.getSysOPTType() == EntitySystem.SystemOPTType.T201 && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C202) {
                String text4 = next.getText();
                FragmentActivity fragmentActivity = MyApplication.K;
                if (fragmentActivity == null) {
                    return;
                } else {
                    fragmentActivity.runOnUiThread(new b(fragmentActivity, text4));
                }
            }
            if (next.getSysOPTType() == systemOPTType2 && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C204) {
                zb2.O().i0(communMessage);
                List<TypingBean> list = ch3.k;
                if (list != null) {
                    if (list.size() > 0) {
                        Iterator<TypingBean> it3 = ch3.k.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z = false;
                                break;
                            }
                            TypingBean next3 = it3.next();
                            if (TextUtils.equals(next3.getFromJid(), str)) {
                                next3.setCreated(communMessage.getCreated());
                                next3.setTyping(true);
                                EventBus.getDefault().post(new TypingEvent(communMessage));
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            TypingBean typingBean = new TypingBean();
                            typingBean.setCreated(communMessage.getCreated());
                            typingBean.setFromJid(str);
                            typingBean.setTyping(false);
                            ch3.k.add(typingBean);
                        }
                    } else {
                        TypingBean typingBean2 = new TypingBean();
                        typingBean2.setCreated(communMessage.getCreated());
                        typingBean2.setFromJid(str);
                        typingBean2.setTyping(true);
                        ch3.k.add(typingBean2);
                        EventBus.getDefault().post(new TypingEvent(communMessage));
                    }
                }
            }
            if (next.getSysOPTType() == EntitySystem.SystemOPTType.T300 && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C309) {
                String text5 = next.getText();
                CommunMessage communMessageFindById2 = DaoUtils.getCommunMessageDao().findById(text5);
                if (communMessageFindById2 == null) {
                    communMessageFindById2 = DaoUtils.getCommunMessageDao().findByReceiveId(text5);
                }
                if (communMessageFindById2 != null) {
                    if (communMessageFindById2.getType() == MessageType.burnpicture) {
                        EntityBurnPicture entityBurnPicture = (EntityBurnPicture) communMessageFindById2.syncDecryptBean();
                        entityBurnPicture.setBurn(true);
                        communMessageFindById2.sendEntity(entityBurnPicture);
                    }
                    if (communMessageFindById2.getType() == MessageType.burnvideo) {
                        EntityBurnShortVideo entityBurnShortVideo = (EntityBurnShortVideo) communMessageFindById2.syncDecryptBean();
                        entityBurnShortVideo.setBurn(true);
                        communMessageFindById2.sendEntity(entityBurnShortVideo);
                    }
                    DaoUtils.getCommunMessageDao().update((CommunMessageDao) communMessageFindById2);
                    EventBus.getDefault().post(new BurnAfterReadEvent(communMessageFindById2));
                }
            }
            if (next.getSysOPTType() == EntitySystem.SystemOPTType.T200 && next.getSysOPTCode() == EntitySystem.SystemOPTCode.C205) {
                DaoUtils.getCommunMessageDao().addIfNotExist(communMessage);
                zb2.O().i0(communMessage);
            }
        }
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        sg3.l(strB);
    }
}
