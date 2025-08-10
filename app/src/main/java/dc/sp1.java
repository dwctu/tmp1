package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogFirmwareUpgrade.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/business/LogFirmwareUpgrade;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class sp1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: LogFirmwareUpgrade.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/business/LogFirmwareUpgrade$Companion;", "", "()V", "C0001", "", "C0002", "C0003", "C0004", "C0005", "C0006", "C0007", "C0008", "C0009", "logC0001", "", FirebaseAnalytics.Param.CONTENT, "logC0002", "logC0003", "logC0004", "logC0005", "logC0006", "logC0007", "logC0008", "logC0009", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@Nullable String str) {
            ye3.d("C0001", str);
        }

        @JvmStatic
        public final void b(@Nullable String str) {
            ye3.d("C0002", str);
        }

        @JvmStatic
        public final void c(@Nullable String str) {
            ye3.d("C0003", str);
        }

        @JvmStatic
        public final void d(@Nullable String str) {
            ye3.d("C0004", str);
        }

        @JvmStatic
        public final void e(@Nullable String str) {
            ye3.d("C0005", str);
        }

        @JvmStatic
        public final void f(@Nullable String str) {
            ye3.d("C0006", str);
        }

        @JvmStatic
        public final void g(@Nullable String str) {
            ye3.d("C0007", str);
        }

        @JvmStatic
        public final void h(@Nullable String str) {
            ye3.d("C0008", str);
        }

        @JvmStatic
        public final void i(@Nullable String str) {
            ye3.d("C0009", str);
        }
    }

    @JvmStatic
    public static final void a(@Nullable String str) {
        a.b(str);
    }

    @JvmStatic
    public static final void b(@Nullable String str) {
        a.c(str);
    }

    @JvmStatic
    public static final void c(@Nullable String str) {
        a.d(str);
    }

    @JvmStatic
    public static final void d(@Nullable String str) {
        a.e(str);
    }

    @JvmStatic
    public static final void e(@Nullable String str) {
        a.f(str);
    }

    @JvmStatic
    public static final void f(@Nullable String str) {
        a.g(str);
    }

    @JvmStatic
    public static final void g(@Nullable String str) {
        a.h(str);
    }

    @JvmStatic
    public static final void h(@Nullable String str) {
        a.i(str);
    }
}
