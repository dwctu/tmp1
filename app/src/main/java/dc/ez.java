package dc;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UrlEncoderUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxhttp/utils/UrlEncoderUtils;", "", "()V", "Companion", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ez {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: UrlEncoderUtils.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lcom/component/dxhttp/utils/UrlEncoderUtils$Companion;", "", "()V", "hasUrlEncoded", "", "str", "", "isValidHexChar", "c", "", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(@NotNull String str) {
            int i;
            Intrinsics.checkNotNullParameter(str, "str");
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (str.charAt(i2) == '%' && (i = i2 + 2) < str.length()) {
                    return b(str.charAt(i3)) && b(str.charAt(i));
                }
                i2 = i3;
            }
            return false;
        }

        public final boolean b(char c) {
            if ('0' <= c && c < ':') {
                return true;
            }
            if ('a' <= c && c < 'g') {
                return true;
            }
            return 'A' <= c && c < 'G';
        }
    }
}
