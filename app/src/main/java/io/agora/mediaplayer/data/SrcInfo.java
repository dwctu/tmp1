package io.agora.mediaplayer.data;

import io.agora.base.internal.CalledByNative;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class SrcInfo {
    private int bitrateInKbps;
    private String name;

    public SrcInfo() {
    }

    @CalledByNative
    public SrcInfo(int i, String str) {
        this.bitrateInKbps = i;
        this.name = str;
    }

    @CalledByNative
    public int getBitrateInKbps() {
        return this.bitrateInKbps;
    }

    @CalledByNative
    public String getName() {
        return this.name;
    }

    public void setBitrateInKbps(int i) {
        this.bitrateInKbps = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "SrcInfo{bitrateInKbps=" + this.bitrateInKbps + ", name=" + this.name + MessageFormatter.DELIM_STOP;
    }
}
