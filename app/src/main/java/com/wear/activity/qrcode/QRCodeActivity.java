package com.wear.activity.qrcode;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import androidx.annotation.StringRes;
import androidx.core.net.MailTo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.lovense.wear.R;
import com.wear.activity.discord.DiscordControl;
import com.wear.activity.discord.DiscordEvent;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.bean.AppGalleryScanBean;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.LanApiControlEvent;
import com.wear.bean.LanApiPlatformChangeEvent;
import com.wear.bean.LocalSocketIoConnectBean;
import com.wear.bean.ScanQRBean;
import com.wear.bean.ScanQRDataBean;
import com.wear.bean.ScanTokenBean;
import com.wear.bean.ScanVideoPatternQRBean;
import com.wear.bean.Toy;
import com.wear.bean.VrCodeResponse;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.event.PlayerCloseEvent;
import com.wear.bean.event.VideoPatternControlEvent;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.date.response.CreateSocketServerBean;
import com.wear.bean.socketio.scan.ScanBean;
import com.wear.broadcast.LanApiService;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.MainActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.JoinGroupChatActivity;
import com.wear.main.longDistance.player.ui.PlayerActivity;
import com.wear.main.migrate.ui.ChatMigrateConnectActivity;
import com.wear.main.ninja.service.PlayService;
import com.wear.main.toy.ToyActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.discover.xremote.activity.XRemoteActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkEndActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.LanApiConnectToyDailog;
import com.wear.widget.dialog.SelectToyDailog;
import com.wear.widget.dialog.VideoPatternConnectToyDialog;
import com.wear.xmpp.FragmentStateLossActivity;
import dc.ac4;
import dc.ad4;
import dc.ah4;
import dc.bc2;
import dc.bc4;
import dc.bv1;
import dc.ch3;
import dc.cs3;
import dc.db2;
import dc.dq2;
import dc.ef2;
import dc.eg3;
import dc.ff2;
import dc.fg2;
import dc.hf3;
import dc.hg2;
import dc.hu3;
import dc.ig2;
import dc.is3;
import dc.kf2;
import dc.kn3;
import dc.ku1;
import dc.kv1;
import dc.lg3;
import dc.mk2;
import dc.ms3;
import dc.na2;
import dc.nd3;
import dc.pb2;
import dc.pf3;
import dc.pg3;
import dc.pj3;
import dc.qb2;
import dc.r32;
import dc.se3;
import dc.sg3;
import dc.t23;
import dc.ti3;
import dc.tn2;
import dc.vc4;
import dc.vf2;
import dc.vl2;
import dc.we3;
import dc.xe3;
import dc.y12;
import dc.yc2;
import dc.yc4;
import dc.ye3;
import dc.yn2;
import dc.zb2;
import dc.zn2;
import dc.zt3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.disco.bean.request.RequestRoomQrcodeInfo;
import org.jivesoftware.smackx.disco.bean.response.ResponseRoomQrcodeInfo;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class QRCodeActivity<P extends vl2> extends FragmentStateLossActivity implements yc2, qb2 {
    public static final String l = QRCodeActivity.class.getSimpleName();
    public Dialog d;
    public boolean e;
    public ProgressDialog g;
    public Handler b = new Handler(Looper.getMainLooper());
    public boolean c = false;
    public Runnable f = new k();
    public String h = "";
    public String i = "";
    public String j = "";
    public ArrayList<String> k = new ArrayList<>();

    public class a implements mk2.r {

        /* renamed from: com.wear.activity.qrcode.QRCodeActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0068a implements Runnable {
            public RunnableC0068a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                QRCodeActivity.this.e = true;
            }
        }

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(ScanVideoPatternQRBean scanVideoPatternQRBean) {
            MusicControl.h0().S();
            y12.c.a().t();
            ff2.d = false;
            ff2.f = false;
            ff2.e = false;
            ff2.n().C();
            ScanQRDataBean scanQRDataBean = MyApplication.G;
            if (scanQRDataBean != null) {
                scanQRDataBean.onCancelReportToService();
            }
            MyApplication.G = null;
            EventBus.getDefault().post(new LanApiControlEvent(false));
            if (OrgySetting.getInstance().isJoinIn()) {
                OrgySetting.getInstance().joinOrgyAction();
            }
            EventBus.getDefault().post(new DiscordEvent(DiscordEvent.TYPE_ACTIVITY_OVER));
            QRCodeActivity.this.g.show();
            mk2.P().Y(scanVideoPatternQRBean);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(ScanVideoPatternQRBean scanVideoPatternQRBean) {
            mk2.P().J();
            QRCodeActivity.this.U4();
            mk2.P().E(scanVideoPatternQRBean.getPatternId(), scanVideoPatternQRBean.getPf(), 3);
        }

        @Override // dc.mk2.r
        public void a(String str, String str2) {
            QRCodeActivity.this.g.dismiss();
            sg3.h(R.string.lan_api_connect_service_error);
            QRCodeActivity.this.b.postDelayed(new RunnableC0068a(), 500L);
            mk2.P().E("", "", 4);
        }

        @Override // dc.mk2.r
        public void b(final ScanVideoPatternQRBean scanVideoPatternQRBean) {
            QRCodeActivity.this.g.dismiss();
            is3.b bVar = new is3.b(QRCodeActivity.this);
            bVar.m(false);
            bVar.l(false);
            String str = String.format(ah4.e(R.string.vp_sync), scanVideoPatternQRBean.getPf());
            mk2.P().H(scanVideoPatternQRBean.getPf());
            bVar.p(str);
            bVar.o(ah4.e(R.string.common_yes));
            bVar.d(new is3.d() { // from class: dc.gj1
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.d(scanVideoPatternQRBean);
                }
            });
            bVar.c(new is3.c() { // from class: dc.fj1
                @Override // dc.is3.c
                public final void doCancel() {
                    this.a.f(scanVideoPatternQRBean);
                }
            });
            cs3.h(bVar).show();
        }
    }

    public class b implements VideoPatternConnectToyDialog.d {
        public b() {
        }

        @Override // com.wear.widget.dialog.VideoPatternConnectToyDialog.d
        public void a() {
            mk2.P().J();
            QRCodeActivity.this.U4();
        }

        @Override // com.wear.widget.dialog.VideoPatternConnectToyDialog.d
        public void b() {
            pj3.f(QRCodeActivity.this, ToyActivity.class);
            QRCodeActivity.this.e = true;
        }
    }

    public class c implements bc2.b {
        public c() {
        }

        @Override // dc.bc2.b
        public void p() {
            xe3.a(vf2.e, "登陆成功！ 准备跳转页面");
            QRCodeActivity.this.dissDialog();
            PlayerActivity.w4(QRCodeActivity.this);
            QRCodeActivity.this.U4();
        }

        @Override // dc.bc2.b
        public void q() {
            QRCodeActivity.this.l5(ah4.e(R.string.player_connect_error));
        }
    }

    public class d implements SelectToyDailog.a {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // com.wear.widget.dialog.SelectToyDailog.a
        public void a(Toy toy) {
            if (hf3.d(QRCodeActivity.this)) {
                pb2.m().G(toy, this.a, 0, QRCodeActivity.this);
            } else {
                QRCodeActivity.this.n5(R.string.qrcode_no_network);
            }
        }
    }

    public class e implements dq2.i {
        public e() {
        }

        @Override // dc.dq2.i
        public void a(ControlLinkBean controlLinkBean) {
            QRCodeActivity.this.dissDialog();
            if (controlLinkBean.getLinkStatus() != 0) {
                if (controlLinkBean.getLinkStatus() == 1) {
                    QRCodeActivity.this.N4(ah4.e(R.string.notification_control_link_in_use));
                    return;
                } else {
                    sg3.l(ah4.e(R.string.control_link_expired));
                    return;
                }
            }
            Intent intent = new Intent(QRCodeActivity.this.activity, (Class<?>) ControlLinkChatActivity.class);
            intent.putExtra("userId", controlLinkBean.getCreator().getUserId());
            intent.putExtra("selfId", controlLinkBean.getSelfId());
            intent.putExtra("userBean", controlLinkBean);
            intent.putExtra("isJoiner", !controlLinkBean.getCreator().getUserId().equals(controlLinkBean.getSelfId()));
            QRCodeActivity.this.activity.startActivity(intent);
            QRCodeActivity.this.U4();
        }

        @Override // dc.dq2.i
        public void onError(String str) {
            QRCodeActivity.this.dissDialog();
            if (str.equals("1")) {
                QRCodeActivity.this.N4(ah4.e(R.string.notification_control_link_in_use));
                return;
            }
            if (str.equals("2")) {
                sg3.l(ah4.e(R.string.control_link_expired));
            } else if (str.equals("11")) {
                QRCodeActivity.this.l5(ah4.e(R.string.cant_control_your_control_link));
            } else {
                QRCodeActivity.this.o5(str);
            }
        }
    }

    public class f implements yn2<BaseResponseBeanNew<VrCodeResponse>> {
        public f() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<VrCodeResponse> baseResponseBeanNew) {
            if (baseResponseBeanNew.code != 0) {
                QRCodeActivity.this.L4(baseResponseBeanNew.code + "");
                return;
            }
            CreateSocketServerBean createSocketServerBean = new CreateSocketServerBean();
            createSocketServerBean.setVrGameCode(baseResponseBeanNew.data.getVrCode());
            r32.l().g(createSocketServerBean);
            QRCodeActivity.this.U4();
            xe3.a(QRCodeActivity.l, "绑定成功！" + baseResponseBeanNew);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            QRCodeActivity.this.L4(netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ String a;

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                QRCodeActivity qRCodeActivity = QRCodeActivity.this;
                qRCodeActivity.b.postDelayed(qRCodeActivity.f, 1000L);
            }
        }

        public class b implements is3.c {
            public b() {
            }

            @Override // dc.is3.c
            public void doCancel() {
                QRCodeActivity.this.U4();
            }
        }

        public g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            is3.b bVar = new is3.b(QRCodeActivity.this);
            bVar.o(ah4.e(R.string.retry));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.c(new b());
            bVar.d(new a());
            bVar.p(ah4.e(R.string.connect_to_mirror_error) + IOUtils.LINE_SEPARATOR_UNIX + this.a);
            cs3.h(bVar).show();
        }
    }

    public class h implements zn2<ScanQRBean> {
        public h() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ScanQRBean scanQRBean) {
            QRCodeActivity.this.dissDialog();
            QRCodeActivity.this.K4(scanQRBean);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            QRCodeActivity.this.l5(netException.message);
        }
    }

    public class i implements zn2<ScanQRBean> {

        public class a implements kn3.d {
            public final /* synthetic */ ScanQRDataBean a;
            public final /* synthetic */ ScanQRBean.DataBean b;

            public a(ScanQRDataBean scanQRDataBean, ScanQRBean.DataBean dataBean) {
                this.a = scanQRDataBean;
                this.b = dataBean;
            }

            @Override // dc.kn3.d
            public void doCancel() {
                QRCodeActivity.this.U4();
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                QRCodeActivity.this.addAnalyticsEventId("scan_3dx_binded", null);
                if (WearUtils.e1(db2.A().c)) {
                    db2.A().c = String.valueOf(eg3.b(WearUtils.x, "control_uid_simple_key", ""));
                }
                QRCodeActivity.this.O4(this.a, this.b.getData(), 7);
            }
        }

        public i() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ScanQRBean scanQRBean) {
            QRCodeActivity.this.dissDialog();
            if (scanQRBean.isResult()) {
                ScanQRBean.DataBean data = scanQRBean.getData();
                ScanQRDataBean scanQRDataBean = (ScanQRDataBean) WearUtils.A.fromJson(nd3.h(data.getData()), ScanQRDataBean.class);
                kn3 kn3Var = new kn3((Context) QRCodeActivity.this, String.format(ah4.e(R.string.lan_api_authorizes_control), scanQRDataBean.getPlatform()), ah4.e(R.string.common_yes), ah4.e(R.string.common_cancel), true, (kn3.d) new a(scanQRDataBean, data));
                kn3Var.show();
                kn3Var.p();
                return;
            }
            HashMap map = new HashMap();
            map.put("result", 1);
            map.put("message", scanQRBean.getMessage());
            map.put(XHTMLText.CODE, Integer.valueOf(scanQRBean.getCode()));
            map.put("type", 5);
            ye3.d("X0003", WearUtils.A.toJson(map));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            QRCodeActivity.this.l5(netException.message);
        }
    }

    public class j implements LanApiConnectToyDailog.d {
        public final /* synthetic */ LanApiConnectToyDailog a;

        public j(LanApiConnectToyDailog lanApiConnectToyDailog) {
            this.a = lanApiConnectToyDailog;
        }

        @Override // com.wear.widget.dialog.LanApiConnectToyDailog.d
        public void a() {
            QRCodeActivity.this.U4();
        }

        @Override // com.wear.widget.dialog.LanApiConnectToyDailog.d
        public void b() {
            pj3.f(QRCodeActivity.this, ToyActivity.class);
            QRCodeActivity.this.T4();
            this.a.dismiss();
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeActivity.this.e = true;
        }
    }

    public class l implements kn3.d {
        public final /* synthetic */ ScanQRDataBean a;
        public final /* synthetic */ ScanQRBean.DataBean b;

        public class a implements zn2<ScanQRBean> {
            public a() {
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(ScanQRBean scanQRBean) {
                QRCodeActivity.this.dissDialog();
                if (scanQRBean.isResult()) {
                    l lVar = l.this;
                    QRCodeActivity.this.O4(lVar.a, lVar.b.getData(), 5);
                } else {
                    HashMap map = new HashMap();
                    map.put("result", 1);
                    map.put("message", scanQRBean.getMessage());
                    map.put(XHTMLText.CODE, Integer.valueOf(scanQRBean.getCode()));
                    map.put("type", 5);
                    ye3.d("X0003", WearUtils.A.toJson(map));
                }
                QRCodeActivity.this.U4();
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
                HashMap map = new HashMap();
                map.put("result", 1);
                map.put("message", netException.getMessage());
                map.put(XHTMLText.CODE, netException.getCode());
                map.put("type", 5);
                ye3.d("X0003", WearUtils.A.toJson(map));
                QRCodeActivity.this.l5(netException.message);
            }
        }

        public l(ScanQRDataBean scanQRDataBean, ScanQRBean.DataBean dataBean) {
            this.a = scanQRDataBean;
            this.b = dataBean;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            QRCodeActivity.this.U4();
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            QRCodeActivity.this.addAnalyticsEventId("scan_3dx_binded", null);
            if (WearUtils.e1(db2.A().c)) {
                db2.A().c = String.valueOf(eg3.b(WearUtils.x, "control_uid_simple_key", ""));
            }
            HashMap map = new HashMap();
            map.put("platform", this.a.getPlatform());
            map.put("userId", this.a.getUid());
            map.put("uid", db2.A().c);
            QRCodeActivity.this.showDialog();
            tn2.x(WearUtils.x).k("/api/lan/bindUser", map, new a());
        }
    }

    public class m implements ef2 {
        public final /* synthetic */ ScanQRDataBean a;

        public m(ScanQRDataBean scanQRDataBean) {
            this.a = scanQRDataBean;
        }

        @Override // dc.ef2
        public ef2.a a(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest) {
            ef2.a aVar = new ef2.a();
            aVar.b = false;
            return aVar;
        }

        @Override // dc.ef2
        public void b(Exception exc) {
            xe3.a("lanApi", "createFail ip=" + exc.getMessage());
        }

        @Override // dc.ef2
        public void c(String str, int i) {
            xe3.a("lanApi", "createSuccess ip=" + str + "   port=" + i);
            db2.A().P();
            this.a.send3dxConnectStartLog();
            QRCodeActivity.this.setResult(-1);
            QRCodeActivity.this.U4();
        }
    }

    public class n implements Runnable {
        public final /* synthetic */ String a;

        public n(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            is3.b bVar = new is3.b(QRCodeActivity.this);
            bVar.p(this.a);
            bVar.k(R.layout.dialog_default_ok_new);
            QRCodeActivity.this.d = cs3.h(bVar);
            QRCodeActivity.this.d.show();
        }
    }

    public class o implements is3.d {
        public o() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            QRCodeActivity.this.e = true;
            QRCodeActivity.this.U4();
        }
    }

    public class p implements is3.c {
        public p() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            ku1.a("Scan QR", "scan_use_connect_popup_click", "click", "scan_use_connect_popup", "popup", "1", null, null);
            QRCodeActivity.this.U4();
        }
    }

    public class q implements is3.d {
        public q() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ku1.a("Scan QR", "scan_use_connect_popup_click", "click", "scan_use_connect_popup", "popup", "2", null, null);
            if (pf3.a(QRCodeActivity.this, "com.lovense.connect")) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setComponent(new ComponentName("com.lovense.connect", "com.lovense.lvs.connect.FlashActivity"));
                QRCodeActivity.this.startActivity(intent);
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.lovense.connect"));
                QRCodeActivity.this.startActivity(intent2);
            }
            QRCodeActivity.this.U4();
        }
    }

    public class r implements DialogInterface.OnDismissListener {
        public r() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QRCodeActivity.this.e = true;
        }
    }

    public class s implements Runnable {
        public final /* synthetic */ String a;

        public s(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeActivity qRCodeActivity = QRCodeActivity.this;
            if (qRCodeActivity.c || qRCodeActivity.q5(this.a)) {
                return;
            }
            QRCodeActivity.this.r5(this.a);
        }
    }

    public class t extends ClickableSpan {
        public final /* synthetic */ String a;

        public t(String str) {
            this.a = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            try {
                QRCodeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class u implements ms3.a {
        public final /* synthetic */ String a;

        public u(String str) {
            this.a = str;
        }

        @Override // dc.ms3.a
        public void a() {
        }

        @Override // dc.ms3.a
        public void b() {
            WearUtils.p(this.a, QRCodeActivity.this);
            sg3.l(ah4.e(R.string.copy_invite_link_title_copied));
        }
    }

    public class v implements bc4 {
        public final /* synthetic */ String a;

        public v(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(String str) {
            QRCodeActivity.this.p5(str);
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            sg3.h(R.string.music_record_net_connect_error_tip);
            iOException.printStackTrace();
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws IOException {
            if (ad4Var.f() == 404) {
                QRCodeActivity qRCodeActivity = QRCodeActivity.this;
                final String str = this.a;
                qRCodeActivity.runOnMainThread(new Runnable() { // from class: dc.hj1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(str);
                    }
                });
                return;
            }
            try {
                if (ad4Var.f() != 200 || ad4Var.b() == null) {
                    sg3.l(ah4.e(R.string.common_netError));
                    return;
                }
                AppGalleryScanBean appGalleryScanBean = (AppGalleryScanBean) new Gson().fromJson(ad4Var.b().string(), AppGalleryScanBean.class);
                if (appGalleryScanBean.getAppId() == null) {
                    sg3.l(ah4.e(R.string.app_gallery_debug_tip2));
                    return;
                }
                QRCodeActivity.this.h = appGalleryScanBean.getAppId();
                if (appGalleryScanBean.getAppVersion() == null) {
                    sg3.l(ah4.e(R.string.app_gallery_debug_tip4));
                    return;
                }
                QRCodeActivity.this.i = appGalleryScanBean.getAppVersion();
                if (appGalleryScanBean.getVersion() == null) {
                    sg3.l(ah4.e(R.string.app_gallery_debug_tip3));
                    return;
                }
                QRCodeActivity.this.j = appGalleryScanBean.getVersion();
                if (pg3.h().g().contains(Uri.parse(this.a).getHost()) || eg3.d(QRCodeActivity.this, "switchWihteList", false)) {
                    QRCodeActivity.this.k = (ArrayList) appGalleryScanBean.getAllowDomains();
                }
                QRCodeActivity qRCodeActivity2 = QRCodeActivity.this;
                qRCodeActivity2.W4(qRCodeActivity2.h, qRCodeActivity2.i, qRCodeActivity2.j, this.a, qRCodeActivity2.k);
            } catch (JsonSyntaxException e) {
                if (e.getCause() instanceof IllegalStateException) {
                    sg3.l("JsonSyntaxException");
                } else {
                    sg3.l(ah4.e(R.string.common_netError));
                }
            }
        }
    }

    public class w implements is3.c {
        public w() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            QRCodeActivity.this.U4();
        }
    }

    public class x implements is3.d {
        public x() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            QRCodeActivity.this.U4();
        }
    }

    public class y implements is3.d {
        public final /* synthetic */ String a;

        public y(String str) {
            this.a = str;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            QRCodeActivity.this.showDialog();
            fg2.j().i();
            ig2.n().l(true);
            pb2.m().k();
            if (PlayService.R) {
                EventBus.getDefault().post(new NotificationCloseEvent());
            }
            na2.m().v();
            QRCodeActivity.this.M4(this.a);
        }
    }

    public class z implements kv1 {
        public final /* synthetic */ String a;
        public final /* synthetic */ RequestRoomQrcodeInfo b;

        public class a implements bv1 {
            public a() {
            }

            @Override // dc.bv1
            public void Q(String str) {
                QRCodeActivity.this.progressDialog.dismiss();
                pj3.j(QRCodeActivity.this, ChatRoomActivity.class, "roomId", str);
                QRCodeActivity.this.U4();
            }

            @Override // dc.bv1
            public void r1(String str) {
                QRCodeActivity.this.progressDialog.dismiss();
            }
        }

        public z(String str, RequestRoomQrcodeInfo requestRoomQrcodeInfo) {
            this.a = str;
            this.b = requestRoomQrcodeInfo;
        }

        @Override // dc.kv1
        public void a(String str) {
            QRCodeActivity.this.dissDialog();
            ResponseRoomQrcodeInfo responseRoomQrcodeInfo = (ResponseRoomQrcodeInfo) JSON.parseObject(str, ResponseRoomQrcodeInfo.class);
            if (responseRoomQrcodeInfo.suc() && responseRoomQrcodeInfo.getData() == null) {
                ye3.d("S0003", "扫码入群数据为空： codeKey = " + this.a + "  " + str);
            }
            if (responseRoomQrcodeInfo.suc() && responseRoomQrcodeInfo.getData() != null) {
                Intent intent = new Intent(QRCodeActivity.this.activity, (Class<?>) JoinGroupChatActivity.class);
                intent.putExtra("qrcode", this.b.codeKey);
                intent.putExtra("data", responseRoomQrcodeInfo.getData());
                QRCodeActivity.this.startActivity(intent);
                QRCodeActivity.this.U4();
                return;
            }
            int i = responseRoomQrcodeInfo.code;
            if (i == 2) {
                QRCodeActivity.this.n5(R.string.group_chat_qr_scan_error4);
                return;
            }
            if (i == 3) {
                QRCodeActivity.this.n5(R.string.group_chat_qr_scan_error1);
                return;
            }
            if (i == 4) {
                QRCodeActivity.this.n5(R.string.group_chat_member_invitations);
                QRCodeActivity.this.U4();
                return;
            }
            if (i == 5) {
                QRCodeActivity.this.n5(R.string.group_chat_qr_scan_error2);
                return;
            }
            if (i != 6) {
                if (i == 7) {
                    QRCodeActivity.this.n5(R.string.group_chat_qr_scan_error3);
                    return;
                } else {
                    QRCodeActivity.this.n5(R.string.lan_api_connect_service_error);
                    return;
                }
            }
            String roomId = responseRoomQrcodeInfo.getData().getRoomId();
            if (ch3.n().k(roomId) == null) {
                hu3.z(QRCodeActivity.this.application).q(roomId, new a());
            } else {
                pj3.j(QRCodeActivity.this, ChatRoomActivity.class, "roomId", roomId);
                QRCodeActivity.this.U4();
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
            QRCodeActivity.this.n5(R.string.scan_check_you_internet);
            QRCodeActivity.this.dissDialog();
        }
    }

    public final void K4(ScanQRBean scanQRBean) {
        if (scanQRBean.isResult()) {
            ScanQRBean.DataBean data = scanQRBean.getData();
            if (data.getType() == 0) {
                j5();
                return;
            }
            ScanQRDataBean scanQRDataBean = (ScanQRDataBean) WearUtils.A.fromJson(nd3.h(data.getData()), ScanQRDataBean.class);
            HashMap map = new HashMap();
            map.put("uid", scanQRDataBean.getUid());
            map.put("utoken", scanQRDataBean.getUtoken());
            map.put("platform", scanQRDataBean.getPlatform());
            map.put("uname", scanQRDataBean.getUname());
            ye3.d("X0002", WearUtils.A.toJson(map));
            kn3 kn3Var = new kn3((Context) this, String.format(ah4.e(R.string.lan_api_authorizes_control), scanQRDataBean.getTransPf()), ah4.e(R.string.common_yes), ah4.e(R.string.common_cancel), true, (kn3.d) new l(scanQRDataBean, data));
            kn3Var.show();
            kn3Var.p();
        }
    }

    public final void L4(String str) {
        xe3.a(l, "绑定失败！");
        runOnMainThread(new g(str));
    }

    public final void M4(String str) {
        dq2.w().r(str, 4, new e());
    }

    public final void N4(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT, str);
        pj3.g(this, ControlLinkEndActivity.class, bundle);
    }

    public final void O4(ScanQRDataBean scanQRDataBean, String str, int i2) {
        HashMap map = new HashMap();
        int iIntValue = 0;
        map.put("result", 0);
        map.put("uid", db2.A().c);
        map.put("userId", scanQRDataBean.getUid());
        map.put("platform", scanQRDataBean.getPlatform());
        map.put("type", Integer.valueOf(i2));
        ye3.d("X0003", WearUtils.A.toJson(map));
        kf2.m().b(new m(scanQRDataBean), "/", false);
        ff2.d = true;
        ff2.e = true;
        if (i2 == 5) {
            ff2.f = false;
            db2.A().b.j(false);
        }
        DaoUtils.getTestValueDao().save(zt3.k, str, TestValueDao.LAN_API_DATA_TYPE);
        ScanQRDataBean scanQRDataBean2 = MyApplication.G;
        if (scanQRDataBean2 != null) {
            scanQRDataBean2.onCancelReportToService();
        }
        String heart = scanQRDataBean.getHeart();
        if (!WearUtils.e1(heart) && WearUtils.q1(heart)) {
            iIntValue = Integer.valueOf(heart).intValue();
        }
        if (iIntValue > 0) {
            scanQRDataBean.createAutoReportToService(iIntValue);
        } else if (iIntValue == 0) {
            scanQRDataBean.reportToService();
        }
        MyApplication.G = scanQRDataBean;
        EventBus.getDefault().post(new LanApiControlEvent(true));
        if (LanApiService.e) {
            EventBus.getDefault().post(new LanApiPlatformChangeEvent());
            return;
        }
        Intent intent = new Intent(WearUtils.x, (Class<?>) LanApiService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    public final void P4(String str, Uri uri) {
        String str2;
        if (WearUtils.e1(this.h) || WearUtils.e1(this.i) || WearUtils.e1(this.j)) {
            str2 = uri.getHost() + "/appgallery_config.json";
        } else {
            str2 = "";
        }
        if (WearUtils.e1(str2)) {
            W4(this.h, this.i, this.j, str, this.k);
        } else {
            V4(str);
        }
    }

    @Override // dc.qb2
    public void Q0() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.b.removeCallbacksAndMessages(null);
        this.b.postDelayed(this.f, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        this.g.dismiss();
    }

    public final void Q4() {
        is3.b bVar = new is3.b(this);
        bVar.m(false);
        bVar.l(false);
        bVar.p(ah4.e(R.string.vp_toy_fst));
        bVar.o(ah4.e(R.string.lan_api_connect_toy));
        VideoPatternConnectToyDialog videoPatternConnectToyDialog = (VideoPatternConnectToyDialog) cs3.i(bVar, VideoPatternConnectToyDialog.class);
        videoPatternConnectToyDialog.p(new b());
        videoPatternConnectToyDialog.show();
        mk2.P().E("", "", 2);
    }

    public final void R4(ScanBean scanBean) {
        if (WearUtils.e1(scanBean.getD())) {
            l5(ah4.e(R.string.player_data_exception));
            return;
        }
        LocalSocketIoConnectBean localSocketIoConnectBean = (LocalSocketIoConnectBean) JSON.parseObject(scanBean.getD(), LocalSocketIoConnectBean.class);
        if (localSocketIoConnectBean == null || localSocketIoConnectBean.getU() == null) {
            l5(ah4.e(R.string.player_data_exception));
            return;
        }
        if (WearUtils.x.G().P().size() <= 0) {
            l5(ah4.e(R.string.qrcode_not_connet_toy));
        } else if (se3.a(WearUtils.x) != 1) {
            l5(ah4.e(R.string.qrcode_not_wifi));
        } else {
            showDialog();
            bc2.r().p(localSocketIoConnectBean, new c());
        }
    }

    @Override // dc.yc2
    public void S3() {
        dissDialog();
    }

    public final void S4(ScanBean scanBean) {
        String d2 = scanBean.getD();
        int i2 = scanBean.getT() == 10 ? 1 : 2;
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        this.g.show();
        mk2.P().q0(i2, d2, new a());
    }

    public final void T4() {
        this.b.removeCallbacksAndMessages(null);
        this.b.postDelayed(this.f, 1000L);
    }

    public final void U4() {
        if (this instanceof MainActivity) {
            return;
        }
        finish();
    }

    public final void V4(String str) {
        String str2;
        vc4 vc4Var = new vc4();
        Uri uri = Uri.parse(str);
        String strReplace = (uri.getScheme() + "://" + uri.getAuthority() + uri.getPath()).replace("/index.html", "");
        if (strReplace.endsWith("/")) {
            str2 = strReplace + "appgallery_config.json";
        } else {
            str2 = strReplace + "/appgallery_config.json";
        }
        String str3 = "Remote/" + WearUtils.q + " (" + Build.MODEL + ";Android" + Build.VERSION.RELEASE + ") AppGallery/2.0.0";
        String str4 = "请求头" + str3;
        yc4.a aVar = new yc4.a();
        aVar.k(str2);
        aVar.e("User-Agent", str3);
        try {
            vc4Var.a(aVar.b()).j(new v(str));
        } catch (Exception e2) {
            sg3.l(ah4.e(R.string.common_netError));
            e2.printStackTrace();
        }
    }

    public final boolean W4(String str, String str2, String str3, String str4, ArrayList<String> arrayList) {
        boolean zD = eg3.d(this, "switchDevelopModel", false);
        if (WearUtils.e1(str)) {
            sg3.l(ah4.e(R.string.app_gallery_debug_tip2));
            return false;
        }
        if (WearUtils.e1(str2)) {
            sg3.l(ah4.e(R.string.app_gallery_debug_tip4));
            return false;
        }
        if (WearUtils.e1(str3)) {
            sg3.l(ah4.e(R.string.app_gallery_debug_tip3));
            return false;
        }
        if (!zD) {
            sg3.l(ah4.e(R.string.xremote_incorrect_debug_qr));
            return false;
        }
        if (t23.a.a(str3)) {
            Bundle bundle = new Bundle();
            bundle.putString(ImagesContract.URL, str4);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, str);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str2);
            bundle.putString("version", str3);
            bundle.putBoolean("developModel", true);
            if (!WearUtils.g1(arrayList)) {
                bundle.putStringArrayList("xremoteAllowDomainList", arrayList);
            }
            pj3.g(this, XRemoteActivity.class, bundle);
            finish();
        } else {
            sg3.l(ah4.e(R.string.xremote_version_incorrect));
        }
        return true;
    }

    public final void X4(String str) {
        if (str.isEmpty()) {
            n5(R.string.qrcode_not_lovense_qrcode);
            return;
        }
        Uri uri = Uri.parse(str);
        if (uri == null) {
            p5(str);
            return;
        }
        if (uri.getScheme() == null || uri.getHost() == null) {
            if (TextUtils.equals(uri.getScheme(), "mailto")) {
                try {
                    startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://mail.google.com/mail/u/0/?view=cm&fs=1&tf=1&to=" + str.replace(MailTo.MAILTO_SCHEME, ""))));
                }
                U4();
                return;
            }
        } else {
            if (TextUtils.equals(uri.getScheme(), "remotelink") && TextUtils.equals(uri.getHost(), "lovense.club")) {
                we3.q(this, str, null);
                U4();
                return;
            }
            if (TextUtils.equals(uri.getHost(), "lovense.club") || TextUtils.equals(uri.getHost(), "landing.lovense-api.com")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(268435456);
                    startActivity(intent);
                    U4();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (eg3.d(this, "switchDevelopModel", false) && b5(str)) {
                U4();
                return;
            }
            if (URLUtil.isFileUrl(str) && !TextUtils.isEmpty(uri.getPath()) && ti3.e(this, uri.getPath())) {
                U4();
                return;
            } else if (we3.r(uri, this)) {
                U4();
                return;
            }
        }
        T4();
        p5(str);
    }

    public final void Y4(ScanTokenBean scanTokenBean) {
        HashMap map = new HashMap();
        map.put("platform", scanTokenBean.getPlatform());
        map.put("data", scanTokenBean.getData());
        map.put("type", 7);
        tn2.x(WearUtils.x).k("/api/lan/getCallback", map, new i());
    }

    public void Z4(String str) {
        runOnMainThread(new s(str));
    }

    @Override // dc.yc2
    public void a2() {
        T4();
    }

    public final void a5(ScanTokenBean scanTokenBean) {
        HashMap map = new HashMap();
        map.put("token", scanTokenBean.getToken());
        map.put("appType", "remote");
        map.put(RemoteConfigConstants.RequestFieldKey.APP_ID, ye3.x());
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        tn2.x(WearUtils.x).k("/app/qr/getQrData", map, new h());
    }

    public final boolean b5(String str) {
        this.h = "";
        this.i = "";
        this.j = "";
        Uri uri = Uri.parse(str);
        if (!str.startsWith("http") && !str.startsWith("https")) {
            return false;
        }
        if (str.contains("#")) {
            Map<String, String> mapT = WearUtils.t(str);
            if (mapT.size() > 0) {
                this.h = mapT.get(RemoteConfigConstants.RequestFieldKey.APP_ID);
                this.i = mapT.get(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
                this.j = mapT.get("version");
            }
        } else {
            this.h = uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID);
            this.i = uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
            this.j = uri.getQueryParameter("version");
        }
        P4(str, uri);
        return true;
    }

    public final void c5(ScanBean scanBean) {
        boolean z2 = WearUtils.D;
        if (ch3.n().o().getIsSupportGroup() == 0 || "zh".equals(lg3.f(WearUtils.x)) || z2) {
            n5(R.string.group_chat_not_support1);
            return;
        }
        showDialog();
        RequestRoomQrcodeInfo requestRoomQrcodeInfo = new RequestRoomQrcodeInfo();
        String d2 = scanBean.getD();
        requestRoomQrcodeInfo.codeKey = d2;
        zb2.O().B0(requestRoomQrcodeInfo, new z(d2, requestRoomQrcodeInfo));
    }

    @Override // dc.yc2
    public void e0() {
        showDialog();
    }

    @Override // dc.yc2
    public void f1() {
        U4();
    }

    public final void f5(int i2, ScanTokenBean scanTokenBean) {
        HashMap map = new HashMap();
        map.put("result", Integer.valueOf(scanTokenBean != null ? 0 : 1));
        map.put("token", scanTokenBean != null ? scanTokenBean.getToken() : null);
        map.put("type", Integer.valueOf(i2));
        ye3.e("X0001", map);
    }

    public final void g5(ScanBean scanBean) {
        String d2 = scanBean.getD();
        boolean zF = fg2.j().f();
        boolean zI = pb2.m().i();
        if (!na2.m().f() && !zI && !zF) {
            showDialog();
            y12.c.a().t();
            if (PlayService.R) {
                EventBus.getDefault().post(new NotificationCloseEvent());
            }
            M4(d2);
            return;
        }
        is3.b bVar = new is3.b(this);
        bVar.p(ah4.e(R.string.notification_control_link_conflict));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.o(ah4.e(R.string.common_ok));
        bVar.d(new y(d2));
        cs3.h(bVar).show();
    }

    /* renamed from: h5, reason: merged with bridge method [inline-methods] */
    public final void e5(String str) {
        HashMap map = new HashMap();
        map.put("qrData", str);
        tn2.x(WearUtils.x).i("/api/remote/mirrorLifeQrCode", map, new f());
    }

    public final void i5(ScanBean scanBean) {
        String d2 = scanBean.getD();
        if (WearUtils.e1(d2)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("websocketUrl", d2);
        pj3.g(this, ChatMigrateConnectActivity.class, bundle);
        U4();
    }

    public final void j5() {
        dissDialog();
        is3.b bVar = new is3.b(this);
        bVar.q(ah4.e(R.string.notification_scan_extension_qr1));
        bVar.p(ah4.e(R.string.notification_scan_extension_qr2));
        bVar.o(ah4.e(R.string.button_download_now));
        bVar.d(new q());
        bVar.c(new p());
        cs3.h(bVar).show();
        ku1.i("Scan QR", "scan_use_connect_popup_exposure", "exposure", "scan_use_connect_popup", "popup");
    }

    public final void k5(ScanBean scanBean) {
        ArrayList<Toy> arrayList = new ArrayList();
        arrayList.addAll(this.application.G().o());
        ArrayList arrayList2 = new ArrayList();
        for (Toy toy : arrayList) {
            if (toy.isSelect() && toy.isSupportControlPanel() && toy.isConnected()) {
                arrayList2.add(toy);
            }
        }
        if (arrayList2.size() == 0) {
            n5(R.string.qrcode_dont_connect_max);
            return;
        }
        String d2 = scanBean.getD();
        if (arrayList2.size() == 1) {
            if (hf3.d(this)) {
                pb2.m().G((Toy) arrayList2.get(0), d2, 0, this);
                return;
            } else {
                n5(R.string.qrcode_no_network);
                return;
            }
        }
        is3.b bVar = new is3.b(this);
        bVar.o(ah4.e(R.string.common_ok));
        bVar.u(R.id.tv_confirm);
        bVar.p(ah4.e(R.string.qrcode_scan_two_toy));
        bVar.e(arrayList2);
        SelectToyDailog selectToyDailog = (SelectToyDailog) cs3.i(bVar, SelectToyDailog.class);
        selectToyDailog.show();
        selectToyDailog.setListener(new d(d2));
    }

    public final void l5(String str) {
        cs3.k(this, str, new o()).show();
    }

    public final void m5() {
        is3.b bVar = new is3.b(this);
        bVar.p(ah4.e(R.string.lan_api_connect_toy_first));
        bVar.v(R.id.tv_text);
        bVar.o(ah4.e(R.string.lan_api_connect_toy));
        bVar.u(R.id.tv_confirm);
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.t(R.id.tv_cancel);
        LanApiConnectToyDailog lanApiConnectToyDailog = (LanApiConnectToyDailog) cs3.i(bVar, LanApiConnectToyDailog.class);
        lanApiConnectToyDailog.setListener(new j(lanApiConnectToyDailog));
        lanApiConnectToyDailog.show();
    }

    public final void n5(@StringRes int i2) {
        o5(ah4.e(i2));
    }

    public final void o5(String str) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.b.removeCallbacksAndMessages(null);
        sg3.k(this, str);
        this.b.postDelayed(this.f, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_qrcode);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.g = progressDialog;
        progressDialog.setMessage(ah4.e(R.string.common_loading));
        this.g.setIndeterminate(true);
        this.g.setCancelable(true);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.removeCallbacksAndMessages(null);
        this.c = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PlayerCloseEvent playerCloseEvent) {
        if (playerCloseEvent.getErrorCode() == 403) {
            l5(ah4.e(R.string.player_already_scanned));
            return;
        }
        if (playerCloseEvent.getErrorCode() == 500) {
            l5(ah4.e(R.string.player_recognize_QR_code));
        } else if (playerCloseEvent.getErrorCode() == 404) {
            l5(ah4.e(R.string.player_data_exception));
        } else if (playerCloseEvent.getErrorCode() == 400) {
            l5(ah4.e(R.string.player_data_parsing_exception));
        }
    }

    public final void p5(String str) {
        ms3 ms3Var = new ms3(this);
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("(https?:\\/\\/)?[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&:\\/\\+#]*[\\w\\-\\@?^=%&\\/\\+#])?").matcher(str);
        while (matcher.find()) {
            spannableString.setSpan(new t(matcher.group()), matcher.start(), matcher.end(), 33);
        }
        ms3Var.g(spannableString);
        ms3Var.k(ah4.e(R.string.common_copy));
        ms3Var.h(new u(str));
        ms3Var.show();
    }

    @Override // dc.qb2
    public void q1(boolean z2) {
        this.g.dismiss();
        if (z2) {
            U4();
        }
    }

    public boolean q5(String str) {
        String string;
        ScanTokenBean scanTokenBean;
        boolean z2;
        String str2 = "tryHandlerFirstMethod____result: " + str;
        try {
            JSONObject object = JSON.parseObject(str);
            Integer integer = object.getInteger("type");
            if (!WearUtils.c1(integer)) {
                int iIntValue = integer.intValue();
                if (iIntValue == 5) {
                    string = object.getString("data");
                    scanTokenBean = (ScanTokenBean) WearUtils.A.fromJson(nd3.h(string), ScanTokenBean.class);
                    if (scanTokenBean == null || WearUtils.e1(scanTokenBean.getToken())) {
                        z2 = false;
                    } else {
                        if (scanTokenBean.getToken().startsWith("c_l:")) {
                            j5();
                            return true;
                        }
                        z2 = true;
                    }
                } else if (iIntValue == 7) {
                    scanTokenBean = new ScanTokenBean();
                    scanTokenBean.setCode("7");
                    scanTokenBean.setData(object.getString("data"));
                    scanTokenBean.setPlatform(object.getString("platform"));
                    z2 = !WearUtils.e1(scanTokenBean.getData());
                    string = null;
                } else {
                    if (iIntValue != 14) {
                        X4(str);
                        return true;
                    }
                    string = object.getString("data");
                    String strH = nd3.h(string);
                    z2 = !WearUtils.e1(strH);
                    String str3 = "tryHandlerFirstMethod___tipper___data: " + string + ", decData: " + strH;
                    scanTokenBean = null;
                }
                f5(integer.intValue(), scanTokenBean);
                if (!z2) {
                    X4(str);
                    return true;
                }
                addAnalyticsEventId("scan_3dx_qrcode", null);
                if (integer.intValue() != 5 && this.application.G().P().isEmpty()) {
                    m5();
                    return true;
                }
                showDialog();
                int iIntValue2 = integer.intValue();
                if (iIntValue2 == 5) {
                    a5(scanTokenBean);
                } else if (iIntValue2 == 7) {
                    Y4(scanTokenBean);
                } else if (iIntValue2 == 14) {
                    ig2.n().q(string, this);
                }
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public void r5(String str) {
        String str2 = l;
        String str3 = "tryHandlerSecondMethod____result: " + str;
        String strH = nd3.h(str);
        if (TextUtils.isEmpty(strH)) {
            X4(str);
            return;
        }
        xe3.a(str2, "解密：decryptRes:" + strH);
        ScanBean scanBean = null;
        try {
            scanBean = (ScanBean) JSON.parseObject(strH, ScanBean.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (scanBean == null) {
            X4(strH);
            return;
        }
        if ("c".equals(scanBean.getA())) {
            n5(R.string.qrcode_scan_with_connect);
            T4();
            return;
        }
        int t2 = scanBean.getT();
        if (t2 == 0) {
            ScanTokenBean scanTokenBean = (ScanTokenBean) WearUtils.A.fromJson(strH, ScanTokenBean.class);
            if (scanTokenBean != null) {
                a5(scanTokenBean);
                return;
            }
            return;
        }
        if (t2 == 300) {
            g5(scanBean);
            return;
        }
        if (t2 == 500) {
            c5(scanBean);
            return;
        }
        if (t2 == 6) {
            k5(scanBean);
            return;
        }
        if (t2 == 7) {
            R4(scanBean);
            return;
        }
        if (t2 == 8) {
            final String d2 = scanBean.getD();
            is3.b bVar = new is3.b(this);
            bVar.o(ah4.e(R.string.common_yes));
            bVar.n(ah4.e(R.string.common_no));
            bVar.c(new w());
            bVar.d(new is3.d() { // from class: dc.ij1
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.e5(d2);
                }
            });
            bVar.p(ah4.e(R.string.connect_to_mirror));
            cs3.h(bVar).show();
            return;
        }
        switch (t2) {
            case 10:
                break;
            case 11:
                hg2.m().o(scanBean.getD(), this);
                return;
            case 12:
                fg2.j().l(scanBean.getD(), this);
                return;
            default:
                switch (t2) {
                    case 14:
                        DiscordControl.getInstance().getActivityStatus(scanBean.getD());
                        break;
                    case 15:
                        i5(scanBean);
                        break;
                    case 16:
                        break;
                    default:
                        cs3.k(this, ah4.e(R.string.qr_scan_default), new x()).show();
                        break;
                }
                return;
        }
        mk2.P().e0();
        mk2.P().r0(1);
        if (this.application.G().P().size() == 0) {
            Q4();
        } else {
            S4(scanBean);
        }
    }

    @Override // dc.qb2
    public void x0() {
        this.g.show();
    }

    @Override // dc.yc2
    public boolean x2(String str) {
        if (this.application.G().N() != null) {
            return true;
        }
        Dialog dialog = this.d;
        if (dialog != null && dialog.isShowing()) {
            this.d.dismiss();
        }
        runOnMainThread(new n(str));
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DiscordEvent discordEvent) {
        if (discordEvent.getEventType() == DiscordEvent.TYPE_ACTIVITY_STATUS) {
            if (!TextUtils.isEmpty(discordEvent.getErrorMsg())) {
                o5(discordEvent.getErrorMsg());
                return;
            }
            if (TextUtils.equals(DiscordEvent.STATUS_OVER, discordEvent.getStatus())) {
                is3.b bVar = new is3.b(this);
                bVar.p(ah4.e(R.string.qr_code_expired));
                bVar.b(false);
                bVar.o(ah4.e(R.string.common_ok));
                bVar.f(new r());
                cs3.h(bVar).show();
                return;
            }
            discordEvent.setEventType(DiscordEvent.TYPE_SCAN_QRCODE);
            EventBus.getDefault().post(discordEvent);
            U4();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(VideoPatternControlEvent videoPatternControlEvent) {
        if (!videoPatternControlEvent.isSuccess()) {
            if (this.g.isShowing()) {
                this.g.dismiss();
            }
            if (videoPatternControlEvent.getType() == 2) {
                if ((videoPatternControlEvent.hasParam("version") ? ((Integer) videoPatternControlEvent.getParam("version")).intValue() : 1) == 2) {
                    sg3.l(ah4.e(R.string.interactive_media_fail_to_sync));
                    return;
                }
            }
            sg3.h(R.string.lan_api_connect_service_error);
            return;
        }
        if (videoPatternControlEvent.getType() == 2) {
            if (this.g.isShowing()) {
                this.g.dismiss();
            }
            U4();
        }
    }
}
