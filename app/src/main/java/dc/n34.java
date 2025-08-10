package dc;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: AbstractChannel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R&\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00028\u0000`\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/SendElementWithUndeliveredHandler;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/SendElement;", "pollResult", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "onUndeliveredElement", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;Lkotlin/jvm/functions/Function1;)V", DiscoverItems.Item.REMOVE_ACTION, "", "undeliveredElement", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class n34<E> extends m34<E> {

    @JvmField
    @NotNull
    public final Function1<E, Unit> f;

    /* JADX WARN: Multi-variable type inference failed */
    public n34(E e, @NotNull yy3<? super Unit> yy3Var, @NotNull Function1<? super E, Unit> function1) {
        super(e, yy3Var);
        this.f = function1;
    }

    @Override // dc.g64
    public boolean F() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!super.F()) {
            return false;
        }
        O();
        return true;
    }

    @Override // dc.k34
    public void O() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        n64.b(this.f, getD(), this.e.get$context());
    }
}
