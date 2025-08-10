package dc;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.component.dxbluetooth.lib.bean.config.BleConnectConfigBean;
import com.component.dxbluetooth.lib.bean.config.BleSearchConfigBean;
import com.component.dxbluetooth.lib.service.BleService;
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
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: BleServiceImpl.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ5\u0010\u001c\u001a\u00020\u0015\"\u0006\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\u001eH\u0086\bJ$\u0010\u001f\u001a\u0004\u0018\u0001H \"\u0006\b\u0000\u0010 \u0018\u0001*\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0086\b¢\u0006\u0002\u0010#R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/component/dxbluetooth/lib/service/BleServiceImpl;", "Lcom/component/dxbluetooth/lib/listener/IBleService;", "Landroid/os/Handler$Callback;", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", NotificationCompat.CATEGORY_SERVICE, "Lcom/component/dxbluetooth/lib/service/BleService;", "getService", "()Lcom/component/dxbluetooth/lib/service/BleService;", "setService", "(Lcom/component/dxbluetooth/lib/service/BleService;)V", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "sendHandler", "", XHTMLText.CODE, "", "args", "Landroid/os/Bundle;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleGeneralResponse;", "callBluetoothApi", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/component/dxbluetooth/lib/listener/IBaseBleResponse;", "getPushServiceGenericType", "U", "key", "", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class qw implements st, Handler.Callback {

    @Nullable
    public static BleService b;

    @NotNull
    public static final qw a = new qw();

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: BleServiceImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<Handler> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper(), qw.a);
        }
    }

    public final Handler a() {
        return (Handler) c.getValue();
    }

    @Nullable
    public final BleService b() {
        return b;
    }

    public final void c(int i, @NotNull Bundle args, @Nullable zv zvVar) {
        Intrinsics.checkNotNullParameter(args, "args");
        Message messageObtainMessage = a().obtainMessage(i, zvVar);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "handler.obtainMessage(code, response)");
        args.setClassLoader(qw.class.getClassLoader());
        messageObtainMessage.setData(args);
        messageObtainMessage.sendToTarget();
    }

    public final void d(@Nullable BleService bleService) {
        b = bleService;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Bundle data = msg.getData();
        String string = data.getString("extra_mac");
        int i = Build.VERSION.SDK_INT;
        UUID uuid = i >= 33 ? (UUID) data.getSerializable("extra_service_uuid", UUID.class) : (UUID) data.getSerializable("extra_service_uuid");
        UUID uuid2 = i >= 33 ? (UUID) data.getSerializable("extra_character_uuid", UUID.class) : (UUID) data.getSerializable("extra_character_uuid");
        UUID uuid3 = i >= 33 ? (UUID) data.getSerializable("extra_descriptor_uuid", UUID.class) : (UUID) data.getSerializable("extra_descriptor_uuid");
        byte[] byteArray = data.getByteArray("extra_byte_value");
        zv zvVar = (zv) msg.obj;
        int i2 = msg.what;
        if (i2 != 20) {
            if (i2 != 21) {
                switch (i2) {
                    case 1:
                        kw.a.f(i >= 33 ? (BleSearchConfigBean) data.getParcelable("extra_config", BleSearchConfigBean.class) : (BleSearchConfigBean) data.getParcelable("extra_config"), zvVar);
                        break;
                    case 2:
                        kw.a.a();
                        break;
                    case 3:
                        if (string != null) {
                            ot.a(kt.a, string).b(i >= 33 ? (BleConnectConfigBean) data.getParcelable("extra_config", BleConnectConfigBean.class) : (BleConnectConfigBean) data.getParcelable("extra_config"), zvVar);
                            break;
                        }
                        break;
                    case 4:
                        if (string != null) {
                            ot.a(kt.a, string).c();
                            break;
                        }
                        break;
                    case 5:
                        if (string != null) {
                            ot.a(kt.a, string).n(uuid, uuid2, zvVar);
                            break;
                        }
                        break;
                    case 6:
                        if (string != null) {
                            ot.a(kt.a, string).y(uuid, uuid2, byteArray, zvVar, data.getBoolean("wait_callback", true));
                            break;
                        }
                        break;
                    case 7:
                        if (string != null) {
                            ot.a(kt.a, string).A(uuid, uuid2, byteArray, zvVar, data.getBoolean("wait_callback", true));
                            break;
                        }
                        break;
                    case 8:
                        if (string != null) {
                            ot.a(kt.a, string).m(uuid, uuid2, zvVar);
                            break;
                        }
                        break;
                    case 9:
                        if (string != null) {
                            ot.a(kt.a, string).x(uuid, uuid2, zvVar);
                            break;
                        }
                        break;
                    case 10:
                        if (string != null) {
                            ot.a(kt.a, string).q(zvVar);
                            break;
                        }
                        break;
                    case 11:
                        if (string != null) {
                            ot.a(kt.a, string).l(uuid, uuid2, zvVar);
                            break;
                        }
                        break;
                    case 12:
                        if (string != null) {
                            ot.a(kt.a, string).o(uuid, uuid2, uuid3, zvVar);
                            break;
                        }
                        break;
                    case 13:
                        if (string != null) {
                            ot.a(kt.a, string).z(uuid, uuid2, uuid3, byteArray, zvVar);
                            break;
                        }
                        break;
                    case 14:
                        if (string != null) {
                            ot.a(kt.a, string).s(data.getInt("extra_mtu"), zvVar);
                            break;
                        }
                        break;
                    case 15:
                        if (string != null) {
                            ot.a(kt.a, string).p(zvVar);
                            break;
                        }
                        break;
                    case 16:
                        if (string != null) {
                            ot.a(kt.a, string).u(data.getInt("extra_phy_tx"), data.getInt("extra_phy_rx"), data.getInt("extra_phy_options"), zvVar);
                            break;
                        }
                        break;
                }
            } else if (string != null) {
                ot.a(kt.a, string).r();
            }
        } else if (string != null) {
            ot.a(kt.a, string).a(data.getInt("extra_type", 0));
        }
        return true;
    }
}
