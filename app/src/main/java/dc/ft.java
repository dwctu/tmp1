package dc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.config.BleConnectConfigBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.tt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;

/* compiled from: BleQueue.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J&\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010*\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u001bH\u0002J&\u0010,\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016J&\u0010.\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J0\u0010/\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u00100\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u00101\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u00102\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u00103\u001a\u00020\u0017H\u0016J\u001a\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u00106\u001a\u00020\u0017H\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0002J*\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010=\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J8\u0010>\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010A\u001a\u00020#H\u0016J:\u0010B\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u00100\u001a\u0004\u0018\u00010(2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J8\u0010C\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010A\u001a\u00020#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014¨\u0006E"}, d2 = {"Lcom/component/dxbluetooth/lib/connect/BleQueue;", "Lcom/component/dxbluetooth/lib/listener/IBleQueue;", "Lcom/component/dxbluetooth/lib/listener/request/IBleConnectDispatcher;", "Landroid/os/Handler$Callback;", "mac", "", "(Ljava/lang/String;)V", "currentRequest", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getMac", "()Ljava/lang/String;", "requestList", "Ljava/util/LinkedList;", "getRequestList", "()Ljava/util/LinkedList;", "requestList$delegate", "addNewRequest", "", DeliveryReceiptRequest.ELEMENT, "clearRequest", "clearType", "", "connect", "configBean", "Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "disconnect", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "indicate", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "isRequestMatch", "requestType", "notify", "onRequestCompleted", "read", "readDescriptor", "descriptor", "readPhy", "readRemoteRssi", "refreshGattCache", "requestMtu", "mtu", "scheduleNextRequest", "delayInMillis", "", "setPhy", "txPhy", "rxPhy", "phyOptions", "unnotify", "write", "bytes", "", "isWaitCallback", "writeDescriptor", "writeNoRsp", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ft implements xt, Handler.Callback {

    @NotNull
    public final String a;

    @NotNull
    public final Lazy b;

    @Nullable
    public jv c;

    @NotNull
    public final Lazy d;

    /* compiled from: BleQueue.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<Handler> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            Looper looperMyLooper = Looper.myLooper();
            Intrinsics.checkNotNull(looperMyLooper);
            return new Handler(looperMyLooper, ft.this);
        }
    }

    /* compiled from: BleQueue.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/component/dxbluetooth/lib/request/BaseBleRequest;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<LinkedList<jv>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LinkedList<jv> invoke() {
            return new LinkedList<>();
        }
    }

    public ft(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
        this.b = LazyKt__LazyJVMKt.lazy(b.a);
        this.d = LazyKt__LazyJVMKt.lazy(new a());
    }

    @Override // dc.xt
    public void a(@NotNull jv request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request == this.c) {
            this.c = null;
            r(10L);
            return;
        }
        throw new IllegalStateException(("request not match request: " + request + ",  currentRequest " + this.c).toString());
    }

    public final void b(jv jvVar) {
        if (g().size() < 100) {
            jvVar.T(this.a);
            g().add(jvVar);
        } else {
            jvVar.C(mt.REQUEST_OVERFLOW);
        }
        r(10L);
    }

    public void c(int i) {
        rw.a.e(Intrinsics.stringPlus("clearRequest ", Integer.valueOf(i)));
        LinkedList linkedList = new LinkedList();
        if (i == 0) {
            linkedList.addAll(g());
        } else {
            Iterator<jv> it = g().iterator();
            while (it.hasNext()) {
                jv request = it.next();
                Intrinsics.checkNotNullExpressionValue(request, "request");
                if (i(request, i)) {
                    linkedList.add(request);
                }
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            ((jv) it2.next()).k();
        }
        g().removeAll(linkedList);
    }

    public void d(@Nullable BleConnectConfigBean bleConnectConfigBean, @Nullable zv zvVar) {
        if (bleConnectConfigBean == null) {
            bleConnectConfigBean = new BleConnectConfigBean(0, 0, 0L, 0L, 15, null);
        }
        b(new kv(bleConnectConfigBean, zvVar));
    }

    public void e() {
        rw.a.e("Process disconnect");
        jv jvVar = this.c;
        if (jvVar != null) {
            jvVar.k();
        }
        this.c = null;
        Iterator<jv> it = g().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
        g().clear();
        tt.a.a(ot.a(kt.a, this.a).f(), mt.CONNECT_CANCEL, null, 2, null);
    }

    public final Handler f() {
        return (Handler) this.d.getValue();
    }

    public final LinkedList<jv> g() {
        return (LinkedList) this.b.getValue();
    }

    public void h(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        b(new lv(uuid, uuid2, zvVar));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what != 18) {
            return false;
        }
        q();
        return true;
    }

    public final boolean i(jv jvVar, int i) {
        if ((i & 1) != 0) {
            return jvVar instanceof qv;
        }
        if ((i & 2) != 0) {
            if (!(jvVar instanceof xv) && !(jvVar instanceof wv)) {
                return false;
            }
        } else {
            if ((i & 4) == 0) {
                if ((i & 8) != 0) {
                    return jvVar instanceof rv;
                }
                return false;
            }
            if (!(jvVar instanceof nv) && !(jvVar instanceof uv) && !(jvVar instanceof lv)) {
                return false;
            }
        }
        return true;
    }

    public void j(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        b(new nv(uuid, uuid2, zvVar));
    }

    public void k(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        b(new qv(uuid, uuid2, zvVar));
    }

    public void l(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable zv zvVar) {
        b(new ov(uuid, uuid2, uuid3, zvVar));
    }

    public void m(@Nullable zv zvVar) {
        b(new pv(zvVar));
    }

    public void n(@Nullable zv zvVar) {
        b(new rv(zvVar));
    }

    public void o() {
        b(new sv(null));
    }

    public void p(int i, @Nullable zv zvVar) {
        b(new mv(i, zvVar));
    }

    public final void q() {
        if (this.c == null && !g().isEmpty()) {
            jv jvVarRemove = g().remove(0);
            this.c = jvVarRemove;
            if (jvVarRemove == null) {
                return;
            }
            jvVarRemove.F(this);
        }
    }

    public final void r(long j) {
        f().sendEmptyMessageDelayed(18, j);
    }

    public void s(int i, int i2, int i3, @Nullable zv zvVar) {
        b(new tv(i, i2, i3, zvVar));
    }

    public void t(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable zv zvVar) {
        b(new uv(uuid, uuid2, zvVar));
    }

    public void u(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable zv zvVar, boolean z) {
        b(new xv(uuid, uuid2, bArr, zvVar, z));
    }

    public void v(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable byte[] bArr, @Nullable zv zvVar) {
        b(new vv(uuid, uuid2, uuid3, bArr, zvVar));
    }

    public void w(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable zv zvVar, boolean z) {
        b(new wv(uuid, uuid2, bArr, zvVar, z));
    }
}
