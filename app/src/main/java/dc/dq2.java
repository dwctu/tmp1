package dc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.ControlLinkData;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.bean.UserControlLink;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.socketio.chatBase.SendMsgACKResponse;
import com.wear.bean.socketio.controlLink.ControlLinkMsgXYBean;
import com.wear.bean.socketio.controlLink.request.CancelOccupyCountDownByJoinerRequest;
import com.wear.bean.socketio.controlLink.request.CancelOccupyCountDownRequest;
import com.wear.bean.socketio.controlLink.request.ControlLinkMessageBean;
import com.wear.bean.socketio.controlLink.request.EndControlRequest;
import com.wear.bean.socketio.controlLink.request.GetControlLinkMsgRequest;
import com.wear.bean.socketio.controlLink.request.GetNewMessageDTORequest;
import com.wear.bean.socketio.controlLink.request.QueryUserOnLineRequest;
import com.wear.bean.socketio.controlLink.request.ReadMsgDTORequest;
import com.wear.bean.socketio.controlLink.request.ReadyTSRequest;
import com.wear.bean.socketio.controlLink.request.SendCommandRequest;
import com.wear.bean.socketio.controlLink.request.ToyCommandBean;
import com.wear.bean.socketio.controlLink.response.CloseControlEvent;
import com.wear.bean.socketio.controlLink.response.GetNewMessageACKResponse;
import com.wear.bean.socketio.controlLink.response.ReadyTCResponse;
import com.wear.dao.ControlLinkCommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.main.longDistance.control.LDRControl;
import com.wear.main.ninja.service.PlayService;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityToy;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.MessageType;
import com.wear.protocol.controlLink.ControlLinkCommunMessage;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkEndActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.EventBus;

/* compiled from: ControlLinkControl.java */
/* loaded from: classes3.dex */
public class dq2 {
    public static final String i = "dc.dq2";
    public static volatile dq2 j;
    public final Object a = new Object();
    public final Object b = new Object();
    public AtomicBoolean c = new AtomicBoolean(false);
    public AtomicBoolean d = new AtomicBoolean(false);
    public Map<String, ControlLinkCommunMessage> e = new ConcurrentHashMap();
    public ek3 f;
    public HashMap<String, ControlLinkMsgXYBean> g;
    public ie3 h;

    /* compiled from: ControlLinkControl.java */
    public class a implements mf2 {

