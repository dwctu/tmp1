package dc;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.component.dxbluetooth.lib.service.BleService;
import com.sun.jna.Callback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleServiceBinder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000e0\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/component/dxbluetooth/lib/service/BleServiceBinder;", "", "()V", "bleService", "Lcom/component/dxbluetooth/lib/listener/IBleService;", "getBleService", "()Lcom/component/dxbluetooth/lib/listener/IBleService;", "setBleService", "(Lcom/component/dxbluetooth/lib/listener/IBleService;)V", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "serviceConnection", "Landroid/content/ServiceConnection;", "bindBleService", "", Callback.METHOD_NAME, "Lkotlin/Function1;", "bindServiceSync", "countDownBindService", "finishBindService", "waitBindService", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class pw {

    @Nullable
    public static volatile st b;

    @Nullable
    public static CountDownLatch c;

    @NotNull
    public static final pw a = new pw();

    @NotNull
    public static final ServiceConnection d = new a();

    /* compiled from: BleServiceBinder.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/component/dxbluetooth/lib/service/BleServiceBinder$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "className", "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "classname", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NotNull ComponentName className, @NotNull IBinder binder) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(binder, "binder");
            pw pwVar = pw.a;
            qw qwVar = qw.a;
            pwVar.j(qwVar);
            qwVar.d(((BleService.a) binder).getA());
            pwVar.g();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NotNull ComponentName classname) {
            Intrinsics.checkNotNullParameter(classname, "classname");
            pw.a.j(null);
        }
    }

    public static final void c(final Function1 callback) throws InterruptedException {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        final st stVarE = a.e();
        if (stVarE == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: dc.nw
            @Override // java.lang.Runnable
            public final void run() {
                pw.d(callback, stVarE);
            }
        });
    }

    public static final void d(Function1 callback, st stVar) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(stVar);
    }

    public final synchronized void b(@NotNull final Function1<? super st, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (b != null) {
            rw.a.a("bindBleService___已绑定");
            callback.invoke(b);
        } else {
            CountDownLatch countDownLatch = c;
            if (countDownLatch != null) {
                rw.a.a(Intrinsics.stringPlus("bindBleService___正在绑定: ", countDownLatch));
            } else {
                rw.a.a("bindBleService___开始绑定");
                new Thread(new Runnable() { // from class: dc.ow
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        pw.c(callback);
                    }
                }).start();
            }
        }
    }

    public final st e() throws InterruptedException {
        c = new CountDownLatch(1);
        if (ve0.a().bindService(new Intent(ve0.a(), (Class<?>) BleService.class), d, 1)) {
            k();
        } else {
            b = qw.a;
            g();
        }
        c = null;
        rw.a.a(Intrinsics.stringPlus("bindServiceSync___绑定结束: ", b));
        return b;
    }

    public final void f() {
        CountDownLatch countDownLatch = c;
        if (countDownLatch == null) {
            return;
        }
        countDownLatch.countDown();
        c = null;
    }

    public final void g() {
        f();
    }

    public final void j(@Nullable st stVar) {
        b = stVar;
    }

    public final void k() throws InterruptedException {
        try {
            CountDownLatch countDownLatch = c;
            if (countDownLatch == null) {
                return;
            }
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
