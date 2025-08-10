package dc;

import androidx.core.os.EnvironmentCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.agora.rtc2.video.VideoCaptureFormat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.shim.packet.Header;

/* compiled from: ToyCommandConstant.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "", "name", "", "shortName", VideoCaptureFormat.keyFormat, FirebaseAnalytics.Param.LEVEL, "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$Level;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$Level;)V", "getFormat", "()Ljava/lang/String;", Header.ELEMENT, "getHeader", "header$delegate", "Lkotlin/Lazy;", "getLevel", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$Level;", "getName", "getShortName", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class la0 {

    @NotNull
    public static final b f = new b(null);

    @NotNull
    public static final Lazy<la0> g = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public final String a;

    @NotNull
    public final String b;

    @NotNull
    public final String c;

    @NotNull
    public final na0 d;

    @NotNull
    public final Lazy e;

    /* compiled from: ToyCommandConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<la0> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("", null, "%s", na0.UNKNOWN, 2, null);
        }
    }

    /* compiled from: ToyCommandConstant.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant$Companion;", "", "()V", "FORMAT_DEFAULT", "", EnvironmentCompat.MEDIA_UNKNOWN, "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "getUnknown", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "unknown$delegate", "Lkotlin/Lazy;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final la0 a() {
            return (la0) la0.g.getValue();
        }
    }

    /* compiled from: ToyCommandConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<String> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            return Intrinsics.areEqual(la0.this.getC(), "%s") ? StringsKt__StringsKt.removeSuffix(la0.this.getA(), (CharSequence) ";") : (String) StringsKt__StringsKt.split$default((CharSequence) la0.this.getC(), new String[]{"%s"}, false, 0, 6, (Object) null).get(0);
        }
    }

    public la0(@NotNull String name, @NotNull String shortName, @NotNull String format, @NotNull na0 level) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(level, "level");
        this.a = name;
        this.b = shortName;
        this.c = format;
        this.d = level;
        this.e = LazyKt__LazyJVMKt.lazy(new c());
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getC() {
        return this.c;
    }

    @NotNull
    public final String c() {
        return (String) this.e.getValue();
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final na0 getD() {
        return this.d;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getA() {
        return this.a;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getB() {
        return this.b;
    }

    public /* synthetic */ la0(String str, String str2, String str3, na0 na0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "%s" : str3, (i & 8) != 0 ? na0.NORMAL : na0Var);
    }
}
