package com.ProjectMelody.MelwareRises;

/* loaded from: classes.dex */
public class OBBData {
    public static final String AppType = "";
    public static final XAPKFile[] xAPKS = {new XAPKFile(true, "1", 42693150)};

    public static class XAPKFile {
        public final long mFileSize;
        public final String mFileVersion;
        public final boolean mIsMain;

        public XAPKFile(boolean z, String str, long j) {
            this.mIsMain = z;
            this.mFileVersion = str;
            this.mFileSize = j;
        }
    }
}
