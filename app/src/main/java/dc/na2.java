package dc;

import android.os.Handler;
import android.os.Looper;
import com.lovense.wear.R;
import com.wear.bean.User;
import com.wear.bean.chat.PanelStatus;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.main.longDistance.control.LDRControl;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ChatControl.java */
/* loaded from: classes3.dex */
public class na2 extends rz1 implements tz1 {
    public final Set<b> a;
    public c83 b;
    public ChatLiveControl c;
    public ChatSyncControl d;
    public ChatVideoControl e;
    public ChatGroupControl f;
    public ChatDSControl g;
    public MyApplication h;
    public long i;
    public int j;
    public HashMap<String, Long> k;
    public Handler l;

    /* compiled from: ChatControl.java */
    public class a extends TimerTask {

        /* compiled from: ChatControl.java */
        /* renamed from: dc.na2$a$a, reason: collision with other inner class name */
        public class RunnableC0201a implements Runnable {
            public RunnableC0201a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    na2 na2Var = na2.this;
                    long j = na2Var.i + 1;
                    na2Var.i = j;
                    boolean z = j % 10 == 0;
                    for (b bVar : na2Var.a) {
                        bVar.k();
                        if (z) {
                            bVar.g();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            na2.this.l.post(new RunnableC0201a());
        }
    }

    /* compiled from: ChatControl.java */
    public interface b {
        void g();

        void k();
    }

    /* compiled from: ChatControl.java */
    public static class c {
        public static final na2 a = new na2(null);
    }

    public /* synthetic */ na2(a aVar) {
        this();
    }

    public static na2 m() {
        return c.a;
    }

    public boolean d() {
        return this.d.r() && this.d.P0() == 1;
    }

    public boolean e() {
        return d83.w().getD().booleanValue();
    }

    public boolean f() {
        return this.c.z() || this.d.z() || this.e.z() || this.f.z() || this.g.z() || this.b.z();
    }

    public boolean g(IPeopleInfo iPeopleInfo, MessageType messageType) {
        if (this.c.r()) {
            if (this.c.D(iPeopleInfo.getId()) && messageType == MessageType.live) {
                this.c.b1();
            } else {
                t();
            }
            return false;
        }
        if (this.d.r()) {
            if (this.d.D(iPeopleInfo.getId()) && messageType == MessageType.sync) {
                this.d.F1();
            } else {
                t();
            }
            return false;
        }
        if (this.f.r()) {
            if (this.f.D(iPeopleInfo.getId()) && messageType == MessageType.sync) {
                this.f.q3();
            } else {
                t();
            }
            return false;
        }
        if (this.g.r()) {
            if (this.g.D(iPeopleInfo.getId()) && messageType == MessageType.live) {
                this.g.z2();
            } else {
                t();
            }
            return false;
        }
        if (!this.e.r()) {
            return true;
        }
        if (this.e.D(iPeopleInfo.getId()) && messageType == MessageType.video && this.e.t.g()) {
            this.e.E1(true);
        } else if (this.e.D(iPeopleInfo.getId()) && messageType == MessageType.voice && !this.e.t.g()) {
            this.e.E1(true);
        } else {
            t();
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.wear.bean.handlerbean.IPeopleInfo] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.wear.bean.handlerbean.IPeopleInfo] */
    @Override // dc.tz1
    public int getPriority() {
        User userB1;
        ?? J;
        ?? J2;
        if (this.c.z() && (J2 = this.c.J()) != 0 && J2.isDateIng()) {
            return 24;
        }
        if (this.d.z() && (J = this.d.J()) != 0 && J.isDateIng()) {
            return 24;
        }
        return (this.e.z() && (userB1 = this.e.b1()) != null && userB1.isDateIng()) ? 24 : 8;
    }

