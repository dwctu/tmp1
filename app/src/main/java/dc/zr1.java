package dc;

import com.wear.bean.Toy;
import com.wear.main.toy.pin.ToyPinSettingActivity;
import dc.x10;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyPinCode.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/pincode/ToyPinCode;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class zr1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyPinCode.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/wear/component/dxtoy/command/pincode/ToyPinCode$Companion;", "", "()V", "getPinCode", "", "mac", "", "getPinSwitch", "setPinCode", "toy", "Lcom/wear/bean/Toy;", "password", "setPinSwitch", "turnOn", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                x10.a.b(mac);
                return;
            }
            pc1.a.e(mac, "GetPinS," + ToyPinSettingActivity.c + ';');
        }

        @JvmStatic
        public final void b(@NotNull Toy toy, @NotNull String password) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(password, "password");
            if (mp1.a.b()) {
                x10.a aVar = x10.a;
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                aVar.c(address, password);
                return;
            }
            String toyTypeKey = toy.getToyTypeKey();
            Intrinsics.checkNotNullExpressionValue(toyTypeKey, "toy.toyTypeKey");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = toyTypeKey.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (Intrinsics.areEqual(lowerCase, "o") && toy.getToyVersion() == 206) {
                pc1 pc1Var = pc1.a;
                String address2 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
                pc1Var.e(address2, "SetPinCode:" + password + ',' + ToyPinSettingActivity.f + ';');
                return;
            }
            pc1 pc1Var2 = pc1.a;
            String address3 = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address3, "toy.address");
            pc1Var2.e(address3, "SetPinC:" + password + ',' + ToyPinSettingActivity.f + ';');
        }

        @JvmStatic
        public final void c(@NotNull Toy toy, boolean z) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            if (mp1.a.b()) {
                x10.a aVar = x10.a;
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                aVar.d(address, z);
                return;
            }
            if (z) {
                String toyTypeKey = toy.getToyTypeKey();
                Intrinsics.checkNotNullExpressionValue(toyTypeKey, "toy.toyTypeKey");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String lowerCase = toyTypeKey.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(lowerCase, "o") && toy.getToyVersion() == 206) {
                    pc1 pc1Var = pc1.a;
                    String address2 = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
                    pc1Var.e(address2, "SetPinStatus:1," + ToyPinSettingActivity.e + ';');
                    return;
                }
                pc1 pc1Var2 = pc1.a;
                String address3 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address3, "toy.address");
                pc1Var2.e(address3, "SetPinS:1," + ToyPinSettingActivity.e + ';');
                return;
            }
            String toyTypeKey2 = toy.getToyTypeKey();
            Intrinsics.checkNotNullExpressionValue(toyTypeKey2, "toy.toyTypeKey");
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
            String lowerCase2 = toyTypeKey2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (Intrinsics.areEqual(lowerCase2, "o") && toy.getToyVersion() == 206) {
                pc1 pc1Var3 = pc1.a;
                String address4 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address4, "toy.address");
                pc1Var3.e(address4, "SetPinStatus:0," + ToyPinSettingActivity.d + ';');
                return;
            }
            pc1 pc1Var4 = pc1.a;
            String address5 = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address5, "toy.address");
            pc1Var4.e(address5, "SetPinS:0," + ToyPinSettingActivity.d + ';');
        }
    }

    @JvmStatic
    public static final void a(@NotNull String str) {
        a.a(str);
    }

    @JvmStatic
    public static final void b(@NotNull Toy toy, @NotNull String str) {
        a.b(toy, str);
    }

    @JvmStatic
    public static final void c(@NotNull Toy toy, boolean z) {
        a.c(toy, z);
    }
}
