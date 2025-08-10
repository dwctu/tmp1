package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: StringExt.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0004"}, d2 = {"countSubstrings", "", "", "substring", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class jq1 {
    public static final int a(@NotNull String str, @NotNull String substring) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(substring, "substring");
        if (!(str.length() == 0)) {
            if (!(substring.length() == 0)) {
                return SequencesKt___SequencesKt.count(Regex.findAll$default(new Regex(Regex.INSTANCE.escape(substring)), str, 0, 2, null));
            }
        }
        return 0;
    }
}
