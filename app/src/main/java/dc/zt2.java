package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: LogFormatter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bj\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/log/LogFormatter;", "", "keyLength", "", "(I)V", "defaultKey", "", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "addContent", "key", "value", "log", "", "tag", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class zt2 {

    @NotNull
    public static final a d = new a(null);

    @NotNull
    public final StringBuilder a = new StringBuilder();

    @NotNull
    public final String b = "                                                                                                    ";
    public int c;

    /* compiled from: LogFormatter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/log/LogFormatter$Companion;", "", "()V", "setUp", "Lcom/wear/ui/chat/pancel/helper/log/LogFormatter;", "int", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ zt2 b(a aVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 50;
            }
            return aVar.a(i);
        }

        @NotNull
        public final zt2 a(int i) {
            return new zt2(i);
        }
    }

    public zt2(int i) {
        this.c = i;
    }

    public static /* synthetic */ zt2 b(zt2 zt2Var, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        zt2Var.a(str, str2);
        return zt2Var;
    }

    @NotNull
    public final zt2 a(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (key.length() == 0) {
            this.a.append(value + " \n");
        } else if (key.length() < this.c) {
            this.a.append(key + ((Object) this.b.subSequence(0, this.c - key.length())) + " = " + value + " \n");
        } else {
            this.a.append(key + " = " + value + " \n");
        }
        return this;
    }

    public final void c(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        String string = this.a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        au2.g(tag, string);
        StringsKt__StringBuilderJVMKt.clear(this.a);
    }
}
