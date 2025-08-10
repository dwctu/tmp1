package dc;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileDownloader.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/component/dxtoy/update/FileDownloader;", "", "()V", "downloadFile", "", "fileUrl", "", "filePath", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxtoy/update/DownloadListener;", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class mc0 {

    @NotNull
    public static final mc0 a = new mc0();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2 A[PHI: r1 r5 r12
  0x00b2: PHI (r1v5 java.io.FileOutputStream) = (r1v3 java.io.FileOutputStream), (r1v0 java.io.FileOutputStream), (r1v0 java.io.FileOutputStream) binds: [B:45:0x00ed, B:57:0x00b2, B:23:0x00ac] A[DONT_GENERATE, DONT_INLINE]
  0x00b2: PHI (r5v6 java.io.BufferedInputStream) = (r5v4 java.io.BufferedInputStream), (r5v10 java.io.BufferedInputStream), (r5v10 java.io.BufferedInputStream) binds: [B:45:0x00ed, B:57:0x00b2, B:23:0x00ac] A[DONT_GENERATE, DONT_INLINE]
  0x00b2: PHI (r12v7 'fileUrl' ??) = (r12v5 'fileUrl' ??), (r12v9 'fileUrl' ??), (r12v9 'fileUrl' ??) binds: [B:45:0x00ed, B:57:0x00b2, B:23:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(java.lang.String r12, dc.lc0 r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.mc0.b(java.lang.String, dc.lc0, java.lang.String):void");
    }

    public final void a(@NotNull final String fileUrl, @NotNull final String filePath, @NotNull final lc0 listener) {
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        se0.c().execute(new Runnable() { // from class: dc.hc0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                mc0.b(fileUrl, listener, filePath);
            }
        });
    }
}
