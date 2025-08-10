package dc;

import com.lovense.wear.R;
import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyStrength;
import com.wear.bean.event.UpdateToyStrengthEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.MainActivity;
import com.wear.main.toy.newtoy.NewToyViewModel;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.vu1;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: SolaceProModelControl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0017\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u0002J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bJ0\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000fJ\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010 \u001a\u00020\tJ\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000fJ\u0006\u0010$\u001a\u00020\u000fJ\u001a\u0010%\u001a\u00020\u000f2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010'\u001a\u00020\u000fR\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/wear/main/toy/solacepro/SolaceProModelControl;", "", "()V", "toastInPositionModePages", "", "Ljava/lang/Class;", "toyModeMap", "", "", "Lcom/wear/main/toy/solacepro/SolaceProModel;", "bindListToys", "", "listToys", "Lcom/wear/bean/Toy;", "resetRecordHiddenTag", "", "clearVelvoModel", "getModel", MultipleAddresses.Address.ELEMENT, "getSettingMaxPosition", "", "updatedDeviceId", "getSettingMinPosition", "notifyVelvoMap", "removeModel", "saveSettingPositionRange", "toy", "strokeForModel", "minPos", "maxPos", "alsoSaveToNet", "setModel", "model", "switchModel", "toastIfInModePositionByMusic", "isStart", "toastIfInPositionMode", "toastIfInPositionModeByPage", "clz", "isControlPlaying", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class fk2 {

    @NotNull
    public static final fk2 a = new fk2();

    @NotNull
    public static final Map<String, ek2> b = new LinkedHashMap();

    @NotNull
    public static final List<Class<?>> c = new ArrayList();

    public final void a(@NotNull List<Toy> listToys, boolean z) {
        Intrinsics.checkNotNullParameter(listToys, "listToys");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listToys);
        b();
        f(arrayList);
        if (z) {
            jp3.h.a();
        }
    }

    public final void b() {
        b.clear();
    }

    @NotNull
    public final ek2 c(@Nullable String str) {
        ek2 ek2Var = b.get(str);
        if (ek2Var == null) {
            ek2Var = ek2.values()[eg3.f(bu1.a(), "velvoModel:" + str, ek2.POSITION.ordinal())];
            if (str != null) {
                a.i(str, ek2Var);
            }
        }
        return ek2Var;
    }

    public final int d(@Nullable String str) {
        StrengthBean.Data data;
        if (str == null || str.length() == 0) {
            return 100;
        }
        StrengthBean strengthBeanC = vu1.a.c(str);
        Integer strokeMax = (strengthBeanC == null || (data = strengthBeanC.getData()) == null) ? null : data.getStrokeMax();
        if (strokeMax == null) {
            return 100;
        }
        return strokeMax.intValue();
    }

    public final int e(@Nullable String str) {
        StrengthBean.Data data;
        if (str == null || str.length() == 0) {
            return 0;
        }
        StrengthBean strengthBeanC = vu1.a.c(str);
        Integer strokeMin = (strengthBeanC == null || (data = strengthBeanC.getData()) == null) ? null : data.getStrokeMin();
        if (strokeMin == null) {
            return 0;
        }
        return strokeMin.intValue();
    }

    public final void f(List<Toy> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList<Toy> arrayList = new ArrayList();
        for (Object obj : list) {
            Toy toy = (Toy) obj;
            if (toy.isBAToy() && !WearUtils.e1(toy.getAddress())) {
                arrayList.add(obj);
            }
        }
        for (Toy toy2 : arrayList) {
            fk2 fk2Var = a;
            String address = toy2.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "it.address");
            fk2Var.i(address, fk2Var.c(toy2.getAddress()));
        }
    }

    public final void g(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        eg3.m(bu1.a(), "velvoModel:" + address);
        b.remove(address);
    }

    public final boolean h(@Nullable Toy toy, @NotNull ek2 strokeForModel, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(strokeForModel, "strokeForModel");
        if (toy == null) {
            return false;
        }
        vu1.a aVar = vu1.a;
        StrengthBean strengthBeanC = aVar.c(toy.getAndUpdateDeviceId());
        if (strengthBeanC == null) {
            strengthBeanC = new StrengthBean(toy.getAndUpdateDeviceId());
            aVar.e(toy.getAndUpdateDeviceId(), strengthBeanC);
        }
        StrengthBean.Data data = strengthBeanC.getData();
        if (data == null) {
            data = new StrengthBean.Data();
            strengthBeanC.setData(data);
        }
        data.setStrokeMin(Integer.valueOf(i));
        data.setStrokeMax(Integer.valueOf(i2));
        String str = "strengthData" + data;
        ToyStrength toyStrengthFindToyStrength = DaoUtils.getToyStrengthDao().findToyStrength(zt3.k, toy.getAndUpdateDeviceId());
        if (toyStrengthFindToyStrength == null) {
            toyStrengthFindToyStrength = new ToyStrength(zt3.k, toy.getAndUpdateDeviceId());
        }
        toyStrengthFindToyStrength.setStrokeMin(Integer.valueOf(i));
        toyStrengthFindToyStrength.setStrokeMax(Integer.valueOf(i2));
        DaoUtils.getToyStrengthDao().updateOrAdd(toyStrengthFindToyStrength);
        if (z) {
            String str2 = zt3.k;
            if (!(str2 == null || str2.length() == 0)) {
                NewToyViewModel.h.a(strengthBeanC);
            }
        }
        dk2.a.j(toy, i, i2);
        EventBus.getDefault().post(new UpdateToyStrengthEvent(toy));
        return true;
    }

    public final void i(@NotNull String address, @NotNull ek2 model) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(model, "model");
        b.put(address, model);
        eg3.k(bu1.a(), "velvoModel:" + address, model.ordinal());
    }

    public final void j() {
        Iterator<Map.Entry<String, ek2>> it = b.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            ek2 ek2Var = b.get(key);
            ek2 ek2Var2 = ek2.SPEED;
            if (ek2Var == ek2Var2) {
                ek2Var2 = ek2.POSITION;
            }
            a.i(key, ek2Var2);
        }
        wi2.e().f("SolaceProModelControl-->switchModel");
        db2.A().P();
        h32.i().z();
    }

    public final void k(boolean z) {
        boolean z2;
        if (z) {
            z2 = MyApplication.H() instanceof MainActivity;
            if (z2 && NewMusicActivity.o) {
                return;
            }
            NewMusicActivity.o = true;
            l();
        }
        if (MyApplication.H() instanceof MainActivity) {
            NewMusicActivity.o = true;
        }
        if (z2) {
        }
        NewMusicActivity.o = true;
        l();
    }

    public final boolean l() {
        Object next;
        Iterator<T> it = pc1.a.P().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Toy toy = (Toy) next;
            if (toy.isBAToy() && a.c(toy.getAddress()) == ek2.POSITION) {
                break;
            }
        }
        if (((Toy) next) == null) {
            return false;
        }
        sg3.e(MyApplication.N(), R.string.tip_controlling_thrusting);
        return true;
    }

    public final boolean m(@NotNull Class<?> clz, boolean z) {
        Intrinsics.checkNotNullParameter(clz, "clz");
        boolean z2 = !z;
        List<Class<?>> list = c;
        if (!(list.contains(clz) ? z2 : true)) {
            return false;
        }
        boolean zL = l();
        if (zL) {
            list.add(clz);
        }
        return zL;
    }
}
