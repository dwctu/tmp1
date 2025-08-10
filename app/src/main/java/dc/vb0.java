package dc;

import androidx.exifinterface.media.ExifInterface;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: BaseMmkvUtil.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003J\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0003J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0003J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0003J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003J\u0016\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0003J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u001eJ\u001f\u0010\u001f\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020!2\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\"J/\u0010\u001f\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020!2\u0006\u0010\u0014\u001a\u00020\u00032\u000e\u0010#\u001a\n\u0012\u0004\u0012\u0002H \u0018\u00010$¢\u0006\u0002\u0010%J9\u0010\u001f\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020!2\u0006\u0010\u0014\u001a\u00020\u00032\u000e\u0010#\u001a\n\u0012\u0004\u0012\u0002H \u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u0001H ¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\u001a\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003J\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010*2\u0006\u0010\u0014\u001a\u00020\u0003J&\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010*2\u0006\u0010\u0014\u001a\u00020\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010*J<\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010*2\u0006\u0010\u0014\u001a\u00020\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010*2\u0014\u0010+\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030*\u0018\u00010$J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010-\u001a\u00020!J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0010J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0017J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0019J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u001bJ\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0005J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u001eJ\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003J\u001c\u0010,\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030*J\u000e\u0010.\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/component/dxtoy/core/utils/BaseMmkvUtil;", "", "key", "", "mode", "", "(Ljava/lang/String;I)V", "kv", "Lcom/tencent/mmkv/MMKV;", "getKv", "()Lcom/tencent/mmkv/MMKV;", "kv$delegate", "Lkotlin/Lazy;", "clear", "", "contains", "", "getAll", "", "getBoolean", "k", "defaultV", "getByte", "", "getDouble", "", "getFloat", "", "getInt", "getLong", "", "getParcelable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "(Ljava/lang/String;)Landroid/os/Parcelable;", "tClass", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "getString", "getStringSet", "", "clz", "put", PSOProgramService.VS_Key, DiscoverItems.Item.REMOVE_ACTION, "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class vb0 {

    @NotNull
    public final String a;
    public final int b;

    @NotNull
    public final Lazy c;

    /* compiled from: BaseMmkvUtil.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mmkv/MMKV;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<MMKV> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MMKV invoke() {
            return MMKV.z(vb0.this.a, vb0.this.b);
        }
    }

    public vb0(@NotNull String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a = key;
        this.b = i;
        this.c = LazyKt__LazyJVMKt.lazy(new a());
        de0.v(" rootDir = " + MMKV.u(ve0.a()), getClass());
    }

    public final boolean c(@NotNull String k) {
        Intrinsics.checkNotNullParameter(k, "k");
        return d(k, false);
    }

    public final boolean d(@NotNull String k, boolean z) {
        Intrinsics.checkNotNullParameter(k, "k");
        return f().c(k, z);
    }

    public final int e(@NotNull String k, int i) {
        Intrinsics.checkNotNullParameter(k, "k");
        return f().d(k, i);
    }

    public final MMKV f() {
        Object value = this.c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-kv>(...)");
        return (MMKV) value;
    }

    @NotNull
    public final String g(@NotNull String k) {
        Intrinsics.checkNotNullParameter(k, "k");
        String strH = h(k, "");
        return strH == null ? "" : strH;
    }

    @Nullable
    public final String h(@NotNull String k, @Nullable String str) {
        Intrinsics.checkNotNullParameter(k, "k");
        return f().g(k, str);
    }

    public final void i(@NotNull String k, int i) {
        Intrinsics.checkNotNullParameter(k, "k");
        f().n(k, i);
    }

    public final void j(@NotNull String k, @NotNull String v) {
        Intrinsics.checkNotNullParameter(k, "k");
        Intrinsics.checkNotNullParameter(v, "v");
        f().q(k, v);
    }

    public final void k(@NotNull String k, boolean z) {
        Intrinsics.checkNotNullParameter(k, "k");
        f().s(k, z);
    }

    public final void l(@NotNull String k) {
        Intrinsics.checkNotNullParameter(k, "k");
        f().remove(k);
    }

    public /* synthetic */ vb0(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 1 : i);
    }
}
