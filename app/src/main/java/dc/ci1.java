package dc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: MediaUtil.kt */
/* loaded from: classes3.dex */
public final class ci1 {
    public static boolean a;
    public static final ci1 c = new ci1();
    public static final HashMap<String, Boolean> b = new HashMap<>();

    public final boolean a(@NotNull MediaFormat videoFormat) {
        Intrinsics.checkParameterIsNotNull(videoFormat, "videoFormat");
        String string = videoFormat.getString("mime");
        if (string == null) {
            string = "";
        }
        return StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) "hevc", false, 2, (Object) null);
    }

    public final synchronized boolean b(@NotNull String mimeType) {
        HashMap<String, Boolean> map;
        String lowerCase;
        Intrinsics.checkParameterIsNotNull(mimeType, "mimeType");
        if (!a) {
            a = true;
            d();
        }
        map = b;
        lowerCase = mimeType.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
        return map.containsKey(lowerCase);
    }

    @NotNull
    public final MediaExtractor c(@NotNull ch1 file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        MediaExtractor mediaExtractor = new MediaExtractor();
        file.c(mediaExtractor);
        return mediaExtractor;
    }

    public final void d() {
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
                Intrinsics.checkExpressionValueIsNotNull(codecInfo, "codecInfo");
                if (!codecInfo.isEncoder()) {
                    String[] types = codecInfo.getSupportedTypes();
                    Intrinsics.checkExpressionValueIsNotNull(types, "types");
                    for (String str : types) {
                        HashMap<String, Boolean> map = b;
                        Intrinsics.checkExpressionValueIsNotNull(str, "types[j]");
                        if (str == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase = str.toLowerCase();
                        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                        map.put(lowerCase, Boolean.TRUE);
                    }
                }
            }
            xh1.c.d("AnimPlayer.MediaUtil", "supportType=" + b.keySet());
        } catch (Throwable th) {
            xh1.c.b("AnimPlayer.MediaUtil", "getSupportType " + th);
        }
    }

    public final int e(@NotNull MediaExtractor extractor) {
        Intrinsics.checkParameterIsNotNull(extractor, "extractor");
        int trackCount = extractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = extractor.getTrackFormat(i);
            String string = trackFormat.getString("mime");
            if (string == null) {
                string = "";
            }
            if (StringsKt__StringsJVMKt.startsWith$default(string, "audio/", false, 2, null)) {
                xh1.c.d("AnimPlayer.MediaUtil", "Extractor selected track " + i + " (" + string + "): " + trackFormat);
                return i;
            }
        }
        return -1;
    }

    public final int f(@NotNull MediaExtractor extractor) {
        Intrinsics.checkParameterIsNotNull(extractor, "extractor");
        int trackCount = extractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = extractor.getTrackFormat(i);
            String string = trackFormat.getString("mime");
            if (string == null) {
                string = "";
            }
            if (StringsKt__StringsJVMKt.startsWith$default(string, "video/", false, 2, null)) {
                xh1.c.d("AnimPlayer.MediaUtil", "Extractor selected track " + i + " (" + string + "): " + trackFormat);
                return i;
            }
        }
        return -1;
    }
}
