package dc;

import android.content.Context;
import android.os.Bundle;
import com.wear.bean.DfuBean;
import com.wear.bean.Toy;
import com.wear.component.dxtoy.toy.update.ToyUpgradeActivity;
import com.wear.dao.DaoUtils;
import com.wear.main.toy.ToyDfuActivity;
import dc.lp1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyBusinessProxy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/ToyBusinessProxy;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class lp1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyBusinessProxy.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/wear/component/dxtoy/ToyBusinessProxy$Companion;", "", "()V", "CURRENT_USER_EMAIL", "", "checkNewToyNeedUpgrade", "", "toy", "Lcom/wear/bean/Toy;", "isToyNeedUpgrade", "", "startToyUpgradeActivity", "context", "Landroid/content/Context;", MultipleAddresses.Address.ELEMENT, "updateToyConfig", "oldEmail", "newEmail", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void b(Toy toy, boolean z) {
            Intrinsics.checkNotNullParameter(toy, "$toy");
            try {
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                toy.setUpdateDfu((DfuBean) xd0.d(xd0.j(kc0.i(address)), DfuBean.class));
                pp1.a.g(toy);
            } catch (Throwable th) {
                th.printStackTrace();
                toy.setGetDfuErrorTime(System.currentTimeMillis());
            }
        }

        public final void a(@NotNull final Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            if (toy.getUpdateDfu() == null) {
                Integer version = toy.getVersion();
                Intrinsics.checkNotNullExpressionValue(version, "toy.version");
                if (version.intValue() > 0) {
                    sp1.a.a(toy.getLogToyType());
                    if (System.currentTimeMillis() - toy.getGetDfuErrorTime() < 360000) {
                        return;
                    }
                    kc0.m(false);
                    String address = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                    kc0.f(address, new jc0() { // from class: dc.kp1
                        @Override // dc.jc0
                        public final void a(boolean z) {
                            lp1.a.b(toy, z);
                        }
                    });
                }
            }
        }

        public final boolean c(@NotNull Toy toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            DfuBean updateDfu = toy.getUpdateDfu();
            if (updateDfu != null) {
                return updateDfu.isHasUpdate();
            }
            return false;
        }

        public final void e(@NotNull Context context, @Nullable String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Bundle bundle = new Bundle();
            if (mp1.a.b()) {
                bundle.putString("dfu_toy_address_Id", str);
                pj3.g(context, ToyUpgradeActivity.class, bundle);
            } else {
                bundle.putString("dfu_toy_address_Id", str);
                pj3.g(context, ToyDfuActivity.class, bundle);
            }
        }

        public final void f(@NotNull String oldEmail, @NotNull String newEmail) {
            Intrinsics.checkNotNullParameter(oldEmail, "oldEmail");
            Intrinsics.checkNotNullParameter(newEmail, "newEmail");
            if (mp1.a.b()) {
                ps1.d.j("current_user_email", newEmail);
                return;
            }
            List<Toy> listFindByEmail = DaoUtils.getToyDao().findByEmail(oldEmail);
            for (Toy toy : listFindByEmail) {
                toy.setEmail(newEmail);
                String id = toy.getId();
                Intrinsics.checkNotNullExpressionValue(id, "toy.id");
                if (StringsKt__StringsJVMKt.endsWith$default(id, oldEmail, false, 2, null)) {
                    DaoUtils.getToyDao().delT(toy);
                    String id2 = toy.getId();
                    Intrinsics.checkNotNullExpressionValue(id2, "toy.id");
                    toy.setId(StringsKt__StringsJVMKt.replace$default(id2, oldEmail, newEmail, false, 4, (Object) null));
                    DaoUtils.getToyDao().updateOrAdd(toy);
                }
            }
            DaoUtils.getToyDao().update(listFindByEmail);
        }
    }
}
