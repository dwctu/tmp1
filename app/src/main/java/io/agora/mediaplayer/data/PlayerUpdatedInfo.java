package io.agora.mediaplayer.data;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class PlayerUpdatedInfo {
    public CacheStatistics cacheStatistics;
    private String deviceId;
    private String playerId;

    public PlayerUpdatedInfo() {
        this.playerId = null;
        this.deviceId = null;
    }

    @CalledByNative
    public PlayerUpdatedInfo(String str, String str2, CacheStatistics cacheStatistics) {
        this.playerId = str;
        this.deviceId = str2;
        this.cacheStatistics = cacheStatistics;
    }

    @CalledByNative
    public CacheStatistics getCacheStatistics() {
        return this.cacheStatistics;
    }

    @CalledByNative
    public String getDeviceId() {
        return this.deviceId;
    }

    @CalledByNative
    public String getPlayerId() {
        return this.playerId;
    }

    @CalledByNative
    public void setCacheStatistics(CacheStatistics cacheStatistics) {
        this.cacheStatistics = cacheStatistics;
    }

    @CalledByNative
    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    @CalledByNative
    public void setPlayerId(String str) {
        this.playerId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("playerId=");
        sb.append(this.playerId);
        sb.append(" deviceId=");
        sb.append(this.deviceId);
        if (this.cacheStatistics != null) {
            sb.append(" cacheStatistics=");
            sb.append(this.cacheStatistics.toString());
        }
        return sb.toString();
    }
}
