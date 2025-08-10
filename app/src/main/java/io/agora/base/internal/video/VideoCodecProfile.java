package io.agora.base.internal.video;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public enum VideoCodecProfile {
    HEVCMain10("profile/2"),
    HEVCMain10HDR10("profile/4096"),
    HEVCMain10HDR10Plus("profile/8192"),
    UNKNOWN("profile/0");

    private static Set<String> _values = new HashSet();
    private final String profile;

    static {
        for (VideoCodecProfile videoCodecProfile : values()) {
            _values.add(videoCodecProfile.name());
        }
    }

    VideoCodecProfile(String str) {
        this.profile = str;
    }

    public static boolean contains(String str) {
        return _values.contains(str);
    }

    public int profile() {
        String strSubstring;
        if (this.profile.length() <= 8 || (strSubstring = this.profile.substring(8)) == null) {
            return 0;
        }
        return Integer.parseInt(strSubstring);
    }
}
