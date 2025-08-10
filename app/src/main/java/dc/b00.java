package dc;

import androidx.exifinterface.media.ExifInterface;
import dc.f90;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyApi.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/ToyApi;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class b00 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyApi.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u001d\u0010\u0015\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J%\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001f0\u001eH\u0096\u0001J\u001d\u0010\u001a\u001a\u00020\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001f0\u001eH\u0096\u0001J\u0017\u0010 \u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\"H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0010H\u0096\u0001J\u001d\u0010%\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0001¨\u0006&"}, d2 = {"Lcom/component/dxtoy/ToyApi$Companion;", "Lcom/component/dxtoy/core/bluetooth/listenter/IToyBtApi;", "Lcom/component/dxtoy/command/listener/IToyCommandManager;", "Lcom/component/dxtoy/core/api/listenter/IToySchedule;", "()V", "addScheduledTask", "", "task", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "interval", "", "cancelAll", "mac", "", "deviceScan", "isStart", "", "disconnect", "init", "appEngine", "Lcom/component/dxtoy/core/api/engine/IToyAppEngine;", "registerDispatcher", ExifInterface.GPS_DIRECTION_TRUE, "handler", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "removeScheduledTask", "sendCommand", "command", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "valueMap", "", "", "sendCommandList", "commandList", "", "setScanAllDeviceSwitch", "isOn", "unregisterDispatcher", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements e90 {
        public final /* synthetic */ f90.a a;
        public final /* synthetic */ l40 b;

        public a() {
            this.a = f90.a;
            this.b = l40.a;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            this.b.a(mac);
        }

        public void b(boolean z) {
            this.a.c(z);
        }

        public void c(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            this.a.d(mac);
        }

        public final void d(@NotNull g90 appEngine) {
            Intrinsics.checkNotNullParameter(appEngine, "appEngine");
            f90.a.e(appEngine);
        }

        public <T> void e(@NotNull sa0<T> handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.b.d(handler);
        }

        public void f(@NotNull b90 command) {
            Intrinsics.checkNotNullParameter(command, "command");
            this.b.e(command);
        }

        public void g(@NotNull String mac, @NotNull Map<String, Integer> valueMap) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(valueMap, "valueMap");
            this.b.f(mac, valueMap);
        }

        public void h(boolean z) {
            this.a.q(z);
        }
    }
}
