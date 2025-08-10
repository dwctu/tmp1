package dc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.wear.bean.socketio.msg.Order;
import com.wear.bean.socketio.msg.response.AckCreateMultiToOneInfoResponse;
import com.wear.bean.socketio.msg.response.DSAckPlayerJoinMultiToOneResponse;
import com.wear.bean.socketio.msg.response.DSMultiToOneIsEndResponse;
import com.wear.bean.socketio.msg.response.DSMultiToySelectChangeResponse;
import com.wear.bean.socketio.msg.response.DSPlayerListChangeResponse;
import com.wear.bean.socketio.msg.response.DSPlayerRefuseMultiToOneInviteResponse;
import com.wear.bean.socketio.msg.response.DSTargeterRefuseInviteResponse;
import com.wear.bean.socketio.msg.response.DSTargeterToyChangeResponse;
import com.wear.bean.socketio.msg.response.DSYouCatPlayingMultiToOneResponse;
import com.wear.bean.socketio.msg.response.DsMultiToOneIsStarNowResponse;
import com.wear.bean.socketio.msg.response.DsSomebodyCreateMultiToOneResponse;
import com.wear.bean.socketio.msg.response.MasterLineStatusNotifyResponse;
import com.wear.bean.socketio.msg.response.MultiToOneToyOrderResponse;
import com.wear.bean.socketio.msg.response.ReceiveMultiToOneControlInviteV2Response;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.HashMap;

/* compiled from: GroupDSManagerImpl.java */
/* loaded from: classes3.dex */
public class wb2 implements tf2 {
    public static volatile wb2 a;

    /* compiled from: GroupDSManagerImpl.java */
    public class a extends TypeReference<HashMap<String, Order>> {
        public a(wb2 wb2Var) {
        }
    }

    public wb2() {
        MyApplication myApplication = WearUtils.x;
    }

    public static wb2 b() {
        if (a == null) {
            synchronized (wb2.class) {
                if (a == null) {
                    a = new wb2();
                }
            }
        }
        return a;
    }

    public void a(rf2 rf2Var, mf2 mf2Var) {
        uf2.v().r(rf2Var, mf2Var);
    }

    public boolean c(String str, String str2) {
        return false;
    }

    @Override // dc.tf2
    public void connectSuc() {
    }

    public boolean d(pf2 pf2Var) {
        return uf2.v().E(pf2Var);
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    public void e(AckCreateMultiToOneInfoResponse ackCreateMultiToOneInfoResponse) {
    }

    public void f(ReceiveMultiToOneControlInviteV2Response receiveMultiToOneControlInviteV2Response) {
        ChatDSControl.r1().b2(receiveMultiToOneControlInviteV2Response);
    }

    public void g(DSAckPlayerJoinMultiToOneResponse dSAckPlayerJoinMultiToOneResponse) {
    }

    public void h(DSPlayerListChangeResponse dSPlayerListChangeResponse) {
        ChatDSControl.r1().j1(dSPlayerListChangeResponse, false);
    }

    public void i(DSPlayerListChangeResponse dSPlayerListChangeResponse) {
        ChatDSControl.r1().j1(dSPlayerListChangeResponse, true);
    }

    public void j(String str) {
    }

    public void k(DSPlayerListChangeResponse dSPlayerListChangeResponse) {
        ChatDSControl.r1().J1(dSPlayerListChangeResponse);
    }

    public void l(DSMultiToOneIsEndResponse dSMultiToOneIsEndResponse) {
        ChatDSControl.r1().S1(dSMultiToOneIsEndResponse);
    }

    public void m(DsMultiToOneIsStarNowResponse dsMultiToOneIsStarNowResponse) {
        ChatDSControl.r1().T1(dsMultiToOneIsStarNowResponse);
    }

    public void n(String str) {
        ChatDSControl.r1().f0((DSMultiToySelectChangeResponse) WearUtils.A.fromJson(str, DSMultiToySelectChangeResponse.class));
    }

    public void o(DSPlayerListChangeResponse dSPlayerListChangeResponse) {
        ChatDSControl.r1().X1(dSPlayerListChangeResponse);
    }

    public void p(DSPlayerRefuseMultiToOneInviteResponse dSPlayerRefuseMultiToOneInviteResponse) {
        ChatDSControl.r1().Y1(dSPlayerRefuseMultiToOneInviteResponse);
    }

    public void q(MultiToOneToyOrderResponse multiToOneToyOrderResponse) {
        ChatDSControl.r1().a2(multiToOneToyOrderResponse.getRoomId(), (HashMap) JSON.parseObject(multiToOneToyOrderResponse.getOrder(), new a(this), new Feature[0]));
        String str = "msg=======" + multiToOneToyOrderResponse.getOrder();
    }

    public void r(DsSomebodyCreateMultiToOneResponse dsSomebodyCreateMultiToOneResponse) {
        ChatDSControl.r1().B2(dsSomebodyCreateMultiToOneResponse);
    }

    public void s(MasterLineStatusNotifyResponse masterLineStatusNotifyResponse) {
        ChatDSControl.r1().F2(masterLineStatusNotifyResponse);
    }

    public void t(DSTargeterRefuseInviteResponse dSTargeterRefuseInviteResponse) {
        ChatDSControl.r1().G2(dSTargeterRefuseInviteResponse);
    }

    public void u(DSTargeterToyChangeResponse dSTargeterToyChangeResponse) {
        ChatDSControl.r1().H2(dSTargeterToyChangeResponse);
    }

    public void v(DSYouCatPlayingMultiToOneResponse dSYouCatPlayingMultiToOneResponse) {
        ChatDSControl.r1().C2(dSYouCatPlayingMultiToOneResponse);
    }
}
