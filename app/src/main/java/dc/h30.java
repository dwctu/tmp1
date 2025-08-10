package dc;

import dc.dw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyRssi.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/component/dxtoy/business/toyinfo/rssi/ToyRssiResponse;", "", "mac", "", "(Ljava/lang/String;)V", "getMac", "()Ljava/lang/String;", SaslStreamElements.Response.ELEMENT, "Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "getResponse", "()Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class h30 {

    @NotNull
    public final String a;

    @NotNull
    public final dw b;

    /* compiled from: ToyRssi.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"com/component/dxtoy/business/toyinfo/rssi/ToyRssiResponse$response$1", "Lcom/component/dxbluetooth/lib/response/BleReadRssiResponse;", "onResponse", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "data", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements dw {
        public a() {
        }

        @Override // dc.qt
        public void b(@NotNull mt mtVar, @Nullable String str) {
            dw.a.a(this, mtVar, str);
        }

        @Override // dc.qt
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull mt code, @Nullable Integer num) {
            nb0 nb0VarE;
            Intrinsics.checkNotNullParameter(code, "code");
            if (code != mt.REQUEST_SUCCESS || (nb0VarE = yb0.e(h30.this.getA())) == null) {
                return;
            }
            h30 h30Var = h30.this;
            nb0VarE.f0(num != null ? num.intValue() : 0);
            g30.a.h(h30Var.getA(), nb0VarE.getB());
            wb0.a.a(new i30(h30Var.getA(), nb0VarE.getB()));
        }
    }

    public h30(@NotNull String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.a = mac;
        this.b = new a();
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getA() {
        return this.a;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final dw getB() {
        return this.b;
    }
}