        /* compiled from: ControlLinkControl.java */
        /* renamed from: dc.dq2$a$a, reason: collision with other inner class name */
        public class RunnableC0172a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0172a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.a)) {
                    dq2.this.c.set(false);
                    return;
                }
                synchronized (dq2.this.b) {
                    GetNewMessageACKResponse getNewMessageACKResponse = (GetNewMessageACKResponse) JSON.parseObject(this.a, GetNewMessageACKResponse.class);
                    ArrayList arrayList = new ArrayList();
                    if (getNewMessageACKResponse == null || getNewMessageACKResponse.getList() == null || getNewMessageACKResponse.getList().size() <= 0) {
                        dq2.this.c.set(false);
                    } else {
                        for (ControlLinkCommunMessage controlLinkCommunMessage : getNewMessageACKResponse.getList()) {
                            ControlLinkMsgXYBean controlLinkMsgXYBean = (ControlLinkMsgXYBean) dq2.this.g.get(controlLinkCommunMessage.getDateImTypeData());
                            if (controlLinkMsgXYBean != null) {
                                String strK = nd3.k(controlLinkCommunMessage.getMsgData(), controlLinkMsgXYBean.getX(), controlLinkMsgXYBean.getY());
                                if (WearUtils.e1(strK)) {
                                    ye3.d("S0003", "ImType = " + controlLinkCommunMessage.getDateImTypeData() + " msg = " + controlLinkCommunMessage.getMsgData() + "   x = " + controlLinkMsgXYBean.getX() + "   y = " + controlLinkMsgXYBean.getY());
                                } else {
                                    controlLinkCommunMessage.setMsgData(nd3.n(strK));
                                    if (!DaoUtils.getControlLinkCommunMessageDao().isAddMessage(controlLinkCommunMessage.getMsgId())) {
                                        arrayList.add(controlLinkCommunMessage);
                                        dq2.this.e.put(controlLinkCommunMessage.getMsgId(), controlLinkCommunMessage);
                                    }
                                }
                            } else {
                                ye3.d("S0003", controlLinkCommunMessage.getDateImTypeData());
                            }
                        }
                        dq2.this.E(arrayList);
                        dq2.this.c.set(false);
                        if (getNewMessageACKResponse.getList().size() != 100) {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<Map.Entry<String, ControlLinkCommunMessage>> it = dq2.this.e.entrySet().iterator();
                            while (it.hasNext()) {
                                arrayList2.add(it.next().getValue());
                            }
                            dq2.this.e.clear();
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                dq2.this.j((ControlLinkCommunMessage) it2.next());
                            }
                            Collections.sort(arrayList2, new o12());
                            EventBus.getDefault().post(new jq2(arrayList2));
                        } else {
                            dq2.this.d.set(true);
                        }
                    }
                }
                if (dq2.this.d.get()) {
                    dq2.this.d.set(false);
                    dq2.this.H();
                }
            }
        }

        public a() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            vg3.b().a(new RunnableC0172a(str));
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            dq2.this.c.set(false);
        }
    }

    /* compiled from: ControlLinkControl.java */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.live.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.sync.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.video.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.voice.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MessageType.pattern.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MessageType.audio.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: ControlLinkControl.java */
    public class c implements mf2 {
        public final /* synthetic */ ControlLinkCommunMessage a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public c(ControlLinkCommunMessage controlLinkCommunMessage, String str, String str2, String str3) {
            this.a = controlLinkCommunMessage;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // dc.mf2
        public void Q(String str) {
            SendMsgACKResponse sendMsgACKResponse;
            ControlLinkMsgXYBean controlLinkMsgXYBean;
            if (TextUtils.isEmpty(str) || (sendMsgACKResponse = (SendMsgACKResponse) JSON.parseObject(str, SendMsgACKResponse.class)) == null) {
                return;
            }
            this.a.setCreateTime(sendMsgACKResponse.getCreateTime());
            this.a.setMsgId(sendMsgACKResponse.getMsgId());
            if (sendMsgACKResponse.getAckCode() == 12) {
                this.a.sendSuc();
            } else if (sendMsgACKResponse.getAckCode() == 400) {
                this.a.sendSuc();
                if (!WearUtils.e1(sendMsgACKResponse.getTips()) && (controlLinkMsgXYBean = (ControlLinkMsgXYBean) dq2.this.g.get(this.b)) != null) {
                    ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
                    controlLinkCommunMessage.setFromId(this.c);
                    controlLinkCommunMessage.setToId(this.d);
                    String tips = sendMsgACKResponse.getTips();
                    if (!WearUtils.e1(sendMsgACKResponse.getTipsKey()) && !WearUtils.e1(ah4.g(sendMsgACKResponse.getTipsKey()))) {
                        tips = ah4.g(sendMsgACKResponse.getTipsKey());
                    }
                    EntitySystem entitySystem = new EntitySystem();
                    entitySystem.addDataToArray(EntitySystem.SystemOPTType.T400.toString(), EntitySystem.SystemOPTCode.C703.toString(), tips);
                    controlLinkCommunMessage.sendEntity(entitySystem, controlLinkMsgXYBean.getX(), controlLinkMsgXYBean.getY());
                    controlLinkCommunMessage.setId(WearUtils.E());
                    controlLinkCommunMessage.setSendStatus(0);
                    controlLinkCommunMessage.setCreateTime(this.a.getCreateTime() + 1);
                    controlLinkCommunMessage.setDateImType("control_link");
                    controlLinkCommunMessage.setDateImTypeData(this.b);
                    EventBus.getDefault().post(new gq2(controlLinkCommunMessage));
                }
            } else {
                this.a.sendFail();
            }
            DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) this.a);
            EventBus.getDefault().post(new hq2(this.a));
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            this.a.sendFail();
            DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) this.a);
            EventBus.getDefault().post(new hq2(this.a));
        }
    }

    /* compiled from: ControlLinkControl.java */
    public class d implements yn2<ControlLinkData> {
        public final /* synthetic */ i a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        /* compiled from: ControlLinkControl.java */
        public class a implements mf2 {
            public final /* synthetic */ ControlLinkBean a;

            public a(ControlLinkBean controlLinkBean) {
                this.a = controlLinkBean;
            }

            @Override // dc.mf2
            public void Q(String str) {
                ReadyTCResponse readyTCResponse = (ReadyTCResponse) JSON.parseObject(str, ReadyTCResponse.class);
                if (readyTCResponse == null) {
                    i iVar = d.this.a;
                    if (iVar != null) {
                        iVar.onError("2");
                        return;
                    }
                    return;
                }
                if (readyTCResponse.getLinkStatus() == 0) {
                    i iVar2 = d.this.a;
                    if (iVar2 != null) {
                        iVar2.a(this.a);
                        return;
                    }
                    return;
                }
                i iVar3 = d.this.a;
                if (iVar3 != null) {
                    iVar3.onError(readyTCResponse.getLinkStatus() + "");
                }
            }

            @Override // dc.mf2
            public void a(Throwable th) {
                i iVar = d.this.a;
                if (iVar != null) {
                    iVar.onError(th.getMessage());
                }
            }
        }

        public d(dq2 dq2Var, i iVar, int i, String str) {
            this.a = iVar;
            this.b = i;
            this.c = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ControlLinkData controlLinkData) {
            if (controlLinkData == null) {
                i iVar = this.a;
                if (iVar != null) {
                    iVar.onError("2");
                    return;
                }
                return;
            }
            if (controlLinkData.getCode() != 0) {
                i iVar2 = this.a;
                if (iVar2 != null) {
                    iVar2.onError(controlLinkData.getMessage());
                    return;
                }
                return;
            }
            int linkStatus = controlLinkData.getData().getLinkStatus();
            if (linkStatus == 0) {
                ControlLinkBean data = controlLinkData.getData();
                dq2.w().F(data.getLinkId(), data.getX(), data.getY());
                if (!data.getSelfId().equals(data.getCreator().getUserId())) {
                    eq2.f().b(new ReadyTSRequest(WearUtils.E(), this.c), new a(data));
                    return;
                } else {
                    if (this.b == 5) {
                        i iVar3 = this.a;
                        if (iVar3 != null) {
                            iVar3.a(data);
                            return;
                        }
                        return;
                    }
                    i iVar4 = this.a;
                    if (iVar4 != null) {
                        iVar4.onError("11");
                        return;
                    }
                    return;
                }
            }
            if (linkStatus == 1) {
                i iVar5 = this.a;
                if (iVar5 != null) {
                    iVar5.onError(linkStatus + "");
                    return;
                }
                return;
            }
            i iVar6 = this.a;
            if (iVar6 != null) {
                iVar6.onError(linkStatus + "");
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            if (this.a != null) {
                if (TextUtils.equals(netException.getCode(), "50091")) {
                    this.a.onError(ah4.e(R.string.banned_opening_link_des));
                } else if (TextUtils.equals(netException.getCode(), "50092")) {
                    this.a.onError(ah4.e(R.string.controller_temporarily_banned));
                } else {
                    this.a.onError(netException.message);
                }
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkControl.java */
    public class e implements tf2 {
        public final /* synthetic */ BaseActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public e(BaseActivity baseActivity, String str, int i) {
            this.a = baseActivity;
            this.b = str;
            this.c = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(String str, int i, BaseActivity baseActivity) {
            uf2.v().C(this);
            dq2.this.G(str, i, baseActivity);
        }

        @Override // dc.tf2
        public void connectSuc() {
            BaseActivity baseActivity = this.a;
            if (baseActivity == null || baseActivity.isFinishing()) {
                return;
            }
            final BaseActivity baseActivity2 = this.a;
            final String str = this.b;
            final int i = this.c;
            baseActivity2.runOnMainThread(new Runnable() { // from class: dc.cq2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(str, i, baseActivity2);
                }
            });
        }

        @Override // dc.tf2
        public void disConnect() {
            uf2.v().C(this);
        }
    }

    /* compiled from: ControlLinkControl.java */
    public class f implements is3.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ BaseActivity c;

        public f(String str, int i, BaseActivity baseActivity) {
            this.a = str;
            this.b = i;
            this.c = baseActivity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            fg2.j().i();
            ig2.n().l(true);
            pb2.m().k();
            y12.c.a().t();
            if (PlayService.R) {
                EventBus.getDefault().post(new NotificationCloseEvent());
            }
            na2.m().v();
            String strI = WearUtils.y.i();
            if (!WearUtils.e1(strI) && !this.a.equals(strI)) {
                EventBus.getDefault().post(new CloseControlEvent(strI));
                c83.R1().I1();
            }
            dq2.this.n(this.a, this.b, this.c);
        }
    }

    /* compiled from: ControlLinkControl.java */
    public class g implements i {
        public final /* synthetic */ BaseActivity a;

        public g(BaseActivity baseActivity) {
            this.a = baseActivity;
        }

        @Override // dc.dq2.i
        public void a(ControlLinkBean controlLinkBean) {
            BaseActivity baseActivity = this.a;
            if (baseActivity != null) {
                baseActivity.dissDialog();
            }
            if (controlLinkBean.getLinkStatus() != 0) {
                if (controlLinkBean.getLinkStatus() == 1) {
                    dq2.this.o(ah4.e(R.string.notification_control_link_in_use), this.a);
                    return;
                } else {
                    dq2.this.o(ah4.e(R.string.control_link_expired), this.a);
                    return;
                }
            }
            Intent intent = new Intent(WearUtils.x, (Class<?>) ControlLinkChatActivity.class);
            intent.putExtra("userId", controlLinkBean.getCreator().getUserId());
            intent.putExtra("selfId", controlLinkBean.getSelfId());
            intent.putExtra("userBean", controlLinkBean);
            intent.putExtra("isJoiner", !controlLinkBean.getCreator().getUserId().equals(controlLinkBean.getSelfId()));
            intent.setFlags(268435456);
            WearUtils.x.startActivity(intent);
        }

        @Override // dc.dq2.i
        public void onError(String str) {
            BaseActivity baseActivity = this.a;
            if (baseActivity != null) {
                baseActivity.dissDialog();
            }
            if (str.equals("1")) {
                dq2.this.o(ah4.e(R.string.notification_control_link_in_use), this.a);
                return;
            }
            if (str.equals("2")) {
                dq2.this.o(ah4.e(R.string.control_link_expired), this.a);
            } else if (str.equals("11")) {
                dq2.this.B(ah4.e(R.string.cant_control_your_control_link), this.a);
            } else {
                sg3.l(str);
            }
        }
    }

    /* compiled from: ControlLinkControl.java */
    public class h implements Runnable {
        public final /* synthetic */ BaseActivity a;
        public final /* synthetic */ String b;

        /* compiled from: ControlLinkControl.java */
        public class a implements is3.d {
            public a(h hVar) {
            }

            @Override // dc.is3.d
            public void doConfirm() {
            }
        }

        public h(dq2 dq2Var, BaseActivity baseActivity, String str) {
            this.a = baseActivity;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BaseActivity baseActivity = this.a;
                if (baseActivity != null) {
                    baseActivity.dissDialog();
                }
                cs3.k(this.a, this.b, new a(this)).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: ControlLinkControl.java */
    public interface i {
        void a(ControlLinkBean controlLinkBean);

        void onError(String str);
    }

    public dq2() {
        new Handler(Looper.getMainLooper());
        this.g = new HashMap<>();
        this.h = new ie3();
        ek3 ek3Var = new ek3(1);
        this.f = ek3Var;
        ek3Var.a();
    }

    public static void p() {
        List<ControlLinkCommunMessage> listFindByAll = DaoUtils.getControlLinkCommunMessageDao().findByAll();
        if (listFindByAll == null || listFindByAll.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < listFindByAll.size(); i2++) {
            ControlLinkCommunMessage controlLinkCommunMessage = listFindByAll.get(i2);
            if (!TextUtils.isEmpty(controlLinkCommunMessage.getMsgData())) {
                controlLinkCommunMessage.syncDecryptBean();
                File file = null;
                if (ControlLinkCommunMessage.decrypt(controlLinkCommunMessage.getMsgData()) != null) {
                    int i3 = b.a[controlLinkCommunMessage.getMsgType().ordinal()];
                    if (i3 == 5) {
                        file = new File(new EntityPattern(controlLinkCommunMessage.getMsgData()).getLocalUrl());
                    } else if (i3 == 6) {
                        EntityAudio entityAudio = new EntityAudio(controlLinkCommunMessage.getMsgData());
                        if (entityAudio.getLocalUrl() != null) {
                            file = new File(entityAudio.getLocalUrl());
                        }
                    }
                }
                if (file != null && file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public static dq2 w() {
        if (j == null) {
            synchronized (dq2.class) {
                if (j == null) {
                    j = new dq2();
                }
            }
        }
        return j;
    }

    public void A(String str) {
        this.g.remove(str);
    }

    public final void B(String str, BaseActivity baseActivity) {
        baseActivity.parentHandler.post(new h(this, baseActivity, str));
    }

    public void C(DataEntityAbstract dataEntityAbstract, UserControlLink userControlLink) {
        ControlLinkCommunMessage controlLinkCommunMessage = new ControlLinkCommunMessage();
        controlLinkCommunMessage.setFromId(WearUtils.y.j());
        controlLinkCommunMessage.setToId(userControlLink.getId());
        String linkId = userControlLink.getLinkId();
        ControlLinkMsgXYBean controlLinkMsgXYBeanU = w().u(linkId);
        if (controlLinkMsgXYBeanU == null) {
            return;
        }
        controlLinkCommunMessage.sendEntity(dataEntityAbstract, controlLinkMsgXYBeanU.getX(), controlLinkMsgXYBeanU.getY());
        controlLinkCommunMessage.setId(WearUtils.E());
        controlLinkCommunMessage.setDateImType("control_link");
        controlLinkCommunMessage.setDateImTypeData(linkId);
        w().D(controlLinkCommunMessage, linkId);
    }

    public void D(ControlLinkCommunMessage controlLinkCommunMessage, String str) {
        String toId = controlLinkCommunMessage.getToId();
        String fromId = controlLinkCommunMessage.getFromId();
        xe3.a(i, "sendMsg:toId->" + toId + ",fromId->" + fromId);
        eq2.f().b(new ControlLinkMessageBean(WearUtils.E(), toId, 5, controlLinkCommunMessage.getMsgType(), controlLinkCommunMessage.getMsgSendData(), str, controlLinkCommunMessage.initExtJsonStr()), new c(controlLinkCommunMessage, str, toId, fromId));
    }

    public final void E(List<ControlLinkCommunMessage> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ControlLinkCommunMessage controlLinkCommunMessage : list) {
            controlLinkCommunMessage.setDataBean(controlLinkCommunMessage.syncDecryptBean());
            List<ControlLinkCommunMessage> listFindShowEmojiAnimMessages = DaoUtils.getControlLinkCommunMessageDao().findShowEmojiAnimMessages(controlLinkCommunMessage.getFromId(), controlLinkCommunMessage.getToId());
            if (listFindShowEmojiAnimMessages != null) {
                Iterator<ControlLinkCommunMessage> it = listFindShowEmojiAnimMessages.iterator();
                while (it.hasNext()) {
                    it.next().setShowEmojiAnim(false);
                }
            }
            DaoUtils.getControlLinkCommunMessageDao().update(listFindShowEmojiAnimMessages);
            if (controlLinkCommunMessage.getMsgType() == MessageType.chat) {
                controlLinkCommunMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.h.s(((EntityChat) controlLinkCommunMessage.getDataBean()).getText(), false)));
            }
        }
        Collections.sort(list, new o12());
        DaoUtils.getControlLinkCommunMessageDao().add(list);
        z(list.get(list.size() - 1).getMsgId());
    }

    public void F(String str, String str2, String str3) {
        this.g.put(str, new ControlLinkMsgXYBean(str2, str3));
    }

    public synchronized void G(String str, int i2, BaseActivity baseActivity) {
        if (uf2.v().q()) {
            l(str, i2, baseActivity);
        } else {
            uf2.v().o(new e(baseActivity, str, i2));
            uf2.v().B();
        }
    }

    public void H() {
        synchronized (this.a) {
            if (this.c.get()) {
                this.d.set(true);
                return;
            }
            this.c.set(true);
            ControlLinkCommunMessage controlLinkCommunMessageFindLastReceiveMessage = DaoUtils.getControlLinkCommunMessageDao().findLastReceiveMessage(WearUtils.y.j());
            eq2.f().b(new GetNewMessageDTORequest(WearUtils.E(), controlLinkCommunMessageFindLastReceiveMessage != null ? controlLinkCommunMessageFindLastReceiveMessage.getMsgId() : ""), new a());
        }
    }

    public void h(String str, mf2 mf2Var) {
        eq2.f().b(new CancelOccupyCountDownRequest(WearUtils.E(), str), mf2Var);
    }

    public void i(String str, mf2 mf2Var) {
        eq2.f().b(new CancelOccupyCountDownByJoinerRequest(WearUtils.E(), str), mf2Var);
    }

    public final void j(ControlLinkCommunMessage controlLinkCommunMessage) {
        if (controlLinkCommunMessage.getMsgType() != MessageType.chat || controlLinkCommunMessage.getDataBean() == null) {
            return;
        }
        controlLinkCommunMessage.setShowEmojiAnim(!TextUtils.isEmpty(this.h.s(((EntityChat) controlLinkCommunMessage.getDataBean()).getText(), false)));
        DaoUtils.getControlLinkCommunMessageDao().update((ControlLinkCommunMessageDao) controlLinkCommunMessage);
    }

    public void k(SendCommandRequest sendCommandRequest) {
        if (na2.m().d() || na2.m().e()) {
            return;
        }
        ToyCommandBean toyCommandBean = (ToyCommandBean) WearUtils.A.fromJson(sendCommandRequest.getToyCommandJson(), ToyCommandBean.class);
        LDRControl lDRControlO = na2.m().o();
        if (toyCommandBean.getCate().equals(EntityToy.ToyOPTType.all.toString())) {
            if (lDRControlO == null || !lDRControlO.e) {
                ToyBean all = toyCommandBean.getAll();
                int t = all.getT();
                if (toyCommandBean.getVersion() == 0) {
                    t = all.getV();
                }
                int i2 = t;
                int s = all.getS();
                if (toyCommandBean.getVersion() < 2) {
                    s = all.getV();
                }
                int i3 = s;
                if (all != null) {
                    na2.m().s(all.getV(), all.getR(), all.getP(), i2, i3, all.getF(), all.getD(), all.getPos());
                }
            } else {
                na2.m().y(null, toyCommandBean.getAll(), false);
                int v = toyCommandBean.getAll().getV();
                if (lDRControlO.h != null && !lDRControlO.c.isSupportLDRFillOrder()) {
                    Iterator<Toy> it = lDRControlO.a.iterator();
                    while (it.hasNext()) {
                        Toy next = it.next();
                        String toyFunction = Toy.getToyFunction(next.getType());
                        if (!WearUtils.e1(next.getType()) && next.isSupportV1V2()) {
                            toyFunction = PSOProgramService.VS_Key;
                        }
                        toyCommandBean.addLdrId(next.getAndUpdateDeviceId(), toyFunction, v);
                    }
                    toyCommandBean.setCate(EntityToy.ToyOPTType.id.toString());
                }
            }
        } else if (lDRControlO != null && lDRControlO.e) {
            if (toyCommandBean.getId() == null) {
                return;
            }
            for (Map.Entry<String, ToyBean> entry : toyCommandBean.getId().entrySet()) {
                na2.m().y(entry.getKey(), entry.getValue(), false);
            }
        }
        ou3.k(toyCommandBean, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:14:0x0021, B:18:0x0029, B:8:0x000f, B:10:0x0017), top: B:24:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void l(java.lang.String r2, int r3, com.wear.BaseActivity r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r4 == 0) goto Lf
            boolean r0 = r4.isFinishing()     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto Lf
            boolean r0 = r4.isDestroyed()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L1d
        Lf:
            androidx.fragment.app.FragmentActivity r0 = com.wear.util.MyApplication.H()     // Catch: java.lang.Throwable -> L2e
            boolean r0 = r0 instanceof com.wear.BaseActivity     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L1d
            androidx.fragment.app.FragmentActivity r4 = com.wear.util.MyApplication.H()     // Catch: java.lang.Throwable -> L2e
            com.wear.BaseActivity r4 = (com.wear.BaseActivity) r4     // Catch: java.lang.Throwable -> L2e
        L1d:
            if (r4 != 0) goto L21
            monitor-exit(r1)
            return
        L21:
            boolean r0 = com.wear.util.WearUtils.e1(r2)     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L29
            monitor-exit(r1)
            return
        L29:
            r1.m(r2, r3, r4)     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r1)
            return
        L2e:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.dq2.l(java.lang.String, int, com.wear.BaseActivity):void");
    }

    public synchronized void m(String str, int i2, BaseActivity baseActivity) {
        boolean zF = fg2.j().f();
        boolean zI = pb2.m().i();
        boolean zF2 = na2.m().f();
        MyApplication.v0(null);
        if (c83.R1().z() && !WearUtils.e1(c83.R1().S1()) && c83.R1().S1().equals(str)) {
            pj3.j(baseActivity, ControlLinkChatActivity.class, "linkId", str);
            return;
        }
        if (zF2 || zI || zF) {
            is3.b bVar = new is3.b(baseActivity);
            bVar.p(ah4.e(R.string.notification_control_link_conflict));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.d(new f(str, i2, baseActivity));
            cs3.h(bVar).show();
        } else {
            y12.c.a().t();
            if (PlayService.R) {
                EventBus.getDefault().post(new NotificationCloseEvent());
            }
            n(str, i2, baseActivity);
        }
    }

    public final void n(String str, int i2, BaseActivity baseActivity) {
        if (baseActivity != null) {
            baseActivity.showDialog();
        }
        w().r(str, i2, new g(baseActivity));
    }

    public final void o(String str, BaseActivity baseActivity) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT, str);
        pj3.g(baseActivity, ControlLinkEndActivity.class, bundle);
    }

    public void q(String str, String str2, long j2) {
        if (l22.n().l() == 3) {
            str2 = TtmlNode.TEXT_EMPHASIS_AUTO;
        }
        EndControlRequest endControlRequest = new EndControlRequest();
        endControlRequest.setLinkId(str);
        eq2.f().h(endControlRequest);
        String str3 = "endControlLink: linkid=" + str;
        HashMap map = new HashMap();
        map.put("reason", str2);
        map.put(TtmlNode.ATTR_ID, str);
        map.put("totaltime", Long.valueOf(j2));
        map.put("toy_mac", cu1.a(pc1.a));
        ye3.d("F0023", WearUtils.A.toJson(map));
        p();
        c83.R1().D1();
    }

    public void r(String str, int i2, i iVar) {
        HashMap map = new HashMap();
        map.put("linkId", str);
        tn2.x(WearUtils.x).i("/api/remote/controllink/info", map, new d(this, iVar, i2, str));
    }

    public void s(String str, mf2 mf2Var) {
        eq2.f().b(new GetControlLinkMsgRequest(WearUtils.E(), str), mf2Var);
    }

    public void t(String str, String str2, mf2 mf2Var, long j2) {
        QueryUserOnLineRequest queryUserOnLineRequest = new QueryUserOnLineRequest(WearUtils.E(), str2, str);
        if (j2 > 0) {
            eq2.f().c(queryUserOnLineRequest, mf2Var, j2);
        } else {
            eq2.f().b(queryUserOnLineRequest, mf2Var);
        }
    }

    public ControlLinkMsgXYBean u(String str) {
        return this.g.get(str);
    }

    public HashMap<String, ControlLinkMsgXYBean> v() {
        return this.g;
    }

    public boolean x(ControlLinkCommunMessage controlLinkCommunMessage) {
        if (MessageType.toy == controlLinkCommunMessage.getMsgType()) {
            return false;
        }
        if (Arrays.asList(MessageType.live, MessageType.sync, MessageType.video, MessageType.voice).contains(controlLinkCommunMessage.getMsgType())) {
            int i2 = b.a[controlLinkCommunMessage.getMsgType().ordinal()];
            if (i2 == 1) {
                EntityLive entityLive = (EntityLive) controlLinkCommunMessage.getDataBean();
                if (entityLive.getType().equals(EntityLive.LiveOPTType.cancel.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.end.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.reject.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.networkError.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.noAnswer.toString()) || entityLive.getType().equals(EntityLive.LiveOPTType.request.toString())) {
                }
            } else if (i2 == 2) {
                EntitySync entitySync = (EntitySync) controlLinkCommunMessage.getDataBean();
                if (entitySync.getType().equals(EntitySync.SyncOPTType.cancel.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.reject.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.end.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.networkError.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.noAnswer.toString()) || entitySync.getType().equals(EntitySync.SyncOPTType.request.toString())) {
                    return true;
                }
            } else if (i2 == 3) {
                EntityVideo entityVideo = (EntityVideo) controlLinkCommunMessage.getDataBean();
                if (entityVideo.getType().equals(EntityVideo.VideoOPTType.cancel.toString()) || entityVideo.getType().equals(EntityVideo.VideoOPTType.reject.toString()) || entityVideo.getType().equals(EntityVideo.VideoOPTType.end.toString()) || entityVideo.getType().equals(EntityVideo.VideoOPTType.networkError.toString()) || entityVideo.getType().equals(EntityVideo.VideoOPTType.noAnswer.toString())) {
                    return true;
                }
            } else if (i2 == 4) {
                EntityVoice entityVoice = (EntityVoice) controlLinkCommunMessage.getDataBean();
                if (entityVoice.getType().equals(EntityVoice.VoiceOPTType.cancel.toString()) || entityVoice.getType().equals(EntityVoice.VoiceOPTType.reject.toString()) || entityVoice.getType().equals(EntityVoice.VoiceOPTType.end.toString()) || entityVoice.getType().equals(EntityVoice.VoiceOPTType.networkError.toString()) || entityVoice.getType().equals(EntityVoice.VoiceOPTType.noAnswer.toString()) || entityVoice.getType().equals(EntityVideo.VideoOPTType.request.toString())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean y(ControlLinkCommunMessage controlLinkCommunMessage) {
        return (MessageType.toy == controlLinkCommunMessage.getMsgType() || Arrays.asList(MessageType.live, MessageType.sync, MessageType.video, MessageType.voice).contains(controlLinkCommunMessage.getMsgType())) ? false : true;
    }

    public void z(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        eq2.f().h(new ReadMsgDTORequest(WearUtils.E(), str));
    }
}
