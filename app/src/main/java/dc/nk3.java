package dc;

import android.text.TextUtils;
import androidx.multidex.MultiDexExtractor;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.util.MyApplication;
import dc.nk3;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import net.lingala.zip4j.exception.ZipException;
import org.jetbrains.annotations.NotNull;

/* compiled from: VbZipUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/vibematevideo/VbZipUtils;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class nk3 {

    @NotNull
    public static final a a = new a(null);

    @NotNull
    public static String b = "";

    /* compiled from: VbZipUtils.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/vibematevideo/VbZipUtils$Companion;", "", "()V", "UN_ZIP_STORE_KEY", "", "unZipDir", "unZipFiles", "zipAssetsDir", "deleteDirection", "", "dir", "Ljava/io/File;", "getAssetsCopyOutDir", "getAssetsUnZipFile", "fileName", "getUnZipDir", "init", "", "unZip", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void h() {
            try {
                if (eg3.f(MyApplication.N(), "UN_ZIP_BY_VERSION_0", -1) == 404) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strB = nk3.a.b();
                new File(strB).mkdirs();
                ok3.a(MyApplication.N(), "vb/img_video_ad_res.zip", strB, null);
                File[] fileArrListFiles = new File(strB).listFiles();
                Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "assetsCopyOutDirFile.listFiles()");
                boolean z = true;
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "file.name");
                    if (StringsKt__StringsJVMKt.endsWith$default(name, MultiDexExtractor.EXTRACTED_SUFFIX, false, 2, null)) {
                        try {
                            pk3.a(file, "HYTTO_VM_000", nk3.a.d());
                        } catch (ZipException e) {
                            a aVar = nk3.a;
                            aVar.a(new File(aVar.d()));
                            String str = "zipException:" + e.getMessage();
                            z = false;
                        }
                        file.delete();
                    }
                }
                String str2 = "耗时:" + (System.currentTimeMillis() - jCurrentTimeMillis);
                if (z) {
                    eg3.i(MyApplication.N(), "UN_ZIP_BY_VERSION_0", 404);
                } else {
                    nk3.a.a(new File(strB));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String str3 = "e.message:" + e2.getMessage();
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
        }

        public final boolean a(File file) {
            if (file == null || !file.exists() || file.isFile()) {
                return false;
            }
            File[] fileArrListFiles = file.listFiles();
            Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "dir.listFiles()");
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    a(file2);
                }
            }
            file.delete();
            return true;
        }

        public final String b() {
            return MyApplication.N().getFilesDir().getAbsolutePath() + File.separator + "assets0";
        }

        @NotNull
        public final String c(@NotNull String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return d() + File.separator + fileName;
        }

        public final String d() {
            if (!TextUtils.isEmpty(nk3.b)) {
                return nk3.b;
            }
            nk3.b = MyApplication.N().getFilesDir().getAbsolutePath() + File.separator + "unZipFiles";
            return nk3.b;
        }

        @JvmStatic
        public final void e() {
            g();
        }

        public final void g() {
            se0.b().execute(new Runnable() { // from class: dc.ik3
                @Override // java.lang.Runnable
                public final void run() {
                    nk3.a.h();
                }
            });
        }
    }

    @JvmStatic
    public static final void c() {
        a.e();
    }
}
