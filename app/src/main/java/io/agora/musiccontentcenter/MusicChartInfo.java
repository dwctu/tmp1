package io.agora.musiccontentcenter;

import io.agora.base.internal.CalledByNative;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class MusicChartInfo {
    public String name;
    public int type;

    public MusicChartInfo() {
    }

    @CalledByNative
    public MusicChartInfo(String str, int i) {
        this.name = str;
        this.type = i;
    }

    @CalledByNative
    public String getName() {
        return this.name;
    }

    @CalledByNative
    public int getType() {
        return this.type;
    }

    public String toString() {
        return "MusicChartInfo{name='" + this.name + "', type=" + this.type + MessageFormatter.DELIM_STOP;
    }
}
