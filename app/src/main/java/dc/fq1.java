package dc;

import android.text.TextUtils;
import com.wear.bean.Setting;
import com.wear.dao.DaoUtils;
import com.wear.dao.SettingDao;
import com.wear.util.WearUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyBtSwitch.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/btswitch/ToyBtSwitch;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class fq1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyBtSwitch.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u000e"}, d2 = {"Lcom/wear/component/dxtoy/command/btswitch/ToyBtSwitch$Companion;", "", "()V", "getAutoSwitch", "", "mac", "", "setAutoSwitch", "turnOn1", "", "turnOn2", "updateToyAutoSwitch", MultipleAddresses.Address.ELEMENT, "message", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
                c00.a.d(mac);
            } else {
                pc1.a.e(mac, "GetAS;");
            }
        }

        @JvmStatic
        public final void b(@NotNull String mac, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                c00.a.e(mac, z, z2);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AutoSwith:");
            sb.append(z ? "On" : "Off");
            sb.append(':');
            sb.append(z2 ? "On" : "Off");
            sb.append(';');
            pc1.a.e(mac, sb.toString());
        }

        @JvmStatic
        public final void c(@NotNull String address, @Nullable String str) {
            Intrinsics.checkNotNullParameter(address, "address");
            if (str != null) {
                String[] strArr = (String[]) StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsJVMKt.replace$default(str, ";", "", false, 4, (Object) null), new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (strArr.length >= 3) {
                    Setting settingS = WearUtils.x.S();
                    settingS.setAutoSwithOff(address, Boolean.valueOf(TextUtils.equals("1", strArr[1])));
                    settingS.setAutoLastLevel(address, Boolean.valueOf(TextUtils.equals("1", strArr[2])));
                    DaoUtils.getSettingDao().update((SettingDao) settingS);
                }
            }
        }
    }

    static {
        d00.b.e(new ta0() { // from class: dc.eq1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                fq1.a((List) obj, str, str2, bArr, str3);
            }
        });
    }

    public static final void a(List list, String mac, String value, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        a.c(mac, value);
    }

    @JvmStatic
    public static final void b(@NotNull String str) {
        a.a(str);
    }

    @JvmStatic
    public static final void d(@NotNull String str, boolean z, boolean z2) {
        a.b(str, z, z2);
    }

    @JvmStatic
    public static final void e(@NotNull String str, @Nullable String str2) {
        a.c(str, str2);
    }
}
