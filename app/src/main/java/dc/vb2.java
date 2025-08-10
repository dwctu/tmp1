package dc;

import com.wear.bean.event.ReCheckRoomStatusEvent;
import com.wear.bean.socketio.msg.response.ChangeLdrToyTypeResponse;
import com.wear.bean.socketio.msg.response.ChangeToSyncMasterResponse;
import com.wear.bean.socketio.msg.response.ClearExitPlayerResponse;
import com.wear.bean.socketio.msg.response.MasterLineStatusNotifyResponse;
import com.wear.bean.socketio.msg.response.PlayerAcceptRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveAllRejectRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveCancelRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveEndRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveLdrControlResponse;
import com.wear.bean.socketio.msg.response.ReceivePlayerRejectRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomBeControllerToyInfoResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomControllerToyInfoResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomRemoteControlResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomSyncToyResponse;
import com.wear.bean.socketio.msg.response.RoomReceiveSyncResponse;
import com.wear.bean.socketio.msg.response.UpdateSyncMasterResponse;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import org.greenrobot.eventbus.EventBus;

/* compiled from: GroupControlManagerImpl.java */
/* loaded from: classes3.dex */
public class vb2 implements tf2 {
    public static vb2 a;

    public vb2() {
        MyApplication myApplication = WearUtils.x;
    }

    public static vb2 b() {
        if (a == null) {
            synchronized (vb2.class) {
                if (a == null) {
                    a = new vb2();
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
        EventBus.getDefault().post(new ReCheckRoomStatusEvent());
    }

    public boolean d(pf2 pf2Var) {
        return uf2.v().E(pf2Var);
    }

    @Override // dc.tf2
    public void disConnect() {
    }

    public void e() {
    }

    public void f(ChangeLdrToyTypeResponse changeLdrToyTypeResponse) {
        ChatGroupControl.o1().Y0(changeLdrToyTypeResponse);
    }

    public void g(ChangeToSyncMasterResponse changeToSyncMasterResponse) {
        ChatGroupControl.o1().a1(changeToSyncMasterResponse);
    }

    public void h(ClearExitPlayerResponse clearExitPlayerResponse) {
        ChatGroupControl.o1().c1(clearExitPlayerResponse);
    }

    public void i() {
    }

    public void j() {
    }

    public void k(MasterLineStatusNotifyResponse masterLineStatusNotifyResponse) {
        ChatGroupControl.o1().n2(masterLineStatusNotifyResponse);
    }

    public void l(PlayerAcceptRoomSyncResponse playerAcceptRoomSyncResponse) {
        ChatGroupControl.o1().x2(playerAcceptRoomSyncResponse);
    }

    public void m(ReceiveAllRejectRoomSyncResponse receiveAllRejectRoomSyncResponse) {
        ChatGroupControl.o1().A2(receiveAllRejectRoomSyncResponse);
    }

    public void n(ReceiveCancelRoomSyncResponse receiveCancelRoomSyncResponse) {
        ChatGroupControl.o1().B2(receiveCancelRoomSyncResponse);
    }

    public void o(ReceiveEndRoomSyncResponse receiveEndRoomSyncResponse) {
        ChatGroupControl.o1().C2(receiveEndRoomSyncResponse);
    }

    public void p() {
    }

    public void q(ReceiveLdrControlResponse receiveLdrControlResponse) {
        ChatGroupControl.o1().D2(receiveLdrControlResponse);
    }

    public void r(ReceivePlayerRejectRoomSyncResponse receivePlayerRejectRoomSyncResponse) {
        ChatGroupControl.o1().E2(receivePlayerRejectRoomSyncResponse);
    }

    public void s(ReceiveRoomBeControllerToyInfoResponse receiveRoomBeControllerToyInfoResponse) {
        ChatGroupControl.o1().F2(receiveRoomBeControllerToyInfoResponse);
    }

    public void t(ReceiveRoomControllerToyInfoResponse receiveRoomControllerToyInfoResponse) {
        ChatGroupControl.o1().G2(receiveRoomControllerToyInfoResponse);
    }

    public void u(ReceiveRoomRemoteControlResponse receiveRoomRemoteControlResponse) {
        ChatGroupControl.o1().H2(receiveRoomRemoteControlResponse);
    }

    public void v(ReceiveRoomSyncToyResponse receiveRoomSyncToyResponse) {
        String str = "socketIoReceiveRoomSyncToy: " + receiveRoomSyncToyResponse.toString();
        ChatGroupControl.o1().I2(receiveRoomSyncToyResponse);
    }

    public void w(RoomReceiveSyncResponse roomReceiveSyncResponse) {
        ChatGroupControl.o1().N2(roomReceiveSyncResponse);
    }

    public void x() {
    }

    public void y(UpdateSyncMasterResponse updateSyncMasterResponse) {
        ChatGroupControl.o1().B3(updateSyncMasterResponse);
    }
}
