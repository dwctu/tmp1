package com.component.dxtoy.core.commandcore.bean;

import dc.eb0;
import dc.la0;
import dc.ma0;
import dc.na0;
import dc.oa0;
import dc.pa0;
import dc.qd0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseToyCommandBean.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0016\u0018\u0000 L2\u00020\u0001:\u0001LB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\u0014J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\u0006\u0010 \u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0014J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0016J\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010%\u001a\u00020\u0014J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u0014J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140*H\u0002J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020,J\u0006\u0010.\u001a\u00020,J\u0006\u0010/\u001a\u00020,J\u0006\u00100\u001a\u00020,J\u000e\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u0014J\u0006\u00103\u001a\u00020,J\u0006\u00104\u001a\u00020,J\u0006\u00105\u001a\u00020,J\u0006\u00106\u001a\u00020,J\u0006\u00107\u001a\u00020,J\u0006\u00108\u001a\u00020,J\u0006\u00109\u001a\u00020,J\u0006\u0010:\u001a\u00020,J\u0006\u0010;\u001a\u00020,J\u0006\u0010<\u001a\u00020,J\u0006\u0010=\u001a\u00020,J\u0006\u0010>\u001a\u00020,J\u0006\u0010?\u001a\u00020,J\u0006\u0010@\u001a\u00020,J\u0006\u0010A\u001a\u00020,J\u0006\u0010B\u001a\u00020,J\u0006\u0010C\u001a\u00020,J\u0006\u0010D\u001a\u00020,J\u0006\u0010E\u001a\u00020,J\u0006\u0010F\u001a\u00020,J\u000e\u0010G\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tJ\u001f\u0010H\u001a\u00020,2\u0012\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010J\"\u00020\u0001¢\u0006\u0002\u0010KR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8@@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\f¨\u0006M"}, d2 = {"Lcom/component/dxtoy/core/commandcore/bean/BaseToyCommandBean;", "", "commandConstant", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "(Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;)V", "getCommandConstant", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "<set-?>", "", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType;", "sendTypeList", "getSendTypeList$core_release", "()Ljava/util/List;", "tagNumber", "", "getTagNumber$core_release", "()I", "setTagNumber$core_release", "(I)V", "tagStr", "", "getTagStr", "()Ljava/lang/String;", "setTagStr", "(Ljava/lang/String;)V", "valueList", "getValueList", "addSendType", "", "sendType", "getCommand", "getCommandByHeadValues", "getCommandName", "getCommandShortName", "getCommandWithTag", "getFormat", "getFormatSize", "getHeader", "getLevel", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$Level;", "getTagSuffix", "getValueLStringList", "", "isAA", "", "isAirIn", "isAirLevel", "isAirOut", "isBattery", "isContainTagSuffix", "command", "isDepth", "isDeviceType", "isFLVS", "isFSetSite", "isFingering", "isGetCap", "isLVS", "isMply", "isMultiply", "isPat", "isRotate", "isRotateFalse", "isRotateTrue", "isSetPat", "isSuck", "isThrusting", "isVibrate", "isVibrate1", "isVibrate2", "isVibrate3", "removeSendType", "setValues", "values", "", "([Ljava/lang/Object;)Z", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class BaseToyCommandBean {

    @NotNull
    private final la0 commandConstant;

    @NotNull
    private List<oa0> sendTypeList;
    private int tagNumber;

    @NotNull
    private String tagStr;

    @NotNull
    private final List<Object> valueList;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final oa0.d defaultSendPreOrPost = new oa0.d(false, 1, null);

    @NotNull
    private static final oa0.a defaultDiscard = new oa0.a(false, 1, null);

    @NotNull
    private static final oa0.e defaultTagTrue = new oa0.e(false, null, 3, null);

    @NotNull
    private static final oa0.b defaultLastSendSame = new oa0.b(1000);

    @NotNull
    private static final oa0.c defaultResend = new oa0.c(0, 1, null);

    /* compiled from: BaseToyCommandBean.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/component/dxtoy/core/commandcore/bean/BaseToyCommandBean$Companion;", "", "()V", "defaultDiscard", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Discard;", "getDefaultDiscard", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Discard;", "defaultLastSendSame", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$LastSendSame;", "getDefaultLastSendSame", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$LastSendSame;", "defaultResend", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Resend;", "getDefaultResend", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Resend;", "defaultSendPreOrPost", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$SendPreOrPost;", "getDefaultSendPreOrPost", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$SendPreOrPost;", "defaultTagTrue", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Tag;", "getDefaultTagTrue", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$SendType$Tag;", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final oa0.a getDefaultDiscard() {
            return BaseToyCommandBean.defaultDiscard;
        }

        @NotNull
        public final oa0.b getDefaultLastSendSame() {
            return BaseToyCommandBean.defaultLastSendSame;
        }

        @NotNull
        public final oa0.c getDefaultResend() {
            return BaseToyCommandBean.defaultResend;
        }

        @NotNull
        public final oa0.d getDefaultSendPreOrPost() {
            return BaseToyCommandBean.defaultSendPreOrPost;
        }

        @NotNull
        public final oa0.e getDefaultTagTrue() {
            return BaseToyCommandBean.defaultTagTrue;
        }
    }

    /* compiled from: BaseToyCommandBean.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[na0.values().length];
            iArr[na0.NORMAL.ordinal()] = 1;
            iArr[na0.CTRL_SINGLE.ordinal()] = 2;
            iArr[na0.CTRL_MULTI.ordinal()] = 3;
            iArr[na0.CTRL_LVS.ordinal()] = 4;
            iArr[na0.UNKNOWN.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BaseToyCommandBean(@NotNull la0 commandConstant) {
        Intrinsics.checkNotNullParameter(commandConstant, "commandConstant");
        this.commandConstant = commandConstant;
        this.tagStr = "";
        this.valueList = new ArrayList();
        this.sendTypeList = new ArrayList();
    }

    private final String getCommandWithTag() {
        String commandByHeadValues = getCommandByHeadValues();
        if (commandByHeadValues.length() == 0) {
            return commandByHeadValues;
        }
        if ((this.tagStr.length() == 0) || eb0.a.d(this, commandByHeadValues)) {
            return commandByHeadValues;
        }
        return StringsKt__StringsKt.removeSuffix(commandByHeadValues, (CharSequence) ";") + getTagSuffix();
    }

    private final List<String> getValueLStringList() {
        if (!(this.valueList.get(0) instanceof String)) {
            return new ArrayList();
        }
        List<Object> list = this.valueList;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Object obj : list) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) obj);
        }
        return arrayList;
    }

    public final void addSendType(@NotNull oa0 sendType) {
        Intrinsics.checkNotNullParameter(sendType, "sendType");
        removeSendType(sendType);
        getSendTypeList$core_release().add(sendType);
    }

    @NotNull
    public final String getCommand() {
        return getCommandWithTag();
    }

    @NotNull
    public String getCommandByHeadValues() {
        if (!this.valueList.isEmpty()) {
            if (isLVS() || isFLVS()) {
                String strC = getA().c();
                Charset charset = Charsets.UTF_8;
                byte[] bytes = strC.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                Object obj = this.valueList.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                byte[] bArrPlus = ArraysKt___ArraysJvmKt.plus(bytes, (byte[]) obj);
                byte[] bytes2 = ";".getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                String strA = qd0.a(ArraysKt___ArraysJvmKt.plus(bArrPlus, bytes2));
                Intrinsics.checkNotNullExpressionValue(strA, "bytes2HexString(byte)");
                return strA;
            }
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = getFormat();
                String[] strArr = (String[]) getValueLStringList().toArray(new String[0]);
                Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
                String str = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                return str;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Intrinsics.areEqual(getFormat(), "%s") ? getCommandName() : "";
    }

    @NotNull
    /* renamed from: getCommandConstant, reason: from getter */
    public la0 getA() {
        return this.commandConstant;
    }

    @NotNull
    public final String getCommandName() {
        return getA().getA();
    }

    @NotNull
    public final String getCommandShortName() {
        return getA().getB();
    }

    @NotNull
    public String getFormat() {
        return getA().getC();
    }

    public final int getFormatSize() {
        if (Intrinsics.areEqual(getA().getC(), "%s")) {
            return 0;
        }
        return StringsKt__StringsKt.split$default((CharSequence) getFormat(), new String[]{"%s"}, false, 0, 6, (Object) null).size() - 1;
    }

    @NotNull
    public final String getHeader() {
        return getA().c();
    }

    @NotNull
    public final na0 getLevel() {
        return getA().getD();
    }

    @NotNull
    public final List<oa0> getSendTypeList$core_release() {
        if (this.sendTypeList.isEmpty()) {
            this.sendTypeList.add(defaultSendPreOrPost);
            int i = WhenMappings.$EnumSwitchMapping$0[getA().getD().ordinal()];
            if (i == 1) {
                this.sendTypeList.add(defaultTagTrue);
            } else if (i == 2 || i == 3 || i == 4) {
                this.sendTypeList.add(defaultDiscard);
                this.sendTypeList.add(defaultLastSendSame);
            }
        }
        return this.sendTypeList;
    }

    /* renamed from: getTagNumber$core_release, reason: from getter */
    public final int getTagNumber() {
        return this.tagNumber;
    }

    @NotNull
    public final String getTagStr() {
        return this.tagStr;
    }

    @NotNull
    public final String getTagSuffix() {
        return ',' + this.tagStr + ';';
    }

    @NotNull
    public final List<Object> getValueList() {
        return this.valueList;
    }

    public final boolean isAA() {
        return Intrinsics.areEqual(getA(), pa0.a.a());
    }

    public final boolean isAirIn() {
        return Intrinsics.areEqual(getA(), ma0.a.e());
    }

    public final boolean isAirLevel() {
        return Intrinsics.areEqual(getA(), ma0.a.f());
    }

    public final boolean isAirOut() {
        return Intrinsics.areEqual(getA(), ma0.a.i());
    }

    public final boolean isBattery() {
        return Intrinsics.areEqual(getA(), pa0.a.f());
    }

    public final boolean isContainTagSuffix(@NotNull String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        return (this.tagStr.length() > 0) && StringsKt__StringsJVMKt.endsWith$default(command, getTagSuffix(), false, 2, null);
    }

    public final boolean isDepth() {
        return Intrinsics.areEqual(getA(), ma0.a.j());
    }

    public final boolean isDeviceType() {
        return Intrinsics.areEqual(getA(), pa0.a.k());
    }

    public final boolean isFLVS() {
        return Intrinsics.areEqual(getA(), ma0.a.k());
    }

    public final boolean isFSetSite() {
        return Intrinsics.areEqual(getA(), ma0.a.l());
    }

    public final boolean isFingering() {
        return Intrinsics.areEqual(getA(), ma0.a.m());
    }

    public final boolean isGetCap() {
        return Intrinsics.areEqual(getA(), ma0.a.n());
    }

    public final boolean isLVS() {
        return Intrinsics.areEqual(getA(), ma0.a.r());
    }

    public final boolean isMply() {
        return Intrinsics.areEqual(getA(), ma0.a.s());
    }

    public final boolean isMultiply() {
        return Intrinsics.areEqual(getA(), ma0.a.t());
    }

    public final boolean isPat() {
        return Intrinsics.areEqual(getA(), ma0.a.u());
    }

    public final boolean isRotate() {
        return Intrinsics.areEqual(getA(), ma0.a.v());
    }

    public final boolean isRotateFalse() {
        return Intrinsics.areEqual(getA(), ma0.a.x());
    }

    public final boolean isRotateTrue() {
        return Intrinsics.areEqual(getA(), ma0.a.y());
    }

    public final boolean isSetPat() {
        return Intrinsics.areEqual(getA(), ma0.a.z());
    }

    public final boolean isSuck() {
        return Intrinsics.areEqual(getA(), ma0.a.B());
    }

    public final boolean isThrusting() {
        return Intrinsics.areEqual(getA(), ma0.a.C());
    }

    public final boolean isVibrate() {
        return Intrinsics.areEqual(getA(), ma0.a.F());
    }

    public final boolean isVibrate1() {
        return Intrinsics.areEqual(getA(), ma0.a.G());
    }

    public final boolean isVibrate2() {
        return Intrinsics.areEqual(getA(), ma0.a.H());
    }

    public final boolean isVibrate3() {
        return Intrinsics.areEqual(getA(), ma0.a.I());
    }

    public final void removeSendType(@NotNull oa0 sendType) {
        Object next;
        Intrinsics.checkNotNullParameter(sendType, "sendType");
        Iterator<T> it = getSendTypeList$core_release().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((oa0) next).getClass(), sendType.getClass())) {
                    break;
                }
            }
        }
        oa0 oa0Var = (oa0) next;
        if (oa0Var != null) {
            getSendTypeList$core_release().remove(oa0Var);
        }
    }

    public final void setTagNumber$core_release(int i) {
        this.tagNumber = i;
    }

    public final void setTagStr(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagStr = str;
    }

    public final boolean setValues(@NotNull Object... values) {
        boolean z;
        Intrinsics.checkNotNullParameter(values, "values");
        this.valueList.clear();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            Object obj = values[i];
            if ((obj instanceof byte[]) || (obj instanceof String)) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return false;
        }
        CollectionsKt__MutableCollectionsKt.addAll(this.valueList, values);
        return true;
    }
}
