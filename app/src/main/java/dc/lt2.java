package dc;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: KeyboardHeightCompat.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/compat/KeyboardHeightCompat;", "", "()V", "getMinLimitHeight", "", "hasPhysicsKeyboard", "", "panelDefaultHeight", "defaultHeight", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class lt2 {

    @NotNull
    public static final lt2 a = new lt2();

    public final int a() {
        return b() ? 100 : 300;
    }

    public final boolean b() {
        String model;
        ke0.c().d();
        eu2 eu2VarB = fu2.a.b();
        if (!Intrinsics.areEqual(eu2VarB.getA(), "blackberry") || (model = eu2VarB.getModel()) == null) {
            return false;
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = model.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (lowerCase != null) {
            return StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "bbf100", false, 2, (Object) null);
        }
        return false;
    }
}
