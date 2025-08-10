package dc;

import com.alibaba.fastjson.JSON;
import com.wear.activity.orgySetting.OrgyControl;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.chat.NotifyClientOfflineBean;
import com.wear.bean.event.AddFriendsAckClEvent;
import com.wear.bean.event.AddFriendsReqTcEvent;
import com.wear.bean.event.RefreshOpenfireFriendTc;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.response.NtokenResponseBean;
import com.wear.bean.response.VibeWithMeBean;
import com.wear.bean.socketio.chatBase.BaseChatResponseBean;
import com.wear.bean.socketio.chatBase.SendMsgACKResponse;
import com.wear.bean.socketio.controlLink.request.ControlLinkBaseRequest;
import com.wear.bean.socketio.controlLink.request.SendCommandRequest;
import com.wear.bean.socketio.controlLink.response.AddTimeResponse;
import com.wear.bean.socketio.controlLink.response.ControlLinkPermissionResponse;
import com.wear.bean.socketio.controlLink.response.EndControlReponse;
import com.wear.bean.socketio.controlLink.response.GetNewMessageACKResponse;
import com.wear.bean.socketio.controlLink.response.PageStatusResponse;
import com.wear.bean.socketio.controlLink.response.RefreshOccupyCountDownResponse;
import com.wear.bean.socketio.date.request.AppUserToysBean;
import com.wear.bean.socketio.date.response.CreateSocketServerBean;
import com.wear.bean.socketio.date.response.ForumEngagementCancelDTOBean;
import com.wear.bean.socketio.date.response.ForumEngagementCheckNoticeDTOBean;
import com.wear.bean.socketio.date.response.ForumEngagementInfoDTOBean;
import com.wear.bean.socketio.date.response.ForumEngagementNoticeBean;
import com.wear.bean.socketio.date.response.ForumEngagementOverNoticeDTOBean;
import com.wear.bean.socketio.msg.response.AckCreateMultiToOneInfoResponse;
import com.wear.bean.socketio.msg.response.BeatSearchForPapersReturnResponse;
import com.wear.bean.socketio.msg.response.ChangeLdrToyTypeResponse;
import com.wear.bean.socketio.msg.response.ChangeToSyncMasterResponse;
import com.wear.bean.socketio.msg.response.ClearExitPlayerResponse;
import com.wear.bean.socketio.msg.response.DSAckPlayerJoinMultiToOneResponse;
import com.wear.bean.socketio.msg.response.DSMultiToOneIsEndResponse;
import com.wear.bean.socketio.msg.response.DSPlayerListChangeResponse;
import com.wear.bean.socketio.msg.response.DSPlayerRefuseMultiToOneInviteResponse;
import com.wear.bean.socketio.msg.response.DSTargeterRefuseInviteResponse;
import com.wear.bean.socketio.msg.response.DSTargeterToyChangeResponse;
import com.wear.bean.socketio.msg.response.DSYouCatPlayingMultiToOneResponse;
import com.wear.bean.socketio.msg.response.DsMultiToOneIsStarNowResponse;
import com.wear.bean.socketio.msg.response.DsSomebodyCreateMultiToOneResponse;
import com.wear.bean.socketio.msg.response.FrozenAccountResponse;
import com.wear.bean.socketio.msg.response.MasterLineStatusNotifyResponse;
import com.wear.bean.socketio.msg.response.MessageErrorResponse;
import com.wear.bean.socketio.msg.response.MultiToOneToyOrderResponse;
import com.wear.bean.socketio.msg.response.PlayerAcceptRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveAllRejectRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveCancelRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveEndRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveLdrControlResponse;
import com.wear.bean.socketio.msg.response.ReceiveMultiToOneControlInviteV2Response;
import com.wear.bean.socketio.msg.response.ReceivePlayerRejectRoomSyncResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomBeControllerToyInfoResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomControllerToyInfoResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomRemoteControlResponse;
import com.wear.bean.socketio.msg.response.ReceiveRoomSyncToyResponse;
import com.wear.bean.socketio.msg.response.RoomReceiveSyncResponse;
import com.wear.bean.socketio.msg.response.UpdateSyncMasterResponse;
import com.wear.bean.socketio.starAndvibrate.response.EndSyncVibeActivityTcResponse;
import com.wear.bean.socketio.starAndvibrate.response.ModelEndBroadcastEventResponse;
import com.wear.bean.socketio.starAndvibrate.response.ReportToyCommandDTOResponse;
import com.wear.bean.socketio.starAndvibrate.response.SyncVibeActivityInfoTcResponse;
import com.wear.bean.socketio.starAndvibrate.response.SyncVibeCommandTcResponse;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlChangeStatusRespone;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlCommandRespone;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlExitGameRespone;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlUpdateInfoRespone;
import com.wear.bean.socketio.timestamp.TimestampResponse;
import com.wear.bean.socketio.videoPattern.MPHeartbeatResponse;
import com.wear.bean.socketio.videoPattern.MPPlayMediaResponse;
import com.wear.bean.socketio.videoPattern.MPRemoteGetFileResponse;
import com.wear.bean.socketio.videoPattern.ModifyVideoPatternDTOResponse;
import com.wear.bean.socketio.videoPattern.StartPreviewModeDTOResponse;
import com.wear.bean.socketio.videoPattern.StopWatchVideoStatusDTOResponse;
import com.wear.bean.socketio.videoPattern.VideoProgressStatusDTOResponse;
import dc.pw3;

/* compiled from: SocketIoClientInitUtil.java */
/* loaded from: classes4.dex */
public final class rw3 {

    /* compiled from: SocketIoClientInitUtil.java */
    public class a implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ig2 b;

