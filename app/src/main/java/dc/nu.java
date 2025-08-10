package dc;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: BleManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ7\u0010\u000b\u001a\u00020\n\"\u0006\b\u0000\u0010\f\u0018\u00012\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u0012H\u0086\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/component/dxbluetooth/lib/manager/BleManager;", "", "()V", "bleService", "Lcom/component/dxbluetooth/lib/listener/IBleService;", "getBleService", "()Lcom/component/dxbluetooth/lib/listener/IBleService;", "setBleService", "(Lcom/component/dxbluetooth/lib/listener/IBleService;)V", "bindBleService", "", "pushServiceHandle", ExifInterface.GPS_DIRECTION_TRUE, XHTMLText.CODE, "", "args", "Landroid/os/Bundle;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/listener/IBaseBleResponse;", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class nu {

    @NotNull
    public static final nu a;

    @Nullable
    public static st b;

    /* compiled from: BleManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_SERVICE, "Lcom/component/dxbluetooth/lib/listener/IBleService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function1<st, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final void a(@Nullable st stVar) {
            nu.a.c(stVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(st stVar) {
            a(stVar);
            return Unit.INSTANCE;
        }
    }

    static {
        nu nuVar = new nu();
        a = nuVar;
        mu.a.x();
        nuVar.a();
    }

    public final void a() {
        pw.a.b(a.a);
    }

    @Nullable
    public final st b() {
        return b;
    }

    public final void c(@Nullable st stVar) {
        b = stVar;
    }
}
