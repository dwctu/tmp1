package com.wear.activity.orgySetting;

import android.text.TextUtils;
import com.spotify.sdk.android.player.Config;

/* loaded from: classes3.dex */
public class OrgyEventTrackUtil {

    public static class AppType {
        public static final String Blog = "14";
        public static final String Connect = "12";
        public static final String Life = "15";
        public static final String Other = "10";
        public static final String Remote = "11";
        public static final String WebSite = "13";
    }

    public static class Location {
        public static final String Banner = "12";
        public static final String FixEntry = "13";
        public static final String Other = "10";
        public static final String StartPage = "11";
    }

    public static String getEventTrack(String str, String str2, String str3) {
        return getEventTrack("11", str, str2, str3);
    }

    public static String getEventTrack(String str, String str2, String str3, String str4) {
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        if (TextUtils.isEmpty(str4)) {
            str5 = "";
        } else {
            str5 = Config.IN_FIELD_SEPARATOR + str4;
        }
        sb.append(str5);
        return sb.toString();
    }
}
