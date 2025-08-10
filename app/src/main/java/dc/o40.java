package dc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Function.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/component/dxtoy/command/code/CmdAA;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "type", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "(Ljava/lang/String;BLjava/util/List;)V", "getParams", "()Ljava/util/List;", "getType", "()B", "value", "getValue", "()Ljava/lang/String;", "value$delegate", "Lkotlin/Lazy;", "initValue", "verifyValues", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class o40 extends b90 {
    public final byte f;

    @NotNull
    public final List<byte[]> g;

    @NotNull
    public final Lazy h;

    /* compiled from: ToyCommandCode+Function.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<Byte, CharSequence> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @NotNull
        public final CharSequence a(byte b) {
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            return str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
            return a(b.byteValue());
        }
    }

    /* compiled from: ToyCommandCode+Function.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<String> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            return o40.this.j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o40(@NotNull String mac, byte b2, @NotNull List<byte[]> params) {
        super(pa0.a.a(), mac, new int[0]);
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f = b2;
        this.g = params;
        this.h = LazyKt__LazyJVMKt.lazy(new b());
        setLongCommand(true);
        f(CollectionsKt__CollectionsJVMKt.listOf(new IntRange(0, 497)));
    }

    @Override // dc.b90
    public boolean g() {
        if (!(i().length() == 0) && d().get(0).contains(i().length())) {
            setValues(i());
            return true;
        }
        onError(mt.ILLEGAL_ARGUMENT, getC() + " command is empty, or too long");
        return false;
    }

    @NotNull
    public final String i() {
        return (String) this.h.getValue();
    }

    public final String j() {
        byte[] bArrPlus = new byte[0];
        Iterator<T> it = this.g.iterator();
        while (it.hasNext()) {
            bArrPlus = ArraysKt___ArraysJvmKt.plus(bArrPlus, (byte[]) it.next());
        }
        int length = bArrPlus.length;
        byte[] bArrPlus2 = ArraysKt___ArraysJvmKt.plus(new byte[]{-86, this.f, (byte) length}, bArrPlus);
        byte[] bArrPlus3 = ArraysKt___ArraysJvmKt.plus(bArrPlus2, xc0.a.a(bArrPlus2));
        String strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(ArraysKt___ArraysKt.drop(bArrPlus3, 1), "", null, null, 0, null, a.a, 30, null);
        de0.l("CmdAA", "initValue___type: " + ((int) this.f) + " length: " + length + "  params " + this.g.size() + " valueByteArray: " + ArraysKt___ArraysKt.joinToString$default(bArrPlus3, (CharSequence) ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), strJoinToString$default);
        return strJoinToString$default;
    }
}
