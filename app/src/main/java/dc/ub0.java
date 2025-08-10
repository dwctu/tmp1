package dc;

import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyInfo+ToyType.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0017\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0018\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001e\u001a\u00020\u0001*\u00020\u0002¨\u0006\u001f"}, d2 = {"isAmbiToy", "", "Lcom/component/dxtoy/core/toy/ToyInfo;", "isC20Toy", "isCalorToy", "isDiamoToy", "isDolceToy", "isDomiToy", "isEdgeToy", "isExomoonToy", "isFerriToy", "isFlexerToy", "isGeminiToy", "isGravityToy", "isGushToy", "isHushToy", "isHyphyToy", "isLapisToy", "isLushToy", "isMaxToy", "isMiniXMachineToy", "isMissionToy", "isNoraToy", "isOsciToy", "isQA01Toy", "isRidgeToy", "isSolaceProToy", "isSolaceToy", "isTeneraToy", "isVulseToy", "isXMachineToy", "core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ub0 {
    public static final boolean a(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "w", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "ea", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "s", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean e(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "b", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "fs", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean g(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "a", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean h(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "o", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean i(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "qa", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean j(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "ba", true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean k(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), XHTMLText.H, true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean l(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), XHTMLText.Q, true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean m(@NotNull nb0 nb0Var) {
        List<String> symbol;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (symbol = toyConfigInfoBeanG.getSymbol()) == null) {
            return false;
        }
        if ((symbol instanceof Collection) && symbol.isEmpty()) {
            return false;
        }
        Iterator<T> it = symbol.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals((String) it.next(), "f", true)) {
                return true;
            }
        }
        return false;
    }
}
