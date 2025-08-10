package dc;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.DfuBean;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.sp1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: BtWorkCore.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u000eJ\u0016\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u000eJ:\u0010(\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\rJ\u0010\u00100\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\rJ\u0010\u00101\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020\rJ\u0010\u00102\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020\rJ\u0010\u00103\u001a\u00020+2\b\u0010%\u001a\u0004\u0018\u00010\rJ\u000e\u00104\u001a\u00020$2\u0006\u0010%\u001a\u00020\rJ\u000e\u00105\u001a\u00020$2\u0006\u0010%\u001a\u00020\rJ\u0006\u00106\u001a\u00020$J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020+J\u001e\u00109\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020.R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR7\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR7\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001e\u0010\u0011R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/lovense/btservice/work/BtWorkCore;", "", "()V", "btCommand", "Lcom/lovense/btservice/work/BtCommand;", "getBtCommand", "()Lcom/lovense/btservice/work/BtCommand;", "btLinked", "Lcom/lovense/btservice/work/BtLinked;", "getBtLinked", "()Lcom/lovense/btservice/work/BtLinked;", "connectMap", "Ljava/util/HashMap;", "", "Landroid/bluetooth/BluetoothDevice;", "Lkotlin/collections/HashMap;", "getConnectMap", "()Ljava/util/HashMap;", "connectMap$delegate", "Lkotlin/Lazy;", "dxBtUtils", "Lcom/lovense/btservice/DxBtUtils;", "getDxBtUtils", "()Lcom/lovense/btservice/DxBtUtils;", "elementId", "getElementId", "()Ljava/lang/String;", "setElementId", "(Ljava/lang/String;)V", "foundMap", "getFoundMap", "foundMap$delegate", "longCommandSend", "", "Landroid/os/Handler;", "addConnectDevice", "", MultipleAddresses.Address.ELEMENT, "device", "addFoundDevice", "addSearchOneToy", "value", "isConnect", "", "deviceName", "rssi", "", "uuid", "disconnect", "getConnectDevice", "getFoundDevice", "isConnected", "removeConnectDevice", "removeFoundDevice", "resetBleParams", "scanDevice", StreamManagement.Enable.ELEMENT, "updateToyConnect", "connectState", "stateCode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class qc1 {

    @NotNull
    public final tb1 a;

    @NotNull
    public final mc1 b;

    @NotNull
    public final jc1 c;

    @NotNull
    public final Map<String, Handler> d;

    @NotNull
    public final Lazy e;

    @NotNull
    public final Lazy f;

    /* compiled from: BtWorkCore.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/lovense/btservice/work/BtWorkCore$addSearchOneToy$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", "data", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements zn2<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Toy b;
        public final /* synthetic */ String c;
        public final /* synthetic */ qc1 d;

        public a(String str, Toy toy, String str2, qc1 qc1Var) {
            this.a = str;
            this.b = toy;
            this.c = str2;
            this.d = qc1Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            String str2 = "onSuccess old result: " + str;
            if (yb1.B && StringsKt__StringsJVMKt.startsWith$default(this.a, "S:210", false, 2, null)) {
                str = "{'version':211,'hasUpdate':true,'url':'C7qzm2dsvXXaNhxI3JEJNOHrveCid9WUHk7pCkRmKVZaImLC9WelB3GHjUtp5mSa6xMPKc4UfJB+ui1gejQhKV0G3BQ19iMn2qeIFkn68XU=','md5':'6175bd20dfc5d7e3417c207652e2dce0','publishPercentMark':false,'toyDfuName':null,'toyDfuUrl':null,'enable3dx':true,'macI':null}";
            }
            String str3 = "onSuccess old result: " + str;
            this.b.setIsDfuEnd(0);
            if (WearUtils.e1(str)) {
                return;
            }
            try {
                DfuBean dfuBean = (DfuBean) new Gson().fromJson(str, DfuBean.class);
                if (dfuBean == null || !dfuBean.isHasUpdate()) {
                    return;
                }
                if (yb1.B && StringsKt__StringsJVMKt.startsWith$default(this.a, "S:210", false, 2, null)) {
                    dfuBean.setUrl("https://test2.lovense.com/UploadFiles/dfu/20210816200758_S43_BG21_PCB_211.gbl");
                } else {
                    dfuBean.setUrl(nd3.j(dfuBean.getUrl()));
                }
                Toy toy = pc1.a.d().get(this.c);
                if (toy != null) {
                    toy.setUpdateDfu(dfuBean);
                }
                this.b.setUpdateDfu(dfuBean);
                this.d.s(this.c, 1, -2);
            } catch (Exception e) {
                Intrinsics.checkNotNull(e.getMessage());
                this.b.setGetDfuErrorTime(System.currentTimeMillis());
            }
        }

        @Override // dc.zn2
        public void onError(@NotNull NetException e) {
            Intrinsics.checkNotNullParameter(e, "e");
            String str = e.message;
            this.b.setIsDfuEnd(0);
            this.b.setGetDfuErrorTime(System.currentTimeMillis());
        }
    }

    /* compiled from: BtWorkCore.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Landroid/bluetooth/BluetoothDevice;", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<HashMap<String, BluetoothDevice>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, BluetoothDevice> invoke() {
            return new HashMap<>();
        }
    }

    /* compiled from: BtWorkCore.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Landroid/bluetooth/BluetoothDevice;", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<HashMap<String, BluetoothDevice>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, BluetoothDevice> invoke() {
            return new HashMap<>();
        }
    }

    public qc1() {
        tb1 tb1VarD = tb1.d();
        Intrinsics.checkNotNullExpressionValue(tb1VarD, "getInstance()");
        this.a = tb1VarD;
        this.b = new mc1(this);
        this.c = new jc1(this);
        this.d = new HashMap();
        this.e = LazyKt__LazyJVMKt.lazy(c.a);
        this.f = LazyKt__LazyJVMKt.lazy(b.a);
    }

    public static final void t(Toy it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        if (it.isRealDeviceType()) {
            return;
        }
        String address = it.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "it.address");
        lr1.c(address);
    }

    public static final void u(Toy it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        if (it.isRealDeviceType()) {
            return;
        }
        String address = it.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "it.address");
        lr1.c(address);
    }

    public final void a(@NotNull String address, @NotNull BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(device, "device");
        h().put(address, device);
    }

    public final void b(@NotNull String address, @NotNull BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(device, "device");
        k().put(address, device);
    }

    public final void c(@NotNull String address, @NotNull String value, boolean z, @Nullable String str, int i, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(value, "value");
        if (z && this.b.k(address)) {
            this.b.r(address);
            xe3.a("connectScan", "bltFoundDevice: deviceName =" + str + "  Address:" + address + "搜索无法识别玩具连接成功 type = " + value);
            this.b.u(address, -996);
            d(address);
        }
        if (re0.e(value) || StringsKt__StringsKt.indexOf$default((CharSequence) value, SignatureImpl.INNER_SEP, 0, false, 6, (Object) null) <= 0) {
            return;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = value.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Toy.isDeviceTypeMessage(lowerCase)) {
            String str3 = ((String[]) StringsKt__StringsKt.split$default((CharSequence) value, new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null).toArray(new String[0]))[0];
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
            String lowerCase2 = str3.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            String strGenerateType = Toy.generateType(lowerCase2);
            Intrinsics.checkNotNullExpressionValue(strGenerateType, "generateType(type)");
            Map<String, String> map = Toy.NAME_MAP;
            if (map.containsKey(strGenerateType)) {
                pc1 pc1Var = pc1.a;
                if (pc1Var.d().get(address) == null && pc1Var.g().get(address) == null) {
                    Toy toy = new Toy();
                    toy.setName(map.get(strGenerateType));
                    toy.setAddress(address);
                    toy.setDeviceType(value);
                    toy.setDeviceName(str);
                    toy.setStatus(z ? 1 : -1);
                    toy.setIsSelect(1);
                    toy.setVersion(Integer.valueOf(((String[]) StringsKt__StringsKt.split$default((CharSequence) value, new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null).toArray(new String[0]))[1]));
                    toy.setType(strGenerateType);
                    toy.setToyConfigDataBean();
                    if (i != 0) {
                        toy.setRssi(i);
                    }
                    toy.setUuid(str2);
                    pc1Var.d().put(address, toy);
                    EventBus.getDefault().post(new n90(address));
                    rp1.a.a(toy);
                }
                if (z) {
                    MyApplication myApplication = WearUtils.x;
                    if (myApplication != null && myApplication.G() != null && WearUtils.x.G().Q(address) != null) {
                        sp1.a aVar = sp1.a;
                        Toy toyQ = pc1Var.Q(address);
                        aVar.a(toyQ != null ? toyQ.getLogToyType() : null);
                    }
                    Toy toyQ2 = pc1Var.Q(address);
                    if (toyQ2 != null && toyQ2.getIsDfuEnd() != 1 && System.currentTimeMillis() - toyQ2.getGetDfuErrorTime() >= 600000 && toyQ2.getUpdateDfu() == null) {
                        HashMap map2 = new HashMap();
                        map2.put("uid", "");
                        map2.put(PSOProgramService.VS_Key, value);
                        map2.put("apiVer", 100);
                        toyQ2.setIsDfuEnd(1);
                        tn2.x(WearUtils.x).l("/app/getUpdate/dfu", map2, new a(value, toyQ2, address, this));
                    }
                }
            }
        }
    }

    public final void d(@Nullable String str) {
        this.a.c(str);
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final jc1 getC() {
        return this.c;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final mc1 getB() {
        return this.b;
    }

    @Nullable
    public final BluetoothDevice g(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return h().get(address);
    }

    public final HashMap<String, BluetoothDevice> h() {
        return (HashMap) this.f.getValue();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final tb1 getA() {
        return this.a;
    }

    @Nullable
    public final BluetoothDevice j(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return k().get(address);
    }

    public final HashMap<String, BluetoothDevice> k() {
        return (HashMap) this.e.getValue();
    }

    public final boolean l(@Nullable String str) {
        Toy toy = pc1.a.g().get(str);
        if (toy != null && toy.isSelect() && toy.isVirtualToy()) {
            return true;
        }
        return this.a.g(str);
    }

    public final void o(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        h().remove(address);
    }

    public final void p() {
        this.a.o();
    }

    public final void q(boolean z) {
        this.b.w(z);
    }

    public final void r(@Nullable String str) {
    }

    public final synchronized void s(@NotNull String address, int i, int i2) {
        Intrinsics.checkNotNullParameter(address, "address");
        final Toy toy = pc1.a.g().get(address);
        if (toy != null) {
            if (i == -1) {
                String address2 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "it.address");
                aj2.b(address2, cc0.DISCONNECTED);
                toy.setLed(-1);
                if (toy.isSelect()) {
                    xe3.a("connectScan", "updateToyConnect:  玩具断联：" + address);
                    this.b.u(address, -997);
                    MyApplication.l0();
                    if (toy.getStatus() == 1) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String strE = ah4.e(R.string.toy_connected_disconnected);
                        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.toy_connected_disconnected)");
                        String str = String.format(strE, Arrays.copyOf(new Object[]{toy.getName()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        sg3.l(str);
                        ze3.c(toy, new BleResultBean(0, null, Integer.valueOf(i2), 3, null));
                    }
                }
                toy.setIsLongRange(0);
                toy.setRealDeviceType(false);
                me3.g();
            } else if (i == 1) {
                String address3 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address3, "it.address");
                aj2.b(address3, cc0.CONNECTED);
                pp1.a.a(toy);
                if (toy.isSelect()) {
                    xe3.a("connectScan", "updateToyConnect:  玩具连接成功：" + address + "  " + i2);
                    this.b.u(address, -996);
                    MyApplication.l0();
                    wi2.e().d(toy);
                    vi2.a.d(toy);
                    if (i2 == -1) {
                        rp1.a.c(toy);
                    }
                    rp1.a.x(toy);
                    Handler handler = this.d.get(address);
                    if (handler == null) {
                        Handler handler2 = new Handler(Looper.getMainLooper());
                        handler2.postDelayed(new Runnable() { // from class: dc.fc1
                            @Override // java.lang.Runnable
                            public final void run() {
                                qc1.t(toy);
                            }
                        }, 1000L);
                        Map<String, Handler> map = this.d;
                        String address4 = toy.getAddress();
                        Intrinsics.checkNotNullExpressionValue(address4, "it.address");
                        map.put(address4, handler2);
                    } else {
                        handler.removeCallbacksAndMessages(null);
                        handler.postDelayed(new Runnable() { // from class: dc.gc1
                            @Override // java.lang.Runnable
                            public final void run() {
                                qc1.u(toy);
                            }
                        }, 1000L);
                    }
                }
                xr1.a.a(address);
                if (toy.isBAToy()) {
                    fk2 fk2Var = fk2.a;
                    dk2.a.j(toy, fk2Var.e(toy.getAndUpdateDeviceId()), fk2Var.d(toy.getAndUpdateDeviceId()));
                }
            }
            toy.setStatus(i);
            toy.setConnectApp(i);
            toy.setUpdateTime(System.currentTimeMillis());
            toy.setFormApp("Lovense Remote");
            qg3.j(WearUtils.x, toy);
            DaoUtils.getToyDao().update(toy);
            db2.A().P();
            h32.i().z();
            wi2.e().f("BtWork.updateToyConnect()-->address:" + address + ", connectState:" + i + ", stateCode:" + i2);
        }
        EventBus.getDefault().post(new xc1(address, i));
        MyApplication myApplication = WearUtils.x;
        if (myApplication != null) {
            LocalBroadcastManager.getInstance(myApplication).sendBroadcast(new Intent("ACTION_TOY_UPDATE"));
        }
    }
}
