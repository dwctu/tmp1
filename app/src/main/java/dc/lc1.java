package dc;

import android.text.TextUtils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.util.WearUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: BtCommandCtrl.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/lovense/btservice/work/BtCommandCtrl;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class lc1 {

    @NotNull
    public static final a a = new a(null);

    @NotNull
    public static ArrayList<String> b;

    /* compiled from: BtCommandCtrl.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0014\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\nH\u0007J=\u0010\u0019\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001fJ \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J;\u0010 \u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0002\u0010\u001fJ(\u0010!\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ \u0010\"\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\nH\u0007J\"\u0010#\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\nH\u0007J,\u0010#\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0007J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0007J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0007J \u0010&\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0007J\u001a\u0010*\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\bH\u0007J \u0010*\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050-H\u0007J0\u0010*\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J \u0010.\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J.\u0010.\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0005002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J(\u0010.\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007JO\u00101\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0006\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dH\u0002¢\u0006\u0002\u00104J$\u00105\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\nH\u0007J(\u00106\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007JQ\u00106\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u00103\u001a\u00020\u001dH\u0007¢\u0006\u0002\u00104JH\u00106\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u00107\u001a\u00020\u001d2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001dJ&\u0010:\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010;\u001a\u00020\u0016H\u0007J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0005H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/lovense/btservice/work/BtCommandCtrl$Companion;", "", "()V", "lastMessageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "oldToyBean", "Lcom/wear/bean/ToyBean;", "getValue", "", "toyBeanMap", "", "motors", "", MultipleAddresses.Address.ELEMENT, "oldToyBeanMap", "getVelvoModelByToy", "Lcom/wear/main/toy/solacepro/SolaceProModel;", "toy", "Lcom/wear/bean/Toy;", "sendAllToyCommand", "", "opertion", "value", "sendAllToyCommands", "funs", "", "needTranslate", "", "needStrength", "([Ljava/lang/String;[Ljava/lang/String;ZZ)V", "sendAllToyCommandsByToyMode", "sendBaToySpeedCommands", "sendCommandStrengthSet", "sendCommandWithStrength", "strength", "c", "sendFuncCommand", "command", "flag", "message", "sendLvsCommand", "toyBean", "messageList", "Ljava/util/LinkedList;", "sendMultiCommand", "commands", "", "sendToSolacePro", "isRange100", "sendByToyMode", "(Lcom/wear/bean/Toy;[Ljava/lang/String;[Ljava/lang/String;ZZZ)V", "sendToyCommand", "sendToyCommands", "playAllMotors", "createdCommandsByPattern", "isSyncModel", "sendToyCommandsByLDR", "stopToysAction", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ek2 a(Toy toy) {
            String workMode = toy.getWorkMode();
            if (TextUtils.isEmpty(workMode)) {
                return fk2.a.c(toy.getAddress());
            }
            Intrinsics.checkNotNullExpressionValue(workMode, "workMode");
            return ek2.valueOf(workMode);
        }

        @JvmStatic
        public final void b(@Nullable String str, int i) {
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                o(it.next(), str, i);
            }
        }

        @JvmStatic
        public final void c(int i, boolean z, boolean z2) {
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                Toy toy = it.next();
                Intrinsics.checkNotNullExpressionValue(toy, "toy");
                p(toy, i, z, z2);
            }
        }

        public final void d(@Nullable String[] strArr, @Nullable String[] strArr2, boolean z, boolean z2) {
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                if (next != null) {
                    r(next, strArr, strArr2, z, z2, true);
                }
            }
        }

        public final void e(@Nullable Toy toy, int i, boolean z, boolean z2) {
            if (toy == null) {
                return;
            }
            fk2 fk2Var = fk2.a;
            dk2.a.h(toy.getAddress(), i, fk2Var.e(toy.getAndUpdateDeviceId()) / 5, fk2Var.d(toy.getAndUpdateDeviceId()) / 5, z, z2);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JvmStatic
        public final void f(@NotNull Toy toy, @NotNull String opertion, int i) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(opertion, "opertion");
            StrengthBean strengthBeanC = vu1.a.c(toy.getAndUpdateDeviceId());
            if (strengthBeanC == null) {
                o(toy, opertion, i);
            }
            StrengthBean.Data data = strengthBeanC.getData();
            int iHashCode = opertion.hashCode();
            if (iHashCode == 100) {
                if (opertion.equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                    Integer d = data.getD() == null ? 100 : data.getD();
                    Intrinsics.checkNotNullExpressionValue(d, "if (data.d == null) 100 else data.d");
                    h(toy, opertion, d.intValue(), i);
                    return;
                }
                return;
            }
            if (iHashCode == 102) {
                if (opertion.equals("f")) {
                    Integer f = data.getF() == null ? 100 : data.getF();
                    Intrinsics.checkNotNullExpressionValue(f, "if (data.f == null) 100 else data.f");
                    h(toy, opertion, f.intValue(), i);
                    return;
                }
                return;
            }
            if (iHashCode == 112) {
                if (opertion.equals("p")) {
                    Integer p = data.getP() == null ? 100 : data.getP();
                    Intrinsics.checkNotNullExpressionValue(p, "if (data.p == null) 100 else data.p");
                    h(toy, opertion, p.intValue(), i);
                    return;
                }
                return;
            }
            if (iHashCode == 118) {
                if (opertion.equals(PSOProgramService.VS_Key)) {
                    if (!toy.isSupportV1V2()) {
                        Integer v = data.getV() == null ? 100 : data.getV();
                        Intrinsics.checkNotNullExpressionValue(v, "if (data.v == null) 100 else data.v");
                        h(toy, opertion, v.intValue(), i);
                        return;
                    } else {
                        Integer v1 = data.getV1() == null ? 100 : data.getV1();
                        Intrinsics.checkNotNullExpressionValue(v1, "if (data.v1 == null) 100 else data.v1");
                        h(toy, "v1", v1.intValue(), i);
                        Integer v2 = data.getV2() == null ? 100 : data.getV2();
                        Intrinsics.checkNotNullExpressionValue(v2, "if (data.v2 == null) 100 else data.v2");
                        h(toy, "v2", v2.intValue(), i);
                        return;
                    }
                }
                return;
            }
            if (iHashCode == 111188) {
                if (opertion.equals("pos")) {
                    h(toy, opertion, 100, i);
                    return;
                }
                return;
            }
            if (iHashCode == 3707) {
                if (opertion.equals("v1")) {
                    Integer v12 = data.getV1() == null ? 100 : data.getV1();
                    Intrinsics.checkNotNullExpressionValue(v12, "if (data.v1 == null) 100 else data.v1");
                    h(toy, opertion, v12.intValue(), i);
                    return;
                }
                return;
            }
            if (iHashCode == 3708) {
                if (opertion.equals("v2")) {
                    Integer v22 = data.getV2() == null ? 100 : data.getV2();
                    Intrinsics.checkNotNullExpressionValue(v22, "if (data.v2 == null) 100 else data.v2");
                    h(toy, opertion, v22.intValue(), i);
                    return;
                }
                return;
            }
            switch (iHashCode) {
                case 114:
                    if (opertion.equals(StreamManagement.AckRequest.ELEMENT)) {
                        Integer r = data.getR() == null ? 100 : data.getR();
                        Intrinsics.checkNotNullExpressionValue(r, "if (data.r == null) 100 else data.r");
                        h(toy, opertion, r.intValue(), i);
                        break;
                    }
                    break;
                case 115:
                    if (opertion.equals("s")) {
                        Integer v3 = data.getV() == null ? 100 : data.getV();
                        Intrinsics.checkNotNullExpressionValue(v3, "if (data.v == null) 100 else data.v");
                        h(toy, opertion, v3.intValue(), i);
                        break;
                    }
                    break;
                case 116:
                    if (opertion.equals("t")) {
                        if (!toy.isBAToy()) {
                            if (!toy.isF01Toy()) {
                                Integer t = data.getT() == null ? 100 : data.getT();
                                Intrinsics.checkNotNullExpressionValue(t, "if (data.t == null) 100 else data.t");
                                h(toy, opertion, t.intValue(), i);
                                break;
                            } else {
                                Integer v4 = data.getV() == null ? 100 : data.getV();
                                Intrinsics.checkNotNullExpressionValue(v4, "if (data.v == null) 100 else data.v");
                                h(toy, opertion, v4.intValue(), i);
                                break;
                            }
                        } else {
                            e(toy, i, false, true);
                            break;
                        }
                    }
                    break;
            }
        }

        @JvmStatic
        public final void g(@Nullable Toy toy, @NotNull String opertion, int i) {
            Intrinsics.checkNotNullParameter(opertion, "opertion");
            if (toy != null) {
                f(toy, opertion, i);
                return;
            }
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                Toy t = it.next();
                Intrinsics.checkNotNullExpressionValue(t, "t");
                f(t, opertion, i);
            }
        }

        @JvmStatic
        public final void h(@Nullable Toy toy, @Nullable String str, int i, int i2) {
            if (toy == null) {
                return;
            }
            int iCeil = (int) Math.ceil((i / 100) * i2);
            String[] strArr = Toy.TOY_OPERATION.get(str);
            if (strArr == null || strArr.length < 2) {
                return;
            }
            String str2 = strArr[0];
            Intrinsics.checkNotNullExpressionValue(str2, "it[0]");
            String strReplace$default = StringsKt__StringsJVMKt.replace$default(str2, "#", "" + iCeil, false, 4, (Object) null);
            String str3 = "sendCommand: s强度=" + i + "  原指令=" + i2 + "   转换后=" + iCeil + "   最后指令=" + strReplace$default;
            if (!toy.isBAToy()) {
                pc1 pc1Var = pc1.a;
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                pc1Var.e(address, strReplace$default);
                return;
            }
            a aVar = lc1.a;
            ek2 ek2VarA = aVar.a(toy);
            if (TextUtils.equals("t", str) && ek2VarA == ek2.SPEED) {
                aVar.e(toy, iCeil, false, false);
            } else if (TextUtils.equals("pos", str) && ek2VarA == ek2.POSITION) {
                dk2.a.e(toy.getAddress(), iCeil, true);
            }
        }

        @JvmStatic
        public final void i(@NotNull String command, int i) {
            Intrinsics.checkNotNullParameter(command, "command");
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                String address = it.next().getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                k(address, command, i);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x010b A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v2 */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void j(@org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull java.lang.String r24) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.lc1.a.j(java.lang.String, java.lang.String):void");
        }

        @JvmStatic
        public final void k(@NotNull String address, @NotNull String command, int i) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(command, "command");
            pc1 pc1Var = pc1.a;
            Toy toyO = pc1Var.O(address);
            if (toyO != null) {
                if (i == 1 && toyO.isEAToy()) {
                    pc1Var.e(address, StringsKt__StringsJVMKt.replace$default(command, "Vibrate:", "Thrusting:", false, 4, (Object) null));
                    return;
                }
                if (!toyO.isSupportV1V2() && StringsKt__StringsKt.contains$default((CharSequence) command, (CharSequence) "vibrate1:", false, 2, (Object) null)) {
                    String address2 = toyO.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address2, "it.address");
                    pc1Var.e(address2, StringsKt__StringsJVMKt.replace$default(command, "vibrate1:", "Vibrate:", false, 4, (Object) null));
                } else {
                    a aVar = lc1.a;
                    String address3 = toyO.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address3, "it.address");
                    aVar.j(address3, command);
                }
            }
        }

        @JvmStatic
        public final void l(@Nullable String str, @NotNull List<String> list, boolean z, boolean z2) {
            int i;
            String str2;
            StrengthBean.Data data;
            int iIntValue;
            String[] strArr;
            StrengthBean strengthBeanC;
            List<String> messageList = list;
            String str3 = StreamManagement.AckRequest.ELEMENT;
            Intrinsics.checkNotNullParameter(messageList, "messageList");
            if (str == null) {
                return;
            }
            if (!messageList.contains("-2") && !messageList.contains("-1")) {
                lc1.b.clear();
                lc1.b.addAll(messageList);
            }
            StringBuilder sb = new StringBuilder();
            try {
                Toy toyQ = pc1.a.Q(str);
                if (toyQ == null) {
                    return;
                }
                int i2 = 0;
                if (list.size() > toyQ.getMotors().size()) {
                    messageList = messageList.subList(0, toyQ.getMotors().size());
                }
                sb.append("LVS:");
                ArrayList arrayList = new ArrayList(toyQ.getMotors());
                StrengthBean.Data data2 = (!z2 || (strengthBeanC = vu1.a.c(toyQ.getAndUpdateDeviceId())) == null) ? null : strengthBeanC.getData();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    int iCeil = Integer.parseInt(messageList.get(i3));
                    if (((List) arrayList.get(i3)).contains(str3) && iCeil == -2) {
                        toyQ.setDirection(!toyQ.isDirection());
                        if (toyQ.isDirection()) {
                            Object obj = lc1.b.get(i3);
                            Intrinsics.checkNotNullExpressionValue(obj, "lastMessageList[i]");
                            iCeil = Integer.parseInt((String) obj);
                        } else {
                            Object obj2 = lc1.b.get(i3);
                            Intrinsics.checkNotNullExpressionValue(obj2, "lastMessageList[i]");
                            i = Integer.parseInt((String) obj2);
                            iCeil = -i;
                        }
                    } else if (((List) arrayList.get(i3)).contains(str3) && iCeil != -1) {
                        if (toyQ.isDirection()) {
                            iCeil = Integer.parseInt(messageList.get(i3));
                        } else {
                            i = Integer.parseInt(messageList.get(i3));
                            iCeil = -i;
                        }
                    }
                    if (z && (strArr = Toy.TOY_OPERATION.get(((List) arrayList.get(i3)).get(i2))) != null && strArr.length >= 2) {
                        Intrinsics.checkNotNullExpressionValue(strArr[1], "it[1]");
                        iCeil = (int) Math.ceil(iCeil / (100.0d / Integer.parseInt(r13)));
                    }
                    if (data2 != null) {
                        int iCeil2 = -1;
                        for (String str4 : (List) arrayList.get(i3)) {
                            String toyFunction = Toy.getToyFunction(toyQ.getType());
                            Intrinsics.checkNotNullExpressionValue(toyFunction, "getToyFunction(toy.type)");
                            String str5 = str3;
                            if (StringsKt__StringsKt.contains$default((CharSequence) toyFunction, (CharSequence) str4, false, 2, (Object) null)) {
                                Field declaredField = StrengthBean.Data.class.getDeclaredField(str4);
                                declaredField.setAccessible(true);
                                if (declaredField.get(data2) == null) {
                                    iIntValue = 100;
                                } else {
                                    Object obj3 = declaredField.get(data2);
                                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                                    iIntValue = ((Integer) obj3).intValue();
                                }
                                String str6 = "fStrength====" + iIntValue;
                                iCeil2 = (int) Math.ceil((iIntValue / 100) * iCeil);
                                String str7 = "fValue====" + iCeil2;
                                data2 = data2;
                            }
                            str3 = str5;
                        }
                        str2 = str3;
                        data = data2;
                        sb.append(iCeil2);
                    } else {
                        str2 = str3;
                        data = data2;
                        sb.append(iCeil);
                    }
                    sb.append(i3 == messageList.size() - 1 ? ";" : ",");
                    i3++;
                    data2 = data;
                    str3 = str2;
                    i2 = 0;
                }
                String str8 = "stringBuilder====" + ((Object) sb);
                pc1 pc1Var = pc1.a;
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
                pc1Var.e(str, string);
            } catch (Exception unused) {
            }
        }

        @JvmStatic
        public final void m(@NotNull Toy toy, @NotNull List<String> commands, boolean z, boolean z2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            int i;
            String toyFunction;
            int iIntValue;
            String[] strArr;
            StrengthBean strengthBeanC;
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(commands, "commands");
            String multiplayOrder = toy.getMultiplayOrder();
            List<List<String>> motors = toy.getMotors();
            if (TextUtils.isEmpty(multiplayOrder) || motors == null || motors.isEmpty()) {
                return;
            }
            Object obj = null;
            StrengthBean.Data data = (!z2 || (strengthBeanC = vu1.a.c(toy.getAndUpdateDeviceId())) == null) ? null : strengthBeanC.getData();
            int size = motors.size();
            boolean z3 = false;
            int i2 = 0;
            while (i2 < size) {
                int iCeil = -1;
                for (String str : motors.get(i2)) {
                    try {
                        toyFunction = Toy.getToyFunction(toy.getType());
                        Intrinsics.checkNotNullExpressionValue(toyFunction, "getToyFunction(toy.type)");
                        Intrinsics.checkNotNull(str);
                    } catch (Exception e) {
                        e = e;
                        i = i2;
                    }
                    if (StringsKt__StringsKt.contains$default(toyFunction, str, z3, 2, obj)) {
                        iCeil = Integer.parseInt(commands.get(i2));
                        if (-2 == iCeil && TextUtils.equals(str, StreamManagement.AckRequest.ELEMENT)) {
                            rq1.d.f(toy.getAddress());
                        } else {
                            if (z && (strArr = Toy.TOY_OPERATION.get(str)) != null && strArr.length >= 2) {
                                String str2 = strArr[1];
                                Intrinsics.checkNotNullExpressionValue(str2, "it[1]");
                                iCeil /= 100 / Integer.parseInt(str2);
                            }
                            if (data != null) {
                                Field declaredField = StrengthBean.Data.class.getDeclaredField(str);
                                declaredField.setAccessible(true);
                                if (declaredField.get(data) == null) {
                                    iIntValue = 100;
                                } else {
                                    Object obj2 = declaredField.get(data);
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                                    iIntValue = ((Integer) obj2).intValue();
                                }
                                i = i2;
                                try {
                                    iCeil = (int) Math.ceil((iIntValue / 100) * iCeil);
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    i2 = i;
                                    obj = null;
                                    z3 = false;
                                }
                                i2 = i;
                                obj = null;
                                z3 = false;
                            }
                        }
                    }
                    obj = null;
                }
                int i3 = i2;
                commands.set(i3, String.valueOf(iCeil));
                i2 = i3 + 1;
                obj = null;
                z3 = false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(multiplayOrder);
            for (String str3 : commands) {
                sb.append(SignatureImpl.INNER_SEP);
                sb.append(str3);
            }
            sb.append(";");
            pc1 pc1Var = pc1.a;
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
            pc1Var.e(address, string);
        }

        public final void n(Toy toy, String[] strArr, String[] strArr2, boolean z, boolean z2, boolean z3) {
            if (toy == null || strArr == null || strArr2 == null) {
                return;
            }
            boolean z4 = du1.a(strArr, PSOProgramService.VS_Key) && du1.a(strArr, "t");
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if (z3) {
                    ek2 ek2VarA = a(toy);
                    if ((!StringsKt__StringsJVMKt.equals("t", str, true) && !StringsKt__StringsJVMKt.equals(PSOProgramService.VS_Key, str, true)) || ek2VarA != ek2.SPEED) {
                        if (StringsKt__StringsJVMKt.equals("pos", str, true) && ek2VarA == ek2.POSITION) {
                            dk2.a.e(toy.getAddress(), Integer.parseInt(strArr2[i]), true);
                            return;
                        }
                    } else if (!z4) {
                        e(toy, Integer.parseInt(strArr2[i]), z, z2);
                        return;
                    } else if (StringsKt__StringsJVMKt.equals("t", str, true)) {
                        e(toy, Integer.parseInt(strArr2[i]), z, z2);
                        return;
                    }
                } else if (StringsKt__StringsJVMKt.equals("t", str, true)) {
                    e(toy, Integer.parseInt(strArr2[i]), z, z2);
                    return;
                } else if (StringsKt__StringsJVMKt.equals("pos", str, true)) {
                    dk2.a.e(toy.getAddress(), Integer.parseInt(strArr2[i]), true);
                    return;
                }
            }
        }

        @JvmStatic
        public final void o(@Nullable Toy toy, @Nullable String str, int i) {
            if (toy != null && toy.isBAToy()) {
                if (TextUtils.equals("t", str)) {
                    e(toy, i, false, false);
                    return;
                } else {
                    if (TextUtils.equals("pos", str)) {
                        dk2.a.e(toy.getAddress(), i, true);
                        return;
                    }
                    return;
                }
            }
            String[] strArr = Toy.TOY_OPERATION.get(str);
            if (strArr == null || strArr.length < 2) {
                return;
            }
            String str2 = strArr[0];
            Intrinsics.checkNotNullExpressionValue(str2, "it[0]");
            String strReplace$default = StringsKt__StringsJVMKt.replace$default(str2, "#", "" + i, false, 4, (Object) null);
            if (toy == null || WearUtils.e1(toy.getAddress())) {
                pc1.a.f(strReplace$default);
                return;
            }
            pc1 pc1Var = pc1.a;
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            pc1Var.e(address, strReplace$default);
        }

        @JvmStatic
        public final void p(@NotNull Toy toy, int i, boolean z, boolean z2) {
            int i2;
            boolean z3;
            Intrinsics.checkNotNullParameter(toy, "toy");
            if (z) {
                i2 = i;
                z3 = z;
            } else {
                i2 = i * 5;
                z3 = true;
            }
            String func = Toy.getToyFunction(toy.getType());
            if (TextUtils.isEmpty(func)) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(func, "func");
            String[] strArr = (String[]) StringsKt__StringsKt.split$default((CharSequence) func, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (true ^ (strArr.length == 0)) {
                int length = strArr.length;
                String[] strArr2 = new String[length];
                for (int i3 = 0; i3 < length; i3++) {
                    strArr2[i3] = String.valueOf(i2);
                }
                r(toy, strArr, strArr2, z3, z2, false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:68:0x01b0  */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void q(@org.jetbrains.annotations.Nullable com.wear.bean.Toy r23, boolean r24, @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> r25, boolean r26, boolean r27, boolean r28, boolean r29) {
            /*
                Method dump skipped, instructions count: 474
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.lc1.a.q(com.wear.bean.Toy, boolean, java.util.List, boolean, boolean, boolean, boolean):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:118:0x0156 A[ADDED_TO_REGION, EDGE_INSN: B:118:0x0156->B:100:0x0156 BREAK  A[LOOP:1: B:46:0x0076->B:83:0x0110], REMOVE, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x010d A[ADDED_TO_REGION] */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void r(@org.jetbrains.annotations.Nullable com.wear.bean.Toy r17, @org.jetbrains.annotations.Nullable java.lang.String[] r18, @org.jetbrains.annotations.Nullable java.lang.String[] r19, boolean r20, boolean r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 376
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.lc1.a.r(com.wear.bean.Toy, java.lang.String[], java.lang.String[], boolean, boolean, boolean):void");
        }

        public final void t(@NotNull Toy toy, int i, boolean z, boolean z2) {
            int i2;
            boolean z3;
            Intrinsics.checkNotNullParameter(toy, "toy");
            if (z) {
                i2 = i;
                z3 = z;
            } else {
                i2 = i * 5;
                z3 = true;
            }
            String func = toy.isBAToy() ? "t" : Toy.getToyFunction(toy.getType());
            if (TextUtils.isEmpty(func)) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(func, "func");
            String[] strArr = (String[]) StringsKt__StringsKt.split$default((CharSequence) func, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (true ^ (strArr.length == 0)) {
                int length = strArr.length;
                String[] strArr2 = new String[length];
                for (int i3 = 0; i3 < length; i3++) {
                    strArr2[i3] = String.valueOf(i2);
                }
                r(toy, strArr, strArr2, z3, z2, false);
            }
        }

        @JvmStatic
        public final void u() {
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                String address = it.next().getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                v(address);
            }
        }

        @JvmStatic
        public final void v(@NotNull String address) {
            String[] strArr;
            Intrinsics.checkNotNullParameter(address, "address");
            String str = "stopToysAction: 地址=" + address;
            try {
                pc1 pc1Var = pc1.a;
                Toy toyQ = pc1Var.Q(address);
                if (toyQ != null) {
                    pc1Var.j(address);
                    if (toyQ.isBAToy()) {
                        pc1Var.e(address, "LVS:0,-1,-1;");
                        return;
                    }
                    if (!toyQ.isMultiplyInstruct()) {
                        String func = Toy.getToyFunction(toyQ.getType());
                        Intrinsics.checkNotNullExpressionValue(func, "func");
                        String[] strArr2 = (String[]) StringsKt__StringsKt.split$default((CharSequence) func, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                        for (String str2 : strArr2) {
                            Map<String, String[]> map = Toy.TOY_OPERATION;
                            if (map.containsKey(str2) && (strArr = map.get(str2)) != null) {
                                String str3 = strArr[0];
                                Intrinsics.checkNotNullExpressionValue(str3, "opDefind[0]");
                                pc1.a.e(address, StringsKt__StringsJVMKt.replace$default(str3, "#", "0", false, 4, (Object) null));
                            }
                        }
                        return;
                    }
                    String multiplayOrder = toyQ.getMultiplayOrder();
                    for (int i = 0; i < toyQ.getMotors().size(); i++) {
                        multiplayOrder = multiplayOrder + ":0";
                    }
                    String order = multiplayOrder + ';';
                    pc1 pc1Var2 = pc1.a;
                    Intrinsics.checkNotNullExpressionValue(order, "order");
                    pc1Var2.l(address, order);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        new ToyBean();
        b = new ArrayList<>();
    }
}
