package dc;

import com.component.dxtoy.business.longc.aapattern.bean.AAPatternItemBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CommandProcessor.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/main/toy/solacepro/pattern/CommandProcessor;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class hk2 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: CommandProcessor.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002¨\u0006\u001b"}, d2 = {"Lcom/wear/main/toy/solacepro/pattern/CommandProcessor$Companion;", "", "()V", "crc8", "", "data", "", "deriveBytes", FirebaseAnalytics.Param.INDEX, "", PSOProgramService.VS_Key, "generateCommand", "toy", "Lcom/wear/bean/Toy;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/component/dxtoy/business/longc/aapattern/bean/AAPatternItemBean;", "orderType", "Lcom/component/dxtoy/business/longc/data/AAEum$Type;", "generateCommandRange100", "generateElement", "generatePatternIntervalCmd", "cmdInterval", "generatePlayStatusCommand", "Lcom/component/dxtoy/business/longc/data/AAEum$PlayState;", "reverseBits", "value", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte a(byte[] bArr) {
            int iG = 0;
            for (byte b : bArr) {
                iG ^= hk2.a.g(b) >>> 24;
                for (int i = 0; i < 8; i++) {
                    int i2 = iG & 128;
                    iG <<= 1;
                    if (i2 != 0) {
                        iG ^= 177;
                    }
                }
            }
            return (byte) ((g(iG & 255) >>> 24) ^ 53);
        }

        public final byte[] b(int i, int i2) {
            return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) (((byte) (((i >> 16) & 3) << 6)) | ((byte) (i2 & 63)))};
        }

        @NotNull
        public final byte[] c(@NotNull Toy toy, @NotNull List<AAPatternItemBean> items, @NotNull k10 orderType) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(orderType, "orderType");
            ArrayList arrayList = new ArrayList();
            arrayList.add((byte) -86);
            arrayList.add(Byte.valueOf(orderType.getCode()));
            arrayList.add(Byte.valueOf((byte) (items.size() * 3)));
            fk2 fk2Var = fk2.a;
            int iE = fk2Var.e(toy.getDeviceId());
            int iD = fk2Var.d(toy.getDeviceId());
            for (AAPatternItemBean aAPatternItemBean : items) {
                arrayList.addAll(ArraysKt___ArraysKt.toList(hk2.a.b(aAPatternItemBean.getIndex(), pu1.a(aAPatternItemBean.getValue(), 0, 20, iE / 5, iD / 5))));
            }
            arrayList.add(Byte.valueOf(a(CollectionsKt___CollectionsKt.toByteArray(arrayList))));
            return CollectionsKt___CollectionsKt.toByteArray(arrayList);
        }

        @NotNull
        public final byte[] d(@NotNull Toy toy, @NotNull List<AAPatternItemBean> items, @NotNull k10 orderType) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(orderType, "orderType");
            ArrayList arrayList = new ArrayList();
            arrayList.add((byte) -86);
            arrayList.add(Byte.valueOf(orderType.getCode()));
            arrayList.add(Byte.valueOf((byte) (items.size() * 4)));
            fk2 fk2Var = fk2.a;
            int iE = fk2Var.e(toy.getDeviceId());
            int iD = fk2Var.d(toy.getDeviceId());
            for (AAPatternItemBean aAPatternItemBean : items) {
                arrayList.addAll(hk2.a.e(aAPatternItemBean.getIndex(), pu1.a(aAPatternItemBean.getValue(), 0, 100, iE, iD)));
            }
            arrayList.add(Byte.valueOf(a(CollectionsKt___CollectionsKt.toByteArray(arrayList))));
            return CollectionsKt___CollectionsKt.toByteArray(arrayList);
        }

        public final List<Byte> e(int i, int i2) {
            return CollectionsKt__CollectionsKt.mutableListOf(Byte.valueOf((byte) (i & 255)), Byte.valueOf((byte) ((i >> 8) & 255)), Byte.valueOf((byte) ((i >> 16) & 255)), Byte.valueOf((byte) i2));
        }

        @NotNull
        public final byte[] f(@NotNull i10 orderType) {
            Intrinsics.checkNotNullParameter(orderType, "orderType");
            ArrayList arrayList = new ArrayList();
            arrayList.add((byte) -86);
            arrayList.add((byte) -118);
            arrayList.add((byte) 1);
            arrayList.add(Byte.valueOf(orderType.getCode()));
            arrayList.add(Byte.valueOf(a(CollectionsKt___CollectionsKt.toByteArray(arrayList))));
            return CollectionsKt___CollectionsKt.toByteArray(arrayList);
        }

        public final int g(int i) {
            int i2 = (i << 16) | (i >>> 16);
            int i3 = ((i2 & 16711935) << 8) | (((-16711936) & i2) >>> 8);
            int i4 = ((i3 & 252645135) << 4) | (((-252645136) & i3) >>> 4);
            int i5 = ((i4 & 858993459) << 2) | (((-858993460) & i4) >>> 2);
            return ((i5 & 1431655765) << 1) | (((-1431655766) & i5) >>> 1);
        }
    }
}
