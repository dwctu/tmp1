package io.agora.rtc2;

/* loaded from: classes4.dex */
public class RecorderStreamInfo {
    public String channelId;
    public int uid;

    public RecorderStreamInfo() {
        this.channelId = null;
        this.uid = 0;
    }

    public RecorderStreamInfo(String str, int i) {
        this.channelId = str;
        this.uid = i;
    }

    public String toString() {
        return "channelId=" + this.channelId + "uid=" + this.uid;
    }
}
