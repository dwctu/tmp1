package dc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.ScanVideoPatternQRBean;
import com.wear.bean.TimestampBean;
import com.wear.bean.Toy;
import com.wear.bean.ToySelectEvent;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.bean.event.VideoPatternControlEvent;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.chatBase.BaseAckRequestBean;
import com.wear.bean.socketio.timestamp.TimestampRequest;
import com.wear.bean.socketio.timestamp.TimestampResponse;
import com.wear.bean.socketio.videoPattern.CancelSyncPatternDTORequest;
import com.wear.bean.socketio.videoPattern.ErrorSyncPatternDTORequest;
import com.wear.bean.socketio.videoPattern.ExitPatternSyncDTORequest;
import com.wear.bean.socketio.videoPattern.MPEndRequest;
import com.wear.bean.socketio.videoPattern.MPPlayMediaResponse;
import com.wear.bean.socketio.videoPattern.MPQueryPlayStatusRequest;
import com.wear.bean.socketio.videoPattern.MPRemoteConnectToJsRequest;
import com.wear.bean.socketio.videoPattern.MPRemoteGetFileResponse;
import com.wear.bean.socketio.videoPattern.MPRemoteReceivedFileRequest;
import com.wear.bean.socketio.videoPattern.ModifyPatternResultDTORequest;
import com.wear.bean.socketio.videoPattern.ModifyVideoPatternDTOResponse;
import com.wear.bean.socketio.videoPattern.RemoteEditorRelationDTORequest;
import com.wear.bean.socketio.videoPattern.RemoteEditorRelationDTOResponse;
import com.wear.bean.socketio.videoPattern.SuccessDownloadPatternDTORequest;
import com.wear.bean.socketio.videoPattern.SuccessSyncPatternDTORequest;
import com.wear.bean.socketio.videoPattern.SyncModifyToyDTORequest;
import com.wear.bean.socketio.videoPattern.SyncPatternHeartbeatDTORequest;
import com.wear.bean.socketio.videoPattern.SyncReadyLoadPatternDTORequest;
import com.wear.bean.socketio.videoPattern.VideoProgressStatusDTOResponse;
import com.wear.broadcast.VideoPatternService;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import dc.mk2;
import dc.ue2;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function2;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* compiled from: VideoPatternControl.java */
/* loaded from: classes3.dex */
public class mk2 {
    public static final String K = "dc.mk2";
    public static mk2 L;
    public Subscription B;
    public Subscription C;
    public Subscription D;
    public Subscription E;
    public Subscription F;
    public Subscription G;
    public Handler H;
    public int I;
    public long a;
    public long b;
    public String d;
    public String e;
    public int f;
    public int g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public int o;
    public int p;
    public long r;
    public long s;
    public int t;
    public File u;
    public pc1 c = pc1.a;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public int q = 0;
    public HashMap<Integer, Integer> v = new HashMap<>();
    public HashMap<Integer, Integer> w = new HashMap<>();
    public HashMap<Integer, Integer> x = new HashMap<>();
    public HashMap<Integer, Integer> y = new HashMap<>();
    public HashMap<Integer, Integer> z = new HashMap<>();
    public HashMap<Integer, Integer> A = new HashMap<>();
    public BigDecimal J = new BigDecimal(100);

