package dc;

import androidx.multidex.MultiDexExtractor;

/* compiled from: FileExtension.java */
/* loaded from: classes.dex */
public enum fb {
    JSON(".json"),
    ZIP(MultiDexExtractor.EXTRACTED_SUFFIX);

    public final String extension;

    fb(String str) {
        this.extension = str;
    }

    public static fb forFile(String str) {
        for (fb fbVar : values()) {
            if (str.endsWith(fbVar.extension)) {
                return fbVar;
            }
        }
        dd.c("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
