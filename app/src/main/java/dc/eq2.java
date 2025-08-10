package dc;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.OpenAppBean;
import com.wear.bean.User;
import com.wear.bean.event.AddFriendsAckClEvent;
import com.wear.bean.event.AddFriendsReqTcEvent;
import com.wear.bean.event.ExpiredNotifyEvent;
import com.wear.bean.event.RefreshOpenfireFriendTc;
import com.wear.bean.socketio.chatBase.BaseChatResponseBean;
import com.wear.bean.socketio.chatBase.SendMsgACKResponse;
import com.wear.bean.socketio.controlLink.request.ControlLinkBaseRequest;
import com.wear.bean.socketio.controlLink.request.PageStatusRequest;
import com.wear.bean.socketio.controlLink.request.SendCommandRequest;
import com.wear.bean.socketio.controlLink.response.AddTimeResponse;
import com.wear.bean.socketio.controlLink.response.ControlLinkPermissionResponse;
import com.wear.bean.socketio.controlLink.response.EndControlReponse;
import com.wear.bean.socketio.controlLink.response.GetNewMessageACKResponse;
import com.wear.bean.socketio.controlLink.response.PageStatusResponse;
import com.wear.bean.socketio.controlLink.response.RefreshOccupyCountDownResponse;
import com.wear.main.longDistance.controllink.ControlLinkNewActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkEndActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.d83;
import io.agora.rtc2.internal.AudioRoutingController;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.SmackException;

/* compiled from: ControlLinkManagerImpl.java */
/* loaded from: classes3.dex */
public class eq2 implements tf2 {
    public static volatile eq2 d;
    public is3 b;
    public Handler a = new Handler(Looper.getMainLooper());
    public boolean c = true;

