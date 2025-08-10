package dc;

import java.io.File;

/* compiled from: FileService.java */
/* loaded from: classes.dex */
public class uh {
    public boolean a(File file) {
        return file.exists();
    }

    public File b(String str) {
        return new File(str);
    }

    public long c(File file) {
        return file.length();
    }
}
