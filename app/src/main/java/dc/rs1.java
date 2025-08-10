package dc;

import com.wear.bean.ToyType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: NewToyTypeDaoImpl.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/wear/component/dxtoy/db/impl/NewToyTypeDaoImpl;", "Lcom/wear/component/dxtoy/db/interfaces/IToyTypeDao;", "()V", "add", "", "t", "Lcom/wear/bean/ToyType;", "clearTable", "findAll", "", "findToyType", MultipleAddresses.Address.ELEMENT, "", "isExistToyType", "", "totalNumber", "", DiscoverItems.Item.UPDATE_ACTION, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class rs1 implements vs1 {
    @Override // dc.vs1
    public void add(@NotNull ToyType t) {
        Intrinsics.checkNotNullParameter(t, "t");
    }

    @Override // dc.vs1
    public void clearTable() {
    }

    @Override // dc.vs1
    @Nullable
    public List<ToyType> findAll() {
        if (yb0.d().isEmpty()) {
            return null;
        }
        ConcurrentHashMap<String, nb0> concurrentHashMapD = yb0.d();
        ArrayList arrayList = new ArrayList(concurrentHashMapD.size());
        for (Map.Entry<String, nb0> entry : concurrentHashMapD.entrySet()) {
            ToyType toyType = new ToyType();
            toyType.setAddress(entry.getValue().getMac());
            toyType.setType(entry.getValue().getDeviceType());
            if (Intrinsics.areEqual(toyType.getType(), "domi") || Intrinsics.areEqual(toyType.getType(), "gemini")) {
                toyType.setAutoLightOn(Boolean.valueOf(entry.getValue().getIsLedOpen()));
                toyType.setaColor(entry.getValue().getLedColor());
            }
            arrayList.add(toyType);
        }
        return arrayList;
    }

    @Override // dc.vs1
    @Nullable
    public ToyType findToyType(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        nb0 nb0Var = yb0.d().get(address);
        if (nb0Var == null) {
            return null;
        }
        ToyType toyType = new ToyType();
        toyType.setAddress(address);
        toyType.setType(nb0Var.getDeviceType());
        toyType.setAutoLightOn(Boolean.valueOf(nb0Var.getIsLedOpen()));
        toyType.setaColor(nb0Var.getLedColor());
        return toyType;
    }

    @Override // dc.vs1
    public boolean isExistToyType(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return yb0.d().containsKey(address);
    }

    @Override // dc.vs1
    public int totalNumber() {
        return yb0.d().size();
    }

    @Override // dc.vs1
    public void update(@NotNull ToyType t) {
        Intrinsics.checkNotNullParameter(t, "t");
        nb0 nb0Var = yb0.d().get(t.getAddress());
        if (nb0Var != null) {
            Boolean autoLightOn = t.getAutoLightOn();
            Intrinsics.checkNotNullExpressionValue(autoLightOn, "t.autoLightOn");
            nb0Var.X(autoLightOn.booleanValue());
            nb0Var.W(t.getaColor());
            String address = t.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "t.address");
            yb0.j(address, nb0Var);
        }
    }
}
