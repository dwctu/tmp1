package io.microshow.rxffmpeg;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class RxFFmpegCommandSupport {
    public static String[] getBoxblur(String str, String str2, String str3, boolean z) {
        RxFFmpegCommandList rxFFmpegCommandList = new RxFFmpegCommandList();
        rxFFmpegCommandList.append("-i");
        rxFFmpegCommandList.append(str);
        rxFFmpegCommandList.append("-vf");
        StringBuilder sb = new StringBuilder();
        sb.append("boxblur=");
        if (TextUtils.isEmpty(str3)) {
            str3 = "5:1";
        }
        sb.append(str3);
        rxFFmpegCommandList.append(sb.toString());
        rxFFmpegCommandList.append("-preset");
        rxFFmpegCommandList.append("superfast");
        rxFFmpegCommandList.append(str2);
        return rxFFmpegCommandList.build(z);
    }
}
