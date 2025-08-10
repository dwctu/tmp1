package dc;

import com.wear.bean.Toy;
import com.wear.bean.ToyType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyInit.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, d2 = {"toOldToy", "Lcom/wear/bean/Toy;", "Lcom/component/dxtoy/core/toy/ToyInfo;", "toToyType", "Lcom/wear/bean/ToyType;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class np1 {
    @Nullable
    public static final Toy a(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        String lowerCase = null;
        if (!nb0Var.getIsUIInMyToyList()) {
            return null;
        }
        Toy toy = new Toy();
        toy.setAddress(nb0Var.getMac());
        toy.setName(nb0Var.e());
        toy.setVersion(Integer.valueOf(nb0Var.getVersion()));
        String strH = nb0Var.h();
        if (strH != null) {
            lowerCase = strH.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        toy.setType(lowerCase);
        toy.setDeviceType(nb0Var.getDeviceType());
        toy.setIsSelect(Integer.valueOf(nb0Var.getIsSelect() ? 1 : 0));
        toy.setSimpleToy(Integer.valueOf(nb0Var.getIsVirtualToy() ? 1 : 0));
        toy.setFormApp(nb0Var.getFormApp());
        toy.setConnectApp(nb0Var.getOtherAppConnectState());
        toy.setUpdateTime(nb0Var.getUpdateTime());
        toy.setLedSetting(Integer.valueOf(nb0Var.getIsLedOpen() ? 1 : 0));
        toy.setUuid(nb0Var.getUuid());
        return toy;
    }

    @NotNull
    public static final ToyType b(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyType toyType = new ToyType();
        toyType.setAddress(nb0Var.getMac());
        toyType.setType(nb0Var.getDeviceType());
        if (Intrinsics.areEqual(nb0Var.h(), "domi") || Intrinsics.areEqual(nb0Var.h(), "gemini")) {
            toyType.setAutoLightOn(Boolean.valueOf(nb0Var.getIsLedOpen()));
            toyType.setaColor(nb0Var.getLedColor());
        }
        return toyType;
    }
}
