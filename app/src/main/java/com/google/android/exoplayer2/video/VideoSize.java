package com.google.android.exoplayer2.video;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public final class VideoSize implements Bundleable {
    private static final int DEFAULT_HEIGHT = 0;
    private static final float DEFAULT_PIXEL_WIDTH_HEIGHT_RATIO = 1.0f;
    private static final int DEFAULT_UNAPPLIED_ROTATION_DEGREES = 0;
    private static final int DEFAULT_WIDTH = 0;
    private static final int FIELD_HEIGHT = 1;
    private static final int FIELD_PIXEL_WIDTH_HEIGHT_RATIO = 3;
    private static final int FIELD_UNAPPLIED_ROTATION_DEGREES = 2;
    private static final int FIELD_WIDTH = 0;

    @IntRange(from = 0)
    public final int height;

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, fromInclusive = false)
    public final float pixelWidthHeightRatio;

    @IntRange(from = 0, to = 359)
    public final int unappliedRotationDegrees;

    @IntRange(from = 0)
    public final int width;
    public static final VideoSize UNKNOWN = new VideoSize(0, 0);
    public static final Bundleable.Creator<VideoSize> CREATOR = new Bundleable.Creator() { // from class: dc.fz0
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return VideoSize.a(bundle);
        }
    };

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this(i, i2, 0, 1.0f);
    }

    public static /* synthetic */ VideoSize a(Bundle bundle) {
        return new VideoSize(bundle.getInt(keyForField(0), 0), bundle.getInt(keyForField(1), 0), bundle.getInt(keyForField(2), 0), bundle.getFloat(keyForField(3), 1.0f));
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        return this.width == videoSize.width && this.height == videoSize.height && this.unappliedRotationDegrees == videoSize.unappliedRotationDegrees && this.pixelWidthHeightRatio == videoSize.pixelWidthHeightRatio;
    }

    public int hashCode() {
        return ((((((217 + this.width) * 31) + this.height) * 31) + this.unappliedRotationDegrees) * 31) + Float.floatToRawIntBits(this.pixelWidthHeightRatio);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(0), this.width);
        bundle.putInt(keyForField(1), this.height);
        bundle.putInt(keyForField(2), this.unappliedRotationDegrees);
        bundle.putFloat(keyForField(3), this.pixelWidthHeightRatio);
        return bundle;
    }

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, to = 359) int i3, @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, fromInclusive = false) float f) {
        this.width = i;
        this.height = i2;
        this.unappliedRotationDegrees = i3;
        this.pixelWidthHeightRatio = f;
    }
}
