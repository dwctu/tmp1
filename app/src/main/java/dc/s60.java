package dc;

import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCommandCode+Multiply.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00020\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007B!\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00020\u0005\"\u00020\u0006¢\u0006\u0002\u0010\nJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/component/dxtoy/command/code/CmdMultiply;", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "mac", "", "values", "", "", "(Ljava/lang/String;[I)V", "commandConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "(Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;Ljava/lang/String;[I)V", "getCommandConstant", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "motorVS", "getMotorVS", "()[I", "checkMultiplyValues", "", "checkMultiplyValues$toy_release", "getFormat", "verifyValues", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class s60 extends b90 {

    @NotNull
    public final la0 f;

    @NotNull
    public final int[] g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s60(@NotNull la0 commandConstant, @NotNull String mac, @NotNull int... values) {
        super(commandConstant, mac, new int[0]);
        Intrinsics.checkNotNullParameter(commandConstant, "commandConstant");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f = commandConstant;
        this.g = values;
    }

    @Override // dc.b90
    public boolean g() {
        nb0 nb0VarC = c();
        if (!((nb0VarC == null || tb0.q(nb0VarC)) ? false : true)) {
            return h();
        }
        onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
        return false;
    }

    @Override // dc.b90, com.component.dxtoy.core.commandcore.bean.ToyCommandBean, com.component.dxtoy.core.commandcore.bean.BaseToyCommandBean
    @NotNull
    /* renamed from: getCommandConstant, reason: from getter */
    public la0 getF() {
        return this.f;
    }

    @Override // com.component.dxtoy.core.commandcore.bean.BaseToyCommandBean
    @NotNull
    public String getFormat() {
        String a = getF().getA();
        for (int i = 0; i < getValueList().size(); i++) {
            a = a + ":%s";
        }
        return a + ';';
    }

    public final boolean h() {
        ToyConfigInfoBean toyConfigInfoBeanG;
        List<Integer> mutableList = ArraysKt___ArraysKt.toMutableList(this.g);
        if (mutableList.isEmpty()) {
            onError(mt.ILLEGAL_ARGUMENT, getC() + " values is empty");
            return false;
        }
        nb0 nb0VarC = c();
        List<List<String>> motors = (nb0VarC == null || (toyConfigInfoBeanG = nb0VarC.g()) == null) ? null : toyConfigInfoBeanG.getMotors();
        if (motors == null || motors.isEmpty()) {
            onError(mt.ILLEGAL_ARGUMENT, "Toy not support " + getC() + " command");
            return false;
        }
        int size = motors.size();
        int size2 = mutableList.size();
        if (size2 > size) {
            mutableList = mutableList.subList(0, size);
        } else if (size2 < size) {
            int i = size - size2;
            for (int i2 = 0; i2 < i; i2++) {
                mutableList.add(-1);
            }
        }
        int i3 = 0;
        for (List<String> list : motors) {
            int i4 = i3 + 1;
            int iIntValue = mutableList.get(i3).intValue();
            if (list.contains("p")) {
                if (!qb0.PUMP.getValueRange().contains(iIntValue) && iIntValue != -1) {
                    onError(mt.ILLEGAL_ARGUMENT, "DXMultiply value over 0 to 3");
                    return false;
                }
            } else if (list.contains(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                if (!qb0.DEPTH.getValueRange().contains(iIntValue) && iIntValue != -1) {
                    onError(mt.ILLEGAL_ARGUMENT, "DXMultiply value over 0 to 20");
                    return false;
                }
            } else if (list.contains(PSOProgramService.VS_Key) && !qb0.VIBRATE.getValueRange().contains(iIntValue) && iIntValue != -1) {
                onError(mt.ILLEGAL_ARGUMENT, "DXMultiply value over 0 to 20");
                return false;
            }
            i3 = i4;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList, 10));
        Iterator<T> it = mutableList.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        setValues(Arrays.copyOf(strArr, strArr.length));
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s60(@NotNull String mac, @NotNull int... values) {
        this(ma0.a.t(), mac, Arrays.copyOf(values, values.length));
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(values, "values");
    }
}
