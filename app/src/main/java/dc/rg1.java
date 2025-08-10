package dc;

import androidx.core.os.EnvironmentCompat;
import io.agora.rtm2.RtmConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Constant.kt */
/* loaded from: classes3.dex */
public final class rg1 {
    public static final rg1 a = new rg1();

    public static /* synthetic */ String b(rg1 rg1Var, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return rg1Var.a(i, str);
    }

    @NotNull
    public final String a(int i, @Nullable String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        switch (i) {
            case 10001:
                str2 = "0x1 MediaExtractor exception";
                break;
            case RtmConstants.RTM_ERR_EXCEED_JOIN_TOPIC_LIMITATION /* 10002 */:
                str2 = "0x2 MediaCodec exception";
                break;
            case RtmConstants.RTM_ERR_INVALID_TOPIC_NAME /* 10003 */:
                str2 = "0x3 thread create fail";
                break;
            case RtmConstants.RTM_ERR_PUBLISH_TOPIC_MESSAGE_FAILED /* 10004 */:
                str2 = "0x4 render create fail";
                break;
            case RtmConstants.RTM_ERR_EXCEED_SUBSCRIBE_TOPIC_LIMITATION /* 10005 */:
                str2 = "0x5 parse config fail";
                break;
            case RtmConstants.RTM_ERR_EXCEED_USER_LIMITATION /* 10006 */:
                str2 = "0x6 vapx fail";
                break;
            default:
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                break;
        }
        sb.append(str2);
        sb.append(' ');
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
