package com.huawei.hms.ml.scan;

import com.huawei.hms.scankit.util.b;

/* loaded from: classes3.dex */
public class HmsScanAnalyzerOptions {
    public final int mode;
    public final boolean photoMode;

    public static class Creator {
        private int type = 0;
        private boolean photoMode = false;

        public HmsScanAnalyzerOptions create() {
            return new HmsScanAnalyzerOptions(this.type, this.photoMode);
        }

        public Creator setHmsScanTypes(int i, int... iArr) {
            int iA = b.a(i);
            this.type = iA;
            if (iArr != null && iArr.length > 0) {
                this.type = b.b(iA);
                for (int i2 : iArr) {
                    this.type = b.b(i2) | this.type;
                }
            }
            return this;
        }

        public Creator setPhotoMode(boolean z) {
            this.photoMode = z;
            return this;
        }
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return super.hashCode();
    }

    private HmsScanAnalyzerOptions(int i, boolean z) {
        this.mode = i;
        this.photoMode = z;
    }
}
