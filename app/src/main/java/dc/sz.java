package dc;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.broadcom.bt.util.io.IOUtils;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HyttoFileUtils.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J(\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J \u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007JC\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\u0004\b\u0000\u0010\u00172\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001aJR\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u001cj\n\u0012\u0004\u0012\u0002H\u0017\u0018\u0001`\u001d\"\u0004\b\u0000\u0010\u00172\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u0019H\u0007J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0004H\u0002J2\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010$\u001a\u00020#2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/HyttoFileUtils;", "", "()V", "PATH_COMMON", "", "PATH_FILE_DATA", "getCacheDir", "fileDir", "accountCode", "getDataStr", "key", "path2", "getDirectory", "Ljava/io/File;", "context", "Landroid/content/Context;", "name", "getFileDir", "getMD5AccountCode", "getPathDir", "path", "initPath", "loadData", ExifInterface.GPS_DIRECTION_TRUE, "cls", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "loadDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "loadPathData", "maybeCreateDir", "", OrmLiteConfigUtil.RESOURCE_DIR_NAME, "saveData", "", "savePathData", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class sz {

    @NotNull
    public static final sz a = new sz();

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String a(@Nullable String str, @Nullable String str2) {
        return a.d(ge0.b(), str, str2);
    }

    public static /* synthetic */ String b(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return a(str, str2);
    }

    public final String c(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String strB = td0.b(str);
        Intrinsics.checkNotNullExpressionValue(strB, "encryptMD5ToString(accountCode)");
        return strB;
    }

    public final String d(String str, String str2, String str3) {
        String strStringPlus;
        String strC = c(str3);
        if (TextUtils.isEmpty(str)) {
            strStringPlus = ge0.l() + IOUtils.DIR_SEPARATOR_UNIX + gd0.b() + IOUtils.DIR_SEPARATOR_UNIX;
        } else {
            strStringPlus = Intrinsics.stringPlus(str, "/");
        }
        if (!(strC == null || strC.length() == 0)) {
            strStringPlus = strStringPlus + strC + IOUtils.DIR_SEPARATOR_UNIX;
        }
        if (!(str2 == null || str2.length() == 0)) {
            strStringPlus = strStringPlus + ((Object) str2) + IOUtils.DIR_SEPARATOR_UNIX;
        }
        e(strStringPlus);
        return strStringPlus;
    }

    public final void e(String str) {
        File parentFile = new File(Intrinsics.stringPlus(str, "aaa")).getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }
}
