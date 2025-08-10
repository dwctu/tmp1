package dc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.lovense.wear.R;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.bean.MessageHide;
import com.wear.bean.VMShareDataBean;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.main.longDistance.ChatPicturesActivity;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityWishList;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.iwatcher.ImageWatcher;
import dc.bo3;
import dc.fe3;
import dc.kn3;
import dc.qn3;
import dc.un3;
import dc.vn3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.qiujuer.genius.graphics.Blur;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: ChatItemMenuAction.java */
/* loaded from: classes3.dex */
public class e82 {
    public QRCodeActivity a;
    public sa2 e;
    public ImageWatcher f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public LottieAnimationView j;
    public so3 k;
    public ie3 l;
    public un3 b = null;
    public vn3 c = null;
    public qn3 d = null;
    public boolean m = true;
    public boolean n = true;
    public boolean o = false;
    public boolean p = false;
    public int r = -1;
    public List<String> s = new ArrayList();
    public List<ns3> t = new ArrayList();
    public List<CommunMessage> u = new ArrayList();
    public ImageView v = null;
    public Handler q = new e(Looper.getMainLooper());

    /* compiled from: ChatItemMenuAction.java */
    public class a implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public a(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.E(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class a0 implements bo3.d {
        public final /* synthetic */ CommunMessage a;

        public a0(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            e82.this.x(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class b implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public b(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.T(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class b0 implements View.OnClickListener {
        public final /* synthetic */ bo3 a;
        public final /* synthetic */ CommunMessage b;
        public final /* synthetic */ String c;

        public b0(bo3 bo3Var, CommunMessage communMessage, String str) {
            this.a = bo3Var;
            this.b = communMessage;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            e82 e82Var = e82.this;
            if (!e82Var.d0(e82Var.b, this.b, false)) {
                sg3.h(R.string.chat_recall_morethen_2min);
                return;
            }
            EntitySystem entitySystem = new EntitySystem();
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C320.toString(), this.c);
            this.b.sendEntity(entitySystem);
            DaoUtils.getCommunMessageDao().update((CommunMessageDao) this.b);
            DaoUtils.getReCallDao().delById(this.b.getId());
            e82.this.e.notifyDataSetChanged();
            if (e82.this.u.size() <= 1) {
                e82.this.f.setVisibility(8);
                e82.this.g.setVisibility(8);
                e82.this.h.setVisibility(8);
                e82.this.i.setVisibility(8);
            } else {
                e82 e82Var2 = e82.this;
                int i = e82Var2.r;
                if (i >= 0) {
                    if (i == 0) {
                        e82Var2.f0(e82Var2.u.get(i + 1));
                    } else {
                        e82Var2.f0(e82Var2.u.get(i - 1));
                    }
                }
            }
            zb2.O().F0(WearUtils.x, this.b.getTo(), entitySystem);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class c implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public c(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.A(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class c0 implements View.OnClickListener {
        public final /* synthetic */ CommunMessage a;

        public c0(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e82.this.z(this.a);
            e82.this.d.dismiss();
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class d implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public d(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.E(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class d0 implements qn3.a {
        public d0(e82 e82Var) {
        }

        @Override // dc.qn3.a
        public void a(View view) {
            view.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_more_up2);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                e82.this.f.B();
                return;
            }
            if (i == 153 && e82.this.i != null) {
                if (e82.this.p) {
                    e82.this.i.setVisibility(8);
                } else {
                    e82.this.i.setVisibility(0);
                }
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class e0 implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public e0(e82 e82Var, CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            fg3.a(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class f implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public f(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            String text = ((EntityChat) this.a.getDataBean()).getText();
            if (WearUtils.e1(text)) {
                return;
            }
            WearUtils.p(text, e82.this.a);
            sg3.i(e82.this.a, R.string.chat_message_item_copy_notice);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class f0 implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public f0(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) throws IOException {
            e82.this.R(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class g implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public g(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.A(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class g0 implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public g0(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.A(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class h implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public h(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.E(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class i implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public i(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            String wishListUrl = ((EntityWishList) this.a.getDataBean()).getWishListUrl();
            if (WearUtils.e1(wishListUrl)) {
                return;
            }
            WearUtils.p(wishListUrl + "?_utm_pro=2112141049", e82.this.a);
            sg3.i(e82.this.a, R.string.chat_message_item_copy_notice);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class j implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public j(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.A(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class k implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public k(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.E(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class l implements vn3.b {
        public final /* synthetic */ vn3 a;
        public final /* synthetic */ CommunMessage b;
        public final /* synthetic */ String c;

        /* compiled from: ChatItemMenuAction.java */
        public class a implements kn3.d {
            public a(l lVar) {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
            }
        }

        /* compiled from: ChatItemMenuAction.java */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EntitySystem entitySystem = new EntitySystem();
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C320.toString(), l.this.c);
                l.this.b.sendEntity(entitySystem);
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) l.this.b);
                l lVar = l.this;
                e82.this.e.R2(lVar.a.i, lVar.b);
                DaoUtils.getReCallDao().delById(l.this.b.getId());
                if (l.this.b.isFromGroup()) {
                    CommunMessage communMessage = new CommunMessage();
                    communMessage.setFrom(WearUtils.y.p());
                    communMessage.setTo(l.this.b.getTo());
                    communMessage.sendEntity(entitySystem);
                    communMessage.setId(WearUtils.E());
                    zb2.O().G0(communMessage.getTo(), communMessage, false, null);
                } else {
                    zb2.O().F0(WearUtils.x, l.this.b.getTo(), entitySystem);
                }
                e82.this.e.dissDialog();
            }
        }

        /* compiled from: ChatItemMenuAction.java */
        public class c implements ip1 {
            public c() {
            }

            @Override // dc.ip1
            public void G() {
                sg3.h(R.string.chat_recall_fail);
                e82.this.e.dissDialog();
            }

            @Override // dc.ip1
            public void d() {
                e82.this.e.cancleDelay();
            }
        }

        public l(vn3 vn3Var, CommunMessage communMessage, String str) {
            this.a = vn3Var;
            this.b = communMessage;
            this.c = str;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            if (!dh3.d(e82.this.e)) {
                kn3 kn3Var = new kn3((Context) e82.this.a, ah4.e(R.string.chat_nonsupport_recall), ah4.e(R.string.common_ok), false, false, (kn3.d) new a(this));
                kn3Var.show();
                kn3Var.n();
            } else {
                if (!e82.this.c0(this.a, this.b, false)) {
                    sg3.h(R.string.chat_recall_morethen_2min);
                    return;
                }
                if (ep1.b().r(e82.this.a, new gp1(new b(), new c()))) {
                    e82.this.e.showDialog();
                }
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class m implements un3.b {
        public final /* synthetic */ un3 a;
        public final /* synthetic */ CommunMessage b;
        public final /* synthetic */ String c;

        /* compiled from: ChatItemMenuAction.java */
        public class a implements kn3.d {
            public a(m mVar) {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
            }
        }

        /* compiled from: ChatItemMenuAction.java */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EntitySystem entitySystem = new EntitySystem();
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C320.toString(), m.this.c);
                m.this.b.sendEntity(entitySystem);
                DaoUtils.getCommunMessageDao().update((CommunMessageDao) m.this.b);
                m mVar = m.this;
                e82.this.e.R2(mVar.a.g, mVar.b);
                DaoUtils.getReCallDao().delById(m.this.b.getId());
                if (m.this.b.isFromGroup()) {
                    CommunMessage communMessage = new CommunMessage();
                    communMessage.setFrom(WearUtils.y.p());
                    communMessage.setTo(m.this.b.getTo());
                    communMessage.sendEntity(entitySystem);
                    communMessage.setId(WearUtils.E());
                    zb2.O().G0(communMessage.getTo(), communMessage, false, null);
                } else {
                    zb2.O().F0(WearUtils.x, m.this.b.getTo(), entitySystem);
                }
                e82.this.e.dissDialog();
            }
        }

        /* compiled from: ChatItemMenuAction.java */
        public class c implements ip1 {
            public c() {
            }

            @Override // dc.ip1
            public void G() {
                sg3.h(R.string.chat_recall_fail);
                e82.this.e.dissDialog();
            }

            @Override // dc.ip1
            public void d() {
                e82.this.e.cancleDelay();
            }
        }

        public m(un3 un3Var, CommunMessage communMessage, String str) {
            this.a = un3Var;
            this.b = communMessage;
            this.c = str;
        }

        @Override // dc.un3.b
        public void a(int i) {
            if (!dh3.d(e82.this.e)) {
                kn3 kn3Var = new kn3((Context) e82.this.a, ah4.e(R.string.chat_nonsupport_recall), ah4.e(R.string.common_ok), false, false, (kn3.d) new a(this));
                kn3Var.show();
                kn3Var.n();
            } else {
                if (!e82.this.d0(this.a, this.b, false)) {
                    sg3.h(R.string.chat_recall_morethen_2min);
                    return;
                }
                if (ep1.b().r(e82.this.a, new gp1(new b(), new c()))) {
                    e82.this.e.showDialog();
                }
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class n implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public n(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.x(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class o implements vn3.b {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ int b;

        public o(CommunMessage communMessage, int i) {
            this.a = communMessage;
            this.b = i;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.Q(this.a, this.b);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class p implements fe3.b {
        public p() {
        }

        @Override // dc.fe3.b
        public void a(long j) {
        }

        @Override // dc.fe3.b
        public void b(String str) {
            sg3.l(str);
        }

        @Override // dc.fe3.b
        public void c(String str) {
            File file = new File(str);
            if (file.exists()) {
                e82.this.U(file);
            } else {
                sg3.l(ah4.e(R.string.file_notfound));
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class q implements vn3.c {
        public q(e82 e82Var) {
        }

        @Override // dc.vn3.c
        public void a(View view) {
            view.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_more_up2);
        }

        @Override // dc.vn3.c
        public void b(View view) {
            view.findViewById(R.id.root_layout).setBackgroundResource(R.drawable.menu_more_down2);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e82 e82Var = e82.this;
            CommunMessage communMessage = e82Var.u.get(e82Var.f.P);
            if (communMessage != null) {
                Intent intent = new Intent(e82.this.a, (Class<?>) ChatPicturesActivity.class);
                intent.putExtra("extras_friend_id", e82.this.e.C().getId());
                intent.putExtra("extras_massage_id", communMessage.getId());
                e82.this.a.startActivityForResult(intent, 28784);
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e82.this.V();
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException {
            e82 e82Var = e82.this;
            CommunMessage communMessage = e82Var.u.get(e82Var.f.P);
            if (communMessage != null) {
                e82 e82Var2 = e82.this;
                e82Var2.r = e82Var2.f.P;
                e82.this.R(communMessage);
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class u implements ImageWatcher.h {
        public u() {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.h
        public void a(int i) {
            sa2 sa2Var = e82.this.e;
            if (sa2Var != null) {
                sa2Var.Z3();
            }
            e82.this.g.setVisibility(8);
            e82.this.h.setVisibility(8);
            e82.this.i.setVisibility(8);
            if (i < e82.this.u.size()) {
                CommunMessage communMessage = e82.this.u.get(i);
                boolean zIsSelfMessage = communMessage.isSelfMessage(WearUtils.y.r());
                if ((communMessage == null || communMessage.getType() != MessageType.burnpicture) && !e82.this.o) {
                    return;
                }
                e82.this.o = false;
                if (e82.this.j != null && !zIsSelfMessage) {
                    e82.this.j.setVisibility(8);
                    e82.this.j.setProgress(0.0f);
                    e82.this.j.g();
                }
                sa2 sa2Var2 = e82.this.e;
                if (sa2Var2 != null) {
                    sa2Var2.Z2();
                }
                if (zIsSelfMessage) {
                    return;
                }
                e82.this.q.removeMessages(1);
            }
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.h
        public void b(int i, GifImageView gifImageView, Object obj) {
            sa2 sa2Var = e82.this.e;
            if (sa2Var != null) {
                sa2Var.W3();
            }
            if (i < e82.this.u.size()) {
                CommunMessage communMessage = e82.this.u.get(i);
                if (communMessage != null && e82.this.F(communMessage.getId())) {
                    e82.this.v(gifImageView, obj);
                    return;
                }
                if (gifImageView == null || obj == null) {
                    return;
                }
                if (obj instanceof Drawable) {
                    gifImageView.setImageDrawable((Drawable) obj);
                } else if (obj instanceof Bitmap) {
                    gifImageView.setImageBitmap((Bitmap) obj);
                }
                boolean zIsSelfMessage = communMessage.isSelfMessage(WearUtils.y.r());
                if (communMessage.getType() == MessageType.burnpicture) {
                    sa2 sa2Var2 = e82.this.e;
                    if (sa2Var2 != null) {
                        sa2Var2.C2(communMessage);
                    }
                    if (e82.this.j != null && !zIsSelfMessage) {
                        e82.this.j.setVisibility(0);
                        e82.this.j.r();
                    }
                    if (!zIsSelfMessage) {
                        e82.this.q.sendEmptyMessageDelayed(1, 5000L);
                    }
                    sa2 sa2Var3 = e82.this.e;
                    if (sa2Var3 != null) {
                        sa2Var3.T0(communMessage);
                    }
                }
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class v implements Runnable {
        public v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e82 e82Var = e82.this;
                HmsScan[] hmsScanArrDecodeWithBitmap = ScanUtil.decodeWithBitmap(e82.this.a, WearUtils.J1(e82Var.s.get(e82Var.r)), new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScanBase.QRCODE_SCAN_TYPE, HmsScanBase.DATAMATRIX_SCAN_TYPE).setPhotoMode(true).create());
                if (hmsScanArrDecodeWithBitmap == null || hmsScanArrDecodeWithBitmap.length <= 0) {
                    sg3.h(R.string.qrcode_not_lovense_qrcode);
                } else {
                    e82.this.h0(hmsScanArrDecodeWithBitmap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class w implements bo3.d {
        public final /* synthetic */ EntityPicture a;
        public final /* synthetic */ CommunMessage b;

        public w(EntityPicture entityPicture, CommunMessage communMessage) {
            this.a = entityPicture;
            this.b = communMessage;
        }

        @Override // dc.bo3.d
        public void a(int i) throws IOException {
            if (WearUtils.e1(this.a.getType()) || !this.a.getType().equals("emoji")) {
                e82.this.R(this.b);
            } else {
                fg3.a(this.b);
            }
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class x implements bo3.d {
        public final /* synthetic */ CommunMessage a;

        public x(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            e82.this.A(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class y implements bo3.d {
        public final /* synthetic */ CommunMessage a;

        public y(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            e82.this.E(this.a);
        }
    }

    /* compiled from: ChatItemMenuAction.java */
    public class z implements vn3.b {
        public final /* synthetic */ CommunMessage a;

        public z(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // dc.vn3.b
        public void a(int i) {
            e82.this.B(this.a);
        }
    }

    public e82(QRCodeActivity qRCodeActivity, sa2 sa2Var, so3 so3Var, ie3 ie3Var) {
        this.a = qRCodeActivity;
        this.e = sa2Var;
        this.k = so3Var;
        this.l = ie3Var;
        this.f = (ImageWatcher) qRCodeActivity.findViewById(R.id.v_image_watcher);
        this.g = (ImageView) qRCodeActivity.findViewById(R.id.v_images_list);
        this.h = (ImageView) qRCodeActivity.findViewById(R.id.v_image_download);
        this.i = (ImageView) qRCodeActivity.findViewById(R.id.v_image_scan);
        this.j = (LottieAnimationView) qRCodeActivity.findViewById(R.id.lottie_view_count_down);
    }

    public final void A(CommunMessage communMessage) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_message", communMessage);
        pj3.g(this.a, ForwardMessageActivity.class, bundle);
    }

    public final void B(CommunMessage communMessage) {
        String str = "forwardVMShareCard: " + CommunMessage.decrypt(communMessage.getData());
        VMShareDataBean vMShareDataBean = (VMShareDataBean) WearUtils.A.fromJson(CommunMessage.decrypt(communMessage.getData()), VMShareDataBean.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("vshare_data", vMShareDataBean);
        pj3.g(this.a, ForwardMessageActivity.class, bundle);
    }

    public final File C(CommunMessage communMessage) {
        DataEntityAbstract dataBean = communMessage.getDataBean();
        if (communMessage.isSelfMessage(WearUtils.y.r())) {
            EntityPicture entityPicture = (EntityPicture) dataBean;
            String localUrl = entityPicture.getLocalUrl();
            String type = entityPicture.getType();
            boolean z2 = !WearUtils.e1(type) && type.equals("emoji");
            if (!WearUtils.e1(localUrl) && (WearUtils.c0(localUrl).exists() || WearUtils.Z(localUrl).exists() || WearUtils.a0(localUrl).exists())) {
                return z2 ? WearUtils.Z(localUrl).exists() ? WearUtils.Z(localUrl) : WearUtils.a0(localUrl) : WearUtils.c0(localUrl);
            }
        }
        String str = WearUtils.e + ((EntityPicture) dataBean).getUrl();
        String strB = fu1.b(MyApplication.N(), str);
        if (!TextUtils.isEmpty(strB)) {
            str = strB;
        }
        fg3.f(str, fg3.d(str));
        return null;
    }

    public final String D(File file) {
        String strD = le3.d(file.getPath());
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        if (strD == null) {
            strD = le3.f(file);
        }
        sb.append(strD);
        return sb.toString();
    }

    public final void E(CommunMessage communMessage) {
        if (F(communMessage.getId())) {
            b0(communMessage.getId());
        } else {
            X(communMessage.getId());
        }
        this.e.notifyDataSetChanged();
    }

    public boolean F(String str) {
        return (this.e.r() == null || WearUtils.e1(str) || this.e.r().get(str) == null) ? false : true;
    }

    public final void G(vn3 vn3Var, CommunMessage communMessage, int i2) {
        c0(vn3Var, communMessage, true);
        I(vn3Var, communMessage, false);
    }

    public final void H(vn3 vn3Var, CommunMessage communMessage, int i2) {
        vn3Var.a(ah4.e(R.string.chat_message_item_action_copy), true, new f(communMessage), R.drawable.menu_more_copy);
        vn3Var.a(ah4.e(R.string.comman_forward), true, new g(communMessage), R.drawable.menu_more_share);
        if (!this.l.D(((EntityChat) communMessage.getDataBean()).getText())) {
            vn3Var.a(ah4.e(F(communMessage.getId()) ? R.string.comman_unhide : R.string.comman_hide), true, new h(communMessage), F(communMessage.getId()) ? R.drawable.menu_more_unhide : R.drawable.menu_more_hide);
        }
        L(vn3Var, communMessage, i2);
        c0(vn3Var, communMessage, true);
        I(vn3Var, communMessage, true);
    }

    public final void I(vn3 vn3Var, CommunMessage communMessage, boolean z2) {
        vn3Var.a(ah4.e(R.string.chat_message_item_action_delete), z2, new n(communMessage), R.drawable.menu_more_delete);
    }

    public final void J(vn3 vn3Var, CommunMessage communMessage, int i2) {
        c0(vn3Var, communMessage, true);
        I(vn3Var, communMessage, false);
    }

    public final void K(vn3 vn3Var, CommunMessage communMessage, int i2) {
        EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
        if (entityPicture == null) {
            return;
        }
        if (WearUtils.e1(entityPicture.getType()) || !entityPicture.getType().equals("emoji")) {
            vn3Var.a(ah4.e(R.string.common_save), true, new f0(communMessage), R.drawable.menu_more_save);
        } else if (!DaoUtils.getEmojiFavoriteDao().hasEmojiResource(entityPicture.getFileMd5())) {
            vn3Var.a(ah4.e(R.string.chat_favorite_meun_add), true, new e0(this, communMessage), R.drawable.pattern_more_add);
        }
        vn3Var.a(ah4.e(R.string.comman_forward), true, new g0(communMessage), R.drawable.menu_more_share);
        if (WearUtils.e1(entityPicture.getType()) || !entityPicture.getType().equals("emoji")) {
            vn3Var.a(ah4.e(F(communMessage.getId()) ? R.string.comman_unhide : R.string.comman_hide), true, new a(communMessage), F(communMessage.getId()) ? R.drawable.menu_more_unhide : R.drawable.menu_more_hide);
        }
        L(vn3Var, communMessage, i2);
        c0(vn3Var, communMessage, true);
        I(vn3Var, communMessage, true);
    }

    public final void L(vn3 vn3Var, CommunMessage communMessage, int i2) {
        vn3Var.a(ah4.e(R.string.chat_menu_reply), false, new o(communMessage, i2), R.drawable.menu_more_reply);
    }

    public final void M(vn3 vn3Var, CommunMessage communMessage, int i2) {
        vn3Var.a(ah4.e(R.string.common_save), true, new b(communMessage), R.drawable.menu_more_save);
        vn3Var.a(ah4.e(R.string.comman_forward), true, new c(communMessage), R.drawable.menu_more_share);
        vn3Var.a(ah4.e(F(communMessage.getId()) ? R.string.comman_unhide : R.string.comman_hide), true, new d(communMessage), F(communMessage.getId()) ? R.drawable.menu_more_unhide : R.drawable.menu_more_hide);
        L(vn3Var, communMessage, i2);
        c0(vn3Var, communMessage, true);
        I(vn3Var, communMessage, true);
    }

    public final void N(vn3 vn3Var, CommunMessage communMessage) {
        vn3Var.a(ah4.e(R.string.chat_message_item_action_copy), true, new i(communMessage), R.drawable.menu_more_copy);
        vn3Var.a(ah4.e(R.string.comman_forward), true, new j(communMessage), R.drawable.menu_more_share);
        vn3Var.a(ah4.e(F(communMessage.getId()) ? R.string.comman_unhide : R.string.comman_hide), true, new k(communMessage), F(communMessage.getId()) ? R.drawable.menu_more_unhide : R.drawable.menu_more_hide);
        c0(vn3Var, communMessage, true);
        I(vn3Var, communMessage, false);
    }

    public final void O(vn3 vn3Var, CommunMessage communMessage, int i2) {
        c0(vn3Var, communMessage, true);
        I(vn3Var, communMessage, false);
        vn3Var.a(ah4.e(R.string.comman_forward), true, new z(communMessage), R.drawable.menu_more_share);
    }

    public void P(ImageView imageView, String str, int i2) {
        this.r = i2;
        this.v = imageView;
        i0(imageView, this.u.get(i2));
    }

    public final void Q(CommunMessage communMessage, int i2) {
        this.e.A0(communMessage, i2);
    }

    public final void R(CommunMessage communMessage) throws IOException {
        communMessage.getDataBean();
        if (this.f.getVisibility() == 0) {
            int i2 = this.r;
            if (i2 != -1) {
                String str = this.s.get(i2);
                fg3.f(str, fg3.d(str));
                return;
            }
            return;
        }
        File fileC = C(communMessage);
        if (fileC == null || !fileC.exists()) {
            return;
        }
        S(fileC, D(fileC));
    }

    public final void S(File file, String str) throws IOException {
        if (file == null || !(file == null || file.exists())) {
            sg3.i(this.a, R.string.chat_message_item_save_error);
            return;
        }
        File fileR = WearUtils.R();
        if (file != null) {
            File file2 = new File(fileR, file.getName() + str);
            WearUtils.q(file, file2);
            sg3.k(this.a, String.format(ah4.e(R.string.chat_message_item_save_path), file2.getAbsoluteFile()));
            W(this.a, file2.getPath());
        }
    }

    public final void T(CommunMessage communMessage) {
        EntityShortVideo entityShortVideo = (EntityShortVideo) communMessage.getDataBean();
        if (!WearUtils.e1(entityShortVideo.getVideoLocalUrl()) && new File(entityShortVideo.getVideoLocalUrl()).exists()) {
            U(new File(entityShortVideo.getVideoLocalUrl()));
            return;
        }
        if (WearUtils.e1(entityShortVideo.getVideoUrl())) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("saveShortVideo videourl is null"));
            sg3.l(ah4.e(R.string.chat_message_item_save_error));
            return;
        }
        String str = entityShortVideo.getVideoUrl().replace(".mp4", "").split("/")[r0.length - 1];
        File file = new File(WearUtils.T("video").getAbsolutePath(), str);
        if (file.exists()) {
            U(file);
            return;
        }
        new fe3().n(WearUtils.e + entityShortVideo.getVideoUrl(), str, this.a, true, new p());
    }

    public final void U(File file) {
        if (file == null || !file.exists()) {
            sg3.i(this.a, R.string.chat_message_item_save_error);
        } else {
            fg3.g(this.a, file);
        }
    }

    public final void V() {
        int i2 = this.f.P;
        this.r = i2;
        if (i2 != -1) {
            new Thread(new v()).start();
        }
    }

    public void W(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            context.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    public void X(String str) {
        ImageView imageView;
        if (this.e.r() == null) {
            this.e.Q1(new HashMap<>());
        }
        if (!WearUtils.e1(str) && !WearUtils.e1(WearUtils.y.p())) {
            MessageHide messageHide = new MessageHide();
            messageHide.setId(str);
            messageHide.setOwnerJid(WearUtils.y.p());
            messageHide.setFriendJid(this.e.b0());
            DaoUtils.getMessageHideDao().addIfNotExist(messageHide);
            this.e.r().put(str, str);
        }
        if (this.f.getVisibility() != 0 || this.r == -1 || (imageView = this.v) == null) {
            return;
        }
        v(imageView, this.f.getImageResource());
    }

    public void Y(boolean z2) {
        this.n = z2;
    }

    public void Z(boolean z2) {
        this.m = z2;
    }

    public void a0(boolean z2) {
        this.o = z2;
    }

    public void b0(String str) {
        Object imageResource;
        if (this.e.r() != null && !WearUtils.e1(str)) {
            this.e.r().remove(str);
            DaoUtils.getMessageHideDao().delById(str);
        }
        if (this.f.getVisibility() != 0 || this.r == -1 || this.v == null || (imageResource = this.f.getImageResource()) == null) {
            return;
        }
        if (imageResource instanceof Drawable) {
            this.v.setImageDrawable((Drawable) imageResource);
        } else if (imageResource instanceof Bitmap) {
            this.v.setImageBitmap((Bitmap) imageResource);
        }
    }

    public final boolean c0(vn3 vn3Var, CommunMessage communMessage, boolean z2) {
        if (!og3.a(3)) {
            return false;
        }
        String strCanRecall = DaoUtils.getReCallDao().canRecall(communMessage.getId());
        boolean z3 = this.e.C().isExit() ? false : !WearUtils.e1(strCanRecall);
        if (z2 && z3) {
            vn3Var.a(ah4.e(R.string.comman_recall), true, new l(vn3Var, communMessage, strCanRecall), R.drawable.menu_more_recall);
        }
        return z3;
    }

    public final boolean d0(un3 un3Var, CommunMessage communMessage, boolean z2) {
        if (!og3.a(3)) {
            return false;
        }
        String strCanRecall = DaoUtils.getReCallDao().canRecall(communMessage.getId());
        boolean z3 = this.e.C().isExit() ? false : !WearUtils.e1(strCanRecall);
        if (z2 && z3) {
            un3Var.a(ah4.e(R.string.comman_recall), true, new m(un3Var, communMessage, strCanRecall));
        }
        return z3;
    }

    public void e0(View view, CommunMessage communMessage, int i2) {
        qn3 qn3Var = this.d;
        if (qn3Var != null) {
            qn3Var.dismiss();
            this.d = null;
        }
        qn3 qn3Var2 = new qn3(this.a);
        this.d = qn3Var2;
        qn3Var2.d(i2);
        this.d.a().setOnClickListener(new c0(communMessage));
        this.d.c(view, 108, -18, new d0(this));
        this.d.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f0(com.wear.protocol.CommunMessage r14) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.e82.f0(com.wear.protocol.CommunMessage):void");
    }

    public void g0(View view, CommunMessage communMessage, int i2) {
        vn3 vn3Var = this.c;
        if (vn3Var != null) {
            vn3Var.dismiss();
            this.c = null;
        }
        vn3 vn3Var2 = new vn3(this.a);
        this.c = vn3Var2;
        vn3Var2.e(i2);
        if (communMessage.getType() == MessageType.picture) {
            K(this.c, communMessage, i2);
        } else if (communMessage.getType() == MessageType.shortvideo) {
            M(this.c, communMessage, i2);
        } else if (communMessage.getType() == MessageType.chat) {
            H(this.c, communMessage, i2);
        } else if (communMessage.getType() == MessageType.wishlist) {
            N(this.c, communMessage);
        } else if (communMessage.getType() == MessageType.giftcard) {
            J(this.c, communMessage, i2);
        } else if (communMessage.getType() == MessageType.voice) {
            I(this.c, communMessage, true);
        } else if (communMessage.getType() == MessageType.burnpicture || communMessage.getType() == MessageType.burnvideo) {
            G(this.c, communMessage, i2);
        } else if (communMessage.getType() == MessageType.vmsharecard) {
            O(this.c, communMessage, i2);
        } else {
            MessageType type = communMessage.getType();
            MessageType messageType = MessageType.audio;
            if (type == messageType) {
                L(this.c, communMessage, i2);
            }
            if (communMessage.getType() == messageType || communMessage.getType() == MessageType.pattern) {
                c0(this.c, communMessage, true);
            }
            I(this.c, communMessage, false);
        }
        this.c.d(view, 0, 0, new q(this));
        this.c.show();
    }

    public final void h0(HmsScan[] hmsScanArr) {
        for (int i2 = 0; i2 < hmsScanArr.length; i2++) {
            String str = "扫码结果" + hmsScanArr[i2].showResult;
            this.a.Z4(hmsScanArr[i2].getOriginalValue());
        }
    }

    public final void i0(View view, CommunMessage communMessage) {
        if (communMessage.getType() == MessageType.picture) {
            EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
            bo3 bo3Var = new bo3(this.a, R.layout.bottom_sheet_chat_picture_longtouch);
            bo3Var.show();
            bo3Var.d(R.id.item_action_save, new w(entityPicture, communMessage));
            bo3Var.d(R.id.item_action_forward, new x(communMessage));
            bo3Var.d(R.id.item_action_hide, new y(communMessage));
            bo3Var.d(R.id.item_action_delete, new a0(communMessage));
            Button button = (Button) bo3Var.a(R.id.item_action_save);
            if (WearUtils.e1(entityPicture.getType()) || !entityPicture.getType().equals("emoji")) {
                button.setText(ah4.e(R.string.common_save));
                ((Button) bo3Var.a(R.id.item_action_hide)).setText(F(communMessage.getId()) ? R.string.comman_unhide : R.string.comman_hide);
            } else {
                View viewA = bo3Var.a(R.id.save_area_line);
                if (DaoUtils.getEmojiFavoriteDao().hasEmojiResource(entityPicture.getFileMd5())) {
                    button.setVisibility(8);
                    viewA.setVisibility(8);
                } else {
                    button.setText(ah4.e(R.string.chat_favorite_meun_add));
                }
                bo3Var.a(R.id.item_action_hide).setVisibility(8);
                bo3Var.a(R.id.hide_area_line).setVisibility(8);
            }
            String strCanRecall = DaoUtils.getReCallDao().canRecall(communMessage.getId());
            Button button2 = (Button) bo3Var.a(R.id.item_action_recall);
            View viewA2 = bo3Var.a(R.id.recall_area_line);
            if (d0(this.b, communMessage, false)) {
                button2.setOnClickListener(new b0(bo3Var, communMessage, strCanRecall));
            } else {
                button2.setVisibility(8);
                viewA2.setVisibility(8);
            }
        }
    }

    public void j0(CommunMessage communMessage) {
        if (this.u.size() > 0) {
            this.r = this.u.indexOf(communMessage);
        } else {
            this.r = -1;
        }
    }

    public final void v(ImageView imageView, Object obj) {
        if (obj != null) {
            Bitmap bitmapA = null;
            if (obj instanceof Drawable) {
                bitmapA = gg3.a((Drawable) obj);
            } else if (obj instanceof Bitmap) {
                bitmapA = (Bitmap) obj;
            }
            if (bitmapA != null) {
                Bitmap bitmapCopy = bitmapA.copy(bitmapA.getConfig(), true);
                int width = bitmapCopy.getWidth();
                int height = bitmapCopy.getHeight();
                int[] iArr = new int[width * height];
                bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
                Blur.c(iArr, width, height, 25);
                bitmapCopy.setPixels(iArr, 0, width, 0, 0, width, height);
                Blur.b(bitmapCopy, 25);
                imageView.setImageBitmap(bitmapCopy);
            }
        }
    }

    public void w() {
        ImageWatcher imageWatcher = this.f;
        if (imageWatcher != null) {
            imageWatcher.B();
        }
    }

    public void x(CommunMessage communMessage) {
        EntityPattern entityPattern;
        this.k.F();
        this.e.d0().remove(communMessage);
        this.e.v1(communMessage);
        DaoUtils.getCommunMessageDao().delT(communMessage);
        if (communMessage.getType() == MessageType.pattern && (entityPattern = (EntityPattern) communMessage.getDataBean()) != null && qf3.n(entityPattern.getUrl(), communMessage.getId())) {
            qf3.C();
        }
        this.e.notifyDataSetChanged();
        if (this.f.getVisibility() == 0 && this.r != -1) {
            if (this.u.size() <= 1) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                this.i.setVisibility(8);
            } else {
                int i2 = this.r;
                if (i2 >= 0) {
                    if (i2 == 0) {
                        f0(this.u.get(i2 + 1));
                    } else {
                        f0(this.u.get(i2 - 1));
                    }
                }
            }
        }
        if (communMessage.getType() == MessageType.alarm) {
            AlarmMessagingService.d(((EntityAlarm) communMessage.getDataBean()).getId(), true);
        }
        if (this.e.H1(false)) {
            this.e.H1(false);
        }
    }

    public void y() {
        vn3 vn3Var = this.c;
        if (vn3Var != null) {
            vn3Var.dismiss();
            this.c = null;
        }
        qn3 qn3Var = this.d;
        if (qn3Var != null) {
            qn3Var.dismiss();
            this.d = null;
        }
    }

    public void z(CommunMessage communMessage) {
        this.e.m2(communMessage);
    }
}
