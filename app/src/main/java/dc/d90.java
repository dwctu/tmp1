package dc;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StringCmdExt.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\"\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a2\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\u0001\u001a\"\u0010\t\u001a\u00020\n*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\u0001\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0001\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010\u0010\u001a\u00020\r*\u00020\u0001\u001a\u0014\u0010\u0011\u001a\u00020\r*\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010\u0013\u001a\u00020\r*\u00020\u0001\u001a\"\u0010\u0014\u001a\u00020\r*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\u0015\u001a\u00020\r*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\u0016\u001a\u00020\r*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\u0017\u001a\u00020\r*\u00020\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¨\u0006\u0018"}, d2 = {"removeHeadAndTag", "", "cmd", TtmlNode.TAG_HEAD, "tag", "getValue", "getValueList", "", "split", "getValueToInt", "", "getValueToIntList", "isER", "", "isHead", "prefix", "isOK", "isTag", "suffix", "isUnknown", "isValue0", "isValue1", "isValueFalse", "isValueTrue", "toy_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class d90 {
    @NotNull
    public static final String a(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.length() == 0 ? "" : n(str, str2, str3);
    }

    public static /* synthetic */ String b(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = null;
        }
        if ((i & 2) != 0) {
            str3 = null;
        }
        return a(str, str2, str3);
    }

    @NotNull
    public static final List<String> c(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String split) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(split, "split");
        String strA = a(str, str2, str3);
        return strA.length() == 0 ? CollectionsKt__CollectionsKt.emptyList() : StringsKt__StringsKt.split$default((CharSequence) strA, new String[]{split}, false, 0, 6, (Object) null);
    }

    public static /* synthetic */ List d(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = null;
        }
        if ((i & 2) != 0) {
            str3 = null;
        }
        if ((i & 4) != 0) {
            str4 = ",";
        }
        return c(str, str2, str3, str4);
    }

    public static final int e(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Integer.parseInt(a(str, str2, str3));
        } catch (Exception unused) {
            return -1;
        }
    }

    public static /* synthetic */ int f(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = null;
        }
        if ((i & 2) != 0) {
            str3 = null;
        }
        return e(str, str2, str3);
    }

    @NotNull
    public static final List<Integer> g(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String split) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(split, "split");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = c(str, str2, str3, split).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
            } catch (Exception unused) {
                arrayList.add(-1);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List h(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = null;
        }
        if ((i & 2) != 0) {
            str3 = null;
        }
        if ((i & 4) != 0) {
            str4 = ",";
        }
        return g(str, str2, str3, str4);
    }

    public static final boolean i(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!(str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                return StringsKt__StringsJVMKt.startsWith(str, str2, true);
            }
        }
        return false;
    }

    public static final boolean j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return false;
        }
        return StringsKt__StringsJVMKt.startsWith(str, "OK", true);
    }

    public static final boolean k(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z = true;
        if (!(str.length() == 0)) {
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (!z) {
                Pair<Boolean, String> pairF = eb0.a.f(str);
                boolean zBooleanValue = pairF.component1().booleanValue();
                String strComponent2 = pairF.component2();
                if (zBooleanValue) {
                    return Intrinsics.areEqual(strComponent2, str2);
                }
            }
        }
        return false;
    }

    public static final boolean l(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual(a(str, str2, str3), "1");
    }

    public static /* synthetic */ boolean m(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = null;
        }
        if ((i & 2) != 0) {
            str3 = null;
        }
        return l(str, str2, str3);
    }

    public static final String n(String str, String str2, String str3) {
        if (str2 != null && i(str, str2)) {
            str = str.substring(str2.length(), str.length());
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        if (str3 != null && k(str, str3)) {
            str = eb0.a.l(str, str3);
        }
        return StringsKt__StringsKt.removeSuffix(str, (CharSequence) ";");
    }
}
