package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.broadcom.bt.util.io.FilenameUtils;
import com.component.dxtoy.core.toy.bean.FuncBean;
import com.component.dxtoy.core.toy.bean.NotSupport;
import com.component.dxtoy.core.toy.bean.ProgramBean;
import com.component.dxtoy.core.toy.bean.RangeBean;
import com.component.dxtoy.core.toy.bean.SupportLanPattern;
import com.component.dxtoy.core.toy.bean.SupportMultiply;
import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import com.component.dxtoy.core.toy.bean.ToyLvsInfoBean;
import com.component.dxtoy.core.toy.bean.TvBean;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyInfo+SupportFunction.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\t\u001a\u0012\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\t\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\t\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\t\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\u0010\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0011\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0012\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0013\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0014\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0015\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0016\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0017\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0018\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u0019\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u001a\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u001b\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u001c\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u001d\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u001e\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\u001f\u001a\u00020\u0006*\u00020\t\u001a\n\u0010 \u001a\u00020\u0006*\u00020\t\u001a\n\u0010!\u001a\u00020\u0006*\u00020\t\u001a\n\u0010\"\u001a\u00020\u0006*\u00020\t\u001a\n\u0010#\u001a\u00020\u0006*\u00020\t\u001a\n\u0010$\u001a\u00020\u0006*\u00020\t\u001a\n\u0010%\u001a\u00020\u0006*\u00020\t\u001a\n\u0010&\u001a\u00020\u0006*\u00020\t¨\u0006'"}, d2 = {"compareVersions", "", "version1", "", "version2", "isVersionInRange", "", TypedValues.AttributesType.S_TARGET, "getFullName", "Lcom/component/dxtoy/core/toy/ToyInfo;", "getLvsMotorsFunc", "", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "getMotorsNumb", "getMultiplyOrder", "getToyPeriodInt", "isSupportChangeName", "isSupportDepth", "isSupportFeedback", "isSupportFingering", "isSupportLED", "isSupportLVS", "isSupportLanApi", "isSupportLongCmd", "isSupportMotherboardLED", "isSupportMply", "isSupportMultiply", "isSupportPat", "isSupportPinCode", "isSupportPosition", "isSupportProgram", "isSupportPump", "isSupportRotate", "isSupportStrokeEnd", "isSupportStrokeStart", "isSupportSuck", "isSupportThrusting", "isSupportVibrate", "toyIsSupport", "core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class tb0 {
    public static final boolean A(@NotNull nb0 nb0Var) {
        List<NotSupport> notSupport;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG != null && (notSupport = toyConfigInfoBeanG.getNotSupport()) != null) {
            gz gzVar = gz.a;
            String strName = gzVar.c().b().name();
            if (strName.length() == 0) {
                return false;
            }
            String strA = gzVar.c().a();
            if (strA.length() == 0) {
                return false;
            }
            for (NotSupport notSupport2 : notSupport) {
                if (Intrinsics.areEqual(notSupport2.getAt(), strName) && Intrinsics.areEqual(notSupport2.getPf(), DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE)) {
                    String minv = notSupport2.getMinv();
                    if (minv == null) {
                        minv = "";
                    }
                    String maxv = notSupport2.getMaxv();
                    if (z(strA, minv, maxv != null ? maxv : "")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final int a(String str, String str2) {
        List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{FilenameUtils.EXTENSION_SEPARATOR}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
        }
        List listSplit$default2 = StringsKt__StringsKt.split$default((CharSequence) str2, new char[]{FilenameUtils.EXTENSION_SEPARATOR}, false, 0, 6, (Object) null);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default2, 10));
        Iterator it2 = listSplit$default2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
        }
        int iMax = Math.max(arrayList.size(), arrayList2.size());
        int i = 0;
        while (i < iMax) {
            int iIntValue = ((Number) ((i < 0 || i > CollectionsKt__CollectionsKt.getLastIndex(arrayList)) ? 0 : arrayList.get(i))).intValue();
            int iIntValue2 = ((Number) ((i < 0 || i > CollectionsKt__CollectionsKt.getLastIndex(arrayList2)) ? 0 : arrayList2.get(i))).intValue();
            if (iIntValue < iIntValue2) {
                return -1;
            }
            if (iIntValue > iIntValue2) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    @Nullable
    public static final String b(@NotNull nb0 nb0Var) {
        String fullName;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        return (toyConfigInfoBeanG == null || (fullName = toyConfigInfoBeanG.getFullName()) == null) ? nb0Var.e() : fullName;
    }

    @Nullable
    public static final List<qb0> c(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getMotorsFunc();
        }
        return null;
    }

    public static final int d(@NotNull nb0 nb0Var) {
        List<List<String>> motors;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getMotorsNumb();
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (motors = toyConfigInfoBeanG.getMotors()) == null) {
            return 0;
        }
        return motors.size();
    }

    @Nullable
    public static final String e(@NotNull nb0 nb0Var) {
        List<SupportMultiply> supportMultiply;
        Object next;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (supportMultiply = toyConfigInfoBeanG.getSupportMultiply()) == null) {
            return null;
        }
        Iterator<T> it = supportMultiply.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SupportMultiply supportMultiply2 = (SupportMultiply) next;
            int minv = supportMultiply2.getMinv();
            int maxv = supportMultiply2.getMaxv();
            int version = nb0Var.getVersion();
            boolean z = false;
            if (minv <= version && version <= maxv) {
                z = true;
            }
            if (z) {
                break;
            }
        }
        SupportMultiply supportMultiply3 = (SupportMultiply) next;
        if (supportMultiply3 != null) {
            return supportMultiply3.getOrder();
        }
        return null;
    }

    public static final int f(@NotNull nb0 nb0Var) {
        List<TvBean> tv;
        Object next;
        String v;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (tv = toyConfigInfoBeanG.getTv()) == null) {
            return 1;
        }
        Iterator<T> it = tv.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            TvBean tvBean = (TvBean) next;
            int minv = tvBean.getMinv();
            int maxv = tvBean.getMaxv();
            int version = nb0Var.getVersion();
            boolean z = false;
            if (minv <= version && version <= maxv) {
                z = true;
            }
            if (z) {
                break;
            }
        }
        TvBean tvBean2 = (TvBean) next;
        if (tvBean2 == null || (v = tvBean2.getV()) == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(v)) == null) {
            return 1;
        }
        return intOrNull.intValue();
    }

    public static final boolean g(@NotNull nb0 nb0Var) {
        List<RangeBean> changeName;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getIsSupportChangeName();
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (changeName = toyConfigInfoBeanG.getChangeName()) == null) {
            return false;
        }
        if ((changeName instanceof Collection) && changeName.isEmpty()) {
            return false;
        }
        for (RangeBean rangeBean : changeName) {
            int minv = rangeBean.getMinv();
            int maxv = rangeBean.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return true;
            }
        }
        return false;
    }

    public static final boolean h(@NotNull nb0 nb0Var) {
        FuncBean func;
        List<qb0> motorsFunc;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null && (motorsFunc = j.getMotorsFunc()) != null) {
            return motorsFunc.contains(qb0.DEPTH);
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (func = toyConfigInfoBeanG.getFunc()) == null) {
            return false;
        }
        return func.getD();
    }

    public static final boolean i(@NotNull nb0 nb0Var) {
        List<RangeBean> feedbackModeSupport;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getIsSupportFeedback();
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (feedbackModeSupport = toyConfigInfoBeanG.getFeedbackModeSupport()) == null) {
            return false;
        }
        if ((feedbackModeSupport instanceof Collection) && feedbackModeSupport.isEmpty()) {
            return false;
        }
        for (RangeBean rangeBean : feedbackModeSupport) {
            int minv = rangeBean.getMinv();
            int maxv = rangeBean.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return true;
            }
        }
        return false;
    }

    public static final boolean j(@NotNull nb0 nb0Var) {
        FuncBean func;
        List<qb0> motorsFunc;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null && (motorsFunc = j.getMotorsFunc()) != null) {
            return motorsFunc.contains(qb0.FINGERING);
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (func = toyConfigInfoBeanG.getFunc()) == null) {
            return false;
        }
        return func.getF();
    }

    public static final boolean k(@NotNull nb0 nb0Var) {
        List<RangeBean> supportLEDColor;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getIsSupportLed();
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (supportLEDColor = toyConfigInfoBeanG.getSupportLEDColor()) == null) {
            return false;
        }
        if ((supportLEDColor instanceof Collection) && supportLEDColor.isEmpty()) {
            return false;
        }
        for (RangeBean rangeBean : supportLEDColor) {
            int minv = rangeBean.getMinv();
            int maxv = rangeBean.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return true;
            }
        }
        return false;
    }

    public static final boolean l(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getIsSupportLVS();
        }
        return false;
    }

    public static final boolean m(@NotNull nb0 nb0Var) {
        List<SupportLanPattern> supportLanPattern;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (supportLanPattern = toyConfigInfoBeanG.getSupportLanPattern()) == null) {
            return false;
        }
        if ((supportLanPattern instanceof Collection) && supportLanPattern.isEmpty()) {
            return false;
        }
        for (SupportLanPattern supportLanPattern2 : supportLanPattern) {
            int minv = supportLanPattern2.getMinv();
            int maxv = supportLanPattern2.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return true;
            }
        }
        return false;
    }

    public static final boolean n(@NotNull nb0 nb0Var) {
        List<SupportLanPattern> supportLanPattern;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getIsSupportLongCmd();
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (supportLanPattern = toyConfigInfoBeanG.getSupportLanPattern()) == null) {
            return false;
        }
        if ((supportLanPattern instanceof Collection) && supportLanPattern.isEmpty()) {
            return false;
        }
        for (SupportLanPattern supportLanPattern2 : supportLanPattern) {
            int minv = supportLanPattern2.getMinv();
            int maxv = supportLanPattern2.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return true;
            }
        }
        return false;
    }

    public static final boolean o(@NotNull nb0 nb0Var) {
        List<RangeBean> supportMotherboradLEDColor;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (supportMotherboradLEDColor = toyConfigInfoBeanG.getSupportMotherboradLEDColor()) == null) {
            return false;
        }
        if ((supportMotherboradLEDColor instanceof Collection) && supportMotherboradLEDColor.isEmpty()) {
            return false;
        }
        for (RangeBean rangeBean : supportMotherboradLEDColor) {
            int minv = rangeBean.getMinv();
            int maxv = rangeBean.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return true;
            }
        }
        return false;
    }

    public static final boolean p(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        return StringsKt__StringsJVMKt.equals("Mply", e(nb0Var), true);
    }

    public static final boolean q(@NotNull nb0 nb0Var) {
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        return StringsKt__StringsJVMKt.equals("Multiply", e(nb0Var), true);
    }

    public static final boolean r(@NotNull nb0 nb0Var) {
        FuncBean func;
        List<qb0> motorsFunc;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null && (motorsFunc = j.getMotorsFunc()) != null) {
            return motorsFunc.contains(qb0.PAT);
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (func = toyConfigInfoBeanG.getFunc()) == null) {
            return false;
        }
        return func.getA();
    }

    public static final boolean s(@NotNull nb0 nb0Var) {
        List<RangeBean> pinCodeSupport;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getIsSupportPinCode();
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (pinCodeSupport = toyConfigInfoBeanG.getPinCodeSupport()) == null) {
            return false;
        }
        if ((pinCodeSupport instanceof Collection) && pinCodeSupport.isEmpty()) {
            return false;
        }
        for (RangeBean rangeBean : pinCodeSupport) {
            int minv = rangeBean.getMinv();
            int maxv = rangeBean.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return true;
            }
        }
        return false;
    }

    public static final boolean t(@NotNull nb0 nb0Var) {
        FuncBean func;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (func = toyConfigInfoBeanG.getFunc()) == null) {
            return false;
        }
        return func.getPos();
    }

    public static final boolean u(@NotNull nb0 nb0Var) {
        List<ProgramBean> program;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null) {
            return j.getIsSupportProgram();
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || !Intrinsics.areEqual(nb0Var.h(), toyConfigInfoBeanG.getType()) || (program = toyConfigInfoBeanG.getProgram()) == null) {
            return false;
        }
        if ((program instanceof Collection) && program.isEmpty()) {
            return false;
        }
        for (ProgramBean programBean : program) {
            int minv = programBean.getMinv();
            int maxv = programBean.getMaxv();
            int version = nb0Var.getVersion();
            if (minv <= version && version <= maxv) {
                return true;
            }
        }
        return false;
    }

    public static final boolean v(@NotNull nb0 nb0Var) {
        FuncBean func;
        List<qb0> motorsFunc;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null && (motorsFunc = j.getMotorsFunc()) != null) {
            return motorsFunc.contains(qb0.PUMP);
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (func = toyConfigInfoBeanG.getFunc()) == null) {
            return false;
        }
        return func.getP();
    }

    public static final boolean w(@NotNull nb0 nb0Var) {
        FuncBean func;
        List<qb0> motorsFunc;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null && (motorsFunc = j.getMotorsFunc()) != null) {
            return motorsFunc.contains(qb0.ROTATE);
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (func = toyConfigInfoBeanG.getFunc()) == null) {
            return false;
        }
        return func.getR();
    }

    public static final boolean x(@NotNull nb0 nb0Var) {
        FuncBean func;
        List<qb0> motorsFunc;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null && (motorsFunc = j.getMotorsFunc()) != null) {
            return motorsFunc.contains(qb0.SUCK);
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (func = toyConfigInfoBeanG.getFunc()) == null) {
            return false;
        }
        return func.getS();
    }

    public static final boolean y(@NotNull nb0 nb0Var) {
        FuncBean func;
        List<qb0> motorsFunc;
        Intrinsics.checkNotNullParameter(nb0Var, "<this>");
        ToyLvsInfoBean j = nb0Var.getJ();
        if (j != null && (motorsFunc = j.getMotorsFunc()) != null) {
            return motorsFunc.contains(qb0.THRUSTING);
        }
        ToyConfigInfoBean toyConfigInfoBeanG = nb0Var.g();
        if (toyConfigInfoBeanG == null || (func = toyConfigInfoBeanG.getFunc()) == null) {
            return false;
        }
        return func.getT();
    }

    public static final boolean z(String str, String str2, String str3) {
        int iA = a(str, str2);
        int iA2 = a(str, str3);
        return (iA >= 0 && iA2 <= 0) || (iA <= 0 && iA2 >= 0);
    }
}
