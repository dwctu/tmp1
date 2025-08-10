package dc;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* compiled from: BaseBleReceiver.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00062\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0004J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/component/dxbluetooth/lib/receiver/BaseBleReceiver;", "", "mDispatcher", "Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;", "(Lcom/component/dxbluetooth/lib/receiver/listener/IReceiverDispatcher;)V", "actionList", "", "", "getActionList", "()Ljava/util/List;", "containsAction", "", AMPExtension.Action.ATTRIBUTE_NAME, "getListeners", "Lcom/component/dxbluetooth/lib/receiver/listener/BaseBleReceiverListener;", "clazz", "Ljava/lang/Class;", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class vu {

    @NotNull
    public fv a;

    public vu(@NotNull fv mDispatcher) {
        Intrinsics.checkNotNullParameter(mDispatcher, "mDispatcher");
        this.a = mDispatcher;
    }

    public final boolean a(@NotNull String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        List<String> listB = b();
        if (!(!listB.isEmpty()) || TextUtils.isEmpty(action)) {
            return false;
        }
        return listB.contains(action);
    }

    @NotNull
    public abstract List<String> b();

    @NotNull
    public final List<av> c(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        List<av> listA = this.a.a(clazz);
        if (listA != null) {
            return listA;
        }
        List<av> listEmptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(listEmptyList, "emptyList()");
        return listEmptyList;
    }

    public abstract boolean d(@NotNull Context context, @NotNull Intent intent);
}