        public a(qw3 qw3Var, ig2 ig2Var) {
            this.a = qw3Var;
            this.b = ig2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("takcon_update_game_info_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("takcon_update_game_info_tc", objArr);
                if (this.a.a("takcon_update_game_info_tc", strE)) {
                    return;
                }
                this.b.Q((TipperCtrlUpdateInfoRespone) JSON.parseObject(strE, TipperCtrlUpdateInfoRespone.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class a0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public a0(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("mp_stop_media_pattern_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("mp_stop_media_pattern_tc", objArr);
                if (this.a.a("mp_stop_media_pattern_tc", strE)) {
                    return;
                }
                this.b.r(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class a1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public a1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("createRoomSync", objArr)) {
                    return;
                }
                String strE = this.a.e("createRoomSync", objArr);
                if (this.a.a("createRoomSync", strE) || this.b.c("createRoomSync", strE)) {
                    return;
                }
                this.b.i();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class a2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public a2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("MULTI_TO_ONE_IS_END", objArr)) {
                    return;
                }
                String strE = this.a.e("MULTI_TO_ONE_IS_END", objArr);
                if (this.a.a("MULTI_TO_ONE_IS_END", strE) || this.b.c("MULTI_TO_ONE_IS_END", strE)) {
                    return;
                }
                this.b.l((DSMultiToOneIsEndResponse) JSON.parseObject(strE, DSMultiToOneIsEndResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class a3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public a3(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("AppUserToysNoticeDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("AppUserToysNoticeDTO", objArr);
                if (this.a.a("AppUserToysNoticeDTO", strE) || this.b.F("AppUserToysNoticeDTO", strE)) {
                    return;
                }
                this.b.N((AppUserToysBean) JSON.parseObject(strE, AppUserToysBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class a4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public a4(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("toy_roulette_controller_reject_tc", objArr)) {
                    return;
                }
                if (this.a.a("toy_roulette_controller_reject_tc", this.a.e("toy_roulette_controller_reject_tc", objArr))) {
                    return;
                }
                this.b.e();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class b implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ig2 b;

        public b(qw3 qw3Var, ig2 ig2Var) {
            this.a = qw3Var;
            this.b = ig2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("takcon_change_game_status_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("takcon_change_game_status_tc", objArr);
                if (this.a.a("takcon_change_game_status_tc", strE)) {
                    return;
                }
                this.b.N((TipperCtrlChangeStatusRespone) JSON.parseObject(strE, TipperCtrlChangeStatusRespone.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class b0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public b0(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("mp_js_end_tc", objArr)) {
                    return;
                }
                if (this.a.a("mp_js_end_tc", this.a.e("mp_js_end_tc", objArr))) {
                    return;
                }
                this.b.j();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class b1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public b1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("roomReceiveSync", objArr)) {
                    return;
                }
                String strE = this.a.e("roomReceiveSync", objArr);
                if (this.a.a("roomReceiveSync", strE) || this.b.c("roomReceiveSync", strE)) {
                    return;
                }
                this.b.w((RoomReceiveSyncResponse) JSON.parseObject(strE, RoomReceiveSyncResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class b2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public b2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("PLAYER_LIST_CHANGE", objArr)) {
                    return;
                }
                String strE = this.a.e("PLAYER_LIST_CHANGE", objArr);
                if (this.a.a("PLAYER_LIST_CHANGE", strE) || this.b.c("PLAYER_LIST_CHANGE", strE)) {
                    return;
                }
                this.b.o((DSPlayerListChangeResponse) JSON.parseObject(strE, DSPlayerListChangeResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class b3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public b3(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("cl_someone_req_add_friend_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("cl_someone_req_add_friend_tc", objArr);
                if (this.a.a("cl_someone_req_add_friend_tc", strE) || this.b.g("cl_someone_req_add_friend_tc", strE)) {
                    return;
                }
                this.b.q((AddFriendsReqTcEvent) JSON.parseObject(strE, AddFriendsReqTcEvent.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class b4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public b4(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("toy_roulette_controller_accept_tc", objArr)) {
                    return;
                }
                if (this.a.a("toy_roulette_controller_accept_tc", this.a.e("toy_roulette_controller_accept_tc", objArr))) {
                    return;
                }
                this.b.d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class c implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ig2 b;

        public c(qw3 qw3Var, ig2 ig2Var) {
            this.a = qw3Var;
            this.b = ig2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("takcon_ack_scan_join_game_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("takcon_ack_scan_join_game_tc", objArr);
                if (this.a.a("takcon_ack_scan_join_game_tc", strE)) {
                    return;
                }
                this.b.M(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class c0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public c0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_new_msg_ts", objArr)) {
                    return;
                }
                String strE = this.a.e("im_new_msg_ts", objArr);
                if (this.a.a("im_new_msg_ts", strE)) {
                    return;
                }
                this.b.m(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class c1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public c1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receivePlayerRejectRoomSync", objArr)) {
                    return;
                }
                String strE = this.a.e("receivePlayerRejectRoomSync", objArr);
                if (this.a.a("receivePlayerRejectRoomSync", strE) || this.b.c("receivePlayerRejectRoomSync", strE)) {
                    return;
                }
                this.b.r((ReceivePlayerRejectRoomSyncResponse) JSON.parseObject(strE, ReceivePlayerRejectRoomSyncResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class c2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public c2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("TARGETER_TOY_CHANGE", objArr)) {
                    return;
                }
                String strE = this.a.e("TARGETER_TOY_CHANGE", objArr);
                if (this.a.a("TARGETER_TOY_CHANGE", strE) || this.b.c("TARGETER_TOY_CHANGE", strE)) {
                    return;
                }
                this.b.u((DSTargeterToyChangeResponse) JSON.parseObject(strE, DSTargeterToyChangeResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class c3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public c3(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ForumEngagementAgreeDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ForumEngagementAgreeDTO", objArr);
                if (this.a.a("ForumEngagementAgreeDTO", strE) || this.b.F("ForumEngagementAgreeDTO", strE)) {
                    return;
                }
                this.b.O((ForumEngagementNoticeBean) JSON.parseObject(strE, ForumEngagementNoticeBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class c4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public c4(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("toy_roulette_start_play_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("toy_roulette_start_play_tc", objArr);
                if (this.a.a("toy_roulette_start_play_tc", strE)) {
                    return;
                }
                this.b.n(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class d implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ig2 b;

        public d(qw3 qw3Var, ig2 ig2Var) {
            this.a = qw3Var;
            this.b = ig2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("takcon_ack_app_exit_game_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("takcon_ack_app_exit_game_tc", objArr);
                if (this.a.a("takcon_ack_app_exit_game_tc", strE)) {
                    return;
                }
                this.b.L(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class d0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public d0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_ack_send_msg_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_ack_send_msg_tc", objArr);
                if (this.a.a("im_ack_send_msg_tc", strE)) {
                    return;
                }
                this.b.i(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class d1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public d1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("cancelRoomSync", objArr)) {
                    return;
                }
                String strE = this.a.e("cancelRoomSync", objArr);
                if (this.a.a("cancelRoomSync", strE) || this.b.c("cancelRoomSync", strE)) {
                    return;
                }
                this.b.e();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class d2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public d2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("TARGETER_NET_WORK_NOTIFY", objArr)) {
                    return;
                }
                String strE = this.a.e("TARGETER_NET_WORK_NOTIFY", objArr);
                if (this.a.a("TARGETER_NET_WORK_NOTIFY", strE) || this.b.c("TARGETER_NET_WORK_NOTIFY", strE)) {
                    return;
                }
                this.b.s((MasterLineStatusNotifyResponse) JSON.parseObject(strE, MasterLineStatusNotifyResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class d3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public d3(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ForumEngagementOverNoticeDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ForumEngagementOverNoticeDTO", objArr);
                if (this.a.a("ForumEngagementOverNoticeDTO", strE) || this.b.F("ForumEngagementOverNoticeDTO", strE)) {
                    return;
                }
                this.b.V((ForumEngagementOverNoticeDTOBean) JSON.parseObject(strE, ForumEngagementOverNoticeDTOBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class d4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public d4(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("toy_roulette_controller_end_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("toy_roulette_controller_end_tc", objArr);
                if (this.a.a("toy_roulette_controller_end_tc", strE)) {
                    return;
                }
                this.b.g(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class e implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ig2 b;

        public e(qw3 qw3Var, ig2 ig2Var) {
            this.a = qw3Var;
            this.b = ig2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("takcon_exit_game_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("takcon_exit_game_tc", objArr);
                if (this.a.a("takcon_exit_game_tc", strE)) {
                    return;
                }
                this.b.O((TipperCtrlExitGameRespone) JSON.parseObject(strE, TipperCtrlExitGameRespone.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class e0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public e0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_msg_receive_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_msg_receive_tc", objArr);
                if (this.a.a("im_msg_receive_tc", strE)) {
                    return;
                }
                this.b.l(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class e1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public e1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("playerAcceptRoomSync", objArr)) {
                    return;
                }
                String strE = this.a.e("playerAcceptRoomSync", objArr);
                if (this.a.a("playerAcceptRoomSync", strE) || this.b.c("playerAcceptRoomSync", strE)) {
                    return;
                }
                this.b.l((PlayerAcceptRoomSyncResponse) JSON.parseObject(strE, PlayerAcceptRoomSyncResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class e2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public e2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("CURRENT_PLAYER_OFF_LINE", objArr)) {
                    return;
                }
                String strE = this.a.e("CURRENT_PLAYER_OFF_LINE", objArr);
                if (this.a.a("CURRENT_PLAYER_OFF_LINE", strE) || this.b.c("CURRENT_PLAYER_OFF_LINE", strE)) {
                    return;
                }
                this.b.h((DSPlayerListChangeResponse) JSON.parseObject(strE, DSPlayerListChangeResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class e3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public e3(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ForumEngagementDatingDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ForumEngagementDatingDTO", objArr);
                if (this.a.a("ForumEngagementDatingDTO", strE) || this.b.F("ForumEngagementDatingDTO", strE)) {
                    return;
                }
                this.b.R((NtokenResponseBean.Dating) JSON.parseObject(strE, NtokenResponseBean.Dating.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class e4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ hg2 b;

        public e4(qw3 qw3Var, hg2 hg2Var) {
            this.a = qw3Var;
            this.b = hg2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("syncVibeCommand_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("syncVibeCommand_tc", objArr);
                if (this.a.a("syncVibeCommand_tc", strE)) {
                    return;
                }
                this.b.A((SyncVibeCommandTcResponse) JSON.parseObject(strE, SyncVibeCommandTcResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class f implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ fg2 b;

        public f(qw3 qw3Var, fg2 fg2Var) {
            this.a = qw3Var;
            this.b = fg2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ReportToyCommandDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ReportToyCommandDTO", objArr);
                if (this.a.a("ReportToyCommandDTO", strE)) {
                    return;
                }
                this.b.u((ReportToyCommandDTOResponse) JSON.parseObject(strE, ReportToyCommandDTOResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class f0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public f0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_ack_msg_deal_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_ack_msg_deal_tc", objArr);
                if (this.a.a("im_ack_msg_deal_tc", strE)) {
                    return;
                }
                this.b.h(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class f1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public f1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveRoomRemoteControl", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveRoomRemoteControl", objArr);
                if (this.a.a("receiveRoomRemoteControl", strE) || this.b.c("receiveRoomRemoteControl", strE)) {
                    return;
                }
                this.b.u((ReceiveRoomRemoteControlResponse) JSON.parseObject(strE, ReceiveRoomRemoteControlResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class f2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public f2(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_you_must_refresh_control_link_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_you_must_refresh_control_link_tc", objArr);
                if (this.a.a("q_you_must_refresh_control_link_tc", strE) || this.b.g("q_you_must_refresh_control_link_tc", strE)) {
                    return;
                }
                this.b.o((ControlLinkBaseRequest) JSON.parseObject(strE, ControlLinkBaseRequest.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class f3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public f3(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ForumEngagementInfoDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ForumEngagementInfoDTO", objArr);
                if (this.a.a("ForumEngagementInfoDTO", strE) || this.b.F("ForumEngagementInfoDTO", strE)) {
                    return;
                }
                this.b.S((ForumEngagementInfoDTOBean) JSON.parseObject(strE, ForumEngagementInfoDTOBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class f4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ hg2 b;

        public f4(qw3 qw3Var, hg2 hg2Var) {
            this.a = qw3Var;
            this.b = hg2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("syncVibeActivityInfo_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("syncVibeActivityInfo_tc", objArr);
                if (this.a.a("syncVibeActivityInfo_tc", strE)) {
                    return;
                }
                this.b.z((SyncVibeActivityInfoTcResponse) JSON.parseObject(strE, SyncVibeActivityInfoTcResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class g implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ fg2 b;

        public g(qw3 qw3Var, fg2 fg2Var) {
            this.a = qw3Var;
            this.b = fg2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("modelEndBroadcastEvent", objArr)) {
                    return;
                }
                String strE = this.a.e("modelEndBroadcastEvent", objArr);
                if (this.a.a("modelEndBroadcastEvent", strE)) {
                    return;
                }
                this.b.t((ModelEndBroadcastEventResponse) JSON.parseObject(strE, ModelEndBroadcastEventResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class g0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public g0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_ack_send_im_msg_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_ack_send_im_msg_tc", objArr);
                if (this.a.a("q_ack_send_im_msg_tc", strE) || this.b.g("q_ack_send_im_msg_tc", strE)) {
                    return;
                }
                this.b.z((SendMsgACKResponse) JSON.parseObject(strE, SendMsgACKResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class g1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public g1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveGroupMemberState", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveGroupMemberState", objArr);
                if (this.a.a("receiveGroupMemberState", strE) || this.b.c("receiveGroupMemberState", strE)) {
                    return;
                }
                this.b.p();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class g2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public g2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("CURRENT_PLAYER_ON_LINE", objArr)) {
                    return;
                }
                String strE = this.a.e("CURRENT_PLAYER_ON_LINE", objArr);
                if (this.a.a("CURRENT_PLAYER_ON_LINE", strE) || this.b.c("CURRENT_PLAYER_ON_LINE", strE)) {
                    return;
                }
                this.b.i((DSPlayerListChangeResponse) JSON.parseObject(strE, DSPlayerListChangeResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class g3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public g3(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ForumEngagementOnRoomNoticeDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ForumEngagementOnRoomNoticeDTO", objArr);
                if (this.a.a("ForumEngagementOnRoomNoticeDTO", strE) || this.b.F("ForumEngagementOnRoomNoticeDTO", strE)) {
                    return;
                }
                this.b.U();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class g4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ hg2 b;

        public g4(qw3 qw3Var, hg2 hg2Var) {
            this.a = qw3Var;
            this.b = hg2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("endSyncVibeActivity_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("endSyncVibeActivity_tc", objArr);
                if (this.a.a("endSyncVibeActivity_tc", strE)) {
                    return;
                }
                this.b.y((EndSyncVibeActivityTcResponse) JSON.parseObject(strE, EndSyncVibeActivityTcResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class h implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ fg2 b;

        public h(qw3 qw3Var, fg2 fg2Var) {
            this.a = qw3Var;
            this.b = fg2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("joinVibrateWithMeAck", objArr)) {
                    return;
                }
                String strE = this.a.e("joinVibrateWithMeAck", objArr);
                if (this.a.a("joinVibrateWithMeAck", strE)) {
                    return;
                }
                this.b.s((VibeWithMeBean) JSON.parseObject(strE, VibeWithMeBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class h0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public h0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_signaling_req_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_signaling_req_tc", objArr);
                if (this.a.a("im_signaling_req_tc", strE)) {
                    return;
                }
                this.b.r(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class h1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public h1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveCancelRoomSync", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveCancelRoomSync", objArr);
                if (this.a.a("receiveCancelRoomSync", strE) || this.b.c("receiveCancelRoomSync", strE)) {
                    return;
                }
                this.b.n((ReceiveCancelRoomSyncResponse) JSON.parseObject(strE, ReceiveCancelRoomSyncResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class h2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public h2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("IS_TIME_TO_SOMEONE_CONTROL", objArr)) {
                    return;
                }
                String strE = this.a.e("IS_TIME_TO_SOMEONE_CONTROL", objArr);
                if (this.a.a("IS_TIME_TO_SOMEONE_CONTROL", strE) || this.b.c("IS_TIME_TO_SOMEONE_CONTROL", strE)) {
                    return;
                }
                this.b.k((DSPlayerListChangeResponse) JSON.parseObject(strE, DSPlayerListChangeResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class h3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public h3(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ForumEngagementCheckNoticeDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ForumEngagementCheckNoticeDTO", objArr);
                if (this.a.a("ForumEngagementCheckNoticeDTO", strE) || this.b.F("ForumEngagementCheckNoticeDTO", strE)) {
                    return;
                }
                this.b.Q((ForumEngagementCheckNoticeDTOBean) JSON.parseObject(strE, ForumEngagementCheckNoticeDTOBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class h4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ig2 b;

        public h4(qw3 qw3Var, ig2 ig2Var) {
            this.a = qw3Var;
            this.b = ig2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("takcon_toy_command_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("takcon_toy_command_tc", objArr);
                if (this.a.a("takcon_toy_command_tc", strE)) {
                    return;
                }
                this.b.P((TipperCtrlCommandRespone) JSON.parseObject(strE, TipperCtrlCommandRespone.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class i implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ fg2 b;

        public i(qw3 qw3Var, fg2 fg2Var) {
            this.a = qw3Var;
            this.b = fg2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("exitVibrateWithMeAck", objArr)) {
                    return;
                }
                String strE = this.a.e("exitVibrateWithMeAck", objArr);
                if (this.a.a("exitVibrateWithMeAck", strE)) {
                    return;
                }
                this.b.r(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class i0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public i0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_signaling_accept_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_signaling_accept_tc", objArr);
                if (this.a.a("im_signaling_accept_tc", strE)) {
                    return;
                }
                this.b.n(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class i1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public i1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveAllRejectRoomSync", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveAllRejectRoomSync", objArr);
                if (this.a.a("receiveAllRejectRoomSync", strE) || this.b.c("receiveAllRejectRoomSync", strE)) {
                    return;
                }
                this.b.m((ReceiveAllRejectRoomSyncResponse) JSON.parseObject(strE, ReceiveAllRejectRoomSyncResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class i2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public i2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("PLAYER_REFUSE_MULTI_TO_ONE_INVITE", objArr)) {
                    return;
                }
                String strE = this.a.e("PLAYER_REFUSE_MULTI_TO_ONE_INVITE", objArr);
                if (this.a.a("PLAYER_REFUSE_MULTI_TO_ONE_INVITE", strE) || this.b.c("PLAYER_REFUSE_MULTI_TO_ONE_INVITE", strE)) {
                    return;
                }
                this.b.p((DSPlayerRefuseMultiToOneInviteResponse) JSON.parseObject(strE, DSPlayerRefuseMultiToOneInviteResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class i3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ pb2 b;

        public i3(qw3 qw3Var, pb2 pb2Var) {
            this.a = qw3Var;
            this.b = pb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("control_change_type", objArr)) {
                    return;
                }
                String strE = this.a.e("control_change_type", objArr);
                if (this.a.a("control_change_type", strE) || this.b.u("control_change_type", strE)) {
                    return;
                }
                this.b.A(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class i4 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public i4(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("cl_please_refresh_long_time_control_link_list_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("cl_please_refresh_long_time_control_link_list_tc", objArr);
                if (this.a.a("cl_please_refresh_long_time_control_link_list_tc", strE) || this.b.g("cl_please_refresh_long_time_control_link_list_tc", strE)) {
                    return;
                }
                this.b.t();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class j implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ k32 b;

        public j(qw3 qw3Var, k32 k32Var) {
            this.a = qw3Var;
            this.b = k32Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ack_app_lan_set_info_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("ack_app_lan_set_info_tc", objArr);
                if (this.a.a("ack_app_lan_set_info_tc", strE)) {
                    return;
                }
                this.b.b((j32) JSON.parseObject(strE, j32.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class j0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public j0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_signaling_req_ack_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_signaling_req_ack_tc", objArr);
                if (this.a.a("im_signaling_req_ack_tc", strE)) {
                    return;
                }
                this.b.q(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class j1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public j1(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ack_query_user_on_line_info_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("ack_query_user_on_line_info_tc", objArr);
                if (this.a.a("ack_query_user_on_line_info_tc", strE) || this.b.g("ack_query_user_on_line_info_tc", strE)) {
                    return;
                }
                this.b.v((BaseChatResponseBean) JSON.parseObject(strE, BaseChatResponseBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class j2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public j2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("MULTI_TOYS_CHANGE_TOY_FUN", objArr)) {
                    return;
                }
                String strE = this.a.e("MULTI_TOYS_CHANGE_TOY_FUN", objArr);
                if (this.a.a("MULTI_TOYS_CHANGE_TOY_FUN", strE) || this.b.c("MULTI_TOYS_CHANGE_TOY_FUN", strE)) {
                    return;
                }
                this.b.n(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class j3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ pb2 b;

        public j3(qw3 qw3Var, pb2 pb2Var) {
            this.a = qw3Var;
            this.b = pb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("remote_control_line_up", objArr)) {
                    return;
                }
                String strE = this.a.e("remote_control_line_up", objArr);
                if (this.a.a("remote_control_line_up", strE) || this.b.u("remote_control_line_up", strE)) {
                    return;
                }
                this.b.C();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class k implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public k(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_notice_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_notice_tc", objArr);
                if (this.a.a("q_notice_tc", strE) || this.b.g("q_notice_tc", strE)) {
                    return;
                }
                this.b.s((ControlLinkBean) JSON.parseObject(strE, ControlLinkBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class k0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public k0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_signaling_cancel_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_signaling_cancel_tc", objArr);
                if (this.a.a("im_signaling_cancel_tc", strE)) {
                    return;
                }
                this.b.o(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class k1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public k1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveEndRoomSync", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveEndRoomSync", objArr);
                if (this.a.a("receiveEndRoomSync", strE) || this.b.c("receiveEndRoomSync", strE)) {
                    return;
                }
                this.b.o((ReceiveEndRoomSyncResponse) JSON.parseObject(strE, ReceiveEndRoomSyncResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class k2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public k2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("YOU_BE_CALLED_TARGETER", objArr)) {
                    return;
                }
                String strE = this.a.e("YOU_BE_CALLED_TARGETER", objArr);
                if (this.a.a("YOU_BE_CALLED_TARGETER", strE) || this.b.c("YOU_BE_CALLED_TARGETER", strE)) {
                    return;
                }
                this.b.f((ReceiveMultiToOneControlInviteV2Response) JSON.parseObject(strE, ReceiveMultiToOneControlInviteV2Response.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class k3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ pb2 b;

        public k3(qw3 qw3Var, pb2 pb2Var) {
            this.a = qw3Var;
            this.b = pb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("end_control_link_notice_cs", objArr)) {
                    return;
                }
                String strE = this.a.e("end_control_link_notice_cs", objArr);
                if (this.a.a("end_control_link_notice_cs", strE) || this.b.u("end_control_link_notice_cs", strE)) {
                    return;
                }
                this.b.B();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class l implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public l(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("AckSuccessSyncPatternDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("AckSuccessSyncPatternDTO", objArr);
                if (this.a.a("AckSuccessSyncPatternDTO", strE)) {
                    return;
                }
                this.b.g((BaseResponseBeanNew) JSON.parseObject(strE, BaseResponseBeanNew.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class l0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public l0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_signaling_reject_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_signaling_reject_tc", objArr);
                if (this.a.a("im_signaling_reject_tc", strE)) {
                    return;
                }
                this.b.p(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class l1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public l1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("clearExitPlayer", objArr)) {
                    return;
                }
                String strE = this.a.e("clearExitPlayer", objArr);
                if (this.a.a("clearExitPlayer", strE) || this.b.c("clearExitPlayer", strE)) {
                    return;
                }
                this.b.h((ClearExitPlayerResponse) JSON.parseObject(strE, ClearExitPlayerResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class l2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public l2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ACK_CREATE_MULTI_TO_ONE_INFO", objArr)) {
                    return;
                }
                String strE = this.a.e("ACK_CREATE_MULTI_TO_ONE_INFO", objArr);
                if (this.a.a("ACK_CREATE_MULTI_TO_ONE_INFO", strE) || this.b.c("ACK_CREATE_MULTI_TO_ONE_INFO", strE)) {
                    return;
                }
                this.b.e((AckCreateMultiToOneInfoResponse) JSON.parseObject(strE, AckCreateMultiToOneInfoResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class l3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ pb2 b;

        public l3(qw3 qw3Var, pb2 pb2Var) {
            this.a = qw3Var;
            this.b = pb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("remote_control_status", objArr)) {
                    return;
                }
                String strE = this.a.e("remote_control_status", objArr);
                if (this.a.a("remote_control_status", strE) || this.b.u("remote_control_status", strE)) {
                    return;
                }
                this.b.D(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class m implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public m(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("AckExitPatternSyncDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("AckExitPatternSyncDTO", objArr);
                if (this.a.a("AckExitPatternSyncDTO", strE)) {
                    return;
                }
                this.b.f((BaseResponseBeanNew) JSON.parseObject(strE, BaseResponseBeanNew.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class m0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public m0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_toy_order_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_toy_order_tc", objArr);
                if (this.a.a("im_toy_order_tc", strE)) {
                    return;
                }
                this.b.s(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class m1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public m1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("getGroupInfo", objArr)) {
                    return;
                }
                String strE = this.a.e("getGroupInfo", objArr);
                if (this.a.a("getGroupInfo", strE) || this.b.c("getGroupInfo", strE)) {
                    return;
                }
                this.b.j();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class m2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public m2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("TARGETER_REFUSE_INVITE", objArr)) {
                    return;
                }
                String strE = this.a.e("TARGETER_REFUSE_INVITE", objArr);
                if (this.a.a("TARGETER_REFUSE_INVITE", strE) || this.b.c("TARGETER_REFUSE_INVITE", strE)) {
                    return;
                }
                this.b.t((DSTargeterRefuseInviteResponse) JSON.parseObject(strE, DSTargeterRefuseInviteResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class m3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public m3(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("cl_please_refresh_openfire_friend_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("cl_please_refresh_openfire_friend_tc", objArr);
                if (this.a.a("cl_please_refresh_openfire_friend_tc", strE) || this.b.g("cl_please_refresh_openfire_friend_tc", strE)) {
                    return;
                }
                this.b.p((RefreshOpenfireFriendTc) JSON.parseObject(strE, RefreshOpenfireFriendTc.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class n implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public n(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("VideoProgressStatusDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("VideoProgressStatusDTO", objArr);
                if (this.a.a("VideoProgressStatusDTO", strE)) {
                    return;
                }
                this.b.h((VideoProgressStatusDTOResponse) JSON.parseObject(strE, VideoProgressStatusDTOResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class n0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public n0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_client_connect_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_client_connect_tc", objArr);
                if (this.a.a("im_client_connect_tc", strE)) {
                    return;
                }
                this.b.j(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class n1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public n1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveLdrControl", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveLdrControl", objArr);
                if (this.a.a("receiveLdrControl", strE) || this.b.c("receiveLdrControl", strE)) {
                    return;
                }
                this.b.q((ReceiveLdrControlResponse) JSON.parseObject(strE, ReceiveLdrControlResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class n2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public n2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("YOU_CAT_PLAYING_MULTI_TO_ONE", objArr)) {
                    return;
                }
                String strE = this.a.e("YOU_CAT_PLAYING_MULTI_TO_ONE", objArr);
                if (this.a.a("YOU_CAT_PLAYING_MULTI_TO_ONE", strE) || this.b.c("YOU_CAT_PLAYING_MULTI_TO_ONE", strE)) {
                    return;
                }
                this.b.v((DSYouCatPlayingMultiToOneResponse) JSON.parseObject(strE, DSYouCatPlayingMultiToOneResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class n3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ r32 b;

        public n3(qw3 qw3Var, r32 r32Var) {
            this.a = qw3Var;
            this.b = r32Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("CreateSocketServer", objArr)) {
                    return;
                }
                String strE = this.a.e("CreateSocketServer", objArr);
                if (this.a.a("CreateSocketServer", strE) || this.b.o("CreateSocketServer", strE)) {
                    return;
                }
                this.b.B((CreateSocketServerBean) JSON.parseObject(strE, CreateSocketServerBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class o implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public o(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("StopWatchVideoStatusDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("StopWatchVideoStatusDTO", objArr);
                if (this.a.a("StopWatchVideoStatusDTO", strE)) {
                    return;
                }
                this.b.s((StopWatchVideoStatusDTOResponse) JSON.parseObject(strE, StopWatchVideoStatusDTOResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class o0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public o0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("toy_roulette_client_panel_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("toy_roulette_client_panel_tc", objArr);
                if (this.a.a("toy_roulette_client_panel_tc", strE)) {
                    return;
                }
                this.b.y(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class o1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public o1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("changeToSyncMaster", objArr)) {
                    return;
                }
                String strE = this.a.e("changeToSyncMaster", objArr);
                if (this.a.a("changeToSyncMaster", strE) || this.b.c("changeToSyncMaster", strE)) {
                    return;
                }
                this.b.g((ChangeToSyncMasterResponse) JSON.parseObject(strE, ChangeToSyncMasterResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class o2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public o2(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("SERVER_FORWARD_TOY_ORDER", objArr)) {
                    return;
                }
                String strE = this.a.e("SERVER_FORWARD_TOY_ORDER", objArr);
                if (this.a.a("SERVER_FORWARD_TOY_ORDER", strE) || this.b.c("SERVER_FORWARD_TOY_ORDER", strE)) {
                    return;
                }
                this.b.q((MultiToOneToyOrderResponse) JSON.parseObject(strE, MultiToOneToyOrderResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class o3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ r32 b;

        public o3(qw3 qw3Var, r32 r32Var) {
            this.a = qw3Var;
            this.b = r32Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("BeginVRGame", objArr)) {
                    return;
                }
                String strE = this.a.e("BeginVRGame", objArr);
                if (this.a.a("BeginVRGame", strE) || this.b.o("BeginVRGame", strE)) {
                    return;
                }
                this.b.A(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class p implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public p(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("StartWatchVideoStatusDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("StartWatchVideoStatusDTO", objArr);
                if (this.a.a("StartWatchVideoStatusDTO", strE)) {
                    return;
                }
                this.b.q((VideoProgressStatusDTOResponse) JSON.parseObject(strE, VideoProgressStatusDTOResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class p0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public p0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("im_client_disconnect_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("im_client_disconnect_tc", objArr);
                if (this.a.a("im_client_disconnect_tc", strE)) {
                    return;
                }
                this.b.k((NotifyClientOfflineBean) JSON.parseObject(strE, NotifyClientOfflineBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class p1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public p1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("updateSyncMaster", objArr)) {
                    return;
                }
                String strE = this.a.e("updateSyncMaster", objArr);
                if (this.a.a("updateSyncMaster", strE) || this.b.c("updateSyncMaster", strE)) {
                    return;
                }
                this.b.y((UpdateSyncMasterResponse) JSON.parseObject(strE, UpdateSyncMasterResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class p2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ zb2 b;

        public p2(qw3 qw3Var, zb2 zb2Var) {
            this.a = qw3Var;
            this.b = zb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("xmppStatus", objArr)) {
                    return;
                }
                String strE = this.a.e("xmppStatus", objArr);
                if (this.a.a("xmppStatus", strE) || this.b.o0("xmppStatus", strE)) {
                    return;
                }
                this.b.c1(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class p3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ r32 b;

        public p3(qw3 qw3Var, r32 r32Var) {
            this.a = qw3Var;
            this.b = r32Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("EndVRGame", objArr)) {
                    return;
                }
                String strE = this.a.e("EndVRGame", objArr);
                if (this.a.a("EndVRGame", strE) || this.b.o("EndVRGame", strE)) {
                    return;
                }
                this.b.C(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class q implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public q(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("PcExitPatternSyncDTO", objArr)) {
                    return;
                }
                if (this.a.a("PcExitPatternSyncDTO", this.a.e("PcExitPatternSyncDTO", objArr))) {
                    return;
                }
                this.b.m();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class q0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ft2 b;

        public q0(qw3 qw3Var, ft2 ft2Var) {
            this.a = qw3Var;
            this.b = ft2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("toy_roulette_toy_update_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("toy_roulette_toy_update_tc", objArr);
                if (this.a.a("toy_roulette_toy_update_tc", strE)) {
                    return;
                }
                this.b.z(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class q1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public q1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveRoomSyncToy", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveRoomSyncToy", objArr);
                if (this.a.a("receiveRoomSyncToy", strE) || this.b.c("receiveRoomSyncToy", strE)) {
                    return;
                }
                this.b.v((ReceiveRoomSyncToyResponse) JSON.parseObject(strE, ReceiveRoomSyncToyResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class q2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public q2(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ack_cl_add_friend_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("ack_cl_add_friend_tc", objArr);
                if (this.a.a("ack_cl_add_friend_tc", strE) || this.b.g("ack_cl_add_friend_tc", strE)) {
                    return;
                }
                this.b.k((AddFriendsAckClEvent) JSON.parseObject(strE, AddFriendsAckClEvent.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class q3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ r32 b;

        public q3(qw3 qw3Var, r32 r32Var) {
            this.a = qw3Var;
            this.b = r32Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("SignOffVR", objArr)) {
                    return;
                }
                String strE = this.a.e("SignOffVR", objArr);
                if (this.a.a("SignOffVR", strE) || this.b.o("SignOffVR", strE)) {
                    return;
                }
                this.b.D();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class r implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public r(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("StartPreviewModeDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("StartPreviewModeDTO", objArr);
                if (this.a.a("StartPreviewModeDTO", strE)) {
                    return;
                }
                this.b.p((StartPreviewModeDTOResponse) JSON.parseObject(strE, StartPreviewModeDTOResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class r0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public r0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_you_have_some_new_im_msg_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_you_have_some_new_im_msg_tc", objArr);
                if (this.a.a("q_you_have_some_new_im_msg_tc", strE) || this.b.g("q_you_have_some_new_im_msg_tc", strE)) {
                    return;
                }
                this.b.w((BaseChatResponseBean) JSON.parseObject(strE, BaseChatResponseBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class r1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public r1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("setSyncMaster", objArr)) {
                    return;
                }
                String strE = this.a.e("setSyncMaster", objArr);
                if (this.a.a("setSyncMaster", strE) || this.b.c("setSyncMaster", strE)) {
                    return;
                }
                this.b.x();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class r2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ zb2 b;

        public r2(qw3 qw3Var, zb2 zb2Var) {
            this.a = qw3Var;
            this.b = zb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("xmpp", objArr)) {
                    return;
                }
                String strE = this.a.e("xmpp", objArr);
                if (this.a.a("xmpp", strE) || this.b.o0("xmpp", strE)) {
                    return;
                }
                this.b.a1(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class r3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ OrgyControl b;

        public r3(qw3 qw3Var, OrgyControl orgyControl) {
            this.a = qw3Var;
            this.b = orgyControl;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b(SyncWsProtocol.CONTROL_ACTIVITY_COMMAND_TYPE_KEY, objArr)) {
                    return;
                }
                String strE = this.a.e(SyncWsProtocol.CONTROL_ACTIVITY_COMMAND_TYPE_KEY, objArr);
                if (this.a.a(SyncWsProtocol.CONTROL_ACTIVITY_COMMAND_TYPE_KEY, strE)) {
                    return;
                }
                this.b.socketIoReportToyCommandDTO(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class s implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public s(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ModifyVideoPatternDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ModifyVideoPatternDTO", objArr);
                if (this.a.a("ModifyVideoPatternDTO", strE)) {
                    return;
                }
                this.b.i((ModifyVideoPatternDTOResponse) JSON.parseObject(strE, ModifyVideoPatternDTOResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class s0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public s0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_command_link_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_command_link_tc", objArr);
                if (this.a.a("q_command_link_tc", strE) || this.b.g("q_command_link_tc", strE)) {
                    return;
                }
                this.b.A((SendCommandRequest) JSON.parseObject(strE, SendCommandRequest.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class s1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public s1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveRoomBeControllerToyInfo", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveRoomBeControllerToyInfo", objArr);
                if (this.a.a("receiveRoomBeControllerToyInfo", strE) || this.b.c("receiveRoomBeControllerToyInfo", strE)) {
                    return;
                }
                this.b.s((ReceiveRoomBeControllerToyInfoResponse) JSON.parseObject(strE, ReceiveRoomBeControllerToyInfoResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class s2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ zb2 b;

        public s2(qw3 qw3Var, zb2 zb2Var) {
            this.a = qw3Var;
            this.b = zb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("xmppReceipt", objArr)) {
                    return;
                }
                String strE = this.a.e("xmppReceipt", objArr);
                if (this.a.a("xmppReceipt", strE) || this.b.o0("xmppReceipt", strE)) {
                    return;
                }
                this.b.b1(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class s3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public s3(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("global_server_timestamp_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("global_server_timestamp_tc", objArr);
                if (this.a.a("global_server_timestamp_tc", strE)) {
                    return;
                }
                this.b.m((TimestampResponse) JSON.parseObject(strE, TimestampResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class t implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public t(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("RetrySyncPatternDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("RetrySyncPatternDTO", objArr);
                if (this.a.a("RetrySyncPatternDTO", strE)) {
                    return;
                }
                this.b.o((ModifyVideoPatternDTOResponse) JSON.parseObject(strE, ModifyVideoPatternDTOResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class t0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public t0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_refresh_occupy_countdown_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_refresh_occupy_countdown_tc", objArr);
                if (this.a.a("q_refresh_occupy_countdown_tc", strE) || this.b.g("q_refresh_occupy_countdown_tc", strE)) {
                    return;
                }
                this.b.x((RefreshOccupyCountDownResponse) JSON.parseObject(strE, RefreshOccupyCountDownResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class t1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public t1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("receiveRoomControllerToyInfo", objArr)) {
                    return;
                }
                String strE = this.a.e("receiveRoomControllerToyInfo", objArr);
                if (this.a.a("receiveRoomControllerToyInfo", strE) || this.b.c("receiveRoomControllerToyInfo", strE)) {
                    return;
                }
                this.b.t((ReceiveRoomControllerToyInfoResponse) JSON.parseObject(strE, ReceiveRoomControllerToyInfoResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class t2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ zb2 b;

        public t2(qw3 qw3Var, zb2 zb2Var) {
            this.a = qw3Var;
            this.b = zb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("SOCKET_IO_GLOBAL_MSG", objArr)) {
                    return;
                }
                String strE = this.a.e("SOCKET_IO_GLOBAL_MSG", objArr);
                if (this.a.a("SOCKET_IO_GLOBAL_MSG", strE) || this.b.o0("SOCKET_IO_GLOBAL_MSG", strE)) {
                    return;
                }
                this.b.a((MessageErrorResponse) JSON.parseObject(strE, MessageErrorResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class t3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public t3(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("please_reconnect_date_socket_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("please_reconnect_date_socket_tc", objArr);
                if (this.a.a("please_reconnect_date_socket_tc", strE)) {
                    return;
                }
                this.b.l(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class u implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public u(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ACK_RemoteEditorRelationDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ACK_RemoteEditorRelationDTO", objArr);
                if (this.a.a("ACK_RemoteEditorRelationDTO", strE)) {
                    return;
                }
                this.b.e(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class u0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public u0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ack_cl_add_control_link_play_time_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("ack_cl_add_control_link_play_time_tc", objArr);
                if (this.a.a("ack_cl_add_control_link_play_time_tc", strE) || this.b.g("ack_cl_add_control_link_play_time_tc", strE)) {
                    return;
                }
                this.b.a((AddTimeResponse) JSON.parseObject(strE, AddTimeResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class u1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public u1(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("which_app_page_open_now_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("which_app_page_open_now_tc", objArr);
                if (this.a.a("which_app_page_open_now_tc", strE) || this.b.g("which_app_page_open_now_tc", strE)) {
                    return;
                }
                this.b.u((PageStatusResponse) JSON.parseObject(strE, PageStatusResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class u2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ zb2 b;

        public u2(qw3 qw3Var, zb2 zb2Var) {
            this.a = qw3Var;
            this.b = zb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("beta_search_for_papers", objArr)) {
                    return;
                }
                String strE = this.a.e("beta_search_for_papers", objArr);
                if (this.a.a("beta_search_for_papers", strE) || this.b.o0("beta_search_for_papers", strE)) {
                    return;
                }
                this.b.N0((BeatSearchForPapersReturnResponse) JSON.parseObject(strE, BeatSearchForPapersReturnResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class u3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public u3(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("roster_had_changed_email_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("roster_had_changed_email_tc", objArr);
                if (this.a.a("roster_had_changed_email_tc", strE)) {
                    return;
                }
                this.b.o(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class v implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public v(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_end_control_link_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_end_control_link_tc", objArr);
                if (this.a.a("q_end_control_link_tc", strE) || this.b.g("q_end_control_link_tc", strE)) {
                    return;
                }
                this.b.j((EndControlReponse) JSON.parseObject(strE, EndControlReponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class v0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public v0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_query_control_info_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_query_control_info_tc", objArr);
                if (this.a.a("q_query_control_info_tc", strE) || this.b.g("q_query_control_info_tc", strE)) {
                    return;
                }
                this.b.l(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class v1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public v1(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("changeLdrToyType", objArr)) {
                    return;
                }
                String strE = this.a.e("changeLdrToyType", objArr);
                if (this.a.a("changeLdrToyType", strE) || this.b.c("changeLdrToyType", strE)) {
                    return;
                }
                this.b.f((ChangeLdrToyTypeResponse) JSON.parseObject(strE, ChangeLdrToyTypeResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class v2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ zb2 b;

        public v2(qw3 qw3Var, zb2 zb2Var) {
            this.a = qw3Var;
            this.b = zb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("remote_account_had_been_frozen_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("remote_account_had_been_frozen_tc", objArr);
                if (this.a.a("remote_account_had_been_frozen_tc", strE) || this.b.o0("remote_account_had_been_frozen_tc", strE)) {
                    return;
                }
                this.b.n0((FrozenAccountResponse) JSON.parseObject(strE, FrozenAccountResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class v3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public v3(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("chatgpt_create_pattern_session_task_is_end_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("chatgpt_create_pattern_session_task_is_end_tc", objArr);
                if (this.a.a("chatgpt_create_pattern_session_task_is_end_tc", strE)) {
                    return;
                }
                this.b.b(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class w implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public w(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("mp_ack_remote_connect_to_js_tc", objArr)) {
                    return;
                }
                if (this.a.a("mp_ack_remote_connect_to_js_tc", this.a.e("mp_ack_remote_connect_to_js_tc", objArr))) {
                    return;
                }
                this.b.d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class w0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public w0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("cl_control_permission_notification_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("cl_control_permission_notification_tc", objArr);
                if (this.a.a("cl_control_permission_notification_tc", strE) || this.b.g("cl_control_permission_notification_tc", strE)) {
                    return;
                }
                this.b.n((ControlLinkPermissionResponse) JSON.parseObject(strE, ControlLinkPermissionResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class w1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public w1(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("SOMEBODY_CREATE_MULTI_TO_ONE", objArr)) {
                    return;
                }
                String strE = this.a.e("SOMEBODY_CREATE_MULTI_TO_ONE", objArr);
                if (this.a.a("SOMEBODY_CREATE_MULTI_TO_ONE", strE) || this.b.c("SOMEBODY_CREATE_MULTI_TO_ONE", strE)) {
                    return;
                }
                this.b.r((DsSomebodyCreateMultiToOneResponse) JSON.parseObject(strE, DsSomebodyCreateMultiToOneResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class w2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public w2(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("reportUserStatus", objArr)) {
                    return;
                }
                String strE = this.a.e("reportUserStatus", objArr);
                if (this.a.a("reportUserStatus", strE) || this.b.F("reportUserStatus", strE)) {
                    return;
                }
                this.b.X();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class w3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public w3(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("chatgpt_create_audiobook_session_task_is_end_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("chatgpt_create_audiobook_session_task_is_end_tc", objArr);
                if (this.a.a("chatgpt_create_audiobook_session_task_is_end_tc", strE)) {
                    return;
                }
                this.b.c(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class x implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public x(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("mp_from_js_heartbeat_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("mp_from_js_heartbeat_tc", objArr);
                if (this.a.a("mp_from_js_heartbeat_tc", strE)) {
                    return;
                }
                this.b.k((MPHeartbeatResponse) JSON.parseObject(strE, MPHeartbeatResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class x0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public x0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("cl_control_permission_response_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("cl_control_permission_response_tc", objArr);
                if (this.a.a("cl_control_permission_response_tc", strE) || this.b.g("cl_control_permission_response_tc", strE)) {
                    return;
                }
                this.b.m((ControlLinkPermissionResponse) JSON.parseObject(strE, ControlLinkPermissionResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class x1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public x1(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("MULTI_TO_ONE_IS_STAR_NOW", objArr)) {
                    return;
                }
                String strE = this.a.e("MULTI_TO_ONE_IS_STAR_NOW", objArr);
                if (this.a.a("MULTI_TO_ONE_IS_STAR_NOW", strE) || this.b.c("MULTI_TO_ONE_IS_STAR_NOW", strE)) {
                    return;
                }
                this.b.m((DsMultiToOneIsStarNowResponse) JSON.parseObject(strE, DsMultiToOneIsStarNowResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class x2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public x2(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("app_user_banned_offline", objArr)) {
                    return;
                }
                String strE = this.a.e("app_user_banned_offline", objArr);
                if (this.a.a("app_user_banned_offline", strE) || this.b.F("app_user_banned_offline", strE)) {
                    return;
                }
                this.b.W(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class x3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public x3(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_ready_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_ready_tc", objArr);
                if (this.a.a("q_ready_tc", strE) || this.b.g("q_ready_tc", strE)) {
                    return;
                }
                this.b.y((BaseChatResponseBean) JSON.parseObject(strE, BaseChatResponseBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class y implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public y(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("mp_from_js_api_pattern_file_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("mp_from_js_api_pattern_file_tc", objArr);
                if (this.a.a("mp_from_js_api_pattern_file_tc", strE)) {
                    return;
                }
                this.b.l((MPRemoteGetFileResponse) JSON.parseObject(strE, MPRemoteGetFileResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class y0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ eq2 b;

        public y0(qw3 qw3Var, eq2 eq2Var) {
            this.a = qw3Var;
            this.b = eq2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("q_ack_user_new_msg_list_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("q_ack_user_new_msg_list_tc", objArr);
                if (this.a.a("q_ack_user_new_msg_list_tc", strE) || this.b.g("q_ack_user_new_msg_list_tc", strE)) {
                    return;
                }
                this.b.r((GetNewMessageACKResponse) JSON.parseObject(strE, GetNewMessageACKResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class y1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public y1(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ACK_PLAYER_JOIN_MULTI_TO_ONE", objArr)) {
                    return;
                }
                String strE = this.a.e("ACK_PLAYER_JOIN_MULTI_TO_ONE", objArr);
                if (this.a.a("ACK_PLAYER_JOIN_MULTI_TO_ONE", strE) || this.b.c("ACK_PLAYER_JOIN_MULTI_TO_ONE", strE)) {
                    return;
                }
                this.b.g((DSAckPlayerJoinMultiToOneResponse) JSON.parseObject(strE, DSAckPlayerJoinMultiToOneResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class y2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public y2(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ForumEngagementNoticeDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ForumEngagementNoticeDTO", objArr);
                if (this.a.a("ForumEngagementNoticeDTO", strE) || this.b.F("ForumEngagementNoticeDTO", strE)) {
                    return;
                }
                this.b.T((ForumEngagementNoticeBean) JSON.parseObject(strE, ForumEngagementNoticeBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class y3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public y3(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("this_account_change_email_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("this_account_change_email_tc", objArr);
                if (this.a.a("this_account_change_email_tc", strE)) {
                    return;
                }
                this.b.a(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class z implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ nk2 b;

        public z(qw3 qw3Var, nk2 nk2Var) {
            this.a = qw3Var;
            this.b = nk2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("mp_play_media_pattern_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("mp_play_media_pattern_tc", objArr);
                if (this.a.a("mp_play_media_pattern_tc", strE)) {
                    return;
                }
                this.b.n((MPPlayMediaResponse) JSON.parseObject(strE, MPPlayMediaResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class z0 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ vb2 b;

        public z0(qw3 qw3Var, vb2 vb2Var) {
            this.a = qw3Var;
            this.b = vb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("masterOnLineStatusNotify", objArr)) {
                    return;
                }
                String strE = this.a.e("masterOnLineStatusNotify", objArr);
                if (this.a.a("masterOnLineStatusNotify", strE) || this.b.c("masterOnLineStatusNotify", strE)) {
                    return;
                }
                this.b.k((MasterLineStatusNotifyResponse) JSON.parseObject(strE, MasterLineStatusNotifyResponse.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class z1 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ wb2 b;

        public z1(qw3 qw3Var, wb2 wb2Var) {
            this.a = qw3Var;
            this.b = wb2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("getGroupInfoV2", objArr)) {
                    return;
                }
                String strE = this.a.e("getGroupInfoV2", objArr);
                if (this.a.a("getGroupInfoV2", strE) || this.b.c("getGroupInfoV2", strE)) {
                    return;
                }
                this.b.j(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class z2 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ ob2 b;

        public z2(qw3 qw3Var, ob2 ob2Var) {
            this.a = qw3Var;
            this.b = ob2Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("ForumEngagementCancelDTO", objArr)) {
                    return;
                }
                String strE = this.a.e("ForumEngagementCancelDTO", objArr);
                if (this.a.a("ForumEngagementCancelDTO", strE) || this.b.F("ForumEngagementCancelDTO", strE)) {
                    return;
                }
                this.b.P((ForumEngagementCancelDTOBean) JSON.parseObject(strE, ForumEngagementCancelDTOBean.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: SocketIoClientInitUtil.java */
    public class z3 implements pw3.a {
        public final /* synthetic */ qw3 a;
        public final /* synthetic */ e42 b;

        public z3(qw3 qw3Var, e42 e42Var) {
            this.a = qw3Var;
            this.b = e42Var;
        }

        @Override // dc.pw3.a
        public void call(Object[] objArr) {
            try {
                if (this.a.b("toy_roulette_find_match_tc", objArr)) {
                    return;
                }
                String strE = this.a.e("toy_roulette_find_match_tc", objArr);
                if (this.a.a("toy_roulette_find_match_tc", strE)) {
                    return;
                }
                this.b.h(strE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(qw3 qw3Var, OrgyControl orgyControl) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (orgyControl == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d(SyncWsProtocol.CONTROL_ACTIVITY_COMMAND_TYPE_KEY, new r3(qw3Var, orgyControl));
    }

    public static void b(qw3 qw3Var, k32 k32Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (k32Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("ack_app_lan_set_info_tc", new j(qw3Var, k32Var));
    }

    public static void c(qw3 qw3Var, r32 r32Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (r32Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("CreateSocketServer", new n3(qw3Var, r32Var));
        qw3Var.d("BeginVRGame", new o3(qw3Var, r32Var));
        qw3Var.d("EndVRGame", new p3(qw3Var, r32Var));
        qw3Var.d("SignOffVR", new q3(qw3Var, r32Var));
    }

    public static void d(qw3 qw3Var, e42 e42Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (e42Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("global_server_timestamp_tc", new s3(qw3Var, e42Var));
        qw3Var.d("please_reconnect_date_socket_tc", new t3(qw3Var, e42Var));
        qw3Var.d("roster_had_changed_email_tc", new u3(qw3Var, e42Var));
        qw3Var.d("chatgpt_create_pattern_session_task_is_end_tc", new v3(qw3Var, e42Var));
        qw3Var.d("chatgpt_create_audiobook_session_task_is_end_tc", new w3(qw3Var, e42Var));
        qw3Var.d("this_account_change_email_tc", new y3(qw3Var, e42Var));
        qw3Var.d("toy_roulette_find_match_tc", new z3(qw3Var, e42Var));
        qw3Var.d("toy_roulette_controller_reject_tc", new a4(qw3Var, e42Var));
        qw3Var.d("toy_roulette_controller_accept_tc", new b4(qw3Var, e42Var));
        qw3Var.d("toy_roulette_start_play_tc", new c4(qw3Var, e42Var));
        qw3Var.d("toy_roulette_controller_end_tc", new d4(qw3Var, e42Var));
    }

    public static void e(qw3 qw3Var, ob2 ob2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (ob2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("reportUserStatus", new w2(qw3Var, ob2Var));
        qw3Var.d("app_user_banned_offline", new x2(qw3Var, ob2Var));
        qw3Var.d("ForumEngagementNoticeDTO", new y2(qw3Var, ob2Var));
        qw3Var.d("ForumEngagementCancelDTO", new z2(qw3Var, ob2Var));
        qw3Var.d("AppUserToysNoticeDTO", new a3(qw3Var, ob2Var));
        qw3Var.d("ForumEngagementAgreeDTO", new c3(qw3Var, ob2Var));
        qw3Var.d("ForumEngagementOverNoticeDTO", new d3(qw3Var, ob2Var));
        qw3Var.d("ForumEngagementDatingDTO", new e3(qw3Var, ob2Var));
        qw3Var.d("ForumEngagementInfoDTO", new f3(qw3Var, ob2Var));
        qw3Var.d("ForumEngagementOnRoomNoticeDTO", new g3(qw3Var, ob2Var));
        qw3Var.d("ForumEngagementCheckNoticeDTO", new h3(qw3Var, ob2Var));
    }

    public static void f(qw3 qw3Var, pb2 pb2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (pb2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("control_change_type", new i3(qw3Var, pb2Var));
        qw3Var.d("remote_control_line_up", new j3(qw3Var, pb2Var));
        qw3Var.d("end_control_link_notice_cs", new k3(qw3Var, pb2Var));
        qw3Var.d("remote_control_status", new l3(qw3Var, pb2Var));
    }

    public static void g(qw3 qw3Var, vb2 vb2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (vb2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("masterOnLineStatusNotify", new z0(qw3Var, vb2Var));
        qw3Var.d("createRoomSync", new a1(qw3Var, vb2Var));
        qw3Var.d("roomReceiveSync", new b1(qw3Var, vb2Var));
        qw3Var.d("receivePlayerRejectRoomSync", new c1(qw3Var, vb2Var));
        qw3Var.d("cancelRoomSync", new d1(qw3Var, vb2Var));
        qw3Var.d("playerAcceptRoomSync", new e1(qw3Var, vb2Var));
        qw3Var.d("receiveRoomRemoteControl", new f1(qw3Var, vb2Var));
        qw3Var.d("receiveGroupMemberState", new g1(qw3Var, vb2Var));
        qw3Var.d("receiveCancelRoomSync", new h1(qw3Var, vb2Var));
        qw3Var.d("receiveAllRejectRoomSync", new i1(qw3Var, vb2Var));
        qw3Var.d("receiveEndRoomSync", new k1(qw3Var, vb2Var));
        qw3Var.d("clearExitPlayer", new l1(qw3Var, vb2Var));
        qw3Var.d("getGroupInfo", new m1(qw3Var, vb2Var));
        qw3Var.d("receiveLdrControl", new n1(qw3Var, vb2Var));
        qw3Var.d("changeToSyncMaster", new o1(qw3Var, vb2Var));
        qw3Var.d("updateSyncMaster", new p1(qw3Var, vb2Var));
        qw3Var.d("receiveRoomSyncToy", new q1(qw3Var, vb2Var));
        qw3Var.d("setSyncMaster", new r1(qw3Var, vb2Var));
        qw3Var.d("receiveRoomBeControllerToyInfo", new s1(qw3Var, vb2Var));
        qw3Var.d("receiveRoomControllerToyInfo", new t1(qw3Var, vb2Var));
        qw3Var.d("changeLdrToyType", new v1(qw3Var, vb2Var));
    }

    public static void h(qw3 qw3Var, wb2 wb2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (wb2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("SOMEBODY_CREATE_MULTI_TO_ONE", new w1(qw3Var, wb2Var));
        qw3Var.d("MULTI_TO_ONE_IS_STAR_NOW", new x1(qw3Var, wb2Var));
        qw3Var.d("ACK_PLAYER_JOIN_MULTI_TO_ONE", new y1(qw3Var, wb2Var));
        qw3Var.d("getGroupInfoV2", new z1(qw3Var, wb2Var));
        qw3Var.d("MULTI_TO_ONE_IS_END", new a2(qw3Var, wb2Var));
        qw3Var.d("PLAYER_LIST_CHANGE", new b2(qw3Var, wb2Var));
        qw3Var.d("TARGETER_TOY_CHANGE", new c2(qw3Var, wb2Var));
        qw3Var.d("TARGETER_NET_WORK_NOTIFY", new d2(qw3Var, wb2Var));
        qw3Var.d("CURRENT_PLAYER_OFF_LINE", new e2(qw3Var, wb2Var));
        qw3Var.d("CURRENT_PLAYER_ON_LINE", new g2(qw3Var, wb2Var));
        qw3Var.d("IS_TIME_TO_SOMEONE_CONTROL", new h2(qw3Var, wb2Var));
        qw3Var.d("PLAYER_REFUSE_MULTI_TO_ONE_INVITE", new i2(qw3Var, wb2Var));
        qw3Var.d("MULTI_TOYS_CHANGE_TOY_FUN", new j2(qw3Var, wb2Var));
        qw3Var.d("YOU_BE_CALLED_TARGETER", new k2(qw3Var, wb2Var));
        qw3Var.d("ACK_CREATE_MULTI_TO_ONE_INFO", new l2(qw3Var, wb2Var));
        qw3Var.d("TARGETER_REFUSE_INVITE", new m2(qw3Var, wb2Var));
        qw3Var.d("YOU_CAT_PLAYING_MULTI_TO_ONE", new n2(qw3Var, wb2Var));
        qw3Var.d("SERVER_FORWARD_TOY_ORDER", new o2(qw3Var, wb2Var));
    }

    public static void i(qw3 qw3Var, zb2 zb2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (zb2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("xmppStatus", new p2(qw3Var, zb2Var));
        qw3Var.d("xmpp", new r2(qw3Var, zb2Var));
        qw3Var.d("xmppReceipt", new s2(qw3Var, zb2Var));
        qw3Var.d("SOCKET_IO_GLOBAL_MSG", new t2(qw3Var, zb2Var));
        qw3Var.d("beta_search_for_papers", new u2(qw3Var, zb2Var));
        qw3Var.d("remote_account_had_been_frozen_tc", new v2(qw3Var, zb2Var));
    }

    public static void j(qw3 qw3Var, fg2 fg2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (fg2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("ReportToyCommandDTO", new f(qw3Var, fg2Var));
        qw3Var.d("modelEndBroadcastEvent", new g(qw3Var, fg2Var));
        qw3Var.d("joinVibrateWithMeAck", new h(qw3Var, fg2Var));
        qw3Var.d("exitVibrateWithMeAck", new i(qw3Var, fg2Var));
    }

    public static void k(qw3 qw3Var, hg2 hg2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (hg2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("syncVibeCommand_tc", new e4(qw3Var, hg2Var));
        qw3Var.d("syncVibeActivityInfo_tc", new f4(qw3Var, hg2Var));
        qw3Var.d("endSyncVibeActivity_tc", new g4(qw3Var, hg2Var));
    }

    public static void l(qw3 qw3Var, ig2 ig2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (ig2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("takcon_toy_command_tc", new h4(qw3Var, ig2Var));
        qw3Var.d("takcon_update_game_info_tc", new a(qw3Var, ig2Var));
        qw3Var.d("takcon_change_game_status_tc", new b(qw3Var, ig2Var));
        qw3Var.d("takcon_ack_scan_join_game_tc", new c(qw3Var, ig2Var));
        qw3Var.d("takcon_ack_app_exit_game_tc", new d(qw3Var, ig2Var));
        qw3Var.d("takcon_exit_game_tc", new e(qw3Var, ig2Var));
    }

    public static void m(qw3 qw3Var, nk2 nk2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (nk2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("AckSuccessSyncPatternDTO", new l(qw3Var, nk2Var));
        qw3Var.d("AckExitPatternSyncDTO", new m(qw3Var, nk2Var));
        qw3Var.d("VideoProgressStatusDTO", new n(qw3Var, nk2Var));
        qw3Var.d("StopWatchVideoStatusDTO", new o(qw3Var, nk2Var));
        qw3Var.d("StartWatchVideoStatusDTO", new p(qw3Var, nk2Var));
        qw3Var.d("PcExitPatternSyncDTO", new q(qw3Var, nk2Var));
        qw3Var.d("StartPreviewModeDTO", new r(qw3Var, nk2Var));
        qw3Var.d("ModifyVideoPatternDTO", new s(qw3Var, nk2Var));
        qw3Var.d("RetrySyncPatternDTO", new t(qw3Var, nk2Var));
        qw3Var.d("ACK_RemoteEditorRelationDTO", new u(qw3Var, nk2Var));
        qw3Var.d("mp_ack_remote_connect_to_js_tc", new w(qw3Var, nk2Var));
        qw3Var.d("mp_from_js_heartbeat_tc", new x(qw3Var, nk2Var));
        qw3Var.d("mp_from_js_api_pattern_file_tc", new y(qw3Var, nk2Var));
        qw3Var.d("mp_play_media_pattern_tc", new z(qw3Var, nk2Var));
        qw3Var.d("mp_stop_media_pattern_tc", new a0(qw3Var, nk2Var));
        qw3Var.d("mp_js_end_tc", new b0(qw3Var, nk2Var));
    }

    public static void n(qw3 qw3Var, eq2 eq2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (eq2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("q_ack_user_new_msg_list_tc", new y0(qw3Var, eq2Var));
        qw3Var.d("ack_query_user_on_line_info_tc", new j1(qw3Var, eq2Var));
        qw3Var.d("which_app_page_open_now_tc", new u1(qw3Var, eq2Var));
        qw3Var.d("q_you_must_refresh_control_link_tc", new f2(qw3Var, eq2Var));
        qw3Var.d("ack_cl_add_friend_tc", new q2(qw3Var, eq2Var));
        qw3Var.d("cl_someone_req_add_friend_tc", new b3(qw3Var, eq2Var));
        qw3Var.d("cl_please_refresh_openfire_friend_tc", new m3(qw3Var, eq2Var));
        qw3Var.d("q_ready_tc", new x3(qw3Var, eq2Var));
        qw3Var.d("cl_please_refresh_long_time_control_link_list_tc", new i4(qw3Var, eq2Var));
        qw3Var.d("q_notice_tc", new k(qw3Var, eq2Var));
        qw3Var.d("q_end_control_link_tc", new v(qw3Var, eq2Var));
        qw3Var.d("q_ack_send_im_msg_tc", new g0(qw3Var, eq2Var));
        qw3Var.d("q_you_have_some_new_im_msg_tc", new r0(qw3Var, eq2Var));
        qw3Var.d("q_command_link_tc", new s0(qw3Var, eq2Var));
        qw3Var.d("q_refresh_occupy_countdown_tc", new t0(qw3Var, eq2Var));
        qw3Var.d("ack_cl_add_control_link_play_time_tc", new u0(qw3Var, eq2Var));
        qw3Var.d("q_query_control_info_tc", new v0(qw3Var, eq2Var));
        qw3Var.d("cl_control_permission_notification_tc", new w0(qw3Var, eq2Var));
        qw3Var.d("cl_control_permission_response_tc", new x0(qw3Var, eq2Var));
    }

    public static void o(qw3 qw3Var, ft2 ft2Var) {
        if (qw3Var == null) {
            throw new IllegalArgumentException("socketIo is null!");
        }
        if (ft2Var == null) {
            throw new IllegalArgumentException("target is null!");
        }
        qw3Var.d("im_new_msg_ts", new c0(qw3Var, ft2Var));
        qw3Var.d("im_ack_send_msg_tc", new d0(qw3Var, ft2Var));
        qw3Var.d("im_msg_receive_tc", new e0(qw3Var, ft2Var));
        qw3Var.d("im_ack_msg_deal_tc", new f0(qw3Var, ft2Var));
        qw3Var.d("im_signaling_req_tc", new h0(qw3Var, ft2Var));
        qw3Var.d("im_signaling_accept_tc", new i0(qw3Var, ft2Var));
        qw3Var.d("im_signaling_req_ack_tc", new j0(qw3Var, ft2Var));
        qw3Var.d("im_signaling_cancel_tc", new k0(qw3Var, ft2Var));
        qw3Var.d("im_signaling_reject_tc", new l0(qw3Var, ft2Var));
        qw3Var.d("im_toy_order_tc", new m0(qw3Var, ft2Var));
        qw3Var.d("im_client_connect_tc", new n0(qw3Var, ft2Var));
        qw3Var.d("toy_roulette_client_panel_tc", new o0(qw3Var, ft2Var));
        qw3Var.d("im_client_disconnect_tc", new p0(qw3Var, ft2Var));
        qw3Var.d("toy_roulette_toy_update_tc", new q0(qw3Var, ft2Var));
    }
}
