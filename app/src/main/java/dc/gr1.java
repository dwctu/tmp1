package dc;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCollect.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/datacollect/ToyCollect;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class gr1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCollect.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/wear/component/dxtoy/command/datacollect/ToyCollect$Companion;", "", "()V", "sendCollect", "", "mac", "", "isCollect", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                m00.b.d(mac, z);
                return;
            }
            pc1 pc1Var = pc1.a;
            StringBuilder sb = new StringBuilder();
            sb.append("Collect:");
            sb.append(z ? "1" : "0");
            pc1Var.e(mac, sb.toString());
        }
    }

    static {
        l00.b.e(new ta0() { // from class: dc.fr1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                gr1.a((byte[]) obj, str, str2, bArr, str3);
            }
        });
    }

    public static final void a(byte[] bArr, String mac, String value, byte[] bytes, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        ArrayList arrayList = new ArrayList();
        for (byte b : bytes) {
            arrayList.add(Integer.valueOf(b & 255));
        }
        vi2.a.b(mac, arrayList);
    }
}