    public boolean h(IPeopleInfo iPeopleInfo, MessageType messageType) {
        if (my2.i.a().getB()) {
            t();
            return false;
        }
        if (this.b.r()) {
            t();
            return false;
        }
        if (this.c.r()) {
            if (this.c.D(iPeopleInfo.getId()) && messageType == MessageType.live) {
                this.c.b1();
            } else {
                t();
            }
            return false;
        }
        if (this.d.r()) {
            if (this.d.D(iPeopleInfo.getId()) && messageType == MessageType.sync) {
                this.d.F1();
            } else {
                t();
            }
            return false;
        }
        if (this.f.r()) {
            if (this.f.D(iPeopleInfo.getId()) && messageType == MessageType.sync) {
                this.f.q3();
            } else {
                t();
            }
            return false;
        }
        if (this.g.r()) {
            if (this.g.D(iPeopleInfo.getId()) && messageType == MessageType.live) {
                this.g.z2();
            } else {
                t();
            }
            return false;
        }
        if (!this.e.r()) {
            if (iPeopleInfo.isOnline() || !(iPeopleInfo instanceof User)) {
                return true;
            }
            sg3.k(this.h, String.format(ah4.e(R.string.str_chatroom_partner_offline), iPeopleInfo.getShowNickName()));
            return false;
        }
        if (this.e.D(iPeopleInfo.getId()) && messageType == MessageType.video && this.e.t.g()) {
            this.e.E1(true);
        } else if (this.e.D(iPeopleInfo.getId()) && messageType == MessageType.voice && !this.e.t.g()) {
            this.e.E1(true);
        } else {
            t();
        }
        return false;
    }

    public boolean i() {
        return this.c.r() || this.d.r() || this.e.r() || this.f.r() || this.g.r() || this.b.r() || my2.i.a().getB();
    }

    public boolean k(IPeopleInfo iPeopleInfo) {
        return this.c.r() ? this.c.D(iPeopleInfo.getId()) : this.d.r() ? this.d.D(iPeopleInfo.getId()) : this.f.r() ? this.f.D(iPeopleInfo.getId()) : this.g.r() ? this.g.D(iPeopleInfo.getId()) : this.e.r() && this.e.D(iPeopleInfo.getId());
    }

    public boolean l() {
        return this.c.r() || this.d.r() || this.e.r() || this.f.r() || this.g.r();
    }

