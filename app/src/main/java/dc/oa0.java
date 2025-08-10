package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandEum.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType;", "", "()V", "Discard", "LastSendSame", "Resend", "SendPreOrPost", "Tag", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Discard;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$LastSendSame;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Resend;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$SendPreOrPost;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Tag;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class oa0 {

    /* compiled from: ToyCommandEum.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Discard;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType;", "isDisCard", "", "(Z)V", "()Z", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends oa0 {
        public final boolean a;

        public a() {
            this(false, 1, null);
        }

        public a(boolean z) {
            super(null);
            this.a = z;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getA() {
            return this.a;
        }

        public /* synthetic */ a(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }
    }

    /* compiled from: ToyCommandEum.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$LastSendSame;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType;", "time", "", "(J)V", "getTime", "()J", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends oa0 {
        public final long a;

        public b() {
            this(0L, 1, null);
        }

        public b(long j) {
            super(null);
            this.a = j;
        }

        /* renamed from: a, reason: from getter */
        public final long getA() {
            return this.a;
        }

        public /* synthetic */ b(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 5000L : j);
        }
    }

    /* compiled from: ToyCommandEum.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Resend;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType;", "resendLimit", "", "(I)V", "getResendLimit", "()I", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends oa0 {
        public final int a;

        public c() {
            this(0, 1, null);
        }

        public c(int i) {
            super(null);
            this.a = i;
        }

        /* renamed from: a, reason: from getter */
        public final int getA() {
            return this.a;
        }

        public /* synthetic */ c(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 3 : i);
        }
    }

    /* compiled from: ToyCommandEum.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$SendPreOrPost;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType;", "isPreOrPost", "", "(Z)V", "()Z", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends oa0 {
        public final boolean a;

        public d() {
            this(false, 1, null);
        }

        public d(boolean z) {
            super(null);
            this.a = z;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getA() {
            return this.a;
        }

        public /* synthetic */ d(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }
    }

    /* compiled from: ToyCommandEum.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Tag;", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType;", "isTag", "", "tag", "", "(ZLjava/lang/String;)V", "()Z", "getTag", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e extends oa0 {
        public final boolean a;

        @NotNull
        public final String b;

        public e() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z, @NotNull String tag) {
            super(null);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.a = z;
            this.b = tag;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getB() {
            return this.b;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getA() {
            return this.a;
        }

        public /* synthetic */ e(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? "" : str);
        }
    }

    public oa0() {
    }

    public /* synthetic */ oa0(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
