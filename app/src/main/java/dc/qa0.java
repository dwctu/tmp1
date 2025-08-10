package dc;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandDispatcher.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u001a\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0005J\u001a\u0010\u0012\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0005R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/component/dxtoy/core/commandcore/dispatcher/ToyCommandDispatcher;", "", "()V", "handlerList", "", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "dispatchCommand", "", "mac", "", "command", "bytes", "", "sendCommand", "registerDispatch", "", ExifInterface.GPS_DIRECTION_TRUE, "handlers", "unregisterDispatch", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class qa0 {

    @NotNull
    public final List<sa0<?>> a = new ArrayList();

    public final boolean a(@NotNull String mac, @NotNull String command, @NotNull byte[] bytes, @NotNull String sendCommand) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            if (((sa0) it.next()).b(mac, command, bytes, sendCommand)) {
                return true;
            }
        }
        return false;
    }

    public final <T> void b(@NotNull sa0<T> handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        if (this.a.contains(handlers)) {
            return;
        }
        this.a.add(handlers);
    }
}
