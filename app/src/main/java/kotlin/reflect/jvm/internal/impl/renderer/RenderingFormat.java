package kotlin.reflect.jvm.internal.impl.renderer;

import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.util.StringUtils;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes4.dex */
public enum RenderingFormat {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return string;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(string, SimpleComparison.LESS_THAN_OPERATION, StringUtils.LT_ENCODE, false, 4, (Object) null), SimpleComparison.GREATER_THAN_OPERATION, StringUtils.GT_ENCODE, false, 4, (Object) null);
        }
    };

    /* synthetic */ RenderingFormat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String escape(@NotNull String str);
}
