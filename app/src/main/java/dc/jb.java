package dc;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.multidex.MultiDexExtractor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public class jb {

    @NonNull
    public final hb a;

    public jb(@NonNull hb hbVar) {
        this.a = hbVar;
    }

    public static String b(String str, fb fbVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fbVar.tempExtension() : fbVar.extension);
        return sb.toString();
    }

    @Nullable
    @WorkerThread
    public Pair<fb, InputStream> a(String str) {
        try {
            File fileC = c(str);
            if (fileC == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileC);
            fb fbVar = fileC.getAbsolutePath().endsWith(MultiDexExtractor.EXTRACTED_SUFFIX) ? fb.ZIP : fb.JSON;
            dd.a("Cache hit for " + str + " at " + fileC.getAbsolutePath());
            return new Pair<>(fbVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public final File c(String str) throws FileNotFoundException {
        File file = new File(d(), b(str, fb.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, fb.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public final File d() {
        File cacheDir = this.a.getCacheDir();
        if (cacheDir.isFile()) {
            cacheDir.delete();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public void e(String str, fb fbVar) {
        File file = new File(d(), b(str, fbVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        dd.a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        dd.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    public File f(String str, InputStream inputStream, fb fbVar) throws IOException {
        File file = new File(d(), b(str, fbVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}
