package dc;

import com.wear.main.toy.EditToyNameActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyName.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/name/ToyName;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class yr1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyName.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/wear/component/dxtoy/command/name/ToyName$Companion;", "", "()V", "changeName", "", "mac", "", "value", "resetName", "sendCommandChangeName", MultipleAddresses.Address.ELEMENT, "name", "tag", "sendCommandRestName", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull String mac, @NotNull String value) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            if (mp1.a.b()) {
                p10.a.a(mac, value);
                return;
            }
            String changeTag = EditToyNameActivity.f;
            Intrinsics.checkNotNullExpressionValue(changeTag, "changeTag");
            c(mac, value, changeTag);
        }

        @JvmStatic
        public final void b(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                p10.a.b(mac);
                return;
            }
            String changeTag = EditToyNameActivity.f;
            Intrinsics.checkNotNullExpressionValue(changeTag, "changeTag");
            d(mac, changeTag);
        }

        public final void c(String str, String str2, String str3) {
            pc1.a.e(str, "CN:" + str2 + ',' + str3 + ';');
        }

        public final void d(String str, String str2) {
            pc1.a.e(str, "RstName," + str2 + ';');
        }
    }

    @JvmStatic
    public static final void a(@NotNull String str, @NotNull String str2) {
        a.a(str, str2);
    }

    @JvmStatic
    public static final void b(@NotNull String str) {
        a.b(str);
    }
}
