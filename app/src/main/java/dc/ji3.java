package dc;

import io.agora.rtc2.Constants;

/* compiled from: Rotation.java */
/* loaded from: classes4.dex */
public enum ji3 {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    /* compiled from: Rotation.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ji3.values().length];
            a = iArr;
            try {
                iArr[ji3.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ji3.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ji3.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ji3.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static ji3 fromInt(int i) {
        if (i == 0) {
            return NORMAL;
        }
        if (i == 90) {
            return ROTATION_90;
        }
        if (i == 180) {
            return ROTATION_180;
        }
        if (i == 270) {
            return ROTATION_270;
        }
        if (i == 360) {
            return NORMAL;
        }
        throw new IllegalStateException(i + " is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
    }

    public int asInt() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 90;
        }
        if (i == 3) {
            return 180;
        }
        if (i == 4) {
            return Constants.VIDEO_ORIENTATION_270;
        }
        throw new IllegalStateException("Unknown Rotation!");
    }
}
