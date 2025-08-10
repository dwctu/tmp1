package dc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: BleCharacterChangeReceiver.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/BleCharacterChangeReceiver;", "Lcom/component/dxbluetooth/lib/receiver/BaseBleReceiver;", "dispatcher", "Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;", "(Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;)V", "actionList", "", "", "getActionList", "()Ljava/util/List;", "actionList$delegate", "Lkotlin/Lazy;", "onCharacterChanged", "", "mac", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "value", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class wu extends vu {

    @NotNull
    public static final a c = new a(null);

    @NotNull
    public final Lazy b;

    /* compiled from: BleCharacterChangeReceiver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/BleCharacterChangeReceiver$Companion;", "", "()V", "newInstance", "Lcom/component/dxbluetooth/lib/receiver/BleCharacterChangeReceiver;", "dispatcher", "Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final wu a(@NotNull fv dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            return new wu(dispatcher);
        }
    }

    /* compiled from: BleCharacterChangeReceiver.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<List<? extends String>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<? extends String> invoke() {
            return CollectionsKt__CollectionsJVMKt.listOf("action_character_changed");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wu(@NotNull fv dispatcher) {
        super(dispatcher);
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.b = LazyKt__LazyJVMKt.lazy(b.a);
    }

    public static final void g(bv listener, String str, UUID uuid, UUID uuid2, byte[] bArr) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.d(str, uuid, uuid2, bArr);
    }

    @Override // dc.vu
    @NotNull
    public List<String> b() {
        return (List) this.b.getValue();
    }

    @Override // dc.vu
    public boolean d(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("extra_mac");
        int i = Build.VERSION.SDK_INT;
        f(stringExtra, i >= 33 ? (UUID) intent.getSerializableExtra("extra_service_uuid", UUID.class) : (UUID) intent.getSerializableExtra("extra_service_uuid"), i >= 33 ? (UUID) intent.getSerializableExtra("extra_character_uuid", UUID.class) : (UUID) intent.getSerializableExtra("extra_character_uuid"), intent.getByteArrayExtra("extra_byte_value"));
        return true;
    }

    public final void f(final String str, final UUID uuid, final UUID uuid2, final byte[] bArr) {
        Iterator<av> it = c(bv.class).iterator();
        while (it.hasNext()) {
            final bv bvVar = (bv) it.next();
            se0.f(new Runnable() { // from class: dc.qu
                @Override // java.lang.Runnable
                public final void run() {
                    wu.g(bvVar, str, uuid, uuid2, bArr);
                }
            });
        }
    }
}
