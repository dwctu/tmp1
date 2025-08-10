package com.component.dxtoy.core.toy.bean;

import dc.n04;
import dc.qb0;
import dc.qd0;
import dc.uy3;
import dc.wz3;
import dc.xz3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyLvsInfoBean.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020(2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001bH\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\"H\u0002J\b\u00100\u001a\u00020(H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0004R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00061"}, d2 = {"Lcom/component/dxtoy/core/toy/bean/ToyLvsInfoBean;", "", "data", "", "([B)V", "isSupportChangeName", "", "()Z", "setSupportChangeName", "(Z)V", "isSupportFeedback", "setSupportFeedback", "isSupportLVS", "setSupportLVS", "isSupportLed", "setSupportLed", "isSupportLongCmd", "setSupportLongCmd", "isSupportPinCode", "setSupportPinCode", "isSupportProgram", "setSupportProgram", "lvsData", "getLvsData", "()[B", "setLvsData", "motorsFunc", "", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "getMotorsFunc", "()Ljava/util/List;", "setMotorsFunc", "(Ljava/util/List;)V", "motorsNumb", "", "getMotorsNumb", "()I", "setMotorsNumb", "(I)V", "getLvsFunction", "", "byte", "", "(Ljava/lang/Byte;)V", "getLvsMotorFunction", "bytes", "isSupportedFunc", "value", "parseLvsData", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ToyLvsInfoBean {
    private boolean isSupportChangeName;
    private boolean isSupportFeedback;
    private boolean isSupportLVS;
    private boolean isSupportLed;
    private boolean isSupportLongCmd;
    private boolean isSupportPinCode;
    private boolean isSupportProgram;

    @NotNull
    private byte[] lvsData;

    @Nullable
    private List<? extends qb0> motorsFunc;
    private int motorsNumb;

    /* compiled from: ToyLvsInfoBean.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.component.dxtoy.core.toy.bean.ToyLvsInfoBean$1", f = "ToyLvsInfoBean.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.component.dxtoy.core.toy.bean.ToyLvsInfoBean$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ToyLvsInfoBean.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ToyLvsInfoBean.this.parseLvsData();
            return Unit.INSTANCE;
        }
    }

    public ToyLvsInfoBean(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.lvsData = new byte[0];
        this.lvsData = data;
        uy3.d(xz3.a(n04.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void getLvsFunction(Byte b) {
        if (b == null) {
            return;
        }
        byte bByteValue = b.byteValue();
        if (isSupportedFunc(bByteValue)) {
            this.isSupportProgram = true;
        }
        if (isSupportedFunc(bByteValue >> 1)) {
            this.isSupportFeedback = true;
        }
        if (isSupportedFunc(bByteValue >> 2)) {
            this.isSupportLongCmd = true;
        }
        if (isSupportedFunc(bByteValue >> 3)) {
            this.isSupportPinCode = true;
        }
        if (isSupportedFunc(bByteValue >> 4)) {
            this.isSupportChangeName = true;
        }
        if (isSupportedFunc(bByteValue >> 5)) {
            this.isSupportLed = true;
        }
    }

    private final void getLvsMotorFunction(List<Byte> bytes) {
        ArrayList arrayList = new ArrayList();
        if (bytes != null) {
            Iterator<T> it = bytes.iterator();
            while (it.hasNext()) {
                qb0 qb0VarA = qb0.INSTANCE.a(qd0.c(new byte[]{((Number) it.next()).byteValue()}));
                if (qb0VarA != null) {
                    arrayList.add(qb0VarA);
                }
            }
        }
        this.motorsFunc = arrayList;
    }

    private final boolean isSupportedFunc(int value) {
        return (value & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseLvsData() {
        byte[] bArr = this.lvsData;
        if (bArr.length < 11) {
            this.isSupportLVS = false;
            return;
        }
        this.isSupportLVS = StringsKt__StringsJVMKt.startsWith$default(ArraysKt___ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), "67658058", false, 2, null);
        getLvsFunction(ArraysKt___ArraysKt.getOrNull(this.lvsData, 4));
        Byte orNull = ArraysKt___ArraysKt.getOrNull(this.lvsData, 8);
        this.motorsNumb = orNull != null ? orNull.byteValue() : (byte) 0;
        getLvsMotorFunction(ArraysKt___ArraysKt.toList(this.lvsData).subList(9, this.lvsData.length - 1));
    }

    @NotNull
    public final byte[] getLvsData() {
        return this.lvsData;
    }

    @Nullable
    public final List<qb0> getMotorsFunc() {
        return this.motorsFunc;
    }

    public final int getMotorsNumb() {
        return this.motorsNumb;
    }

    /* renamed from: isSupportChangeName, reason: from getter */
    public final boolean getIsSupportChangeName() {
        return this.isSupportChangeName;
    }

    /* renamed from: isSupportFeedback, reason: from getter */
    public final boolean getIsSupportFeedback() {
        return this.isSupportFeedback;
    }

    /* renamed from: isSupportLVS, reason: from getter */
    public final boolean getIsSupportLVS() {
        return this.isSupportLVS;
    }

    /* renamed from: isSupportLed, reason: from getter */
    public final boolean getIsSupportLed() {
        return this.isSupportLed;
    }

    /* renamed from: isSupportLongCmd, reason: from getter */
    public final boolean getIsSupportLongCmd() {
        return this.isSupportLongCmd;
    }

    /* renamed from: isSupportPinCode, reason: from getter */
    public final boolean getIsSupportPinCode() {
        return this.isSupportPinCode;
    }

    /* renamed from: isSupportProgram, reason: from getter */
    public final boolean getIsSupportProgram() {
        return this.isSupportProgram;
    }

    public final void setLvsData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.lvsData = bArr;
    }

    public final void setMotorsFunc(@Nullable List<? extends qb0> list) {
        this.motorsFunc = list;
    }

    public final void setMotorsNumb(int i) {
        this.motorsNumb = i;
    }

    public final void setSupportChangeName(boolean z) {
        this.isSupportChangeName = z;
    }

    public final void setSupportFeedback(boolean z) {
        this.isSupportFeedback = z;
    }

    public final void setSupportLVS(boolean z) {
        this.isSupportLVS = z;
    }

    public final void setSupportLed(boolean z) {
        this.isSupportLed = z;
    }

    public final void setSupportLongCmd(boolean z) {
        this.isSupportLongCmd = z;
    }

    public final void setSupportPinCode(boolean z) {
        this.isSupportPinCode = z;
    }

    public final void setSupportProgram(boolean z) {
        this.isSupportProgram = z;
    }
}
