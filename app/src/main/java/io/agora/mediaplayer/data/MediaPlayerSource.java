package io.agora.mediaplayer.data;

import io.agora.base.internal.CalledByNative;
import io.agora.mediaplayer.IMediaPlayerCustomDataProvider;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class MediaPlayerSource {
    public Boolean isAgoraSource;
    public Boolean isLiveSource;
    public long startPos = 0;
    public boolean enableCache = false;
    public String url = null;
    public String uri = null;
    public boolean autoPlay = true;
    public IMediaPlayerCustomDataProvider provider = null;

    public void enableAgoraSource(boolean z) {
        this.isAgoraSource = Boolean.valueOf(z);
    }

    public void enableLiveSource(boolean z) {
        this.isLiveSource = Boolean.valueOf(z);
    }

    @CalledByNative
    public IMediaPlayerCustomDataProvider getProvider() {
        return this.provider;
    }

    @CalledByNative
    public long getStartPos() {
        return this.startPos;
    }

    @CalledByNative
    public String getUri() {
        return this.uri;
    }

    @CalledByNative
    public String getUrl() {
        return this.url;
    }

    @CalledByNative
    public Boolean isAgoraSource() {
        return this.isAgoraSource;
    }

    @CalledByNative
    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    @CalledByNative
    public boolean isEnableCache() {
        return this.enableCache;
    }

    @CalledByNative
    public Boolean isLiveSource() {
        return this.isLiveSource;
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public void setEnableCache(boolean z) {
        this.enableCache = z;
    }

    public void setProvider(IMediaPlayerCustomDataProvider iMediaPlayerCustomDataProvider) {
        this.provider = iMediaPlayerCustomDataProvider;
    }

    public void setStartPos(long j) {
        this.startPos = j;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaPlayerSource{url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", uri='");
        sb.append(this.uri);
        sb.append('\'');
        sb.append(", startPos=");
        sb.append(this.startPos);
        sb.append(", enableCache=");
        sb.append(this.enableCache);
        sb.append(", autoPlay=");
        sb.append(this.autoPlay);
        sb.append(", isLiveSource=");
        Boolean bool = this.isLiveSource;
        sb.append(bool != null ? Boolean.valueOf(bool.booleanValue()) : null);
        sb.append(", isAgoraSource=");
        Boolean bool2 = this.isAgoraSource;
        sb.append(bool2 != null ? Boolean.valueOf(bool2.booleanValue()) : null);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
