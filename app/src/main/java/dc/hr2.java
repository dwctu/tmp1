package dc;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatMessageObservableData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/wear/ui/chat/ChatMessageObservableData;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "updateValue", "", "value", "(Ljava/lang/Object;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class hr2<T> {

    @NotNull
    public final t24<T> a;

    @NotNull
    public final t34<T> b;

    public hr2() {
        t24<T> t24VarB = w24.b(-2, null, null, 6, null);
        this.a = t24VarB;
        this.b = v34.s(t24VarB);
    }

    @NotNull
    public final t34<T> a() {
        return this.b;
    }

    public final void b(T t) {
        this.a.h(t);
    }
}
