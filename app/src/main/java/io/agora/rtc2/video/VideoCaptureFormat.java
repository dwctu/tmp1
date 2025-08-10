package io.agora.rtc2.video;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import io.agora.base.internal.CalledByNative;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class VideoCaptureFormat {
    public static final String keyFPS = "fps";
    public static final String keyFormat = "format";
    public static final String keyHeight = "height";
    public static final String keyWidth = "width";
    public final int mFramerate;
    public final int mHeight;
    public final int mPixelFormat;
    public final int mWidth;

    @CalledByNative
    public VideoCaptureFormat(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mFramerate = i3;
        this.mPixelFormat = i4;
    }

    public static VideoCaptureFormat fromString(String str) {
        if (str == null || !str.startsWith("{")) {
            return null;
        }
        String[] strArrSplit = str.substring(1, str.length() - 1).split(",");
        HashMap map = new HashMap();
        try {
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("=");
                map.put(strArrSplit2[0].trim(), Integer.valueOf(Integer.parseInt(strArrSplit2[1].trim())));
            }
            return new VideoCaptureFormat(((Integer) map.get(keyWidth)).intValue(), ((Integer) map.get(keyHeight)).intValue(), ((Integer) map.get(keyFPS)).intValue(), ((Integer) map.get(keyFormat)).intValue());
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            return null;
        }
    }

    @CalledByNative
    public int getFramerate() {
        return this.mFramerate;
    }

    @CalledByNative
    public int getHeight() {
        return this.mHeight;
    }

    @CalledByNative
    public int getPixelFormat() {
        return this.mPixelFormat;
    }

    @CalledByNative
    public int getWidth() {
        return this.mWidth;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put(keyWidth, Integer.valueOf(this.mWidth));
        map.put(keyHeight, Integer.valueOf(this.mHeight));
        map.put(keyFPS, Integer.valueOf(this.mFramerate));
        map.put(keyFormat, Integer.valueOf(this.mPixelFormat));
        return map.toString();
    }
}