    /* compiled from: VideoPatternControl.java */
    public class a implements Action1<Long> {
        public a() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            mk2.this.K0(false, 4);
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class b implements mf2 {
        public b() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            RemoteEditorRelationDTOResponse remoteEditorRelationDTOResponse;
            if (TextUtils.isEmpty(str) || (remoteEditorRelationDTOResponse = (RemoteEditorRelationDTOResponse) WearUtils.A.fromJson(str, RemoteEditorRelationDTOResponse.class)) == null || !remoteEditorRelationDTOResponse.isSync()) {
                mk2.this.K0(false, 4);
            } else {
                mk2.this.G0();
                sg3.l("socket reconnect");
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            String unused = mk2.K;
            th.getMessage();
            mk2.this.K0(false, 4);
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class c extends Subscriber<Integer> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;

        public c(int i, int i2, List list) {
            this.a = i;
            this.b = i2;
            this.c = list;
        }

        public static /* synthetic */ Boolean a(Integer num, List list, List list2, Toy toy, Map map) {
            if (!toy.isBAToy()) {
                return Boolean.FALSE;
            }
            if (num.intValue() == 0) {
                ck2.b().c(toy, list, false);
            }
            ck2.b().d(toy.getAddress(), list2);
            return Boolean.TRUE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v4, types: [int] */
        @Override // rx.Observer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(final Integer num) throws NumberFormatException {
            String[] strArr;
            if (mk2.this.n) {
                return;
            }
            int iIntValue = this.a + (this.b * num.intValue());
            String unused = mk2.K;
            String str = "time tick = " + num + " calculate time = " + iIntValue;
            int i = iIntValue - (iIntValue % 100);
            String unused2 = mk2.K;
            String str2 = "real video data time = " + i;
            HashMap map = new HashMap();
            boolean z = false;
            if (mk2.this.v.containsKey(Integer.valueOf(i))) {
                Integer numValueOf = Integer.valueOf(mk2.this.g0(i) ? 0 : ((Integer) mk2.this.v.get(Integer.valueOf(i))).intValue());
                map.put(PSOProgramService.VS_Key, numValueOf);
                map.put("p", numValueOf);
                map.put(StreamManagement.AckRequest.ELEMENT, numValueOf);
                map.put("s", numValueOf);
                map.put("f", numValueOf);
                map.put("t", numValueOf);
                map.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, numValueOf);
            }
            String unused3 = mk2.K;
            String str3 = "commandsMap的长度===" + map.size() + "commandsMap的数据===" + map.keySet();
            int iF0 = mk2.this.f0(this.a, this.b, num.intValue() + 120);
            final ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(iF0));
            int i2 = 2;
            if (mp1.h()) {
                int iIntValue2 = (!mk2.this.v.containsKey(Integer.valueOf(i)) || mk2.this.v.get(Integer.valueOf(i)) == null) ? 0 : ((Integer) mk2.this.v.get(Integer.valueOf(i))).intValue() * 5;
                ToyControlBuilder toyControlBuilder = new ToyControlBuilder(true, true, false);
                final List list = this.c;
                toyControlBuilder.f(new Function2() { // from class: dc.lk2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return mk2.c.a(num, list, arrayList, (Toy) obj, (Map) obj2);
                    }
                });
                rq1.d.e(iIntValue2, toyControlBuilder);
                if (i < mk2.this.q || mk2.this.p >= mk2.this.q) {
                    return;
                }
                mk2.this.G(2);
                return;
            }
            Iterator<Toy> it = mk2.this.c.P().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isBAToy()) {
                    if (num.intValue() == 0) {
                        ck2.b().c(next, this.c, z);
                    }
                    ck2.b().d(next.getAddress(), arrayList);
                } else {
                    String multiplayOrder = next.getMultiplayOrder();
                    List<List<String>> motors = next.getMotors();
                    ArrayList arrayList2 = new ArrayList(motors.size());
                    int i3 = 0;
                    ?? r5 = z;
                    while (i3 < motors.size()) {
                        List<String> list2 = motors.get(i3);
                        String str4 = "";
                        int iIntValue3 = -1;
                        for (String str5 : list2) {
                            if (map.containsKey(str5)) {
                                iIntValue3 = ((Integer) map.get(str5)).intValue();
                                str4 = str5;
                            }
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            String str6 = str4;
                            strArr = Toy.TOY_OPERATION.get(str6);
                            if (strArr == null && strArr.length >= i2) {
                                int i4 = iIntValue3;
                                if (i4 > Integer.parseInt(strArr[1])) {
                                    i4 = Integer.parseInt(strArr[1]);
                                }
                                int iB = vu1.b(next.getAndUpdateDeviceId(), str6, i4);
                                String strReplace = strArr[0].replace("#", "" + iB);
                                String unused4 = mk2.K;
                                String str7 = "command===" + str6;
                                arrayList2.add(strReplace);
                            }
                        } else if (!TextUtils.isEmpty(multiplayOrder)) {
                            str4 = list2.get(r5);
                            String str62 = str4;
                            strArr = Toy.TOY_OPERATION.get(str62);
                            if (strArr == null) {
                            }
                        }
                        i3++;
                        r5 = 0;
                        i2 = 2;
                    }
                    if (!arrayList2.isEmpty()) {
                        if (TextUtils.isEmpty(multiplayOrder)) {
                            Iterator it2 = new ArrayList(new LinkedHashSet(arrayList2)).iterator();
                            while (it2.hasNext()) {
                                String str8 = (String) it2.next();
                                String unused5 = mk2.K;
                                String str9 = "发送单独指令->toy:" + next.getAddress() + ", command:" + str8;
                                WearUtils.x.G().e(next.getAddress(), str8);
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                                String strReplace2 = ((String) arrayList2.get(i5)).split(SignatureImpl.INNER_SEP)[1];
                                String unused6 = mk2.K;
                                String str10 = "v===" + strReplace2;
                                if (i5 != arrayList2.size() - 1) {
                                    strReplace2 = strReplace2.replace(";", SignatureImpl.INNER_SEP);
                                }
                                sb.append(strReplace2);
                            }
                            sb.insert(0, multiplayOrder + SignatureImpl.INNER_SEP);
                            String unused7 = mk2.K;
                            String str11 = "发送多控指令->toy:" + next.getAddress() + ", command:" + ((Object) sb);
                            WearUtils.x.G().e(next.getAddress(), sb.toString());
                        }
                    }
                    z = false;
                    i2 = 2;
                }
            }
            if (i < mk2.this.q || mk2.this.p >= mk2.this.q) {
                return;
            }
            mk2.this.G(2);
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            xe3.a(mk2.K, "error:" + th.toString());
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class d implements Func1<Long, Integer> {
        public d(mk2 mk2Var) {
        }

        @Override // rx.functions.Func1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call(Long l) {
            return Integer.valueOf(l.intValue());
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class e implements Action1<Long> {
        public e() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            Iterator<Toy> it = mk2.this.c.P().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next.isBAToy()) {
                    ck2.b().e(next.getAddress());
                } else {
                    mk2.this.c.v0(next.getAddress());
                }
            }
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class f implements Action1<Long> {
        public final /* synthetic */ int a;

        public f(int i) {
            this.a = i;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            mk2.this.s = System.currentTimeMillis();
            mk2 mk2Var = mk2.this;
            mk2.p(mk2Var, (int) (mk2Var.s - mk2.this.r));
            HashMap map = new HashMap();
            map.put("connect_id", mk2.this.e);
            map.put("pf", mk2.this.i);
            map.put("connect_type", Integer.valueOf(mk2.this.f));
            map.put("pattern_id", mk2.this.h);
            map.put("play_duration", Integer.valueOf(mk2.this.t / 1000));
            ArrayList arrayList = new ArrayList();
            Iterator<Toy> it = mk2.this.c.P().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getAndUpdateDeviceId());
            }
            map.put("toys", WearUtils.A.toJson(arrayList));
            map.put("end_type", Integer.valueOf(this.a));
            ye3.d("R0002", WearUtils.A.toJson(map).replaceAll("\\\\", ""));
            xe3.a(mk2.K, "add_log:" + WearUtils.A.toJson(map).replaceAll("\\\\", ""));
            mk2.this.t = 0;
            mk2.this.r = 0L;
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class g implements Action1<Long> {
        public final /* synthetic */ SyncPatternHeartbeatDTORequest a;

        public g(mk2 mk2Var, SyncPatternHeartbeatDTORequest syncPatternHeartbeatDTORequest) {
            this.a = syncPatternHeartbeatDTORequest;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            nk2.b().a(this.a, null);
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class h implements Action1<Long> {
        public h() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            if (uf2.v().q()) {
                mk2.this.K0(false, 6);
            }
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class i extends Handler {
        public i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                mk2.this.l0((File) message.obj);
            }
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class j implements yn2<TimestampBean> {
        public j() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(TimestampBean timestampBean) {
            if (timestampBean == null || !timestampBean.isResult()) {
                return;
            }
            long data = timestampBean.getData();
            if (data != 0) {
                mk2 mk2Var = mk2.this;
                long j = mk2Var.a;
                if (j != 0) {
                    long j2 = mk2Var.b;
                    if (j2 != 0) {
                        mk2Var.o = (int) (data - (j + (r2 / 2)));
                        String str = mk2.K;
                        xe3.a(str, "requestTime:" + mk2.this.a + ", responseTime:" + mk2.this.b + ", times:" + ((int) (j2 - j)) + ", timestamp:" + data + ", offsetTime:" + mk2.this.o);
                    }
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class k implements mf2 {
        public k() {
        }

        @Override // dc.mf2
        public void Q(String str) {
            mk2.this.b = System.currentTimeMillis();
            long serverTimestamp = ((TimestampResponse) WearUtils.A.fromJson(str, TimestampResponse.class)).getServerTimestamp();
            mk2 mk2Var = mk2.this;
            mk2Var.o = (int) (serverTimestamp - mk2Var.b);
            xe3.a(mk2.K, "responseTime:" + mk2.this.b + ", timestamp:" + serverTimestamp + ", offsetTime:" + mk2.this.o);
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class l implements Action1<Long> {
        public l() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            if (mk2.this.c.P().size() > 0) {
                mk2.this.F0();
            } else {
                mk2.this.K0(true, 3);
            }
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class m implements zn2<BaseResponseBeanNew<ScanVideoPatternQRBean>> {
        public final /* synthetic */ r a;

        public m(mk2 mk2Var, r rVar) {
            this.a = rVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<ScanVideoPatternQRBean> baseResponseBeanNew) {
            if (baseResponseBeanNew.code == 0) {
                xe3.a(mk2.K, "scan qr code success");
                r rVar = this.a;
                if (rVar != null) {
                    rVar.b(baseResponseBeanNew.data);
                    return;
                }
                return;
            }
            xe3.a(mk2.K, "scan qr code fail2:" + baseResponseBeanNew.message);
            r rVar2 = this.a;
            if (rVar2 != null) {
                rVar2.a(String.valueOf(baseResponseBeanNew.code), baseResponseBeanNew.message);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            xe3.a(mk2.K, "scan qr code fail1:" + netException.getMessage());
            r rVar = this.a;
            if (rVar != null) {
                rVar.a(netException.code, netException.getMessage());
            }
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class n implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;

        /* compiled from: VideoPatternControl.java */
        public class a implements ue2.a {
            public a() {
            }

            @Override // dc.ue2.a
            public void a(int i, String str) {
                xe3.a(mk2.K, "down load pattern file fail:" + i + ", msg:" + str);
                mk2.this.L(i, str);
                if (TextUtils.isEmpty(n.this.c)) {
                    return;
                }
                n nVar = n.this;
                mk2.this.i0(nVar.c, false);
                mk2.this.I0();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0087  */
            @Override // dc.ue2.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void b(java.io.File r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = dc.mk2.q()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "down load pattern file success:"
                    r1.append(r2)
                    java.lang.String r2 = r5.getAbsolutePath()
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    dc.xe3.a(r0, r1)
                    java.lang.String r0 = dc.mk2.q()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "file====:"
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    dc.xe3.a(r0, r1)
                    dc.mk2$n r0 = dc.mk2.n.this
                    dc.mk2 r0 = dc.mk2.this
                    dc.mk2.z(r0, r5)
                    dc.mk2$n r0 = dc.mk2.n.this
                    dc.mk2 r0 = dc.mk2.this
                    android.os.Handler r0 = dc.mk2.A(r0)
                    r1 = 1
                    r0.removeMessages(r1)
                    android.os.Message r0 = android.os.Message.obtain()
                    r0.what = r1
                    r0.obj = r5
                    dc.mk2$n r5 = dc.mk2.n.this
                    dc.mk2 r5 = dc.mk2.this
                    android.os.Handler r5 = dc.mk2.A(r5)
                    r2 = 500(0x1f4, double:2.47E-321)
                    r5.sendMessageDelayed(r0, r2)
                    dc.mk2$n r5 = dc.mk2.n.this
                    java.lang.String r5 = r5.c
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L6f
                    dc.mk2$n r5 = dc.mk2.n.this
                    dc.mk2 r0 = dc.mk2.this
                    java.lang.String r5 = r5.c
                    r0.i0(r5, r1)
                L6f:
                    dc.mk2$n r5 = dc.mk2.n.this
                    dc.mk2 r5 = dc.mk2.this
                    boolean r5 = dc.mk2.B(r5)
                    if (r5 == 0) goto L87
                    dc.mk2$n r5 = dc.mk2.n.this
                    boolean r0 = r5.d
                    if (r0 != 0) goto L87
                    java.lang.String r5 = r5.c
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L8e
                L87:
                    dc.mk2$n r5 = dc.mk2.n.this
                    dc.mk2 r5 = dc.mk2.this
                    dc.mk2.C(r5)
                L8e:
                    dc.mk2$n r5 = dc.mk2.n.this
                    boolean r0 = r5.e
                    if (r0 == 0) goto L99
                    dc.mk2 r5 = dc.mk2.this
                    dc.mk2.D(r5)
                L99:
                    dc.mk2$n r5 = dc.mk2.n.this
                    boolean r0 = r5.f
                    if (r0 == 0) goto La4
                    dc.mk2 r5 = dc.mk2.this
                    dc.mk2.c(r5)
                La4:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: dc.mk2.n.a.b(java.io.File):void");
            }
        }

        public n(String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = z2;
            this.f = z3;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            WearUtils.i2(false, this.a, this.b, "videoPattern", new a());
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class o implements mf2 {
        public final /* synthetic */ VideoPatternControlEvent a;
        public final /* synthetic */ ScanVideoPatternQRBean b;

        public o(VideoPatternControlEvent videoPatternControlEvent, ScanVideoPatternQRBean scanVideoPatternQRBean) {
            this.a = videoPatternControlEvent;
            this.b = scanVideoPatternQRBean;
        }

        @Override // dc.mf2
        public void Q(String str) {
            mk2.this.b0(this.b.getConnectId());
        }

        @Override // dc.mf2
        public void a(Throwable th) {
            EventBus.getDefault().post(this.a);
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class p implements Action1<Long> {
        public final /* synthetic */ Object a;

        public p(mk2 mk2Var, Object obj) {
            this.a = obj;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Long l) {
            EventBus.getDefault().post(this.a);
        }
    }

    /* compiled from: VideoPatternControl.java */
    public class q implements Action1<String> {
        public q(mk2 mk2Var) {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            is3.b bVar = new is3.b(MyApplication.H());
            bVar.p(String.format(ah4.e(R.string.vp_disc), str));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.b(false);
            cs3.h(bVar).show();
        }
    }

    /* compiled from: VideoPatternControl.java */
    public interface r {
        void a(String str, String str2);

        void b(ScanVideoPatternQRBean scanVideoPatternQRBean);
    }

    public mk2() {
        EventBus.getDefault().register(this);
        this.H = new i(Looper.getMainLooper());
    }

    public static mk2 P() {
        if (L == null) {
            synchronized (mk2.class) {
                if (L == null) {
                    L = new mk2();
                }
            }
        }
        return L;
    }

    public static /* synthetic */ int p(mk2 mk2Var, int i2) {
        int i3 = mk2Var.t + i2;
        mk2Var.t = i3;
        return i3;
    }

    public void A0(MPPlayMediaResponse mPPlayMediaResponse) {
        if (mPPlayMediaResponse == null) {
            return;
        }
        y0(new BigDecimal(mPPlayMediaResponse.getSpeed()).divide(this.J, 2, 4).floatValue(), Integer.parseInt(mPPlayMediaResponse.getMediaTimestamp()), mPPlayMediaResponse.getJsLocalTimestamp());
    }

    public void B0(VideoProgressStatusDTOResponse videoProgressStatusDTOResponse) {
        if (this.v.isEmpty() || videoProgressStatusDTOResponse == null || !TextUtils.equals(videoProgressStatusDTOResponse.getVideoId(), this.j)) {
            return;
        }
        if (!TextUtils.equals("1", this.d) || this.k) {
            y0(Float.parseFloat(videoProgressStatusDTOResponse.getSpeed()), Integer.parseInt(videoProgressStatusDTOResponse.getVideoTime()), Long.parseLong(videoProgressStatusDTOResponse.getLocalTime()));
        }
    }

    public final void C0() {
        Observable.timer(100L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e());
    }

    public void D0() {
        p0(this.B);
        this.m = false;
        C0();
    }

    public void E(String str, String str2, int i2) {
        HashMap map = new HashMap();
        map.put("connect_id", this.e);
        map.put("pattern_id", str);
        map.put("pf", str2);
        map.put("connect_type", Integer.valueOf(this.f));
        map.put("connect_result", Integer.valueOf(i2));
        ArrayList arrayList = new ArrayList();
        Iterator<Toy> it = this.c.P().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAndUpdateDeviceId());
        }
        map.put("toys", WearUtils.A.toJson(arrayList));
        ye3.d("R0001", WearUtils.A.toJson(map).replaceAll("\\\\", ""));
        xe3.a(K, "add_log:" + WearUtils.A.toJson(map).replaceAll("\\\\", ""));
    }

    public final void E0(ScanVideoPatternQRBean scanVideoPatternQRBean) {
        xe3.a(K, "sync media pattern control");
        MPRemoteConnectToJsRequest mPRemoteConnectToJsRequest = new MPRemoteConnectToJsRequest();
        mPRemoteConnectToJsRequest.setAckId(WearUtils.E());
        mPRemoteConnectToJsRequest.setJsSessionCode(scanVideoPatternQRBean.getJsSessionCode());
        VideoPatternControlEvent videoPatternControlEvent = new VideoPatternControlEvent(2, false);
        videoPatternControlEvent.putParam("version", Integer.valueOf(this.I));
        nk2.b().a(mPRemoteConnectToJsRequest, new o(videoPatternControlEvent, scanVideoPatternQRBean));
        s0(videoPatternControlEvent);
        if (na2.m().i()) {
            this.n = true;
        }
    }

    public void F() {
        HashMap map = new HashMap();
        map.put("connect_id", this.e);
        map.put("pattern_id", this.h);
        map.put("type", Integer.valueOf(this.g));
        ye3.d("R0003", WearUtils.A.toJson(map).replaceAll("\\\\", ""));
        xe3.a(K, "DisconnectLog:" + WearUtils.A.toJson(map).replaceAll("\\\\", ""));
    }

    public final void F0() {
        if (this.I == 1) {
            SyncModifyToyDTORequest syncModifyToyDTORequest = new SyncModifyToyDTORequest();
            syncModifyToyDTORequest.setAckId(WearUtils.E());
            syncModifyToyDTORequest.setToys(T());
            nk2.b().a(syncModifyToyDTORequest, null);
        }
    }

    public void G(int i2) {
        if (this.r != 0) {
            int i3 = i2 == 0 ? 3 : 0;
            p0(this.G);
            this.G = Observable.timer(i3, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new f(i2));
        }
    }

    public final void G0() {
        Subscription subscription = this.C;
        if (subscription == null || subscription.isUnsubscribed()) {
            SyncPatternHeartbeatDTORequest syncPatternHeartbeatDTORequest = new SyncPatternHeartbeatDTORequest();
            syncPatternHeartbeatDTORequest.setAckId(WearUtils.E());
            this.C = Observable.interval(0L, 15L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new g(this, syncPatternHeartbeatDTORequest));
        }
    }

    public void H(String str) {
        HashMap map = new HashMap();
        map.put("connect_id", this.e);
        map.put("type", "remote");
        map.put("mode_type", "scan code");
        map.put("pf", str);
        ye3.d("R0007", WearUtils.A.toJson(map).replaceAll("\\\\", ""));
        xe3.a(K, "add_log:" + WearUtils.A.toJson(map).replaceAll("\\\\", ""));
    }

    public final void H0() {
        SyncReadyLoadPatternDTORequest syncReadyLoadPatternDTORequest = new SyncReadyLoadPatternDTORequest();
        syncReadyLoadPatternDTORequest.setAckId(WearUtils.E());
        nk2.b().a(syncReadyLoadPatternDTORequest, null);
    }

    public final void I(JSONArray jSONArray, String str, Map map) throws JSONException {
        map.clear();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONArray.get(0);
        if (jSONObject.has(str)) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                int iIntValue = (((Integer) jSONObject2.get("t")).intValue() / 100) * 100;
                int iIntValue2 = ((Integer) jSONObject2.get(str)).intValue();
                if (iIntValue2 > 0) {
                    map.put(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                }
            }
            return;
        }
        JSONObject jSONObject3 = (JSONObject) jSONArray.get(jSONArray.length() - 1);
        int iIntValue3 = (((Integer) jSONObject.get("t")).intValue() / 100) * 100;
        int iIntValue4 = (((Integer) jSONObject3.get("t")).intValue() / 100) * 100;
        int i3 = TextUtils.equals("p", str) ? PlaybackException.ERROR_CODE_DRM_UNSPECIFIED : 1000;
        int i4 = iIntValue4 - iIntValue3;
        if (i4 != 0) {
            if (i4 <= i3) {
                Iterator<Integer> it = this.v.values().iterator();
                int iIntValue5 = 0;
                while (it.hasNext()) {
                    iIntValue5 += it.next().intValue();
                }
                map.put(0, Integer.valueOf(J0(str, iIntValue5 / i4)));
                return;
            }
            int i5 = iIntValue3;
            int iIntValue6 = 0;
            int i6 = 0;
            while (iIntValue3 <= iIntValue4) {
                if (this.v.get(Integer.valueOf(iIntValue3)) != null) {
                    iIntValue6 += this.v.get(Integer.valueOf(iIntValue3)).intValue();
                    i6++;
                    if (i6 % (i3 / 100) == 0 || iIntValue3 == iIntValue4) {
                        map.put(Integer.valueOf(i5), Integer.valueOf(J0(str, iIntValue6 / i6)));
                        i5 = iIntValue3 + 100;
                        iIntValue6 = 0;
                        i6 = 0;
                    }
                }
                iIntValue3 += 100;
            }
        }
    }

    public final void I0() {
        xe3.a(K, "sync video pattern control");
        SuccessSyncPatternDTORequest successSyncPatternDTORequest = new SuccessSyncPatternDTORequest();
        successSyncPatternDTORequest.setAckId(WearUtils.E());
        successSyncPatternDTORequest.setToys(T());
        nk2.b().c(successSyncPatternDTORequest);
        s0(new VideoPatternControlEvent(2, false));
        if (na2.m().i()) {
            this.n = true;
        }
    }

    public void J() {
        if (this.I == 1) {
            CancelSyncPatternDTORequest cancelSyncPatternDTORequest = new CancelSyncPatternDTORequest();
            cancelSyncPatternDTORequest.setAckId(WearUtils.E());
            nk2.b().a(cancelSyncPatternDTORequest, null);
        }
    }

    public final int J0(String str, int i2) {
        if (!TextUtils.equals("p", str)) {
            if (i2 > 20) {
                return 20;
            }
            return i2;
        }
        if (i2 >= 1 && i2 <= 7) {
            return 1;
        }
        if (i2 <= 7 || i2 > 13) {
            return i2 > 13 ? 3 : 0;
        }
        return 2;
    }

    public final void K() {
        this.v.clear();
        this.x.clear();
        this.w.clear();
        this.y.clear();
        this.z.clear();
        this.A.clear();
    }

    public void K0(boolean z, int i2) {
        BaseAckRequestBean mPEndRequest;
        xe3.a(K, "unsync video pattern control");
        this.g = i2;
        if (z) {
            if (this.I == 1) {
                p0(this.E);
                mPEndRequest = new ExitPatternSyncDTORequest();
                s0(new VideoPatternControlEvent(3, false));
            } else {
                mPEndRequest = new MPEndRequest();
                W();
            }
            mPEndRequest.setAckId(WearUtils.E());
            nk2.b().a(mPEndRequest, null);
        } else {
            W();
        }
        if (VideoPatternService.f) {
            WearUtils.x.stopService(new Intent(WearUtils.x, (Class<?>) VideoPatternService.class));
        }
    }

    public final void L(int i2, String str) {
        ErrorSyncPatternDTORequest errorSyncPatternDTORequest = new ErrorSyncPatternDTORequest();
        errorSyncPatternDTORequest.setCode(String.valueOf(i2));
        errorSyncPatternDTORequest.setMsg(str);
        errorSyncPatternDTORequest.setAckId(WearUtils.E());
        nk2.b().a(errorSyncPatternDTORequest, null);
        EventBus.getDefault().post(new VideoPatternControlEvent(1, false));
    }

    public void M(String str, String str2, boolean z, boolean z2, String str3, boolean z3) {
        this.h = str;
        vg3.b().a(new n(str, str2, str3, z2, z, z3));
    }

    public final void N() {
        SuccessDownloadPatternDTORequest successDownloadPatternDTORequest = new SuccessDownloadPatternDTORequest();
        successDownloadPatternDTORequest.setAckId(WearUtils.E());
        nk2.b().a(successDownloadPatternDTORequest, null);
    }

    public String O() {
        return String.format(ah4.e(R.string.pe_disc), this.i);
    }

    public final void Q() {
        if (this.I == 1) {
            tn2.x(MyApplication.N()).d("/date-web-api/api/server/timestamp", new j());
            return;
        }
        TimestampRequest timestampRequest = new TimestampRequest();
        timestampRequest.setAckId(WearUtils.E());
        e42.i().f(timestampRequest, new k());
    }

    public void R(MPRemoteGetFileResponse mPRemoteGetFileResponse) {
        if (mPRemoteGetFileResponse != null) {
            try {
                String[] strArrSplit = mPRemoteGetFileResponse.getFileZipBase64().split(",");
                if (strArrSplit.length == 2) {
                    m0(hh3.a(strArrSplit[1]));
                }
                this.h = mPRemoteGetFileResponse.getPatternId();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        MPRemoteReceivedFileRequest mPRemoteReceivedFileRequest = new MPRemoteReceivedFileRequest();
        mPRemoteReceivedFileRequest.setColaId(mPRemoteGetFileResponse.getColaId());
        mPRemoteReceivedFileRequest.setFileName(mPRemoteGetFileResponse.getFileName());
        mPRemoteReceivedFileRequest.setAckId(WearUtils.E());
        nk2.b().a(mPRemoteReceivedFileRequest, null);
    }

    public String S(Context context) {
        int size = WearUtils.x.G().P().size();
        String string = "";
        int i2 = 0;
        while (i2 < size) {
            Toy toy = WearUtils.x.G().P().get(i2);
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(toy.getName());
            sb.append(i2 == size + (-1) ? "" : ", ");
            string = sb.toString();
            i2++;
        }
        return String.format(ah4.e(this.n ? R.string.vp_sync_1_paused : R.string.vp_sync_1), string, this.i);
    }

    public final List<String> T() {
        ArrayList arrayList = new ArrayList();
        Iterator<Toy> it = WearUtils.x.G().P().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, next.getDeviceId());
            map.put("name", next.getRealType().toLowerCase());
            map.put("status", String.valueOf(WearUtils.x.G().a(next.getAddress()) ? 1 : 0));
            map.put("battery", Integer.valueOf(next.getBattery()));
            map.put("nickName", WearUtils.e1(next.getDefineRename()) ? "" : next.getDefineRename());
            map.put("version", next.getGenerationVersion());
            arrayList.add(ro2.c(map));
        }
        return arrayList;
    }

    public String U(Context context) {
        return ah4.e(R.string.vp_unsync);
    }

    public String V() {
        return this.d;
    }

    public final void W() {
        F();
        p0(this.C);
        D0();
        EventBus.getDefault().post(new VideoPatternControlEvent(3, true));
        if (TextUtils.equals("2", this.d)) {
            w0(this.i);
        }
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.d = "";
        this.i = "";
        this.j = "";
        this.h = "";
        this.k = false;
        this.l = false;
        this.n = false;
        this.u = null;
        this.I = 0;
    }

    public void X(BaseResponseBeanNew baseResponseBeanNew) {
        p0(this.E);
        if (baseResponseBeanNew != null) {
            if (baseResponseBeanNew.code == 0) {
                W();
            } else {
                EventBus.getDefault().post(new VideoPatternControlEvent(3, false));
            }
        }
    }

    public void Y(ScanVideoPatternQRBean scanVideoPatternQRBean) {
        K();
        this.i = scanVideoPatternQRBean.getPf();
        if (this.I != 1) {
            E0(scanVideoPatternQRBean);
            return;
        }
        this.d = scanVideoPatternQRBean.getUserType();
        this.j = scanVideoPatternQRBean.getVideoId();
        if (TextUtils.isEmpty(scanVideoPatternQRBean.getPattern()) || TextUtils.isEmpty(scanVideoPatternQRBean.getPatternId())) {
            I0();
            return;
        }
        File fileP0 = WearUtils.P0(scanVideoPatternQRBean.getPatternId());
        this.u = fileP0;
        if (fileP0.exists()) {
            this.u.delete();
        }
        M(scanVideoPatternQRBean.getPatternId(), scanVideoPatternQRBean.getPattern(), false, false, "", false);
    }

    public void Z() {
        if (this.l) {
            p0(this.B);
            p0(this.C);
            C0();
            Subscription subscription = this.F;
            if (subscription == null || subscription.isUnsubscribed()) {
                this.F = Observable.timer(85L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
            }
        }
    }

    public void a0() {
        if (this.l) {
            p0(this.F);
            if (this.I == 1) {
                RemoteEditorRelationDTORequest remoteEditorRelationDTORequest = new RemoteEditorRelationDTORequest();
                remoteEditorRelationDTORequest.setAckId(WearUtils.E());
                nk2.b().a(remoteEditorRelationDTORequest, new b());
            } else {
                MPQueryPlayStatusRequest mPQueryPlayStatusRequest = new MPQueryPlayStatusRequest();
                mPQueryPlayStatusRequest.setAckId(WearUtils.E());
                nk2.b().a(mPQueryPlayStatusRequest, null);
            }
        }
    }

    public void b0(String str) {
        xe3.a(K, "sync media pattern control success v2");
        p0(this.E);
        Q();
        EventBus.getDefault().post(new VideoPatternControlEvent(2, true));
        if (!this.l) {
            E(this.h, this.i, 1);
        }
        this.e = str;
        this.l = true;
        v0();
    }

    public void c0(BaseResponseBeanNew baseResponseBeanNew) {
        p0(this.E);
        if (TextUtils.isEmpty(this.d)) {
            EventBus.getDefault().post(new VideoPatternControlEvent(2, false));
            return;
        }
        if (baseResponseBeanNew != null) {
            if (baseResponseBeanNew.code == 0) {
                xe3.a(K, "sync video pattern control success v1");
                G0();
                Q();
                EventBus.getDefault().post(new VideoPatternControlEvent(2, true));
                if (!this.l) {
                    E(this.h, this.i, 1);
                }
                this.l = true;
                v0();
            } else {
                xe3.a(K, "sync video v1 pattern control fail:" + baseResponseBeanNew.message);
                EventBus.getDefault().post(new VideoPatternControlEvent(2, false));
            }
            x0();
        }
    }

    public final void d0() {
        if (this.l) {
            p0(this.D);
            this.D = Observable.timer(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new l());
        }
    }

    public void e0() {
        this.e = WearUtils.E();
    }

    public final int f0(int i2, int i3, int i4) {
        int i5 = i2 + (i3 * i4);
        int i6 = i5 - (i5 % 100);
        if (i6 >= this.q) {
            return -1;
        }
        Integer num = this.v.get(Integer.valueOf(i6));
        if (num == null) {
            num = -1;
        }
        String str = "insertPatternData time = " + i6 + " value = " + num;
        return num.intValue();
    }

    public boolean g0(int i2) {
        return i2 >= this.q || !this.m;
    }

    public boolean h0() {
        return this.l;
    }

    public void i0(String str, boolean z) {
        ModifyPatternResultDTORequest modifyPatternResultDTORequest = new ModifyPatternResultDTORequest();
        modifyPatternResultDTORequest.setAckId(WearUtils.E());
        modifyPatternResultDTORequest.setVideoId(str);
        modifyPatternResultDTORequest.setResult(z);
        if (z) {
            modifyPatternResultDTORequest.setToys(T());
        }
        nk2.b().a(modifyPatternResultDTORequest, null);
    }

    public void j0(ModifyVideoPatternDTOResponse modifyVideoPatternDTOResponse) {
        D0();
        this.u = null;
        K();
        this.j = modifyVideoPatternDTOResponse.getVideoId();
        G(1);
        if (!TextUtils.isEmpty(modifyVideoPatternDTOResponse.getPattern()) && !TextUtils.isEmpty(modifyVideoPatternDTOResponse.getPatternId())) {
            M(modifyVideoPatternDTOResponse.getPatternId(), modifyVideoPatternDTOResponse.getPattern(), false, false, modifyVideoPatternDTOResponse.getVideoId(), false);
        } else {
            i0(modifyVideoPatternDTOResponse.getVideoId(), false);
            I0();
        }
    }

    public void k0() {
        p0(this.C);
        this.C = Observable.timer(80L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h());
    }

    public final void l0(File file) {
        if (file != null) {
            m0(WearUtils.N1(file.getAbsolutePath()));
        }
    }

    public final void m0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            String str2 = "parsePattern====" + jSONArray;
            u0(jSONArray);
            I(jSONArray, "p", this.w);
            I(jSONArray, StreamManagement.AckRequest.ELEMENT, this.x);
            I(jSONArray, "t", this.y);
            I(jSONArray, "s", this.z);
            I(jSONArray, "f", this.A);
            I(jSONArray, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, this.A);
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public void n0(boolean z) {
        String str = "pause ===" + z;
        if (this.n != z) {
            this.n = z;
            if (z) {
                C0();
            }
            EventBus.getDefault().post(new VideoPatternControlEvent(4, true));
        }
    }

    public final List<Integer> o0(int i2, int i3) {
        int iF0;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < 120 && (iF0 = f0(i2, i3, i4)) >= 0) {
            i4++;
            arrayList.add(Integer.valueOf(iF0));
        }
        String str = "insertPatternData data size = " + arrayList.size() + " ;vMap size = " + this.v.size();
        return arrayList;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ChangeToyEvent changeToyEvent) {
        d0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToySelectEvent toySelectEvent) {
        d0();
    }

    public final void p0(Subscription subscription) {
        if (subscription == null || subscription.isUnsubscribed()) {
            return;
        }
        subscription.unsubscribe();
    }

    public void q0(int i2, String str, r rVar) {
        this.I = i2;
        HashMap map = new HashMap();
        map.put("qrData", str);
        tn2.x(WearUtils.x).k(i2 == 1 ? "/api/patternEditor/scanQrCode" : "/api/mediaPattern/scanQrCode", map, new m(this, rVar));
    }

    public void r0(int i2) {
        this.f = i2;
    }

    public final void s0(Object obj) {
        this.E = Observable.timer(10L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this, obj));
    }

    public void t0(boolean z) {
        this.k = z;
    }

    public final void u0(JSONArray jSONArray) throws JSONException {
        this.v.clear();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
            int iIntValue = (((Integer) jSONObject.get("t")).intValue() / 100) * 100;
            int iIntValue2 = ((Integer) jSONObject.get(PSOProgramService.VS_Key)).intValue();
            this.v.put(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
            if (i2 == jSONArray.length() - 1) {
                this.q = iIntValue;
            } else {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2 + 1);
                int iIntValue3 = (((Integer) jSONObject2.get("t")).intValue() / 100) * 100;
                int iIntValue4 = ((Integer) jSONObject2.get(PSOProgramService.VS_Key)).intValue();
                int i3 = (iIntValue3 - iIntValue) / 100;
                if (i3 != 0) {
                    float fFloatValue = new BigDecimal(iIntValue4 - iIntValue2).divide(new BigDecimal(i3), 2, 4).floatValue();
                    for (int i4 = 1; i4 < i3; i4++) {
                        this.v.put(Integer.valueOf((i4 * 100) + iIntValue), Integer.valueOf((int) (iIntValue2 + (i4 * fFloatValue))));
                    }
                }
            }
        }
    }

    public final void v0() {
        Iterator<Toy> it = this.c.P().iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (next.isBAToy() && fk2.a.c(next.getAddress()) == ek2.SPEED) {
                sg3.l(ah4.e(R.string.tip_controlling_position));
            }
        }
    }

    public final void w0(String str) {
        Observable.just(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this));
    }

    public final void x0() {
        if (VideoPatternService.f) {
            return;
        }
        Intent intent = new Intent(WearUtils.x, (Class<?>) VideoPatternService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            WearUtils.x.startForegroundService(intent);
        } else {
            WearUtils.x.startService(intent);
        }
    }

    public final void y0(float f2, int i2, long j2) {
        this.m = true;
        p0(this.G);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.r = jCurrentTimeMillis;
        int i3 = this.o;
        int i4 = (int) ((jCurrentTimeMillis + i3) - j2);
        if (i3 == 0 && this.I == 2) {
            i4 = 300;
        }
        xe3.a(K, "startTime:" + this.r + ", offsetTime:" + this.o + ", localTime:" + j2 + ", initialDelay:" + i4);
        int i5 = i2 + i4;
        int i6 = i5 % 100;
        z0(i6 != 0 ? 100 - i6 : 0, i5, f2);
        this.p = i5;
    }

    public final void z0(int i2, int i3, float f2) {
        p0(this.B);
        int i4 = f2 < 1.0f ? (int) (100.0f / f2) : 100;
        int i5 = i3 + i2;
        String str = "videoTime:" + i3 + ", ceil:" + i2 + ", period:" + i4 + ", speed:" + f2;
        int i6 = f2 > 1.0f ? (int) (f2 * 100.0f) : 100;
        this.B = Observable.interval(i2, i4, TimeUnit.MILLISECONDS).map(new d(this)).subscribe((Subscriber<? super R>) new c(i5, i6, o0(i5, i6)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(xc1 xc1Var) {
        d0();
    }
}
