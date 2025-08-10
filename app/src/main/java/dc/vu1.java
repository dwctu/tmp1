package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.wear.bean.StrengthBean;
import com.wear.bean.ToyStrength;
import com.wear.dao.DaoUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ToyStrengthUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/ext/ToyStrengthUtils;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class vu1 {

    @NotNull
    public static final a a = new a(null);

    @NotNull
    public static Map<String, StrengthBean> b = new LinkedHashMap();

    /* compiled from: ToyStrengthUtils.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\tH\u0007J&\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u001c\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/wear/ext/ToyStrengthUtils$Companion;", "", "()V", "TAG", "", "toyStrengths", "", "Lcom/wear/bean/StrengthBean;", "getMotorStrength", "", "toyAddress", "motorFun", "motorValue", "getToyStrength", "initToyStrengthConfig", "", "putToyStrength", "strengthBean", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        @JvmStatic
        public final int a(@Nullable String str, @Nullable String str2, int i) {
            StrengthBean strengthBeanC = c(str);
            Integer d = null;
            StrengthBean.Data data = strengthBeanC != null ? strengthBeanC.getData() : null;
            if (data == null) {
                return i;
            }
            if (str2 != null) {
                int iHashCode = str2.hashCode();
                if (iHashCode != 100) {
                    if (iHashCode != 102) {
                        if (iHashCode != 112) {
                            if (iHashCode != 118) {
                                switch (iHashCode) {
                                    case 114:
                                        if (str2.equals(StreamManagement.AckRequest.ELEMENT)) {
                                            d = data.getR();
                                            break;
                                        }
                                        break;
                                    case 115:
                                        if (str2.equals("s")) {
                                            d = data.getS();
                                            break;
                                        }
                                        break;
                                    case 116:
                                        if (str2.equals("t")) {
                                            d = data.getT();
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (iHashCode) {
                                            case 3707:
                                                if (str2.equals("v1")) {
                                                    d = data.getV1();
                                                    break;
                                                }
                                                break;
                                            case 3708:
                                                if (str2.equals("v2")) {
                                                    d = data.getV2();
                                                    break;
                                                }
                                                break;
                                            case 3709:
                                                if (str2.equals("v3")) {
                                                    d = data.getV3();
                                                    break;
                                                }
                                                break;
                                        }
                                }
                            } else if (str2.equals(PSOProgramService.VS_Key)) {
                                d = data.getV();
                            }
                        } else if (str2.equals("p")) {
                            d = data.getP();
                        }
                    } else if (str2.equals("f")) {
                        d = data.getF();
                    }
                } else if (str2.equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                    d = data.getD();
                }
            }
            return d != null ? (int) Math.ceil((d.intValue() / 100) * i) : i;
        }

        @JvmStatic
        @NotNull
        public final String b(@Nullable String str, @Nullable String str2, @NotNull String motorValue) {
            Intrinsics.checkNotNullParameter(motorValue, "motorValue");
            return String.valueOf(a(str, str2, Integer.parseInt(motorValue)));
        }

        @JvmStatic
        @Nullable
        public final StrengthBean c(@Nullable String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return (StrengthBean) vu1.b.get(str);
        }

        @JvmStatic
        public final void d() {
            xe3.a("ToyStrengthUtils", "initToyStrengthConfig");
            vu1.b.clear();
            List<ToyStrength> listFindAllStrength = DaoUtils.getToyStrengthDao().findAllStrength(zt3.k);
            if (listFindAllStrength == null || listFindAllStrength.isEmpty()) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ToyStrength toyStrength : listFindAllStrength) {
                StrengthBean strengthBean = new StrengthBean(toyStrength.getToyAddress());
                StrengthBean.Data data = new StrengthBean.Data();
                String vibrationStrength = toyStrength.getVibrationStrength();
                if (!(vibrationStrength == null || vibrationStrength.length() == 0)) {
                    String vibrationStrength2 = toyStrength.getVibrationStrength();
                    Intrinsics.checkNotNullExpressionValue(vibrationStrength2, "toyStrength.vibrationStrength");
                    data.setV(Integer.valueOf(Integer.parseInt(vibrationStrength2)));
                }
                String vibration1Strength = toyStrength.getVibration1Strength();
                if (!(vibration1Strength == null || vibration1Strength.length() == 0)) {
                    String vibration1Strength2 = toyStrength.getVibration1Strength();
                    Intrinsics.checkNotNullExpressionValue(vibration1Strength2, "toyStrength.vibration1Strength");
                    data.setV1(Integer.valueOf(Integer.parseInt(vibration1Strength2)));
                }
                String vibration2Strength = toyStrength.getVibration2Strength();
                if (!(vibration2Strength == null || vibration2Strength.length() == 0)) {
                    String vibration2Strength2 = toyStrength.getVibration2Strength();
                    Intrinsics.checkNotNullExpressionValue(vibration2Strength2, "toyStrength.vibration2Strength");
                    data.setV2(Integer.valueOf(Integer.parseInt(vibration2Strength2)));
                }
                String vibration3Strength = toyStrength.getVibration3Strength();
                if (!(vibration3Strength == null || vibration3Strength.length() == 0)) {
                    String vibration3Strength2 = toyStrength.getVibration3Strength();
                    Intrinsics.checkNotNullExpressionValue(vibration3Strength2, "toyStrength.vibration3Strength");
                    data.setV3(Integer.valueOf(Integer.parseInt(vibration3Strength2)));
                }
                String rotateStrength = toyStrength.getRotateStrength();
                if (!(rotateStrength == null || rotateStrength.length() == 0)) {
                    String rotateStrength2 = toyStrength.getRotateStrength();
                    Intrinsics.checkNotNullExpressionValue(rotateStrength2, "toyStrength.rotateStrength");
                    data.setR(Integer.valueOf(Integer.parseInt(rotateStrength2)));
                }
                String airStrength = toyStrength.getAirStrength();
                if (!(airStrength == null || airStrength.length() == 0)) {
                    String airStrength2 = toyStrength.getAirStrength();
                    Intrinsics.checkNotNullExpressionValue(airStrength2, "toyStrength.airStrength");
                    data.setP(Integer.valueOf(Integer.parseInt(airStrength2)));
                }
                String thrustingStrength = toyStrength.getThrustingStrength();
                if (!(thrustingStrength == null || thrustingStrength.length() == 0)) {
                    String thrustingStrength2 = toyStrength.getThrustingStrength();
                    Intrinsics.checkNotNullExpressionValue(thrustingStrength2, "toyStrength.thrustingStrength");
                    data.setT(Integer.valueOf(Integer.parseInt(thrustingStrength2)));
                }
                String suctionStrength = toyStrength.getSuctionStrength();
                if (!(suctionStrength == null || suctionStrength.length() == 0)) {
                    String suctionStrength2 = toyStrength.getSuctionStrength();
                    Intrinsics.checkNotNullExpressionValue(suctionStrength2, "toyStrength.suctionStrength");
                    data.setS(Integer.valueOf(Integer.parseInt(suctionStrength2)));
                }
                String fingeringStrength = toyStrength.getFingeringStrength();
                if (!(fingeringStrength == null || fingeringStrength.length() == 0)) {
                    String fingeringStrength2 = toyStrength.getFingeringStrength();
                    Intrinsics.checkNotNullExpressionValue(fingeringStrength2, "toyStrength.fingeringStrength");
                    data.setF(Integer.valueOf(Integer.parseInt(fingeringStrength2)));
                }
                String depthStrength = toyStrength.getDepthStrength();
                if (!(depthStrength == null || depthStrength.length() == 0)) {
                    String depthStrength2 = toyStrength.getDepthStrength();
                    Intrinsics.checkNotNullExpressionValue(depthStrength2, "toyStrength.depthStrength");
                    data.setD(Integer.valueOf(Integer.parseInt(depthStrength2)));
                }
                data.setStrokeMin(toyStrength.getStrokeMin());
                data.setStrokeMax(toyStrength.getStrokeMax());
                strengthBean.setData(data);
                String toyAddress = toyStrength.getToyAddress();
                Intrinsics.checkNotNullExpressionValue(toyAddress, "toyStrength.toyAddress");
                linkedHashMap.put(toyAddress, strengthBean);
            }
            vu1.b.putAll(linkedHashMap);
        }

        @JvmStatic
        public final void e(@Nullable String str, @Nullable StrengthBean strengthBean) {
            if ((str == null || str.length() == 0) || strengthBean == null) {
                return;
            }
            vu1.b.put(str, strengthBean);
        }
    }

    @JvmStatic
    public static final int b(@Nullable String str, @Nullable String str2, int i) {
        return a.a(str, str2, i);
    }

    @JvmStatic
    @NotNull
    public static final String c(@Nullable String str, @Nullable String str2, @NotNull String str3) {
        return a.b(str, str2, str3);
    }

    @JvmStatic
    @Nullable
    public static final StrengthBean d(@Nullable String str) {
        return a.c(str);
    }

    @JvmStatic
    public static final void e() {
        a.d();
    }

    @JvmStatic
    public static final void f(@Nullable String str, @Nullable StrengthBean strengthBean) {
        a.e(str, strengthBean);
    }
}
