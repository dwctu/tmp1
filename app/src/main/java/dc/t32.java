package dc;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.google.gson.JsonSyntaxException;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.wear.bean.Toy;
import com.wear.bean.ToyCtrlGameReceiveBean;
import com.wear.bean.ToyFeedbackBean;
import com.wear.bean.event.ToyCtrlGameEvent;
import com.wear.bean.event.ToyGserEvent;
import com.wear.util.WearUtils;
import dc.ef2;
import dc.or1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.ping.packet.Ping;

/* compiled from: ToyCtrlGameModeImpl.java */
/* loaded from: classes3.dex */
public class t32 {
    public static String g = "t32";
    public static volatile t32 h;
    public ef2 b;
    public Timer f;
    public String a = UUID.randomUUID().toString();
    public String c = "";
    public boolean d = false;
    public CopyOnWriteArrayList<c> e = new CopyOnWriteArrayList<>();

    /* compiled from: ToyCtrlGameModeImpl.java */
    public class a implements ef2 {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(WebSocket webSocket, Exception exc) {
            String unused = t32.g;
            String str = "WebSocket setClosedCallback: " + exc;
            t32.this.D(webSocket);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g(WebSocket webSocket, String str) {
            String unused = t32.g;
            String str2 = "WebSocket onStringAvailable: " + str;
            t32.this.v(webSocket, str);
        }

        @Override // dc.ef2
        public ef2.a a(final WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest) {
            ef2.a aVar = new ef2.a();
            aVar.b = false;
            String path = asyncHttpServerRequest.getPath();
            if (t32.this.d && "/v1".equals(path)) {
                String unused = t32.g;
                String str = "WebSocket address:" + webSocket.toString();
                aVar.b = true;
                c cVar = new c();
                cVar.b = webSocket;
                cVar.b();
                t32.this.e.add(cVar);
                webSocket.setClosedCallback(new CompletedCallback() { // from class: dc.p32
                    @Override // com.koushikdutta.async.callback.CompletedCallback
                    public final void onCompleted(Exception exc) {
                        this.a.e(webSocket, exc);
                    }
                });
                webSocket.setStringCallback(new WebSocket.StringCallback() { // from class: dc.q32
                    @Override // com.koushikdutta.async.http.WebSocket.StringCallback
                    public final void onStringAvailable(String str2) {
                        this.a.g(webSocket, str2);
                    }
                });
            }
            return aVar;
        }

        @Override // dc.ef2
        public void b(Exception exc) {
            String unused = t32.g;
            String str = "createFail___e: " + exc.getStackTrace();
        }

        @Override // dc.ef2
        public void c(String str, int i) {
            String unused = t32.g;
            String str2 = "createSuccess___ip: " + str + ", port: " + i;
        }
    }

