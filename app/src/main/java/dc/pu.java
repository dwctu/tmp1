package dc;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.component.dxbluetooth.lib.bean.BleDeviceBean;
import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import com.component.dxbluetooth.lib.bean.config.BleConnectConfigBean;
import com.component.dxbluetooth.lib.bean.config.BleSearchConfigBean;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: BleManagerOperateExt.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a:\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\u001a#\u0010\n\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000f\u001a(\u0010\u0010\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a2\u0010\u0016\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0019\u001a2\u0010\u001a\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0019\u001a2\u0010\u001b\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u001c\u001a<\u0010\u001d\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u001c\u001a\u001e\u0010\u001f\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u001c\u001a\u001e\u0010 \u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010!\u001a\u0014\u0010\"\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a-\u0010#\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&\u001a\u001e\u0010'\u001a\u00020\u000b*\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010(2\b\u0010\u0013\u001a\u0004\u0018\u00010)\u001aA\u0010*\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010+\u001a\u0004\u0018\u00010\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u000e2\b\u0010-\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010.\u001a\n\u0010/\u001a\u00020\u000b*\u00020\f\u001a2\u00100\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u000101\u001a2\u00102\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u000101\u001aF\u00103\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u0001052\b\b\u0002\u00106\u001a\u000207\u001aF\u00108\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u000105\u001aF\u00109\u001a\u00020\u000b*\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u0001052\b\b\u0002\u00106\u001a\u000207¨\u0006:"}, d2 = {"createBundle", "Landroid/os/Bundle;", "mac", "", "serviceUUID", "Ljava/util/UUID;", "characteristicUUID", "descriptorUUID", "bytes", "", "clearRequest", "", "Lcom/component/dxbluetooth/lib/manager/BleManager;", "type", "", "(Lcom/component/dxbluetooth/lib/manager/BleManager;Ljava/lang/String;Ljava/lang/Integer;)V", "connect", "configBean", "Lcom/component/dxbluetooth/lib/bean/config/BleConnectConfigBean;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleConnectResponse;", "disconnect", "indicate", NotificationCompat.CATEGORY_SERVICE, FirebaseAnalytics.Param.CHARACTER, "Lcom/component/dxbluetooth/lib/response/BleNotifyResponse;", "notify", "read", "Lcom/component/dxbluetooth/lib/response/BleReadResponse;", "readDescriptor", "descriptor", "readPhy", "readRssi", "Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "refreshGattCache", "requestMtu", "mtu", "Lcom/component/dxbluetooth/lib/response/BleMtuResponse;", "(Lcom/component/dxbluetooth/lib/manager/BleManager;Ljava/lang/String;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleMtuResponse;)V", FirebaseAnalytics.Event.SEARCH, "Lcom/component/dxbluetooth/lib/bean/config/BleSearchConfigBean;", "Lcom/component/dxbluetooth/lib/response/BleSearchResponse;", "setPhy", "txPhy", "rxPhy", "options", "(Lcom/component/dxbluetooth/lib/manager/BleManager;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/component/dxbluetooth/lib/response/BleReadResponse;)V", "stopSearch", "unindicate", "Lcom/component/dxbluetooth/lib/response/BleUnnotifyResponse;", "unnotify", "write", "value", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "isWaitCallback", "", "writeDescriptor", "writeNoRsp", "hytto-apps.android.components.core:dxbluetooth"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class pu {

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* renamed from: dc.pu$a$a, reason: collision with other inner class name */
        public static final class C0208a implements zv {
            public final /* synthetic */ qt a;

            public C0208a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[PHI: r9
  0x0037: PHI (r9v20 java.lang.Object) = 
  (r9v3 java.lang.Object)
  (r9v4 java.lang.Object)
  (r9v5 java.lang.Object)
  (r9v6 java.lang.Object)
  (r9v7 java.lang.Object)
  (r9v8 java.lang.Object)
  (r9v10 java.lang.Object)
  (r9v11 java.lang.Object)
  (r9v12 java.lang.Object)
  (r9v14 java.lang.Object)
  (r9v16 java.lang.Object)
  (r9v17 java.lang.Object)
  (r9v18 java.lang.Object)
  (r9v19 java.lang.Object)
  (r9v21 java.lang.Object)
  (r9v22 java.lang.Object)
 binds: [B:80:0x0163, B:77:0x015a, B:70:0x013f, B:68:0x0133, B:62:0x0120, B:57:0x010b, B:52:0x00f5, B:47:0x00da, B:42:0x00be, B:37:0x00a2, B:32:0x0086, B:27:0x006b, B:22:0x0055, B:20:0x004a, B:13:0x0033, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(@org.jetbrains.annotations.NotNull dc.mt r8, @org.jetbrains.annotations.Nullable android.os.Bundle r9) {
                /*
                    Method dump skipped, instructions count: 382
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: dc.pu.a.C0208a.a(dc.mt, android.os.Bundle):void");
            }
        }

        public a(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new C0208a(qtVar2) : null);
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BleDeviceBean.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", BleDeviceBean.class);
                                } else {
                                    Parcelable parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof BleDeviceBean)) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (BleDeviceBean) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", BleDeviceBean.class);
                                } else {
                                    Parcelable parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof BleDeviceBean)) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (BleDeviceBean) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof BleDeviceBean)) {
                                    string = null;
                                }
                                parcelable = (BleDeviceBean) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                                if (!(objValueOf instanceof BleDeviceBean)) {
                                    objValueOf = null;
                                }
                                parcelable = (BleDeviceBean) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf2 instanceof BleDeviceBean)) {
                                    objValueOf2 = null;
                                }
                                parcelable = (BleDeviceBean) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf3 instanceof BleDeviceBean)) {
                                    objValueOf3 = null;
                                }
                                parcelable = (BleDeviceBean) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf4 instanceof BleDeviceBean)) {
                                    objValueOf4 = null;
                                }
                                parcelable = (BleDeviceBean) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf5 instanceof BleDeviceBean)) {
                                    objValueOf5 = null;
                                }
                                parcelable = (BleDeviceBean) objValueOf5;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                Object byteArray = bundle.getByteArray("extra_response");
                                if (!(byteArray instanceof BleDeviceBean)) {
                                    byteArray = null;
                                }
                                parcelable = (BleDeviceBean) byteArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                Object intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof BleDeviceBean)) {
                                    intArray = null;
                                }
                                parcelable = (BleDeviceBean) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", BleDeviceBean.class);
                                } else {
                                    Parcelable parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof BleDeviceBean)) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (BleDeviceBean) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof BleDeviceBean)) {
                                        serializable = null;
                                    }
                                    parcelable = (BleDeviceBean) serializable;
                                } else {
                                    Object serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof BleDeviceBean)) {
                                        serializable2 = null;
                                    }
                                    parcelable = (BleDeviceBean) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public b(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements zv {
        public final /* synthetic */ qt a;

        public c(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BleDeviceBean.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", BleDeviceBean.class);
                            } else {
                                Parcelable parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof BleDeviceBean)) {
                                    parcelable2 = null;
                                }
                                parcelable = (BleDeviceBean) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", BleDeviceBean.class);
                            } else {
                                Parcelable parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof BleDeviceBean)) {
                                    parcelable3 = null;
                                }
                                parcelable = (BleDeviceBean) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof BleDeviceBean)) {
                                string = null;
                            }
                            parcelable = (BleDeviceBean) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                            if (!(objValueOf instanceof BleDeviceBean)) {
                                objValueOf = null;
                            }
                            parcelable = (BleDeviceBean) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf2 instanceof BleDeviceBean)) {
                                objValueOf2 = null;
                            }
                            parcelable = (BleDeviceBean) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf3 instanceof BleDeviceBean)) {
                                objValueOf3 = null;
                            }
                            parcelable = (BleDeviceBean) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf4 instanceof BleDeviceBean)) {
                                objValueOf4 = null;
                            }
                            parcelable = (BleDeviceBean) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf5 instanceof BleDeviceBean)) {
                                objValueOf5 = null;
                            }
                            parcelable = (BleDeviceBean) objValueOf5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            Object byteArray = bundle.getByteArray("extra_response");
                            if (!(byteArray instanceof BleDeviceBean)) {
                                byteArray = null;
                            }
                            parcelable = (BleDeviceBean) byteArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            Object intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof BleDeviceBean)) {
                                intArray = null;
                            }
                            parcelable = (BleDeviceBean) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", BleDeviceBean.class);
                            } else {
                                Parcelable parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof BleDeviceBean)) {
                                    parcelable4 = null;
                                }
                                parcelable = (BleDeviceBean) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof BleDeviceBean)) {
                                    serializable = null;
                                }
                                parcelable = (BleDeviceBean) serializable;
                            } else {
                                Object serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof BleDeviceBean)) {
                                    serializable2 = null;
                                }
                                parcelable = (BleDeviceBean) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class d implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[PHI: r9
  0x0037: PHI (r9v20 java.lang.Object) = 
  (r9v3 java.lang.Object)
  (r9v4 java.lang.Object)
  (r9v5 java.lang.Object)
  (r9v6 java.lang.Object)
  (r9v7 java.lang.Object)
  (r9v8 java.lang.Object)
  (r9v10 java.lang.Object)
  (r9v11 java.lang.Object)
  (r9v12 java.lang.Object)
  (r9v14 java.lang.Object)
  (r9v16 java.lang.Object)
  (r9v17 java.lang.Object)
  (r9v18 java.lang.Object)
  (r9v19 java.lang.Object)
  (r9v21 java.lang.Object)
  (r9v22 java.lang.Object)
 binds: [B:80:0x0163, B:77:0x015a, B:70:0x013f, B:68:0x0133, B:62:0x0120, B:57:0x010b, B:52:0x00f5, B:47:0x00da, B:42:0x00be, B:37:0x00a2, B:32:0x0086, B:27:0x006b, B:22:0x0055, B:20:0x004a, B:13:0x0033, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(@org.jetbrains.annotations.NotNull dc.mt r8, @org.jetbrains.annotations.Nullable android.os.Bundle r9) {
                /*
                    Method dump skipped, instructions count: 382
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: dc.pu.d.a.a(dc.mt, android.os.Bundle):void");
            }
        }

        public d(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof byte[])) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (byte[]) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof byte[])) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (byte[]) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof byte[])) {
                                    string = null;
                                }
                                parcelable = (byte[]) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                                if (!(objValueOf instanceof byte[])) {
                                    objValueOf = null;
                                }
                                parcelable = (byte[]) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf2 instanceof byte[])) {
                                    objValueOf2 = null;
                                }
                                parcelable = (byte[]) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf3 instanceof byte[])) {
                                    objValueOf3 = null;
                                }
                                parcelable = (byte[]) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf4 instanceof byte[])) {
                                    objValueOf4 = null;
                                }
                                parcelable = (byte[]) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf5 instanceof byte[])) {
                                    objValueOf5 = null;
                                }
                                parcelable = (byte[]) objValueOf5;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                parcelable = bundle.getByteArray("extra_response");
                                if (!(parcelable instanceof byte[])) {
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                int[] intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof byte[])) {
                                    intArray = null;
                                }
                                parcelable = (byte[]) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof byte[])) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (byte[]) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof byte[])) {
                                        serializable = null;
                                    }
                                    parcelable = (byte[]) serializable;
                                } else {
                                    Object serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof byte[])) {
                                        serializable2 = null;
                                    }
                                    parcelable = (byte[]) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public e(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f implements zv {
        public final /* synthetic */ qt a;

        public f(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof byte[])) {
                                    parcelable2 = null;
                                }
                                parcelable = (byte[]) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof byte[])) {
                                    parcelable3 = null;
                                }
                                parcelable = (byte[]) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof byte[])) {
                                string = null;
                            }
                            parcelable = (byte[]) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                            if (!(objValueOf instanceof byte[])) {
                                objValueOf = null;
                            }
                            parcelable = (byte[]) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf2 instanceof byte[])) {
                                objValueOf2 = null;
                            }
                            parcelable = (byte[]) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf3 instanceof byte[])) {
                                objValueOf3 = null;
                            }
                            parcelable = (byte[]) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf4 instanceof byte[])) {
                                objValueOf4 = null;
                            }
                            parcelable = (byte[]) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf5 instanceof byte[])) {
                                objValueOf5 = null;
                            }
                            parcelable = (byte[]) objValueOf5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            parcelable = bundle.getByteArray("extra_response");
                            if (!(parcelable instanceof byte[])) {
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            int[] intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof byte[])) {
                                intArray = null;
                            }
                            parcelable = (byte[]) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof byte[])) {
                                    parcelable4 = null;
                                }
                                parcelable = (byte[]) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof byte[])) {
                                    serializable = null;
                                }
                                parcelable = (byte[]) serializable;
                            } else {
                                Object serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof byte[])) {
                                    serializable2 = null;
                                }
                                parcelable = (byte[]) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BleManagerOperateExt.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0010"}, d2 = {"com/component/dxbluetooth/lib/manager/ext/BleManagerOperateExtKt$notify$1", "Lcom/component/dxbluetooth/lib/response/BleNotifyResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onNotify", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "value", "", "onResponse", "data", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g implements bw {
        public final /* synthetic */ bw a;
        public final /* synthetic */ String b;
        public final /* synthetic */ UUID c;
        public final /* synthetic */ UUID d;

        public g(bw bwVar, String str, UUID uuid, UUID uuid2) {
            this.a = bwVar;
            this.b = str;
            this.c = uuid;
            this.d = uuid2;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            bw bwVar = this.a;
            if (bwVar == null) {
                return;
            }
            bwVar.b(code, str);
        }

        @Override // dc.bw
        public void c(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr) {
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable byte[] bArr) {
            String str;
            UUID uuid;
            UUID uuid2;
            Intrinsics.checkNotNullParameter(code, "code");
            bw bwVar = this.a;
            if (bwVar == null || (str = this.b) == null || (uuid = this.c) == null || (uuid2 = this.d) == null) {
                return;
            }
            if (code == mt.REQUEST_SUCCESS) {
                mu.a.B(str, uuid, uuid2, bwVar);
            }
            this.a.a(code, bArr);
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class h implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof byte[])) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (byte[]) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof byte[])) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (byte[]) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof byte[])) {
                                    string = null;
                                }
                                parcelable = (byte[]) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                                if (!(objValueOf instanceof byte[])) {
                                    objValueOf = null;
                                }
                                parcelable = (byte[]) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf2 instanceof byte[])) {
                                    objValueOf2 = null;
                                }
                                parcelable = (byte[]) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf3 instanceof byte[])) {
                                    objValueOf3 = null;
                                }
                                parcelable = (byte[]) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf4 instanceof byte[])) {
                                    objValueOf4 = null;
                                }
                                parcelable = (byte[]) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf5 instanceof byte[])) {
                                    objValueOf5 = null;
                                }
                                parcelable = (byte[]) objValueOf5;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                parcelable = bundle.getByteArray("extra_response");
                                if (!(parcelable instanceof byte[])) {
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                int[] intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof byte[])) {
                                    intArray = null;
                                }
                                parcelable = (byte[]) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof byte[])) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (byte[]) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof byte[])) {
                                        serializable = null;
                                    }
                                    parcelable = (byte[]) serializable;
                                } else {
                                    Object serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof byte[])) {
                                        serializable2 = null;
                                    }
                                    parcelable = (byte[]) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public h(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class i implements zv {
        public final /* synthetic */ qt a;

        public i(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof byte[])) {
                                    parcelable2 = null;
                                }
                                parcelable = (byte[]) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof byte[])) {
                                    parcelable3 = null;
                                }
                                parcelable = (byte[]) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof byte[])) {
                                string = null;
                            }
                            parcelable = (byte[]) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                            if (!(objValueOf instanceof byte[])) {
                                objValueOf = null;
                            }
                            parcelable = (byte[]) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf2 instanceof byte[])) {
                                objValueOf2 = null;
                            }
                            parcelable = (byte[]) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf3 instanceof byte[])) {
                                objValueOf3 = null;
                            }
                            parcelable = (byte[]) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf4 instanceof byte[])) {
                                objValueOf4 = null;
                            }
                            parcelable = (byte[]) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf5 instanceof byte[])) {
                                objValueOf5 = null;
                            }
                            parcelable = (byte[]) objValueOf5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            parcelable = bundle.getByteArray("extra_response");
                            if (!(parcelable instanceof byte[])) {
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            int[] intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof byte[])) {
                                intArray = null;
                            }
                            parcelable = (byte[]) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof byte[])) {
                                    parcelable4 = null;
                                }
                                parcelable = (byte[]) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof byte[])) {
                                    serializable = null;
                                }
                                parcelable = (byte[]) serializable;
                            } else {
                                Object serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof byte[])) {
                                    serializable2 = null;
                                }
                                parcelable = (byte[]) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class j implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof Integer)) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (Integer) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof Integer)) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (Integer) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof Integer)) {
                                    string = null;
                                }
                                parcelable = (Integer) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                parcelable = Integer.valueOf(bundle.getInt("extra_response", -1));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf instanceof Integer)) {
                                    objValueOf = null;
                                }
                                parcelable = (Integer) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf2 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf2 instanceof Integer)) {
                                    objValueOf2 = null;
                                }
                                parcelable = (Integer) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf3 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf3 instanceof Integer)) {
                                    objValueOf3 = null;
                                }
                                parcelable = (Integer) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf4 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf4 instanceof Integer)) {
                                    objValueOf4 = null;
                                }
                                parcelable = (Integer) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                Object byteArray = bundle.getByteArray("extra_response");
                                if (!(byteArray instanceof Integer)) {
                                    byteArray = null;
                                }
                                parcelable = (Integer) byteArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                Object intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof Integer)) {
                                    intArray = null;
                                }
                                parcelable = (Integer) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof Integer)) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (Integer) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Serializable serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof Integer)) {
                                        serializable = null;
                                    }
                                    parcelable = (Integer) serializable;
                                } else {
                                    Serializable serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof Integer)) {
                                        serializable2 = null;
                                    }
                                    parcelable = (Integer) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public j(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class k implements zv {
        public final /* synthetic */ qt a;

        public k(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof Integer)) {
                                    parcelable2 = null;
                                }
                                parcelable = (Integer) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof Integer)) {
                                    parcelable3 = null;
                                }
                                parcelable = (Integer) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof Integer)) {
                                string = null;
                            }
                            parcelable = (Integer) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            parcelable = Integer.valueOf(bundle.getInt("extra_response", -1));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf instanceof Integer)) {
                                objValueOf = null;
                            }
                            parcelable = (Integer) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf2 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf2 instanceof Integer)) {
                                objValueOf2 = null;
                            }
                            parcelable = (Integer) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf3 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf3 instanceof Integer)) {
                                objValueOf3 = null;
                            }
                            parcelable = (Integer) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf4 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf4 instanceof Integer)) {
                                objValueOf4 = null;
                            }
                            parcelable = (Integer) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            Object byteArray = bundle.getByteArray("extra_response");
                            if (!(byteArray instanceof Integer)) {
                                byteArray = null;
                            }
                            parcelable = (Integer) byteArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            Object intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof Integer)) {
                                intArray = null;
                            }
                            parcelable = (Integer) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof Integer)) {
                                    parcelable4 = null;
                                }
                                parcelable = (Integer) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Serializable serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof Integer)) {
                                    serializable = null;
                                }
                                parcelable = (Integer) serializable;
                            } else {
                                Serializable serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof Integer)) {
                                    serializable2 = null;
                                }
                                parcelable = (Integer) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class l implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof Integer)) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (Integer) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof Integer)) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (Integer) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof Integer)) {
                                    string = null;
                                }
                                parcelable = (Integer) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                parcelable = Integer.valueOf(bundle.getInt("extra_response", -1));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf instanceof Integer)) {
                                    objValueOf = null;
                                }
                                parcelable = (Integer) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf2 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf2 instanceof Integer)) {
                                    objValueOf2 = null;
                                }
                                parcelable = (Integer) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf3 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf3 instanceof Integer)) {
                                    objValueOf3 = null;
                                }
                                parcelable = (Integer) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf4 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf4 instanceof Integer)) {
                                    objValueOf4 = null;
                                }
                                parcelable = (Integer) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                Object byteArray = bundle.getByteArray("extra_response");
                                if (!(byteArray instanceof Integer)) {
                                    byteArray = null;
                                }
                                parcelable = (Integer) byteArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                Object intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof Integer)) {
                                    intArray = null;
                                }
                                parcelable = (Integer) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof Integer)) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (Integer) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Serializable serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof Integer)) {
                                        serializable = null;
                                    }
                                    parcelable = (Integer) serializable;
                                } else {
                                    Serializable serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof Integer)) {
                                        serializable2 = null;
                                    }
                                    parcelable = (Integer) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public l(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class m implements zv {
        public final /* synthetic */ qt a;

        public m(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof Integer)) {
                                    parcelable2 = null;
                                }
                                parcelable = (Integer) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof Integer)) {
                                    parcelable3 = null;
                                }
                                parcelable = (Integer) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof Integer)) {
                                string = null;
                            }
                            parcelable = (Integer) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            parcelable = Integer.valueOf(bundle.getInt("extra_response", -1));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf instanceof Integer)) {
                                objValueOf = null;
                            }
                            parcelable = (Integer) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf2 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf2 instanceof Integer)) {
                                objValueOf2 = null;
                            }
                            parcelable = (Integer) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf3 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf3 instanceof Integer)) {
                                objValueOf3 = null;
                            }
                            parcelable = (Integer) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf4 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf4 instanceof Integer)) {
                                objValueOf4 = null;
                            }
                            parcelable = (Integer) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            Object byteArray = bundle.getByteArray("extra_response");
                            if (!(byteArray instanceof Integer)) {
                                byteArray = null;
                            }
                            parcelable = (Integer) byteArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            Object intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof Integer)) {
                                intArray = null;
                            }
                            parcelable = (Integer) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof Integer)) {
                                    parcelable4 = null;
                                }
                                parcelable = (Integer) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Serializable serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof Integer)) {
                                    serializable = null;
                                }
                                parcelable = (Integer) serializable;
                            } else {
                                Serializable serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof Integer)) {
                                    serializable2 = null;
                                }
                                parcelable = (Integer) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class n implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", BleSearchDeviceBean.class);
                                } else {
                                    Parcelable parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof BleSearchDeviceBean)) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (BleSearchDeviceBean) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", BleSearchDeviceBean.class);
                                } else {
                                    Parcelable parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof BleSearchDeviceBean)) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (BleSearchDeviceBean) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof BleSearchDeviceBean)) {
                                    string = null;
                                }
                                parcelable = (BleSearchDeviceBean) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                                if (!(objValueOf instanceof BleSearchDeviceBean)) {
                                    objValueOf = null;
                                }
                                parcelable = (BleSearchDeviceBean) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf2 instanceof BleSearchDeviceBean)) {
                                    objValueOf2 = null;
                                }
                                parcelable = (BleSearchDeviceBean) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf3 instanceof BleSearchDeviceBean)) {
                                    objValueOf3 = null;
                                }
                                parcelable = (BleSearchDeviceBean) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf4 instanceof BleSearchDeviceBean)) {
                                    objValueOf4 = null;
                                }
                                parcelable = (BleSearchDeviceBean) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf5 instanceof BleSearchDeviceBean)) {
                                    objValueOf5 = null;
                                }
                                parcelable = (BleSearchDeviceBean) objValueOf5;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                Object byteArray = bundle.getByteArray("extra_response");
                                if (!(byteArray instanceof BleSearchDeviceBean)) {
                                    byteArray = null;
                                }
                                parcelable = (BleSearchDeviceBean) byteArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                Object intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof BleSearchDeviceBean)) {
                                    intArray = null;
                                }
                                parcelable = (BleSearchDeviceBean) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", BleSearchDeviceBean.class);
                                } else {
                                    Parcelable parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof BleSearchDeviceBean)) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (BleSearchDeviceBean) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof BleSearchDeviceBean)) {
                                        serializable = null;
                                    }
                                    parcelable = (BleSearchDeviceBean) serializable;
                                } else {
                                    Object serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof BleSearchDeviceBean)) {
                                        serializable2 = null;
                                    }
                                    parcelable = (BleSearchDeviceBean) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public n(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class o implements zv {
        public final /* synthetic */ qt a;

        public o(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", BleSearchDeviceBean.class);
                            } else {
                                Parcelable parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof BleSearchDeviceBean)) {
                                    parcelable2 = null;
                                }
                                parcelable = (BleSearchDeviceBean) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", BleSearchDeviceBean.class);
                            } else {
                                Parcelable parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof BleSearchDeviceBean)) {
                                    parcelable3 = null;
                                }
                                parcelable = (BleSearchDeviceBean) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof BleSearchDeviceBean)) {
                                string = null;
                            }
                            parcelable = (BleSearchDeviceBean) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                            if (!(objValueOf instanceof BleSearchDeviceBean)) {
                                objValueOf = null;
                            }
                            parcelable = (BleSearchDeviceBean) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf2 instanceof BleSearchDeviceBean)) {
                                objValueOf2 = null;
                            }
                            parcelable = (BleSearchDeviceBean) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf3 instanceof BleSearchDeviceBean)) {
                                objValueOf3 = null;
                            }
                            parcelable = (BleSearchDeviceBean) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf4 instanceof BleSearchDeviceBean)) {
                                objValueOf4 = null;
                            }
                            parcelable = (BleSearchDeviceBean) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf5 instanceof BleSearchDeviceBean)) {
                                objValueOf5 = null;
                            }
                            parcelable = (BleSearchDeviceBean) objValueOf5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            Object byteArray = bundle.getByteArray("extra_response");
                            if (!(byteArray instanceof BleSearchDeviceBean)) {
                                byteArray = null;
                            }
                            parcelable = (BleSearchDeviceBean) byteArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            Object intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof BleSearchDeviceBean)) {
                                intArray = null;
                            }
                            parcelable = (BleSearchDeviceBean) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", BleSearchDeviceBean.class);
                            } else {
                                Parcelable parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof BleSearchDeviceBean)) {
                                    parcelable4 = null;
                                }
                                parcelable = (BleSearchDeviceBean) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof BleSearchDeviceBean)) {
                                    serializable = null;
                                }
                                parcelable = (BleSearchDeviceBean) serializable;
                            } else {
                                Object serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof BleSearchDeviceBean)) {
                                    serializable2 = null;
                                }
                                parcelable = (BleSearchDeviceBean) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class p implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof byte[])) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (byte[]) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof byte[])) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (byte[]) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof byte[])) {
                                    string = null;
                                }
                                parcelable = (byte[]) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                                if (!(objValueOf instanceof byte[])) {
                                    objValueOf = null;
                                }
                                parcelable = (byte[]) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf2 instanceof byte[])) {
                                    objValueOf2 = null;
                                }
                                parcelable = (byte[]) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf3 instanceof byte[])) {
                                    objValueOf3 = null;
                                }
                                parcelable = (byte[]) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf4 instanceof byte[])) {
                                    objValueOf4 = null;
                                }
                                parcelable = (byte[]) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf5 instanceof byte[])) {
                                    objValueOf5 = null;
                                }
                                parcelable = (byte[]) objValueOf5;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                parcelable = bundle.getByteArray("extra_response");
                                if (!(parcelable instanceof byte[])) {
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                int[] intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof byte[])) {
                                    intArray = null;
                                }
                                parcelable = (byte[]) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", byte[].class);
                                } else {
                                    Object parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof byte[])) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (byte[]) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof byte[])) {
                                        serializable = null;
                                    }
                                    parcelable = (byte[]) serializable;
                                } else {
                                    Object serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof byte[])) {
                                        serializable2 = null;
                                    }
                                    parcelable = (byte[]) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public p(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class q implements zv {
        public final /* synthetic */ qt a;

        public q(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof byte[])) {
                                    parcelable2 = null;
                                }
                                parcelable = (byte[]) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof byte[])) {
                                    parcelable3 = null;
                                }
                                parcelable = (byte[]) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof byte[])) {
                                string = null;
                            }
                            parcelable = (byte[]) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            Object objValueOf = Integer.valueOf(bundle.getInt("extra_response", -1));
                            if (!(objValueOf instanceof byte[])) {
                                objValueOf = null;
                            }
                            parcelable = (byte[]) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf2 = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf2 instanceof byte[])) {
                                objValueOf2 = null;
                            }
                            parcelable = (byte[]) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf3 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf3 instanceof byte[])) {
                                objValueOf3 = null;
                            }
                            parcelable = (byte[]) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf4 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf4 instanceof byte[])) {
                                objValueOf4 = null;
                            }
                            parcelable = (byte[]) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf5 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf5 instanceof byte[])) {
                                objValueOf5 = null;
                            }
                            parcelable = (byte[]) objValueOf5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            parcelable = bundle.getByteArray("extra_response");
                            if (!(parcelable instanceof byte[])) {
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            int[] intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof byte[])) {
                                intArray = null;
                            }
                            parcelable = (byte[]) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", byte[].class);
                            } else {
                                Object parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof byte[])) {
                                    parcelable4 = null;
                                }
                                parcelable = (byte[]) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Object serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof byte[])) {
                                    serializable = null;
                                }
                                parcelable = (byte[]) serializable;
                            } else {
                                Object serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof byte[])) {
                                    serializable2 = null;
                                }
                                parcelable = (byte[]) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class r implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[PHI: r9
  0x0037: PHI (r9v20 java.lang.Object) = 
  (r9v3 java.lang.Object)
  (r9v4 java.lang.Object)
  (r9v5 java.lang.Object)
  (r9v6 java.lang.Object)
  (r9v7 java.lang.Object)
  (r9v8 java.lang.Object)
  (r9v10 java.lang.Object)
  (r9v11 java.lang.Object)
  (r9v12 java.lang.Object)
  (r9v14 java.lang.Object)
  (r9v16 java.lang.Object)
  (r9v17 java.lang.Object)
  (r9v18 java.lang.Object)
  (r9v19 java.lang.Object)
  (r9v21 java.lang.Object)
  (r9v22 java.lang.Object)
 binds: [B:80:0x0163, B:77:0x015a, B:70:0x013f, B:68:0x0133, B:62:0x0120, B:57:0x010b, B:52:0x00f5, B:47:0x00da, B:42:0x00be, B:37:0x00a2, B:32:0x0086, B:27:0x006b, B:22:0x0055, B:20:0x004a, B:13:0x0033, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(@org.jetbrains.annotations.NotNull dc.mt r8, @org.jetbrains.annotations.Nullable android.os.Bundle r9) {
                /*
                    Method dump skipped, instructions count: 382
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: dc.pu.r.a.a(dc.mt, android.os.Bundle):void");
            }
        }

        public r(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class s implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof Integer)) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (Integer) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof Integer)) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (Integer) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof Integer)) {
                                    string = null;
                                }
                                parcelable = (Integer) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                parcelable = Integer.valueOf(bundle.getInt("extra_response", -1));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf instanceof Integer)) {
                                    objValueOf = null;
                                }
                                parcelable = (Integer) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf2 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf2 instanceof Integer)) {
                                    objValueOf2 = null;
                                }
                                parcelable = (Integer) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf3 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf3 instanceof Integer)) {
                                    objValueOf3 = null;
                                }
                                parcelable = (Integer) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf4 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf4 instanceof Integer)) {
                                    objValueOf4 = null;
                                }
                                parcelable = (Integer) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                Object byteArray = bundle.getByteArray("extra_response");
                                if (!(byteArray instanceof Integer)) {
                                    byteArray = null;
                                }
                                parcelable = (Integer) byteArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                Object intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof Integer)) {
                                    intArray = null;
                                }
                                parcelable = (Integer) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof Integer)) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (Integer) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Serializable serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof Integer)) {
                                        serializable = null;
                                    }
                                    parcelable = (Integer) serializable;
                                } else {
                                    Serializable serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof Integer)) {
                                        serializable2 = null;
                                    }
                                    parcelable = (Integer) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public s(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class t implements zv {
        public final /* synthetic */ qt a;

        public t(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof Integer)) {
                                    parcelable2 = null;
                                }
                                parcelable = (Integer) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof Integer)) {
                                    parcelable3 = null;
                                }
                                parcelable = (Integer) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof Integer)) {
                                string = null;
                            }
                            parcelable = (Integer) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            parcelable = Integer.valueOf(bundle.getInt("extra_response", -1));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf instanceof Integer)) {
                                objValueOf = null;
                            }
                            parcelable = (Integer) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf2 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf2 instanceof Integer)) {
                                objValueOf2 = null;
                            }
                            parcelable = (Integer) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf3 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf3 instanceof Integer)) {
                                objValueOf3 = null;
                            }
                            parcelable = (Integer) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf4 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf4 instanceof Integer)) {
                                objValueOf4 = null;
                            }
                            parcelable = (Integer) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            Object byteArray = bundle.getByteArray("extra_response");
                            if (!(byteArray instanceof Integer)) {
                                byteArray = null;
                            }
                            parcelable = (Integer) byteArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            Object intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof Integer)) {
                                intArray = null;
                            }
                            parcelable = (Integer) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof Integer)) {
                                    parcelable4 = null;
                                }
                                parcelable = (Integer) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Serializable serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof Integer)) {
                                    serializable = null;
                                }
                                parcelable = (Integer) serializable;
                            } else {
                                Serializable serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof Integer)) {
                                    serializable2 = null;
                                }
                                parcelable = (Integer) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class u implements Runnable {
        public final /* synthetic */ qt a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Bundle c;

        /* compiled from: BleServiceImpl.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$1$run$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements zv {
            public final /* synthetic */ qt a;

            public a(qt qtVar) {
                this.a = qtVar;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    this.a.b(code, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Bundle bundle) {
                Object parcelable;
                Intrinsics.checkNotNullParameter(code, "code");
                try {
                    qt qtVar = this.a;
                    Object obj = null;
                    if (bundle != null) {
                        qw qwVar = qw.a;
                        try {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable2 = bundle.getParcelable("extra_response");
                                    if (!(parcelable2 instanceof Integer)) {
                                        parcelable2 = null;
                                    }
                                    parcelable = (Integer) parcelable2;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable3 = bundle.getParcelable("extra_response");
                                    if (!(parcelable3 instanceof Integer)) {
                                        parcelable3 = null;
                                    }
                                    parcelable = (Integer) parcelable3;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                Object string = bundle.getString("extra_response");
                                if (!(string instanceof Integer)) {
                                    string = null;
                                }
                                parcelable = (Integer) string;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                parcelable = Integer.valueOf(bundle.getInt("extra_response", -1));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                Object objValueOf = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                                if (!(objValueOf instanceof Integer)) {
                                    objValueOf = null;
                                }
                                parcelable = (Integer) objValueOf;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                Object objValueOf2 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                                if (!(objValueOf2 instanceof Integer)) {
                                    objValueOf2 = null;
                                }
                                parcelable = (Integer) objValueOf2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                Object objValueOf3 = Long.valueOf(bundle.getLong("extra_response", -1L));
                                if (!(objValueOf3 instanceof Integer)) {
                                    objValueOf3 = null;
                                }
                                parcelable = (Integer) objValueOf3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                Object objValueOf4 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                                if (!(objValueOf4 instanceof Integer)) {
                                    objValueOf4 = null;
                                }
                                parcelable = (Integer) objValueOf4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                                Object byteArray = bundle.getByteArray("extra_response");
                                if (!(byteArray instanceof Integer)) {
                                    byteArray = null;
                                }
                                parcelable = (Integer) byteArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                                Object intArray = bundle.getIntArray("extra_response");
                                if (!(intArray instanceof Integer)) {
                                    intArray = null;
                                }
                                parcelable = (Integer) intArray;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    parcelable = bundle.getParcelable("extra_response", Integer.class);
                                } else {
                                    Object parcelable4 = bundle.getParcelable("extra_response");
                                    if (!(parcelable4 instanceof Integer)) {
                                        parcelable4 = null;
                                    }
                                    parcelable = (Integer) parcelable4;
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    Serializable serializable = bundle.getSerializable("extra_response", Serializable.class);
                                    if (!(serializable instanceof Integer)) {
                                        serializable = null;
                                    }
                                    parcelable = (Integer) serializable;
                                } else {
                                    Serializable serializable2 = bundle.getSerializable("extra_response");
                                    if (!(serializable2 instanceof Integer)) {
                                        serializable2 = null;
                                    }
                                    parcelable = (Integer) serializable2;
                                }
                            }
                            obj = parcelable;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    qtVar.a(code, obj);
                } catch (Throwable th) {
                    this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                    th.printStackTrace();
                }
            }
        }

        public u(qt qtVar, int i, Bundle bundle) {
            this.a = qtVar;
            this.b = i;
            this.c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nu nuVar = nu.a;
            if (nuVar.b() == null) {
                qt qtVar = this.a;
                if (qtVar == null) {
                    return;
                }
                qtVar.b(mt.BLE_SERVICE_NOT_BIND, "蓝牙服务未绑定");
                return;
            }
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            int i = this.b;
            Bundle bundle = this.c;
            if (bundle == null) {
                bundle = new Bundle();
            }
            qt qtVar2 = this.a;
            qwVar.c(i, bundle, qtVar2 != null ? new a(qtVar2) : null);
        }
    }

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\f"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceImpl$callBluetoothApi$1", "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "Landroid/os/Bundle;", "hytto-apps.android.components.core:dxbluetooth", "com/component/dxbluetooth/lib/manager/BleManager$pushServiceHandle$$inlined$callBluetoothApi$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class v implements zv {
        public final /* synthetic */ qt a;

        public v(qt qtVar) {
            this.a = qtVar;
        }

        @Override // dc.qt
        public void b(@NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                this.a.b(code, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Bundle bundle) {
            Object parcelable;
            Intrinsics.checkNotNullParameter(code, "code");
            try {
                qt qtVar = this.a;
                Object obj = null;
                if (bundle != null) {
                    qw qwVar = qw.a;
                    try {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleSearchDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable2 = bundle.getParcelable("extra_response");
                                if (!(parcelable2 instanceof Integer)) {
                                    parcelable2 = null;
                                }
                                parcelable = (Integer) parcelable2;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BleDeviceBean.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable3 = bundle.getParcelable("extra_response");
                                if (!(parcelable3 instanceof Integer)) {
                                    parcelable3 = null;
                                }
                                parcelable = (Integer) parcelable3;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string = bundle.getString("extra_response");
                            if (!(string instanceof Integer)) {
                                string = null;
                            }
                            parcelable = (Integer) string;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            parcelable = Integer.valueOf(bundle.getInt("extra_response", -1));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            Object objValueOf = Float.valueOf(bundle.getFloat("extra_response", -1.0f));
                            if (!(objValueOf instanceof Integer)) {
                                objValueOf = null;
                            }
                            parcelable = (Integer) objValueOf;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            Object objValueOf2 = Double.valueOf(bundle.getDouble("extra_response", -1.0d));
                            if (!(objValueOf2 instanceof Integer)) {
                                objValueOf2 = null;
                            }
                            parcelable = (Integer) objValueOf2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            Object objValueOf3 = Long.valueOf(bundle.getLong("extra_response", -1L));
                            if (!(objValueOf3 instanceof Integer)) {
                                objValueOf3 = null;
                            }
                            parcelable = (Integer) objValueOf3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            Object objValueOf4 = Boolean.valueOf(bundle.getBoolean("extra_response", false));
                            if (!(objValueOf4 instanceof Integer)) {
                                objValueOf4 = null;
                            }
                            parcelable = (Integer) objValueOf4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                            Object byteArray = bundle.getByteArray("extra_response");
                            if (!(byteArray instanceof Integer)) {
                                byteArray = null;
                            }
                            parcelable = (Integer) byteArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                            Object intArray = bundle.getIntArray("extra_response");
                            if (!(intArray instanceof Integer)) {
                                intArray = null;
                            }
                            parcelable = (Integer) intArray;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Parcelable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = bundle.getParcelable("extra_response", Integer.class);
                            } else {
                                Object parcelable4 = bundle.getParcelable("extra_response");
                                if (!(parcelable4 instanceof Integer)) {
                                    parcelable4 = null;
                                }
                                parcelable = (Integer) parcelable4;
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Serializable.class))) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                Serializable serializable = bundle.getSerializable("extra_response", Serializable.class);
                                if (!(serializable instanceof Integer)) {
                                    serializable = null;
                                }
                                parcelable = (Integer) serializable;
                            } else {
                                Serializable serializable2 = bundle.getSerializable("extra_response");
                                if (!(serializable2 instanceof Integer)) {
                                    serializable2 = null;
                                }
                                parcelable = (Integer) serializable2;
                            }
                        }
                        obj = parcelable;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                qtVar.a(code, obj);
            } catch (Throwable th) {
                this.a.b(mt.ILLEGAL_ARGUMENT, th.getMessage());
                th.printStackTrace();
            }
        }
    }

    public static final void a(@NotNull nu nuVar, @Nullable String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, null, null, null, null);
        bundleC.putInt("extra_type", num == null ? 0 : num.intValue());
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new a(null, 20, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(20, bundleC, null);
        }
    }

    public static final void b(@NotNull nu nuVar, @Nullable String str, @Nullable BleConnectConfigBean bleConnectConfigBean, @Nullable yv yvVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, null, null, null, null);
        bundleC.putParcelable("extra_config", bleConnectConfigBean);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new b(yvVar, 3, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(3, bundleC, yvVar != null ? new c(yvVar) : null);
        }
    }

    public static final Bundle c(String str, UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("extra_mac", str);
        }
        if (uuid != null) {
            bundle.putSerializable("extra_service_uuid", uuid);
        }
        if (uuid2 != null) {
            bundle.putSerializable("extra_character_uuid", uuid2);
        }
        if (uuid3 != null) {
            bundle.putSerializable("extra_descriptor_uuid", uuid3);
        }
        if (bArr != null) {
            bundle.putByteArray("extra_byte_value", bArr);
        }
        return bundle;
    }

    public static final void d(@NotNull nu nuVar, @Nullable String str) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, null, null, null, null);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new d(null, 4, bundleC), 300L);
        } else if (nuVar.b() != null) {
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(4, bundleC, null);
        }
        if (str == null) {
            return;
        }
        mu.a.A(str);
    }

    public static final void e(@NotNull nu nuVar, @Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable bw bwVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, uuid, uuid2, null, null);
        g gVar = new g(bwVar, str, uuid, uuid2);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new e(gVar, 8, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(8, bundleC, new f(gVar));
        }
    }

    public static final void f(@NotNull nu nuVar, @Nullable String str, @Nullable cw cwVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, null, null, null, null);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new h(cwVar, 15, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(15, bundleC, cwVar != null ? new i(cwVar) : null);
        }
    }

    public static final void g(@NotNull nu nuVar, @Nullable String str, @Nullable dw dwVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, null, null, null, null);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new j(dwVar, 10, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(10, bundleC, dwVar != null ? new k(dwVar) : null);
        }
    }

    public static final void h(@NotNull nu nuVar, @Nullable String str, @Nullable Integer num, @Nullable aw awVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, null, null, null, null);
        bundleC.putInt("extra_mtu", num == null ? 0 : num.intValue());
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new l(awVar, 14, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(14, bundleC, awVar != null ? new m(awVar) : null);
        }
    }

    public static final void i(@NotNull nu nuVar, @Nullable BleSearchConfigBean bleSearchConfigBean, @Nullable ew ewVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(null, null, null, null, null);
        bundleC.putParcelable("extra_config", bleSearchConfigBean);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new n(ewVar, 1, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(1, bundleC, ewVar != null ? new o(ewVar) : null);
        }
    }

    public static final void j(@NotNull nu nuVar, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable cw cwVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, null, null, null, null);
        bundleC.putInt("extra_phy_tx", num == null ? 0 : num.intValue());
        bundleC.putInt("extra_phy_rx", num2 == null ? 0 : num2.intValue());
        bundleC.putInt("extra_phy_options", num3 != null ? num3.intValue() : 0);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new p(cwVar, 16, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(16, bundleC, cwVar != null ? new q(cwVar) : null);
        }
    }

    public static final void k(@NotNull nu nuVar) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new r(null, 2, null), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw.a.c(2, new Bundle(), null);
        }
    }

    public static final void l(@NotNull nu nuVar, @Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, uuid, uuid2, null, bArr);
        bundleC.putBoolean("wait_callback", z);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new s(fwVar, 6, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(6, bundleC, fwVar != null ? new t(fwVar) : null);
        }
    }

    public static final void m(@NotNull nu nuVar, @Nullable String str, @Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr, @Nullable fw fwVar, boolean z) {
        Intrinsics.checkNotNullParameter(nuVar, "<this>");
        Bundle bundleC = c(str, uuid, uuid2, null, bArr);
        bundleC.putBoolean("wait_callback", z);
        if (nuVar.b() == null) {
            nuVar.a();
            se0.g(new u(fwVar, 7, bundleC), 300L);
        } else {
            if (nuVar.b() == null) {
                return;
            }
            qw qwVar = qw.a;
            if (bundleC == null) {
                bundleC = new Bundle();
            }
            qwVar.c(7, bundleC, fwVar != null ? new v(fwVar) : null);
        }
    }
}
