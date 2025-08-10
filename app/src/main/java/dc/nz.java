package dc;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IHyttoAppDataEngine.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H&¨\u0006\r"}, d2 = {"Lcom/component/dxhyttoutils/lib/listener/IHyttoAppDataEngine;", "", "getAppAccountCode", "", "getAppVersion", "getAppVersionCode", "", "getDeviceIdIgnoreList", "", "getHyttoAppCode", "Lcom/component/dxhyttoutils/lib/data/HyttoEum$AppCode;", "getX", "getY", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface nz {

    /* compiled from: IHyttoAppDataEngine.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        @NotNull
        public static List<String> a(@NotNull nz nzVar) {
            Intrinsics.checkNotNullParameter(nzVar, "this");
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    @NotNull
    String a();

    @NotNull
    iz b();

    @NotNull
    List<String> c();

    @Nullable
    String getX();

    @Nullable
    String getY();
}