    /* compiled from: ToyCtrlGameModeImpl.java */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            Iterator it = t32.this.e.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.a()) {
                    arrayList.add(cVar);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                t32.this.D(((c) it2.next()).b);
            }
        }
    }

    /* compiled from: ToyCtrlGameModeImpl.java */
    public static class c {
        public String a;
        public WebSocket b;
        public long c;

        public boolean a() {
            return be3.r() - this.c > 11000;
        }

        public void b() {
            this.c = be3.r();
        }
    }

    public static t32 j() {
        if (h == null) {
            synchronized (t32.class) {
                if (h == null) {
                    h = new t32();
                }
            }
        }
        return h;
    }

    public static boolean n() {
        Iterator<Toy> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            if (it.next().isFeedbackModeEnable()) {
                return true;
            }
        }
        return false;
    }

    public static int o() {
        Iterator<Toy> it = pc1.a.P().iterator();
        int iIsFeedbackModeEnableAndUpdateEnable = -1;
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isFeedbackModeEnableAndUpdateEnable() == 0) {
                return 0;
            }
            if (next.isFeedbackModeEnableAndUpdateEnable() != 1) {
                iIsFeedbackModeEnableAndUpdateEnable = next.isFeedbackModeEnableAndUpdateEnable();
            }
        }
        return iIsFeedbackModeEnableAndUpdateEnable;
    }

    public final void A() {
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f = null;
        }
        Timer timer2 = new Timer();
        this.f = timer2;
        timer2.schedule(new b(), 1000L, 5000L);
    }

    public final void B() {
        String str = "stopAllWebSocket: " + this.e.size();
        Iterator<c> it = this.e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            String str2 = "stopAllWebSocket: " + this.e.size();
            next.b.close();
        }
        this.e.clear();
    }

    public final void C() {
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f = null;
        }
    }

    public final void D(WebSocket webSocket) {
        webSocket.close();
        c cVarG = g(webSocket);
        if (cVarG != null) {
            this.e.remove(cVarG);
            EventBus.getDefault().post(new ToyCtrlGameEvent(20));
        }
        if (m()) {
            return;
        }
        or1.a aVar = or1.a;
        aVar.h();
        aVar.b(0);
    }

    public void f() {
        if (this.d) {
            return;
        }
        this.d = true;
        A();
        EventBus.getDefault().register(this);
        kf2 kf2VarM = kf2.m();
        if (this.b == null) {
            this.b = new a();
        }
        kf2VarM.b(this.b, "/v1", true);
    }

    public final c g(WebSocket webSocket) {
        if (webSocket == null) {
            return null;
        }
        Iterator<c> it = this.e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (webSocket == next.b) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<c> h() {
        WebSocket webSocket;
        ArrayList<c> arrayList = new ArrayList<>();
        Iterator<c> it = this.e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!TextUtils.isEmpty(next.a) && (webSocket = next.b) != null && webSocket.isOpen()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String i() {
        return this.a;
    }

    public final int[] k(ToyCtrlGameEvent toyCtrlGameEvent) {
        String str = toyCtrlGameEvent.value;
        String[] strArrSplit = str.substring(0, str.length() - 1).split(SignatureImpl.INNER_SEP);
        if (strArrSplit.length != 4) {
            return null;
        }
        try {
            return new int[]{Integer.parseInt(strArrSplit[1]), ExifInterface.GPS_MEASUREMENT_IN_PROGRESS.equals(strArrSplit[2]) ? 100 : Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3])};
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final int[] l(ToyGserEvent toyGserEvent) {
        if (toyGserEvent == null || TextUtils.isEmpty(toyGserEvent.getValue())) {
            return null;
        }
        String[] strArrSplit = toyGserEvent.getValue().replace(";", "").split(SignatureImpl.INNER_SEP);
        if (strArrSplit.length != 3) {
            return null;
        }
        try {
            return new int[]{Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2])};
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean m() {
        boolean z;
        Iterator<c> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            c next = it.next();
            if (!TextUtils.isEmpty(next.a) && next.b != null) {
                z = true;
                break;
            }
        }
        String str = "isFeedbackEnable:  " + z + ", gameBeanList: " + this.e.size();
        return z;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(xc1 xc1Var) {
        String str = "EventBusToyConnectEvent_____: " + xc1Var.b();
        int iB = xc1Var.b();
        if (iB == -1 || iB == 1) {
            Toy toyZ = z(xc1Var.a());
            StringBuilder sb = new StringBuilder();
            sb.append("EventBusToyConnectEvent_____isConnected: ");
            sb.append(toyZ != null ? Boolean.valueOf(toyZ.isConnected()) : null);
            sb.toString();
            if (toyZ == null || !toyZ.isConnected()) {
                return;
            }
            String str2 = "startFeedbackMode____getAddress: " + xc1Var.a();
            or1.a aVar = or1.a;
            aVar.g(toyZ);
            aVar.c(toyZ, 3);
        }
    }

    public final boolean p(WebSocket webSocket) {
        return webSocket != null && webSocket.isOpen();
    }

    public boolean q() {
        return this.d;
    }

    public final int r(int i) {
        if (i > 0 && i <= 150) {
            return 1;
        }
        if (150 >= i || i > 210) {
            return 210 < i ? 3 : 0;
        }
        return 2;
    }

    public final int s(int i, int i2) {
        if (i == i2) {
            return 20;
        }
        return (int) ((i * 20.0d) / i2);
    }

    public void t(String str) {
        if (TextUtils.equals(this.c, i())) {
            return;
        }
        ye3.j("game mode", "game_mode_send_lan_api", "send", i(), "", str, "", -1L);
        this.c = i();
    }

    public void u() {
        x(new ToyFeedbackBean("event-closed"));
        this.d = false;
        B();
        C();
        or1.a aVar = or1.a;
        aVar.h();
        aVar.b(0);
        EventBus.getDefault().unregister(this);
    }

    public final void v(WebSocket webSocket, String str) {
        c cVarG;
        c cVarG2;
        if (TextUtils.isEmpty(str) || !p(webSocket)) {
            return;
        }
        ToyCtrlGameReceiveBean toyCtrlGameReceiveBean = null;
        try {
            toyCtrlGameReceiveBean = (ToyCtrlGameReceiveBean) WearUtils.A.fromJson(str, ToyCtrlGameReceiveBean.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        if (toyCtrlGameReceiveBean == null || TextUtils.isEmpty(toyCtrlGameReceiveBean.type)) {
            return;
        }
        String str2 = toyCtrlGameReceiveBean.type;
        str2.hashCode();
        if (!str2.equals("access")) {
            if (str2.equals(Ping.ELEMENT) && (cVarG2 = g(webSocket)) != null) {
                cVarG2.b();
                w(webSocket, new ToyFeedbackBean("pong"));
                return;
            }
            return;
        }
        ToyCtrlGameReceiveBean.DataDTO dataDTO = toyCtrlGameReceiveBean.data;
        if (dataDTO == null || TextUtils.isEmpty(dataDTO.appName) || (cVarG = g(webSocket)) == null) {
            return;
        }
        cVarG.a = toyCtrlGameReceiveBean.data.appName;
        cVarG.b();
        w(webSocket, new ToyFeedbackBean("access-granted"));
        EventBus.getDefault().post(new ToyCtrlGameEvent(20));
        or1.a aVar = or1.a;
        aVar.f();
        aVar.b(3);
        y();
    }

    public final boolean w(WebSocket webSocket, ToyFeedbackBean toyFeedbackBean) {
        boolean z = false;
        try {
            if (!p(webSocket)) {
                return false;
            }
            String jSONString = JSON.toJSONString(toyFeedbackBean);
            String str = "sendMsg__str: " + jSONString;
            webSocket.send(jSONString);
            z = true;
            t(toyFeedbackBean.type);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public final boolean x(ToyFeedbackBean toyFeedbackBean) {
        boolean z = false;
        try {
            String jSONString = JSON.toJSONString(toyFeedbackBean);
            String str = "gameBeanList: " + this.e.size() + "\nsendMsg__str: " + jSONString;
            Iterator<c> it = this.e.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (p(next.b)) {
                    next.b.send(jSONString);
                    z = true;
                }
            }
            t(toyFeedbackBean.type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public final void y() {
        if (m()) {
            ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
            toyFeedbackBean.type = "toy-list";
            toyFeedbackBean.toyList = new ArrayList();
            Iterator<Toy> it = pc1.a.p().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isFeedbackModeEnable()) {
                    ToyFeedbackBean.ToyListDTO toyListDTO = new ToyFeedbackBean.ToyListDTO();
                    toyListDTO.id = next.getDeviceId();
                    toyListDTO.name = next.getSimpleName();
                    toyListDTO.type = next.getType();
                    int iTypeInt = next.typeInt();
                    String str = "";
                    if (iTypeInt > 1) {
                        str = "" + iTypeInt;
                    }
                    toyListDTO.hVersion = str;
                    toyListDTO.fVersion = Integer.valueOf(next.getToyVersion());
                    toyListDTO.nickname = next.getDefineRename();
                    toyListDTO.battery = Integer.valueOf(next.getBattery());
                    toyListDTO.connected = Boolean.valueOf(next.isConnected());
                    toyFeedbackBean.toyList.add(toyListDTO);
                }
            }
            x(toyFeedbackBean);
        }
    }

    public final Toy z(String str) {
        if (!m()) {
            return null;
        }
        Iterator<Toy> it = pc1.a.p().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (TextUtils.equals(str, next.getAddress()) && next.isFeedbackModeEnable()) {
                ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
                toyFeedbackBean.type = "toy-status";
                toyFeedbackBean.toyId = next.getDeviceId();
                ToyFeedbackBean.DataDTO dataDTO = new ToyFeedbackBean.DataDTO();
                toyFeedbackBean.data = dataDTO;
                dataDTO.connected = Boolean.valueOf(next.isConnected());
                x(toyFeedbackBean);
                return next;
            }
        }
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(uc1 uc1Var) {
        String str = "EventBusToyAddOrDeleteEvent_____: " + uc1Var.a();
        int iA = uc1Var.a();
        if (iA == -10 || iA == 10) {
            y();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ToyCtrlGameEvent toyCtrlGameEvent) {
        if (toyCtrlGameEvent.type == 21) {
            String str = "ToyCtrlGameEvent__value: " + toyCtrlGameEvent.value;
            int[] iArrK = k(toyCtrlGameEvent);
            if (iArrK != null) {
                Toy toyO = pc1.a.O(toyCtrlGameEvent.address);
                if (toyO.isFeedbackModeEnable()) {
                    ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
                    toyFeedbackBean.feedback = WearUtils.B ? toyCtrlGameEvent.value : null;
                    toyFeedbackBean.toyId = toyO.getDeviceId();
                    ToyFeedbackBean.DataDTO dataDTO = new ToyFeedbackBean.DataDTO();
                    toyFeedbackBean.data = dataDTO;
                    switch (iArrK[0]) {
                        case 0:
                            toyFeedbackBean.type = "button-down";
                            dataDTO.index = Integer.valueOf(iArrK[1]);
                            toyO.setFeedbackDownTime(be3.r());
                            break;
                        case 1:
                            toyFeedbackBean.type = "button-up";
                            dataDTO.index = Integer.valueOf(iArrK[1]);
                            break;
                        case 2:
                            toyFeedbackBean.type = "function-strength-changed";
                            dataDTO.function = "vibration";
                            dataDTO.index = Integer.valueOf(iArrK[1]);
                            toyFeedbackBean.data.value = Integer.valueOf(iArrK[2]);
                            break;
                        case 3:
                            toyFeedbackBean.type = "function-strength-changed";
                            dataDTO.function = "rotitaion";
                            dataDTO.index = Integer.valueOf(iArrK[1]);
                            toyFeedbackBean.data.value = Integer.valueOf(iArrK[2]);
                            break;
                        case 4:
                            toyFeedbackBean.type = "shake-frequency-changed";
                            dataDTO.value = Integer.valueOf(s(iArrK[2], 4));
                            break;
                        case 5:
                            return;
                        case 6:
                            toyFeedbackBean.type = "depth-changed";
                            dataDTO.value = Integer.valueOf(s(iArrK[2], 3));
                            break;
                        case 7:
                        case 10:
                            toyFeedbackBean.type = "function-strength-changed";
                            dataDTO.function = "inflation";
                            dataDTO.index = Integer.valueOf(iArrK[1]);
                            toyFeedbackBean.data.value = Integer.valueOf(r(iArrK[2] * 10));
                            break;
                        case 8:
                            return;
                        case 9:
                            toyFeedbackBean.type = "function-strength-changed";
                            dataDTO.function = "inflation";
                            dataDTO.index = Integer.valueOf(iArrK[1]);
                            toyFeedbackBean.data.value = 0;
                            break;
                        case 11:
                            toyFeedbackBean.type = "battery-changed";
                            dataDTO.value = Integer.valueOf(iArrK[2]);
                            break;
                    }
                    Integer num = toyFeedbackBean.data.index;
                    if (num != null && num.intValue() == 100) {
                        toyFeedbackBean.data.index = 0;
                        x(toyFeedbackBean);
                        if (iArrK[0] == 2 && toyO.isSupportV1V2()) {
                            toyFeedbackBean.data.index = 1;
                            x(toyFeedbackBean);
                        }
                    } else {
                        x(toyFeedbackBean);
                    }
                    if (iArrK[0] != 1 || be3.r() - toyO.getFeedbackDownTime() > 300) {
                        return;
                    }
                    toyFeedbackBean.type = "button-pressed";
                    x(toyFeedbackBean);
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ToyGserEvent toyGserEvent) {
        Toy toyO;
        String str = "ToyGserEvent__value: " + toyGserEvent.toString();
        int[] iArrL = l(toyGserEvent);
        if (iArrL == null || iArrL.length != 2 || (toyO = pc1.a.O(toyGserEvent.getAddress())) == null || !toyO.isFeedbackModeEnable()) {
            return;
        }
        ToyFeedbackBean toyFeedbackBean = new ToyFeedbackBean();
        toyFeedbackBean.feedback = WearUtils.B ? toyGserEvent.getValue() : null;
        toyFeedbackBean.type = "shake-frequency-changed";
        toyFeedbackBean.toyId = toyO.getDeviceId();
        ToyFeedbackBean.DataDTO dataDTO = new ToyFeedbackBean.DataDTO();
        toyFeedbackBean.data = dataDTO;
        dataDTO.value = Integer.valueOf(s(iArrL[0], 4));
        x(toyFeedbackBean);
        if (iArrL[1] == 1) {
            ToyFeedbackBean toyFeedbackBean2 = new ToyFeedbackBean();
            toyFeedbackBean2.feedback = WearUtils.B ? toyGserEvent.getValue() : null;
            toyFeedbackBean2.type = "shake";
            toyFeedbackBean2.toyId = toyO.getDeviceId();
            x(toyFeedbackBean2);
        }
    }
}