    public LDRControl o() {
        if (this.d.r()) {
            return this.d.p;
        }
        if (this.e.r()) {
            return this.e.o;
        }
        return null;
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    public String r() {
        PanelStatus panelStatus = new PanelStatus();
        if (this.c.z()) {
            panelStatus.setControlType("LiveControl");
        } else if (this.d.z()) {
            panelStatus.setControlType("SyncControl");
            ChatSyncControl chatSyncControl = this.d;
            if (chatSyncControl.p.e) {
                panelStatus.setPanelMode(2);
                panelStatus.setControlToyMac(this.d.p.g.getAddress());
            } else if (chatSyncControl.P0() == 4) {
                panelStatus.setPanelMode(3);
            } else {
                panelStatus.setPanelMode(1);
            }
            if (this.d.b.isLDRMutualControl()) {
                panelStatus.setControlMode(2);
            } else if (this.d.b.getLiveStatus() == 1) {
                panelStatus.setControlMode(Integer.valueOf(this.d.b.getLiveStatus()));
            } else if (this.d.b.getLiveStatus() == 2) {
                panelStatus.setControlMode(3);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(User.FEATURE_IS_SUPPORT_LDR_FILL_SOLACE);
            panelStatus.setFeatures(arrayList);
        }
        return WearUtils.A.toJson(panelStatus);
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public void s(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.d.r()) {
            this.d.j1(i, i2, i3, i4, i5, i6, i7, i8);
        }
    }

    @Override // dc.tz1
    public void stop(int i) {
        this.c.M(i);
        this.d.M(i);
        this.e.M(i);
        this.f.M(i);
        this.g.M(i);
    }

    public boolean t() {
        if (my2.i.a().getB()) {
            sg3.k(this.h, ah4.e(R.string.roulette_conflict_toast));
            return true;
        }
        if (this.b.z() && !this.b.d0()) {
            sg3.k(this.h, ah4.e(R.string.control_link_conflict_toast));
            return true;
        }
        if (this.c.z()) {
            sg3.k(this.h, ah4.e(R.string.live_conflict_toast));
            return true;
        }
        if (this.d.z()) {
            sg3.k(this.h, ah4.e(R.string.sync_conflict_toast));
            return true;
        }
        if (this.f.z()) {
            sg3.k(this.h, ah4.e(R.string.sync_conflict_toast));
            return true;
        }
        if (this.g.z()) {
            sg3.k(this.h, ah4.e(R.string.ds_control_conflict_with_ds));
            return true;
        }
        if (!this.e.z()) {
            return false;
        }
        sg3.k(this.h, this.e.k1() ? ah4.e(R.string.video_conflict_toast) : ah4.e(R.string.voice_conflict_toast));
        return true;
    }

    public boolean u(IPeopleInfo iPeopleInfo) {
        if (this.c.r() && this.c.D(iPeopleInfo.getId())) {
            return false;
        }
        if (this.d.r() && this.d.D(iPeopleInfo.getId())) {
            return false;
        }
        if (this.f.r() && this.f.D(iPeopleInfo.getId())) {
            return false;
        }
        return (this.g.r() && this.g.D(iPeopleInfo.getId())) ? false : true;
    }

    public void v() {
        this.c.M(this.j);
        this.d.M(this.j);
        this.e.M(this.j);
        this.f.M(this.j);
        this.g.M(this.j);
    }

    public void w() {
        if (this.c.z()) {
            this.c.a();
        }
        if (this.d.z()) {
            this.d.a();
        }
        if (this.f.z()) {
            this.f.a();
        }
        if (this.g.z()) {
            this.g.a();
        }
        if (this.b.z()) {
            this.b.a();
        }
    }

    public void x() {
        if (this.c.z()) {
            this.c.a();
        }
        if (this.d.z()) {
            this.d.a();
        }
        if (this.f.z()) {
            this.f.a();
        }
        if (this.g.z()) {
            this.g.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(java.lang.String r9, com.wear.bean.ToyBean r10, boolean r11) {
        /*
            r8 = this;
            long r0 = java.lang.System.currentTimeMillis()
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r3 = "all"
            if (r2 == 0) goto L21
            java.util.HashMap<java.lang.String, java.lang.Long> r2 = r8.k
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L36
            java.util.HashMap<java.lang.String, java.lang.Long> r2 = r8.k
            java.lang.Object r2 = r2.get(r3)
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            goto L38
        L21:
            java.util.HashMap<java.lang.String, java.lang.Long> r2 = r8.k
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L36
            java.util.HashMap<java.lang.String, java.lang.Long> r2 = r8.k
            java.lang.Object r2 = r2.get(r9)
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            goto L38
        L36:
            r4 = 0
        L38:
            long r4 = r0 - r4
            r6 = 500(0x1f4, double:2.47E-321)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L74
            com.wear.main.longDistance.control.ChatSyncControl r2 = r8.d
            boolean r2 = r2.r()
            if (r2 == 0) goto L4e
            com.wear.main.longDistance.control.ChatSyncControl r2 = r8.d
            r2.R1(r9, r10, r11)
            goto L5b
        L4e:
            com.wear.main.longDistance.control.ChatVideoControl r2 = r8.e
            boolean r2 = r2.r()
            if (r2 == 0) goto L5b
            com.wear.main.longDistance.control.ChatVideoControl r2 = r8.e
            r2.a2(r10, r11)
        L5b:
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L6b
            java.util.HashMap<java.lang.String, java.lang.Long> r9 = r8.k
            java.lang.Long r10 = java.lang.Long.valueOf(r0)
            r9.put(r3, r10)
            goto L74
        L6b:
            java.util.HashMap<java.lang.String, java.lang.Long> r10 = r8.k
            java.lang.Long r11 = java.lang.Long.valueOf(r0)
            r10.put(r9, r11)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.na2.y(java.lang.String, com.wear.bean.ToyBean, boolean):void");
    }

    public na2() {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.a = copyOnWriteArraySet;
        new Timer();
        this.j = 8;
        this.k = new HashMap<>();
        this.l = new Handler(Looper.getMainLooper());
        this.b = c83.R1();
        this.c = ChatLiveControl.q0();
        this.d = ChatSyncControl.N0();
        this.e = ChatVideoControl.a1();
        this.f = ChatGroupControl.o1();
        this.g = ChatDSControl.r1();
        this.h = WearUtils.x;
        sz1.d().n(this);
        copyOnWriteArraySet.add(this.c);
        copyOnWriteArraySet.add(this.d);
        copyOnWriteArraySet.add(this.e);
        copyOnWriteArraySet.add(this.f);
        copyOnWriteArraySet.add(this.g);
        new Timer().scheduleAtFixedRate(new a(), 1000L, 100L);
        this.i = 0L;
    }
}
