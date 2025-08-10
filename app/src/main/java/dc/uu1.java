package dc;

import com.wear.bean.Toy;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Toy.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e\u001a\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u001a\u0018\u0010\u000f\u001a\u00020\u000b2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e\u001a\u0018\u0010\u0010\u001a\u00020\u000b2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e\u001a\u0018\u0010\u0011\u001a\u00020\u000b2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e\u001a\u0010\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u001a\u0018\u0010\u0012\u001a\u00020\u000b2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"TOY_NAME_MINI_XMACHINE", "", "TOY_NAME_MINI_XMACHINE_WRAP", "TOY_NAME_XMACHINE", "TOY_TYPE_MINI_MXMACHINE1", "TOY_TYPE_MINI_MXMACHINE2", "getToyUINameSpecialForMiniXMachine", "toyName", "type", "", "isF01FromSymbol", "", "symbol", "symbols", "", "isMiniXMachineFromSymbol", "isTenaraFromSymbol", "isVelvoSymbol", "isXMachineFromSymbol", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class uu1 {
    @NotNull
    public static final String a(@Nullable String str, int i) {
        return str != null ? (StringsKt__StringsJVMKt.equals("Mini XMachine", str, true) || StringsKt__StringsJVMKt.equals("mXMachine", str, true) || StringsKt__StringsJVMKt.equals("Mini XMachine", str, true)) ? i != 1 ? i != 2 ? i != 3 ? str : "Mini\nXMachine" : Toy.TOY_XMACHINE : "Mini XMachine" : str : "";
    }

    public static final boolean b(@Nullable String str) {
        return c(CollectionsKt__CollectionsJVMKt.listOf(str));
    }

    public static final boolean c(@Nullable List<String> list) {
        return h(list) || e(list);
    }

    public static final boolean d(@Nullable String str) {
        if (str != null) {
            return e(CollectionsKt__CollectionsJVMKt.listOf(str));
        }
        return false;
    }

    public static final boolean e(@Nullable List<String> list) {
        if (list == null) {
            return false;
        }
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (CollectionsKt___CollectionsKt.contains(wu1.MINI_XMACHINE.getSymbols(), (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(@Nullable List<String> list) {
        if (list == null) {
            return false;
        }
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (CollectionsKt___CollectionsKt.contains(wu1.TENERA.getSymbols(), (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean g(@Nullable List<String> list) {
        if (list == null) {
            return false;
        }
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            if (str != null && wu1.SOLACE_PRO.getSymbols().contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean h(@Nullable List<String> list) {
        if (list == null) {
            return false;
        }
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (CollectionsKt___CollectionsKt.contains(wu1.XMACHINE.getSymbols(), (String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