    /* compiled from: ControlLinkManagerImpl.java */
    public class a implements Runnable {
        public a(eq2 eq2Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MyApplication.U == null) {
                return;
            }
            String str = "handleNewTask: getCurrentActivity = " + MyApplication.U.data;
            OpenAppBean openAppBean = MyApplication.U;
            dq2.w().l(openAppBean.data, openAppBean.type, (BaseActivity) MyApplication.H());
        }
    }

    /* compiled from: ControlLinkManagerImpl.java */
    public class b implements Runnable {
        public final /* synthetic */ ControlLinkBean a;

        /* compiled from: ControlLinkManagerImpl.java */
        public class a implements Function1<Boolean, Unit> {
            public a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Boolean bool) {
                Intent intent = new Intent(WearUtils.x, (Class<?>) ControlLinkChatActivity.class);
                intent.putExtra("linkId", b.this.a.getLinkId());
                intent.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                FragmentActivity fragmentActivityH = MyApplication.H();
                fragmentActivityH.startActivity(intent);
                if (!(fragmentActivityH instanceof ControlLinkEndActivity)) {
                    return null;
                }
                fragmentActivityH.finish();
                return null;
            }
        }

        public b(ControlLinkBean controlLinkBean) {
            this.a = controlLinkBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity fragmentActivityH = MyApplication.H();
            if (fragmentActivityH == null || fragmentActivityH.isDestroyed() || fragmentActivityH.isFinishing()) {
                return;
            }
            if (fragmentActivityH instanceof ControlLinkNewActivity) {
                ((ControlLinkNewActivity) fragmentActivityH).H4();
            } else {
                l22.n().s(true, true);
            }
            eq2.this.d();
            d83.w().b0(fragmentActivityH, ah4.e(R.string.Notification_control_link_acitive), false, new a());
        }
    }

    /* compiled from: ControlLinkManagerImpl.java */
    public class c implements Runnable {
        public final /* synthetic */ RefreshOccupyCountDownResponse a;

        public c(eq2 eq2Var, RefreshOccupyCountDownResponse refreshOccupyCountDownResponse) {
            this.a = refreshOccupyCountDownResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != null) {
                String str = "msg=====" + this.a.toString();
            }
            EventBus.getDefault().post(this.a);
        }
    }

    /* compiled from: ControlLinkManagerImpl.java */
    public class d implements Runnable {
        public final /* synthetic */ ControlLinkPermissionResponse a;

        public d(eq2 eq2Var, ControlLinkPermissionResponse controlLinkPermissionResponse) {
            this.a = controlLinkPermissionResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            d83.w().W(this.a.getLinkPermissionType());
            d83.w().q(null);
            if (WearUtils.e1(this.a.getOperationType())) {
                return;
            }
            if (!this.a.getOperationType().equals(d83.c.request.name())) {
                if (d83.w().s() != null) {
                    d83.w().R();
                } else {
                    d83.w().O(d83.c.cancel);
                }
                d83.w().Z("", false);
                d83.w().M();
            } else if (d83.w().s() != null) {
                c83.R1().K2(d83.w().s().findViewById(R.id.actionbar), this.a.getLinkPermissionType());
            } else {
                d83.w().Z(this.a.getLinkPermissionType(), true);
            }
            c83.R1().o2();
        }
    }

    /* compiled from: ControlLinkManagerImpl.java */
    public class e implements Runnable {
        public final /* synthetic */ ControlLinkPermissionResponse a;

        public e(eq2 eq2Var, ControlLinkPermissionResponse controlLinkPermissionResponse) {
            this.a = controlLinkPermissionResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            d83.w().M();
            d83.w().q(this.a);
            if (WearUtils.e1(this.a.getOperationType())) {
                return;
            }
            if (this.a.getOperationType().equals(d83.c.accept.name())) {
                if (d83.w().s() != null) {
                    d83.w().s().n6(this.a.getLinkPermissionType().equals(d83.d.live_control.name()));
                    return;
                }
                return;
            }
            String operationType = this.a.getOperationType();
            d83.c cVar = d83.c.expired;
            if (operationType.equals(cVar.name())) {
                if (c83.R1().e2()) {
                    ye3.g("control_link_permission_cancel_click", "click", "control_link_permission_cancel", "button", "2", this.a.getLinkId(), JSON.toJSONString(WearUtils.x.G().m()));
                }
                if (d83.w().s() != null) {
                    d83.w().T();
                } else {
                    d83.w().O(cVar);
                }
                d83.w().Z("", false);
                return;
            }
            if (this.a.getOperationType().equals(d83.c.decline.name())) {
                d83.w().S();
                c83.R1().o2();
                return;
            }
            String operationType2 = this.a.getOperationType();
            d83.c cVar2 = d83.c.cancel;
            if (operationType2.equals(cVar2.name())) {
                if (d83.w().s() != null) {
                    d83.w().R();
                } else {
                    d83.w().O(cVar2);
                }
            }
        }
    }

    public static eq2 f() {
        if (d == null) {
            synchronized (eq2.class) {
                if (d == null) {
                    d = new eq2();
                }
            }
        }
        return d;
    }

    public void A(SendCommandRequest sendCommandRequest) {
        if (this.c) {
            if (!WearUtils.h1(dq2.w().v()) || db2.A().D()) {
                dq2.w().k(sendCommandRequest);
                c83.R1().z1();
            }
        }
    }

    public void a(AddTimeResponse addTimeResponse) {
        if (!addTimeResponse.isResult()) {
            sg3.h(R.string.control_link_add_time_failed);
            return;
        }
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH == null || !(fragmentActivityH instanceof ControlLinkNewActivity)) {
            return;
        }
        ((ControlLinkNewActivity) fragmentActivityH).H4();
    }

    public void b(rf2 rf2Var, mf2 mf2Var) {
        uf2.v().r(rf2Var, mf2Var);
    }

    public void c(rf2 rf2Var, mf2 mf2Var, long j) {
        uf2.v().s(rf2Var, mf2Var, j);
    }

    @Override // dc.tf2
    public void connectSuc() {
        if (MyApplication.H() != null && (MyApplication.H() instanceof ControlLinkChatActivity)) {
            dq2.w().H();
        }
        OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean != null) {
            int i = openAppBean.type;
            if ((i == 4 || i == 5) && !WearUtils.e1(openAppBean.data) && (MyApplication.H() instanceof BaseActivity)) {
                this.a.post(new a(this));
            }
        }
    }

    public void d() {
        try {
            is3 is3Var = this.b;
            if (is3Var != null) {
                is3Var.dismiss();
                this.b = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    public Activity e() {
        if (MyApplication.H() != null && (MyApplication.H() instanceof ControlLinkChatActivity)) {
            return (ControlLinkChatActivity) MyApplication.H();
        }
        return null;
    }

    public boolean g(String str, String str2) {
        return false;
    }

    public boolean h(pf2 pf2Var) {
        return uf2.v().E(pf2Var);
    }

    public void i(boolean z) {
        this.c = z;
    }

    public void j(EndControlReponse endControlReponse) {
        if (l22.n().l() == 0) {
            l22.n().y(endControlReponse.getEndPersonType());
        }
        if (MyApplication.H() != null) {
            l22.n().s(false, true);
        }
    }

    public void k(AddFriendsAckClEvent addFriendsAckClEvent) {
        EventBus.getDefault().post(addFriendsAckClEvent);
    }

    public void l(String str) {
    }

    public void m(ControlLinkPermissionResponse controlLinkPermissionResponse) {
        if (controlLinkPermissionResponse != null) {
            se0.f(new e(this, controlLinkPermissionResponse));
        }
    }

    public void n(ControlLinkPermissionResponse controlLinkPermissionResponse) {
        if (controlLinkPermissionResponse != null) {
            se0.g(new d(this, controlLinkPermissionResponse), 100L);
        }
    }

    public void o(ControlLinkBaseRequest controlLinkBaseRequest) {
        EventBus.getDefault().post(controlLinkBaseRequest);
    }

    public void p(RefreshOpenfireFriendTc refreshOpenfireFriendTc) {
        EventBus.getDefault().post(refreshOpenfireFriendTc);
        synchronized (new Object()) {
            try {
                try {
                    hu3.z(MyApplication.N()).a0();
                } catch (SmackException.NotConnectedException e2) {
                    e = e2;
                    throw new RuntimeException(e);
                } catch (SmackException.NotLoggedInException e3) {
                    e = e3;
                    throw new RuntimeException(e);
                }
            } finally {
            }
        }
    }

    public void q(AddFriendsReqTcEvent addFriendsReqTcEvent) {
        EventBus.getDefault().post(addFriendsReqTcEvent);
    }

    public void r(GetNewMessageACKResponse getNewMessageACKResponse) {
    }

    public void s(ControlLinkBean controlLinkBean) {
        WearUtils.z2();
        if (!WearUtils.x.f0()) {
            WearUtils.K1(false, null);
        } else if (og3.b(1) && og3.b(2)) {
            WearUtils.K1(false, null);
        }
        dq2.w().F(controlLinkBean.getLinkId(), controlLinkBean.getX(), controlLinkBean.getY());
        WearUtils.x.t(controlLinkBean.getLinkId());
        this.a.postDelayed(new b(controlLinkBean), 300L);
    }

    public void t() {
        EventBus.getDefault().post(new ExpiredNotifyEvent());
    }

    public void u(PageStatusResponse pageStatusResponse) {
        String str = (c83.R1().r() && (MyApplication.H() instanceof ControlLinkChatActivity)) ? "control_link" : "other";
        ArrayList arrayList = new ArrayList();
        arrayList.add(User.FEATURE_IS_SUPPORT_CONTROLLINK_FRIEND_REQUEST);
        arrayList.add(User.FEATURE_IS_SUPPORT_CONTROLLINK_PERMISSION_REQUEST);
        h(new PageStatusRequest(pageStatusResponse.getPepsiId(), str, new Gson().toJson(arrayList)));
    }

    public void v(BaseChatResponseBean baseChatResponseBean) {
    }

    public void w(BaseChatResponseBean baseChatResponseBean) {
        dq2.w().H();
    }

    public void x(RefreshOccupyCountDownResponse refreshOccupyCountDownResponse) {
        this.a.postDelayed(new c(this, refreshOccupyCountDownResponse), 100L);
    }

    public void y(BaseChatResponseBean baseChatResponseBean) {
    }

    public void z(SendMsgACKResponse sendMsgACKResponse) {
    }
}
