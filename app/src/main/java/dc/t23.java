package dc;

import android.os.Bundle;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.lovense.wear.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: XRemoteVersionUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/ui/discover/xremote/utils/XRemoteVersionUtils;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class t23 {

    @NotNull
    public static final a a = new a(null);

    @NotNull
    public static String[] b = {"1.0", "1", "2"};

    /* compiled from: XRemoteVersionUtils.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005JZ\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005JZ\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/wear/ui/discover/xremote/utils/XRemoteVersionUtils$Companion;", "", "()V", "versionArr", "", "", "getVersionArr", "()[Ljava/lang/String;", "setVersionArr", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "checkVersion", "", "version", "checkXremoteParmas", "Landroid/os/Bundle;", "applicationUrl", RemoteConfigConstants.RequestFieldKey.APP_ID, RemoteConfigConstants.RequestFieldKey.APP_VERSION, "applicationName", "xremoteAllowDomainList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "applicationIconUrl", "getBundle", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return ArraysKt___ArraysKt.contains(d(), version);
        }

        @Nullable
        public final Bundle b(@NotNull String applicationUrl, @NotNull String appId, @NotNull String appVersion, @NotNull String version, @NotNull String applicationName, @Nullable ArrayList<String> arrayList, @Nullable String str) {
            Intrinsics.checkNotNullParameter(applicationUrl, "applicationUrl");
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(appVersion, "appVersion");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(applicationName, "applicationName");
            if (!(appId.length() == 0)) {
                if (!(appVersion.length() == 0)) {
                    if (!(version.length() == 0)) {
                        if (a(version)) {
                            return c(applicationUrl, appId, version, appVersion, applicationName, arrayList, str);
                        }
                        sg3.l(ah4.e(R.string.xremote_version_incorrect));
                        return null;
                    }
                }
            }
            sg3.l(ah4.e(R.string.common_service_error));
            return null;
        }

        public final Bundle c(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6) {
            Bundle bundle = new Bundle();
            bundle.putString(ImagesContract.URL, str + "?appId=" + str2 + "&version=" + str3 + "&appVersion=" + str4);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, str2);
            bundle.putString("applicationName", str5);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str4);
            bundle.putString("version", str3);
            bundle.putString("applicationIconUrl", str6);
            if (arrayList != null) {
                bundle.putStringArrayList("xremoteAllowDomainList", arrayList);
            }
            return bundle;
        }

        @NotNull
        public final String[] d() {
            return t23.b;
        }
    }
}
